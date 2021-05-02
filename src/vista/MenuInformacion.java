package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MenuInformacion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public static MenuInformacion dialogMenuInformacion = new MenuInformacion();

	public static void mostrarMenuInformacion(JFrame menuprincipal) {
		dialogMenuInformacion.setVisible(true);
	}

	public MenuInformacion() {
		setTitle("PLEITOMYK - SOBRE NOSOTROS");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuInformacion.class.getResource("/vista/icono.png")));
		setResizable(false);
		setBounds(100, 100, 456, 310);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel imagen = new JLabel("");
		imagen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				MenuPrincipal.menuprincipal.setVisible(true);
			}
		});
		imagen.setIcon(new ImageIcon(MenuInformacion.class.getResource("/vista/pintura3.png")));
		imagen.setBounds(0, 0, 450, 281);
		contentPanel.add(imagen);

		JLabel textoTitulo = new JLabel("Pleitomyk");
		textoTitulo.setBackground(Color.WHITE);
		textoTitulo.setForeground(Color.BLACK);
		textoTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		textoTitulo.setFont(new Font("Cambria", Font.BOLD, 32));
		textoTitulo.setBounds(0, 11, 450, 59);
		contentPanel.add(textoTitulo);

		JTextPane textoInfo = new JTextPane();
		textoInfo.setForeground(Color.BLACK);
		textoInfo.setFont(new Font("Garamond", Font.BOLD, 16));
		textoInfo.setText(
				"Somos la aplicaci\u00F3n n\u00FAmero uno con la que podr\u00E1s hacer\r\nreservas de tus pistas de p\u00E1del favoritas. Tambi\u00E9n puedes\r\ncompetir en un equipo e ir mejorando tu nivel de juego, y\r\nechar un vistazo a nuestra tienda para comprar todo el \r\nequipo que te haga falta.\r\n\r\n- Pleitomyk.");
		textoInfo.setBounds(0, 75, 450, 163);
		textoInfo.setOpaque(false);
		textoInfo.setEditable(false);
		contentPanel.add(textoInfo);

		JLabel textoAyuda = new JLabel("Haz clic para regresar.");
		textoAyuda.setBackground(Color.GRAY);
		textoAyuda.setForeground(Color.BLACK);
		textoAyuda.setHorizontalAlignment(SwingConstants.CENTER);
		textoAyuda.setFont(new Font("Garamond", Font.BOLD | Font.ITALIC, 12));
		textoAyuda.setBounds(0, 224, 450, 37);
		contentPanel.add(textoAyuda);

		StyledDocument doc = textoInfo.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);

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
				imagen.requestFocus();
			}
		});
	}
}
