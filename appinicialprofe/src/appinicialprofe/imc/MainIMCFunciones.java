package appinicialprofe.imc;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * PROGRAMA IMC Índice de Masa Corporal
 * 
 * Fórmula IMC = peso kg / altura al cuadrado
 * 
 * IMC < 16 DESNUTRIDO IMC >=16 Y < 18 DELGADO IMC >=18 Y < 25 IDEAL IMC >=25 Y
 * < 31 SOBREPESO IMC >= 31 OBESO
 * 
 * TODO: HACED UNA APP QUE PIDA AL USUARIO SU PESO Y SU ESTATURA Y LE INFORME DE
 * SU IMC NUMÉRICO Y NOMIMAL
 * 
 * PEJ: 22.35 IDEAL
 */
public class MainIMCFunciones {
	
	/**
	 * Pedimos el peso al usuario
	 * por la entrada estándar (teclado)
	 * 
	 * @return el peso introducido
	 */
	public static float pedirPeso() {
		float peso = 0;
		Scanner scanner = null;

		scanner = new Scanner(System.in);
		System.out.println("Intro peso (Kg)");
		peso = scanner.nextFloat();

		return peso;
	}
	/**
	 * Pedimos el altura al usuario
	 * por la entrada estándar (teclado)
	 * 
	 * @return la altura introducido
	 */
	public static float pedirAltura() {
		float altura = 0;
		Scanner scanner = null;

		scanner = new Scanner(System.in);
		System.out.println("Intro altura (m)");
		altura = scanner.nextFloat();

		return altura;

	}
     
	/**
	 * 
	 * Función para caluclar el IMC de una perona
	 * conocido su peso y su altura
	 * 
	 * @param peso el peso en kg
	 * @param altura la altura en m
	 * @return el imc en formato decimal
	 */
	public static double calcularImcNumerico(float peso, float altura) {
		double imcnum = 0;


		imcnum = peso / Math.pow(altura, 2);

		return imcnum;
		

	}
	
	/**
	 * Calcula el imcNominal teniendo en cuenta
	 * el imcNumerico que ha devuelto calcularImcNumerico
	 * 
	 * @param imcNumerico
	 * @return imcNominal
	 */
	public static String calcularIMCNominal(double imcnum) {
		String imcNominal = null;

			if (imcnum < 16) {
				imcNominal = "DESNUTRIDO";
			} else if (imcnum >= 16 && imcnum < 18) {
				imcNominal = "DELGADO";
			} else if (imcnum >= 18 && imcnum < 25) {
				imcNominal = "IDEAL";
			} else if (imcnum >= 25 && imcnum < 31) {
				imcNominal = "SOBREPRESO";
			} else if (imcnum > 31) {
				imcNominal = "OBESO";
			}

		return imcNominal;
	}
	
	/**
	 * Imprime la frase acorde al imcNumerico e imcNominal
	 * 
	 * @param imcNumerico
	 * @param imcNominal
	 */
	
	public static void informarIMC (String imcNominal, double imcNumerico)
	{
		
		DecimalFormat df = new DecimalFormat("#.00");
		
		
		System.out.println("SU IMC ES " + df.format(imcNumerico) + " - " + imcNominal);
		
		
	}
	

	public static void main(String[] args) {

		float pesoUsuario = pedirPeso();
		float alturaUsuario = pedirAltura();
		double imcNumerico = calcularImcNumerico(pesoUsuario, alturaUsuario);
		String imcNominal =	 calcularIMCNominal(imcNumerico);
		informarIMC(imcNominal, imcNumerico);
		//TODO redondear el resultado
		

	}

}
