package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class GUIPaciente extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodPaciente;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtDni;
	private JTextField txtCelular;
	private JTextField txtCorreo;

	/**
	 * Create the frame.
	 */
	public GUIPaciente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUIPaciente.class.getResource("/img/paciente (1).png")));
		setTitle("Adicionar Paciente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodPaciente = new JLabel("codPaciente");
		lblCodPaciente.setBounds(28, 30, 73, 16);
		contentPane.add(lblCodPaciente);
		
		txtCodPaciente = new JTextField();
		txtCodPaciente.setEditable(false);
		txtCodPaciente.setBounds(111, 29, 96, 19);
		contentPane.add(txtCodPaciente);
		txtCodPaciente.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombres");
		lblNewLabel_1.setBounds(28, 56, 52, 13);
		contentPane.add(lblNewLabel_1);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(90, 53, 238, 19);
		contentPane.add(txtNombres);
		txtNombres.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Apellidos");
		lblNewLabel_2.setBounds(28, 85, 52, 13);
		contentPane.add(lblNewLabel_2);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(90, 82, 238, 19);
		contentPane.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("DNI");
		lblNewLabel_3.setBounds(28, 117, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		txtDni = new JTextField();
		txtDni.setEditable(false);
		txtDni.setBounds(79, 111, 96, 19);
		contentPane.add(txtDni);
		txtDni.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Edad");
		lblNewLabel_4.setBounds(28, 141, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("Celular");
		lblNewLabel.setBounds(28, 164, 45, 13);
		contentPane.add(lblNewLabel);
		
		txtCelular = new JTextField();
		txtCelular.setBounds(79, 161, 96, 19);
		contentPane.add(txtCelular);
		txtCelular.setColumns(10);
		
		JComboBox cbmEdad = new JComboBox();
		cbmEdad.setBounds(79, 137, 45, 21);
		contentPane.add(cbmEdad);
		
		JLabel lblNewLabel_5 = new JLabel("Correo");
		lblNewLabel_5.setBounds(28, 193, 45, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Estado");
		lblNewLabel_6.setBounds(28, 222, 45, 13);
		contentPane.add(lblNewLabel_6);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(79, 190, 156, 19);
		contentPane.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		JComboBox cmbEstado = new JComboBox();
		cmbEstado.setBounds(79, 218, 45, 21);
		contentPane.add(cmbEstado);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(new ImageIcon(GUIPaciente.class.getResource("/img/disco-flexible (1).png")));
		btnGuardar.setBounds(164, 232, 106, 21);
		contentPane.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(GUIPaciente.class.getResource("/img/usuario (1).png")));
		btnCancelar.setBounds(280, 232, 112, 21);
		contentPane.add(btnCancelar);
	}
}