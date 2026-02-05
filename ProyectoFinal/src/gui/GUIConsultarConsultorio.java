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
import javax.swing.JTabbedPane;

public class GUIConsultarConsultorio extends JFrame {
	private JTable table;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIConsultarConsultorio frame = new GUIConsultarConsultorio();
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
	public GUIConsultarConsultorio() {
		setTitle("Consultar Por Consultorio");
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(new Color(51, 153, 255));
		panelSuperior.setBounds(0, 0, 728, 74);
		getContentPane().add(panelSuperior);
		panelSuperior.setLayout(null);
		
		//añadio
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        formato.setLenient(false);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBorder(null);
		comboBox_1.setBackground(new Color(255, 255, 255));
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Semanal", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"}));
		comboBox_1.setBounds(498, 26, 162, 22);
		panelSuperior.add(comboBox_1);
		
		btnNewButton = new JButton("Del Dia");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(28, 25, 118, 23);
		panelSuperior.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Citas ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(281, 16, 159, 34);
		panelSuperior.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 74, 728, 396);
		getContentPane().add(scrollPane);
		scrollPane.setBorder(null);
		scrollPane.setBackground(new Color(255, 255, 255));
		
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
		setBounds(100, 100, 744, 504);
		
		
		
		
	}
}