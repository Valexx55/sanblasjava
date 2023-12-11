package apuestasbd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import apuestasbd.BaseDatos;
import apuestasbd.modelo.Equipo;

public class EquipoDao {

	
	public EquipoDao() {
		// TODO Auto-generated constructor stub
	}

	

	// TEXT Blocks JAVA 15 https://openjdk.org/jeps/378
	// si pongo escape (barra invertida - backslash -)
	// me quita el salto de línea

	private static final String INSERTAR_EQUIPO = """
			INSERT INTO `bdapuestas`.`equipos` \
			(`nombre`) VALUES (?);""";

	private static final String BORRAR_EQUIPOS = """
			DELETE FROM bdapuestas.equipos""";

	private static final String LEER_EQUIPOS = """
			SELECT * FROM bdapuestas.equipos""";

	public boolean borrarEquipos() {
		boolean equiposBorrados = false;

		try (Connection connection = BaseDatos.obtenerConexion())

		{

			Statement instruccion = connection.createStatement();
			int nregistros = instruccion.executeUpdate(BORRAR_EQUIPOS);
			System.out.println(nregistros + " equipos borrados");
			equiposBorrados = true;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return equiposBorrados;
	}

	public boolean borrarEquipos(Connection connection) {
		boolean equiposBorrados = false;

		try

		{

			Statement instruccion = connection.createStatement();
			int nregistros = instruccion.executeUpdate(BORRAR_EQUIPOS);
			System.out.println(nregistros + " equipos borrados");
			equiposBorrados = true;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return equiposBorrados;
	}

	public boolean insertarEquipos(List<Equipo> listaEquipos) {
		boolean insertadosOk = false;

		try (Connection connection = BaseDatos.obtenerConexion()) {
			PreparedStatement ps = connection.prepareStatement(INSERTAR_EQUIPO);

			for (Equipo e : listaEquipos) {
				ps.setString(1, e.getNombre());
				// ps.executeUpdate();//voy ejecutando de 1 en 1
				ps.addBatch();// voy acumulando
			}
			int[] resultados = ps.executeBatch();// ejecuta todos los insert acumulados de una vez

			int pos = -1;

			do {
				pos++;
			} while (pos < resultados.length && resultados[pos] == 1);

			insertadosOk = (pos == resultados.length);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			insertadosOk = false;
		}

		return insertadosOk;

	}

	public boolean insertarEquipos(List<Equipo> listaEquipos, Connection connection) {
		boolean insertadosOk = false;

		try {
			PreparedStatement ps = connection.prepareStatement(INSERTAR_EQUIPO);

			for (Equipo e : listaEquipos) {
				ps.setString(1, e.getNombre());
				// ps.executeUpdate();//voy ejecutando de 1 en 1
				ps.addBatch();// voy acumulando
			}
			int[] resultados = ps.executeBatch();// ejecuta todos los insert acumulados de una vez

			int pos = -1;

			do {
				pos++;
			} while (pos < resultados.length && resultados[pos] == 1);

			insertadosOk = (pos == resultados.length);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			insertadosOk = false;
		}

		return insertadosOk;

	}

	public List<Equipo> leerEquipos() {
		List<Equipo> lEquipos = null;

		try (Connection connection = BaseDatos.obtenerConexion()) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(LEER_EQUIPOS);

			Equipo equipoAux = null;
			int idequipo = 0;
			String nombrequipo = null;
			lEquipos = new ArrayList<Equipo>(); // creo la lista

			while (resultSet.next()) {
				idequipo = resultSet.getInt("idequipos");
				nombrequipo = resultSet.getString("nombre");
				equipoAux = new Equipo(idequipo, nombrequipo);
				lEquipos.add(equipoAux);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lEquipos;
	}

	public List<Equipo> leerEquipos(Connection connection) {
		List<Equipo> lEquipos = null;

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(LEER_EQUIPOS);

			Equipo equipoAux = null;
			int idequipo = 0;
			String nombrequipo = null;
			lEquipos = new ArrayList<Equipo>(); // creo la lista

			while (resultSet.next()) {
				idequipo = resultSet.getInt("idequipos");
				nombrequipo = resultSet.getString("nombre");
				equipoAux = new Equipo(idequipo, nombrequipo);
				lEquipos.add(equipoAux);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lEquipos;
	}

	public static void main(String[] args) {

		List<Equipo> le = Equipo.cargarListaEquipos("src/main/resources/equipos.txt");
		EquipoDao equipoDao = new EquipoDao();
		boolean insertado = equipoDao.insertarEquipos(le);
		if (insertado) {
			System.out.println("equipos insertados");
			equipoDao.borrarEquipos();
		} else {
			System.out.println("equipos No insertados");
		}

	}

}
