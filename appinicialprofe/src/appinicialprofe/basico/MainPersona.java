package appinicialprofe.basico;

import java.io.InputStream;
import java.util.Scanner;

public class MainPersona {
	
	public static void main(String[] args) {
		System.out.println("En el Main Personas");
		Persona belen = new Persona();//estoy llamando Al constructor por defecto
		belen.edad = 23;
		belen.nombre = "Belén";
		
		Persona profe = new Persona();//estoy llamando Al constructor por defecto
		profe.edad = 39;
		profe.nombre = "Vale";
		
		Scanner sc = new Scanner(System.in);
		String mete =  sc.next();
		System.out.println(mete);
		
	}

}
