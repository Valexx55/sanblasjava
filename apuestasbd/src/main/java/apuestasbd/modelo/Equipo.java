package apuestasbd.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Equipo implements Comparable<Equipo>{
	
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
		
		Equipo equipo = new Equipo(3, "FC Barcelona");
		Equipo equipo1 = new Equipo(2, "Real Madrid");
		Equipo equipo2 = new Equipo(1, "Atlético de Madrid");
		
		//List<Equipo> listaEquipos = List.of(equipo, equipo1, equipo2);
		List<Equipo> listaEquipos = new ArrayList<Equipo>();
		listaEquipos.add(equipo);
		listaEquipos.add(equipo1);
		listaEquipos.add(equipo2);
		
		System.out.println("lista equipos tras crear");
		System.out.println(listaEquipos);
		
		Collections.shuffle(listaEquipos);
		System.out.println("lista equipos tras barajar");
		System.out.println(listaEquipos);
		
		//Collection
		ComparadorEquiposPorId ce = new ComparadorEquiposPorId();
		Collections.sort(listaEquipos, ce);
		System.out.println("lista equipos tras ordenar");
		System.out.println(listaEquipos);
		//Collections.sort(null);
		
	}
	
	//ORDEN NATURAL: el método de comparación se hace dentro de la clase
	@Override
	public int compareTo(Equipo o) {
		// TODO tengo que comparar o con this
		return 0;
	}
}
