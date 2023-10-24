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

public class MainNumeros2 {
	
	//SIEMPRE QUE DECLARE UNA FUNCIÓN
	//1 pensar el nombre/ identificador DESCRIPTIVO!!
	//2 pensar Entradas ¿qué INPUT necesito?
	//3 pensar SALIDAS ¿qué calcula/devuelve la función?
	//4 si la función devuelve algo, 
		// Primera linea, delaro variable del tipo devuelto
	    //última linea, hago return de esa variable
	public static boolean esNumeroImpar (int n)
	{
		boolean esImpar = false;
		
			if ((n%2!=0)==true)
			{
				esImpar = true;
			} 
			else {
				esImpar = false;
			}
		
		return esImpar;
	}
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int contadorImpares = 0;
		for (int contador = 1; contador<11; contador++) {
			System.out.println("METE UN NÚMERO");
			int numLeido = scanner.nextInt();
			//si numleido es impar
			if (esNumeroImpar(numLeido))
			//if (numLeido%2!=0)
			{
				//el num leido es impar
				//actualizo la cuenta de impares
				contadorImpares= contadorImpares+1;// contadorImpares++;//au
			}
			  
			System.out.println(" Numero "+ contador + " = " + numLeido);
		}
		System.out.println("HAS METIDO " + contadorImpares + " Impares");
		System.out.println("FIN DE PROGRAMA");
				
		
	}
}
