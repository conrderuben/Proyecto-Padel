package modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import clases.Reserva;
import vista.MenuPrincipal;

public class ReservasDAO {
	public static void insertarReserva(ArrayList<String> listaReservas) {
		
		try {
			EnlaceJDBC enlace=new EnlaceJDBC();
			enlace.insertar("Insert into reservas values(0, '" + listaReservas.get(1) + "', '" + listaReservas.get(0) + "', (select id_usuario from usuarios where nombre= '" + MenuPrincipal.DatosUsuario() + "'));");
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static List<Reserva> obtenerDatosReserva(){
		List<Reserva> consultaReservas= new ArrayList<Reserva>();
		ResultSet res=null;
		try {
			EnlaceJDBC enlace=new EnlaceJDBC();
			res=enlace.seleccionRegistros("select * from reservas where id_usuario=(select id_usuario from usuarios where nombre='" + MenuPrincipal.DatosUsuario() + "');");
			while(res.next()) {
				consultaReservas.add(new Reserva(res.getString(1), res.getInt(3), res.getString(2), res.getInt(4)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return consultaReservas;
	}
	
	
	
}