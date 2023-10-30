package appinicialprofe.basico;

public class MainStaticVsDinamic {
	
	public static void main(String[] args) {
		
		String numerocadena = "250";
		//int numero = 250;
		
		//TODO CONVERTIR STRING A NÚMERO
		int numero = Integer.parseInt(numerocadena);
		float numero_real = Float.parseFloat("20.56");
		
		System.out.println(numero);
		System.out.println(numero_real);
	}

}
