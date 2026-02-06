package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
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

public class GUIConsultorio extends JFrame {

    private JPanel contentPane;
    
    private JPanel panelSuperior;
    private JPanel panelInferior;

    private JTextField txtConsultorio_cod;
    private JTextField txtConsultorio_nombre;
    private JTextField txtConsultorio_piso;
    private JTextField txtConsultorio_cap;
    private JTextField txtConsultorio_ubi;
    private JComboBox<String> cmbConsultorio_estado;
    
    private JButton btnConsultorio_adicionar;
    private JButton btnConsultorio_grabar;

    /**
     * Create the frame.
     */
    public GUIConsultorio() {
        setTitle("Adicionar Consultorio");
        setIconImage(Toolkit.getDefaultToolkit().getImage(GUIConsultorio.class.getResource("/img/servicio-medico-en-linea (1) (1).png")));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 480, 420);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        panelSuperior = new JPanel();
        panelSuperior.setBounds(0, 0, 480, 80); 
        panelSuperior.setBackground(new Color(51, 153, 255));
        panelSuperior.setLayout(null);
        contentPane.add(panelSuperior);
        
        JLabel lblTitulo = new JLabel("AÑADIR CONSULTORIO");
        lblTitulo.setForeground(Color.WHITE);
                lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 24)); 
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(0, 20, 464, 40);
        panelSuperior.add(lblTitulo);

       
        panelInferior = new JPanel();
        panelInferior.setBounds(0, 80, 480, 301); 
        panelInferior.setBackground(Color.WHITE);
        panelInferior.setLayout(null);
        contentPane.add(panelInferior);


        JLabel lblCod = new JLabel("Código:");
        lblCod.setBounds(30, 20, 80, 16);
        panelInferior.add(lblCod);
        
        txtConsultorio_cod = new JTextField();
        txtConsultorio_cod.setEditable(false);         
        txtConsultorio_cod.setBounds(100, 18, 100, 22);
        panelInferior.add(txtConsultorio_cod);
        txtConsultorio_cod.setColumns(10);
        
        JLabel lblNom = new JLabel("Nombre:");
        lblNom.setBounds(30, 55, 80, 13);
        panelInferior.add(lblNom);
        
        txtConsultorio_nombre = new JTextField();
       txtConsultorio_nombre.setEditable(true); 
        txtConsultorio_nombre.setBounds(100, 51, 320, 22);
        panelInferior.add(txtConsultorio_nombre);
        txtConsultorio_nombre.setColumns(10);

        
        JLabel lblPiso = new JLabel("Piso:");
        lblPiso.setBounds(30, 90, 40, 13);
        panelInferior.add(lblPiso);
        
        txtConsultorio_piso = new JTextField();
        txtConsultorio_piso.setBounds(100, 86, 60, 22);
        panelInferior.add(txtConsultorio_piso);
        txtConsultorio_piso.setColumns(10);
        
        JLabel lblCap = new JLabel("Capac.:");
        lblCap.setBounds(180, 90, 50, 13);
        panelInferior.add(lblCap);
        
        txtConsultorio_cap = new JTextField();
        txtConsultorio_cap.setBounds(230, 86, 50, 22);
        panelInferior.add(txtConsultorio_cap);
        txtConsultorio_cap.setColumns(10);
        
        JLabel lblEst = new JLabel("Estado:");
        lblEst.setBounds(300, 90, 50, 13);
        panelInferior.add(lblEst);
        
        cmbConsultorio_estado = new JComboBox<>();
        cmbConsultorio_estado.setModel(new DefaultComboBoxModel<>(new String[] {"Libre", "Ocupado", "Mantenimiento"}));
        cmbConsultorio_estado.setBounds(350, 86, 70, 22);
        panelInferior.add(cmbConsultorio_estado);

        JLabel lblUbi = new JLabel("Ubicación:");
        lblUbi.setBounds(30, 125, 80, 13);
        panelInferior.add(lblUbi);
        
        txtConsultorio_ubi = new JTextField();
        txtConsultorio_ubi.setBounds(100, 121, 320, 22);
        panelInferior.add(txtConsultorio_ubi);
        txtConsultorio_ubi.setColumns(10);
        
                btnConsultorio_adicionar = new JButton("Adicionar");
        btnConsultorio_adicionar.setBackground(Color.WHITE);
        btnConsultorio_adicionar.setIcon(new ImageIcon(GUIConsultorio.class.getResource("/img/signo-de-mas (1).png")));
        btnConsultorio_adicionar.setBounds(90, 180, 130, 30);
        panelInferior.add(btnConsultorio_adicionar);
        
        btnConsultorio_grabar = new JButton("Grabar");
        btnConsultorio_grabar.setBackground(Color.WHITE);
        btnConsultorio_grabar.setIcon(new ImageIcon(GUIConsultorio.class.getResource("/img/disco-flexible (1).png")));
        btnConsultorio_grabar.setBounds(250, 180, 130, 30);
        panelInferior.add(btnConsultorio_grabar);
        
        btnConsultorio_adicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtConsultorio_nombre.setText("");
                txtConsultorio_piso.setText("");
                txtConsultorio_cap.setText("");
                txtConsultorio_ubi.setText("");
                txtConsultorio_nombre.requestFocus();
            }
        });
    }
}