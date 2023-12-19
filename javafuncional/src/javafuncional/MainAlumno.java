package javafuncional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MainAlumno {

	public static void main(String[] args) {

		Alumno alumno = new Alumno(3, "Alex");
		Alumno alumno1 = new Alumno(5, "Vini");
		Alumno alumno2 = new Alumno(7, "Kevin");
		Alumno alumno3 = new Alumno(10, "Harrison");

		List<Alumno> la = List.of(alumno, alumno1, alumno2, alumno3);
		List<Alumno> la2 = new ArrayList<Alumno>(la);
		
		//TODO Ordenar la lista de Alumnos por nota;
		/*la2.sort((Alumno a1, Alumno a2) -> {
			int resultado = 0;
			if (a1.getNota()>a2.getNota())
			{
				resultado = 1;
			} else if (a1.getNota()<a2.getNota())
			{
				resultado = -1;
			}else {
				resultado = 0;
			}
			return resultado;
		});*/
		
		la2.sort((a1, a2)-> a2.getNota()-a1.getNota());
		System.out.println("ORDEN POR NOTA = "+ la2);
		
		//la.add("HOLA");
		/*Alumno alumno4 = new Alumno();
		System.out.println(alumno.toString());
		System.out.println(alumno4);*/

		// TODO HACED UN MÉTODO QUE RECIBA UNA LISTA
		// Y ME DEVUELVA OTRA LISTA SÓLO CON LOS ALUMNOS
		// EXCELENTES. UN ALUMNO ES EXCELENTE SI SU NOTA ES MAYOR A 7
		
		List<Alumno> listaExcelentes = MainAlumno.filtrarAlumnosExcelent(la);
		System.out.println("Lista excelentes " +listaExcelentes);
		Predicate<Alumno> predicado = new AlumnoExcelente();
		//la2.removeIf(predicado);
		
		//la2.removeIf(a -> true);
		//System.out.println("QUEDA ALGUIEN ?? " +la2);
		//la2.removeIf((Alumno a) -> {return true;});
		/*la2.removeIf((Alumno a) -> 
			{
				if (a.getNota()<=7)
				{
					return true;
					} 
				else {
					return false;
				}
				
			}
			);
		System.out.println("QUEDA ALGUIEN 2 ?? " +la2);*/
		
		
		

	}

	public static List<Alumno> filtrarAlumnosExcelent(List<Alumno> listaAlumnos) {
		List<Alumno> estudiantesExcelent = null;//di omito el <Alumno> se me crea una lista de objetos
		
		estudiantesExcelent = new ArrayList<Alumno>();//<> OPERADOR diamante
		for (Alumno estudiante : listaAlumnos) {
			if (estudiante.getNota() > 7) {
				estudiantesExcelent.add(estudiante);
			}
		}
		return estudiantesExcelent;
	}

}
