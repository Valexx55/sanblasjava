package apuestasbd;

import java.util.Scanner;

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
		System.out.println("(1) Registrar Apuesta.");
		System.out.println("(2) Mostrar Apuestas,");
		System.out.println("(3) Ajustes Usuario.");
		System.out.println("(9) Salir.");

		opcion = sc.nextInt();

		return opcion;

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
