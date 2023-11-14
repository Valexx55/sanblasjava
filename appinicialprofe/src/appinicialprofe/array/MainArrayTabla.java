package appinicialprofe.array;

public class MainArrayTabla {
	
	public static void main(String[] args) {
		
		int[][] arrayNum = new int [3][3];
		//rellenar la columna 1 con todo unos
		
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
