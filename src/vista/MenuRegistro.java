package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

import control.Clave;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JScrollBar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.NumberFormat;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Toolkit;

public class MenuRegistro extends JDialog {
	private JTextField textUsuario;
	private JPasswordField passwordField;
	private JTextField textCP;
	private JTextField textcalle;
	private JTextField textN;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private final ButtonGroup buttonGroup_3 = new ButtonGroup();
	private final ButtonGroup buttonGroup_4 = new ButtonGroup();

	public static void mostrarRegistro(JFrame menusecundario) {
		MenuRegistro dialog = new MenuRegistro();
		dialog.setVisible(true);
	}

	public MenuRegistro() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuRegistro.class.getResource("/vista/icono.png")));

		setTitle("PLEITOMYK - REGISTRO");
		setResizable(false);
		setBounds(100, 100, 637, 997);
//		setBounds(100, 100, 579, 415);
//		setPreferredSize(new Dimension(100, 100));
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

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

		//////////////////// TEXTOS DE ERRORES /////////////////

		JLabel alertaError = new JLabel("* Alguno de los campos no es v\u00E1lido.");
		alertaError.setBackground(Color.LIGHT_GRAY);
		alertaError.setForeground(Color.RED);
		alertaError.setFont(new Font("Tahoma", Font.BOLD, 11));
		alertaError.setBounds(53, 921, 254, 23);
		alertaError.setVisible(false);
		getContentPane().add(alertaError);

		JLabel errorUsuario = new JLabel("* Este campo no es v\u00E1lido.");
		errorUsuario.setFont(new Font("Tahoma", Font.BOLD, 10));
		errorUsuario.setForeground(Color.RED);
		errorUsuario.setBounds(318, 147, 146, 14);
		errorUsuario.setVisible(false);
		getContentPane().add(errorUsuario);

		JLabel errorClave = new JLabel("* Este campo no es v\u00E1lido.");
		errorClave.setFont(new Font("Tahoma", Font.BOLD, 10));
		errorClave.setForeground(Color.RED);
		errorClave.setBounds(318, 200, 146, 14);
		errorClave.setVisible(false);
		getContentPane().add(errorClave);

		JLabel errorCP = new JLabel("* Este campo no es v\u00E1lido.");
		errorCP.setFont(new Font("Tahoma", Font.BOLD, 10));
		errorCP.setForeground(Color.RED);
		errorCP.setBounds(318, 299, 146, 14);
		errorCP.setVisible(false);
		getContentPane().add(errorCP);

		JLabel errorCalle = new JLabel("* Este campo no es v\u00E1lido.");
		errorCalle.setFont(new Font("Tahoma", Font.BOLD, 10));
		errorCalle.setForeground(Color.RED);
		errorCalle.setBounds(188, 353, 146, 14);
		errorCalle.setVisible(false);
		getContentPane().add(errorCalle);

		JLabel errorNumero = new JLabel("* Este campo no es v\u00E1lido.");
		errorNumero.setFont(new Font("Tahoma", Font.BOLD, 10));
		errorNumero.setForeground(Color.RED);
		errorNumero.setBounds(401, 353, 146, 14);
		errorNumero.setVisible(false);
		getContentPane().add(errorNumero);

		JLabel req1 = new JLabel("*");
		req1.setForeground(Color.RED);
		req1.setFont(new Font("Tahoma", Font.BOLD, 10));
		req1.setBackground(Color.LIGHT_GRAY);
		req1.setBounds(128, 455, 16, 14);
		req1.setVisible(false);
		getContentPane().add(req1);

		JLabel req2 = new JLabel("*");
		req2.setForeground(Color.RED);
		req2.setFont(new Font("Tahoma", Font.BOLD, 10));
		req2.setBackground(Color.LIGHT_GRAY);
		req2.setBounds(168, 540, 16, 14);
		req2.setVisible(false);
		getContentPane().add(req2);

		JLabel req3 = new JLabel("*");
		req3.setForeground(Color.RED);
		req3.setFont(new Font("Tahoma", Font.BOLD, 10));
		req3.setBackground(Color.LIGHT_GRAY);
		req3.setBounds(148, 611, 16, 14);
		req3.setVisible(false);
		getContentPane().add(req3);

		JLabel req4 = new JLabel("*");
		req4.setForeground(Color.RED);
		req4.setFont(new Font("Tahoma", Font.BOLD, 10));
		req4.setBackground(Color.LIGHT_GRAY);
		req4.setBounds(99, 682, 16, 14);
		req4.setVisible(false);
		getContentPane().add(req4);

		JLabel req5 = new JLabel("*");
		req5.setForeground(Color.RED);
		req5.setFont(new Font("Tahoma", Font.BOLD, 10));
		req5.setBackground(Color.LIGHT_GRAY);
		req5.setBounds(168, 795, 16, 14);
		req5.setVisible(false);
		getContentPane().add(req5);

		////////////////////////////////////////////////////////////////

		textUsuario = new JTextField();
		textUsuario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textUsuario.getText().isBlank()
						|| !modelo.dao.UsuariosDAO.comprobarUsuario(textUsuario.getText())) {
					errorUsuario.setVisible(true);
				} else {
					errorUsuario.setVisible(false);
				}
			}
		});
		textUsuario.setColumns(10);
		textUsuario.setBounds(318, 122, 146, 20);
		getContentPane().add(textUsuario);

		JLabel lblNewLabel = new JLabel("Registro");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblNewLabel.setBounds(219, 29, 178, 59);
		getContentPane().add(lblNewLabel);

		JLabel lblnUsuario = new JLabel("Nombre de usuario");
		lblnUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblnUsuario.setBounds(85, 119, 156, 20);
		getContentPane().add(lblnUsuario);

		JLabel lblContrasea = new JLabel("Contrase\u00f1a");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContrasea.setBounds(85, 169, 156, 20);
		getContentPane().add(lblContrasea);

		passwordField = new JPasswordField();
		passwordField.setToolTipText(
				"Debe tener de 8 a 20 caracteres, una may\u00FAscula, un n\u00FAmero y un car\u00E1cter especial.");
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
		passwordField.setBounds(318, 172, 146, 20);
		getContentPane().add(passwordField);

//		Image llave = new ImageIcon(this.getClass().getResource("key.ico")).getImage();
		JButton btnVer = new JButton("Ver");
//		btnVer.setIcon(new ImageIcon(llave));
//		btnVer.setIcon(llave);
//		btnVer.setSelectedIcon(llave);
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		char defecto = passwordField.getEchoChar();
		btnVer.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				passwordField.setEchoChar('\0');
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				passwordField.setEchoChar(defecto);
			}
		});
		btnVer.setBounds(487, 171, 60, 20);
		getContentPane().add(btnVer);

		JLabel lblDireccion = new JLabel("DIRECCI\u00d3N");
		lblDireccion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblDireccion.setBounds(222, 225, 164, 48);
		getContentPane().add(lblDireccion);

		textCP = new JTextField();
		textCP.setToolTipText("El campo debe tener cinco n\u00FAmeros.");
		textCP.setColumns(10);
		textCP.setBounds(318, 274, 146, 20);
		textCP.addKeyListener((KeyListener) new KeyAdapter() {
			public void keyTyped(KeyEvent evt) {
				if (!Character.isDigit(evt.getKeyChar())) {
					evt.consume();
				}
			}
		});
		textCP.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textCP.getText().isBlank() || (textCP.getText().length() != 5)) {
					errorCP.setVisible(true);
				} else {
					errorCP.setVisible(false);
				}
			}
		});
		getContentPane().add(textCP);

		JLabel lblCodigoPostal = new JLabel("C\u00f3digo Postal");
		lblCodigoPostal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCodigoPostal.setBounds(85, 271, 156, 20);
		getContentPane().add(lblCodigoPostal);

		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCalle.setBounds(86, 317, 58, 32);
		getContentPane().add(lblCalle);

		textcalle = new JTextField();
		textcalle.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textcalle.getText().isBlank()) {
					errorCalle.setVisible(true);
				} else {
					errorCalle.setVisible(false);
				}
			}
		});
		textcalle.setColumns(10);
		textcalle.setBounds(188, 324, 146, 23);
		getContentPane().add(textcalle);

		JLabel lblN = new JLabel("N\u00ba");
		lblN.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblN.setBounds(363, 323, 34, 20);
		getContentPane().add(lblN);

		textN = new JTextField();
		textN.setColumns(10);
		textN.setBounds(403, 325, 61, 20);
		textN.addKeyListener((KeyListener) new KeyAdapter() {
			public void keyTyped(KeyEvent evt) {
				if (!Character.isDigit(evt.getKeyChar())) {
					evt.consume();
				}
			}
		});
		textN.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textN.getText().isBlank()) {
					errorNumero.setVisible(true);
				} else {
					errorNumero.setVisible(false);
				}
			}
		});
		getContentPane().add(textN);

		JLabel lblDireccion_1 = new JLabel("NIVEL");
		lblDireccion_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDireccion_1.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblDireccion_1.setBounds(219, 378, 178, 34);
		getContentPane().add(lblDireccion_1);

		JLabel lblNewLabel_1 = new JLabel("Responde estas preguntas para que podamos asignarte un nivel adecuado.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(58, 416, 511, 14);
		getContentPane().add(lblNewLabel_1);

		JLabel lbl1P = new JLabel("1. \u00BFCu\u00E1ntos meses llevas jugando al p\u00E1del?");
		lbl1P.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl1P.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1P.setBounds(86, 449, 447, 23);
		getContentPane().add(lbl1P);

		JRadioButton rdbtn1P1 = new JRadioButton("Menos de 2");
		buttonGroup.add(rdbtn1P1);
		rdbtn1P1.setBounds(111, 490, 107, 23);
		getContentPane().add(rdbtn1P1);

		JRadioButton rdbtn1P2 = new JRadioButton("Entre 2 y 6");
		buttonGroup.add(rdbtn1P2);
		rdbtn1P2.setBounds(219, 490, 95, 23);
		getContentPane().add(rdbtn1P2);

		JRadioButton rdbtn1P3 = new JRadioButton("Entre 6 y 15");
		buttonGroup.add(rdbtn1P3);
		rdbtn1P3.setBounds(329, 490, 95, 23);
		getContentPane().add(rdbtn1P3);

		JRadioButton rdbtn1P4 = new JRadioButton("M\u00e1s de 15");
		buttonGroup.add(rdbtn1P4);
		rdbtn1P4.setBounds(438, 490, 107, 23);
		getContentPane().add(rdbtn1P4);

		JLabel lbl2P = new JLabel("2. \u00BFJuegas todas las semanas?");
		lbl2P.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2P.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl2P.setBounds(86, 533, 447, 23);
		getContentPane().add(lbl2P);

		JRadioButton rdbtn2P1 = new JRadioButton("SI");
		buttonGroup_1.add(rdbtn2P1);
		rdbtn2P1.setBounds(264, 563, 43, 32);
		getContentPane().add(rdbtn2P1);

		JRadioButton rdbtn2P2 = new JRadioButton("NO");
		buttonGroup_1.add(rdbtn2P2);
		rdbtn2P2.setBounds(318, 563, 50, 32);
		getContentPane().add(rdbtn2P2);

		JLabel lbl3P = new JLabel("3. \u00BFCu\u00e1ntos d\u00edas juegas a la semana?");
		lbl3P.setHorizontalAlignment(SwingConstants.CENTER);
		lbl3P.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl3P.setBounds(86, 608, 447, 17);
		getContentPane().add(lbl3P);

		JLabel lbl4P = new JLabel("4. \u00BFDominas los remates, paralelos, globos y dem\u00E1s?");
		lbl4P.setHorizontalAlignment(SwingConstants.CENTER);
		lbl4P.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl4P.setBounds(53, 667, 530, 41);
		getContentPane().add(lbl4P);

		JRadioButton rdbtn3P1 = new JRadioButton("1 d\u00eda");
		buttonGroup_2.add(rdbtn3P1);
		rdbtn3P1.setBounds(208, 632, 61, 32);
		getContentPane().add(rdbtn3P1);

		JRadioButton rdbtn3P2 = new JRadioButton("2 o 3 d\u00edas");
		buttonGroup_2.add(rdbtn3P2);
		rdbtn3P2.setBounds(273, 632, 81, 32);
		getContentPane().add(rdbtn3P2);

		JRadioButton rdbtn3P3 = new JRadioButton("M\u00e1s de 4");
		buttonGroup_2.add(rdbtn3P3);
		rdbtn3P3.setBounds(356, 632, 87, 32);
		getContentPane().add(rdbtn3P3);

		JRadioButton rdbtn4P1 = new JRadioButton("Pr\u00e1cticamente nada");
		buttonGroup_3.add(rdbtn4P1);
		rdbtn4P1.setBounds(53, 701, 140, 32);
		getContentPane().add(rdbtn4P1);

		JRadioButton rdbtn4P2 = new JRadioButton("Medianamente");
		buttonGroup_3.add(rdbtn4P2);
		rdbtn4P2.setBounds(217, 701, 117, 32);
		getContentPane().add(rdbtn4P2);

		JRadioButton rdbtn4P3 = new JRadioButton("Bastante bien");
		buttonGroup_3.add(rdbtn4P3);
		rdbtn4P3.setBounds(357, 701, 107, 32);
		getContentPane().add(rdbtn4P3);

		JRadioButton rdbtn4P4 = new JRadioButton("Los domino");
		buttonGroup_3.add(rdbtn4P4);
		rdbtn4P4.setBounds(487, 701, 107, 32);
		getContentPane().add(rdbtn4P4);

		JLabel lblPago = new JLabel("PAGO");
		lblPago.setHorizontalAlignment(SwingConstants.CENTER);
		lblPago.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblPago.setBounds(233, 740, 164, 53);
		getContentPane().add(lblPago);

		JLabel lblSeleccionaElMetodo = new JLabel("Selecciona un m\u00E9todo de pago");
		lblSeleccionaElMetodo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccionaElMetodo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSeleccionaElMetodo.setBounds(43, 779, 540, 41);
		getContentPane().add(lblSeleccionaElMetodo);

		JRadioButton rdbtnPago1 = new JRadioButton("Tarjeta");
		buttonGroup_4.add(rdbtnPago1);
		rdbtnPago1.setBounds(188, 827, 71, 23);
		getContentPane().add(rdbtnPago1);

		JRadioButton rdbtnPago2 = new JRadioButton("PayPal");
		buttonGroup_4.add(rdbtnPago2);
		rdbtnPago2.setBounds(286, 827, 71, 23);
		getContentPane().add(rdbtnPago2);

		JRadioButton rdbtnPago3 = new JRadioButton("Bizum");
		buttonGroup_4.add(rdbtnPago3);
		rdbtnPago3.setBounds(377, 827, 66, 23);
		getContentPane().add(rdbtnPago3);

		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int cont = 0;
				int mpago = 0;
				if (rdbtn1P1.isSelected()) {

				}
				if (rdbtn1P2.isSelected()) {
					cont += 4;
				}
				if (rdbtn1P3.isSelected()) {
					cont += 7;
				}
				if (rdbtn1P4.isSelected()) {
					cont += 10;
				}
				if (rdbtn2P1.isSelected()) {
					cont += 5;
				}
				if (rdbtn2P2.isSelected()) {

				}
				if (rdbtn3P1.isSelected()) {
					cont += 2;
				}
				if (rdbtn3P2.isSelected()) {
					cont += 5;
				}
				if (rdbtn3P3.isSelected()) {
					cont += 10;
				}
				if (rdbtn4P1.isSelected()) {
					cont += 0;
				}
				if (rdbtn4P2.isSelected()) {
					cont += 4;
				}
				if (rdbtn4P3.isSelected()) {
					cont += 7;
				}
				if (rdbtn4P4.isSelected()) {
					cont += 10;
				}
				if (rdbtnPago1.isSelected()) {
					mpago = 1;
				}
				if (rdbtnPago2.isSelected()) {
					mpago = 2;
				}
				if (rdbtnPago3.isSelected()) {
					mpago = 3;
				}

				if (buttonGroup.isSelected(null)) {
					req1.setVisible(true);
				} else {
					req1.setVisible(false);
				}
				if (buttonGroup_1.isSelected(null)) {
					req2.setVisible(true);
				} else {
					req2.setVisible(false);
				}
				if (buttonGroup_2.isSelected(null)) {
					req3.setVisible(true);
				} else {
					req3.setVisible(false);
				}
				if (buttonGroup_3.isSelected(null)) {
					req4.setVisible(true);
				} else {
					req4.setVisible(false);
				}
				if (buttonGroup_4.isSelected(null)) {
					req5.setVisible(true);
				} else {
					req5.setVisible(false);
				}

				if (errorCalle.isVisible() || errorClave.isVisible() || errorCP.isVisible() || errorNumero.isVisible()
						|| errorUsuario.isVisible() || textUsuario.getText().isBlank()
						|| passwordField.getText().isBlank() || textCP.getText().isBlank()
						|| textcalle.getText().isBlank() || textN.getText().isBlank() || buttonGroup.isSelected(null)
						|| buttonGroup_1.isSelected(null) || buttonGroup_2.isSelected(null)
						|| buttonGroup_3.isSelected(null) || buttonGroup_4.isSelected(null)) {
					alertaError.setVisible(true);
				} else {
					dispose();
					Lectura.leerDatosRegistro(textUsuario.getText(), passwordField.getText(),
							Integer.parseInt(textCP.getText()), textcalle.getText(), Integer.parseInt(textN.getText()),
							cont, mpago);
					MenuLogin.mostrarMenuSesion(MenuPrincipal.menuprincipal);
					JOptionPane.showMessageDialog(null, "Te has registrado con \u00e9xito.", "REGISTRO",
							JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
		btnEnviar.setBounds(325, 921, 89, 23);
		getContentPane().add(btnEnviar);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textUsuario.setText(null);
				passwordField.setText(null);
				textCP.setText(null);
				textcalle.setText(null);
				textN.setText(null);
				buttonGroup.clearSelection();
				buttonGroup_1.clearSelection();
				buttonGroup_2.clearSelection();
				buttonGroup_3.clearSelection();
				buttonGroup_4.clearSelection();
				errorCalle.setVisible(false);
				errorClave.setVisible(false);
				errorCP.setVisible(false);
				errorNumero.setVisible(false);
				errorUsuario.setVisible(false);
				req1.setVisible(false);
				req2.setVisible(false);
				req3.setVisible(false);
				req4.setVisible(false);
				req5.setVisible(false);
				alertaError.setVisible(false);
			}
		});
		btnLimpiar.setBounds(424, 921, 89, 23);
		getContentPane().add(btnLimpiar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				MenuInicio.mostrarMenuRegistro(MenuPrincipal.menuprincipal);
			}
		});
		btnCancelar.setBounds(523, 921, 89, 23);
		getContentPane().add(btnCancelar);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(MenuRegistro.class.getResource("/vista/registro.jpg")));
		lblNewLabel_2.setBounds(0, 0, 631, 968);
		getContentPane().add(lblNewLabel_2);
	}
}
