package apuestasbd;

import java.util.List;
import java.util.Scanner;

import apuestasbd.modelo.Apuesta;
import apuestasbd.modelo.Equipo;
import apuestasbd.modelo.Partido;
import apuestasbd.modelo.Usuario;

public class Pantalla {

	// TODO hacemos 2 métodos (1 por menú)
	// public static

	// 1 con el menú inicio
	// con opciones registrar
	// login

	// 2 con el menú principal
	// 1 registrar apuesta
	// 2 ajustes usuario
	// 3 consultar apuestas

	// MOSTRAR EL MNÚ Y DEVOLVERME LA OPCIÓN
	// PULSADA POR EL USUARIO (INT)

	static Scanner sc = new Scanner(System.in);

	public static Equipo mostrarYElgirEquipoApuesta (List<Equipo> listaEquipos)
	{
		Equipo equipoElegido = null;
		int numEquipo = 1;
		
			for (Equipo e : listaEquipos)
			{
				System.out.println(numEquipo + "-"+ e.getNombre());
				numEquipo++;
			}
			System.out.println("Elija equipo");
			numEquipo = sc.nextInt();
			equipoElegido = listaEquipos.get(numEquipo-1);
		
		return equipoElegido;
	}
	
	public static Apuesta pedirDatosApuesta ()
	{
		Apuesta apuestaNueva = null;
		
			//PEDIR VALOR
			System.out.println("Introduzca cantidad ");
			float valor = sc.nextFloat();
			//PEDIR GOLES LOCAL
			System.out.println("Introduzca Goles Local ");
			int golesLocal = sc.nextInt();
			//PEDIR GOLES VISITANTE
			System.out.println("Introduzca Goles Visitante ");
			int golesVisintante = sc.nextInt();
			
			apuestaNueva = new Apuesta();
			apuestaNueva.setValor(valor);
			apuestaNueva.setGoles_local(golesLocal);
			apuestaNueva.setGoles_visitante(golesVisintante);
			
		
		
		return apuestaNueva;
		
	}
	
	
	public static Usuario pedirUsuarioNuevo ()
	{
		Usuario usuario = null;
		
		 Scanner scanner = new Scanner(System.in);
		 String nombre, email, password = null;
		 System.out.println("Introduzca nombre de usuario");
		 nombre = scanner.next();
		 System.out.println("Introduzca email");
		 email = scanner.next();
		 System.out.println("Introduzca contraseña");
		 password = scanner.next();
		 
		 usuario = new Usuario(0, nombre, email, password);
		 
		 return usuario;
	}
	
	public static Usuario pedirCredenciales ()
	{
		Usuario usuario = null;
		
		//TODO pedid al usuario su email y password
		//y devolverlo "envuelto" en un objeto usuario
			System.out.println("Email usuario:");
			String email = sc.next();
		
			System.out.println("Contraseña:");
			String pass = sc.next();
			
			usuario = new Usuario();
			usuario.setPassword(pass);
			usuario.setEmail(email);
		
		return usuario;
	}
	
	public static int menuPantallaInicio() {

		int opcionLeida = 0;
		System.out.println("Inicio");
		System.out.println("(1) Acceso. ");
		System.out.println("(2) Registro");
		System.out.println("(3) Salir. ");

		opcionLeida = sc.nextInt();

		return opcionLeida;
	}

	public static int menuPantallaPrincipal() {
		int opcion = 0;
		System.out.println("Menú principal");
		System.out.println("(1) Apuestas.");
		System.out.println("(2) Ajustes.");
		System.out.println("(3) Generar partidos.");
		System.out.println("(9) Salir.");

		opcion = sc.nextInt();

		return opcion;

	}
	
	public static int menuApuestas() {
		int opcion = 0;
		System.out.println("Menú apuestas");
		System.out.println("(1) Apostar.");
		System.out.println("(2) Mis apuestas.");
		System.out.println("(3) Estadísticas.");
		System.out.println("(9) Salir.");

		opcion = sc.nextInt();

		return opcion;

	}
	
	public static Partido mostrarYElegirPartidoApuesta (List<Partido> lp)
	{
		Partido partido = null;
		Partido paux = null;
		int numPartido = 1;
		int partidoSeleccionado = 0;
		
			for (numPartido=0; lp.size()<numPartido; numPartido++)
			{
				paux = lp.get(numPartido);
				System.out.println(numPartido+1 + " " + paux.getEquipoLocal().getNombre()+" - " + paux.getEquipoVisitante().getNombre() + " " + paux.getFecha());
			}
			
			//leo el partido
			partidoSeleccionado = sc.nextInt();
			partido = lp.get(partidoSeleccionado-1);
		
		return partido;
	}
	
	public static boolean confirmarGenerarPartidos() {
		boolean confirmar=false;
		int opc=0;
		
			System.out.println("Generar los partidos puede borrar la base de datos ¿Quiere borrar los datos almacenados?");
			System.out.println("1-SI");	
			System.out.println("2-NO");	
			
			Scanner sc= new Scanner(System.in);
			opc=sc.nextInt();
		
			confirmar = (opc == 1);// ? true : false;
			

		return confirmar;
		
	}

}
