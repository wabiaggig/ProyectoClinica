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

public class GUIConsultarMedico extends JFrame {
	private JTable table;
	private JFormattedTextField txtFecha;

	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIConsultarMedico frame = new GUIConsultarMedico();
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
	public GUIConsultarMedico() {
		setTitle("Consultar Agenda Medica");
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(new Color(51, 153, 255));
		panelSuperior.setBounds(0, 0, 728, 154);
		getContentPane().add(panelSuperior);
		panelSuperior.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(46, 105, 659, 10);
		panelSuperior.add(separator);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cita Del Dia:");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(66, 44, 117, 39);
		panelSuperior.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(GUIConsultarMedico.class.getResource("/imagenes/fecha.png")));
		lblNewLabel_3.setBounds(37, 41, 32, 46);
		panelSuperior.add(lblNewLabel_3);
		
		//añadio
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        formato.setLenient(false);
		
		txtFecha = new JFormattedTextField(formato);
		txtFecha.setBounds(190, 57, 162, 20);
		
		txtFecha.setValue(new Date()); // fecha actual
	    txtFecha.setColumns(10);
		panelSuperior.add(txtFecha);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 153, 728, 404);
		getContentPane().add(scrollPane);
		scrollPane.setBorder(null);
		scrollPane.setBackground(new Color(255, 255, 255));
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Hora", "Paciente", "Medico", "Estado"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		
		scrollPane.setViewportView(table);
		setBounds(100, 100, 744, 596);
		
		
		
		
	}
}