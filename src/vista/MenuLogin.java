package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
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
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class MenuLogin extends JDialog {

	private JPanel contentPane;
	private JTextField textUsuario;
	private JPasswordField password;

	public static void mostrarMenuSesion(JFrame menuprincipal) {
		MenuLogin iniciosesion = new MenuLogin(menuprincipal);
		iniciosesion.setVisible(true);
	}

	public MenuLogin(JFrame menuprincipal) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuLogin.class.getResource("/vista/icono.png")));
		setResizable(false);
		setTitle("PLEITOMYK - INICIAR SESI\u00d3N");
		setBounds(100, 100, 709, 445);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

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

		textUsuario = new JTextField();
		textUsuario.setBounds(402, 143, 190, 32);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);

		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(148, 138, 156, 30);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Contrase\u00f1a");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(148, 235, 156, 30);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Iniciar sesi\u00f3n");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel_2.setBounds(225, 45, 253, 41);
		contentPane.add(lblNewLabel_2);

		JButton btnIniciar = new JButton("Acceder");
		btnIniciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIniciar.setBackground(new java.awt.Color(225, 231, 31));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnIniciar.setBackground(new java.awt.Color(255, 250, 205));
			}
		});
		btnIniciar.setBackground(new Color(255, 250, 205));
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Lectura.leerDatosLogin(textUsuario.getText(), password.getText());
			}
		});
		btnIniciar.setBounds(280, 320, 131, 32);
		contentPane.add(btnIniciar);

		password = new JPasswordField();
		password.setBounds(402, 241, 190, 30);
		contentPane.add(password);

		JButton btnback = new JButton("<<");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				MenuInicio.mostrarMenuInicio(MenuPrincipal.menuprincipal);
			}
		});
		btnback.setBounds(10, 11, 53, 23);
		contentPane.add(btnback);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(MenuLogin.class.getResource("/vista/iniciosesion.png")));
		lblNewLabel_3.setBounds(0, 0, 703, 416);
		contentPane.add(lblNewLabel_3);
	}
}
