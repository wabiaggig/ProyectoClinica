package gui;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

public class GUIConsultorioCME extends JFrame {

    private JPanel contentPane;
    
    private JPanel panelSuperior;
    private JPanel panelInferior;

    private JTextField txtCodConsultorio;
    private JTextField txtNombre;
    private JTextField txtPiso;
    private JTextField txtCapacidad;
    private JTextField txtUbicacion;
    private JComboBox<String> cmbConsultorio_estado;
    private JTable tblListarConsultorio;
    private DefaultTableModel model;

    /**
     * Create the frame.
     */
    public GUIConsultorioCME() {
        setTitle("Mantenimiento de Consultorios");
        setIconImage(Toolkit.getDefaultToolkit().getImage(GUIConsultorioCME.class.getResource("/img/produccion (2).png")));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 806, 618);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        panelSuperior = new JPanel();
        panelSuperior.setBounds(0, 0, 792, 230); 
        panelSuperior.setBackground(new Color(51, 153, 255));
        panelSuperior.setLayout(null);
        contentPane.add(panelSuperior);
        
        JLabel lblTitulo = new JLabel("GESTIÓN Y CONSULTA DE CONSULTORIOS");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(0, 15, 792, 30);
        panelSuperior.add(lblTitulo);

        // --- FILA 1 ---
        JLabel lblCod = new JLabel("Cód. Consultorio:");
        lblCod.setForeground(Color.WHITE);
        lblCod.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblCod.setBounds(20, 60, 110, 16);
        panelSuperior.add(lblCod);
        
        txtCodConsultorio = new JTextField();
        txtCodConsultorio.setEditable(false);
        txtCodConsultorio.setBounds(130, 58, 100, 22);
        panelSuperior.add(txtCodConsultorio);
        txtCodConsultorio.setColumns(10);
        
        JLabel lblNom = new JLabel("Nombre:");
        lblNom.setForeground(Color.WHITE);
        lblNom.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNom.setBounds(260, 60, 60, 13);
        panelSuperior.add(lblNom);
        
        txtNombre = new JTextField();
        txtNombre.setEditable(false); 
        txtNombre.setBounds(340, 57, 200, 22);
        panelSuperior.add(txtNombre);
        txtNombre.setColumns(10);
        
        JLabel lblEst = new JLabel("Estado:");
        lblEst.setForeground(Color.WHITE);
        lblEst.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblEst.setBounds(550, 60, 50, 13);
        panelSuperior.add(lblEst);
        
        cmbConsultorio_estado = new JComboBox<>();
        cmbConsultorio_estado.setBounds(610, 58, 120, 22);
        panelSuperior.add(cmbConsultorio_estado);

        JLabel lblPiso = new JLabel("Piso:");
        lblPiso.setForeground(Color.WHITE);
        lblPiso.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblPiso.setBounds(20, 95, 52, 13);
        panelSuperior.add(lblPiso);
        
        txtPiso = new JTextField();
        txtPiso.setBounds(130, 92, 100, 22);
        panelSuperior.add(txtPiso);
        txtPiso.setColumns(10);
        
        JLabel lblCap = new JLabel("Capacidad:");
        lblCap.setForeground(Color.WHITE);
        lblCap.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblCap.setBounds(260, 95, 70, 13);
        panelSuperior.add(lblCap);
        
        txtCapacidad = new JTextField();
        txtCapacidad.setBounds(340, 92, 80, 22);
        panelSuperior.add(txtCapacidad);
        txtCapacidad.setColumns(10);

        JLabel lblUbi = new JLabel("Ubicación:");
        lblUbi.setForeground(Color.WHITE);
        lblUbi.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblUbi.setBounds(20, 130, 80, 13);
        panelSuperior.add(lblUbi);
        
        txtUbicacion = new JTextField();
        txtUbicacion.setBounds(130, 127, 400, 22);
        panelSuperior.add(txtUbicacion);
        txtUbicacion.setColumns(10);

        JButton btnConsultar = new JButton("Consultar");
        btnConsultar.setBackground(Color.WHITE);
        btnConsultar.setIcon(new ImageIcon(GUIConsultorioCME.class.getResource("/img/consulta (1).png")));
        btnConsultar.setBounds(150, 180, 130, 30);
        panelSuperior.add(btnConsultar);
        
        JButton btnModificar = new JButton("Modificar");
        btnModificar.setBackground(Color.WHITE);
        btnModificar.setBounds(300, 180, 130, 30);
        panelSuperior.add(btnModificar);
        
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBackground(Color.WHITE);
        btnEliminar.setBounds(450, 180, 130, 30);
        panelSuperior.add(btnEliminar);


        panelInferior = new JPanel();
        panelInferior.setBounds(0, 230, 792, 351); 
        panelInferior.setLayout(null);
        contentPane.add(panelInferior);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 770, 330);
        scrollPane.setBorder(new LineBorder(new Color(51, 153, 255), 1));
        scrollPane.getViewport().setBackground(Color.WHITE);
        panelInferior.add(scrollPane);
        
        tblListarConsultorio = new JTable();
        tblListarConsultorio.setFillsViewportHeight(true);
        model = new DefaultTableModel(
            new Object[][] {},
            new String[] {
                "Cód.", "Nombre", "Piso", "Capacidad", "Estado", "Ubicación"
            }
        );
        tblListarConsultorio.setModel(model);
        
        tblListarConsultorio.getColumnModel().getColumn(0).setPreferredWidth(50);
        tblListarConsultorio.getColumnModel().getColumn(1).setPreferredWidth(150);
        tblListarConsultorio.getColumnModel().getColumn(5).setPreferredWidth(200);

        scrollPane.setViewportView(tblListarConsultorio);
    }
}