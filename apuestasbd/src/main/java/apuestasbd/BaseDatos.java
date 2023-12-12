package apuestasbd;

import java.io.FileReader;
import java.sql.CallableStatement;
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
		
		
		//String sql2 = "DELETE FROM bdapuestas.equipos";
		
		
		
		try (Connection c = obtenerConexion()){
			
			
			//Statement st = c.createStatement();
			CallableStatement cs = c.prepareCall("{call calcular_max_min_media_apuestas (?,?,?)};");
			cs.registerOutParameter("apuestamax", java.sql.Types.INTEGER);
			cs.registerOutParameter("apuestamin", java.sql.Types.INTEGER);
			cs.registerOutParameter("apuestamedia", java.sql.Types.FLOAT);
			boolean res = cs.execute();
			System.out.println(res);
			ResultSet rs = cs.getResultSet();
			if (rs.next())
			{
				System.out.println(rs.getInt("apuestamax"));
				System.out.println(rs.getInt("apuestamin"));
				System.out.println(rs.getFloat("apuestamedia"));
			} else {
				System.out.println("sin resultados");
			}
			
			
			//int n =  st.executeUpdate(sql2);
			
			
			
			//System.out.println("Se han modificado " + n + " filas");
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
}
