package appapuestas;

import java.util.Scanner;

import appapuestas.bean.Apuesta;

public class MainApuestas {
	
	public static final int MAXIMO_APUESTAS = 20;

	public static Apuesta crearApuesta() {
		Apuesta apuesta=null;
		
		System.out.println("registrar apuestas");
		apuesta = new Apuesta();
		System.out.println("Introduce tu nombre");
		Scanner scanner = new Scanner(System.in);
		String nombreapostante=scanner.next();

		System.out.println("Número de goles "+ Apuesta.equipoLocal);
		int goleslocal = scanner.nextInt();
		
		
		System.out.println("Número de goles " +Apuesta.equipoVisitante);
		int golesvisitante = scanner.nextInt();
		
		apuesta.setNombre(nombreapostante);
		apuesta.setGolesLocal(goleslocal);
		apuesta.setGolesVisitante(golesvisitante);
		
		return apuesta;
	}
	
	public static void mostrarMenu() {

		System.out.println("\nOpciones:");
		System.out.println("1. Mostrar Apuestas");
		System.out.println("2. Registrar Nueva Apuesta");
		System.out.println("3. Salir");

		System.out.print("Selecciona una opción: ");

	}

	public static int leerOpcion() {

		int opcionleida = 0;
		Scanner scanner = null; 

		scanner = new Scanner(System.in); 
		opcionleida = scanner.nextInt(); 
										

		return opcionleida;
	}

	public static void main(String[] args) {
		
		Apuesta[] arrayApuestas = new Apuesta[MAXIMO_APUESTAS];
		int numApuestas = 0;//lo uso para llevar la cuenta de apuestas

		int opcionleida = 0;
		do {
			mostrarMenu();
			opcionleida = leerOpcion();
			System.out.println("el usuario ha elegido la opcion " + opcionleida);

			switch (opcionleida) {
			case 1:
				
				if (numApuestas>0)
				{
					Apuesta apuestaActual = null;
					//for(Apuesta apuesta : arrayApuestas)
					for(int i = 0; i < numApuestas; i++)
					{
						apuestaActual = arrayApuestas[i];
						System.out.println(apuestaActual.toString());
					}
				} else {
					System.out.println("NO hay apuestas");
				}
				
				System.out.println("mostrar apuestas");
				break;

			case 2:
				System.out.println("registrar apuestas");
				if (numApuestas<MAXIMO_APUESTAS)
				{
					Apuesta apuestaNueva = crearApuesta();
					System.out.println("Apuesta creada "  );
					apuestaNueva.mostrarApuesta();
					//TODO GUARDAR LA APUESTA EN UN ARRAY 
					arrayApuestas[numApuestas]=apuestaNueva;
					numApuestas++;
				} else {
					System.out.println("APUESTAS CERRADAS");
				}
				
				
				
				

				
						
				//TODO pedir al usuario los datos de la apuesta
				//pedir nombre
				//pedir goles local
				//pedir goles vistante
				
				break;

			case 3:
				System.out.println("salir");
				break;

			default:
				//throw new IllegalArgumentException("Unexpected value: " + opcionleida);
				System.out.println("Opción incorrecta mete del 1 al 3");
			}

		} while (opcionleida != 3);// mientras no seleccione la opcion 3
		System.out.println("PROGRAMA TERMINADO");
	}
}