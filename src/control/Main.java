package control;

//import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import clases.Direccion;
import clases.Usuario;
import modelo.ficheros.LecturaFichero;
import vista.MenuInicio;
import vista.MenuPrincipal;

public class Main {
	public static List<String> fileLista = new ArrayList<String>();

	public static void leerDatosIniciales(String fichero) {
		fileLista = LecturaFichero.lecturaCompletaLineas(fichero);
	}

	public static void main(String[] args) {

		MenuPrincipal.menuprincipal.setVisible(false);
		MenuInicio.mostrarMenuInicio(MenuPrincipal.menuprincipal);
		

	}
}
