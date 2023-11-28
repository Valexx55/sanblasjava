package apuestasbd;

import java.util.Scanner;

import apuestasbd.dao.UsuarioDao;
import apuestasbd.modelo.Usuario;

public class MainApuestasBd {

	public static void main(String[] args) {
		
		/**
		 * System.out.println("(1) Acceso. ");
		System.out.println("(2) Registro");
		System.out.println("(3) Salir. ");
		 */
		boolean salir = false;
		do {
		
			int opcionInicio = Pantalla.menuPantallaInicio();
			switch (opcionInicio) { 
			case 1: //ACCESO 
				System.out.println("Quiere Acceder");
				login();
				break;
			case 2: //REGISTRO
				System.out.println("Quiere Registrarse");
				registroUsuario ();
			break;
			case 3: //SALIR
				System.out.println("HASTA PRONTO! Saliendo...");
				salir = true;
				break;
			default:
				System.out.println("OPCIÓN INCORRECTA");
			}
		}while (!salir);
	}
	
	 public static void registroUsuario ()
	 {
		 //TODO 
		 /**
		  * 1 PEDIR DATOS DE USUARIO (nombre, email, password) POR PANTALLA
		  * 2 INSERTAR USUARIO (datos) en base datos
		  * 3 INFORMAR Registro OK
		  */
		 Usuario usuarioNuevo = Pantalla.pedirUsuarioNuevo();
		 
		 UsuarioDao usuarioDao = new UsuarioDao();
		 boolean insertado = usuarioDao.insertarUsuario(usuarioNuevo);
		 
		 if (insertado)
		 {
			 System.out.println("SE HA REGISTRADO CON ÉXITO");
			 login ();
		 } else {
			 System.out.println("REGISTRO FALLIDO. VUELVA A INTENTARLO");
			 //NO HAGO NADA, MUESTRA EL MENÚ PRINCIPAL OTRA VEZ
		 }
		 
		 
	 }
	 
	 public static void login ()
	 {
		 //TODO pedir las credenciales para que el usuario
		 //entre en el sistema
		 System.out.println("En login() ...");
	 }

}
