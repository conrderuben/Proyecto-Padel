package vista;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import clases.Direccion;
import clases.Usuario;



public class Escritura {
	public static void mostrarDatos(List<Usuario> listaUsuarios) {
		
	
		for (Usuario u: listaUsuarios) {
			System.out.println("Metodo de Pago: " + u.getMetodoPago() + " - Nombre usuario: " + u.getNombre() + " - Clave: " + u.getClave());
			
		}
		
	}
	public static void mostrarConsultaReservas(List<String> consultaReservas) {
		System.out.println("\nCOD - ID  - DATE\n");
		for(String s: consultaReservas) {
			System.out.println(s);
	}
		System.out.println();
}
	public static void mostrarConsultaRecintos(List<String> consultaReservas) {
		for(String s: consultaReservas) {
			System.out.println(s);
		}
	}
	public static void mostrarDireccionesAleatorias(ArrayList<Direccion> direccionesAleatorias) {
		for(Direccion d: direccionesAleatorias) {
			System.out.println(d.getCodigoPostal() + " | " + d.getCalle() + " | " + d.getNumero());
		}
	}
	public static void mostrarConsultaPistas(List<String> consultaPistas) {
		for(String s: consultaPistas) {
			System.out.println(s);
	}
		System.out.println();
}
}
