package vista;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import clases.Direccion;
import clases.Usuario;
import control.Clave;
import control.InicioSesion;
import control.Main;
import modelo.dao.DireccionesDAO;
import modelo.dao.PistasDAO;
import modelo.dao.UsuariosDAO;
import modelo.ficheros.EscrituraFichero;

public class Lectura {
	static Scanner scan = new Scanner(System.in);

	public static int leerOpcion() {
		System.out.println();
		System.out.print("\t     >> ");
		return scan.nextInt();
	}

	public static ArrayList<String> leerDatosReserva() {
		String s = "";
		int n = 0;
		String n2 = "";
		scan.nextLine();
		ArrayList<String> listaReservas = new ArrayList<String>();
		System.out.println("Selecciona el nombre del recinto:");
		s = scan.nextLine();
		System.out.println("Elige el n\u00famero de pista");
		n = PistasDAO.obtenerIdPista(scan.next(), s);
		PistasDAO.ocuparPista(n);
		n2 = "" + n;
		listaReservas.add(n2);
		System.out.println("Escribe la fecha de la reserva: (yyyy-mm-dd)");
		listaReservas.add(scan.next());
		return listaReservas;
	}

	public static void leerDatosLogin(String usuario, String claveIntroducida) {

		String claveAlmacenada = "";
		boolean invalido = true;

		while (invalido) {
			claveAlmacenada = InicioSesion.verificaUsuario(usuario);
			if (claveAlmacenada.equals("")) {
				JOptionPane.showMessageDialog(null, "Usuario no encontrado", "ERROR", JOptionPane.ERROR_MESSAGE);
				vista.MenuLogin.mostrarMenuSesion(MenuPrincipal.menuprincipal);
				invalido = false;
			} else {
				if (Clave.loginClave(claveAlmacenada, claveIntroducida)) {
//					JOptionPane.showMessageDialog(null, "Contrase\u00f1a correcta");
					MenuPrincipal.usuario = MenuPrincipal.datosUsuario(usuario);
					MenuPrincipal.menuprincipal.setVisible(true);
					invalido = false;
				} else {
					JOptionPane.showMessageDialog(null, "Contrase\u00f1a incorrecta");
					vista.MenuLogin.mostrarMenuSesion(MenuPrincipal.menuprincipal);
					invalido = false;
				}
			}
		}
	}

	public static void leerDatosRegistro(String nombre, String clave, int codigoPostal, String calle, int numero,
			int cont, int mPago) {

		Direccion dir;
		int idUsuario = 0;
		String claveCifrada = "";
		char nivel = 'n';
		int puntuacion = 0;
		int id = 0;
		boolean noValido = true;
		noValido = Clave.comprobar(clave);

		if (!noValido) {
			try {
				claveCifrada = Clave.crearClaveCifrada(clave);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Se ha producido un error en el cifrado");
			}

			dir = new Direccion(0, codigoPostal, calle, numero);
			DireccionesDAO.insertarDireccion(dir);

			if (cont < 15) {
				nivel = 'B';
			} else if (cont > 15 && cont < 25) {
				nivel = 'M';
			} else if (cont > 25 && cont < 35) {
				nivel = 'A';
			} else if (cont == 35) {
				nivel = 'S';
			}
			Usuario user = new Usuario(idUsuario, nombre, claveCifrada,
					new Direccion(id++, codigoPostal, calle, numero), nivel, mPago, puntuacion);
			UsuariosDAO.insertarUsuario(user);
			EscrituraFichero.escribirFicheroCompleto("Files/DatosUsuarios.csv", user);
		}
	}
}
