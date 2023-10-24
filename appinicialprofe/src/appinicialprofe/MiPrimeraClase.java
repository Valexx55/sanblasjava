package appinicialprofe;

import java.util.Scanner;

public class MiPrimeraClase {

	// COMENTARIO DE LÍNEA
	/*
	 * COMENTARIO MULTILÍNEA
	 * 
	 * EN CUALQUIER CLASE SOLO TENGO 2 TIPOS DE COSAS:
	 * 
	 * -Atributos / campos / fields / propiedades -Métodos o funciones / rutina /
	 * procedimiento / subprograma
	 */

	public static void main(String[] args) {
		
		String saludoItaliano = "CIAO";
		int longitud = saludoItaliano.length();
		
		String saludoEspanol = "HOLA";
		
		String saludoVenezolano = new String("EPALE");		
				
		System.out.println(longitud);
		
		System.out.println("AUPA ATLETI");
		System.out.print("HALA MADRID");
		System.out.println("FIN DE LA PRIMERA CLASE");

		// TODO Modificar este programa
		// para que imprima del 0 al 50 sólo los números pares
		// y al final, muestre un mensaje de
		// "THE END"
		System.out.println("Con el bulce FOR");
		for (int a = 0; a <= 50; a++) {
			// si a es par
			if ((a % 2 == 0)==true) {
				// se cumple
				System.out.println(a);
			} else {
				// si no se cumple
			}
			// imprime
			// si no
			// no hago na

		}
		System.out.println("THE END FOR");
		
		System.out.println("Con el bulce DO WHILE");
		int numero = 0;
		do {
			if ((numero%2)==0) //es par
			{
				System.out.println(numero);
			}
			numero = numero +1;
			
		} while (numero<=50);
		System.out.println("THE END WHILE");
		
		
		//System.in es el teclado - Entrada Estándar
		//tengo un objeto que me lee de teclado
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Mete un número ");
		int numeroLeido = scanner.nextInt();
		System.out.println(numeroLeido);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
