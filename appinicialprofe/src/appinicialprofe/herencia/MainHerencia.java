package appinicialprofe.herencia;

import java.util.ArrayList;
import java.util.List;

public class MainHerencia {
	
	public static void main(String[] args) {
		
		List<Persona> listaPersonas = null;
		
		listaPersonas = new ArrayList<Persona>();
		
		
		
		Persona persona = new Persona();
		
		Estudiante estudiante = new Estudiante();
		//CASTING 
		Persona persona2 = (Persona) estudiante;
		
		//Estudiante estudiante2 = (Estudiante)persona;
		
        Object opersona = 	(Object) persona;
		
		Estudiante estudiante2 = (Estudiante)persona2;
		
		estudiante.setNombre("Defeng");
		estudiante.setEmail("defeng@kuku.ch");
		estudiante.setTelefono(9874521);
		estudiante.setNumero(1);
		estudiante.setPromedio(5);
		
		
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

}
