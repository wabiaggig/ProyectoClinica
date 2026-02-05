package gui;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Font;
import java.awt.Color;

public class GUIReportes extends JFrame {

    private JPanel contentPane;
    private JTable tableReportes;
    private DefaultTableModel model;
    private JTextField txtFiltro;
    private JComboBox<String> cmbTipoReporte;
    private JLabel lblFiltroDinamico;

    private final String[] COLUMNAS_DETALLE = {"Nro", "Paciente", "Médico", "Consultorio", "Fecha", "Hora", "Estado"};
    private final String[] COLUMNAS_RESUMEN = {"Entidad (Médico/Consul)", "Total Citas", "Pendientes", "Atendidas"};
    private JPanel panelSuperior;

	/**
	 * Create the frame.
	 */
    public GUIReportes() {
        setTitle("Reportes y Consultas Médicas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 750, 500); 
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitulo = new JLabel("MÓDULO DE REPORTES");
        lblTitulo.setBounds(0, 11, 734, 20);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblTitulo);

        JLabel lblSeleccion = new JLabel("Seleccione Reporte:");
        lblSeleccion.setBounds(20, 50, 120, 14);
        lblSeleccion.setFont(new Font("Tahoma", Font.BOLD, 11));
        contentPane.add(lblSeleccion);

        cmbTipoReporte = new JComboBox<>();
        cmbTipoReporte.setBounds(140, 47, 250, 22);
        cmbTipoReporte.setModel(new DefaultComboBoxModel<>(new String[] {
            "1. Historial por Paciente",          
            "2. Agenda por Médico",               
            "3. Ocupación por Consultorio",       
            "4. Listado por Fecha",              
            "5. Pacientes con Citas Pendientes",  
            "6. Resumen Citas por Médico",       
            "7. Ocupación Diaria Consultorio",   
            "8. Agenda del Día (Hoy)"            
        }));
        contentPane.add(cmbTipoReporte);

        lblFiltroDinamico = new JLabel("Ingrese ID Paciente:");
        lblFiltroDinamico.setBounds(20, 85, 120, 14);
        contentPane.add(lblFiltroDinamico);

        txtFiltro = new JTextField();
        txtFiltro.setBounds(140, 82, 120, 20);
        contentPane.add(txtFiltro);
        txtFiltro.setColumns(10);

        JButton btnConsultar = new JButton("Consultar");
        btnConsultar.setBounds(280, 81, 110, 23);
        btnConsultar.setIcon(null);
        contentPane.add(btnConsultar);
        

        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(400, 81, 90, 23);
        contentPane.add(btnLimpiar);


        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 125, 739, 337);
        contentPane.add(scrollPane);
        scrollPane.setBorder(null);
		scrollPane.setBackground(new Color(255, 255, 255));

        tableReportes = new JTable();
        model = new DefaultTableModel(new Object[][] {}, COLUMNAS_DETALLE);
        tableReportes.setModel(model);
        

        tableReportes.setBackground(Color.WHITE);
        scrollPane.setViewportView(tableReportes);
        
        panelSuperior = new JPanel();
        panelSuperior.setBounds(-67, -2, 916, 128);
        panelSuperior.setBackground(new Color(51, 153, 255));
        contentPane.add(panelSuperior);
        panelSuperior.setLayout(null);

        cmbTipoReporte.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    actualizarInterfazFiltro();
                }
            }
        });

        btnConsultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generarReporte();
            }
        });
        

        btnLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtFiltro.setText("");
                model.setRowCount(0);
                txtFiltro.requestFocus();
            }
        });
        
        actualizarInterfazFiltro();
    }
private void actualizarInterfazFiltro() {
        int index = cmbTipoReporte.getSelectedIndex();
        txtFiltro.setText("");
        txtFiltro.setEnabled(true);
        
        switch (index) {
            case 0: lblFiltroDinamico.setText("ID Paciente:"); break;
            case 1: lblFiltroDinamico.setText("ID Médico:"); break;
            case 2: lblFiltroDinamico.setText("ID Consultorio:"); break;
            case 3: lblFiltroDinamico.setText("Fecha (dd/mm/aaaa):"); break;
            case 4: // Pendientes
            case 5: // Resumen Medico
            case 6: // Ocupacion Diario
            case 7: // Agenda Hoy
                lblFiltroDinamico.setText("Sin filtro necesario:"); 
                txtFiltro.setEnabled(false);
                txtFiltro.setText("N/A");
                break;
        }
    }

    private void generarReporte() {
        int index = cmbTipoReporte.getSelectedIndex();
        String filtro = txtFiltro.getText();
        model.setRowCount(0); 
        
        if (index == 5 || index == 6) { 
            model.setColumnIdentifiers(COLUMNAS_RESUMEN);
        } else {
            model.setColumnIdentifiers(COLUMNAS_DETALLE);
        }

        switch (index) {
            case 0: 
                break;
            case 1: 
                break;
            case 3:
                break;
            case 4: 
                break;
            case 8: 
                break;
        }
        
        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No se encontraron registros con los criterios ingresados.");
        }
    }
}