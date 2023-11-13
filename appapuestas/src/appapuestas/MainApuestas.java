package appapuestas;

import java.util.Scanner;

import appapuestas.bean.Apuesta;

public class MainApuestas {

	// TODO Controlar que un apostador sólo pueda
	// registrar una apuesta

	public static final int MAXIMO_APUESTAS = 20;// AMIBTO GLOBAL

	public static Apuesta crearApuesta() {
		Apuesta apuesta = null;

		System.out.println("registrar apuestas");
		apuesta = new Apuesta();
		System.out.println("Introduce tu nombre");
		Scanner scanner = new Scanner(System.in);
		String nombreapostante = scanner.next();

		System.out.println("Número de goles " + Apuesta.equipoLocal);
		int goleslocal = scanner.nextInt();

		System.out.println("Número de goles " + Apuesta.equipoVisitante);
		int golesvisitante = scanner.nextInt();
		
		System.out.println("Valor de la apuesta");
		float valorapuesta = scanner.nextFloat();
		
		apuesta.setNombre(nombreapostante);
		apuesta.setGolesLocal(goleslocal);
		apuesta.setGolesVisitante(golesvisitante);
		apuesta.setValorApuesta(valorapuesta);

		return apuesta;
	}

	public static void mostrarMenu() {

		System.out.println("\nOpciones:");
		System.out.println("1. Mostrar Apuestas");
		System.out.println("2. Registrar Nueva Apuesta");
		System.out.println("3. Borrar apuestas (todas)");
		System.out.println("4. Buscar apostante");
		System.out.println("5. Salir");

		System.out.print("Selecciona una opción: ");

	}

	public static int leerOpcion() {

		int opcionleida = 0;
		Scanner scanner = null;

		scanner = new Scanner(System.in);
		opcionleida = scanner.nextInt();

		return opcionleida;
	}

	/**
	 * Método descubre sí el nombre de apostante ya existe
	 * 
	 * @param arayApuestas el registro de apuestas donde buscar
	 * @param nombre       el nombre del apostador
	 * @param numApuestas  la cima/ el número de apuestas del Array
	 * @return false si el nombre no está en el array o tur si sí
	 */
	public static boolean esApuestaRepetida(Apuesta[] arrayApuestas, String nombre, int numApuestas) {
		boolean nombreRepetido = false;
		int apuestaActual = 0;
		Apuesta apuestaAux = null;
		String nombreActual = null;

		while ((apuestaActual < numApuestas) && (!nombreRepetido)) {
			// obtengo la apuesta
			apuestaAux = arrayApuestas[apuestaActual];
			// comparo el nombre
			nombreActual = apuestaAux.getNombre();
			if (nombreActual.equals(nombre)) {
				nombreRepetido = true;
			}
			apuestaActual++;

		}

		return nombreRepetido;
	}

	/**
	 * Método que nos busca una apuesta dado el nombre
	 * del apostador
	 * 
	 * @param arrayApuestas el array de las apuestras
	 * @param nombreApostadorBuscado el nombre del apostador a buscar
	 * @param numApuestas las apuestas que tengo en el array
	 * @return null si no existe un apostador con ese nombre
	 * o la apuesta si ese apostador está
	 */
	public static Apuesta bucarApuesta(Apuesta[] arrayApuestas, String nombreApostadorBuscado, int numApuestas) 
	{

		Apuesta apuesta = null;
		boolean nombreEncontrado = false;
		Apuesta apuestaAux = null;
		String nombreAux = null;

		int i = 0;
		while ((i < numApuestas) && (!nombreEncontrado)) {
			apuestaAux = arrayApuestas[i];
			nombreAux = apuestaAux.getNombre();
			if (nombreAux.equals(nombreApostadorBuscado)) {
				nombreEncontrado = true;
				apuesta = arrayApuestas[i];
			}
			i++;
		}

		return apuesta;
	}

	public static void main(String[] args) {

		boolean salir = false;// controlo el final del programa
		Apuesta[] arrayApuestas = new Apuesta[MAXIMO_APUESTAS];
		int numApuestas = 0;// lo uso para llevar la cuenta de apuestas
		// TODO AÑADIR LA OPCIÓN DE BORRAR APUESTAS (TODAS)
		int opcionleida = 0;
		do {
			mostrarMenu();
			opcionleida = leerOpcion();
			System.out.println("el usuario ha elegido la opcion " + opcionleida);

			switch (opcionleida) {
			case 1:

				if (numApuestas > 0) {
					Apuesta apuestaActual = null;
					// for(Apuesta apuesta : arrayApuestas)
					for (int i = 0; i < numApuestas; i++) {
						apuestaActual = arrayApuestas[i];
						System.out.println(apuestaActual.toString());
					}
				} else {
					System.out.println("NO hay apuestas");
				}

				System.out.println("mostrar apuestas");
				break;

			case 2:// REGISTRAR APUESTA

				if (numApuestas < MAXIMO_APUESTAS) {
					Apuesta apuestaNueva = crearApuesta();
					System.out.println("Apuesta creada ");

					boolean apuestaRepe = esApuestaRepetida(arrayApuestas, apuestaNueva.getNombre(), numApuestas);
					if (apuestaRepe) {
						System.out.println(apuestaNueva.getNombre() + " Ya ha apostado");
					} else {
						// guardo
						apuestaNueva.mostrarApuesta();
						arrayApuestas[numApuestas] = apuestaNueva;
						numApuestas++;
					}

				} else {
					System.out.println("APUESTAS CERRADAS");
				}

				break;

			case 3:
				for (int i = 0; i < numApuestas; i++) {
					arrayApuestas[i] = null;

				}
				numApuestas = 0;// actualizo el numero de apuestas el cero!
				System.out.println("Apuestas BORRADAS");
				break;

			case 4:
				System.out.println("Ingresa el nombre del apostador que deseas buscar:");
				Scanner scanner = new Scanner(System.in);
				String nombreBuscar = scanner.next();
				Apuesta apuestaEncontrada = bucarApuesta(arrayApuestas, nombreBuscar, numApuestas);

				if (apuestaEncontrada != null) {
					System.out.println("APOSADOR ENCONTRADO");
					apuestaEncontrada.mostrarApuesta();

				} else {
					System.out.println("APOSTADOR NO ENCONTRADO");
				}

				break;

			case 5:
				System.out.println("salir");
				salir = true;
				break;

			default:
				// throw new IllegalArgumentException("Unexpected value: " + opcionleida);
				System.out.println("Opción incorrecta mete del 1 al 3");
			}

		} while (!salir); // (opcionleida != 4);// mientras no seleccione la opcion 3
		System.out.println("PROGRAMA TERMINADO");
	}
}