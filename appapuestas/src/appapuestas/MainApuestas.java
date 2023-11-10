package appapuestas;

import java.util.Scanner;

import appapuestas.bean.Apuesta;

public class MainApuestas {
	
	//TODO Controlar que un apostador sólo pueda
	//registrar una apuesta
	
	public static final int MAXIMO_APUESTAS = 20;//AMIBTO GLOBAL

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

	
	/**
	 * Método descubre sí el nombre de apostante ya existe
	 * @param arayApuestas el registro de apuestas donde buscar
	 * @param nombre el nombre del apostador
	 * @param numApuestas la cima/ el número de apuestas del Array
	 * @return false si el nombre no está en el array o tur si sí
	 */
	public static boolean esApuestaRepetida (Apuesta[] arrayApuestas, String nombre, int numApuestas)
	{
		boolean nombreRepetido = false;
		int apuestaActual = 0;
		Apuesta apuestaAux = null;
		String nombreActual = null;
		
		
			while ((apuestaActual<numApuestas)&&(!nombreRepetido))
			{
				//obtengo la apuesta
				apuestaAux = arrayApuestas[apuestaActual];
				//comparo el nombre
				nombreActual = apuestaAux.getNombre();
				if (nombreActual.equals(nombre))
				{
					nombreRepetido=true;
				}
				apuestaActual++;
				
			}
		
		return nombreRepetido;
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

			case 2://REGISTRAR APUESTA
				
				if (numApuestas<MAXIMO_APUESTAS)
				{
					Apuesta apuestaNueva = crearApuesta();
					System.out.println("Apuesta creada "  );
					 
					boolean apuestaRepe = esApuestaRepetida (arrayApuestas, apuestaNueva.getNombre(), numApuestas);
					if (apuestaRepe)
					{
						System.out.println(apuestaNueva.getNombre()+ " Ya ha apostado" );
					} else  {
						//guardo
						apuestaNueva.mostrarApuesta();
						arrayApuestas[numApuestas]=apuestaNueva;
						numApuestas++;
					}
					
				} else {
					System.out.println("APUESTAS CERRADAS");
				}
				
				
								
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