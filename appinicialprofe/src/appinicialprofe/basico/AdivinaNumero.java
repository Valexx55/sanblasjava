package appinicialprofe.basico;

import java.util.Random;
import java.util.Scanner;

/**
 * HACED UN PROGRAMA QUE JUEGUE CON EL USUARIO A ADIVINAR UN NÚMERO
 * 
 * EL PROGRAMA (LA MÁQUINA) PIENSA UN NÚMERO ALEATORIO ENTRE 1 Y 100
 * 
 * Y LE DA 5 OPORTUNIDADES AL USUARIO PARA AVERIGUARLO
 * 
 * POR CADA INTENTO, EL PROGRAMA LE DA UNA PISTA AL USUARIO.
 * 
 * SI EL NÚMERO INTRODUCIDO ES MENOR QUE EL QUE TIENE QUE ADIVINAR, LE DA EL
 * MENSAJE DE "BUSCO NUMERO MAYOR"
 * 
 * SI EL NÚMERO INTRODUCIDO ES MAYOR QUE EL QUE TIENE QUE ADIVINAR, LE DA EL
 * MENSAJE DE "BUSCO NUMERO MENOR"
 * 
 * SI EL USUARIO ACIERTA, LE DAMOS UN MENSAJE DE ENHORABUENA
 * 
 * Y SI SE QUEDAN SIN INTENTOS, LE DECIMOS "GAME OVER" Y LE DAMOS LA SOLUCIÓN
 * DEL NÚMERO BUSCADO
 */

public class AdivinaNumero {
	
	public static final int MAXIMO_INTENTOS = 2;

	public static int pedirNumeroUsuario() {
		int numeroUsuario = 0;
		Scanner scanner = null;

		scanner = new Scanner(System.in);
		System.out.println("Advina un número del 1 al 100");
		numeroUsuario = scanner.nextInt();
		//scanner.close();

		return numeroUsuario;
	}

	public static int generarNumeroAleatorio() {
		int numeroAleatorio = 0;

		Random random = new Random();
		numeroAleatorio = random.nextInt(100) + 1;

		return numeroAleatorio;
	}

	public static void main(String[] args) {
		boolean acertado = false;// me sirve para controlar cuándo el usuario acierta y se acaba el juego
		// 1 genero numero aleatorio
		int numeroSecreto = generarNumeroAleatorio();
		System.out.println("Hay que adivinar el " + numeroSecreto);
		// 2 inicio vidas
		
		int numeroUsuario =0;
		int vidas = MAXIMO_INTENTOS;// REPRESENTA los intentos que restan al usuario
		do {
			// 3 pedir numero usuario
		
			numeroUsuario = pedirNumeroUsuario();
			// 4 comparo acierto??
			if (numeroUsuario == numeroSecreto) {
				// ha ganado!
				System.out.println("ENHORABUENA, HAS ACERTADO");
				acertado = true;
			} else {
				// ha fallado / no ha acertado
				if (numeroUsuario > numeroSecreto) {
					// es mayor el introducido que el buscado
					System.out.println("EL Número SECRETO ES MENOR");
				} else if (numeroUsuario < numeroSecreto) {
					// es menor el introducido que el buscado
					System.out.println("EL Número SECRETO ES MAYOR");
				}
				vidas = vidas - 1;// vidas--;
			}

		} while ((!acertado) && (vidas > 0));// ((acertado==false) && (vidas>0)); //hago el bucle mientras no acierte y le queden vidas
		
		if (!acertado)
		{
			//el usuario ha salido del bucle sin acertar
			//porque ya no tiene vidas
			System.out.println("HAS FALLADO. El número buscado era "+ numeroSecreto);
		}
	
	}

}
