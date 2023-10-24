package appinicialprofe.imc;

import java.util.Scanner;

/**
 * PROGRAMA IMC Índice de Masa Corporal
 * 
 * Fórmula IMC = peso kg / altura al cuadrado
 * 
 * IMC < 16 DESNUTRIDO
 * IMC >=16 Y < 18 DELGADO
 * IMC >=18 Y < 25 IDEAL
 * IMC >=25 Y < 31 SOBREPESO
 * IMC >= 31 OBESO
 * 
 * TODO: HACED UNA APP QUE PIDA AL USUARIO
 * SU PESO Y SU ESTATURA Y LE INFORME DE SU IMC
 * NUMÉRICO Y NOMIMAL
 * 
 * PEJ: 22.35 IDEAL
 */
public class MainIMC {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//1 PEDIR PESO
		System.out.println("Intro peso (Kg)");
		float peso = scanner.nextFloat();
		//2 PEDIR ALTURA
		System.out.println("Intro altura (m)");
		float altura = scanner.nextFloat();
		//3 CALCULAR EL IMC
		
		
			//3.1 CALCULAR EL IMC NUMÉRICO
		//float imcNumerico = peso/(altura*altura);
		double imcNumerico =  peso / Math.pow(altura, 2);
		String imcNominal = null;
			//3.2 CALCULAR EL IMC NOMINAL
		if (imcNumerico<16)
		{
			imcNominal ="DESNUTRIDO";
		} else if (imcNumerico>=16 &&  imcNumerico<18){
			imcNominal = "DELGADO";
		} else if (imcNumerico>=18 &&  imcNumerico<25){
			imcNominal = "IDEAL";
		}else if (imcNumerico>=25 &&  imcNumerico<31){
			imcNominal = "SOBREPRESO";
		}else if (imcNumerico>31){
			imcNominal = "OBESO";
		}
		
		
		//4 INFORMAR AL USUARIO
		System.out.println("SU IMC ES "+ imcNumerico + " " + imcNominal);
	}

}




