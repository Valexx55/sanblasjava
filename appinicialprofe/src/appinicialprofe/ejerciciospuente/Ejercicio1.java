package appinicialprofe.ejerciciospuente;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * 1 INTERSECCIÓN

TENEMOS DOS FICHEROS DE TEXTO (nombres1.txt)
y (nombres2.txt)
EN CADA FICHEROS, POR CADA LÍNEA HAY
UN NOMBRE DE PERSONA

HACED UNA APP QUE PROCESE LOS DOS FICHEROS DE TEXTO
E IMPIRMA POR PANTALLA SÓLO LOS NOMBRES EN COMÚN EN 
AMBOS FICHEROS

SI NO HAY NINGUNA COINCIDENCIA, QUE TAMBIÉN ME LO DIGA
EL PROPIO PROGRAMA
 */


public class Ejercicio1 {

	
	public static void main(String[] args) throws IOException {
		
		Path rutaF1 = Path.of("nombres1.txt");
		List<String> lnombresF1 = Files.readAllLines(rutaF1);
		
		Path rutaF2 = Path.of("nombres2.txt");
		List<String> lnombresF2 = Files.readAllLines(rutaF2);
		
		boolean coincide = false;
		
		for (String nombre : lnombresF1)
		{
			if (lnombresF2.contains(nombre))
			{
				coincide = true;
				System.out.println(nombre);
			}
		}
		
		if (!coincide)
		{
			System.out.println("No hay ninguna coicidencia en los ficheros");
		}
		
	
	}
}
