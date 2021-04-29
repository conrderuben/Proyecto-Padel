package control;

import java.util.List;

import javax.swing.JOptionPane;

import modelo.ficheros.LecturaFichero;
import vista.MenuPrincipal;

public class InicioSesion {
	public static List<String> listaDatosUsuarios;

	public static String verificaUsuario(String usuario) {
		String clave = "";
		listaDatosUsuarios = LecturaFichero.lecturaCompletaLineas("Files/DatosUsuarios.csv");
		String[] array;
		for (String s : listaDatosUsuarios) {
			array = s.split(";");
			if (array[1].equals(usuario)) {
				clave = array[2];
				return clave;
			}

		}
		
		return clave;
	}
}
