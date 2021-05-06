package modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecintosDAO {

	public static Scanner scan=new Scanner(System.in);
	public static List<String> consultarRecintos(){
		String codigoPostal;
		List<String> consultaRecintos= new ArrayList<String>();
		ResultSet res=null;
		try {
			EnlaceJDBC enlace=new EnlaceJDBC();
			System.out.println("Escribe el codigoPostal del que quieres consultar los recintos:");
			codigoPostal=scan.next();
			res=enlace.seleccionRegistros("select id_recinto, r.nombre, r.precio, r.codigopostal, d.calle, d.numero from recinto r, direccion d where d.codigoPostal = r.codigoPostal and d.codigoPostal=" + codigoPostal + ";" );
			while(res.next()) {
				consultaRecintos.add("id_Recinto = " + res.getInt(1) + ", nombre = "+ res.getString(2) +", precio = "+ res.getFloat(3) + ", codigoPostal = " + res.getInt(4) + ", calle = " + res.getString(5) + ", numero = " + res.getInt(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return consultaRecintos;
	}
	
	public static List<String> sacarListaRecintos(){
		
		List<String> listaRecintos= new ArrayList<String>();
		ResultSet res=null;
		try {
			EnlaceJDBC enlace=new EnlaceJDBC();
			res=enlace.seleccionRegistros("select nombre from recintos;" );
			while(res.next()) {
				listaRecintos.add(res.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return listaRecintos;
	}
	
public static String sacarNombreRecinto(String id_pista){
		
		String nombre="";
		ResultSet res=null;
		try {
			EnlaceJDBC enlace=new EnlaceJDBC();
			res=enlace.seleccionRegistros("select nombre from recintos where id_recinto=(select id_recinto from pistas where id_pista=" + id_pista + ");" );
			while(res.next()) {
				nombre=res.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return nombre;
	}

public static float sacarPrecioRecinto(String id_pista){
	
	float precio=0;
	ResultSet res=null;
	try {
		EnlaceJDBC enlace=new EnlaceJDBC();
		res=enlace.seleccionRegistros("select precio from recintos where id_recinto=(select id_recinto from pistas where id_pista=" + id_pista + ");" );
		while(res.next()) {
			precio=res.getFloat(1);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return precio;
}
}
