package appdniprofe;

import java.util.Scanner;

public class MainDniExtranjero {

	public static void main(String[] args) {
		// TODO pedir un dni extranjero
		// número y letra de (prefijo)
		// y calcularle su letra

		// Z0120994 -- L

		// https://www.interior.gob.es/opencms/es/servicios-al-ciudadano/tramites-y-gestiones/dni/calculo-del-digito-de-control-del-nif-nie/

		Scanner scanner = new Scanner(System.in);// pàra leer de teclado

		// PEIDO NÚMERO
		System.out.println("INTRO DNI");
		String caddni = scanner.next();

		// PIDO LETRA

		System.out.println("INTRO LETRA");
		String letra = scanner.next();
		String letraMayuscula = letra.toUpperCase();

		/*
		if (letraMayuscula.equals("X")) {
			System.out.println("El usuario introdujo X");
		} else if (letraMayuscula.equals("Y")) {
			System.out.println("El usuario introdujo Y");
		} else if (letraMayuscula.equals("Z")) {
			System.out.println("El usuario introdujo Z");
		}*/

		switch (letraMayuscula) {
		case "X":
			System.out.println("El usuario introdujo X case");
			caddni = "0"+caddni;
			break;
		case "Y":
			System.out.println("El usuario introdujo Y case");
			caddni = "1"+caddni;
			break;
		case "Z":
			System.out.println("El usuario introdujo Z case");
			caddni = "2"+caddni;
			break;

		default:
			break;
		}
		
		//caddni el número compuesto preparado
		
		int numDniPreparado = Integer.parseInt(caddni);
		int resto = numDniPreparado%23;
		char letraFinal = Dni.SECUENCIA_LETRAS_DNI.charAt(resto);
		System.out.println("Su letra final es "+ letraFinal);
/*
		// CONVERTIR NÚMERO EN CADENA
		int n2 = 100;
		String sn2 = n2 + "";// "100"
		sn2 = String.valueOf(n2);
		// CONVERTIR CADENA EN NÚMERO String --> int
		int n = Integer.parseInt("34234324");
		System.out.println(n);
*/
	}

}
