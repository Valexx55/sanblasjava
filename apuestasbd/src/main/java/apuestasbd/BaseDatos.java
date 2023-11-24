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
	
	public static final String INSTRUCCION_LEER_USUARIOS = "SELECT * FROM bdapuestas.usuarios;";
	public static final String INSTRUCCION_LEER_USUARIOS_FILTRO = "SELECT * FROM bdapuestas.usuarios WHERE email=? AND password=?";
	public static final String INSTRUCCION_INSERTAR_USUARIO = "INSERT INTO `bdapuestas`.`usuarios` (`nombre`, `email`, `password`) VALUES (?,?,?);";
	
	
	/**
	 * Méotod que reeucpera de la base de datos 
	 * el listado de usuarios registrados
	 * 
	 * 
	 * 
	 * @return
	 * @throws SQLException 
	 */
	public static List<Usuario> leerUsuarios ()// throws SQLException
	{
		List<Usuario> listaUsuarios = null;
		
		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection(CADENA_DE_CONEXION, BaseDatos.USUARIO, BaseDatos.PWD);
			System.out.println("Conexión realizada");
			Statement instruccion = conexion.createStatement();
			ResultSet rs = instruccion.executeQuery(INSTRUCCION_LEER_USUARIOS);
			//TODO recorrer los resultados el rs
			int idUsuarioAux = 0;
			String nombreAux, emailAux, pwdWaux = null;
			Usuario usuarioAux = null;
			listaUsuarios = new ArrayList<Usuario>();
			while (rs.next()) //mientras haya filas, dame una
			{
				idUsuarioAux = rs.getInt("idusuarios");
				nombreAux = rs.getString("nombre");
				emailAux = rs.getString("email");
				pwdWaux = rs.getString("password");
				usuarioAux = new Usuario(idUsuarioAux, nombreAux, emailAux, pwdWaux);
				listaUsuarios.add(usuarioAux);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//throw e;//propago la excepción
			
		} finally {
			System.out.println("ESTO SE EJECUTA SIEMPRE");
			try {
				conexion.close();
				System.out.println("Conexión cerrada OK!");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return listaUsuarios;
		
	}
	
	/**
	 * El método busca un usuario en la base de datos
	 * 
	 * @param email el email del usuario buscado
	 * @param pwd la pwd del usuario buscado
	 * @return null si no lo encuentra o el usuario si existía
	 * con esas credenciales
	 */
	
	public static Usuario buscarExiste (String email, String pwd)// throws SQLException
	{
		Usuario usuario = null;
		
		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection(CADENA_DE_CONEXION, BaseDatos.USUARIO, BaseDatos.PWD);
			System.out.println("Conexión realizada");
			PreparedStatement instruccion = conexion.prepareStatement(INSTRUCCION_LEER_USUARIOS_FILTRO);
			instruccion.setString(1, email);
			instruccion.setString(2, pwd);
			ResultSet rs = instruccion.executeQuery();
			//TODO recorrer los resultados el rs
			int idUsuarioAux = 0;
			String nombreAux, emailAux, pwdWaux = null;
			if (rs.next()) //si recuperra un resultado
			{
				idUsuarioAux = rs.getInt("idusuarios");
				nombreAux = rs.getString("nombre");
				emailAux = rs.getString("email");
				pwdWaux = rs.getString("password");
				usuario = new Usuario(idUsuarioAux, nombreAux, emailAux, pwdWaux);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//throw e;//propago la excepción
			
		} finally {
			System.out.println("ESTO SE EJECUTA SIEMPRE");
			try {
				conexion.close();
				System.out.println("Conexión cerrada OK!");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return usuario;
		
	}
	
	
	
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
		
		Usuario usuario = new Usuario(0, "Vinicius", "vini@realmadrid.es", "pozo");
		
		if ( insertarUsuario(usuario))
		{
			System.out.println("Usuario insertado ");
		} else {
			System.out.println("USUARIO NO insertado");
		}
		
		
		List<Usuario> listabd =  leerUsuarios();
		System.out.println("La lista tiene " + listabd.size() + " usuarios");
		System.out.println(listabd);
		
	}
	
	public static boolean insertarUsuario (Usuario usuario)
	{
		boolean insertado = false;
		
		//TRY con recursos
		//es poner el tryu conb parénteisis después
		//declaras la conexión dentro y se cuerra sola
		try (
				Connection conexion = 
			DriverManager.getConnection(CADENA_DE_CONEXION, BaseDatos.USUARIO, BaseDatos.PWD);
			){
			
			System.out.println("Conexión realizada");
			PreparedStatement instruccion = conexion.prepareStatement(INSTRUCCION_INSERTAR_USUARIO);
			instruccion.setString(1, usuario.getNombre());
			instruccion.setString(2, usuario.getEmail());
			instruccion.setString(3, usuario.getPassword());
			int nfilasnuevas = instruccion.executeUpdate();
			insertado = (nfilasnuevas==1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//throw e;//propago la excepción
			
		}
		
		return insertado;
	}
	
	
	
}
