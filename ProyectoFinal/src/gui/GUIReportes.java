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

    // Constantes para las columnas
    private final String[] COLUMNAS_DETALLE = {"Nro", "Paciente", "Médico", "Consultorio", "Fecha", "Hora", "Estado"};
    private final String[] COLUMNAS_RESUMEN = {"Entidad (Médico/Consul)", "Total Citas", "Pendientes", "Atendidas"};
    private JPanel panelSuperior;

    public GUIReportes() {
        setTitle("Reportes y Consultas Médicas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 750, 500); // Un poco más ancha para ver datos
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // --- TÍTULO ---
        JLabel lblTitulo = new JLabel("MÓDULO DE REPORTES");
        lblTitulo.setBounds(0, 11, 734, 20);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblTitulo);

        // --- SELECTOR DE REPORTE ---
        JLabel lblSeleccion = new JLabel("Seleccione Reporte:");
        lblSeleccion.setBounds(20, 50, 120, 14);
        lblSeleccion.setFont(new Font("Tahoma", Font.BOLD, 11));
        contentPane.add(lblSeleccion);

        cmbTipoReporte = new JComboBox<>();
        cmbTipoReporte.setBounds(140, 47, 250, 22);
        // Ordenados según tu requerimiento
        cmbTipoReporte.setModel(new DefaultComboBoxModel<>(new String[] {
            "1. Historial por Paciente",          // Requiere filtro (DNI/Cod)
            "2. Agenda por Médico",               // Requiere filtro (Cod Medico)
            "3. Ocupación por Consultorio",       // Requiere filtro (Cod Cons)
            "4. Listado por Fecha",               // Requiere filtro (Fecha)
            "5. Pacientes con Citas Pendientes",  // Sin filtro (General)
            "6. Resumen Citas por Médico",        // Totales (Estadístico)
            "7. Ocupación Diaria Consultorio",    // Totales
            "8. Agenda del Día (Hoy)"             // Automático fecha actual
        }));
        contentPane.add(cmbTipoReporte);

        // --- FILTRO DINÁMICO (Cambia según lo que selecciones arriba) ---
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
        
        // Botón extra para exportar o limpiar (opcional)
        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(400, 81, 90, 23);
        contentPane.add(btnLimpiar);

        // --- TABLA DE RESULTADOS ---
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 125, 739, 337);
        contentPane.add(scrollPane);
        scrollPane.setBorder(null);
		scrollPane.setBackground(new Color(255, 255, 255));

        tableReportes = new JTable();
        model = new DefaultTableModel(new Object[][] {}, COLUMNAS_DETALLE);
        tableReportes.setModel(model);
        
        // Ajustes visuales de la tabla
        tableReportes.setBackground(Color.WHITE);
        scrollPane.setViewportView(tableReportes);
        
        panelSuperior = new JPanel();
        panelSuperior.setBounds(-67, -2, 916, 128);
        panelSuperior.setBackground(new Color(51, 153, 255));
        contentPane.add(panelSuperior);
        panelSuperior.setLayout(null);

        // ============================================================
        // LÓGICA DE EVENTOS
        // ============================================================

        // 1. CAMBIAR ETIQUETA DEL FILTRO SEGÚN SELECCIÓN
        cmbTipoReporte.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    actualizarInterfazFiltro();
                }
            }
        });

        // 2. BOTÓN CONSULTAR (El cerebro del reporte)
        btnConsultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generarReporte();
            }
        });
        
        // 3. BOTÓN LIMPIAR
        btnLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtFiltro.setText("");
                model.setRowCount(0);
                txtFiltro.requestFocus();
            }
        });
        
        // Inicializar etiqueta correcta
        actualizarInterfazFiltro();
    }

    // ============================================================
    // MÉTODOS AUXILIARES (Lógica de Negocio)
    // ============================================================

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
                txtFiltro.setEnabled(false); // Bloqueamos porque no necesita escribir nada
                txtFiltro.setText("N/A");
                break;
        }
    }

    private void generarReporte() {
        int index = cmbTipoReporte.getSelectedIndex();
        String filtro = txtFiltro.getText();
        
        // Limpiamos la tabla antes de cargar nuevos datos
        model.setRowCount(0); 
        
        // Configurar las columnas adecuadas según el reporte
        if (index == 5 || index == 6) { 
            // Reportes Estadísticos (Totales)
            model.setColumnIdentifiers(COLUMNAS_RESUMEN);
        } else {
            // Reportes Detallados (Listas de citas)
            model.setColumnIdentifiers(COLUMNAS_DETALLE);
        }

        // AQUÍ CONECTARÍAS CON TU ARRAYLIST O BASE DE DATOS
        // Ejemplo simulado:
        
        switch (index) {
            case 0: // Por Paciente
                // for(Cita c : listaCitas) { 
                //    if(c.getIdPaciente().equals(filtro)) agregarFila(c); 
                // }
                break;
            case 1: // Por Médico
                // for(Cita c : listaCitas) {
                //    if(c.getIdMedico().equals(filtro)) agregarFila(c);
                // }
                break;
            case 3: // Por Fecha
                // for(Cita c : listaCitas) {
                //    if(c.getFecha().equals(filtro)) agregarFila(c);
                // }
                break;
            case 4: // Pendientes
                // for(Cita c : listaCitas) {
                //    if(c.getEstado() == 0) agregarFila(c); // 0 = Pendiente
                // }
                break;
            case 8: // Agenda del día (Automático)
                // String hoy = obtenerFechaDelSistema();
                // for(Cita c : listaCitas) {
                //    if(c.getFecha().equals(hoy)) agregarFila(c);
                // }
                break;
                
            // Puedes agregar más casos...
        }
        
        // Mensaje si no hay datos (Simulado)
        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No se encontraron registros con los criterios ingresados.");
        }
    }
}