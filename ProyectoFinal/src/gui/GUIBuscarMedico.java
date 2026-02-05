package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Component;
import java.awt.Cursor;

import javax.swing.Box;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class GUIBuscarMedico extends JFrame {
	private JTextField txtDni;
	private JTable table;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIBuscarMedico frame = new GUIBuscarMedico();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUIBuscarMedico() {
		setTitle("Consultar Paciente");
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(new Color(51, 153, 255));
		panelSuperior.setBounds(0, 0, 728, 240);
		getContentPane().add(panelSuperior);
		panelSuperior.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(GUIBuscarMedico.class.getResource("/imagenes/tarjeta-de-identificacion.png")));
		lblNewLabel.setBounds(46, 22, 89, 72);
		panelSuperior.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Selecciona Tu Medico");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel_1.setBounds(134, 43, 294, 39);
		panelSuperior.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(46, 105, 659, 10);
		panelSuperior.add(separator);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(46, 126, 89, 39);
		panelSuperior.add(lblNewLabel_1_1);
		
		txtDni = new JTextField();
		txtDni.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtDni.setBounds(174, 139, 210, 20);
		panelSuperior.add(txtDni);
		txtDni.setColumns(10);
		
		JButton btnBuscarDni = new JButton("Buscar");
		btnBuscarDni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscarDni.setForeground(new Color(0, 0, 0));
		btnBuscarDni.setBackground(new Color(255, 255, 255));
		btnBuscarDni.setBounds(456, 188, 89, 23);
		panelSuperior.add(btnBuscarDni);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Especialidad");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(46, 176, 115, 39);
		panelSuperior.add(lblNewLabel_1_1_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(174, 188, 210, 22);
		panelSuperior.add(comboBox);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 203, 728, 388);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(0, 34, 728, 354);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cod Medico", "Nombre", "Apellido", "Especialidad", "Cmp", "Estado"
			}
		));
		
		
		scrollPane.setViewportView(table);
		setBounds(100, 100, 744, 630);
		
		
		
		
	}
}