package appinicialprofe.herencia;

public class MainPersonaEquals {
	
	public static void main(String[] args) {
		
		Persona p1 = new Persona("VINI", 557799, "vini@realmadrid.es");
		Persona p2 = new Persona("KEVIN", 94549, "kevin@funela.es");
		Persona p3 = new Persona("KEVIN", 94549, "kevin@funela.es");
		
		if (p2.equals(p3)) {
			System.out.println("son iguales");
		} else {
			System.out.println("son distintos");	
		}
	}

}
