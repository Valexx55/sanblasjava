package apuestasbd.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import apuestasbd.BaseDatos;
import apuestasbd.modelo.Partido;

public class PartidoDao {
	
	
	
	
	public PartidoDao() {
		// TODO Auto-generated constructor stub
	}
	
	



	//INSERT INTO `bdapuestas`.`partidos` (`fecha`,`goles_visitantes`, `goles_local`, `equipo_local`, `equipo_visitante`) VALUES ?, ?, ?, ?);
	
	public static final String INSERTAR_PARITIDOS = "INSERT INTO `bdapuestas`.`partidos` (`fecha`,`goles_visitantes`, `goles_local`, `equipo_local`, `equipo_visitante`) VALUES (?, ?, ?, ?, ?);";
	
	public static final String CONSULTA_NUM_PARITIDOS = "SELECT COUNT(*) FROM bdapuestas.partidos;"; 
	
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
