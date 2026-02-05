package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class GUIConsultorio extends JFrame {

	private JPanel contentPane;
	private JTextField txtConsultorio_cod;
	private JTextField txtConsultorio_nombre;
	private JTextField txtConsultorio_piso;
	private JTextField txtConsultorio_cap;
	private JTextField txtConsultorio_ubi;

	/**
	 * Create the frame.
	 */
	public GUIConsultorio() {
		setTitle("Adicionar Consultorio");
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUIConsultorio.class.getResource("/img/servicio-medico-en-linea (1) (1).png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodconsultorio = new JLabel("codConsultorio");
		lblCodconsultorio.setBounds(10, 26, 107, 16);
		contentPane.add(lblCodconsultorio);
		
		txtConsultorio_cod = new JTextField();
		txtConsultorio_cod.setEditable(false);
		txtConsultorio_cod.setColumns(10);
		txtConsultorio_cod.setBounds(127, 25, 96, 19);
		contentPane.add(txtConsultorio_cod);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(10, 52, 52, 13);
		contentPane.add(lblNewLabel_1);
		
		txtConsultorio_nombre = new JTextField();
		txtConsultorio_nombre.setEditable(false);
		txtConsultorio_nombre.setColumns(10);
		txtConsultorio_nombre.setBounds(72, 49, 150, 19);
		contentPane.add(txtConsultorio_nombre);
		
		txtConsultorio_piso = new JTextField();
		txtConsultorio_piso.setColumns(10);
		txtConsultorio_piso.setBounds(72, 78, 151, 19);
		contentPane.add(txtConsultorio_piso);
		
		JLabel lblNewLabel_2 = new JLabel("Piso");
		lblNewLabel_2.setBounds(10, 81, 52, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Capacidad");
		lblNewLabel_3.setBounds(10, 110, 65, 13);
		contentPane.add(lblNewLabel_3);
		
		txtConsultorio_cap = new JTextField();
		txtConsultorio_cap.setColumns(10);
		txtConsultorio_cap.setBounds(72, 107, 151, 19);
		contentPane.add(txtConsultorio_cap);
		
		JLabel lblNewLabel_6 = new JLabel("Estado");
		lblNewLabel_6.setBounds(245, 81, 45, 13);
		contentPane.add(lblNewLabel_6);
		
		JComboBox cmbConsultorio_estado = new JComboBox();
		cmbConsultorio_estado.setBounds(300, 81, 45, 16);
		contentPane.add(cmbConsultorio_estado);
		
		txtConsultorio_ubi = new JTextField();
		txtConsultorio_ubi.setColumns(10);
		txtConsultorio_ubi.setBounds(72, 136, 217, 19);
		contentPane.add(txtConsultorio_ubi);
		
		JLabel lblNewLabel_5 = new JLabel("Ubicacion");
		lblNewLabel_5.setBounds(10, 144, 83, 13);
		contentPane.add(lblNewLabel_5);
		
		JButton btnConsultorio_adicionar = new JButton("Adicionar");
		btnConsultorio_adicionar.setIcon(new ImageIcon(GUIConsultorio.class.getResource("/img/signo-de-mas (1).png")));
		btnConsultorio_adicionar.setBounds(61, 193, 122, 21);
		contentPane.add(btnConsultorio_adicionar);
		
		JButton btnConsultorio_grabar = new JButton("Grabar");
		btnConsultorio_grabar.setIcon(new ImageIcon(GUIConsultorio.class.getResource("/img/disco-flexible (1).png")));
		btnConsultorio_grabar.setBounds(247, 193, 122, 21);
		contentPane.add(btnConsultorio_grabar);
	}

}
