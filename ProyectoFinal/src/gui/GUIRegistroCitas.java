package gui;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;

public class GUIRegistroCitas extends JFrame {

    private JPanel contentPane;
    
    private JPanel panelSuperior;
    private JPanel panelInferior;

    private JTextField txtNumeroCita;
    private JTextField txtPacienteCod;
    private JTextField txtMedicoCod;
    private JTextField txtConsultorioCod;
    private JTextField txtFecha;
    private JTextField txtHora;
    private JComboBox<String> cmbEstado;
    
    private JButton btnAdicionar;
    private JButton btnModificar;
    private JButton btnCancelar;
    private JButton btnGrabar;

    private JTable tableCitas;
    private DefaultTableModel model;
    
    private final int ESTADO_PENDIENTE = 0;
    
    /**
     * Create the frame.
     */
    public GUIRegistroCitas() {
        setTitle("Gestión de Citas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 800, 600); 
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        panelSuperior = new JPanel();
        panelSuperior.setBounds(0, 0, 786, 220); 
        panelSuperior.setBackground(new Color(51, 153, 255));
        contentPane.add(panelSuperior);
        panelSuperior.setLayout(null);
        
        JLabel lblTitulo = new JLabel("GESTIÓN DE CITAS Y PROGRAMACIÓN");
        lblTitulo.setBounds(0, 11, 786, 30);
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        panelSuperior.add(lblTitulo);

        JLabel lblNro = new JLabel("Nro Cita:"); 
        lblNro.setBounds(39, 71, 60, 14);
        lblNro.setForeground(Color.WHITE); // Texto blanco
        lblNro.setFont(new Font("Tahoma", Font.BOLD, 11));
        panelSuperior.add(lblNro);
        
        txtNumeroCita = new JTextField(); 
        txtNumeroCita.setBounds(99, 68, 100, 22);
        txtNumeroCita.setEditable(false);
        panelSuperior.add(txtNumeroCita);
        
        JLabel lblEst = new JLabel("Estado:"); 
        lblEst.setBounds(229, 71, 50, 14);
        lblEst.setForeground(Color.WHITE);
        lblEst.setFont(new Font("Tahoma", Font.BOLD, 11));
        panelSuperior.add(lblEst);
        
        cmbEstado = new JComboBox<>(new String[]{"Pendiente", "Atendido", "Historial"});
        cmbEstado.setBounds(279, 68, 120, 22);
        cmbEstado.setEnabled(false); 
        panelSuperior.add(cmbEstado);

        JLabel lblPac = new JLabel("Paciente:"); 
        lblPac.setBounds(39, 106, 60, 14);
        lblPac.setForeground(Color.WHITE);
        lblPac.setFont(new Font("Tahoma", Font.BOLD, 11));
        panelSuperior.add(lblPac);
        
        txtPacienteCod = new JTextField();
        txtPacienteCod.setBounds(99, 103, 300, 22);
        panelSuperior.add(txtPacienteCod);
        
        JLabel lblMed = new JLabel("Médico:"); 
        lblMed.setBounds(39, 139, 50, 14);
        lblMed.setForeground(Color.WHITE);
        lblMed.setFont(new Font("Tahoma", Font.BOLD, 11));
        panelSuperior.add(lblMed);
        
        txtMedicoCod = new JTextField();
        txtMedicoCod.setBounds(99, 136, 300, 22);
        panelSuperior.add(txtMedicoCod);

        JLabel lblCons = new JLabel("Consul.:"); 
        lblCons.setBounds(39, 169, 70, 14);
        lblCons.setForeground(Color.WHITE);
        lblCons.setFont(new Font("Tahoma", Font.BOLD, 11));
        panelSuperior.add(lblCons);
        
        txtConsultorioCod = new JTextField();
        txtConsultorioCod.setBounds(99, 166, 100, 22);
        panelSuperior.add(txtConsultorioCod);
        
        JLabel lblFec = new JLabel("Fecha:"); 
        lblFec.setBounds(229, 169, 50, 14);
        lblFec.setForeground(Color.WHITE);
        lblFec.setFont(new Font("Tahoma", Font.BOLD, 11));
        panelSuperior.add(lblFec);
        
        txtFecha = new JTextField();
        txtFecha.setBounds(279, 166, 120, 22);
        panelSuperior.add(txtFecha);
        
        JLabel lblHora = new JLabel("Hora:"); 
        lblHora.setBounds(409, 169, 40, 14);
        lblHora.setForeground(Color.WHITE);
        lblHora.setFont(new Font("Tahoma", Font.BOLD, 11));
        panelSuperior.add(lblHora);
        
        txtHora = new JTextField();
        txtHora.setBounds(454, 165, 100, 22);
        panelSuperior.add(txtHora);

        btnAdicionar = new JButton("Programar");
        btnAdicionar.setBounds(602, 61, 120, 25);
        btnAdicionar.setBackground(Color.WHITE);
        panelSuperior.add(btnAdicionar);

        btnModificar = new JButton("Reprogramar");
        btnModificar.setBounds(602, 96, 120, 25);
        btnModificar.setBackground(Color.WHITE);
        panelSuperior.add(btnModificar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(602, 131, 120, 25);
        btnCancelar.setBackground(Color.WHITE);
        panelSuperior.add(btnCancelar);
        
        btnGrabar = new JButton("Aplicar");
        btnGrabar.setBounds(602, 167, 120, 25);
        btnGrabar.setBackground(Color.WHITE);
        panelSuperior.add(btnGrabar);


        panelInferior = new JPanel();
        panelInferior.setBounds(0, 220, 786, 343); 
        panelInferior.setBackground(Color.WHITE);
        panelInferior.setLayout(null);
        contentPane.add(panelInferior);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 760, 320);
        scrollPane.setBorder(new LineBorder(new Color(51, 153, 255), 1));
        scrollPane.getViewport().setBackground(Color.WHITE);
        panelInferior.add(scrollPane);

        tableCitas = new JTable();
        tableCitas.setFillsViewportHeight(true); 
        model = new DefaultTableModel(
            new Object[][] {},
            new String[] {"Nro", "Paciente", "Médico", "Consul.", "Fecha", "Hora", "Estado"}
        );
        tableCitas.setModel(model);
        scrollPane.setViewportView(tableCitas);

        btnAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generarCorrelativo();
                
                String medico = txtMedicoCod.getText();
                String fecha = txtFecha.getText();
                String hora = txtHora.getText();
                String consultorio = txtConsultorioCod.getText();

                if (validarDisponibilidad(medico, fecha, hora, consultorio)) {
                    agregarFilaTabla(ESTADO_PENDIENTE); 
                    limpiarCampos();
                    JOptionPane.showMessageDialog(null, "Cita Registrada con éxito.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error: Médico o Consultorio ocupado.", "Cruce", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

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
                   }
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int fila = tableCitas.getSelectedRow();
                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "Seleccione una cita para cancelar.");
                    return;
                }
                model.setValueAt("Cancelado (Historial)", fila, 6); 
                JOptionPane.showMessageDialog(null, "Cita cancelada.");
            }
        });
    }

    private void generarCorrelativo() {
        txtNumeroCita.setText("C0001"); 
    }

    private boolean validarDisponibilidad(String codMedico, String fecha, String hora, String codConsultorio) {
         if (hora.equals("10:00") && codMedico.equals("M001")) {
            return false; 
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
}