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

public class MenuPrincipal extends JFrame {
	public static void DatosUsuario() {
		
	}
	static String usuario;

	public static String datosUsuario(String user) {
		return user;
	}


	public static MenuPrincipal menuprincipal = new MenuPrincipal(usuario);
	private JPanel contentPane;
	private JTextField textField;
	

	
	 public  MenuPrincipal(String usuario) {
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
				String Botones[] = {"Salir", "Cancelar"};
				int resultado = JOptionPane.showOptionDialog(null, "�Est�s seguro de que quieres salir de la aplicaci�n?", "SALIDA", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, Botones, Botones[1]);
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
		
		
		JLabel lblNewLabel = new JLabel("PLEITOMYK");
		lblNewLabel.setForeground(new Color(51, 204, 51));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD, 48));
		lblNewLabel.setBounds(258, 54, 321, 87);
		contentPane.add(lblNewLabel);
		
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
		btnReservas.setBounds(321, 230, 180, 33);
		contentPane.add(btnReservas);
		
		JButton btnConsultaRecinto = new JButton("Consultar recintos");
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
		
		JButton btnPerfil = new JButton("Perfil");
		btnPerfil.setBounds(321, 415, 180, 33);
		contentPane.add(btnPerfil);
		
		textField = new JTextField();
		textField.setBounds(38, 39, 137, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText(usuario);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/vista/Menuprincipal.jpg")));
		lblNewLabel_1_1.setBounds(0, 0, 834, 548);
		contentPane.add(lblNewLabel_1_1);
	}

}
