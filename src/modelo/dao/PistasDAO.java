package modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PistasDAO {

	public static List<String> obtenerDatosPistas(String nombreRecinto){
		List<String> consultaPistas= new ArrayList<String>();
		ResultSet res=null;
		try {
			EnlaceJDBC enlace=new EnlaceJDBC();
			res=enlace.seleccionRegistros("select * from pistas where id_recinto = (select id_recinto from recintos where nombre = '" + nombreRecinto + "' and disponible = 1);");
			while(res.next()) {
				consultaPistas.add("id_pista: " + res.getInt(1) +" | n_pista: "+ res.getInt(2) +" | cubierta: "+ res.getBoolean(3)+" | disponible: " + res.getBoolean(4) + " | id_recinto: " + res.getInt(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return consultaPistas;
	}
	
	public static int  obtenerIdPista(String numeroPista, String nombreRecinto) {
		int idPista=0;
		ResultSet res=null;
		try {
			EnlaceJDBC enlace=new EnlaceJDBC();
			res=enlace.seleccionRegistros("select id_pista from pistas where n_pista = '" + numeroPista + "' and id_recinto = (select id_recinto from recintos where nombre = '" + nombreRecinto + "' and disponible = 1);");
			while(res.next()) {
				idPista=res.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return idPista;
		
	}
	
	public static void ocuparPista(int idPista) {
		try {
			EnlaceJDBC enlace=new EnlaceJDBC();
			
			enlace.insertar("Update pistas set disponible = 0 where id_pista= " + idPista + ";");
				System.out.println("El elemento se ha actualizado correctamente");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
public static ArrayList sacarListaNumPista(String recinto){
		
		ArrayList listaPistas= new ArrayList();
		ResultSet res=null;
		try {
			EnlaceJDBC enlace=new EnlaceJDBC();
			res=enlace.seleccionRegistros("select n_pista from pistas where id_recinto= (select id_recinto from recintos where nombre = '" + recinto + "' and disponible = 1);" );
			while(res.next()) {
				
				listaPistas.add(res.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return listaPistas;
	}

public static int sacarPistaCubierta(String id_pista){
	
	int n=3;
	ResultSet res=null;
	try {
		EnlaceJDBC enlace=new EnlaceJDBC();
		res=enlace.seleccionRegistros("select cubierta from pistas where id_pista=" + id_pista + ";" );
		while(res.next()) {
			
			n=res.getInt(1);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return n;
	
}
}

