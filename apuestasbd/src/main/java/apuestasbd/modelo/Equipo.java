package apuestasbd.modelo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
	
	public Equipo( String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public Equipo() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Equipo [idequipo=" + idequipo + ", nombre=" + nombre + "]\n";
	}

	public static void main(String[] args) {
		
		/*Equipo equipo = new Equipo(3, "FC Barcelona");
		Equipo equipo1 = new Equipo(2, "Real Madrid");
		Equipo equipo2 = new Equipo(1, "Atlético de Madrid");
		
		//List<Equipo> listaEquipos = List.of(equipo, equipo1, equipo2);
		List<Equipo> listaEquipos = new ArrayList<Equipo>();
		listaEquipos.add(equipo);
		listaEquipos.add(equipo1);
		listaEquipos.add(equipo2);
		
		System.out.println("lista equipos tras crear");
		System.out.println(listaEquipos + "\n");//\n es el caracter intro 10 o el 10 y 13
		
		Collections.shuffle(listaEquipos);
		System.out.println("lista equipos tras barajar");
		System.out.println(listaEquipos+ "\n");
		
		//Collection
		ComparadorEquiposPorId ce = new ComparadorEquiposPorId();
		Collections.sort(listaEquipos, ce);//ORDEN TOTAL -- sort invoca al Comparator.compare (o1,o2)
		System.out.println("lista equipos tras ordenar por id -TOTAL-");
		System.out.println(listaEquipos+ "\n");
		Collections.sort(listaEquipos);//ORDEN NATURAL -- sort Equipo.compareTo(equipo);
		System.out.println("lista equipos tras ordenar por Nombre -NATURAL-");
		System.out.println(listaEquipos+ "\n");*/
		
		List<Equipo> le = Equipo.cargarListaEquipos("src/main/resources/equipos.txt");
		System.out.println(le);
		
	}
	
	//ORDEN NATURAL: el método de comparación se hace dentro de la clase
	/**
	 * Ordenamos por el nombre del equipo: orden alfabético
	 */
	@Override
	public int compareTo(Equipo o) {
		int resultado = 0;
		//si this es mayor, devuelvo positivo
		//si o es mayor, devuelvo negativo
		//si son iguales, cero
		//VOY A COMPARAR POR EL NOMBRE DE LOS EQUIPOS
		resultado = this.nombre.compareTo(o.nombre);
		
		
		return resultado;
	}
	
	//TODO HACED UN MÉTODO QUE CARGUE LA LISTA
	//DE EQUIPOS DEL FICHERO "equipos.txt"
	//Y LA CREE ORDENADA ALFABÉTICAMENTE (A-Z
	public static List<Equipo> cargarListaEquipos(String ruta){
		List<Equipo> lequipos = null;
			
		
		try {
			Path pathEquipos = Path.of(ruta);
			List<String> lineas = Files.readAllLines(pathEquipos);
			lequipos = new ArrayList<Equipo>();
			for (String linea : lineas) {
				//si linea tiene *, es una Región
				
				if (linea.startsWith("*")) // if (linea.charAt(0)=='*')
				{
					System.out.println("Es una Región");
				}else 
				{
					Equipo equipo = new Equipo(linea);
					lequipos.add(equipo);
				}
			}
			//TODO ordenar
			Collections.sort(lequipos);//Al no indicar un 2º parámetro, la lista se ordena por el orden "natural" -alfabéticamente por el nombre de los equipos"
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Error al cargar el fichero");
		}
			
		
		return lequipos;
	}
	
	
}
