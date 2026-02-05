package model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reportes extends JFrame {
    private static final long serialVersionUID = 1L;

    private ArrayList<Paciente> pacientes = new ArrayList<>();
    private ArrayList<Medico> medicos = new ArrayList<>();
    private ArrayList<Consultorio> consultorios = new ArrayList<>();
    private ArrayList<Cita> citas = new ArrayList<>();

    private JComboBox<String> cbPacientes;
    private JComboBox<String> cbMedicos;
    private JComboBox<String> cbConsultorios;
    private JTextField tfFecha;
    private JTextField tfEspecialidad;
    private JTextArea taSalida;

    private final String basePath = "src/s/"; // text files will live here

    public Reportes() {
        setTitle("Módulo de Reportes");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel p = new JPanel(new BorderLayout(8, 8));
        setContentPane(p);

        // Top controls
        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnRefrescar = new JButton("Cargar datos");
        btnRefrescar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadAll();
                JOptionPane.showMessageDialog(Reportes.this, "Datos cargados.", "Info", JOptionPane.INFORMATION_MESSAGE);
                refreshCombos();
            }
        });
        top.add(btnRefrescar);

        JButton btnCrearEjemplo = new JButton("Crear datos de ejemplo");
        btnCrearEjemplo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    createSampleFiles();
                    loadAll();
                    refreshCombos();
                    JOptionPane.showMessageDialog(Reportes.this, "Archivos de ejemplo creados en '" + basePath + "'.", "Info", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(Reportes.this, "Error creando archivos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        top.add(btnCrearEjemplo);

        top.add(new JLabel("Fecha (YYYY-MM-DD):"));
        tfFecha = new JTextField(10);
        top.add(tfFecha);

        top.add(new JLabel("Especialidad (opcional):"));
        tfEspecialidad = new JTextField(10);
        top.add(tfEspecialidad);

        p.add(top, BorderLayout.NORTH);

        // Center text area
        taSalida = new JTextArea();
        taSalida.setEditable(false);
        taSalida.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        JScrollPane sp = new JScrollPane(taSalida);
        p.add(sp, BorderLayout.CENTER);

        // Left controls for selecting entities and report buttons
        JPanel left = new JPanel();
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        left.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        left.add(new JLabel("Pacientes:"));
        cbPacientes = new JComboBox<>();
        left.add(cbPacientes);
        JButton btnRepPaciente = new JButton("Reporte por Paciente");
        btnRepPaciente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reportePorPaciente();
            }
        });
        left.add(btnRepPaciente);

        left.add(Box.createVerticalStrut(8));
        left.add(new JLabel("Médicos:"));
        cbMedicos = new JComboBox<>();
        left.add(cbMedicos);
        JButton btnRepMedico = new JButton("Reporte por Médico");
        btnRepMedico.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reportePorMedico();
            }
        });
        left.add(btnRepMedico);

        left.add(Box.createVerticalStrut(8));
        left.add(new JLabel("Consultorios:"));
        cbConsultorios = new JComboBox<>();
        left.add(cbConsultorios);
        JButton btnRepConsultorio = new JButton("Reporte por Consultorio");
        btnRepConsultorio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reportePorConsultorio();
            }
        });
        left.add(btnRepConsultorio);

        left.add(Box.createVerticalStrut(8));
        JButton btnRepFecha = new JButton("Reporte por Fecha");
        btnRepFecha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reportePorFecha();
            }
        });
        left.add(btnRepFecha);

        left.add(Box.createVerticalStrut(8));
        JButton btnRepPendientes = new JButton("Pacientes con citas pendientes");
        btnRepPendientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reportePendientes();
            }
        });
        left.add(btnRepPendientes);

        left.add(Box.createVerticalStrut(8));
        JButton btnRepCitasPorMedico = new JButton("Citas por médico (totales/por estado)");
        btnRepCitasPorMedico.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reporteCitasPorMedico();
            }
        });
        left.add(btnRepCitasPorMedico);

        left.add(Box.createVerticalStrut(8));
        JButton btnRepCitasPorConsultorio = new JButton("Citas por consultorio (ocupación por día)");
        btnRepCitasPorConsultorio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reporteCitasPorConsultorio();
            }
        });
        left.add(btnRepCitasPorConsultorio);

        left.add(Box.createVerticalStrut(8));
        JButton btnAgendaDia = new JButton("Agenda del día (por fecha)");
        btnAgendaDia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reporteAgendaDelDia();
            }
        });
        left.add(btnAgendaDia);

        p.add(left, BorderLayout.WEST);

        // initial load
        loadAll();
        refreshCombos();
    }

    private void loadAll() {
        pacientes.clear();
        medicos.clear();
        consultorios.clear();
        citas.clear();

        loadPacientes();
        loadMedicos();
        loadConsultorios();
        loadCitas();
    }

    private void refreshCombos() {
        cbPacientes.removeAllItems();
        for (Paciente pa : pacientes) {
            if (pa.getEstado() == 1) // only active
                cbPacientes.addItem(pa.getCodPaciente() + " - " + pa.getNombres() + " " + pa.getApellidos());
        }
        cbMedicos.removeAllItems();
        for (Medico m : medicos) {
            if (m.getEstado() == 1)
                cbMedicos.addItem(m.getCodMedico() + " - " + m.getNombres() + " " + m.getApellidos() + " (" + m.getEspecialidad() + ")");
        }
        cbConsultorios.removeAllItems();
        for (Consultorio c : consultorios) {
            if (c.getEstado() == 1)
                cbConsultorios.addItem(c.getCodConsultorio() + " - " + c.getNombre());
        }
    }

    private void loadPacientes() {
        File f = new File(basePath + "pacientes.txt");
        if (!f.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                String[] a = line.split("\\t|\\|");
                // support both tab and pipe separators
                if (a.length < 8) continue;
                try {
                    Paciente p = new Paciente(Integer.parseInt(a[0]), a[1], a[2], a[3], Integer.parseInt(a[4]), a[5], a[6], Integer.parseInt(a[7]));
                    pacientes.add(p);
                } catch (Exception ex) {
                    // skip malformed
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error leyendo pacientes: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadMedicos() {
        File f = new File(basePath + "medicos.txt");
        if (!f.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                String[] a = line.split("\\t|\\|");
                if (a.length < 6) continue;
                try {
                    Medico m = new Medico(Integer.parseInt(a[0]), a[1], a[2], a[3], a[4], Integer.parseInt(a[5]));
                    medicos.add(m);
                } catch (Exception ex) {
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error leyendo medicos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadConsultorios() {
        File f = new File(basePath + "consultorios.txt");
        if (!f.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                String[] a = line.split("\\t|\\|");
                if (a.length < 6) continue;
                try {
                    Consultorio c = new Consultorio(Integer.parseInt(a[0]), a[1], Integer.parseInt(a[2]), a[3], Integer.parseInt(a[4]), Integer.parseInt(a[5]));
                    consultorios.add(c);
                } catch (Exception ex) {
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error leyendo consultorios: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadCitas() {
        File f = new File(basePath + "citas.txt");
        if (!f.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                String[] a = line.split("\\t|\\|");
                if (a.length < 8) continue;
                try {
                    Cita c = new Cita(Integer.parseInt(a[0]), Integer.parseInt(a[1]), Integer.parseInt(a[2]), Integer.parseInt(a[3]), a[4], a[5], Integer.parseInt(a[6]), a[7]);
                    citas.add(c);
                } catch (Exception ex) {
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error leyendo citas: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Helper lookups
    private Paciente findPaciente(int id) {
        for (Paciente p : pacientes) if (p.getCodPaciente() == id) return p;
        return null;
    }

    private Medico findMedico(int id) {
        for (Medico m : medicos) if (m.getCodMedico() == id) return m;
        return null;
    }

    private Consultorio findConsultorio(int id) {
        for (Consultorio c : consultorios) if (c.getCodConsultorio() == id) return c;
        return null;
    }

    private String estadoTexto(int estado) {
        switch (estado) {
            case 1: return "PENDIENTE";
            case 2: return "ATENDIDA";
            case 3: return "CANCELADA";
            default: return "DESCONOCIDO("+estado+")";
        }
    }

    private void reportePorPaciente() {
        if (cbPacientes.getItemCount() == 0) { JOptionPane.showMessageDialog(this, "No hay pacientes activos cargados.", "Info", JOptionPane.INFORMATION_MESSAGE); return; }
        String sel = (String) cbPacientes.getSelectedItem();
        int id = Integer.parseInt(sel.split(" - ")[0]);
        Paciente p = findPaciente(id);
        if (p == null) return;
        StringBuilder sb = new StringBuilder();
        sb.append("Reporte de citas del paciente: \n");
        sb.append(p.getNombres()+" "+p.getApellidos()+" (DNI: "+p.getDni()+")\n\n");
        for (Cita c : citas) {
            if (c.getCodPaciente() == id) {
                // only show if related entities are active
                Medico m = findMedico(c.getCodMedico());
                Consultorio co = findConsultorio(c.getCodConsultorio());
                if (m==null || co==null) continue;
                if (m.getEstado()!=1 || co.getEstado()!=1) continue;
                sb.append(String.format("Cita %d - %s %s | Fecha: %s %s | Médico: %s %s | Consultorio: %s | Estado: %s\n",
                        c.getNumCita(), c.getFecha(), c.getHora(), c.getFecha(), c.getHora(), m.getNombres(), m.getApellidos(), co.getNombre(), estadoTexto(c.getEstado())));
            }
        }
        taSalida.setText(sb.toString());
    }

    private void reportePorMedico() {
        if (cbMedicos.getItemCount() == 0) { JOptionPane.showMessageDialog(this, "No hay médicos activos.", "Info", JOptionPane.INFORMATION_MESSAGE); return; }
        String sel = (String) cbMedicos.getSelectedItem();
        int id = Integer.parseInt(sel.split(" - ")[0]);
        Medico m = findMedico(id);
        if (m == null) return;
        String filEsp = tfEspecialidad.getText().trim();
        if (!filEsp.isEmpty() && !m.getEspecialidad().equalsIgnoreCase(filEsp)) {
            JOptionPane.showMessageDialog(this, "El médico seleccionado no coincide con la especialidad filtrada.", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        String fechaFiltro = tfFecha.getText().trim();
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Agenda del médico %s %s (Especialidad: %s)\n\n", m.getNombres(), m.getApellidos(), m.getEspecialidad()));
        for (Cita c : citas) {
            if (c.getCodMedico() == id) {
                if (!fechaFiltro.isEmpty() && !c.getFecha().equals(fechaFiltro)) continue;
                Paciente p = findPaciente(c.getCodPaciente());
                Consultorio co = findConsultorio(c.getCodConsultorio());
                if (p==null || co==null) continue;
                if (p.getEstado()!=1 || co.getEstado()!=1) continue;
                sb.append(String.format("Cita %d | Fecha: %s %s | Paciente: %s %s | Consultorio: %s | Estado: %s\n",
                        c.getNumCita(), c.getFecha(), c.getHora(), p.getNombres(), p.getApellidos(), co.getNombre(), estadoTexto(c.getEstado())));
            }
        }
        taSalida.setText(sb.toString());
    }

    private void reportePorConsultorio() {
        if (cbConsultorios.getItemCount() == 0) { JOptionPane.showMessageDialog(this, "No hay consultorios activos.", "Info", JOptionPane.INFORMATION_MESSAGE); return; }
        String sel = (String) cbConsultorios.getSelectedItem();
        int id = Integer.parseInt(sel.split(" - ")[0]);
        Consultorio c = findConsultorio(id);
        if (c == null) return;
        String fechaFiltro = tfFecha.getText().trim();
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Ocupación del consultorio %s (capacidad %d)\n\n", c.getNombre(), c.getCapacidad()));
        Map<String, List<Cita>> porDia = new HashMap<>();
        for (Cita ci : citas) {
            if (ci.getCodConsultorio() == id) {
                if (!porDia.containsKey(ci.getFecha())) porDia.put(ci.getFecha(), new ArrayList<>());
                porDia.get(ci.getFecha()).add(ci);
            }
        }
        if (!fechaFiltro.isEmpty()) {
            List<Cita> lista = porDia.get(fechaFiltro);
            if (lista == null || lista.isEmpty()) sb.append("No hay citas en la fecha solicitada.\n");
            else {
                sb.append("Fecha: " + fechaFiltro + "\n");
                for (Cita ci : lista) {
                    Paciente p = findPaciente(ci.getCodPaciente());
                    Medico me = findMedico(ci.getCodMedico());
                    if (p==null || me==null) continue;
                    if (p.getEstado()!=1 || me.getEstado()!=1) continue;
                    sb.append(String.format("Cita %d | Hora: %s | Paciente: %s %s | Médico: %s %s | Estado: %s\n",
                            ci.getNumCita(), ci.getHora(), p.getNombres(), p.getApellidos(), me.getNombres(), me.getApellidos(), estadoTexto(ci.getEstado())));
                }
                sb.append(String.format("\nTotal citas: %d | Disponibilidad aparente: %d\n", lista.size(), Math.max(0, c.getCapacidad() - lista.size())));
            }
        } else {
            for (String fecha : porDia.keySet()) {
                List<Cita> lista = porDia.get(fecha);
                sb.append(String.format("%s -> %d citas\n", fecha, lista.size()));
            }
        }
        taSalida.setText(sb.toString());
    }

    private void reportePorFecha() {
        String fecha = tfFecha.getText().trim();
        if (fecha.isEmpty()) { JOptionPane.showMessageDialog(this, "Ingrese una fecha en el campo superior.", "Info", JOptionPane.INFORMATION_MESSAGE); return; }
        StringBuilder sb = new StringBuilder();
        int total = 0;
        sb.append("Citas en fecha " + fecha + "\n\n");
        for (Cita c : citas) {
            if (c.getFecha().equals(fecha)) {
                Paciente p = findPaciente(c.getCodPaciente());
                Medico m = findMedico(c.getCodMedico());
                Consultorio co = findConsultorio(c.getCodConsultorio());
                if (p==null || m==null || co==null) continue;
                if (p.getEstado()!=1 || m.getEstado()!=1 || co.getEstado()!=1) continue;
                sb.append(String.format("Cita %d | Hora: %s | Paciente: %s %s | Médico: %s %s | Consultorio: %s | Estado: %s\n",
                        c.getNumCita(), c.getHora(), p.getNombres(), p.getApellidos(), m.getNombres(), m.getApellidos(), co.getNombre(), estadoTexto(c.getEstado())));
                total++;
            }
        }
        sb.append(String.format("\nTotal de citas: %d\n", total));
        taSalida.setText(sb.toString());
    }

    private void reportePendientes() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pacientes con citas pendientes:\n\n");
        Map<Integer, List<Cita>> map = new HashMap<>();
        for (Cita c : citas) {
            if (c.getEstado() == 1) { // pendiente
                Paciente p = findPaciente(c.getCodPaciente());
                Medico m = findMedico(c.getCodMedico());
                Consultorio co = findConsultorio(c.getCodConsultorio());
                if (p==null || m==null || co==null) continue;
                if (p.getEstado()!=1 || m.getEstado()!=1 || co.getEstado()!=1) continue;
                if (!map.containsKey(p.getCodPaciente())) map.put(p.getCodPaciente(), new ArrayList<>());
                // avoid duplicates: ensure not adding same cita multiple times
                map.get(p.getCodPaciente()).add(c);
            }
        }
        for (Integer id : map.keySet()) {
            Paciente p = findPaciente(id);
            sb.append(String.format("%s %s (DNI: %s) -> %d citas pendientes\n", p.getNombres(), p.getApellidos(), p.getDni(), map.get(id).size()));
        }
        taSalida.setText(sb.toString());
    }

    private void reporteCitasPorMedico() {
        StringBuilder sb = new StringBuilder();
        sb.append("Citas por médico (totales y por estado):\n\n");
        for (Medico m : medicos) {
            if (m.getEstado()!=1) continue;
            int total = 0; int pendientes = 0; int atendidas = 0; int canceladas = 0;
            for (Cita c : citas) {
                if (c.getCodMedico() == m.getCodMedico()) {
                    Paciente p = findPaciente(c.getCodPaciente());
                    Consultorio co = findConsultorio(c.getCodConsultorio());
                    if (p==null || co==null) continue;
                    if (p.getEstado()!=1 || co.getEstado()!=1) continue;
                    total++;
                    switch (c.getEstado()) { case 1: pendientes++; break; case 2: atendidas++; break; case 3: canceladas++; break; }
                }
            }
            sb.append(String.format("%s %s (Esp: %s) -> Total: %d | Pend: %d | Atend: %d | Canc: %d\n",
                    m.getNombres(), m.getApellidos(), m.getEspecialidad(), total, pendientes, atendidas, canceladas));
        }
        taSalida.setText(sb.toString());
    }

    private void reporteCitasPorConsultorio() {
        StringBuilder sb = new StringBuilder();
        sb.append("Citas por consultorio (ocupación por día):\n\n");
        for (Consultorio co : consultorios) {
            if (co.getEstado()!=1) continue;
            Map<String, Integer> porDia = new HashMap<>();
            for (Cita c : citas) {
                if (c.getCodConsultorio() == co.getCodConsultorio()) {
                    Paciente p = findPaciente(c.getCodPaciente());
                    Medico m = findMedico(c.getCodMedico());
                    if (p==null || m==null) continue;
                    if (p.getEstado()!=1 || m.getEstado()!=1) continue;
                    porDia.put(c.getFecha(), porDia.getOrDefault(c.getFecha(), 0) + 1);
                }
            }
            sb.append(co.getNombre() + " ->\n");
            for (String fecha : porDia.keySet()) {
                sb.append(String.format("  %s : %d citas (capacidad %d)\n", fecha, porDia.get(fecha), co.getCapacidad()));
            }
            sb.append("\n");
        }
        taSalida.setText(sb.toString());
    }

    private void reporteAgendaDelDia() {
        String fecha = tfFecha.getText().trim();
        if (fecha.isEmpty()) { JOptionPane.showMessageDialog(this, "Ingrese una fecha en el campo superior.", "Info", JOptionPane.INFORMATION_MESSAGE); return; }
        StringBuilder sb = new StringBuilder();
        sb.append("Agenda del día: " + fecha + "\n\n");
        for (Cita c : citas) {
            if (c.getFecha().equals(fecha)) {
                Paciente p = findPaciente(c.getCodPaciente());
                Medico m = findMedico(c.getCodMedico());
                Consultorio co = findConsultorio(c.getCodConsultorio());
                if (p==null || m==null || co==null) continue;
                if (p.getEstado()!=1 || m.getEstado()!=1 || co.getEstado()!=1) continue;
                sb.append(String.format("%s | %s %s | Médico: %s %s | Consultorio: %s | Estado: %s\n",
                        c.getHora(), p.getNombres(), p.getApellidos(), m.getNombres(), m.getApellidos(), co.getNombre(), estadoTexto(c.getEstado())));
            }
        }
        taSalida.setText(sb.toString());
    }

    // create sample files with test data
    private void createSampleFiles() throws IOException {
        File dir = new File(basePath);
        if (!dir.exists()) dir.mkdirs();

        try (PrintWriter pw = new PrintWriter(new FileWriter(new File(dir, "pacientes.txt")))) {
            pw.println("1|Juan|Perez|12345678|30|987654321|juan@ejemplo.com|1");
            pw.println("2|Ana|Gomez|87654321|25|987651234|ana@ejemplo.com|1");
            pw.println("3|Carlos|Lopez|11223344|40|987600000|carlos@ejemplo.com|0");
        }
        try (PrintWriter pw = new PrintWriter(new FileWriter(new File(dir, "medicos.txt")))) {
            pw.println("1|Luis|Diaz|Cardiologia|CMP001|1");
            pw.println("2|Marta|Ruiz|Pediatria|CMP002|1");
            pw.println("3|Ricardo|Soto|Dermatologia|CMP003|0");
        }
        try (PrintWriter pw = new PrintWriter(new FileWriter(new File(dir, "consultorios.txt")))) {
            pw.println("1|Consultorio A|1|Primer piso|5|1");
            pw.println("2|Consultorio B|2|Segundo piso|3|1");
            pw.println("3|Consultorio C|3|Tercer piso|2|0");
        }
        try (PrintWriter pw = new PrintWriter(new FileWriter(new File(dir, "citas.txt")))) {
            pw.println("1|1|1|1|2026-02-01|09:00|1|Control de presión");
            pw.println("2|2|2|2|2026-02-01|10:00|1|Fiebre");
            pw.println("3|1|2|1|2026-02-02|11:00|2|Revisión");
            pw.println("4|2|1|2|2026-02-02|12:00|3|Cancelada por paciente");
            pw.println("5|3|1|1|2026-02-03|09:30|1|Consulta general");
        }
    }
}
