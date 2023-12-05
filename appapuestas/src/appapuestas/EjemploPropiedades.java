package appapuestas;


import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class EjemploPropiedades 
{
	public static void main(String[] pepi) throws Throwable 
	{
		
		
		Properties fichero_propiedaes = null;
		
		fichero_propiedaes = new Properties();
		
		FileReader fr = new FileReader("cuento.properties", StandardCharsets.UTF_8);
				
		fichero_propiedaes.load(fr);
		
		String vd = fichero_propiedaes.getProperty("start");
		
		System.out.println(vd);
		
		fr.close();
		
		
		
		
		
	}

}