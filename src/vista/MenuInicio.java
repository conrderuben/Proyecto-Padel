package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuInicio extends JDialog {

	private JPanel contentPane;
	public static void mostrarMenuInicio(JFrame menuprincipal) {
		MenuInicio menuregistro = new MenuInicio(menuprincipal);
		menuregistro.setVisible(true);
	}

	public MenuInicio(JFrame menusecundario) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuInicio.class.getResource("/vista/icono.png")));
//		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuInicio.class.getResource("/img/key.ico")));
		setResizable(false);
		setTitle("PLEITOMYK");
		setBounds(100, 100, 600, 366);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(144, 238, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
			@Override
			public void windowOpened(WindowEvent e) {
				getContentPane().requestFocusInWindow();
			}
		});
		
		JButton btnIniciarSesion = new JButton("Iniciar sesi\u00f3n");
		btnIniciarSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIniciarSesion.setBackground(new java.awt.Color(226,178,239));
				
			}
			
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnIniciarSesion.setBackground(new java.awt.Color(216,191,216));
			}
		});
		btnIniciarSesion.setBackground(new Color(216, 191, 216));
		btnIniciarSesion.setFont(new Font("Ebrima", Font.PLAIN, 20));
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				MenuLogin.mostrarMenuSesion(MenuPrincipal.menuprincipal);
			}
		});
		btnIniciarSesion.setBounds(199, 158, 171, 52);
		contentPane.add(btnIniciarSesion);
		
		JButton btnIniciarSesion_1 = new JButton("Registrarse");
		btnIniciarSesion_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIniciarSesion_1.setBackground(new java.awt.Color(226,178,239));
				
			}
			
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnIniciarSesion_1.setBackground(new java.awt.Color(216,191,216));
			}
		});
		btnIniciarSesion_1.setBackground(new Color(216, 191, 216));
		btnIniciarSesion_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				MenuRegistroUno.mostrarRegistro(MenuPrincipal.menuprincipal);
			}
		});
		btnIniciarSesion_1.setFont(new Font("Ebrima", Font.PLAIN, 20));
		btnIniciarSesion_1.setBounds(199, 238, 171, 52);
		contentPane.add(btnIniciarSesion_1);
		
		JLabel lblNewLabel = new JLabel("PLEITOMYK");
		lblNewLabel.setFont(new Font("SimSun-ExtB", Font.PLAIN, 43));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(98, 33, 373, 82);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MenuInicio.class.getResource("/vista/inicio.jpg")));
		lblNewLabel_1.setBounds(0, 0, 594, 337);
		contentPane.add(lblNewLabel_1);
	}
}
