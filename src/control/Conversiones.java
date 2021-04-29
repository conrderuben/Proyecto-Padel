package control;

import java.util.ArrayList;
import java.util.List;

import clases.Direccion;
import clases.Usuario;

public class Conversiones {
	public static List<Usuario> obtenerDatos(List<String> fileLista) {
		List<Usuario> listaUsuarios= new ArrayList<Usuario>();
		String[] campos;
		
		
		for (String l: fileLista) {
			campos=l.split(";");
			listaUsuarios.add(new Usuario(Integer.parseInt(campos[0]), campos[1], campos[2],new Direccion(Integer.parseInt(campos[3]),Integer.parseInt(campos[4]),campos[5],Integer.parseInt(campos[6])),campos[7].charAt(0),Integer.parseInt(campos[8]),Integer.parseInt(campos[9])));
	}
		return listaUsuarios;
	}
}
