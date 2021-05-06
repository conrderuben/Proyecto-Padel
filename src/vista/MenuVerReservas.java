package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.sun.tools.javac.util.List;

import clases.Reserva;
import modelo.dao.PistasDAO;
import modelo.dao.RecintosDAO;
import modelo.dao.ReservasDAO;


import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class MenuVerReservas extends JDialog {

	private final JPanel contentPanel = new JPanel();

	static String usuario;
	private JTable table;
	private JTextField textRecinto;
	private JTextField textCubierta;
	private JTextField textPrecio;

	public static String datosUsuario(String user) {
		return user;
	}

	public static void mostrarMenuVerReservas(JFrame menuprincipal) {
		MenuVerReservas dialog = new MenuVerReservas(menuprincipal);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}

	public MenuVerReservas(JFrame menuprincipal) {

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
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuVerReservas.class.getResource("/vista/icono.png")));
		setTitle("PLEITOMYK - VER RESERVAS");
		setBounds(100, 100, 764, 477);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TUS RESERVAS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel.setBounds(251, 11, 291, 39);
		contentPanel.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(97, 81, 581, 200);
		contentPanel.add(panel);
		
		
		String[] cabecera= {"COD_RESERVA", "ID_PISTA", "FECHA"};
		
		java.util.List<Reserva> lista= new ArrayList<Reserva>();
				lista= ReservasDAO.obtenerDatosReserva();
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(cabecera);
		for(int i=0;i<lista.size();i++){
		    modelo.addRow(new Object[] {lista.get(i).getCodReserva(), lista.get(i).getPistaR(), lista.get(i).getFecha()});
		}
		
		
		table = new JTable(modelo);
		table.setCellSelectionEnabled(true);
		
		JScrollPane scroll =new JScrollPane(table);
		panel.add(scroll);
		
		JButton btnNewButton = new JButton("Obtener datos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(283, 292, 226, 23);
		contentPanel.add(btnNewButton);
		
		textRecinto = new JTextField();
		textRecinto.setBounds(128, 391, 187, 20);
		contentPanel.add(textRecinto);
		textRecinto.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Recinto");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(58, 388, 81, 21);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Pista cubierta");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(339, 390, 110, 17);
		contentPanel.add(lblNewLabel_1_1);
		
		textCubierta = new JTextField();
		textCubierta.setBounds(458, 391, 59, 20);
		contentPanel.add(textCubierta);
		textCubierta.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Precio");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(547, 394, 59, 17);
		contentPanel.add(lblNewLabel_1_1_1);
		
		textPrecio = new JTextField();
		textPrecio.setColumns(10);
		textPrecio.setBounds(606, 391, 59, 20);
		contentPanel.add(textPrecio);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("€");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_1_1.setBounds(675, 394, 59, 17);
		contentPanel.add(lblNewLabel_1_1_1_1);
		
		JButton btnback = new JButton("<<");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				menuprincipal.setVisible(true);
			}
		});
		btnback.setForeground(Color.LIGHT_GRAY);
		btnback.setBackground(Color.DARK_GRAY);
		btnback.setBounds(21, 11, 53, 23);
		contentPanel.add(btnback);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(MenuVerReservas.class.getResource("/vista/tusreservas.jpg")));
		lblNewLabel_2.setBounds(0, 0, 769, 438);
		contentPanel.add(lblNewLabel_2);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textRecinto.setText(RecintosDAO.sacarNombreRecinto(modelo.getValueAt(table.getSelectedRow(), 1).toString()));
				if(PistasDAO.sacarPistaCubierta(modelo.getValueAt(table.getSelectedRow(), 1).toString())==1) {
					textCubierta.setText("SI");
				}else if(PistasDAO.sacarPistaCubierta(modelo.getValueAt(table.getSelectedRow(), 1).toString())==0) {
					textCubierta.setText("NO");
				}
				textPrecio.setText(""+RecintosDAO.sacarPrecioRecinto(modelo.getValueAt(table.getSelectedRow(), 1).toString()));
			}
		});
		
	}
}
