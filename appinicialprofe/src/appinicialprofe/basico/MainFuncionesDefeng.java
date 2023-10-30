package appinicialprofe.basico;

import java.util.Random;
import java.util.Scanner;

/**
 * 
 * LISTA DE EJERCICIOS DE REPASO A LA PARTE DE INICIACIÓN EN JAVA:
 * 
 * 1) HACER UN MÉTODO QUE RECIBA UNA CADENA Y UN CARACTER Y DIGA SI ESE CARACTER
 * PERTENECE A LA CADENA O NO 2) HACER UN MÉTODO QUE RECIBA UNA CADENA Y UN
 * CARACTER Y DIGA CÚANTAS VECES APARECE ESE CARACTER EN LA CADENA 3) HACER UN
 * MÉTODO QUE DADO UN NÚMERO, DIGA SI ES PAR O NO 4) HACER UN MÉTODO QUE LE PIDA
 * AL USUARIO SU EDAD Y LE DIGA SI ES MAYOR DE EDAD O NO 5) HACER UN MÉTODO QUE
 * RECIBA UNA NOTA DE 0 A 10 Y DIGA SI EQUIVALE A UN APROBADO, BIEN, NOTABLE, O
 * SOBRESALIENTE 6) HACER UN MÉTODO QUE RECIBA UNA CADENA Y LA DEVUELVA ALREVÉS
 * 7) HACER UN PROGRAMA QUE MUESTRE LA SECUENCIA 3, 6, 9, 12, 15 ...99
 *
 *
 * // DEFINO UN MÉTODO public static // DARLE UN NOMBRE - camelCase // ID la
 * entrada - // ID la salida -
 *
 * //pensar los pasos en ESPAÑOL en psuedocódigo
 */
public class MainFuncionesDefeng {

	public static void main(String[] args) {

		// VARIABLES PARA TESTS
		String cadena = "Ejemplo cadena aaa";
		int numero = 9;
		char caracter = 'a';

		// TESTS
		System.out.println(perteneceCadena(cadena, caracter));

		System.out.println(cantidadRepetidas(cadena, caracter));

		System.out.println(esPar(numero));

		System.out.println(esMayor(numero));

		System.out.println(notaNominal(numero));

		System.out.println(cadenaInversa(cadena));

		System.out.println(secuenciaTres());

		System.out.println(quitarEspacios(cadena));

		System.out.println(intercalarCadena(cadena));

		System.out.println(generadorRandom());

	}

	/**
	 * Función para recorrer una cadena y comprobar si un carácter(caracter)
	 * pertenece a una cadena (args).
	 * 
	 * @param args
	 * @param caracter
	 * @return boolean
	 */
	public static boolean perteneceCadena(String args, char caracter) {
		boolean pertenecer = false;

		for (int i = 0; i < args.length(); i++) {

			if (caracter == args.charAt(i)) {
				pertenecer = true;
			}
		}
		return pertenecer;

	}

	/**
	 * Función que recorre y cuenta la cantidad de veces que se repite un carácter
	 * (caracter) en una cadena (args).
	 * 
	 * @param args
	 * @param caracter
	 * @return cantidad
	 */
	public static int cantidadRepetidas(String args, char caracter) {

		int cantidad = 0;

		for (int i = 0; i < args.length(); i++) {

			if (caracter == args.charAt(i)) {
				cantidad++;
			}
		}
		return cantidad;

	}

	/**
	 * Función para comprobar si un número (num) es par.
	 * 
	 * @param num
	 * @return boolean
	 */
	public static boolean esPar(int num) {

		boolean esPar = false;

		if ((num % 2) == 0) {
			esPar = true;
		}
		return esPar;
	}

	/**
	 * Función para comprobar dado un int (edad) si es mayor o igual que 18.
	 * 
	 * @param edad
	 * @return boolean
	 */
	public static boolean esMayor(int edad) {

		boolean mayor = false;

		if (edad >= 18) {
			mayor = true;
		}
		return mayor;

	}

	/**
	 * Función que dada una nota en numero (nota) asigna una nota nominal.
	 * 
	 * @param nota
	 * @return notaNominal
	 */
	public static String notaNominal(double nota) {

		String notaNominal = "";

		if (nota < 5) {
			notaNominal = "Suspenso";
		} else if (nota == 5) {
			notaNominal = "Aprobado";
		} else if (nota >= 6 && nota < 7) {
			notaNominal = "Bien";
		} else if (nota >= 7 && nota < 9) {
			notaNominal = "Notable";
		} else if (nota >= 9) {
			notaNominal = "Sobresaliente";
		}
		return notaNominal;
	}

	/**
	 * Función que introducida una cadena (args) la devuelve inversa.
	 * 
	 * @param args
	 * @return cadenaInversa
	 */
	public static String cadenaInversa(String args) {
		String cadenaInversa = "";

		for (int i = args.length() - 1; i > -1; i--) {

			cadenaInversa = cadenaInversa + args.charAt(i);

		}
		return cadenaInversa;
	}

	/**
	 * Función que imprime una secuencia de números que va aunmentando de 3 en 3
	 * hasta 100.
	 * 
	 * @return secuencia
	 */
	public static String secuenciaTres() {

		String secuencia = "";

		for (int i = 1; i <= 33; i++) {

			secuencia = secuencia + (i * 3);

			if (i < 33) {
				secuencia = secuencia + ", ";
			}

		}
		return secuencia;
	}

	/**
	 * Función que quita espacios de la cadena (args) introducida.
	 * 
	 * @param args
	 * @return sinEspacios
	 */
	public static String quitarEspacios(String args) {

		String sinEspacios = "";

		for (int i = 0; i < args.length(); i++) {

			if (args.charAt(i) != ' ') {
				sinEspacios = sinEspacios + args.charAt(i);
			}
		}
		return sinEspacios;
	}

	/**
	 * Función para intercalar letras de una cadena (args) usando un algoritmo
	 * predecible.
	 * 
	 * @param args
	 * @return cadenaIntercalada
	 */
	public static String intercalarCadena(String args) {

		String cadenaPares = "";
		String cadenaEntre3 = "";
		String cadenaImpares = "";

		for (int i = 0; i < args.length(); i++) {

			if ((i % 2) == 0) {
				cadenaPares = cadenaPares + args.charAt(i);
			} else if ((i % 3) == 0) {
				cadenaEntre3 = cadenaEntre3 + args.charAt(i);
			} else {
				cadenaImpares = cadenaImpares + args.charAt(i);
			}
		}
		return cadenaPares + cadenaEntre3 + cadenaImpares;
	}

	/**
	 * Funcion que devuelve una cadena con 15 caracteres escogidas aleatorias de un
	 * diccionario.
	 * 
	 * @return contraseña
	 */
	public static String generadorRandom() {
		Random r = new Random();
		String contraseña = "";
		String diccionario = "1234567890QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm!@%&*?¿ºª_-!@%&*?¿ºª_-";
		for (int i = 0; i < 15; i++) {
			contraseña = contraseña + diccionario.charAt(r.nextInt(diccionario.length()));
		}
		return contraseña;
	}
}
