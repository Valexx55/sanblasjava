package appdniprofe;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MainMapas {
	
	public static void main(String[] args) {
		//Map<String, Dni> mapaPersonaDni = new HashMap<String, Dni>();
		Map<String, Dni> mapaPersonaDni = new TreeMap<String, Dni>();
		
		mapaPersonaDni.put("Laura", new Dni(53954510, 'Y'));
		mapaPersonaDni.put("Vale", new Dni(53130984, 'H'));
		mapaPersonaDni.put("Vale", new Dni(53130985, 'L'));
		mapaPersonaDni.put("Vini", new Dni(50500231, 'M'));
		mapaPersonaDni.put("Alba", new Dni(5945376, 'Z'));
		
		Dni dniVale =  mapaPersonaDni.get("Vale");
		System.out.println(dniVale);
		
		if (mapaPersonaDni.get("Defeng")==null)
		{
			System.out.println("El DNI de DEFENG no está fichado");
		}
		
		System.out.println("Tamaño Mapa = " +mapaPersonaDni.size()); 
		
		Set<String> claves =  mapaPersonaDni.keySet();
		System.out.println("Claves =  " + claves.size());
		
		for (String clave : claves)
		{
			System.out.println(clave);
			Dni dni = mapaPersonaDni.get(clave);
			System.out.println(dni);
		}
		
		
		
		
		
		
	}
}
