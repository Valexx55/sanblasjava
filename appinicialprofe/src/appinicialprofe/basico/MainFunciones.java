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
 *  6) HACER UN MÉTODO QUE RECIBA UNA CADENA Y LA DEVUELVA ALREVÉS
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
//		boolean resultado = esNumeroPar(8);
//		System.out.println(resultado);

		informarMayorEdad();
	}
	// EN TOTAL DEBO TENER 8 MÉTODOS

	// 3) HACER UN MÉTODO QUE DADO UN NÚMERO, DIGA SI ES PAR O NO
	public static boolean esNumeroPar(int numero) {
		boolean espar = false;

		 	espar = numero%2==0;
		 	if (numero%2==0)
		 	{
		 		espar = true;
		 	} else {
		 		espar = false;
		 	}
		 	

		return espar;
	}
	
	public static void esNumeroParVersionLaura(int numero) {
		
		if (numero%2==0) {
			System.out.println("Es número par");
		}
		else {
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

		// tengo que ver si es mayor de edad o no
		// si es mayor de 18 le informo que es mayor
		// si es menor de 18 le informo que es menor
//		if (edad >= 18) {
//			System.out.println("Eres mayor de edad");
//
//		} else {
//			System.out.println("Eres menor de edad");
//
//		}
		
		if (edad<18) {
			System.out.println("Menor de edad");
		}else {
			System.out.println("Mayor de edad");
		}

	}

}
