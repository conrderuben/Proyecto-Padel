package control;

import java.util.Scanner;

import javax.swing.JOptionPane;

import java.util.Random;

public class Clave {

	public static Scanner sc = new Scanner(System.in);
	public static Random rnd = new Random();

	public static boolean loginClave(String claveAlmacenada, String claveIntroducida) {


		if (crearClaveCifrada(claveIntroducida).equals(claveAlmacenada)) {
			return true;
		} else {
			return false;
		}

	}

	public static String crearClaveCifrada(String clave) {

		String secreto = "camaleondavidcamaleonrubencamaleonisicamaleonrubencamaleonisicamaleondavid";
		String resultado = "";

		for (int i = 0; i < clave.length(); i++) {
			resultado += clave.charAt(i) + secreto.charAt(i);
		}

		return resultado;

	}

	public static boolean comprobar(String clave) {

		boolean tieneMay = false;
		boolean tieneNum = false;
		boolean tieneSim = false;

		if (clave.length() < 8 || clave.length() > 20) {
//			JOptionPane.showMessageDialog(null, "La longitud de la clave es incorrecta, debe tener entre 8 y 20 caracteres.");
			return true;
		}

//		for (int i = 0; i < clave.length(); i++) {
//			if (clave.charAt(i) < 5 || clave.charAt(i) > 127) {
//				JOptionPane.showMessageDialog(null, "Car\u00e1cter inv\u00e1lido detectado: " + clave.charAt(i));
//				return true;
//			}
//		}

		for (int i = 0; i < clave.length(); i++) {
			if (clave.charAt(i) > 47 && clave.charAt(i) < 58) {
				tieneNum = true;
			}
		}

		for (int i = 0; i < clave.length(); i++) {
			if (clave.charAt(i) > 64 && clave.charAt(i) < 91) {
				tieneMay = true;
			}
		}

		for (int i = 0; i < clave.length(); i++) {
			if ((clave.charAt(i) > 31 && clave.charAt(i) < 48) || (clave.charAt(i) > 57 && clave.charAt(i) < 65)) {
				tieneSim = true;
			}
		}

		if (tieneNum && tieneMay && tieneSim) {
			return false;
		} else {
//			JOptionPane.showMessageDialog(null, "Tu clave debe tener entre 8 y 20 caracteres, y contener al menos una may\u00fascula, un n\u00famero y un car\u00e1cter especial");
			return true;
		}

	}

	public static void main() {

		boolean noValida = true;
		String clave = "";

		while (noValida) {
			System.out.println("Introduce una contrase\u00f1a: ");
			clave = sc.nextLine();
			noValida = comprobar(clave);
		}



		

	}

}