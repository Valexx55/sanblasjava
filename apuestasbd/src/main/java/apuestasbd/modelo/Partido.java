package apuestasbd.modelo;

import java.time.LocalDate;
//import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Partido {
	
	 private int id;
	 private LocalDate fecha;
	 private int golesLocal;
	 private int golesVisitante;
	 private Equipo equipoLocal;
	 private Equipo equipoVisitante;
	 
	 
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
		 
		 return listaPartidos;
	 }
	 
	 public static void main(String[] args) {
		 
		 LocalDate fecha= LocalDate.now();
		 System.out.println(fecha); 
		 fecha = fecha.plusWeeks(1);
		 System.out.println(fecha);
		 System.out.println(System.currentTimeMillis());
		//System.out.println(LocalDateTime.now());
		 
			}
	 

}
