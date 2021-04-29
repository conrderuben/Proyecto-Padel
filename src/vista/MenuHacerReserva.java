package vista;

import java.awt.BorderLayout;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.dao.PistasDAO;
import modelo.dao.RecintosDAO;
import modelo.dao.ReservasDAO;

import java.awt.Window.Type;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowEvent;

import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.event.WindowAdapter;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuHacerReserva extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	
	public static void mostrarMenuHacerReserva(JFrame menuprincipal) {
		
		MenuHacerReserva dialog = new MenuHacerReserva(menuprincipal);
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
	}

	public MenuHacerReserva(JFrame menuprincipal) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuHacerReserva.class.getResource("/vista/icono.png")));
		
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				String Botones[] = {"Salir", "Cancelar"};
				int resultado = JOptionPane.showOptionDialog(null, "¿Estás seguro de que quieres salir de la aplicación?", "SALIDA", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, Botones, Botones[1]);
				if (resultado == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		
		
		ArrayList seleccion= new ArrayList(); 
		setTitle("PLEITOMYK - DATOS RESERVA");
		setResizable(false);
		setBounds(100, 100, 601, 374);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setToolTipText("");
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("RECINTO: ");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(81, 61, 125, 32);
		contentPanel.add(lblNewLabel);
		JComboBox comboBox = new JComboBox(RecintosDAO.sacarListaRecintos().toArray());
		comboBox.setToolTipText("selecciona");
		comboBox.setBounds(321, 71, 148, 22);
		contentPanel.add(comboBox);
		
		JLabel lblPista = new JLabel("PISTA:");
		lblPista.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPista.setBounds(81, 142, 125, 34);
		contentPanel.add(lblPista);
		
		JComboBox comboBox_1 = new JComboBox(seleccion.toArray());
		comboBox_1.setBounds(321, 152, 148, 22);
		contentPanel.add(comboBox_1);
		
		
	
		table = new JTable();
		table.setBounds(243, 300, 37, -24);
		contentPanel.add(table);
		
		JLabel lblFecha = new JLabel("FECHA:");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFecha.setBounds(81, 229, 125, 34);
		contentPanel.add(lblFecha);
		
		JDateChooser calendar = new JDateChooser();
		calendar.setBounds(318, 239, 151, 20);
		contentPanel.add(calendar);
		
		JButton btnReservar = new JButton("RESERVAR");
		btnReservar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnReservar.setBackground(new java.awt.Color(5,188,27));
				
			}
			
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnReservar.setBackground(new java.awt.Color(153,204,102));
			}
		});
		btnReservar.setBackground(new Color(153, 204, 102));
		btnReservar.setForeground(new Color(0, 0, 0));
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				ArrayList<String> listaReservas = new ArrayList<String>();
				String fecha;
				fecha=(calendar.getDate().getYear()+1900) + "-" + (calendar.getDate().getMonth() + 1) + "-" + calendar.getDate().getDate();
				if((calendar.getDate().getMonth() + 1 + "").length()==1 ) {
					fecha=(calendar.getDate().getYear()+1900) + "-0" + (calendar.getDate().getMonth() + 1) + "-" + calendar.getDate().getDate();
				}
				if((calendar.getDate().getDate()+ "").length()==1 ) {
					fecha=(calendar.getDate().getYear()+1900) + "-" + (calendar.getDate().getMonth() + 1) + "-0" + calendar.getDate().getDate();
				}
				if((calendar.getDate().getDate()+ "").length()==1 && (calendar.getDate().getMonth() + 1 + "").length()==1) {
					fecha=(calendar.getDate().getYear()+1900) + "-0" + (calendar.getDate().getMonth() + 1) + "-0" + calendar.getDate().getDate();
				}
				System.out.println(fecha);
				listaReservas.add(PistasDAO.obtenerIdPista(comboBox_1.getSelectedItem().toString(), comboBox.getSelectedItem().toString().toString()) + "");
				listaReservas.add(fecha);
				
				
					ReservasDAO.insertarReserva(listaReservas);
				}catch (Exception e){
					JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos.", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnReservar.setBounds(180, 300, 103, 22);
		contentPanel.add(btnReservar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCancelar.setBackground(new java.awt.Color(5,188,27));
				
				
			}
			
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnCancelar.setBackground(new java.awt.Color(153,204,102));
			}
		});
		btnCancelar.setBackground(new Color(153, 204, 102));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				menuprincipal.setVisible(true);
			}
		});
		btnCancelar.setBounds(299, 300, 100, 22);
		contentPanel.add(btnCancelar);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MenuHacerReserva.class.getResource("/vista/reservas2jpg.jpg")));
		lblNewLabel_1.setBounds(0, 0, 595, 345);
		contentPanel.add(lblNewLabel_1);
		
		
		
		
		
		
		comboBox.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				ArrayList seleccion=PistasDAO.sacarListaNumPista(comboBox.getSelectedItem().toString());
				comboBox_1.removeAllItems();
				for(int i=0; i< seleccion.size(); i++ ) {

					comboBox_1.addItem(seleccion.get(i));
				}
				
				
				
			}
		});
	}
}
