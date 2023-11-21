package appinicialprofe.herencia;

import java.util.ArrayList;
import java.util.List;

public class MainHerencia {
	
	public static void main(String[] args) {
		
		List<Persona> listaPersonas = null;
		
		listaPersonas = new ArrayList<Persona>();
		
		List<Estudiante> le = new ArrayList<Estudiante>();
		
		
		Persona persona = new Persona();
		
		Estudiante estudiante = new Estudiante();
		//CASTING 
		Persona persona2 = (Persona) estudiante;
		
		//Estudiante estudiante2 = (Estudiante)persona;
		
        Object opersona = 	(Object) persona;
		
		Estudiante estudiante2 = new Estudiante();
		
		estudiante2.setNombre("Alex");
		estudiante2.setEmail("alex@gmail.es");
		estudiante2.setTelefono(874521);
		estudiante2.setNumero(2);
		estudiante2.setPromedio(4);
		
		Estudiante estudiante3 = new Estudiante();
		
		estudiante3.setNombre("Lidia");
		estudiante3.setEmail("lidia@kuku.ch");
		estudiante3.setTelefono(98721);
		estudiante3.setNumero(3);
		estudiante3.setPromedio(7);
		
		Estudiante estudiante4 = new Estudiante();
		
		estudiante4.setNombre("Defeng");
		estudiante4.setEmail("defeng@kuku.ch");
		estudiante4.setTelefono(9874521);
		estudiante4.setNumero(1);
		estudiante4.setPromedio(5);
		
		
		le.add(estudiante2);
		le.add(estudiante3);
		//le.add(estudiante4);
		
		int posicion = posicionEstudiante(estudiante4, le);
		System.out.println("En la posición " + posicion);
		
		persona.setNombre("Laura");
		persona.setEmail("lau@correo.es");
		persona.setTelefono(4545848);
		
		
		listaPersonas.add(estudiante);
		listaPersonas.add(persona);
		
		
		Persona personaPos0 = listaPersonas.get(0);
		System.out.println("El nombre de 0 es " +personaPos0.getNombre());
		
		Persona personaPos1 = listaPersonas.get(1);
		System.out.println("El nombre de 1 es " +personaPos1.getNombre());
		
		for (Persona p : listaPersonas)
		{
			System.out.println(p.getNombre());
		}
		
		Persona p = null;
		for (int pos=0; pos<listaPersonas.size(); pos++)
		{
			p = listaPersonas.get(pos);
			p.mostrarPersona();
		}
		
		//listaPersonas.add((Persona)opersona);
		
		int longi =  listaPersonas.size();
		System.out.println(longi);
		
		
		
		if (estudiante instanceof Persona)
		{
			System.out.println("Sí, el estudiante es Persona");
		} else {
			System.out.println("NO, el estudiante No es Persona");
		}
		
		if (persona instanceof Estudiante)
		{
			System.out.println("Sí, la persona es Estudiante");
		} else {
			System.out.println("NO, la persona  No es Estudiante");
		}
	}
	
	/**
	 * 1) UN MÉTDO QUE RECIBA UN ALUMNO Y 
	 * UNA LISTA DE ALUMNOS Y DIGA EN QUE 
	 * POSICIÓN ESTÁ ESE ALUMNO
		O -1 SI ESE ALUMNO NO EXISTE EN AL LISTA
	 */
	
	public static int posicionEstudiante (
			Estudiante estudianteBuscado, 
			List<Estudiante> listaEstudiantes)
	{
		int posicion = -1;
		int posicionActual = 0;
		int longitud = listaEstudiantes.size();
		boolean encontrado = false;
		Estudiante estudianteAux = null;
		//hago esto hasta llegar al final o encontrar al alumno
		//recorro la lista lista y voy buscando
			//si el estudiante actual es igula al buscado, me guardo la posición
			//si no voy a la siguiente
		while ((posicionActual<longitud)&& (!encontrado))
		{
			estudianteAux = listaEstudiantes.get(posicionActual);
			//si el estudianteAux es igual a estudianteBuscado
			//encontrado = true y actualizo posicion
			System.out.println("Estudiante actual " + estudianteAux.toString());
			if (estudianteAux.equals(estudianteBuscado))
			{
				encontrado = true;
				posicion = posicionActual;
			} 
			
			//si no, voy al siguiente
			else {
				posicionActual++;
			}
		}
		
		return posicion;
	}
	
	
	
	 
	
	

}
