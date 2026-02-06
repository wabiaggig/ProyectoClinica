package gui;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIPaciente extends JFrame {

    private JPanel contentPane;
    
    private JPanel panelSuperior;
    private JPanel panelInferior;

    private JTextField txtCodPaciente;
    private JTextField txtNombres;
    private JTextField txtApellidos;
    private JTextField txtDni;
    private JTextField txtCelular;
    private JTextField txtCorreo;
    private JComboBox<String> cbmEdad;
    private JComboBox<String> cmbEstado;
    
    private JButton btnGuardar;
    private JButton btnCancelar;

    /**
     * Create the frame.
     */
    public GUIPaciente() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(GUIPaciente.class.getResource("/img/paciente (1).png")));
        setTitle("Adicionar Paciente");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 450); 
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        panelSuperior = new JPanel();
        panelSuperior.setBounds(0, 0, 436, 80); 
        panelSuperior.setBackground(new Color(51, 153, 255));
        panelSuperior.setLayout(null);
        contentPane.add(panelSuperior);
        
        JLabel lblTitulo = new JLabel("AÑADIR PACIENTE");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 24)); 
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(0, 20, 436, 40);
        panelSuperior.add(lblTitulo);

        panelInferior = new JPanel();
        panelInferior.setBounds(0, 80, 436, 333); 
        panelInferior.setBackground(Color.WHITE);
        panelInferior.setLayout(null);
        contentPane.add(panelInferior);

        JLabel lblCod = new JLabel("Cód. Paciente:");
        lblCod.setBounds(30, 20, 90, 16);
        panelInferior.add(lblCod);
        
        txtCodPaciente = new JTextField();
        txtCodPaciente.setEditable(false);
        txtCodPaciente.setBounds(120, 18, 100, 22);
        panelInferior.add(txtCodPaciente);
        txtCodPaciente.setColumns(10);
        
        JLabel lblNom = new JLabel("Nombres:");
        lblNom.setBounds(30, 55, 90, 13);
        panelInferior.add(lblNom);
        
        txtNombres = new JTextField();
        txtNombres.setBounds(120, 52, 260, 22);
        panelInferior.add(txtNombres);
        txtNombres.setColumns(10);
        
        JLabel lblApe = new JLabel("Apellidos:");
        lblApe.setBounds(30, 90, 90, 13);
        panelInferior.add(lblApe);
        
        txtApellidos = new JTextField();
        txtApellidos.setBounds(120, 87, 260, 22);
        panelInferior.add(txtApellidos);
        txtApellidos.setColumns(10);
        
        JLabel lblDni = new JLabel("DNI:");
        lblDni.setBounds(30, 125, 45, 13);
        panelInferior.add(lblDni);
        
        txtDni = new JTextField();
        txtDni.setEditable(true); 
        txtDni.setBounds(120, 122, 100, 22);
        panelInferior.add(txtDni);
        txtDni.setColumns(10);
        
        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setBounds(240, 125, 45, 13);
        panelInferior.add(lblEdad);
        
        cbmEdad = new JComboBox<>();
        for(int i=1; i<=100; i++) cbmEdad.addItem(String.valueOf(i));
        cbmEdad.setBounds(280, 122, 50, 22);
        panelInferior.add(cbmEdad);
        
        JLabel lblCel = new JLabel("Celular:");
        lblCel.setBounds(30, 160, 60, 13);
        panelInferior.add(lblCel);
        
        txtCelular = new JTextField();
        txtCelular.setBounds(120, 157, 100, 22);
        panelInferior.add(txtCelular);
        txtCelular.setColumns(10);
        
        JLabel lblEst = new JLabel("Estado:");
        lblEst.setBounds(240, 160, 45, 13);
        panelInferior.add(lblEst);
        
        cmbEstado = new JComboBox<>();
        cmbEstado.setModel(new DefaultComboBoxModel<>(new String[] {"Activo", "Inactivo"}));
        cmbEstado.setBounds(290, 157, 90, 22);
        panelInferior.add(cmbEstado);

        JLabel lblMail = new JLabel("Correo:");
        lblMail.setBounds(30, 195, 60, 13);
        panelInferior.add(lblMail);
        
        txtCorreo = new JTextField();
        txtCorreo.setBounds(120, 192, 260, 22);
        panelInferior.add(txtCorreo);
        txtCorreo.setColumns(10);
        
        btnGuardar = new JButton("Guardar");
        btnGuardar.setBackground(Color.WHITE);
        btnGuardar.setIcon(new ImageIcon(GUIPaciente.class.getResource("/img/disco-flexible (1).png")));
        btnGuardar.setBounds(80, 250, 120, 30);
        panelInferior.add(btnGuardar);
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(Color.WHITE);
        btnCancelar.setIcon(new ImageIcon(GUIPaciente.class.getResource("/img/usuario (1).png")));
        btnCancelar.setBounds(230, 250, 120, 30);
        panelInferior.add(btnCancelar);
        
  
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); 
            }
        });
    }
}