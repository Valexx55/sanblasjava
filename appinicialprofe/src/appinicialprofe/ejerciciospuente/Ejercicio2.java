package appinicialprofe.ejerciciospuente;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 
 * 2 ORDEN

HAY UN FICHERO DE TEXTO CON NOMBRES DE INGRENDIENTES
(UNO POR LÍNEA)llamado ingredientes.txt

HACED UN PRORGAMA QUE PROCESE EL FICHERO ANTERIOR
Y DIGA SI LOS INGREDIENTES ESTÁN EN ORDEN ALFABÉTICO
O NO
 */

public class Ejercicio2 {
	
	public static void main(String[] args) throws IOException {
		//1 leer fichero
		
		Path rutaFicheroIngredientes = Path.of("ingredientes.txt");
		List<String> listaOrdenada = Files.readAllLines(rutaFicheroIngredientes);
		List<String> listaOriginal = new ArrayList<String>(listaOrdenada);
		Collections.sort(listaOrdenada);
		//funciona porque usar el equals de string para comparar 
		//cada elemento de la lista
		if (listaOrdenada.equals(listaOriginal))
		{
			System.out.println("La lista de ingredientes está ordenada equals" );
		}
		else {
			System.out.println("La lista de ingredientes NO está ordenada equals");
		}
		
		//si mismacht da -1, es que son iguales
		int primeraPosicionDistinta = Arrays.mismatch(listaOrdenada.toArray(), listaOriginal.toArray());
		if (primeraPosicionDistinta==-1)
		{
			System.out.println("La lista de ingredientes está ordenada mismatch");
		}
		else {
			System.out.println("La lista de ingredientes NO está ordenada  mismatch");
			System.out.println("poscion fallo = " +primeraPosicionDistinta);
		}
	}
	
}
