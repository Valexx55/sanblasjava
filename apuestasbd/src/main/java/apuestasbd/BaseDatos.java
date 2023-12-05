package apuestasbd;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;



import apuestasbd.modelo.Equipo;
import apuestasbd.modelo.Partido;
import apuestasbd.modelo.Usuario;

public class BaseDatos {
	
	public static final String SERVIDOR_BD = "localhost";
	public static final String PUERTO = "3306";
	public static final String USUARIO;// = "root";
	public static final String PWD;// = "root";
	public static final String CADENA_DE_CONEXION;// = "jdbc:mysql://"+SERVIDOR_BD+":"+PUERTO+"/bdapuestas";
	
	static {
		//esta sección de código se ejecuta al principio
		//cuando la clase BaseDatos se vaya a utilizar, por primera vez
		//se ejecuta esto
		String cadenaConexion = "jdbc:mysql://localhost:3306/bdapuestas";
		String usuario = "root";
		String password = "root";
		System.out.println("Sección static de Base de datos");
		try {
			Properties properties = new Properties();
			FileReader fileReader = new FileReader("src/main/resources/apuestas.properties");
			properties.load(fileReader);//leemos el fichero
			cadenaConexion = properties.getProperty("cadenaconexion");
			usuario = properties.getProperty("usuariobd");
			password = properties.getProperty("contraseniabd");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error al cargar las propiedades");
		} finally {
			CADENA_DE_CONEXION = cadenaConexion;
			USUARIO = usuario;
			PWD = password;
		}
		
	}
	
	
	
	
	public static Connection obtenerConexion () throws SQLException
	{
		Connection connection = null;
		
			connection = DriverManager.getConnection(CADENA_DE_CONEXION, BaseDatos.USUARIO, BaseDatos.PWD);
		
		return connection;
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		//String sql = "INSERT INTO `bdapuestas`.`partidos` (`fecha`,`goles_visitantes`, `goles_local`, `equipo_local`, `equipo_visitante`) VALUES (?, ?, ?, ?, ?)";
		String sql2 = "DELETE FROM bdapuestas.equipos";
		
		
		/*Partido partido = new Partido();
		Equipo e1 = new Equipo(1, "Real");
		Equipo e2 = new Equipo(2, "Atleti");
		
		partido.setEquipoLocal(e1);
		partido.setEquipoLocal(e2);
		partido.setGolesLocal(0);
		partido.setGolesVisitante(0);
		partido.setFecha(LocalDate.now());*/
		
		
		try (Connection c = obtenerConexion()){
			/*PreparedStatement ps = c.prepareStatement(sql);
			ps.setDate(1, Date.valueOf(partido.getFecha()));
			ps.setInt(2, 0);
			ps.setInt(3, 0);
			ps.setInt(4, e1.getIdequipo());
			ps.setInt(5, e2.getIdequipo());*/
			
			Statement st = c.createStatement();
			int n =  st.executeUpdate(sql2);
			
			//int n = ps.executeUpdate();
			
			System.out.println("Se han modificado " + n + " filas");
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		/*Usuario usuario = buscarExiste("valerianomoreno@gmail.com", "nomeacuerdo");
		
		if (usuario!=null)
		{
			System.out.println("El usuario existe " + usuario.toString());
			
		} else //usuario es null 
		{
			System.out.println("El usuario no existe");
		}
		
		
		usuario = buscarExiste("marcos@justeat.vip", "nomeacuerdo");
		
		if (usuario!=null)
		{
			System.out.println("El usuario existe " + usuario.toString());
			
		} else //usuario es null 
		{
			System.out.println("El usuario no existe");
		}*/
		
		/*Usuario usuario = new Usuario(0, "Vinicius", "vini@realmadrid.es", "pozo");
		
		if ( insertarUsuario(usuario))
		{
			System.out.println("Usuario insertado ");
		} else {
			System.out.println("USUARIO NO insertado");
		}
		
		
		List<Usuario> listabd =  leerUsuarios();
		System.out.println("La lista tiene " + listabd.size() + " usuarios");
		System.out.println(listabd);*/
		
	}
	
	
	
	
	
}
