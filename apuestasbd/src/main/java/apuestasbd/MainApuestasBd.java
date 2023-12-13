package apuestasbd;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import apuestasbd.dao.ApuestaDao;
import apuestasbd.dao.EquipoDao;
import apuestasbd.dao.PartidoDao;
import apuestasbd.dao.UsuarioDao;
import apuestasbd.modelo.Equipo;
import apuestasbd.modelo.Partido;
import apuestasbd.modelo.Usuario;

public class MainApuestasBd {

	private static final int MAX_INTENTOS_LOGIN = 3;
/*
	public static void main(String[] args) {

		boolean salir = false;
		do {

			int opcionInicio = Pantalla.menuPantallaInicio();
			switch (opcionInicio) {
			case 1: // ACCESO
				System.out.println("Quiere Acceder");
				login();
				break;
			case 2: // REGISTRO
				System.out.println("Quiere Registrarse");
				registroUsuario();
				break;
			case 3: // SALIR
				System.out.println("HASTA PRONTO! Saliendo...");
				salir = true;
				break;
			default:
				System.out.println("OPCIÓN INCORRECTA");
			}
		} while (!salir);
	}*/
	
	public static void main(String[] args) {
		ApuestaDao apuestaDao = new ApuestaDao();
		Map<String, Float> mapaStats  = apuestaDao.obtenerEstadisticosApuestas();
		System.out.println(mapaStats);
	}

	public static void registroUsuario() {

		Usuario usuarioNuevo = Pantalla.pedirUsuarioNuevo();

		UsuarioDao usuarioDao = new UsuarioDao();
		boolean insertado = usuarioDao.insertarUsuario(usuarioNuevo);

		if (insertado) {
			System.out.println("SE HA REGISTRADO CON ÉXITO");
			login();
		} else {
			System.out.println("REGISTRO FALLIDO. VUELVA A INTENTARLO");
			// NO HAGO NADA, MUESTRA EL MENÚ PRINCIPAL OTRA VEZ
		}

	}

	public static void login() {
		int numeroIntentos = 0;
		boolean encontrado = false;
		Usuario usuariodeBD = null;
		do {

			Usuario usuarioLogin = Pantalla.pedirCredenciales(); // DESDE LA CLASE PANTALLA LLAMA A PEDIR CREDENCIALES
			UsuarioDao usuarioDAO = new UsuarioDao();
			usuariodeBD = usuarioDAO.buscarExiste(usuarioLogin.getEmail(), usuarioLogin.getPassword());
			numeroIntentos++;
			if (numeroIntentos == MAX_INTENTOS_LOGIN - 1) {
				System.out.println("TE QUEDA 1 INTENTO");
			}
			if (usuariodeBD != null) {
				System.out.println("BIENVENIDO");

				encontrado = true;
			} else {
				System.out.println(" USUARIO NO EXISTE VERIFICA DATOS");
			}
		} while ((!encontrado) && (numeroIntentos < MAX_INTENTOS_LOGIN));

		if (encontrado) {
			/**
			 * 	System.out.println("Menú principal");
		System.out.println("(1) Apuestas.");
		System.out.println("(2) Ajustes.");
		System.out.println("(3) Generar partidos.");
		System.out.println("(9) Salir.");
			 */
			switch (Pantalla.menuPantallaPrincipal()) {
			case 1: //apuestas 
				
				 
				 switch (Pantalla.menuApuestas()) {
				case 1: //apostar
					//usuariodeBD
					break;
				case 2: //mis apuestas
					break;
				case 3: //estadísticas
					//mostrar maximo, minimo y media de las apuestas
					
					
					break;
				case 9: //salir
					break;
				} 
				
				break;
			case 2: //ajustes
				
				break;
			case 3: //generar partidos
				try {
					MainApuestasBd.generarPartidos();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.err.println("No se ha podido generar los partidos");
					e.printStackTrace();
				}
				break;
			case 9: //salir 
				break;
			
			} 
		} else {
			System.out.println("NÚMERO DE INTENTOS SUPERADO");
			System.exit(0);// finalizo el programa
		}

	}

	/**
	 * Este método responde a una opción del usuario cuando quiere generar partidos
	 * y equipos nuevos
	 * 
	 * Si hay partidos
	 * 
	 * @throws SQLException
	 */
	public static void generarPartidos() throws SQLException {
		Connection conexion_compartida = BaseDatos.obtenerConexion();
		conexion_compartida.setAutoCommit(false);// para manejar la transacción y que cada operación no se haga
													// automáticamente en base datos hasta yo que haga commit
													// manualmente
		try {

			// 0 PREGUNTAR AL USUARIO SI QUIERE BORRAR LOS DATOS / REGENERAR
			if (Pantalla.confirmarGenerarPartidos()) { // BORRO EQUIPOS
				EquipoDao equipoDao = new EquipoDao();
				equipoDao.borrarEquipos(conexion_compartida);
				// CARGO EQUIPOS
				List<Equipo> lEquipos = Equipo.cargarListaEquipos("src/main/resources/equipos.txt");
				System.out.println("Equipos " + lEquipos);
				// GUARDO
				equipoDao.insertarEquipos(lEquipos, conexion_compartida);

				// PROVOCAR FALLO para probar transacción
				/*
				 * String saludo = "h"; saludo.charAt(5);
				 */

				// LEO PARA RECUPERAR EL ID
				lEquipos = equipoDao.leerEquipos(conexion_compartida);

				// GENERO PARTIDOS
				List<Partido> lPartidos = Partido.generarPartidos(lEquipos);
				System.out.println("Partidos " + lPartidos);
				// GUARDAR PARTIDOS
				PartidoDao partidoDao = new PartidoDao();
				partidoDao.insertarPartidos(lPartidos, conexion_compartida);

				conexion_compartida.commit();

			} else {
				System.out.println("Operación cancelada");
			}

		} catch (Exception e) {
			// TODO: handle exception
			conexion_compartida.rollback();
			e.printStackTrace();
		} finally {
			conexion_compartida.close();
		}
	}

//	public static void main(String[] args) {
//		try {
//			MainApuestasBd.generarPartidos();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
