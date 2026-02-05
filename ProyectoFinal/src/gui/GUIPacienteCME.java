package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class GUIPacienteCME extends JFrame {

	private JPanel contentPane;
	private JTextField txtCME_codpaciente;
	private JTextField txtCME_nombres;
	private JTextField txtCME_apellidos;
	private JTextField txtCME_dni;
	private JTextField txtCME_celular;
	private JTextField txtCME_correo;
	private JTable tblListarPaciente;

	/**
	 * Create the frame.
	 */
	public GUIPacienteCME() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUIPacienteCME.class.getResource("/img/produccion (2).png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 661, 529);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodPaciente = new JLabel("codPaciente");
		lblCodPaciente.setBounds(20, 11, 73, 16);
		contentPane.add(lblCodPaciente);
		
		txtCME_codpaciente = new JTextField();
		txtCME_codpaciente.setEditable(false);
		txtCME_codpaciente.setColumns(10);
		txtCME_codpaciente.setBounds(103, 10, 96, 19);
		contentPane.add(txtCME_codpaciente);
		
		txtCME_nombres = new JTextField();
		txtCME_nombres.setColumns(10);
		txtCME_nombres.setBounds(82, 34, 288, 19);
		contentPane.add(txtCME_nombres);
		
		JLabel lblNewLabel_1 = new JLabel("Nombres");
		lblNewLabel_1.setBounds(20, 37, 52, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellidos");
		lblNewLabel_2.setBounds(20, 66, 52, 13);
		contentPane.add(lblNewLabel_2);
		
		txtCME_apellidos = new JTextField();
		txtCME_apellidos.setColumns(10);
		txtCME_apellidos.setBounds(82, 63, 288, 19);
		contentPane.add(txtCME_apellidos);
		
		txtCME_dni = new JTextField();
		txtCME_dni.setEditable(false);
		txtCME_dni.setColumns(10);
		txtCME_dni.setBounds(465, 34, 96, 19);
		contentPane.add(txtCME_dni);
		
		JLabel lblNewLabel_3 = new JLabel("DNI");
		lblNewLabel_3.setBounds(421, 37, 34, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Edad");
		lblNewLabel_4.setBounds(313, 96, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		txtCME_celular = new JTextField();
		txtCME_celular.setColumns(10);
		txtCME_celular.setBounds(465, 94, 96, 16);
		contentPane.add(txtCME_celular);
		
		JLabel lblNewLabel = new JLabel("Celular");
		lblNewLabel.setBounds(410, 96, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_5 = new JLabel("Correo");
		lblNewLabel_5.setBounds(20, 98, 45, 13);
		contentPane.add(lblNewLabel_5);
		
		txtCME_correo = new JTextField();
		txtCME_correo.setColumns(10);
		txtCME_correo.setBounds(82, 92, 221, 19);
		contentPane.add(txtCME_correo);
		
		JComboBox cmbCME_estado = new JComboBox();
		cmbCME_estado.setBounds(465, 62, 45, 21);
		contentPane.add(cmbCME_estado);
		
		JLabel lblNewLabel_6 = new JLabel("Estado");
		lblNewLabel_6.setBounds(410, 66, 45, 13);
		contentPane.add(lblNewLabel_6);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 199, 627, 283);
		contentPane.add(scrollPane);
		
		tblListarPaciente = new JTable();
		tblListarPaciente.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(tblListarPaciente);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(353, 92, 30, 20);
		contentPane.add(spinner);
		
		JButton btnPaciente_Consultar = new JButton("Consultar");
		btnPaciente_Consultar.setIcon(new ImageIcon(GUIPacienteCME.class.getResource("/img/consulta (1).png")));
		btnPaciente_Consultar.setBounds(82, 154, 117, 21);
		contentPane.add(btnPaciente_Consultar);
		
		JButton btnPaciente_Modificar = new JButton("Modificar");
		btnPaciente_Modificar.setBounds(248, 154, 85, 21);
		contentPane.add(btnPaciente_Modificar);
		
		JButton btn_Paciente_Eliminar = new JButton("Eliminar");
		btn_Paciente_Eliminar.setBounds(389, 154, 85, 21);
		contentPane.add(btn_Paciente_Eliminar);
	}
}
