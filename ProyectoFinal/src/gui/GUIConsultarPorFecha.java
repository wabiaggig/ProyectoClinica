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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class GUIConsultarPorFecha extends JFrame {
	private JTable table;
	private JFormattedTextField txtFecha;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIConsultarPorFecha frame = new GUIConsultarPorFecha();
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
	public GUIConsultarPorFecha() {
		setTitle("Consultar Agenda Medica");
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(new Color(51, 153, 255));
		panelSuperior.setBounds(0, 0, 728, 204);
		getContentPane().add(panelSuperior);
		panelSuperior.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(46, 105, 659, 10);
		panelSuperior.add(separator);
		
		JLabel lblNewLabel_1_1 = new JLabel("Agenda De:");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1_1.setBounds(107, 44, 144, 39);
		panelSuperior.add(lblNewLabel_1_1);
		
		JLabel lblMedico = new JLabel("Dr. JeanPierre Nureña");
		lblMedico.setForeground(Color.WHITE);
		lblMedico.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMedico.setBounds(253, 46, 233, 39);
		panelSuperior.add(lblMedico);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(GUIConsultarPorFecha.class.getResource("/imagenes/3952988.png")));
		lblNewLabel_3.setBounds(45, 33, 46, 53);
		panelSuperior.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Fecha:");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(46, 137, 59, 39);
		panelSuperior.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Estado:");
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_1_1.setBounds(314, 137, 65, 39);
		panelSuperior.add(lblNewLabel_1_1_1_1);
		
		comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Pendiente", "Atendida", "Cancelado"}));
		comboBox.setBounds(389, 148, 131, 22);
		panelSuperior.add(comboBox);
		
		//añadio
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        formato.setLenient(false);
		
		txtFecha = new JFormattedTextField(formato);
		txtFecha.setBounds(115, 149, 162, 20);
		
		txtFecha.setValue(new Date()); // fecha actual
	    txtFecha.setColumns(10);
		panelSuperior.add(txtFecha);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 203, 728, 388);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(0, 0, 728, 354);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Hora", "Paciente", "Consultorio"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		
		scrollPane.setViewportView(table);
		setBounds(100, 100, 744, 596);
		
		
		
		
	}
}