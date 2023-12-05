package appapuestas;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class EjemploPropiedades {

	// MODIFICAD LA APLICACIÓN PARA QUE FUNCIONE ASÍ:

	/**
	 * 
	 * SE RECIBE COMO ARGUMENTO el idioma deseado (it, en o es)
	 * 
	 * y EL PROGRAMA DEBE IMPRIMIR EL CUENTO EN ORDEN (start, body, end) EN EL
	 * IDIOMA ELEGIDO
	 * 
	 */
	public static void main(String[] args) throws Throwable {
		String nombreFichero = null;
		// args[0] aquí vendrá el idioma elegido por el usario
		System.out.println("Idioma elegido = " + args[0]);
		switch (args[0]) {
		case "it":
			nombreFichero = "cuento_it.properties";
			break;
		case "es":
			nombreFichero = "cuento.properties";
			break;
		case "en":
			nombreFichero = "cuento_en.properties";
			break;

		default:
			//si mete un idioma no previsto, usamos el español
			nombreFichero = "cuento.properties";
		}

		Properties fichero_propiedaes = null;

		fichero_propiedaes = new Properties();

		FileReader fr = new FileReader(nombreFichero, StandardCharsets.UTF_8);

		fichero_propiedaes.load(fr);

		String inicio = fichero_propiedaes.getProperty("start");
		String cuerpo = fichero_propiedaes.getProperty("body");
		String fin = fichero_propiedaes.getProperty("end");

		System.out.println(inicio);
		System.out.println(cuerpo);
		System.out.println(fin);

		fr.close();

	}

}