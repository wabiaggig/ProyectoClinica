package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class GUIConsultorioCME extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable tblListarConsultorio;

	/**
	 * Create the frame.
	 */
	public GUIConsultorioCME() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUIConsultorioCME.class.getResource("/img/produccion (2).png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 806, 618);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodconsultorio = new JLabel("codConsultorio");
		lblCodconsultorio.setBounds(10, 21, 107, 16);
		contentPane.add(lblCodconsultorio);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(109, 20, 140, 19);
		contentPane.add(textField);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(259, 23, 52, 13);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(300, 20, 217, 19);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_2 = new JLabel("Piso");
		lblNewLabel_2.setBounds(10, 52, 52, 13);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(45, 49, 204, 19);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_6 = new JLabel("Estado");
		lblNewLabel_6.setBounds(552, 23, 45, 13);
		contentPane.add(lblNewLabel_6);
		
		JComboBox cmbConsultorio_estado = new JComboBox();
		cmbConsultorio_estado.setBounds(607, 21, 83, 16);
		contentPane.add(cmbConsultorio_estado);
		
		JLabel lblNewLabel_3 = new JLabel("Capacidad");
		lblNewLabel_3.setBounds(259, 52, 65, 13);
		contentPane.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(321, 49, 196, 19);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(321, 78, 379, 19);
		contentPane.add(textField_4);
		
		JLabel lblNewLabel_5 = new JLabel("Ubicacion");
		lblNewLabel_5.setBounds(259, 81, 83, 13);
		contentPane.add(lblNewLabel_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 167, 759, 404);
		contentPane.add(scrollPane);
		
		tblListarConsultorio = new JTable();
		tblListarConsultorio.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(tblListarConsultorio);
		
		JButton btnConsultorio_consultar = new JButton("Consultar");
		btnConsultorio_consultar.setIcon(new ImageIcon(GUIConsultorioCME.class.getResource("/img/consulta (1).png")));
		btnConsultorio_consultar.setBounds(122, 124, 127, 21);
		contentPane.add(btnConsultorio_consultar);
		
		JButton btnConsultorio_modificar = new JButton("Modificar");
		btnConsultorio_modificar.setBounds(305, 124, 127, 21);
		contentPane.add(btnConsultorio_modificar);
		
		JButton btnConsultorio_elminar = new JButton("Eliminar");
		btnConsultorio_elminar.setBounds(539, 124, 85, 21);
		contentPane.add(btnConsultorio_elminar);
	}
}