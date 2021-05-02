package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class MenuPerfil extends JDialog {

	private final JPanel contentPanel = new JPanel();

	static String usuario;

	public static String datosUsuario(String user) {
		return user;
	}
	
	public static void mostrarMenuPerfil(JFrame menuprincipal) {
		MenuPerfil dialog = new MenuPerfil(menuprincipal);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}

	public MenuPerfil(JFrame menuprincipal) {
		
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				String Botones[] = {"Salir", "Cancelar"};
				int resultado = JOptionPane.showOptionDialog(null, "\u00bfEst\u00e1s seguro de que quieres salir de la aplicaci\u00f3n?", "SALIDA", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, Botones, Botones[1]);
				if (resultado == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuPerfil.class.getResource("/vista/icono.png")));
		setTitle("PLEITOMYK - PERFIL");
		setBounds(100, 100, 657, 474);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel textoTitulo = new JLabel("Perfil");
		textoTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		textoTitulo.setFont(new Font("Tahoma", Font.BOLD, 40));
		textoTitulo.setBounds(10, 29, 621, 59);
		getContentPane().add(textoTitulo);
		
		JButton botonCerrarSesion = new JButton("Cerrar sesi\u00F3n");
		botonCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Botones[] = { "Salir", "Volver" };
				int resultado = JOptionPane.showOptionDialog(null,
						"\u00bfSeguro que quieres cerrar la sesi\u00f3n?", "CERRAR SESI\u00d3N",
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, Botones, Botones[1]);
				if (resultado == JOptionPane.YES_OPTION) {
					dispose();
					MenuInicio.mostrarMenuInicio(MenuPrincipal.menuprincipal);
				}
			}
		});
		botonCerrarSesion.setBounds(30, 308, 164, 23);
		getContentPane().add(botonCerrarSesion);
		
		JButton botonCambiarUsuario = new JButton("Cambiar usuario");
		botonCambiarUsuario.setBounds(30, 240, 164, 23);
		getContentPane().add(botonCambiarUsuario);
		
		JButton botonCambiarClave = new JButton("Cambiar clave");
		botonCambiarClave.setBounds(30, 274, 164, 23);
		getContentPane().add(botonCambiarClave);
		
		JLabel textoUsuario = new JLabel(usuario);
		textoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		textoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoUsuario.setBounds(10, 99, 621, 14);
		getContentPane().add(textoUsuario);
		
		JButton botonVerDatos = new JButton("Ver datos");
		botonVerDatos.setBounds(30, 206, 164, 23);
		getContentPane().add(botonVerDatos);
		
		JButton botonVolver = new JButton("<<");
		botonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				menuprincipal.setVisible(true);
			}
		});
		botonVolver.setBounds(30, 400, 49, 23);
		getContentPane().add(botonVolver);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(256, 153, 340, 231);
		getContentPane().add(textArea);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	}
}
