package appinicialprofe.array;

import java.util.Random;

public class MainArrayTabla {

	/**
	 * 1) Haced un método que reciba un array de números 2 dimensiones y devuelva la
	 * suma de todas las posiciones
	 * 
	 */

	public static int sumarPosicionesArray(int[][] tabla) {
		int suma = 0;

		for (int fila = 0; fila < tabla.length; fila++) {

			// System.out.println( tabla[fila][2];);
			for (int columna = 0; columna < tabla[fila].length; columna++) {
				// System.out.println(tabla[fila][columna]);
				suma = suma + tabla[fila][columna];
			}
		}

		return suma;
	}

	/**
	 * 2) Haced un método que reciba un array de números y lo muestre de la
	 * siguiente manera:
	 * 
	 * Pe ej, siendo el array de 3 x 3
	 * 
	 * 1 2 3 4 5 6 7 8 9
	 * 
	 * PISTA: si hago sysout print no me mete salto de línea si hago sysout println
	 * sí me mete un salto de línea
	 * 
	 */

	public static void mostrarTabla(int[][] tabla) {

		String strnum = null;
		int longitud = 0;

		for (int fila = 0; fila < tabla.length; fila++) {

			for (int columna = 0; columna < tabla[fila].length; columna++) {
				// LOS NÚMEROS TIENEN Q OCUPAR 3 POSICIONES
				strnum = String.valueOf(tabla[fila][columna]);
				longitud = strnum.length();
				while (longitud < 3) {
					strnum = strnum + " ";
					longitud = strnum.length();
				}
				System.out.print(strnum + " ");
			}
			System.out.println();
		}

	}

	/**
	 * 3) Haced un método que reciba las dimensiones de un array (número de filas y
	 * columnas) y devuelva un array relleno de números aletorios entre 1 y 100
	 * 
	 */

	private static int generarNumeroAleatorio() {
		int numAleatorio = 0;
		Random random = null;

		random = new Random();
		numAleatorio = 1 + random.nextInt(100);

		return numAleatorio;
	}

	public static int[][] crearTablaAleatoria(int numfilas, int numcolumnas) {
		int[][] arrayNuevo = new int[numfilas][numcolumnas];

		for (int fila = 0; fila < arrayNuevo.length; fila++) {

			for (int columna = 0; columna < arrayNuevo[fila].length; columna++) {
				arrayNuevo[fila][columna] = generarNumeroAleatorio();

			}

		}

		return arrayNuevo;
	}

	private static String formatearPosicionMatriz(int n) {
		String strnum = null;
		int longitud = 0;
	
			strnum = String.valueOf(n);
			longitud = strnum.length();
			while (longitud < 3) {
				strnum = strnum + " ";
				longitud = strnum.length();
			}

		return strnum;

	}

	/**
	 * 
	 * 4) Haced un método que reciba un array de números y 
	 * lo muestre como en el punto 2, pero además, 
	 * incluya la suma de las filas
	 */
	
	public static void mostrarArraySumaPorFilas (int [][] arrayNumeros)
	{
	
		 String strnum = null;
		 int longitud = 0;
		 int sumatorioFila = 0;
		 	
			for (int fila = 0; fila < arrayNumeros.length; fila++) {

				for (int columna = 0; columna < arrayNumeros[fila].length; columna++) {
					//LOS NÚMEROS TIENEN Q OCUPAR 3 POSICIONES
					sumatorioFila = sumatorioFila + arrayNumeros[fila][columna];
					strnum = formatearPosicionMatriz (arrayNumeros[fila][columna]);
					System.out.print(strnum + " ");
				}
				System.out.print("--> " + sumatorioFila);
				sumatorioFila = 0;
				System.out.println();
			}
				
	}
	
	
	public static void mostrarArraySumaPorFilasYColumnas (int [][] arrayNumeros)
	{
	
		 String strnum = null;
		 int longitud = 0;
		 int sumatorioFila = 0;
		 int[] sumatorioColumas = new int [arrayNumeros[0].length];
		 	
			for (int fila = 0; fila < arrayNumeros.length; fila++) {

				for (int columna = 0; columna < arrayNumeros[fila].length; columna++) {
					//LOS NÚMEROS TIENEN Q OCUPAR 3 POSICIONES
					sumatorioFila = sumatorioFila + arrayNumeros[fila][columna];
					strnum = formatearPosicionMatriz (arrayNumeros[fila][columna]);
					System.out.print(strnum + " ");
					sumatorioColumas[columna]=sumatorioColumas[columna]+arrayNumeros[fila][columna];
				}
				System.out.print("--> " + sumatorioFila);
				sumatorioFila = 0;
				System.out.println();
			}
			//TODO mostrar sumatorio
			for (int i = 0; i < sumatorioColumas.length; i++) {
				strnum = formatearPosicionMatriz(sumatorioColumas[i]);
				System.out.print(strnum + " ");
			}
				
	}


	public static void main(String[] args) {

		// int[][] arrayNum = new int [3][3];
		// rellenar la columna 1 con todo unos

		int[][] arrayNum = { { 0, 1, 2 }, { 2, 3, 1 }, { 5, 5, 5 } };
		int resultado = sumarPosicionesArray(arrayNum);
		System.out.println(resultado);
		mostrarTabla(arrayNum);
		int[][] arrayNuevo = crearTablaAleatoria(10, 7);
		mostrarTabla(arrayNuevo);
		System.out.println();
		System.out.println();
		mostrarArraySumaPorFilas(arrayNuevo);
		System.out.println();
		System.out.println();
		mostrarArraySumaPorFilasYColumnas(arrayNuevo);
		

		for (int fila = 0; fila < arrayNum.length; fila++) {

			for (int columna = 0; columna < arrayNum[fila].length; columna++) {
				if (fila == columna) {
					arrayNum[fila][columna] = 1;
				} else {
					arrayNum[fila][columna] = 0;
				}

			}
		}
		System.out.println("FIN");

	}

}
