package appinicialprofe.basico;

import java.util.Iterator;
import java.util.Scanner;

/*
 * //TODO HACER LOS SIGUIENTES ALGORITMOS/PROGRAMAS, EN ESTE ORDEN

1) 1 PROGRAMA QUE PIDA 10 NÚMEROS AL USUARIO Y LOS IMPRIMA POR PANTALLA
2) 1 PROGRAMA QUE PIDA 10 NÚMEROS AL USUARIO Y DIGA CUÁNTOS IMPARES HAY DE ESOS DIEZ
3) 1 PROGRAMA QUE PIDA 10 NÚMEROS Y DIGA LA SUMA DE LOS 10
4) 1 PROGRAMA QUE PIDA 10 NÚMEROS Y DIGA EL MAYOR DE LOS 10
5) 1 PROGRAMA QUE PIDA 10 NÚMEROS Y DIGA EL MAYOR, LA MEDIA Y EL MENOR
 */

public class MainNumeros {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		for (int contador = 1; contador<11; contador++) {
			System.out.println("METE UN NÚMERO");
			int numLeido = scanner.nextInt();
			System.out.println(" Numero "+ contador + " = " + numLeido);
		}
		
		System.out.println("FIN DE PROGRAMA");
				
		
	}
}
