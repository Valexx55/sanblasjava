package appinicialprofe.basico;

import java.util.Scanner;

public class EjercicioScanner {
	
	/*
	 *
	 * //TODO: 

HACED UNA APLICACIÓN QUE VAYA PIDIENDO
NÚMEROS AL USUARIO



EL PROGRAMA DEJA DE PEDIR NÚMEROS
(ACABA)
CUANDO EL USUARIO METE UN CERO

	 * @param args
	 */
	//Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numleido =0;
		//SI EL NÚMERO ES IMPAR, LO IMPRIME
		//SI NO, IMPRIME EL MENSAJE "hAS METIDO UN PAR"
		do {
			System.out.println("Dame un número");
			numleido = scanner.nextInt();
			if (numleido%2==0)
			{
				//el caso par
				System.out.println("hAS METIDO UN PAR");
			} else {
				//el caso impar
				System.out.println(numleido);
			}
			
		} while (numleido != 0);
		System.out.println("FIN DEL PROGRAMA. El usuario metió cero");
	}
    
}
