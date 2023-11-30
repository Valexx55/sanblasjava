package appinicialprofe.ficheros;

import java.io.File;
import java.io.IOException;

public class MainFichero {

	public static void main(String[] args) {

		// https://codeshare.io/qPJBqM
		// TODO HACED UN PROGRAMA QUE RECIBE POR PARÁMETROS
		// 1 STRING --args[0]
		// ESE STRING, ES EL NOMBRE DE UN FICHERO
		// SI EL FICHERO EXISTE, QUE ME DIGA SI ES FICHERO
		// O DIRECTORIO
		// Y SI NO EXISTE, QUE ME LO CREE

		if (args.length > 0) {
			String nombreFichero = args[0];
			File fichero = new File(nombreFichero);
			if (fichero.exists()) {
				if (fichero.isFile()) {
					System.out.println("El fichero existe y es un archivo");
				} else if (fichero.isDirectory()) {
					System.out.println("El fichero existe y es un directorio");
				}
				
				
				boolean borrado = fichero.delete();
				
				if (borrado) {
					
					System.out.println("fichero borrado");
					
				}else {
					
					System.out.println("no se ha borrado");
				}
				
			} else {
				// no existe
				try {
					boolean creado = fichero.createNewFile();
					if (creado) {
						System.out.println("Fichero creado " + nombreFichero);
					} else {
						System.out.println("Fichero no se ha podido crear ");
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.err.println("ERROR CREANDO FICHERO");
					e.printStackTrace();
					
				}
			}

		} else {
			System.out.println("No he recibido ningún parámetro");
		}

		
		
	}

}
