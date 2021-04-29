package control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import clases.Direccion;

public class Generador {
	public static Random rnd= new Random();
	public static ArrayList<Direccion> generarDireccionesAleatorias(){
		int cont=0;
		int[] codigos={28512, 28514, 28830, 28510, 29200, 28680, 28710, 28713, 28340, 29110, 28640, 28880, 28990, 28500,28328};
		
		String[] calles={"Calle Mayor", "Calle 9", "Av de la Paz", "Av. de Ramon y Cajal", "Calle de Hermosilla","Calle Antonio Machado", 
				"Calle Picaso", "Calle Alcala", "Calle Cristobal Colon","Av. Constitucion" };
		ArrayList<Direccion> direccionesAleatorias =new ArrayList<Direccion>();
		
		for (int i=0; i<10; i++) {
			direccionesAleatorias.add(new Direccion(cont++,codigos[rnd.nextInt(15)], calles[rnd.nextInt(10)], rnd.nextInt(99)+1));
		}
		return direccionesAleatorias;
	}
}
