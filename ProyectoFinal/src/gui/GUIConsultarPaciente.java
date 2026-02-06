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

public class GUIConsultarPaciente extends JFrame {
	private JTextField txtDni;
	private JTable table;

	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIConsultarPaciente frame = new GUIConsultarPaciente();
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
	public GUIConsultarPaciente() {
		setTitle("Consultar Paciente");
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(new Color(51, 153, 255));
		panelSuperior.setBounds(0, 0, 728, 202);
		getContentPane().add(panelSuperior);
		panelSuperior.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(GUIConsultarPaciente.class.getResource("/imagenes/tarjeta-de-identificacion.png")));
		lblNewLabel.setBounds(46, 22, 89, 72);
		panelSuperior.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Buscar Paciente");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_1.setBounds(134, 43, 248, 39);
		panelSuperior.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(46, 105, 659, 10);
		panelSuperior.add(separator);
		
		JLabel lblNewLabel_1_1 = new JLabel("Buscar Por DNI");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(46, 126, 140, 39);
		panelSuperior.add(lblNewLabel_1_1);
		
		txtDni = new JTextField();
		txtDni.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtDni.setBounds(204, 139, 248, 20);
		panelSuperior.add(txtDni);
		txtDni.setColumns(10);
		
		JButton btnBuscarDni = new JButton("Buscar");
		btnBuscarDni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//aqui ira el codigo que buscara al paciente y cargue al jtable
			}
		});
		btnBuscarDni.setForeground(new Color(0, 0, 0));
		btnBuscarDni.setBackground(new Color(255, 255, 255));
		btnBuscarDni.setBounds(473, 138, 89, 23);
		panelSuperior.add(btnBuscarDni);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 203, 728, 388);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Citas De:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(74, 23, 71, 35);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(GUIConsultarPaciente.class.getResource("/imagenes/usuario24x24.png")));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(39, 28, 24, 24);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNamePaciente = new JLabel("JeanPierre ");
		lblNamePaciente.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNamePaciente.setBounds(139, 23, 192, 35);
		panel.add(lblNamePaciente);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(39, 69, 663, 288);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Fecha", "Hora", "Estado", "Medico", "Consultorio"
			}
		));
		
		
		scrollPane.setViewportView(table);
		setBounds(100, 100, 744, 630);
		
		
		
		
	}
}