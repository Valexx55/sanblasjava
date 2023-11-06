package appdniprofe;

import java.util.Scanner;

public class MainDni {
	
	//Algoritmo https://www.interior.gob.es/opencms/es/servicios-al-ciudadano/tramites-y-gestiones/dni/calculo-del-digito-de-control-del-nif-nie/
	
  public static final String SECUENCIA_LETRAS_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";
	
	public static void main(String[] args) {
		//SECUENCIA_LETRAS_DNI = "";
		//TODO pedir el número del dni
		//y decirle qué letra tiene
		//pedir número del dni
		System.out.println("Introduce tu numero de dni");
		Scanner scanner = new Scanner(System.in);
		int numdni = scanner.nextInt();
		System.out.println("DNI INTRO = " + numdni);
		int resto = numdni%SECUENCIA_LETRAS_DNI.length();
		System.out.println(resto);
		char letra = SECUENCIA_LETRAS_DNI.charAt(resto);
		System.out.println("Su letra es " + letra);
		
		
		Dni dnivale = new Dni(53130984, 'H');
		Dni dniandrei = new Dni(3003042, 'R');
		
		//vamos a obtener la letra de Andrei
		char letraAndrei = dniandrei.getLetra();
		//vamos a obtener la letra de Andrei
		char letraVale = dnivale.getLetra();
		
		
		System.out.println("La letra de Andrei es "+ letraAndrei);
		System.out.println("La letra de Vale es "+ letraVale);
		
		String saludoes = "HOLA";
		String comida = "LASAÑA";
		
		int logitudcomida = comida.length();
		int logitudsaludo = saludoes.length();
		
		Dni dniVini = new Dni(50500231);
		char letraVini = dniVini.calcularLetra();
		
		System.out.println("La letra de Vini es " + letraVini);
		dniVini.setLetra(letraVini);
		
		//letraVini.
		
		
		if  (saludoes.equals(comida)) // (saludoes==comida)
		{
			
		}
		
		
		
		
		
		
		
	}	

	
	
	
}
