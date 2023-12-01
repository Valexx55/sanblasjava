package apuestasbd;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Prueba {
	
	//VAMOS A TRABAJAR CON Files
		public static void main(String[] args) {
			
			//vamos al leer el fichero de equipos
			
			try {
				
				//Path es como File pero "moderno"
				Path pathEquipos = Path.of("src/main/resources/equipos.txt");
				List<String> lequipos = Files.readAllLines(pathEquipos);
				System.out.println(lequipos);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}


}
