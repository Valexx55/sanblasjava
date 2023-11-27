package apuestasbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

import apuestasbd.modelo.Usuario;

public class BaseDatos {
	
	public static final String SERVIDOR_BD = "localhost";
	public static final String PUERTO = "3306";
	public static final String USUARIO = "root";
	public static final String PWD = "root";
	public static final String CADENA_DE_CONEXION = "jdbc:mysql://"+SERVIDOR_BD+":"+PUERTO+"/bdapuestas";
	
	
	
	
	
	
	public static Connection obtenerConexion () throws SQLException
	{
		Connection connection = null;
		
			connection = DriverManager.getConnection(CADENA_DE_CONEXION, BaseDatos.USUARIO, BaseDatos.PWD);
		
		return connection;
		
	}
	
	
	
	
	/*
	public static void main(String[] args) {
		
		
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
		System.out.println(listabd);
		
	}*/
	
	
	
	
	
}
