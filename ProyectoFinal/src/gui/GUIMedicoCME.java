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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class GUIMedicoCME extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable tblListarMedico;

	/**
	 * Create the frame.
	 */
	public GUIMedicoCME() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUIMedicoCME.class.getResource("/img/produccion (2).png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 714, 529);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodmedico = new JLabel("codMedico");
		lblCodmedico.setBounds(10, 11, 73, 16);
		contentPane.add(lblCodmedico);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(93, 10, 96, 19);
		contentPane.add(textField);
		
		JLabel lblNewLabel_1 = new JLabel("Nombres");
		lblNewLabel_1.setBounds(199, 13, 52, 13);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(246, 10, 238, 19);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellidos");
		lblNewLabel_2.setBounds(10, 47, 52, 13);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(61, 44, 196, 19);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_3 = new JLabel("CMP");
		lblNewLabel_3.setBounds(273, 47, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(304, 44, 96, 19);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_6 = new JLabel("Estado");
		lblNewLabel_6.setBounds(494, 13, 45, 13);
		contentPane.add(lblNewLabel_6);
		
		JComboBox cmbMedico_estado = new JComboBox();
		cmbMedico_estado.setBounds(533, 11, 45, 16);
		contentPane.add(cmbMedico_estado);
		
		JLabel lblNewLabel_5 = new JLabel("Especialidad");
		lblNewLabel_5.setBounds(410, 47, 83, 13);
		contentPane.add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(473, 44, 217, 19);
		contentPane.add(textField_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 158, 667, 324);
		contentPane.add(scrollPane);
		
		tblListarMedico = new JTable();
		tblListarMedico.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(tblListarMedico);
		
		JButton btnMedico_consultar = new JButton("Consultar");
		btnMedico_consultar.setIcon(new ImageIcon(GUIMedicoCME.class.getResource("/img/consulta (1).png")));
		btnMedico_consultar.setBounds(126, 107, 125, 21);
		contentPane.add(btnMedico_consultar);
		
		JButton btnMedico_modificar = new JButton("Modificar");
		btnMedico_modificar.setBounds(293, 107, 107, 21);
		contentPane.add(btnMedico_modificar);
		
		JButton btnMedico_eliminar = new JButton("Eliminar");
		btnMedico_eliminar.setBounds(435, 107, 85, 21);
		contentPane.add(btnMedico_eliminar);
	}

}