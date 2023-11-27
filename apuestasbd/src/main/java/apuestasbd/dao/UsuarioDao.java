package apuestasbd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import apuestasbd.BaseDatos;
import apuestasbd.modelo.Usuario;

/**
 * En esta clase, vamos a agurpar todas las operaciones
 * de base datos relaciones con el Usuario
 */
public class UsuarioDao {
	
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
	public List<Usuario> leerUsuarios ()// throws SQLException
	{
		List<Usuario> listaUsuarios = null;
		
		
		try (Connection conexion = BaseDatos.obtenerConexion();) 
		   {
			
			System.out.println("Conexión realizada");
			Statement instruccion = conexion.createStatement();
			ResultSet rs = instruccion.executeQuery(INSTRUCCION_LEER_USUARIOS);
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
			e.printStackTrace();
			
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
	
	public Usuario buscarExiste (String email, String pwd)// throws SQLException
	{
		Usuario usuario = null;
		
		try (Connection conexion = BaseDatos.obtenerConexion())
		    {
			
			System.out.println("Conexión realizada");
			PreparedStatement instruccion = conexion.prepareStatement(INSTRUCCION_LEER_USUARIOS_FILTRO);
			instruccion.setString(1, email);
			instruccion.setString(2, pwd);
			ResultSet rs = instruccion.executeQuery();
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
			e.printStackTrace();
			
		}
		
		return usuario;
		
	}
	
	public boolean insertarUsuario (Usuario usuario)
	{
		boolean insertado = false;
		
		//TRY con recursos
		//es poner el tryu conb parénteisis después
		//declaras la conexión dentro y se cuerra sola
		 
		try ( Connection conexion =BaseDatos.obtenerConexion()){
			
			System.out.println("Conexión realizada");
			PreparedStatement instruccion = conexion.prepareStatement(INSTRUCCION_INSERTAR_USUARIO);
			instruccion.setString(1, usuario.getNombre());
			instruccion.setString(2, usuario.getEmail());
			instruccion.setString(3, usuario.getPassword());
			int nfilasnuevas = instruccion.executeUpdate();
			insertado = (nfilasnuevas==1);
			
		} catch (SQLException e) {
			e.printStackTrace();
			//throw e;//propago la excepción
			
		}
		
		return insertado;
	}


	//TODO borrar usuario - DELETE - ALBA
	public boolean borrarUsuario (String email)
	{
		boolean borrado = false;
		
		return borrado;
	}
	//TODO modificar contraseña usuario - UPDATE - ELHIEZER
	
	public boolean modificarUsuario (String email, String nuevapwd)
	{
		boolean modificado = false;
		
		return modificado;
	}

}
