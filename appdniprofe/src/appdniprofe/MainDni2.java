package appdniprofe;

import java.util.Random;

//TODO HACER UN NUEVO MAINDNI LLAMADO MAINDNI2
		/**
		 * PARA QUE GENERE 10 DNIS NUEVOS
		 * CADA NÚMERO DEL DNI SE TIENE QUE GENERAR
		 * AUTOMÁTICAMENTE /ALEATORIA
		 * Y PARA CADA DNI, SE TIENE QUE CALCULAR SU LETRA
		 * 
		 * EN LA CLASE DNI, SE TIENE QUE LLEVAR LA CUENTA
		 * DE CUÁNTOS DNIS SE CREAN Y MOSTRARLO AL FINAL
		 * DE LA EJECUCIÓN
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
public class MainDni2 {
	
	public static final int MAX_NUMERO_DNI = 99999999; 
	
	public static void main(String[] args) {
		
		//FOR 10 veces
			//1 generar numero
			//2 crear dni
			//3 sacar letra de ese dni
		for (int i = 0; i <= 9; i++) {
			Random random = new Random();
			int numDni = random.nextInt(MAX_NUMERO_DNI) + 1;
			Dni dni = new Dni(numDni);
			
			char letraDNI = dni.calcularLetra();
			dni.setLetra(letraDNI);
			
			System.out.println("Tu numero: " + dni.getNumero() + " - " + dni.getLetra());
		}
		//TODO imprimir el número total de DNIS creados
		System.out.println("SE HAN  CREADO " + Dni.contador + " dnis");
	}

}
