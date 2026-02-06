package gui;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

public class GUIPacienteCME extends JFrame {

    private JPanel contentPane;
    
    private JPanel panelSuperior;
    private JPanel panelInferior;

    private JTextField txtCME_codpaciente;
    private JTextField txtCME_nombres;
    private JTextField txtCME_apellidos;
    private JTextField txtCME_dni;
    private JTextField txtCME_celular;
    private JTextField txtCME_correo;
    private JComboBox<String> cmbCME_estado;
    private JSpinner spinnerEdad;
    
    private JTable tblListarPaciente;
    private DefaultTableModel model;

    /**
     * Create the frame.
     */
    public GUIPacienteCME() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(GUIPacienteCME.class.getResource("/img/produccion (2).png")));
        setTitle("Mantenimiento de Pacientes");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        panelSuperior = new JPanel();
        panelSuperior.setBounds(0, 0, 786, 250);
        panelSuperior.setBackground(new Color(51, 153, 255));
        panelSuperior.setLayout(null);
        contentPane.add(panelSuperior);
        
        JLabel lblTitulo = new JLabel("GESTIÓN DE PACIENTES");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(0, 15, 786, 40);
        panelSuperior.add(lblTitulo);

        JLabel lblCod = new JLabel("Cód. Paciente:");
        lblCod.setForeground(Color.WHITE);
        lblCod.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblCod.setBounds(30, 70, 90, 16);
        panelSuperior.add(lblCod);
        
        txtCME_codpaciente = new JTextField();
        txtCME_codpaciente.setEditable(false);
        txtCME_codpaciente.setBounds(120, 68, 100, 22);
        panelSuperior.add(txtCME_codpaciente);
        txtCME_codpaciente.setColumns(10);
        
        JLabel lblDni = new JLabel("DNI:");
        lblDni.setForeground(Color.WHITE);
        lblDni.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblDni.setBounds(250, 70, 40, 13);
        panelSuperior.add(lblDni);
        
        txtCME_dni = new JTextField();
        txtCME_dni.setEditable(false); 
        txtCME_dni.setBounds(290, 68, 100, 22);
        panelSuperior.add(txtCME_dni);
        txtCME_dni.setColumns(10);
        
        JLabel lblEst = new JLabel("Estado:");
        lblEst.setForeground(Color.WHITE);
        lblEst.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblEst.setBounds(420, 70, 50, 13);
        panelSuperior.add(lblEst);
        
        cmbCME_estado = new JComboBox<>();
        cmbCME_estado.setBounds(470, 68, 100, 22);
        panelSuperior.add(cmbCME_estado);

        JLabel lblNom = new JLabel("Nombres:");
        lblNom.setForeground(Color.WHITE);
        lblNom.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNom.setBounds(30, 105, 60, 13);
        panelSuperior.add(lblNom);
        
        txtCME_nombres = new JTextField();
        txtCME_nombres.setBounds(120, 102, 200, 22);
        panelSuperior.add(txtCME_nombres);
        
        JLabel lblApe = new JLabel("Apellidos:");
        lblApe.setForeground(Color.WHITE);
        lblApe.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblApe.setBounds(340, 105, 60, 13);
        panelSuperior.add(lblApe);
        
        txtCME_apellidos = new JTextField();
        txtCME_apellidos.setBounds(410, 102, 200, 22);
        panelSuperior.add(txtCME_apellidos);

        JLabel lblCorreo = new JLabel("Correo:");
        lblCorreo.setForeground(Color.WHITE);
        lblCorreo.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblCorreo.setBounds(30, 140, 50, 13);
        panelSuperior.add(lblCorreo);
        
        txtCME_correo = new JTextField();
        txtCME_correo.setBounds(120, 137, 200, 22);
        panelSuperior.add(txtCME_correo);
        
        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setForeground(Color.WHITE);
        lblEdad.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblEdad.setBounds(340, 140, 40, 13);
        panelSuperior.add(lblEdad);
        
        spinnerEdad = new JSpinner();
        spinnerEdad.setBounds(380, 137, 50, 22);
        panelSuperior.add(spinnerEdad);
        
        JLabel lblCel = new JLabel("Celular:");
        lblCel.setForeground(Color.WHITE);
        lblCel.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblCel.setBounds(450, 140, 50, 13);
        panelSuperior.add(lblCel);
        
        txtCME_celular = new JTextField();
        txtCME_celular.setBounds(500, 137, 110, 22);
        panelSuperior.add(txtCME_celular);

        JButton btnConsultar = new JButton("Consultar");
        btnConsultar.setBackground(Color.WHITE);
        btnConsultar.setIcon(new ImageIcon(GUIPacienteCME.class.getResource("/img/consulta (1).png")));
        btnConsultar.setBounds(120, 190, 130, 30);
        panelSuperior.add(btnConsultar);
        
        JButton btnModificar = new JButton("Modificar");
        btnModificar.setBackground(Color.WHITE);
        btnModificar.setBounds(270, 190, 130, 30);
        panelSuperior.add(btnModificar);
        
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBackground(Color.WHITE);
        btnEliminar.setBounds(420, 190, 130, 30);
        panelSuperior.add(btnEliminar);

        panelInferior = new JPanel();
        panelInferior.setBounds(0, 250, 786, 313); 
        panelInferior.setBackground(Color.WHITE);
        panelInferior.setLayout(null);
        contentPane.add(panelInferior);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 764, 292);
        scrollPane.setBorder(new LineBorder(new Color(51, 153, 255), 1));
        scrollPane.getViewport().setBackground(Color.WHITE);
        panelInferior.add(scrollPane);
        
        tblListarPaciente = new JTable();
        tblListarPaciente.setFillsViewportHeight(true);
        model = new DefaultTableModel(
            new Object[][] {},
            new String[] {
                "Cód.", "Nombres", "Apellidos", "DNI", "Edad", "Celular", "Correo", "Estado"
            }
        );
        tblListarPaciente.setModel(model);
        
        tblListarPaciente.getColumnModel().getColumn(0).setPreferredWidth(50);
        tblListarPaciente.getColumnModel().getColumn(3).setPreferredWidth(70);
        tblListarPaciente.getColumnModel().getColumn(4).setPreferredWidth(40);
        
        scrollPane.setViewportView(tblListarPaciente);
    }
}