package modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquiposDAO {

		public static void insertarEquipo(String nombre, String usuario) {
			
			try {
				EnlaceJDBC enlace=new EnlaceJDBC();
				enlace.insertar("Insert into equipos values(0, '" + nombre + "' );");
				enlace.update("update usuarios set id_equipo=(select id_equipo from equipos where nombre = '" +nombre+ "') where nombre = '" + usuario + "';" );
					
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		public static String obtenerEquipo(String usuario){
			String equipo="";
			ResultSet res=null;
			try {
				EnlaceJDBC enlace=new EnlaceJDBC();
				res=enlace.seleccionRegistros("select nombre from equipos where id_equipo=(select id_equipo from usuarios where nombre ='" + usuario +"');");
				while(res.next()) {
					equipo=res.getString(1);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return equipo;
		}
		
		public static List<String> obtenerJugadores(String equipo){
			List<String> consultaJugadores= new ArrayList<String>();
			ResultSet res=null;
			try {
				EnlaceJDBC enlace=new EnlaceJDBC();
				res=enlace.seleccionRegistros("select nombre from usuarios where id_equipo=(select id_equipo from equipos where nombre= '" + equipo + "');");
				while(res.next()) {
					consultaJugadores.add(res.getString(1));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return consultaJugadores;
		}
		
		
	
}
