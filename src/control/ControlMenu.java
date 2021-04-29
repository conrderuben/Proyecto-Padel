package control;

import java.util.ArrayList;
import java.util.List;

import clases.Usuario;
import modelo.dao.RecintosDAO;
import modelo.dao.ReservasDAO;
import modelo.ficheros.EscrituraFichero;
import vista.Escritura;
import vista.Lectura;


public class ControlMenu {
	public static ArrayList<String> listaReservas = new ArrayList<String>();
	public static List<Usuario> listaUsuarios= new ArrayList<Usuario>();
	public static List<Usuario> obtenerDatos() {
		listaUsuarios=Conversiones.obtenerDatos(Main.fileLista);
		return listaUsuarios;
	}
	public static void realizarOpcionMenuPrincipal(int opcion) {
		switch (opcion) {
			
			case 2:break;
		}
		}
	
	
	public static void realizarOpcionMenuSecundario(int opcion) {
		switch (opcion) {
			case 1:ReservasDAO.insertarReserva(Lectura.leerDatosReserva());break;
			case 2:
			case 3:Escritura.mostrarConsultaRecintos(RecintosDAO.consultarRecintos());Escritura.mostrarConsultaReservas(ReservasDAO.obtenerDatosReserva());break;
			case 4:Escritura.mostrarDireccionesAleatorias(Generador.generarDireccionesAleatorias());
			case 5:
			case 6:Escritura.mostrarConsultaReservas(ReservasDAO.obtenerDatosReserva());break;
		}
	}
}
