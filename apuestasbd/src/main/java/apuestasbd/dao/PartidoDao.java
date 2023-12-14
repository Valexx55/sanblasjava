package apuestasbd.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import apuestasbd.BaseDatos;
import apuestasbd.modelo.Equipo;
import apuestasbd.modelo.Partido;

public class PartidoDao {
	
	
	
	
	public PartidoDao() {
		// TODO Auto-generated constructor stub
	}
	
	



	//INSERT INTO `bdapuestas`.`partidos` (`fecha`,`goles_visitantes`, `goles_local`, `equipo_local`, `equipo_visitante`) VALUES ?, ?, ?, ?);
	
	public static final String INSERTAR_PARITIDOS = "INSERT INTO `bdapuestas`.`partidos` (`fecha`,`goles_visitantes`, `goles_local`, `equipo_local`, `equipo_visitante`) VALUES (?, ?, ?, ?, ?);";
	
	public static final String CONSULTA_NUM_PARITIDOS = "SELECT COUNT(*) FROM bdapuestas.partidos;"; 

	//TODO mejora: consultar sólo los partidos de fecha posterior a la actual
	//public static final String CONSULTA_PARITIDOS_EQUIPO = "SELECT * FROM bdapuestas.partidos WHERE equipo_local=? OR equipo_visitante=?;";
	public static final String CONSULTA_PARITIDOS_EQUIPO = """
			SELECT p.idpartidos, p.fecha, p.equipo_visitante, p.equipo_local, 
			v.nombre AS "nombre_visitante", l.nombre AS "nombre_local"
			FROM partidos p 
			LEFT JOIN equipos l ON p.equipo_local=l.idequipos
			LEFT JOIN equipos v ON p.equipo_visitante=v.idequipos
			WHERE p.equipo_local=? OR p.equipo_visitante=?;
			"""; 
	
	
	//TODO seleccionar los partidos de un equipo 
	public  List<Partido> buscarPartidosEquipo (Equipo equipo){
			List<Partido> listP = null;
			
			try(Connection connection = BaseDatos.obtenerConexion()) 
			{
			PreparedStatement preparedStatement = connection.prepareStatement(CONSULTA_PARITIDOS_EQUIPO);
			preparedStatement.setInt(1, equipo.getIdequipo());
			preparedStatement.setInt(2, equipo.getIdequipo());
			ResultSet resultados = preparedStatement.executeQuery();
			
			Partido partido_aux = null;
			int idpartido = 0;
			Date fecha = null;
			int idequipoLocal, idequipoVisitante = 0;
			String nombre_visitante = null;
			String nombre_local = null;
			
			listP = new ArrayList<Partido>();
			
			while (resultados.next())//mientras haya Partidos
			{
				idpartido = resultados.getInt("idpartidos");
				fecha = resultados.getDate("fecha");
				idequipoLocal = resultados.getInt("equipo_local");
				idequipoVisitante = resultados.getInt("equipo_visitante");
				nombre_local = resultados.getString("nombre_local");
				nombre_visitante = resultados.getString("nombre_visitante");
				
				partido_aux = new Partido();
				partido_aux.setId(idpartido);
				partido_aux.setFecha(fecha.toLocalDate());
				
				Equipo equipoLocal = new Equipo();
				equipoLocal.setIdequipo(idequipoLocal);
				equipoLocal.setNombre(nombre_local);
				
				Equipo equipoVisitante = new Equipo();
				equipoVisitante.setIdequipo(idequipoVisitante);
				equipoVisitante.setNombre(nombre_visitante);
				
				partido_aux.setEquipoLocal(equipoLocal);
				partido_aux.setEquipoVisitante(equipoVisitante);
				
				listP.add(partido_aux);
			}
			
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			return listP;
		}

	
	public boolean insertarPartidos (List<Partido> listaPartidos)
	{
		boolean ok = false;
		
		//TODO insertar todos los partidos
		//partido.setFecha(LocalDate.now())
		//ps.setDate(1, Date.valueOf(partido.getFecha()));
		try (Connection connection = BaseDatos.obtenerConexion()) 
		{
			PreparedStatement ps = connection.prepareStatement(INSERTAR_PARITIDOS);
			LocalDate fecha_partido = LocalDate.now();
			
			for (Partido p : listaPartidos) 
			{
				//ponemos un partido cada día
				//LocalDate igual que String, son inmutables:
				//si lo modifico, realmente se crea un objeto nuevo
				fecha_partido = fecha_partido.plusDays(1);
				ps.setDate(1, Date.valueOf(fecha_partido));
				ps.setInt(2, p.getGolesVisitante());
				ps.setInt(3, p.getGolesLocal());
				ps.setInt(4, p.getEquipoLocal().getIdequipo());
				ps.setInt(5, p.getEquipoVisitante().getIdequipo());
				
				ps.addBatch();//por lotes
			}
			ps.executeBatch();
			ok = true;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return ok;
	}
	
	
	public boolean insertarPartidos (List<Partido> listaPartidos, Connection connection)
	{
		boolean ok = false;
		
		//TODO insertar todos los partidos
		//partido.setFecha(LocalDate.now())
		//ps.setDate(1, Date.valueOf(partido.getFecha()));
		try  
		{
			PreparedStatement ps = connection.prepareStatement(INSERTAR_PARITIDOS);
			LocalDate fecha_partido = LocalDate.now();
			
			for (Partido p : listaPartidos) 
			{
				//ponemos un partido cada día
				//LocalDate igual que String, son inmutables:
				//si lo modifico, realmente se crea un objeto nuevo
				fecha_partido = fecha_partido.plusDays(1);
				ps.setDate(1, Date.valueOf(fecha_partido));
				ps.setInt(2, p.getGolesVisitante());
				ps.setInt(3, p.getGolesLocal());
				ps.setInt(4, p.getEquipoLocal().getIdequipo());
				ps.setInt(5, p.getEquipoVisitante().getIdequipo());
				
				ps.addBatch();//por lotes
			}
			ps.executeBatch();
			ok = true;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return ok;
	}

}
