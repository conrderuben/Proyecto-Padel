package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Clave;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class MenuRegistroUno extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField usuario;
	private JTextField CP;
	private JTextField calle;
	private JTextField numero;
	private final ButtonGroup grupoPago = new ButtonGroup();
	private JPasswordField passwordField;

	
	public static MenuRegistroUno dialogMenuRegistroUno = new MenuRegistroUno();
	
	
	public static void mostrarRegistro(JFrame menuprincipal) {
		dialogMenuRegistroUno.setVisible(true);
	}

	public MenuRegistroUno() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuRegistroUno.class.getResource("/vista/icono.png")));
		setResizable(false);

		setTitle("PLEITOMYK - REGISTRO");
		setBounds(100, 100, 703, 416);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				String Botones[] = { "Salir", "Cancelar" };
				int resultado = JOptionPane.showOptionDialog(null,
						"¿Estás seguro de que quieres salir de la aplicación?", "SALIDA", JOptionPane.DEFAULT_OPTION,
						JOptionPane.WARNING_MESSAGE, null, Botones, Botones[1]);
				if (resultado == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		
		JLabel errorUsuario = new JLabel("* Este campo no es v\u00E1lido.");
		errorUsuario.setForeground(Color.RED);
		errorUsuario.setFont(new Font("Tahoma", Font.BOLD, 10));
		errorUsuario.setBounds(365, 126, 210, 14);
		errorUsuario.setVisible(false);
		contentPanel.add(errorUsuario);

		JLabel errorCP = new JLabel("* Este campo no es v\u00E1lido.");
		errorCP.setForeground(Color.RED);
		errorCP.setFont(new Font("Tahoma", Font.BOLD, 10));
		errorCP.setBounds(280, 188, 210, 14);
		errorCP.setVisible(false);
		contentPanel.add(errorCP);

		JLabel errorCalleNumero = new JLabel("* Revisa estos campos.");
		errorCalleNumero.setForeground(Color.RED);
		errorCalleNumero.setFont(new Font("Tahoma", Font.BOLD, 10));
		errorCalleNumero.setBounds(415, 219, 210, 14);
		errorCalleNumero.setVisible(false);
		contentPanel.add(errorCalleNumero);

		JLabel errorPago = new JLabel("* Revisa este campo.");
		errorPago.setForeground(Color.RED);
		errorPago.setFont(new Font("Tahoma", Font.BOLD, 10));
		errorPago.setBounds(404, 250, 210, 14);
		errorPago.setVisible(false);
		contentPanel.add(errorPago);

		JLabel errorTerminos = new JLabel("* Debes marcar esta opci\u00F3n.");
		errorTerminos.setForeground(Color.RED);
		errorTerminos.setFont(new Font("Tahoma", Font.BOLD, 10));
		errorTerminos.setBounds(403, 295, 202, 14);
		errorTerminos.setVisible(false);
		contentPanel.add(errorTerminos);

		JLabel errorClave = new JLabel("* Este campo no es v\u00E1lido.");
		errorClave.setForeground(Color.RED);
		errorClave.setFont(new Font("Tahoma", Font.BOLD, 10));
		errorClave.setBounds(375, 157, 210, 14);
		errorClave.setVisible(false);
		contentPanel.add(errorClave);
		
		JLabel errorUsuarioEnUso = new JLabel("* Este usuario ya existe.");
		errorUsuarioEnUso.setForeground(Color.RED);
		errorUsuarioEnUso.setFont(new Font("Tahoma", Font.BOLD, 10));
		errorUsuarioEnUso.setBounds(365, 126, 131, 14);
		errorUsuarioEnUso.setVisible(false);
		contentPanel.add(errorUsuarioEnUso);

		JLabel lblNewLabel_1 = new JLabel("Registro");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel_1.setBounds(247, 23, 178, 59);
		contentPanel.add(lblNewLabel_1);

		JLabel lblnUsuario = new JLabel("Nombre de usuario");
		lblnUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblnUsuario.setBounds(43, 121, 156, 20);
		contentPanel.add(lblnUsuario);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblContrasea.setBounds(43, 152, 156, 20);
		contentPanel.add(lblContrasea);

		JLabel lblCodigoPostal = new JLabel("C\u00F3digo Postal");
		lblCodigoPostal.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCodigoPostal.setBounds(43, 183, 156, 20);
		contentPanel.add(lblCodigoPostal);

		JLabel lblCalleYNmero = new JLabel("Calle y n\u00FAmero");
		lblCalleYNmero.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCalleYNmero.setBounds(43, 214, 135, 20);
		contentPanel.add(lblCalleYNmero);

		JLabel lblMtodoDePago = new JLabel("M\u00E9todo de pago");
		lblMtodoDePago.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMtodoDePago.setBounds(43, 245, 156, 20);
		contentPanel.add(lblMtodoDePago);

		usuario = new JTextField();
		usuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (!modelo.dao.UsuariosDAO.comprobarUsuario(usuario.getText())) {
					errorUsuario.setVisible(false);
					errorUsuarioEnUso.setVisible(true);
				} else {
					errorUsuarioEnUso.setVisible(false);
				}
				if (usuario.getText().isBlank()) {
					errorUsuarioEnUso.setVisible(false);
					errorUsuario.setVisible(true);
				} else {
					errorUsuario.setVisible(false);
				}
			}
		});
		usuario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (!modelo.dao.UsuariosDAO.comprobarUsuario(usuario.getText())) {
					errorUsuario.setVisible(false);
					errorUsuarioEnUso.setVisible(true);
				} else {
					errorUsuarioEnUso.setVisible(false);
				}
				if (usuario.getText().isBlank()) {
					errorUsuarioEnUso.setVisible(false);
					errorUsuario.setVisible(true);
				} else {
					errorUsuario.setVisible(false);
				}
			}
		});
		usuario.setColumns(10);
		usuario.setBounds(209, 123, 146, 20);
		contentPanel.add(usuario);

		CP = new JTextField();
		CP.addKeyListener((KeyListener) new KeyAdapter() {
			public void keyTyped(KeyEvent evt) {
				if (!Character.isDigit(evt.getKeyChar())) {
					evt.consume();
				}
				if (CP.getText().length() > 4) {
					evt.consume();
				}
			}
		});
		CP.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (!(CP.getText().isBlank() || (CP.getText().length() != 5))) {
					errorCP.setVisible(false);
				}
			}
		});
		CP.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (CP.getText().isBlank() || (CP.getText().length() != 5)) {
					errorCP.setVisible(true);
				} else {
					errorCP.setVisible(false);
				}
			}
		});
		CP.setColumns(10);
		CP.setBounds(174, 185, 86, 20);
		contentPanel.add(CP);

		calle = new JTextField();
		calle.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (calle.getText().isBlank()) {
					errorCalleNumero.setVisible(true);
				} else {
					errorCalleNumero.setVisible(false);
				}
			}
		});
		calle.setColumns(10);
		calle.setBounds(184, 214, 146, 20);
		contentPanel.add(calle);

		numero = new JTextField();
		numero.addKeyListener((KeyListener) new KeyAdapter() {
			public void keyTyped(KeyEvent evt) {
				if (!Character.isDigit(evt.getKeyChar())) {
					evt.consume();
				}
				if (numero.getText().length() > 2) {
					evt.consume();
				}
			}
		});
		numero.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (numero.getText().isBlank()) {
					errorCalleNumero.setVisible(true);
				} else {
					errorCalleNumero.setVisible(false);
				}
			}
		});
		numero.setColumns(10);
		numero.setBounds(340, 214, 60, 20);
		contentPanel.add(numero);

		JRadioButton pago1 = new JRadioButton("Tarjeta");
		grupoPago.add(pago1);
		pago1.setBounds(192, 245, 71, 23);
		contentPanel.add(pago1);

		JRadioButton pago2 = new JRadioButton("PayPal");
		grupoPago.add(pago2);
		pago2.setBounds(267, 245, 71, 23);
		contentPanel.add(pago2);

		JRadioButton pago3 = new JRadioButton("Bizum");
		grupoPago.add(pago3);
		pago3.setBounds(338, 246, 60, 23);
		contentPanel.add(pago3);

		JCheckBox terminos = new JCheckBox("Acepto los t\u00E9rminos y condiciones del servicio Pleitomyk.");
		terminos.setFont(new Font("Tahoma", Font.BOLD, 11));
		terminos.setBounds(43, 291, 354, 23);
		contentPanel.add(terminos);

		passwordField = new JPasswordField();
		passwordField.setToolTipText(
				"Debe tener de 8 a 20 caracteres, una may\u00FAscula, un n\u00FAmero y un car\u00E1cter especial.");
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (!(passwordField.getText().isBlank() || Clave.comprobar(passwordField.getText()))) {
					errorClave.setVisible(false);
				}
			}
		});
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (passwordField.getText().isBlank() || Clave.comprobar(passwordField.getText())) {
					errorClave.setVisible(true);
				} else {
					errorClave.setVisible(false);
				}
			}
		});
		passwordField.setBounds(153, 154, 140, 20);
		contentPanel.add(passwordField);

		JButton verClave = new JButton("Ver");
		verClave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		char defecto = passwordField.getEchoChar();
		verClave.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				passwordField.setEchoChar('\0');
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				passwordField.setEchoChar(defecto);
			}
		});
		verClave.setBounds(303, 153, 60, 20);
		contentPanel.add(verClave);
		{
			JButton okButton = new JButton("Siguiente");
			okButton.setBounds(467, 342, 94, 23);
			contentPanel.add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					int mpago = 0;

					if (pago1.isSelected()) {
						mpago = 1;
					}
					if (pago2.isSelected()) {
						mpago = 2;
					}
					if (pago3.isSelected()) {
						mpago = 3;
					}

					if (errorCalleNumero.isVisible() || errorClave.isVisible() || errorCP.isVisible()
							|| errorUsuario.isVisible() || errorTerminos.isVisible() || usuario.getText().isBlank()
							|| passwordField.getText().isBlank() || CP.getText().isBlank()
							|| calle.getText().isBlank() || numero.getText().isBlank() || grupoPago.isSelected(null)
							|| !terminos.isSelected()) {

						if (usuario.getText().isBlank()) {
							errorUsuario.setVisible(true);
						}

						if (passwordField.getText().isBlank()) {
							errorClave.setVisible(true);
						}

						if (CP.getText().isBlank()) {
							errorCP.setVisible(true);
						}

						if (calle.getText().isBlank() || numero.getText().isBlank()) {
							errorCalleNumero.setVisible(true);
						}

						if (grupoPago.isSelected(null)) {
							errorPago.setVisible(true);
						} else {
							errorPago.setVisible(false);
						}

						if (!terminos.isSelected()) {
							errorTerminos.setVisible(true);
						} else {
							errorTerminos.setVisible(false);
						}

					} else {
						dialogMenuRegistroUno.setVisible(false);
						MenuRegistroDos.mostrarRegistro(usuario.getText(), passwordField.getText(),
								Integer.parseInt(CP.getText()), calle.getText(), Integer.parseInt(numero.getText()),
								mpago);
					}

				}
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Cancelar");
			cancelButton.setBounds(571, 342, 94, 23);
			contentPanel.add(cancelButton);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
					MenuInicio.mostrarMenuInicio(MenuPrincipal.menuprincipal);
				}
			});
			cancelButton.setActionCommand("Cancel");
		}
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MenuRegistroUno.class.getResource("/vista/fondoregistrouno.jpg")));
		lblNewLabel.setBounds(0, 0, 697, 387);
		contentPanel.add(lblNewLabel);
	}
}
