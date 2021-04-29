package modelo.ficheros;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import clases.Usuario;

public class EscrituraFichero {
	public static void escribirFicheroCompleto(String fichero, Usuario user) {
		//Escritura en un fichero de una vez, con una lista de Strings		
			Path salida = Paths.get(fichero);						
			Charset charset=StandardCharsets.ISO_8859_1;
			List<String> con= new ArrayList<String>();
			OpenOption[] options =new OpenOption[2];
			options[0] = StandardOpenOption.APPEND;
			options[1] = StandardOpenOption.WRITE;
			
			con.add(user.getIdUsuario() + ";" + user.getNombre() + ";" + user.getClave() + ";" + user.getNivel() + ";" + user.getMetodoPago() + ";" +user.getPuntuacion());
				
			
			try {
				
				Files.write(salida, con ,charset, options);
			} catch (IOException io) {
				System.err.println(io);
			}
		}
}

