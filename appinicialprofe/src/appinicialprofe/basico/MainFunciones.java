package appinicialprofe.basico;

import java.util.Scanner;

/**
 * 
 * LISTA DE EJERCICIOS DE REPASO A LA PARTE DE INICIACIÓN EN JAVA:
 * 
 * 1) HACER UN MÉTODO QUE RECIBA UNA CADENA Y UN CARACTER Y DIGA SI ESE CARACTER
 * PERTENECE A LA CADENA O NO 
 * 2) HACER UN MÉTODO QUE RECIBA UNA CADENA Y UN
 * CARACTER Y DIGA CÚANTAS VECES APARECE ESE CARACTER EN LA CADENA 
 * 3) HACER UN
 * MÉTODO QUE DADO UN NÚMERO, DIGA SI ES PAR O NO 
 * 4) HACER UN MÉTODO QUE LE PIDA
 * AL USUARIO SU EDAD Y LE DIGA SI ES MAYOR DE EDAD O NO 
 * 5) HACER UN MÉTODO QUE
 * RECIBA UNA NOTA DE 0 A 10 Y DIGA SI EQUIVALE A UN APROBADO, BIEN, NOTABLE, O
 * SOBRESALIENTE 
 * 6) HACER UN MÉTODO QUE RECIBA UNA CADENA Y LA DEVUELVA AL REVÉS
 * 7) HACER UN PROGRAMA QUE MUESTRE LA SECUENCIA 3, 6, 9, 12, 15 ...99
 *
 *
 * // DEFINO UN MÉTODO public static // DARLE UN NOMBRE - camelCase // ID la
 * entrada - // ID la salida -
 *
 * //pensar los pasos en ESPAÑOL en psuedocódigo
 */
public class MainFunciones {

	public static void main(String[] args) {
		// TODO llamar/invocar a las funciones
		boolean resultado = esNumeroPar(8);
		System.out.println(resultado);

		
		informarMayorEdad(); boolean espar = esNumeroPar(37);
		System.out.println("El numero es par = " + espar); 
		imprimrSecuencia();
		

		imprimirNotaNominal(0);
		boolean pertenece = perteneceLetraAPalabra("EXAMEN", 'z');
		System.out.println(pertenece);
		pertenece = perteneceLetraAPalabraVersionAdri("EXAMEN", 'z');
		System.out.println(pertenece);
		int nveces = calculaNumVecesCharEnString ("LUNES ES HOY", 'E');
		System.out.println(nveces);
		String cadreves = cadenaReves("roma");
		System.out.println(cadreves);
	}
	// EN TOTAL DEBO TENER 8 MÉTODOS

	// 3) HACER UN MÉTODO QUE DADO UN NÚMERO, DIGA SI ES PAR O NO
	public static boolean esNumeroPar(int numero) {
		boolean espar = false;

		espar = numero % 2 == 0;

//		 	if (numero%2==0)
//		 	{
//		 		espar = true;
//		 	} else {
//		 		espar = false;
//		 	}

		return espar;
	}

	public static void esNumeroParVersionLaura(int numero) {

		if (numero % 2 == 0) {
			System.out.println("Es número par");
		} else {
			System.out.println("Es número impar");
		}
	}

	// 4) HACER UN MÉTODO QUE LE PIDA AL USUARIO SU EDAD Y LE DIGA SI ES MAYOR DE
	// EDAD O NO
	public static void informarMayorEdad() {
		// TODO PEDIMOS EDAD
		System.out.println("Introduce tu edad");// pido la edad al usuario
		Scanner scanner = new Scanner(System.in);// creo scanner para leer de teclado
		int edad = scanner.nextInt();

		if (edad >= 18) {
			System.out.println("Eres mayor de edad");

		} else {
			System.out.println("Eres menor de edad");

		}

	}

	// 7) HACER UN PROGRAMA QUE MUESTRE LA SECUENCIA 3, 6, 9, 12, 15 ...99

	public static void imprimrSecuencia() {
		for (int i = 3; i < 99; i = i + 3) {

			System.out.print(i + " ,");

		}
		System.out.println(99);
	}

	/*
	 * * 5) HACER UN MÉTODO QUE RECIBA UNA NOTA DE 0 A 10 Y DIGA SI EQUIVALE A UN
	 * APROBADO, BIEN, NOTABLE, O SOBRESALIENTE
	 */

	public static void imprimirNotaNominal(int notanumerica) {
		switch (notanumerica) {
		case 0, 1, 2, 3, 4:
			System.out.println("SUSPENSO");
			break;
		case 5:
			System.out.println("APROBADO");
			break;
		case 6:
			System.out.println("BIEN");
			break;
		case 7, 8:
			System.out.println("NOTABLE");
			break;
		case 9, 10:
			System.out.println("SOBRESALIENTE");
			break;
		default: // no coincide con ningún caso anterior
			System.out.println("NOTA RECIBIDA INCORRECTA");
			System.out.println("NOTAS VÁLIDAS DEL 0 AL 10");
		}
	}

	/**
	 * 1) HACER UN MÉTODO QUE RECIBA UNA CADENA Y UN CARACTER Y DIGA SI ESE CARACTER
	 * PERTENECE A LA CADENA O NO
	 */

	public static boolean perteneceLetraAPalabra(String palabra, char letra) {
		boolean pertenece = false;
		int posicion = 0;
		int longitud = palabra.length();
		char letraActual = ' ';

		do {
			letraActual = palabra.charAt(posicion);
			// pertenece = letraActual == letra;
			if (letraActual == letra) {
				pertenece = true;
			}
			posicion++;
		} while (posicion < longitud && !pertenece);

		return pertenece;
	}

	public static boolean perteneceLetraAPalabraVersionAdri(String palabra, char letra) {
		boolean pertence = false;

		// pertence = palabra.contains(letra+"");
		String palabraAux = String.valueOf(letra);// convierto el char en String
		pertence = palabra.contains(palabraAux);// para poder usar el contains

		return pertence;
	}

	/*2) HACER UN MÉTODO QUE RECIBA UNA CADENA Y UN
	 * CARACTER Y DIGA CÚANTAS VECES APARECE ESE 
	 * CARACTER EN LA CADENA*/

	public static int calculaNumVecesCharEnString 
	(String cadena, char letra)
	{
		int nveces = 0;
		int longitud = cadena.length();
		char letraActual = ' ';//variable auxiliar
		
			for (int posicion = 0; posicion<longitud; posicion++)
			{
				letraActual = cadena.charAt(posicion);
				if (letraActual==letra)
				{
					//nveces++;
					nveces = nveces+1;
				}
			}
		
		return nveces;
	}
	
	public static String cadenaReves (String cadena)
	{
		String cadenaReves = null;
		char letraActual = ' ';
		
		    cadenaReves = new String("");
			for (int posicion = cadena.length()-1;posicion>=0;posicion--)
				
			{
				letraActual = cadena.charAt(posicion);
				cadenaReves = cadenaReves + letraActual; 
			}
		
		
		return cadenaReves;
	}
	
	
	
	
	
	
}
