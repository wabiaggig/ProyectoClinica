package gui;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
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
    
    // Paneles contenedores
    private JPanel panelSuperior;
    private JPanel panelInferior;

    private final String[] COLUMNAS_DETALLE = {"Nro", "Paciente", "Médico", "Consultorio", "Fecha", "Hora", "Estado"};
    private final String[] COLUMNAS_RESUMEN = {"Entidad (Médico/Consul)", "Total Citas", "Pendientes", "Atendidas"};

    /**
     * Create the frame.
     */
    public GUIReportes() {
        setTitle("Reportes y Consultas Médicas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 750, 500); // Tamaño total de la ventana
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // =======================================================
        // 1. PANEL SUPERIOR (Color Azul - Contiene los controles)
        // =======================================================
        panelSuperior = new JPanel();
        panelSuperior.setBounds(0, 0, 736, 125); // Ocupa la parte superior
        panelSuperior.setBackground(new Color(51, 153, 255));
        panelSuperior.setLayout(null);
        contentPane.add(panelSuperior);

        JLabel lblTitulo = new JLabel("MÓDULO DE REPORTES");
        lblTitulo.setForeground(Color.WHITE); // Texto blanco para contraste
        lblTitulo.setBounds(0, 11, 734, 20);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        panelSuperior.add(lblTitulo); // Agregado al panelSuperior

        JLabel lblSeleccion = new JLabel("Seleccione Reporte:");
        lblSeleccion.setForeground(Color.WHITE);
        lblSeleccion.setBounds(20, 50, 120, 14);
        lblSeleccion.setFont(new Font("Tahoma", Font.BOLD, 11));
        panelSuperior.add(lblSeleccion);

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
        panelSuperior.add(cmbTipoReporte);

        lblFiltroDinamico = new JLabel("Ingrese ID Paciente:");
        lblFiltroDinamico.setForeground(Color.WHITE);
        lblFiltroDinamico.setBounds(20, 85, 140, 14); // Un poco más ancho para textos largos
        lblFiltroDinamico.setFont(new Font("Tahoma", Font.BOLD, 11));
        panelSuperior.add(lblFiltroDinamico);

        txtFiltro = new JTextField();
        txtFiltro.setBounds(160, 82, 100, 20); // Ajustado posición X
        txtFiltro.setColumns(10);
        panelSuperior.add(txtFiltro);

        JButton btnConsultar = new JButton("Consultar");
        btnConsultar.setBackground(Color.WHITE); // Botón blanco
        btnConsultar.setBounds(280, 81, 110, 23);
        panelSuperior.add(btnConsultar);

        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBackground(Color.WHITE);
        btnLimpiar.setBounds(400, 81, 90, 23);
        panelSuperior.add(btnLimpiar);

        // =======================================================
        // 2. PANEL INFERIOR (Color Blanco/Gris - Contiene la Tabla)
        // =======================================================
        panelInferior = new JPanel();
        panelInferior.setBounds(0, 125, 736, 338); // Empieza donde termina el superior
        panelInferior.setBackground(Color.WHITE);
        panelInferior.setLayout(null);
        contentPane.add(panelInferior);

        JScrollPane scrollPane = new JScrollPane();
        // El scrollpane ocupa casi todo el panel inferior con un pequeño margen
        scrollPane.setBounds(10, 11, 716, 316); 
        scrollPane.setBorder(new LineBorder(new Color(51, 153, 255), 1)); // Borde azul sutil
        scrollPane.getViewport().setBackground(Color.WHITE);
        panelInferior.add(scrollPane); // Agregado al panelInferior

        tableReportes = new JTable();
        tableReportes.setFillsViewportHeight(true);
        model = new DefaultTableModel(new Object[][] {}, COLUMNAS_DETALLE);
        tableReportes.setModel(model);
        scrollPane.setViewportView(tableReportes);

        // =======================================================
        // LOGICA Y LISTENERS
        // =======================================================
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
        txtFiltro.setBackground(Color.WHITE);

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
                txtFiltro.setBackground(new Color(230, 230, 230)); // Gris cuando deshabilitado
                txtFiltro.setText("N/A");
                break;
        }
    }

    private void generarReporte() {
        int index = cmbTipoReporte.getSelectedIndex();
        // String filtro = txtFiltro.getText(); // Variable lista para usar en BD
        model.setRowCount(0); 
        
        if (index == 5 || index == 6) { 
            model.setColumnIdentifiers(COLUMNAS_RESUMEN);
        } else {
            model.setColumnIdentifiers(COLUMNAS_DETALLE);
        }

        // Simulación de lógica (Aquí irían tus llamadas a la base de datos)
        switch (index) {
            case 0: break;
            case 1: break;
            // ... resto de casos
        }
        
        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No se encontraron registros con los criterios ingresados.");
        }
    }
}