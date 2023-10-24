package appinicialprofe.basico;

import java.util.Scanner;

public class EjerciciosBasicos {

	// Siempre que declare una función
	// 1 pensar el nombre/ identificador DESCRIPTIVO!!
	// 2 PENSAR Entradas ¿que INPUT necesito?
	// 3 pensar SALIDAS ¿qué calcula/devuelve la función?
	// 4 si la funcion devuelve algo,
	// Primera linea, declaro variable del tipo devuelvo
	// última linea, hago return de esa variable

	public static boolean esNumeroImpar(int n) {
		boolean esImpar = false;

		if ((n % 2 != 0) == true) {
			esImpar = true;

		}

		else {
			esImpar = false;
		}

		return esImpar;
	}

	public static void main(String[] args) {

		/*
		 * 1) 1 PROGRAMA QUE PIDA 10 NÚMEROS AL USUARIO Y LOS IMPRIMA POR PANTALLA
		 */

		Scanner scanner = new Scanner(System.in);
		{

			for (int contador = 1; contador < 11; contador++) {
				System.out.println("METE UN NÚMERO");
				int numLeido = scanner.nextInt();
				System.out.println(" Numero " + contador + " = " + numLeido);
			}

			System.out.println("FIN DE PROGRAMA");

			/*
			 * 2) 1 PROGRAMA QUE PIDA 10 NÚMEROS AL USUARIO Y DIGA CUÁNTOS IMPARES HAY DE
			 * ESOS DIEZ
			 */

			
			 Scanner scanner1 = new Scanner(System.in); 
			 int contadorImpares = 0; 
			 for (int contador = 1; contador < 11; contador++) {
			 System.out.println("METE UN NÚMERO"); 
			 int numLeido = scanner1.nextInt(); //
			  //si numleido es impar 
			  if (numLeido % 2 == 1) { // el número leido es impar //
			// actualizo la cuenta de impares
			  contadorImpares = contadorImpares + 1; // contadorImpares++; //
			  }
			
			 System.out.println(" Numero " + contador + " = " + numLeido);
			 
			 } System.out.println("FIN DE PROGRAMA"); }
			 

			/*
			 * 3) 1 PROGRAMA QUE PIDA 10 NÚMEROS Y DIGA LA SUMA DE LOS 10
			 */

			Scanner scanner1 = new Scanner(System.in);
			int total = 0;// suma vale 0
			int numLeido =0;

			for (int contador = 1; contador < 11; contador++) {
				System.out.println("METE UN NÚMERO");
				numLeido = scanner1.nextInt();// leo número del teclado
				total = total + numLeido;// actualizo el valor del total sumo
				//total += numLeido;
				System.out.println(" Numero " + contador + " = " + numLeido);
			}
			System.out.println("SUMA = " + total);// muestro
			System.out.println("FIN DE PROGRAMA");

			/*
			 * 4) 1 PROGRAMA QUE PIDA 10 NÚMEROS Y DIGA EL MAYOR DE LOS 10
			 * 
			 */

			Scanner scanner2 = new Scanner(System.in);
			int numUsuario = 0;
			int numeroMayor = 0;
			for (int contador = 1; contador < 11; contador++) {
				System.out.println("METE UN NÚMERO");
				numUsuario = scanner2.nextInt();// leo número del teclado
				if (numUsuario>numeroMayor)
				{
					//TENGO UN NUEVO MAYOR!
					numeroMayor=numUsuario;
				}
				//System.out.println(" Numero " + contador + " = " + numLeido);
			}
			System.out.println(" Numero MAYOR = " + numeroMayor);
			System.out.println("FIN DE PROGRAMA");
			
			/*
			 * 5) 1 PROGRAMA QUE PIDA 10 NÚMEROS Y DIGA EL MAYOR , LA MEDIA Y EL MENOR
			 * 
			 */
			
			Scanner scanner3 = new Scanner(System.in);
			int numUsuario1 = 0;
			int numeroMayor1 = 0;
			int numeroMenor = 0;
			float media =0;//0f;
			int total2 = 0;
					;
			for (int contador = 1; contador < 11; contador++) {
				System.out.println("METE UN NÚMERO");
				numUsuario = scanner3.nextInt();// leo número del teclado
				if (numUsuario1>numeroMayor1)
				{
					//TENGO UN NUEVO MAYOR!
					numeroMayor1=numUsuario;
				}
				if (numUsuario1<numeroMenor)
				{
					//TENGO UN NUEVO MAYOR!
					numeroMenor=numUsuario1;
				}
				total2 = total2+numUsuario1;
				//System.out.println(" Numero " + contador + " = " + numLeido);
			}
			media = total2/10; //calcular la media
			System.out.println(" Numero MAYOR = " + numeroMayor1);
			System.out.println(" Numero MENOR = " + numeroMenor);
			System.out.println(" MEDIA = " + media);
			System.out.println("FIN DE PROGRAMA");
	
	}//fin main
}//fin clase
