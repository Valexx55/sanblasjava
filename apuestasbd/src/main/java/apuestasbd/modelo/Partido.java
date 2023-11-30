package apuestasbd.modelo;

import java.time.LocalDate;
//import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

public class Partido {
	
	 private int id;
	 private LocalDate fecha;
	 private int golesLocal;
	 private int golesVisitante;
	 private Equipo equipoLocal;
	 private Equipo equipoVisitante;
	 
	 
	 
	 public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getGolesLocal() {
		return golesLocal;
	}

	public void setGolesLocal(int golesLocal) {
		this.golesLocal = golesLocal;
	}

	public int getGolesVisitante() {
		return golesVisitante;
	}

	public void setGolesVisitante(int golesVisitante) {
		this.golesVisitante = golesVisitante;
	}

	public Equipo getEquipoLocal() {
		return equipoLocal;
	}

	public void setEquipoLocal(Equipo equipoLocal) {
		this.equipoLocal = equipoLocal;
	}

	public Equipo getEquipoVisitante() {
		return equipoVisitante;
	}

	public void setEquipoVisitante(Equipo equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}

	
	
	public Partido(int id, LocalDate fecha, int golesLocal, int golesVisitante, Equipo equipoLocal,
			Equipo equipoVisitante) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.golesLocal = golesLocal;
		this.golesVisitante = golesVisitante;
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
	}

	public Partido() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Partido(Equipo equipoLocal, Equipo equipoVisitante) {
		super();
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
	}
	
	

	@Override
	public String toString() {
		return "Partido [equipoLocal=" + equipoLocal + ", equipoVisitante=" + equipoVisitante + "]\n";
	}

	/**
	  * El método crea una lista de partidos donde los equipos recibidos
	  * se enfrentan ida y vuelta
	  * 	  * 
	  * @param listaEquipos
	  * @return la lista de partidos creada
	  */
	 public static List<Partido> generarPartidos (List<Equipo> listaEquipos)
	 {
		 List<Partido> listaPartidos = null;
		 
		 	int numPartidos = listaEquipos.size() * (listaEquipos.size()-1); 
		 	listaPartidos = new ArrayList<Partido>(numPartidos);
		 	
		 	//TODO completar partidos con fecha
		 	for (int i=0; i<listaEquipos.size()-1;i++)
		 	{
		 		Equipo equipoLocal = listaEquipos.get(i);
		 		for (int j=i+1; j<listaEquipos.size();j++) {
		 			
					Equipo equipoVisitante = listaEquipos.get(j);
					Partido partidoIda = new Partido(equipoLocal, equipoVisitante);
					listaPartidos.add(partidoIda);
					Partido partidoVuelta = new Partido(equipoVisitante, equipoLocal);
					listaPartidos.add(partidoVuelta);
					
					
				}
		 	}
		 	
		 	
		 	
		 
		 return listaPartidos;
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
			
			List<Partido> lp = Partido.generarPartidos(listaEquipos);
			System.out.println(lp);
		 
		 LocalDate fecha= LocalDate.now();
		 System.out.println(fecha); 
		 fecha = fecha.plusWeeks(1);
		 System.out.println(fecha);
		 System.out.println(System.currentTimeMillis());
		//System.out.println(LocalDateTime.now());
		 
			}
	 

}
