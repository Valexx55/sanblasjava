package appdniprofe;

import java.util.Random;

//TODO HACER UN NUEVO MAINDNI LLAMADO MAINDNI2
/**
 * PARA QUE GENERE 10 DNIS NUEVOS CADA NÚMERO DEL DNI SE TIENE QUE GENERAR
 * AUTOMÁTICAMENTE /ALEATORIA Y PARA CADA DNI, SE TIENE QUE CALCULAR SU LETRA
 * 
 * EN LA CLASE DNI, SE TIENE QUE LLEVAR LA CUENTA DE CUÁNTOS DNIS SE CREAN Y
 * MOSTRARLO AL FINAL DE LA EJECUCIÓN
 * 
 * 
 * 
 * 
 * 
 */
public class MainDni2 {

	public static final int MAX_NUMERO_DNI = 99999999;

	public static void main(String[] args) {

		// FOR 10 veces
		// 1 generar numero
		// 2 crear dni
		// 3 sacar letra de ese dni
		Dni[] arrayDnis = new Dni[10]; // me creo un array con espacio para 10 dnis
		for (int i = 0; i <= 9; i++) {
			Random random = new Random();
			int numDni = random.nextInt(MAX_NUMERO_DNI) + 1;
			Dni dni = new Dni(numDni);

			char letraDNI = dni.calcularLetra();
			dni.setLetra(letraDNI);
			// add el dni al array
			if (i % 2 == 0)// si la posicion es par
			{
				arrayDnis[i] = dni;// meto un DNI
			} else {
				arrayDnis[i] = new Nie();// si es impar, meto un NIE
			}

			System.out.println("Tu numero: " + dni.getNumero() + " - " + dni.getLetra());
		}

		// TODO imprimir el número total de DNIS creados
		System.out.println("SE HAN  CREADO " + Dni.contador + " dnis");

		// VAMOS A LLAMAR A BUSCAR AL MAYOR DE LOS DNIS
		int nummayor = Dni.obtenerDniMayor(arrayDnis);
		System.out.println("El mayor DNI es " + nummayor);

		for (Dni dni : arrayDnis) {
			if (dni instanceof Nie) {
				System.out.println("ES UN NIE");
			} else /* if (dni instanceof Dni) */ {
				System.out.println("ES UN DNI");
			}

		}

		// TODO haced un método estático QUE RECIBA un array
		// de dnis y me diga cuántos NIEs hay en ese array
		
		int numeroNies = contarNies(arrayDnis);
		System.out.println("HAY " + numeroNies + " NIES " + " de un total de " + arrayDnis.length + " DNIES");
		numeroNies = contarNiesForEach(arrayDnis);
		System.out.println("HAY " + numeroNies + " NIES " + " de un total de " + arrayDnis.length + " DNIES");
		
		
		

	}

	public static int contarNies(Dni[] arrayDnies) {
		int numNies = 0;
		Dni dniActual = null;

		for (int i = 0; i < arrayDnies.length; i++) {
			dniActual = arrayDnies[i];
			if (dniActual instanceof Nie) {
				numNies = numNies + 1;
			}
		}

		return numNies;
	}

	public static int contarNiesForEach(Dni[] arrayDnies) {
		int numNies = 0;
		
		for (Dni dni : arrayDnies) {
			if (dni instanceof Nie) {
				numNies++;
			}
		}
		return numNies;
	}

}
