package modelo.ficheros;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;



public class LecturaFichero {
	
	
	public static List<String> lecturaCompletaLineas(String fichero) {
		
		Path file = Paths.get(fichero);	
		Charset charset=StandardCharsets.ISO_8859_1;
		List<String> fileLista = null;
		
		try {			
			fileLista = Files.readAllLines(file, charset);		
		} catch (IOException io) {
			System.err.println(io);
		}
		return fileLista;

	}
}