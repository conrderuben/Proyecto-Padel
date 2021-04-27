package modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import clases.Usuario;

public class UsuariosDAO {

	public static void insertarUsuario(Usuario u) {

		try {
			EnlaceJDBC enlace = new EnlaceJDBC();

			enlace.insertar("Insert into usuarios values(" + u.getIdUsuario() + ",'" + u.getNombre()
					+ "', (select id_direccion from direcciones where codigoPostal = "
					+ u.getdUsuario().getCodigoPostal() + " and calle= '" + u.getdUsuario().getCalle()
					+ "' and numero= " + u.getdUsuario().getNumero() + "), 1 );");
			System.out.println("El elemento se ha insertado correctamente");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static boolean comprobarUsuario(String u) {

		try {

			if (u.isBlank()) {
				return false;
			}

			EnlaceJDBC enlace = new EnlaceJDBC();
			ResultSet usuarios = enlace.seleccionRegistros("select nombre from usuarios;");
			while (usuarios.next()) {
				if (u.toLowerCase().equals(usuarios.getString(1).toLowerCase())) {
					return false;
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;

	}

}
