package appdniprofe;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MainNie {

	public static void main(String[] args) {
		// TODO pedir un dni extranjero
		// número y letra de (prefijo)
		// y calcularle su letra

		// Z0120994 -- L

		// https://www.interior.gob.es/opencms/es/servicios-al-ciudadano/tramites-y-gestiones/dni/calculo-del-digito-de-control-del-nif-nie/

//		calcularLetraForma1();
		calcularLetraForma2();//controlamos los ceros!
	}
	
	public static void calcularLetraForma2 ()
	{
		int dniwil = 120994;
		char letraPrefijo = 'Z';
		
			DecimalFormat df = new DecimalFormat("0000000");
			String dniwilcad = df.format(dniwil);
			System.out.println(dniwilcad);
			
			if (letraPrefijo=='Z')
			{
				dniwilcad = "2"+dniwilcad;
			} else if (letraPrefijo=='Y')
			{
				dniwilcad = "1"+dniwilcad;
			}/*else {
				// sería poner un cero a la izquieda, que no tiene
				 * ningún efecto
			}*/
			int numero = Integer.parseInt(dniwilcad);
			int resto = numero%23;
			char letraFinal = Dni.SECUENCIA_LETRAS_DNI.charAt(resto);
			System.out.println("La letra final es " + letraFinal);
			
			
	}
	
	
	public static void calcularLetraForma1 ()
	{
		Scanner scanner = new Scanner(System.in);// pàra leer de teclado

		// PEIDO NÚMERO
		System.out.println("INTRO DNI");
		String caddni = scanner.next();

		// PIDO LETRA

		System.out.println("INTRO LETRA");
		String letra = scanner.next();
		String letraMayuscula = letra.toUpperCase();

	

		switch (letraMayuscula) {
		case "X":
			System.out.println("El usuario introdujo X case");
			caddni = "0"+caddni;
			break;
		case "Y":
			System.out.println("El usuario introdujo Y case");
			caddni = "1"+caddni;
			break;
		case "Z":
			System.out.println("El usuario introdujo Z case");
			caddni = "2"+caddni;
			break;

		default:
			break;
		}
		
		//caddni el número compuesto preparado
		
		int numDniPreparado = Integer.parseInt(caddni);
		int resto = numDniPreparado%23;
		char letraFinal = Dni.SECUENCIA_LETRAS_DNI.charAt(resto);
		System.out.println("Su letra final es "+ letraFinal);
	}

}
