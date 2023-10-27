package appinicialprofe.basico;

/**
 * Esta clase es para jugar con la clase String
 */
public class MainCadenas {
	
	public static void main(String[] args) {
		//String saludo = "HOLA";
		String saludo = new String("HOLA");
		System.out.println(saludo);
		char primeraletra = saludo.charAt(0);
		System.out.println(primeraletra);
		int longitud = saludo.length();
		System.out.println("La longitud de la palabra es " + longitud);
		//RECORRO LA CADENA
		char letraActual = ' ';
		for (int indice = 0;indice<longitud;indice++) {
			//obtengo la letra en curso
			letraActual = saludo.charAt(indice);
			System.out.println("La letra en la posición " 
			+indice+ " es "+ letraActual);
		}
		
	}

}
