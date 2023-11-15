package appinicialprofe.array;

public class MainArrayTabla {
	
	
	/**
	 * 1) Haced un método que reciba un array de números 
	 * 2 dimensiones y devuelva la suma de todas
		las posiciones
	 * 
	 */
	
	public static int sumarPosicionesArray (int[][] tabla)
	{
		int suma =0;
		
			for (int fila = 0; fila < tabla.length; fila++) {
				
				//System.out.println( tabla[fila][2];);
				for (int columna = 0; columna < tabla[fila].length; columna++) {
					//System.out.println(tabla[fila][columna]);
					suma = suma + tabla[fila][columna];
				}
			}
		
		return suma;
	}
	
		
	public static void main(String[] args) {
		
		//int[][] arrayNum = new int [3][3];
		//rellenar la columna 1 con todo unos
		
		int[][] arrayNum = {{0, 1, 2},{2, 3, 1}, {5, 5, 5}};
		int resultado = sumarPosicionesArray(arrayNum);
		System.out.println(resultado);
		
		for (int fila = 0; fila < arrayNum.length; fila ++)
		{
			
			for (int columna = 0; columna < arrayNum[fila].length; columna++) {
				if (fila==columna)
				{
					arrayNum[fila][columna]=1;
				} else {
					arrayNum[fila][columna]=0;
				}
				
			}
		}
		System.out.println("FIN");
		
		
		
		
		
		
		
		
		
	}

}
