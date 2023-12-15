package apuestasbd.modelo;

import java.util.List;

import apuestasbd.Pantalla;
import apuestasbd.dao.EquipoDao;
import apuestasbd.dao.PartidoDao;

public class Apuesta {
	
	private int id;
	private float valor;
	private int goles_local;
	private int goles_visitante;
	private int idUsuario;
	private int idPartido;
	
	
	
	public Apuesta() {
	}
	
	public Apuesta(int id, float valor, int goles_local, int goles_visitante, int idUsuario, int idPartido) {
		super();
		this.id = id;
		this.valor = valor;
		this.goles_local = goles_local;
		this.goles_visitante = goles_visitante;
		this.idUsuario = idUsuario;
		this.idPartido = idPartido;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public float getValor() {
		return valor;
	}




	public void setValor(float valor) {
		this.valor = valor;
	}




	public int getGoles_local() {
		return goles_local;
	}




	public void setGoles_local(int goles_local) {
		this.goles_local = goles_local;
	}




	public int getGoles_visitante() {
		return goles_visitante;
	}




	public void setGoles_visitante(int goles_visitante) {
		this.goles_visitante = goles_visitante;
	}




	public int getIdUsuario() {
		return idUsuario;
	}




	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}




	public int getIdPartido() {
		return idPartido;
	}




	public void setIdPartido(int idPartido) {
		this.idPartido = idPartido;
	}




	@Override
	public String toString() {
		return "Apuesta [id=" + id + ", valor=" + valor + ", goles_local=" + goles_local + ", goles_visitante="
				+ goles_visitante + ", idUsuario=" + idUsuario + ", idPartido=" + idPartido + "]";
	}

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
		Apuesta apuesta = Pantalla.pedirDatosApuesta();
		//asignar a la apuesta el usuario y el partido
		apuesta.setIdPartido(partidoApuesta.getId());
		apuesta.setIdUsuario(usuario.getId());
		
		//6 GUARDAR 
		//TODO GUARDAR APUESTA
		
		return ok;
	}

}
