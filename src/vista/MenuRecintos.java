package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

public class MenuRecintos extends JDialog {
	private JTable table;
	
	public static void mostrarMenuRecintos(JFrame menuprincipal) {
	MenuRecintos dialog = new MenuRecintos();
	dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	dialog.setVisible(true);
	}

	public MenuRecintos() {
		setBounds(100, 100, 986, 556);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(268, 133, 381, 141);
		getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		String[] cabecera= {"ID", "NOMBRE", "PAIS"};
		Object[][] datos= {{1,"Madrid", "España"}, {2, "Roma", "Italia"}, {3,"París", "Francia"}};
		table = new JTable(datos,cabecera);
		panel.add(table);
		
		
		
		
	
		
		
		
		
		
		
		
		
		
		
	}
}
