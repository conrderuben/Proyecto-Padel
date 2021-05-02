package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class MenuRegistroDos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private final ButtonGroup grupo1 = new ButtonGroup();
	private final ButtonGroup grupo2 = new ButtonGroup();
	private final ButtonGroup grupo3 = new ButtonGroup();
	private final ButtonGroup grupo4 = new ButtonGroup();

	public static void mostrarRegistro(String usuario, String clave, int CP, String calle, int numero, int pago) {
		MenuRegistroDos dialog = new MenuRegistroDos(usuario, clave, CP, calle, numero, pago);
		dialog.setVisible(true);
	}

	public MenuRegistroDos(String usuario, String clave, int CP, String calle, int numero, int pago) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuRegistroDos.class.getResource("/vista/icono.png")));
		setResizable(false);

		setTitle("PLEITOMYK - COMPLETA TU REGISTRO");
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
						"\u00bfEst\u00e1s seguro de que quieres salir de la aplicaci\u00f3n?", "SALIDA",
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, Botones, Botones[1]);
				if (resultado == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});

		JLabel error1 = new JLabel("* ");
		error1.setForeground(Color.RED);
		error1.setFont(new Font("Tahoma", Font.BOLD, 10));
		error1.setBounds(166, 97, 15, 14);
		error1.setVisible(false);
		contentPanel.add(error1);

		JLabel error2 = new JLabel("* ");
		error2.setForeground(Color.RED);
		error2.setFont(new Font("Tahoma", Font.BOLD, 10));
		error2.setBounds(210, 157, 15, 14);
		error2.setVisible(false);
		contentPanel.add(error2);

		JLabel error3 = new JLabel("* ");
		error3.setForeground(Color.RED);
		error3.setFont(new Font("Tahoma", Font.BOLD, 10));
		error3.setBounds(186, 214, 15, 14);
		error3.setVisible(false);
		contentPanel.add(error3);

		JLabel error4 = new JLabel("* ");
		error4.setForeground(Color.RED);
		error4.setFont(new Font("Tahoma", Font.BOLD, 10));
		error4.setBounds(146, 271, 15, 14);
		error4.setVisible(false);
		contentPanel.add(error4);

		JLabel titulo = new JLabel("Nivel Inicial");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Tahoma", Font.BOLD, 40));
		titulo.setBounds(205, 11, 254, 59);
		contentPanel.add(titulo);

		JLabel p1 = new JLabel("1. \u00BFCu\u00E1ntos meses llevas jugando al p\u00E1del?");
		p1.setHorizontalAlignment(SwingConstants.CENTER);
		p1.setFont(new Font("Tahoma", Font.BOLD, 14));
		p1.setBounds(109, 91, 447, 23);
		contentPanel.add(p1);

		JRadioButton rdbtn1P1 = new JRadioButton("Menos de 2");
		rdbtn1P1.setBackground(Color.WHITE);
		grupo1.add(rdbtn1P1);
		rdbtn1P1.setBounds(133, 121, 107, 23);
		rdbtn1P1.setOpaque(false);
		rdbtn1P1.setContentAreaFilled(false);
		rdbtn1P1.setBorderPainted(false);
		contentPanel.add(rdbtn1P1);

		JRadioButton rdbtn1P2 = new JRadioButton("Entre 2 y 6");
		grupo1.add(rdbtn1P2);
		rdbtn1P2.setBounds(242, 121, 95, 23);
		rdbtn1P2.setOpaque(false);
		rdbtn1P2.setContentAreaFilled(false);
		rdbtn1P2.setBorderPainted(false);
		contentPanel.add(rdbtn1P2);

		JRadioButton rdbtn1P3 = new JRadioButton("Entre 6 y 15");
		grupo1.add(rdbtn1P3);
		rdbtn1P3.setBounds(346, 121, 95, 23);
		rdbtn1P3.setOpaque(false);
		rdbtn1P3.setContentAreaFilled(false);
		rdbtn1P3.setBorderPainted(false);
		contentPanel.add(rdbtn1P3);

		JRadioButton rdbtn1P4 = new JRadioButton("M\u00E1s de 15");
		grupo1.add(rdbtn1P4);
		rdbtn1P4.setBounds(458, 121, 107, 23);
		rdbtn1P4.setOpaque(false);
		rdbtn1P4.setContentAreaFilled(false);
		rdbtn1P4.setBorderPainted(false);
		contentPanel.add(rdbtn1P4);

		JLabel p2 = new JLabel("2. \u00BFJuegas todas las semanas?");
		p2.setHorizontalAlignment(SwingConstants.CENTER);
		p2.setFont(new Font("Tahoma", Font.BOLD, 14));
		p2.setBounds(109, 151, 447, 23);
		contentPanel.add(p2);

		JRadioButton rdbtn2P1 = new JRadioButton("S\u00ED");
		grupo2.add(rdbtn2P1);
		rdbtn2P1.setBounds(283, 181, 43, 23);
		rdbtn2P1.setOpaque(false);
		rdbtn2P1.setContentAreaFilled(false);
		rdbtn2P1.setBorderPainted(false);
		contentPanel.add(rdbtn2P1);

		JRadioButton rdbtn2P2 = new JRadioButton("No");
		grupo2.add(rdbtn2P2);
		rdbtn2P2.setBounds(339, 181, 50, 23);
		rdbtn2P2.setOpaque(false);
		rdbtn2P2.setContentAreaFilled(false);
		rdbtn2P2.setBorderPainted(false);
		contentPanel.add(rdbtn2P2);

		JLabel p3 = new JLabel("3. \u00BFCu\u00E1ntos d\u00EDas juegas a la semana?");
		p3.setHorizontalAlignment(SwingConstants.CENTER);
		p3.setFont(new Font("Tahoma", Font.BOLD, 14));
		p3.setBounds(109, 211, 447, 17);
		contentPanel.add(p3);

		JRadioButton rdbtn3P1 = new JRadioButton("1 d\u00EDa");
		grupo3.add(rdbtn3P1);
		rdbtn3P1.setBounds(234, 235, 61, 23);
		rdbtn3P1.setOpaque(false);
		rdbtn3P1.setContentAreaFilled(false);
		rdbtn3P1.setBorderPainted(false);
		contentPanel.add(rdbtn3P1);

		JRadioButton rdbtn3P2 = new JRadioButton("2 o 3 d\u00EDas");
		grupo3.add(rdbtn3P2);
		rdbtn3P2.setBounds(297, 235, 81, 23);
		rdbtn3P2.setOpaque(false);
		rdbtn3P2.setContentAreaFilled(false);
		rdbtn3P2.setBorderPainted(false);
		contentPanel.add(rdbtn3P2);

		JRadioButton rdbtn3P3 = new JRadioButton("M\u00E1s de 4");
		grupo3.add(rdbtn3P3);
		rdbtn3P3.setBounds(380, 235, 87, 23);
		rdbtn3P3.setOpaque(false);
		rdbtn3P3.setContentAreaFilled(false);
		rdbtn3P3.setBorderPainted(false);
		contentPanel.add(rdbtn3P3);

		JLabel p4 = new JLabel("4. \u00BFDominas los remates, paralelos, globos y dem\u00E1s?");
		p4.setHorizontalAlignment(SwingConstants.CENTER);
		p4.setFont(new Font("Tahoma", Font.BOLD, 14));
		p4.setBounds(78, 265, 530, 23);
		contentPanel.add(p4);

		JRadioButton rdbtn4P1 = new JRadioButton("Pr\u00E1cticamente nada");
		rdbtn4P1.setBackground(new Color(255, 255, 255));
		grupo4.add(rdbtn4P1);
		rdbtn4P1.setBounds(98, 295, 140, 23);
		rdbtn4P1.setOpaque(false);
		rdbtn4P1.setContentAreaFilled(false);
		rdbtn4P1.setBorderPainted(false);
		contentPanel.add(rdbtn4P1);

		JRadioButton rdbtn4P2 = new JRadioButton("Medianamente");
		grupo4.add(rdbtn4P2);
		rdbtn4P2.setBounds(240, 295, 107, 23);
		rdbtn4P2.setOpaque(false);
		rdbtn4P2.setContentAreaFilled(false);
		rdbtn4P2.setBorderPainted(false);
		contentPanel.add(rdbtn4P2);

		JRadioButton rdbtn4P3 = new JRadioButton("Bastante bien");
		grupo4.add(rdbtn4P3);
		rdbtn4P3.setBounds(360, 295, 107, 23);
		rdbtn4P3.setOpaque(false);
		rdbtn4P3.setContentAreaFilled(false);
		rdbtn4P3.setBorderPainted(false);
		contentPanel.add(rdbtn4P3);

		JRadioButton rdbtn4P4 = new JRadioButton("Los domino");
		grupo4.add(rdbtn4P4);
		rdbtn4P4.setBounds(474, 295, 107, 23);
		rdbtn4P4.setOpaque(false);
		rdbtn4P4.setContentAreaFilled(false);
		rdbtn4P4.setBorderPainted(false);
		contentPanel.add(rdbtn4P4);

		JButton okButton = new JButton("Aceptar");
		okButton.setBounds(505, 342, 82, 23);
		contentPanel.add(okButton);
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (grupo1.isSelected(null) || grupo2.isSelected(null) || grupo3.isSelected(null)
						|| grupo4.isSelected(null)) {

					if (grupo1.isSelected(null)) {
						error1.setVisible(true);
					} else {
						error1.setVisible(false);
					}
					if (grupo2.isSelected(null)) {
						error2.setVisible(true);
					} else {
						error2.setVisible(false);
					}
					if (grupo3.isSelected(null)) {
						error3.setVisible(true);
					} else {
						error3.setVisible(false);
					}
					if (grupo4.isSelected(null)) {
						error4.setVisible(true);
					} else {
						error4.setVisible(false);
					}

				} else {

					int cont = 0;
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

					dispose();
					Lectura.leerDatosRegistro(usuario, clave, CP, calle, numero, cont, pago);
					MenuLogin.mostrarMenuSesion(MenuPrincipal.menuprincipal);
					JOptionPane.showMessageDialog(null, "Te has registrado con \u00e9xito.", "REGISTRO",
							JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
		okButton.setActionCommand("OK");
		getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Volver");
		cancelButton.setBounds(597, 342, 75, 23);
		contentPanel.add(cancelButton);
		cancelButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				dispose();
				MenuRegistroUno.dialogMenuRegistroUno.setVisible(true);
			}

		});
		cancelButton.setActionCommand("Cancel");

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MenuRegistroDos.class.getResource("/vista/fondoregistrouno.jpg")));
		lblNewLabel.setBounds(0, 0, 697, 387);
		contentPanel.add(lblNewLabel);
	}
}
