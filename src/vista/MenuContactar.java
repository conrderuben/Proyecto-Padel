package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Clave;

import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;

public class MenuContactar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public static MenuContactar dialogMenuContactar = new MenuContactar();
	private final ButtonGroup grupoBotonesMotivo = new ButtonGroup();
	static boolean primerMenu = true;

	public static void mostrarMenuContactar(JFrame menuprincipal) {
		dialogMenuContactar.setVisible(true);
	}

	public MenuContactar() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuContactar.class.getResource("/vista/icono.png")));
		setTitle("PLEITOMYK - CONTACTAR");
		setResizable(false);
		setBounds(100, 100, 1300, 546);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.setLayout(null);
		{
			JLabel textoTitulo = new JLabel("Contacta con nosotros");
			textoTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			textoTitulo.setForeground(Color.BLACK);
			textoTitulo.setFont(new Font("Cambria", Font.BOLD, 36));
			textoTitulo.setBackground(Color.WHITE);
			textoTitulo.setBounds(0, 0, 866, 96);
			contentPanel.add(textoTitulo);
		}

		JLabel textoAyuda = new JLabel(
				"Indica cu\u00E1l de estos motivos para contactarnos se ajusta mejor en tu caso.");
		textoAyuda.setFont(new Font("Garamond", Font.PLAIN, 16));
		textoAyuda.setHorizontalAlignment(SwingConstants.CENTER);
		textoAyuda.setBounds(0, 107, 866, 39);
		contentPanel.add(textoAyuda);

		JRadioButton opcion1 = new JRadioButton(" Problema con pedido");
		grupoBotonesMotivo.add(opcion1);
		opcion1.setFont(new Font("Garamond", Font.PLAIN, 14));
		opcion1.setBounds(349, 181, 168, 23);
		contentPanel.add(opcion1);

		JRadioButton opcion2 = new JRadioButton(" Problema con reserva");
		grupoBotonesMotivo.add(opcion2);
		opcion2.setFont(new Font("Garamond", Font.PLAIN, 14));
		opcion2.setBounds(349, 207, 168, 23);
		contentPanel.add(opcion2);

		JRadioButton opcion3 = new JRadioButton(" Problema con la app");
		grupoBotonesMotivo.add(opcion3);
		opcion3.setFont(new Font("Garamond", Font.PLAIN, 14));
		opcion3.setBounds(349, 233, 168, 23);
		contentPanel.add(opcion3);

		JRadioButton opcion4 = new JRadioButton(" Reportar un bug");
		grupoBotonesMotivo.add(opcion4);
		opcion4.setFont(new Font("Garamond", Font.PLAIN, 14));
		opcion4.setBounds(349, 259, 168, 23);
		contentPanel.add(opcion4);

		JRadioButton opcion5 = new JRadioButton(" Otro distinto");
		grupoBotonesMotivo.add(opcion5);
		opcion5.setFont(new Font("Garamond", Font.PLAIN, 14));
		opcion5.setBounds(349, 285, 168, 23);
		contentPanel.add(opcion5);

		JLabel errorMensaje = new JLabel("Debes seleccionar alguna de las opciones para poder continuar.");
		errorMensaje.setVisible(false);

		JTextPane mensaje = new JTextPane();
		mensaje.setBackground(Color.LIGHT_GRAY);
		mensaje.setVisible(false);
		mensaje.addKeyListener((KeyListener) new KeyAdapter() {
			public void keyTyped(KeyEvent evt) {
				if (mensaje.getText().length() > 699) {
					evt.consume();
				}
			}
		});
		mensaje.setBounds(203, 157, 462, 171);
		contentPanel.add(mensaje);
		errorMensaje.setForeground(Color.RED);
		errorMensaje.setFont(new Font("Garamond", Font.BOLD, 14));
		errorMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		errorMensaje.setBounds(0, 339, 866, 29);
		contentPanel.add(errorMensaje);

		JButton botonContinuar = new JButton("CONTINUAR");
		botonContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (primerMenu) {
					if (grupoBotonesMotivo.isSelected(null)) {
						errorMensaje.setVisible(true);
					} else {
						errorMensaje.setVisible(false);
						opcion1.setVisible(false);
						opcion2.setVisible(false);
						opcion3.setVisible(false);
						opcion4.setVisible(false);
						opcion5.setVisible(false);
						mensaje.setVisible(true);
						textoAyuda.setText("Escribe tu mensaje (700 letras como máximo).");
						errorMensaje.setText("Debes escribir un mensaje.");
						primerMenu = false;
						botonContinuar.setText("ENVIAR");
					}
				} else {
					if (mensaje.getText().isBlank()) {
						errorMensaje.setVisible(true);
					} else {
						errorMensaje.setVisible(false);
						dispose();
						MenuPrincipal.menuprincipal.setVisible(true);
						JOptionPane.showMessageDialog(null,
								"Tu mensaje ha sido enviado a Pleitomyk, recibirás una respuesta en menos de 24 horas.",
								"MENSAJE ENVIADO", JOptionPane.INFORMATION_MESSAGE);
					}
				}

			}
		});
		botonContinuar.setFont(new Font("Garamond", Font.BOLD, 14));
		botonContinuar.setBounds(349, 393, 168, 23);
		contentPanel.add(botonContinuar);

		JButton botonVolver = new JButton("CANCELAR");
		botonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (primerMenu) {
					errorMensaje.setVisible(false);
					grupoBotonesMotivo.clearSelection();
					dispose();
					MenuPrincipal.menuprincipal.setVisible(true);
				} else {
					opcion1.setVisible(true);
					opcion2.setVisible(true);
					opcion3.setVisible(true);
					opcion4.setVisible(true);
					opcion5.setVisible(true);
					mensaje.setVisible(false);
					errorMensaje.setVisible(false);
					primerMenu = true;
					textoAyuda.setText("Indica cu\u00E1l de estos motivos para contactarnos se ajusta mejor en tu caso.");
					errorMensaje.setText("Debes seleccionar alguna de las opciones para poder continuar.");
					botonContinuar.setText("CONTINUAR");
				}
			}
		});
		botonVolver.setFont(new Font("Garamond", Font.BOLD, 14));
		botonVolver.setBounds(349, 427, 168, 23);
		contentPanel.add(botonVolver);

		JLabel imagen = new JLabel("");
		imagen.setIcon(new ImageIcon(MenuContactar.class.getResource("/vista/sidigame.jpg")));
		imagen.setBounds(0, 0, 1294, 517);
		contentPanel.add(imagen);

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

			@Override
			public void windowOpened(WindowEvent e) {
				getContentPane().requestFocusInWindow();
			}
		});
	}
}
