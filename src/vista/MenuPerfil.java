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
import java.awt.event.ActionEvent;

public class MenuPerfil extends JDialog {

	private final JPanel contentPanel = new JPanel();

	static String usuario;

	public static String datosUsuario(String user) {
		return user;
	}
	
	public static void mostrarMenuPerfil(JFrame menuprincipal) {
		MenuPerfil dialog = new MenuPerfil();
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}

	public MenuPerfil() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuPerfil.class.getResource("/vista/icono.png")));
		setTitle("PLEITOMYK - PERFIL");
		setBounds(100, 100, 657, 474);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel_1 = new JLabel("Perfil");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel_1.setBounds(10, 29, 621, 59);
		getContentPane().add(lblNewLabel_1);
		
		JButton cerrarSesion = new JButton("Cerrar sesi\u00F3n");
		cerrarSesion.addActionListener(new ActionListener() {
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
		cerrarSesion.setBounds(30, 308, 164, 23);
		getContentPane().add(cerrarSesion);
		
		JButton btnNewButton_1 = new JButton("Cambiar usuario");
		btnNewButton_1.setBounds(30, 240, 164, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cambiar clave");
		btnNewButton_2.setBounds(30, 274, 164, 23);
		getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel(usuario);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 99, 621, 14);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Ver datos");
		btnNewButton.setBounds(30, 206, 164, 23);
		getContentPane().add(btnNewButton);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	}
}
