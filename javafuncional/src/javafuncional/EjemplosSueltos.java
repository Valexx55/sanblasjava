package javafuncional;

import java.util.stream.Stream;

public class EjemplosSueltos {
	
	public static void main(String[] args) {
		
		Stream<String> nombres = Stream.of("Maria", "Ana", "David", "Belén");
		//TODO haced que nos diga si algun nombre acaba en d
		boolean tieneD = nombres.anyMatch((String cadena) ->
		{
			boolean acabaend = false;
			
			//si la ultima letra de cadena es d, true
			char ultimaLetra = cadena.charAt(cadena.length()-1);
			if (ultimaLetra == 'd')
			{
				acabaend=true;
			}
			
			return acabaend;
		} );
		
		 tieneD = nombres.anyMatch(cadena -> cadena.endsWith("d"));
		
		System.out.println(tieneD);
		
	}

}
