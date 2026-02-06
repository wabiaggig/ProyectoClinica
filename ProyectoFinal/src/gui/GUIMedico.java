package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;

public class GUIMedico extends JFrame {

    private JPanel contentPane;
    
    private JPanel panelSuperior;
    private JPanel panelInferior;
    
    private JTextField txtMedico_cod;
    private JTextField txtMedico_nombres;
    private JTextField txtMedico_apellidos;
    private JTextField txtMedico_cmp;
    private JTextField txtMedico_especialidad;
    private JComboBox<String> cmbMedico_estado;
    private JButton btnMedico_adicionar;
    private JButton btnMedico_grabar;

    /**
     * Create the frame.
     */
    public GUIMedico() {
        setTitle("Mantenimiento de Médico");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 465, 360); 
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        panelSuperior = new JPanel();
        panelSuperior.setBounds(0, 0, 450, 60); 
        panelSuperior.setBackground(new Color(51, 153, 255));
        panelSuperior.setLayout(null);
        contentPane.add(panelSuperior);
        
        JLabel lblTitulo = new JLabel("REGISTRO DE MÉDICO");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(0, 15, 450, 30);
        panelSuperior.add(lblTitulo);


        panelInferior = new JPanel();
        panelInferior.setBounds(0, 60, 450, 261);
        panelInferior.setBackground(Color.WHITE);
        panelInferior.setLayout(null);
        contentPane.add(panelInferior);

        JLabel lblCodmedico = new JLabel("Código:");
        lblCodmedico.setBounds(30, 20, 73, 16);
        panelInferior.add(lblCodmedico);
        
        txtMedico_cod = new JTextField();
        txtMedico_cod.setEditable(false);
        txtMedico_cod.setBounds(110, 19, 100, 22); 
        panelInferior.add(txtMedico_cod);
        txtMedico_cod.setColumns(10);
        
        JLabel lblNombres = new JLabel("Nombres:");
        lblNombres.setBounds(30, 55, 73, 13);
        panelInferior.add(lblNombres);

        txtMedico_nombres = new JTextField();
        txtMedico_nombres.setBounds(110, 51, 280, 22);
        panelInferior.add(txtMedico_nombres);
        txtMedico_nombres.setColumns(10);
        
        JLabel lblApellidos = new JLabel("Apellidos:");
        lblApellidos.setBounds(30, 87, 73, 13);
        panelInferior.add(lblApellidos);
        
        txtMedico_apellidos = new JTextField();
        txtMedico_apellidos.setBounds(110, 83, 280, 22);
        panelInferior.add(txtMedico_apellidos);
        txtMedico_apellidos.setColumns(10);
        
        JLabel lblCmp = new JLabel("CMP:");
        lblCmp.setBounds(30, 119, 45, 13);
        panelInferior.add(lblCmp);
        
        txtMedico_cmp = new JTextField();
        txtMedico_cmp.setEditable(false); 
        txtMedico_cmp.setBounds(110, 115, 100, 22);
        panelInferior.add(txtMedico_cmp);
        txtMedico_cmp.setColumns(10);
        
        JLabel lblEstado = new JLabel("Estado:");
        lblEstado.setBounds(230, 119, 45, 13);
        panelInferior.add(lblEstado);
        
        cmbMedico_estado = new JComboBox<>();
        cmbMedico_estado.setModel(new DefaultComboBoxModel<>(new String[] {"Activo", "Inactivo"}));
        cmbMedico_estado.setBounds(280, 115, 110, 22);
        panelInferior.add(cmbMedico_estado);
        
        JLabel lblEspecialidad = new JLabel("Especialidad:");
        lblEspecialidad.setBounds(30, 151, 83, 13);
        panelInferior.add(lblEspecialidad);
        
        txtMedico_especialidad = new JTextField();
        txtMedico_especialidad.setBounds(110, 147, 280, 22);
        panelInferior.add(txtMedico_especialidad);
        txtMedico_especialidad.setColumns(10);
        
        btnMedico_adicionar = new JButton("Adicionar");
        btnMedico_adicionar.setIcon(new ImageIcon(GUIMedico.class.getResource("/img/signo-de-mas (1).png")));
        btnMedico_adicionar.setBounds(90, 200, 120, 30);
        btnMedico_adicionar.setBackground(Color.WHITE); 
        panelInferior.add(btnMedico_adicionar);
        
        btnMedico_grabar = new JButton("Grabar");
        btnMedico_grabar.setIcon(new ImageIcon(GUIMedico.class.getResource("/img/disco-flexible (1).png")));
        btnMedico_grabar.setBounds(240, 200, 120, 30);
        btnMedico_grabar.setBackground(Color.WHITE);
        panelInferior.add(btnMedico_grabar);
        
        btnMedico_adicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarFormulario();
            }
        });
        
        btnMedico_grabar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Grabando médico: " + txtMedico_nombres.getText());
            }
        });
    }
    
    private void limpiarFormulario() {
        txtMedico_nombres.setText("");
        txtMedico_apellidos.setText("");
        txtMedico_cmp.setText("");
        txtMedico_especialidad.setText("");
        cmbMedico_estado.setSelectedIndex(0);
        txtMedico_nombres.requestFocus();
    }
}