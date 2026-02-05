package gui;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUIRegistroCitas extends JFrame { // O JInternalFrame si usas DesktopPane

    private JPanel contentPane;
    private JTextField txtNumeroCita;
    private JTextField txtPacienteCod;
    private JTextField txtMedicoCod;
    private JTextField txtConsultorioCod;
    private JTextField txtFecha;
    private JTextField txtHora;
    private JTable tableCitas;
    private DefaultTableModel model;
    private JComboBox<String> cmbEstado;

    // Simulación de estados para que el código sea legible
    private final int ESTADO_PENDIENTE = 0;
    private final int ESTADO_ATENDIDO = 1;
    private final int ESTADO_HISTORIAL = 2; // Cancelado

    public GUIRegistroCitas() {
        setTitle("Gestión de Citas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 650, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // --- CAMPOS ---
        setupCampos(); // Método auxiliar para no llenar el constructor de código visual
        
        // --- BOTONES ---
        JButton btnAdicionar = new JButton("Adicionar");
        btnAdicionar.setBounds(450, 20, 150, 23);
        contentPane.add(btnAdicionar);

        JButton btnModificar = new JButton("Reprogramar");
        btnModificar.setBounds(450, 50, 150, 23);
        contentPane.add(btnModificar);

        JButton btnCancelar = new JButton("Cancelar Cita");
        btnCancelar.setBounds(450, 80, 150, 23);
        contentPane.add(btnCancelar);
        
        JButton btnGrabar = new JButton("Grabar BD");
        btnGrabar.setBounds(450, 110, 150, 23);
        contentPane.add(btnGrabar);

        // --- TABLA ---
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(20, 160, 580, 280);
        contentPane.add(scrollPane);

        tableCitas = new JTable();
        model = new DefaultTableModel(
            new Object[][] {},
            new String[] {"Nro", "Paciente", "Médico", "Consul.", "Fecha", "Hora", "Estado"}
        );
        tableCitas.setModel(model);
        scrollPane.setViewportView(tableCitas);

        // =======================================================
        // LÓGICA DE EVENTOS (Aquí está la "magia" que te piden)
        // =======================================================

        // 1. EVENTO ADICIONAR
        btnAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // A. Generar Correlativo
                generarCorrelativo();
                
                // B. Capturar datos
                String medico = txtMedicoCod.getText();
                String fecha = txtFecha.getText();
                String hora = txtHora.getText();
                String consultorio = txtConsultorioCod.getText();

                // C. Validar Disponibilidad (Crucial)
                if (validarDisponibilidad(medico, fecha, hora, consultorio)) {
                    // Si todo está libre:
                    agregarFilaTabla(ESTADO_PENDIENTE); // Estado 0
                    limpiarCampos();
                    JOptionPane.showMessageDialog(null, "Cita Registrada con éxito.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error: Médico o Consultorio ocupado en ese horario.", "Cruce de Horarios", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // 2. EVENTO SELECCIONAR FILA (Para consultar/modificar)
        tableCitas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = tableCitas.getSelectedRow();
                if (fila >= 0) {
                    txtNumeroCita.setText(model.getValueAt(fila, 0).toString());
                    txtPacienteCod.setText(model.getValueAt(fila, 1).toString());
                    txtMedicoCod.setText(model.getValueAt(fila, 2).toString());
                    txtConsultorioCod.setText(model.getValueAt(fila, 3).toString());
                    txtFecha.setText(model.getValueAt(fila, 4).toString());
                    txtHora.setText(model.getValueAt(fila, 5).toString());
                    // Seleccionar combo según estado (texto a índice)
                    // ... lógica para setear combo
                }
            }
        });

        // 3. EVENTO CANCELAR (Pasar a Historial)
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int fila = tableCitas.getSelectedRow();
                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "Seleccione una cita para cancelar.");
                    return;
                }
                
                // Cambiar visualmente y en lógica
                model.setValueAt("Cancelado (Historial)", fila, 6); 
                // Aquí deberías actualizar tu ArrayList o BD seteando estado = 2
                JOptionPane.showMessageDialog(null, "Cita cancelada y movida a historial.");
            }
        });
        
        // 4. EVENTO REPROGRAMAR (Modificar)
        btnModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Similar a adicionar, pero valida disponibilidad excluyendo la cita actual
                // y actualiza la fila seleccionada.
            }
        });
    }

    // =======================================================
    // MÉTODOS DE AYUDA (LOGICA DE NEGOCIO)
    // =======================================================

    private void generarCorrelativo() {
        // Lógica: Leer el último ID de tu lista/BD y sumar 1
        // Ejemplo:
        // int nuevoId = listaCitas.size() + 1;
        // txtNumeroCita.setText("C" + nuevoId);
        txtNumeroCita.setText("C0001"); // Dummy
    }

    /**
     * Esta es la validación más importante que te piden.
     * Retorna TRUE si se puede agendar, FALSE si hay choque.
     */
    private boolean validarDisponibilidad(String codMedico, String fecha, String hora, String codConsultorio) {
        // 1. Recorrer tu arreglo/BD de citas existentes.
        // 2. IF (cita.getFecha() == fecha AND cita.getHora() == hora)
        // 3.    IF (cita.getMedico() == codMedico) -> Retorna FALSE (Médico ocupado)
        // 4.    IF (cita.getConsultorio() == codConsultorio) -> Retorna FALSE (Sala ocupada)
        
        // Simulación:
        if (hora.equals("10:00") && codMedico.equals("M001")) {
            return false; // Ejemplo de choque
        }
        return true;
    }

    private void agregarFilaTabla(int estadoCodigo) {
        String estadoTexto = "";
        if(estadoCodigo == 0) estadoTexto = "Pendiente";
        else if(estadoCodigo == 2) estadoTexto = "Historial";

        model.addRow(new Object[]{
            txtNumeroCita.getText(),
            txtPacienteCod.getText(),
            txtMedicoCod.getText(),
            txtConsultorioCod.getText(),
            txtFecha.getText(),
            txtHora.getText(),
            estadoTexto
        });
    }

    private void limpiarCampos() {
        txtPacienteCod.setText("");
        txtMedicoCod.setText("");
        txtConsultorioCod.setText("");
        txtFecha.setText("");
        txtHora.setText("");
        txtPacienteCod.requestFocus();
    }
    
    // Configuración visual aburrida movida aquí para limpieza
    private void setupCampos() {
        JLabel lblNro = new JLabel("Nro Cita:"); lblNro.setBounds(20, 20, 60, 14); contentPane.add(lblNro);
        txtNumeroCita = new JTextField(); txtNumeroCita.setEditable(false); txtNumeroCita.setBounds(80, 17, 80, 20); contentPane.add(txtNumeroCita);
        
        JLabel lblPac = new JLabel("Paciente:"); lblPac.setBounds(20, 50, 60, 14); contentPane.add(lblPac);
        txtPacienteCod = new JTextField(); txtPacienteCod.setBounds(80, 47, 120, 20); contentPane.add(txtPacienteCod);
        
        JLabel lblMed = new JLabel("Médico:"); lblMed.setBounds(220, 50, 50, 14); contentPane.add(lblMed);
        txtMedicoCod = new JTextField(); txtMedicoCod.setBounds(270, 47, 120, 20); contentPane.add(txtMedicoCod);
        
        JLabel lblCons = new JLabel("Consultorio:"); lblCons.setBounds(20, 80, 70, 14); contentPane.add(lblCons);
        txtConsultorioCod = new JTextField(); txtConsultorioCod.setBounds(90, 77, 110, 20); contentPane.add(txtConsultorioCod);
        
        JLabel lblFec = new JLabel("Fecha:"); lblFec.setBounds(20, 110, 50, 14); contentPane.add(lblFec);
        txtFecha = new JTextField(); txtFecha.setBounds(80, 107, 90, 20); contentPane.add(txtFecha);
        
        JLabel lblHora = new JLabel("Hora:"); lblHora.setBounds(190, 110, 50, 14); contentPane.add(lblHora);
        txtHora = new JTextField(); txtHora.setBounds(230, 107, 60, 20); contentPane.add(txtHora);
        
        JLabel lblEst = new JLabel("Estado:"); lblEst.setBounds(220, 20, 50, 14); contentPane.add(lblEst);
        cmbEstado = new JComboBox<>(new String[]{"Pendiente", "Atendido", "Historial"});
        cmbEstado.setBounds(270, 17, 100, 22); cmbEstado.setEnabled(false); contentPane.add(cmbEstado);
    }
}