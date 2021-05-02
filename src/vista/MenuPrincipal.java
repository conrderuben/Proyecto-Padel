package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;

public class MenuPrincipal extends JFrame {
	public static void DatosUsuario() {

	}

	static String usuario;

	public static String datosUsuario(String user) {
		return user;
	}

	public static MenuPrincipal menuprincipal = new MenuPrincipal(usuario);
	private JPanel contentPane;

	public MenuPrincipal(String usuario) {
		String user;

		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/vista/icono.png")));
//	 	setIconImage(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/img/key.png")));
//	 	this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/key.png")));
		setTitle("PLEITOMYK");
		setBounds(100, 100, 849, 587);
		setLocationRelativeTo(null);

		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				String Botones[] = { "Salir", "Cancelar" };
				int resultado = JOptionPane.showOptionDialog(null,
						"\u00bfEst\u00e1s seguro de que quieres salir de la aplicaci\u00f3n?", "SALIDA",
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, Botones, Botones[1]);
				if (resultado == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});

		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBounds(0, 0, 171, 22);
		contentPane.add(menuBar);
		
		JMenu menuInicio = new JMenu("Inicio");
		menuBar.add(menuInicio);
		
		JMenuItem menuItemCosas = new JMenuItem("Cosas");
		menuItemCosas.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/vista/vaya.png")));
		menuInicio.add(menuItemCosas);
		
		JMenu menuTienda = new JMenu("Tienda");
		menuBar.add(menuTienda);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Palas y paleteros");
		mntmNewMenuItem.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/vista/palapadel.png")));
		menuTienda.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Pelotas");
		mntmNewMenuItem_1.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/vista/pelota.png")));
		menuTienda.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Mochilas");
		mntmNewMenuItem_2.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/vista/mochila.png")));
		menuTienda.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Ropa");
		mntmNewMenuItem_3.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/vista/camiseta.png")));
		menuTienda.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Carrito");
		mntmNewMenuItem_4.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/vista/carrito.png")));
		menuTienda.add(mntmNewMenuItem_4);
		
		JMenu menuInformacion = new JMenu("Informaci\u00F3n");
		menuBar.add(menuInformacion);
		
		JMenuItem menuItemSoporte = new JMenuItem("Soporte");
		menuItemSoporte.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/vista/mensaje.png")));
		menuInformacion.add(menuItemSoporte);
		
		JMenuItem menuItemSobreNosotros = new JMenuItem("Sobre nosotros");
		menuItemSobreNosotros.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/vista/info.png")));
		menuInformacion.add(menuItemSobreNosotros);

		JLabel textoTitulo = new JLabel("PLEITOMYK");
		textoTitulo.setForeground(new Color(51, 204, 51));
		textoTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		textoTitulo.setFont(new Font("Sitka Subheading", Font.BOLD, 48));
		textoTitulo.setBounds(258, 54, 321, 87);
		contentPane.add(textoTitulo);

		JLabel nombreUsuario = new JLabel();
		nombreUsuario.setVisible(false);
		nombreUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		nombreUsuario.setForeground(new Color(51, 204, 51));
		nombreUsuario.setBackground(Color.CYAN);
		nombreUsuario.setBounds(26, 497, 269, 40);
		contentPane.add(nombreUsuario);
		
		JButton btnHacerReserva = new JButton("Hacer una reserva");
		btnHacerReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuprincipal.setVisible(false);
				MenuHacerReserva.mostrarMenuHacerReserva(menuprincipal);

			}
		});
		btnHacerReserva.setBounds(321, 164, 180, 33);
		contentPane.add(btnHacerReserva);

		JButton btnReservas = new JButton("Tus reservas");
		btnReservas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuprincipal.setVisible(false);
				MenuVerReservas.usuario = MenuVerReservas.datosUsuario(MenuPrincipal.usuario);
				MenuVerReservas.mostrarMenuVerReservas(menuprincipal);
			}
		});
		btnReservas.setBounds(321, 230, 180, 33);
		contentPane.add(btnReservas);

		JButton btnConsultaRecinto = new JButton("Consultar recintos");
		btnConsultaRecinto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuprincipal.setVisible(false);
				MenuVerRecintos.usuario = MenuVerRecintos.datosUsuario(MenuPrincipal.usuario);
				MenuVerRecintos.mostrarMenuVerRecintos(menuprincipal);
			}
		});
		btnConsultaRecinto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				nombreUsuario.setText("- Bienvenido, "+MenuPrincipal.usuario);
				nombreUsuario.setVisible(true);
			}
		});
		btnConsultaRecinto.setBounds(321, 291, 180, 33);
		contentPane.add(btnConsultaRecinto);

		JButton btnEquipo = new JButton("Equipo");
		btnEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuprincipal.setVisible(false);
				MenuEquipos.mostrarMenuEquipos(menuprincipal);
			}
		});
		btnEquipo.setBounds(321, 353, 180, 33);
		contentPane.add(btnEquipo);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				nombreUsuario.setText("- Bienvenido, "+MenuPrincipal.usuario);
				nombreUsuario.setVisible(true);
			}
		});
		
				JButton btnPerfil = new JButton("Perfil");
				btnPerfil.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						menuprincipal.setVisible(false);
						MenuPerfil.usuario = MenuPerfil.datosUsuario(MenuPrincipal.usuario);
						MenuPerfil.mostrarMenuPerfil(menuprincipal);
					}
				});
				btnPerfil.setBounds(321, 415, 180, 33);
				contentPane.add(btnPerfil);
		lblNewLabel_1_1.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/vista/Menuprincipal.jpg")));
		lblNewLabel_1_1.setBounds(0, 0, 834, 548);
		contentPane.add(lblNewLabel_1_1);
	}
}
