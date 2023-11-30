package appinicialprofe.ficheros;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MainFicheros {
	
	public static void main(String[] args) {
		
		try {
			List<String> listaEquipos = Files.readAllLines(Path.of("equipos.txt"));
			listaEquipos.forEach(System.out::println); 
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
