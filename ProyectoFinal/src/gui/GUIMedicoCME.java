package gui;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

public class GUIMedicoCME extends JFrame {

    private JPanel contentPane;
    
    private JPanel panelSuperior;
    private JPanel panelInferior;

    private JTextField txtCME_codMedico;
    private JTextField txtCME_nombres;
    private JTextField txtCME_apellidos;
    private JTextField txtCME_cmp;
    private JTextField txtCME_especialidad;
    private JComboBox<String> cmbCME_estado;
    
    private JTable tblListarMedico;
    private DefaultTableModel model;

    /**
     * Create the frame.
     */
    public GUIMedicoCME() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(GUIMedicoCME.class.getResource("/img/produccion (2).png")));
        setTitle("Mantenimiento de Médicos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        panelSuperior = new JPanel();
        panelSuperior.setBounds(0, 0, 786, 230);
        panelSuperior.setBackground(new Color(51, 153, 255));
        panelSuperior.setLayout(null);
        contentPane.add(panelSuperior);
        
        JLabel lblTitulo = new JLabel("GESTIÓN DE MÉDICOS");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(0, 15, 786, 40);
        panelSuperior.add(lblTitulo);

        JLabel lblCod = new JLabel("Cód. Médico:");
        lblCod.setForeground(Color.WHITE);
        lblCod.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblCod.setBounds(30, 70, 80, 16);
        panelSuperior.add(lblCod);
        
        txtCME_codMedico = new JTextField();
        txtCME_codMedico.setEditable(false);
        txtCME_codMedico.setBounds(110, 68, 100, 22);
        panelSuperior.add(txtCME_codMedico);
        txtCME_codMedico.setColumns(10);
        
        JLabel lblCMP = new JLabel("CMP:");
        lblCMP.setForeground(Color.WHITE);
        lblCMP.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblCMP.setBounds(240, 70, 40, 13);
        panelSuperior.add(lblCMP);
        
        txtCME_cmp = new JTextField();
        txtCME_cmp.setEditable(false);
        txtCME_cmp.setBounds(280, 68, 100, 22);
        panelSuperior.add(txtCME_cmp);
        txtCME_cmp.setColumns(10);
        
        JLabel lblEst = new JLabel("Estado:");
        lblEst.setForeground(Color.WHITE);
        lblEst.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblEst.setBounds(410, 70, 50, 13);
        panelSuperior.add(lblEst);
        
        cmbCME_estado = new JComboBox<>();
        cmbCME_estado.setBounds(460, 68, 100, 22);
        panelSuperior.add(cmbCME_estado);

        JLabel lblNom = new JLabel("Nombres:");
        lblNom.setForeground(Color.WHITE);
        lblNom.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNom.setBounds(30, 105, 60, 13);
        panelSuperior.add(lblNom);
        
        txtCME_nombres = new JTextField();
        txtCME_nombres.setBounds(110, 102, 200, 22);
        panelSuperior.add(txtCME_nombres);
        
        JLabel lblApe = new JLabel("Apellidos:");
        lblApe.setForeground(Color.WHITE);
        lblApe.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblApe.setBounds(330, 105, 60, 13);
        panelSuperior.add(lblApe);
        
        txtCME_apellidos = new JTextField();
        txtCME_apellidos.setBounds(400, 102, 200, 22);
        panelSuperior.add(txtCME_apellidos);

        JLabel lblEsp = new JLabel("Especialidad:");
        lblEsp.setForeground(Color.WHITE);
        lblEsp.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblEsp.setBounds(30, 140, 80, 13);
        panelSuperior.add(lblEsp);
        
        txtCME_especialidad = new JTextField();
        txtCME_especialidad.setBounds(110, 137, 270, 22);
        panelSuperior.add(txtCME_especialidad);

        JButton btnConsultar = new JButton("Consultar");
        btnConsultar.setBackground(Color.WHITE);
        btnConsultar.setIcon(new ImageIcon(GUIMedicoCME.class.getResource("/img/consulta (1).png")));
        btnConsultar.setBounds(110, 180, 130, 30);
        panelSuperior.add(btnConsultar);
        
        JButton btnModificar = new JButton("Modificar");
        btnModificar.setBackground(Color.WHITE);
        btnModificar.setBounds(260, 180, 130, 30);
        panelSuperior.add(btnModificar);
        
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBackground(Color.WHITE);
        btnEliminar.setBounds(410, 180, 130, 30);
        panelSuperior.add(btnEliminar);


        panelInferior = new JPanel();
        panelInferior.setBounds(0, 230, 786, 333); 
        panelInferior.setBackground(Color.WHITE);
        panelInferior.setLayout(null);
        contentPane.add(panelInferior);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 764, 310);
        scrollPane.setBorder(new LineBorder(new Color(51, 153, 255), 1));
        scrollPane.getViewport().setBackground(Color.WHITE);
        panelInferior.add(scrollPane);
        
        tblListarMedico = new JTable();
        tblListarMedico.setFillsViewportHeight(true);
        model = new DefaultTableModel(
            new Object[][] {},
            new String[] {
                "Cód.", "Nombres", "Apellidos", "CMP", "Especialidad", "Estado"
            }
        );
        tblListarMedico.setModel(model);
        
        tblListarMedico.getColumnModel().getColumn(0).setPreferredWidth(50);
        tblListarMedico.getColumnModel().getColumn(4).setPreferredWidth(150);
        
        scrollPane.setViewportView(tblListarMedico);
    }
}