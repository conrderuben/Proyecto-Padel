package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.dao.EquiposDAO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class MenuEquipos extends JDialog {

	private JTextField textCrearEquipo;
	private JTextField textEquipoActual;
	private JTextField textAgregarJugador;

	private final JPanel contentPanel = new JPanel();

	static String usuario;

	public static String datosUsuario(String user) {
		return user;
	}

	public static void mostrarMenuEquipos(JFrame menuprincipal) {
		MenuEquipos dialog = new MenuEquipos(menuprincipal);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}

	public MenuEquipos(JFrame menuprincipal) {

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

		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuEquipos.class.getResource("/vista/icono.png")));
		setTitle("PLEITOMYK - EQUIPOS");

		setBounds(100, 100, 791, 513);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 197, 775, 277);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_3_1 = new JLabel("Tu equipo actual");
		lblNewLabel_3_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3_1.setBounds(55, 87, 150, 23);
		panel_1.add(lblNewLabel_3_1);

		textEquipoActual = new JTextField(EquiposDAO.obtenerEquipo(MenuPrincipal.usuario));
		textEquipoActual.setHorizontalAlignment(SwingConstants.CENTER);
		textEquipoActual.setBackground(Color.LIGHT_GRAY);
		textEquipoActual.setColumns(10);
		textEquipoActual.setBounds(263, 91, 173, 20);
		panel_1.add(textEquipoActual);

		JLabel lblNewLabel_4 = new JLabel("Miembros del equipo");
		lblNewLabel_4.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(544, 26, 147, 27);
		panel_1.add(lblNewLabel_4);

		
		DefaultListModel modelo= new DefaultListModel();
		modelo.addAll(EquiposDAO.obtenerJugadores(textEquipoActual.getText()));
		
		
		JList list = new JList(modelo);
		list.setBackground(Color.LIGHT_GRAY);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(502, 73, 229, 152);
		panel_1.add(scrollPane);

		JLabel lblNewLabel_1_1 = new JLabel("Cambiar miembros del equipo");
		lblNewLabel_1_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(137, 28, 251, 21);
		panel_1.add(lblNewLabel_1_1);

		JLabel lblNewLabel_3_1_1 = new JLabel("A\u00f1adir jugador");
		lblNewLabel_3_1_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3_1_1.setBounds(23, 173, 150, 23);
		panel_1.add(lblNewLabel_3_1_1);

		textAgregarJugador = new JTextField();
		textAgregarJugador.setColumns(10);
		textAgregarJugador.setBackground(Color.LIGHT_GRAY);
		textAgregarJugador.setBounds(201, 177, 155, 20);
		panel_1.add(textAgregarJugador);

		JButton btnAgregarJugador = new JButton("A\u00f1adir\r\n");
		btnAgregarJugador.setForeground(Color.DARK_GRAY);
		btnAgregarJugador.setBackground(Color.LIGHT_GRAY);
		btnAgregarJugador.setBounds(395, 176, 89, 23);
		panel_1.add(btnAgregarJugador);

		JButton btnBorrarJugador = new JButton("Borrar jugador seleccionado");
		btnBorrarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					EquiposDAO.borrarJugadorEquipo(list.getSelectedValue().toString());
					modelo.remove(list.getSelectedIndex());
				}catch(Exception E){
					JOptionPane.showMessageDialog(null, "Debes selccionar un jugador", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnBorrarJugador.setForeground(Color.DARK_GRAY);
		btnBorrarJugador.setBackground(Color.LIGHT_GRAY);
		btnBorrarJugador.setBounds(502, 236, 229, 23);
		panel_1.add(btnBorrarJugador);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 775, 196);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Nombre del equipo");
		lblNewLabel_3.setBackground(Color.DARK_GRAY);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(80, 136, 150, 21);
		panel.add(lblNewLabel_3);

		textCrearEquipo = new JTextField();
		textCrearEquipo.setHorizontalAlignment(SwingConstants.CENTER);
		textCrearEquipo.setForeground(Color.DARK_GRAY);
		textCrearEquipo.setBackground(new Color(169, 169, 169));
		textCrearEquipo.setColumns(10);
		textCrearEquipo.setBounds(309, 137, 202, 20);
		panel.add(textCrearEquipo);

		JLabel lblNewLabel_1 = new JLabel("Crear un nuevo equipo");
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setBackground(Color.DARK_GRAY);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(300, 80, 172, 21);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Men\u00fa de equipos");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel_2.setBounds(215, 28, 323, 41);
		panel.add(lblNewLabel_2);

		JButton btnCrearEquipo = new JButton("Crear equipo");
		btnCrearEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EquiposDAO.insertarEquipo(textCrearEquipo.getText(), MenuPrincipal.usuario);
				textEquipoActual.setText(EquiposDAO.obtenerEquipo(MenuPrincipal.usuario));
				textCrearEquipo.setText(null);
			}
		});
		btnCrearEquipo.setForeground(Color.DARK_GRAY);
		btnCrearEquipo.setBackground(new Color(128, 128, 128));
		btnCrearEquipo.setBounds(563, 136, 128, 23);
		panel.add(btnCrearEquipo);
		
		JButton btnback = new JButton("<<");
		btnback.setForeground(Color.LIGHT_GRAY);
		btnback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnback.setBackground(Color.LIGHT_GRAY);
				btnback.setForeground(Color.DARK_GRAY);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnback.setBackground(Color.DARK_GRAY);
				btnback.setForeground(Color.LIGHT_GRAY);
			}
		});
		btnback.setBackground(Color.DARK_GRAY);
		btnback.setForeground(Color.LIGHT_GRAY);
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				menuprincipal.setVisible(true);
				
			}
		});
		btnback.setBounds(10, 11, 53, 23);
		panel.add(btnback);
	}
}
