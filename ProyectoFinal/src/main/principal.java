package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private gui.GUIPaciente guiPacienteFrame;
	private gui.GUIPacienteCME guiPacienteCMEFrame;
	private gui.GUIMedico guiMedicoFrame;
	private gui.GUIMedicoCME guiMedicoCMEFrame;
	private gui.GUIConsultorio guiConsultorioFrame;
	private gui.GUIConsultorioCME guiConsultorioCMEFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					principal frame = new principal();
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
	public principal() {
		setTitle("SISTEMA DE RESERVA DE CITAS MÉDICAS");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 600, 400);

		Font menuFont = new Font("Segoe UI", Font.PLAIN, 15);
		UIManager.put("Menu.font", menuFont);
		UIManager.put("MenuItem.font", menuFont);
		UIManager.put("MenuBar.font", menuFont);
		UIManager.put("PopupMenu.font", menuFont);
		UIManager.put("CheckBoxMenuItem.font", menuFont);
		UIManager.put("RadioButtonMenuItem.font", menuFont);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		try {
			Image iconImg = ImageIO.read(new File("doctor-icon-physician-symbol-vector.jpg"));
			if (iconImg == null)
				throw new IOException();
			setIconImage(iconImg);
		} catch (IOException e) {
			try (InputStream is = getClass().getResourceAsStream("/doctor-icon-physician-symbol-vector.jpg")) {
				if (is != null) {
					Image iconImg = ImageIO.read(is);
					setIconImage(iconImg);
				}
			} catch (IOException ex) {
				// ignore
			}
		}

		contentPane = new PanelFondo("fondo.png");

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(176, 196, 222));
		menuBar.setFont(menuFont);
		setJMenuBar(menuBar);

		JMenu mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setFont(menuFont);
		menuBar.add(mnMantenimiento);

		JMenu MPaciente = new JMenu("Paciente");
		MPaciente.setIcon(cargarIcono("paciente.png", 16, 16));
		MPaciente.setFont(menuFont);
		mnMantenimiento.add(MPaciente);

		JMenuItem SMPaciente_adicionar = new JMenuItem("Adicionar");
		SMPaciente_adicionar.setIcon(cargarIcono("signo-de-mas (1).png", 16, 16));
		SMPaciente_adicionar.setFont(menuFont);
		SMPaciente_adicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (guiPacienteFrame == null || !guiPacienteFrame.isDisplayable()) {
						guiPacienteFrame = new gui.GUIPaciente();
						ImageIcon icon = cargarIcono("paciente.png", 32, 32);
						if (icon != null) guiPacienteFrame.setIconImage(icon.getImage());
						guiPacienteFrame.setLocationRelativeTo(principal.this);
						guiPacienteFrame.addWindowListener(new WindowAdapter() {
							@Override
							public void windowClosed(WindowEvent e) {
								guiPacienteFrame = null;
							}
						});
						guiPacienteFrame.setVisible(true);
					} else {
						guiPacienteFrame.toFront();
						guiPacienteFrame.requestFocus();
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(principal.this, "No se pudo abrir Paciente (Adicionar): " + ex.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		MPaciente.add(SMPaciente_adicionar);

		JMenuItem SMPaciente_cme = new JMenuItem("Consultar, Modificar y Eliminar");
		SMPaciente_cme.setIcon(cargarIcono("produccion (2).png", 16, 16));
		SMPaciente_cme.setFont(menuFont);
		SMPaciente_cme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (guiPacienteCMEFrame == null || !guiPacienteCMEFrame.isDisplayable()) {
						guiPacienteCMEFrame = new gui.GUIPacienteCME();
						guiPacienteCMEFrame.setLocationRelativeTo(principal.this);
						guiPacienteCMEFrame.addWindowListener(new WindowAdapter() {
							@Override
							public void windowClosed(WindowEvent e) {
								guiPacienteCMEFrame = null;
							}
						});
						guiPacienteCMEFrame.setVisible(true);
					} else {
						guiPacienteCMEFrame.toFront();
						guiPacienteCMEFrame.requestFocus();
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(principal.this, "No se pudo abrir Paciente (CME): " + ex.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		MPaciente.add(SMPaciente_cme);

		JMenu MMedico = new JMenu("Medico");
		MMedico.setIcon(cargarIcono("medico.png", 16, 16));
		MMedico.setFont(menuFont);
		mnMantenimiento.add(MMedico);

		JMenuItem SMMedico_adicionar = new JMenuItem("Adicionar");
		SMMedico_adicionar.setIcon(cargarIcono("signo-de-mas (1).png", 16, 16));
		SMMedico_adicionar.setFont(menuFont);
		SMMedico_adicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (guiMedicoFrame == null || !guiMedicoFrame.isDisplayable()) {
						guiMedicoFrame = new gui.GUIMedico();
						ImageIcon icon = cargarIcono("medico.png", 32, 32);
						if (icon != null) guiMedicoFrame.setIconImage(icon.getImage());
						guiMedicoFrame.setLocationRelativeTo(principal.this);
						guiMedicoFrame.addWindowListener(new WindowAdapter() {
							@Override
							public void windowClosed(WindowEvent e) {
								guiMedicoFrame = null;
							}
						});
						guiMedicoFrame.setVisible(true);
					} else {
						guiMedicoFrame.toFront();
						guiMedicoFrame.requestFocus();
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(principal.this, "No se pudo abrir Medico (Adicionar): " + ex.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		MMedico.add(SMMedico_adicionar);

		JMenuItem SMMedico_cme = new JMenuItem("Consultar, Modificar y Eliminar");
		SMMedico_cme.setIcon(cargarIcono("produccion (2).png", 16, 16));
		SMMedico_cme.setFont(menuFont);
		SMMedico_cme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (guiMedicoCMEFrame == null || !guiMedicoCMEFrame.isDisplayable()) {
						guiMedicoCMEFrame = new gui.GUIMedicoCME();
						guiMedicoCMEFrame.setLocationRelativeTo(principal.this);
						guiMedicoCMEFrame.addWindowListener(new WindowAdapter() {
							@Override
							public void windowClosed(WindowEvent e) {
								guiMedicoCMEFrame = null;
							}
						});
						guiMedicoCMEFrame.setVisible(true);
					} else {
						guiMedicoCMEFrame.toFront();
						guiMedicoCMEFrame.requestFocus();
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(principal.this, "No se pudo abrir Medico (CME): " + ex.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		MMedico.add(SMMedico_cme);

		JMenu MConsultorio = new JMenu("Consultorio");
		MConsultorio.setIcon(cargarIcono("consultorio.png", 16, 16));
		MConsultorio.setFont(menuFont);
		mnMantenimiento.add(MConsultorio);

		JMenuItem SMConsultorio_adicionar = new JMenuItem("Adicionar");
		SMConsultorio_adicionar.setIcon(cargarIcono("signo-de-mas (1).png", 16, 16));
		SMConsultorio_adicionar.setFont(menuFont);
		SMConsultorio_adicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (guiConsultorioFrame == null || !guiConsultorioFrame.isDisplayable()) {
						guiConsultorioFrame = new gui.GUIConsultorio();
						ImageIcon icon = cargarIcono("consultorio.png", 32, 32);
						if (icon != null) guiConsultorioFrame.setIconImage(icon.getImage());
						guiConsultorioFrame.setLocationRelativeTo(principal.this);
						guiConsultorioFrame.addWindowListener(new WindowAdapter() {
							@Override
							public void windowClosed(WindowEvent e) {
								guiConsultorioFrame = null;
							}
						});
						guiConsultorioFrame.setVisible(true);
					} else {
						guiConsultorioFrame.toFront();
						guiConsultorioFrame.requestFocus();
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(principal.this, "No se pudo abrir Consultorio (Adicionar): " + ex.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		MConsultorio.add(SMConsultorio_adicionar);

		JMenuItem SMConsultorio_cme = new JMenuItem("Consultar, Modificar y Eliminar");
		SMConsultorio_cme.setIcon(cargarIcono("produccion (2).png", 16, 16));
		SMConsultorio_cme.setFont(menuFont);
		SMConsultorio_cme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (guiConsultorioCMEFrame == null || !guiConsultorioCMEFrame.isDisplayable()) {
						guiConsultorioCMEFrame = new gui.GUIConsultorioCME();
						guiConsultorioCMEFrame.setLocationRelativeTo(principal.this);
						guiConsultorioCMEFrame.addWindowListener(new WindowAdapter() {
							@Override
							public void windowClosed(WindowEvent e) {
								guiConsultorioCMEFrame = null;
							}
						});
						guiConsultorioCMEFrame.setVisible(true);
					} else {
						guiConsultorioCMEFrame.toFront();
						guiConsultorioCMEFrame.requestFocus();
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(principal.this, "No se pudo abrir Consultorio (CME): " + ex.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		MConsultorio.add(SMConsultorio_cme);

		JMenu mnRegistro = new JMenu("Registro");
		mnRegistro.setFont(menuFont);

		JMenuItem mntmRegistroCitas = new JMenuItem("Registro Citas");
		mntmRegistroCitas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.GUIRegistroCitas regFrame = new gui.GUIRegistroCitas();
				regFrame.setVisible(true);
			}
		});
		mntmRegistroCitas.setIcon(cargarIcono("registrocita.jpg", 16, 16));
		mntmRegistroCitas.setFont(menuFont);
		mnRegistro.add(mntmRegistroCitas);

		menuBar.add(mnRegistro);

		JMenu mnConsulta = new JMenu("Consulta");
		mnConsulta.setFont(menuFont);
		menuBar.add(mnConsulta);
		
		JMenuItem mntmConsultarMedico = new JMenuItem("Consultar Medico");
		mntmConsultarMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.GUIConsultarMedico consultarMedicoFrame = new gui.GUIConsultarMedico();
				consultarMedicoFrame.setVisible(true);
			}
		});
		mntmConsultarMedico.setIcon(cargarIcono("GUIConsultarMedico.png"
				+ "", 16, 16));
		mntmConsultarMedico.setFont(menuFont);
		mnConsulta.add(mntmConsultarMedico);
		
		JMenuItem mntmConsultarPaciente = new JMenuItem("Consultar Paciente");
		mntmConsultarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.GUIConsultarPaciente consultarPacienteFrame = new gui.GUIConsultarPaciente();
				consultarPacienteFrame.setVisible(true);
			}
		});
		mntmConsultarPaciente.setIcon(cargarIcono("GUIConsultarPaciente.png",
				16, 16));
		mntmConsultarPaciente.setFont(menuFont);
		mnConsulta.add(mntmConsultarPaciente);
		
		JMenuItem mntmConsultarConsultorio = new JMenuItem("Consultar Consultorio");
		mntmConsultarConsultorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.GUIConsultarConsultorio consultarConsultorioFrame = new gui.GUIConsultarConsultorio();
				consultarConsultorioFrame.setVisible(true);
			}
			});
		mntmConsultarConsultorio.setIcon(cargarIcono("GUIConsultarConsultorio.png",
				16, 16));
		mntmConsultarConsultorio.setFont(menuFont);
		mnConsulta.add(mntmConsultarConsultorio);
		
		

		JMenu mnReporte = new JMenu("Reporte");
		mnReporte.setFont(menuFont);
		menuBar.add(mnReporte);
		
		JMenuItem mntmGenerarReportes = new JMenuItem("Generar Reportes");
		mntmGenerarReportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.GUIReportes reportesFrame = new gui.GUIReportes();
				reportesFrame.setVisible(true);
			}
		});
		mntmGenerarReportes.setIcon(cargarIcono("reportes.png",
				16, 16));
		mntmGenerarReportes.setFont(menuFont);
		mnReporte.add(mntmGenerarReportes);
		

		JMenu mnExtra = new JMenu("Extra");
		mnExtra.setFont(menuFont);
		JMenuItem mntmAcerca = new JMenuItem("Acerca de");
		mntmAcerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(principal.this,
						"SISTEMA DE RESERVA DE CITAS MÉDICAS"
						+ "\n-----------------------------------------------------------"
						+ "\nDesarrollado por:"
						+ "\n\n- Maria Teresa Chipana Chavez - i202516086  "
						+ "\n- Williams Herles Vilchez Villanueva - i202518055 "
						+ "\n- Franklin Kevin Mori Rivera - i202518362"
						+ "\n- Jean Pierre Nureña Coronel - i201723942"
						+ "\n- Wilfredo Aaron Biaggi Gurreonero - i202516382"
						+ "\n\n2026 - Cibertec",
						"Acerca de", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mntmAcerca.setIcon(cargarIcono("doctor-icon-physician-symbol-vector.jpg", 16, 16));
		mntmAcerca.setFont(menuFont);
		mnExtra.add(mntmAcerca);
		menuBar.add(mnExtra);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int option = JOptionPane.showConfirmDialog(principal.this,
					"¿Está seguro que desea salir?", "Confirmar salida", JOptionPane.YES_NO_OPTION);
				if (option == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});

		JMenuItem mntmSalirConfirm = new JMenuItem("Salir");
		mntmSalirConfirm.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mntmSalirConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(principal.this,
					"¿Está seguro que desea salir?", "Confirmar salida", JOptionPane.YES_NO_OPTION);
				if (option == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		try {
			mnExtra.add(mntmSalirConfirm);
		} catch (Exception ex) {
			if (getJMenuBar() != null) {
				getJMenuBar().add(mntmSalirConfirm);
			}
		}
	}

	/**
	 * Helper to load and scale an icon from disk or classpath.
	 */
	private ImageIcon cargarIcono(String ruta, int w, int h) {
		try {
			Image img = ImageIO.read(new File(ruta));
			if (img != null) {
				Image scaled = img.getScaledInstance(w, h, Image.SCALE_SMOOTH);
				return new ImageIcon(scaled);
			}
		} catch (IOException e) {
			// fall through to try resource
		}
		try (InputStream is = getClass().getResourceAsStream("/" + ruta)) {
			if (is != null) {
				Image img = ImageIO.read(is);
				if (img != null) {
					Image scaled = img.getScaledInstance(w, h, Image.SCALE_SMOOTH);
					return new ImageIcon(scaled);
				}
			}
		} catch (IOException e) {
		}
		return null;
	}

	class PanelFondo extends JPanel {
		private static final long serialVersionUID = 1L;
		private Image imagen;

		public PanelFondo(String ruta) {
			try {
				imagen = ImageIO.read(new File(ruta));
			} catch (IOException e) {
				try (InputStream is = getClass().getResourceAsStream("/" + ruta)) {
					if (is != null) {
						imagen = ImageIO.read(is);
					} else {
						System.err.println("Advertencia: recurso no encontrado en classpath: /" + ruta);
					}
				} catch (IOException ex) {
					System.err.println("Error leyendo recurso de clase: " + ex.getMessage());
				}
			}

			setOpaque(true);
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			if (imagen != null) {
				g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
			}
		}
	}
}
