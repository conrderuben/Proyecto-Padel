package modelo.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import clases.Direccion;

public class DireccionesDAO {

public static void insertarDireccion(Direccion dir) {
		
		try {
			EnlaceJDBC enlace=new EnlaceJDBC();
			enlace.insertar("Insert into direcciones values(" + dir.getIdDireccion() + "," + dir.getCodigoPostal() + ",'" + dir.getCalle() + "'," + dir.getNumero()+ ");");
				System.out.println("El elemento se ha insertado correctamente");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
