package modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservasDAO {
	public static void insertarReserva(ArrayList<String> listaReservas) {
		
		try {
			EnlaceJDBC enlace=new EnlaceJDBC();
			enlace.insertar("Insert into reservas values(0, '" + listaReservas.get(1) + "', '" + listaReservas.get(0) + "');");
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static List<String> obtenerDatosReserva(){
		List<String> consultaReservas= new ArrayList<String>();
		ResultSet res=null;
		try {
			EnlaceJDBC enlace=new EnlaceJDBC();
			res=enlace.seleccionRegistros("select * from reservas");
			while(res.next()) {
				consultaReservas.add(res.getString(1) +" | "+ res.getInt(2) +" | "+ res.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return consultaReservas;
	}
	
	
	
}