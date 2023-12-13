package apuestasbd.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import apuestasbd.BaseDatos;

public class ApuestaDao {

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
