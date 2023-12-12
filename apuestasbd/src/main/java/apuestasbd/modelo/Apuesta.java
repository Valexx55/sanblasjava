package apuestasbd.modelo;

import java.util.List;

import apuestasbd.Pantalla;
import apuestasbd.dao.EquipoDao;
import apuestasbd.dao.PartidoDao;

public class Apuesta {
	
	/**
	 * El método permite que el usuario haga una apuesta sobre un
	 * partido
	 * @param usuario el usuario que quiere apostar
	 * @return true si la apuesta se registró correctamente
	 * false en caso contrario.
	 */
	public static boolean apostar (Usuario usuario)
	{
		boolean ok =false;
		
		//1 a qué equipo
		//TODO LEER LOS EQUIPOS QUE HAY EN BD
		EquipoDao equipoDao = new EquipoDao();
		List<Equipo> listaEquipos = equipoDao.leerEquipos();
		Equipo equipoApostar = Pantalla.mostrarYElgirEquipoApuesta(listaEquipos);
		//2 listamos partidos de ese equipo
		PartidoDao partidoDao = new PartidoDao();
		List<Partido> lp = partidoDao.buscarPartidosEquipo(equipoApostar);
		//3 elegimos partido
		Partido partidoApuesta = Pantalla.mostrarYElegirPartidoApuesta(lp);
		//4 ponemos resultado
		//5 dienero apostado
		
		return ok;
	}

}
