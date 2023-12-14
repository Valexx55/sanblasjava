package apuestasbd.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import apuestasbd.BaseDatos;
import apuestasbd.modelo.Apuesta;
import apuestasbd.modelo.Equipo;
import apuestasbd.modelo.Partido;

public class ApuestaDao {

	public static final String LEER_APUESTAS_PARTIDO = "SELECT * FROM bdapuestas.apuestas a WHERE a.partido=?;";
	
	
	public boolean guardarApuesta (Apuesta apuesta)
	{
		boolean ok = false;
		
		return ok;
	}

	public List<Apuesta> leerApuestasPartido(Partido partido) {
		List<Apuesta> lApuestas = null;

		try (Connection connection = BaseDatos.obtenerConexion()) {
			PreparedStatement ps = connection.prepareStatement(LEER_APUESTAS_PARTIDO);
			ps.setInt(1, partido.getId());
			ResultSet rs = ps.executeQuery();
			lApuestas = new ArrayList<Apuesta>();
			Apuesta apuestaAux = null;// cada fila/resultado
			int colidapuestas, colgv, colgl, colusuario, colpartido = 0;
			float colvalor = 0;
			while (rs.next()) {
				colidapuestas = rs.getInt("idapuestas");
				colvalor = rs.getFloat("valor");
				colgv = rs.getInt("goles_visitante");
				colgl = rs.getInt("goles_local");
				colusuario = rs.getInt("usuario");
				colpartido = rs.getInt("partido");

				apuestaAux = new Apuesta(colidapuestas, colvalor, colgl, colgv, colusuario, colpartido);
				lApuestas.add(apuestaAux);
			} // while
		} // try
		catch (Exception e) {
			e.printStackTrace();
		}

		return lApuestas;
	}

	// TODO FUNCIONALIDAD DE EQUIPO FAVORITO EN APUESTAS by Harrison
	/**
	 * Este método obtiene el equipo favorito de un partido, en base a las apuestas
	 * realizadas sobre ese partido.
	 * 
	 * Un equipo es el favorito si tiene más apuestas con resultado a favor que otro
	 * 
	 * @param partido
	 * @return el equipo favorito o null si no hay un favorito
	 */
	public Equipo obtenerEquipoFavoritoPartido(Partido partido) {
		Equipo equipoFavorito = null;

		// 1 SACAR APUESTAS DE ESE PARTIDO
		List<Apuesta> listaApuestas = leerApuestasPartido(partido);
		int nvecesfavlocal = 0;
		int nvecesfavvisitante = 0;

		for (Apuesta a : listaApuestas) {
			if (a.getGoles_local() > a.getGoles_visitante()) {
				nvecesfavlocal++;
			} else if (a.getGoles_visitante() > a.getGoles_local()) {
				nvecesfavvisitante++;
			}
		}

		if (nvecesfavlocal > nvecesfavvisitante) {
			equipoFavorito = partido.getEquipoLocal();
		} else if (nvecesfavvisitante > nvecesfavlocal) {
			equipoFavorito = partido.getEquipoVisitante();
		}

		return equipoFavorito;
	}

	public Map<String, Float> obtenerEstadisticosApuestas() {
		Map<String, Float> mapaEstadisticas = null;

		try (Connection connection = BaseDatos.obtenerConexion()) {

			// preparo
			CallableStatement cs = connection.prepareCall("{call calcular_max_min_media_apuestas (?,?,?)}");
			cs.registerOutParameter(1, java.sql.Types.FLOAT);
			cs.registerOutParameter(2, java.sql.Types.FLOAT);
			cs.registerOutParameter(3, java.sql.Types.FLOAT);

			// ejecuto

			cs.execute();

			mapaEstadisticas = new HashMap<String, Float>();
			// hay media, maximo y minimo
			float maximo = cs.getFloat(1);
			float minino = cs.getFloat(2);
			float media = cs.getFloat(3);
			mapaEstadisticas.put("maximo", maximo);
			mapaEstadisticas.put("minimo", minino);
			mapaEstadisticas.put("media", media);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return mapaEstadisticas;
	}

}
