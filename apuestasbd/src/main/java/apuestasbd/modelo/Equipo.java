package apuestasbd.modelo;

import java.util.List;

public class Equipo {
	
	private int	idequipo;
	private String nombre;
	public int getIdequipo() {
		return idequipo;
	}
	public void setIdequipo(int idequipo) {
		this.idequipo = idequipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Equipo(int idequipo, String nombre) {
		super();
		this.idequipo = idequipo;
		this.nombre = nombre;
	}
	
	public Equipo() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Equipo [idequipo=" + idequipo + ", nombre=" + nombre + "]";
	}

	public static void main(String[] args) {
		
		Equipo equipo = new Equipo(1, "FC Barcelona");
		Equipo equipo1 = new Equipo(2, "Real Madrid");
		Equipo equipo2 = new Equipo(3, "Atlético de Madrid");
		
		List<Equipo> listaEquipos = List.of(equipo, equipo1, equipo2);
		
		System.out.println(listaEquipos);
		
	}
}
