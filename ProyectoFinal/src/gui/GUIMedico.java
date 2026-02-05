package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class GUIMedico extends JFrame {

	private JPanel contentPane;
	private JTextField txtMedico_cod;
	private JTextField txtMedico_nombres;
	private JTextField txtMedico_apellidos;
	private JTextField txtMedico_cmp;
	private JTextField txtMedico_especialidad;

	/**
	 * Create the frame.
	 */
	public GUIMedico() {
		setTitle("Adicionar Medico");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodmedico = new JLabel("codMedico");
		lblCodmedico.setBounds(22, 11, 73, 16);
		contentPane.add(lblCodmedico);
		
		txtMedico_cod = new JTextField();
		txtMedico_cod.setEditable(false);
		txtMedico_cod.setColumns(10);
		txtMedico_cod.setBounds(105, 10, 96, 19);
		contentPane.add(txtMedico_cod);
		
		txtMedico_nombres = new JTextField();
		txtMedico_nombres.setColumns(10);
		txtMedico_nombres.setBounds(84, 34, 238, 19);
		contentPane.add(txtMedico_nombres);
		
		JLabel lblNewLabel_1 = new JLabel("Nombres");
		lblNewLabel_1.setBounds(22, 37, 52, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellidos");
		lblNewLabel_2.setBounds(22, 66, 52, 13);
		contentPane.add(lblNewLabel_2);
		
		txtMedico_apellidos = new JTextField();
		txtMedico_apellidos.setColumns(10);
		txtMedico_apellidos.setBounds(84, 63, 238, 19);
		contentPane.add(txtMedico_apellidos);
		
		txtMedico_cmp = new JTextField();
		txtMedico_cmp.setEditable(false);
		txtMedico_cmp.setColumns(10);
		txtMedico_cmp.setBounds(84, 92, 96, 19);
		contentPane.add(txtMedico_cmp);
		
		JLabel lblNewLabel_3 = new JLabel("CMP");
		lblNewLabel_3.setBounds(22, 95, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Especialidad");
		lblNewLabel_5.setBounds(22, 129, 83, 13);
		contentPane.add(lblNewLabel_5);
		
		txtMedico_especialidad = new JTextField();
		txtMedico_especialidad.setColumns(10);
		txtMedico_especialidad.setBounds(105, 126, 217, 19);
		contentPane.add(txtMedico_especialidad);
		
		JComboBox cmbMedico_estado = new JComboBox();
		cmbMedico_estado.setBounds(240, 92, 45, 16);
		contentPane.add(cmbMedico_estado);
		
		JLabel lblNewLabel_6 = new JLabel("Estado");
		lblNewLabel_6.setBounds(190, 95, 45, 13);
		contentPane.add(lblNewLabel_6);
		
		JButton btnMedico_adicionar = new JButton("Adicionar");
		btnMedico_adicionar.setIcon(new ImageIcon(GUIMedico.class.getResource("/img/signo-de-mas (1).png")));
		btnMedico_adicionar.setBounds(77, 191, 103, 21);
		contentPane.add(btnMedico_adicionar);
		
		JButton btnMedico_grabar = new JButton("Grabar");
		btnMedico_grabar.setIcon(new ImageIcon(GUIMedico.class.getResource("/img/disco-flexible (1).png")));
		btnMedico_grabar.setBounds(228, 191, 111, 21);
		contentPane.add(btnMedico_grabar);
	}

}