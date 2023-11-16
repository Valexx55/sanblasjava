package apppreguntascert;

public class MaintablaString {

	static String[][] table;

	//¿cómo hacemos para imprimir "Sun5c"
	public static void main(String[] args) {
        String[] x = { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun" };
        String[] y1 = { "1", "2", "3", "4", "5" };
        String[] y2 = { "a", "b", "c" };
        
        table = new String[3][];
        table[0] = x;
        table[1] = y1;
        table[2] = y2;

       //opción buena Imprime Sun5c!!! 
        for(var row : table){
        	System.out.print(row[row.length-1]); 
        }
        
        //OPCION MALA PQ NO LLEGA AL ÚLTIMO 
        //ARRRAY SÓLO IMPRIME Sun5
        for(int i=0; i<table.length-1; i++){
        	int j = table[i].length-1; 
        	System.out.print(table[i][j]); 
        }

    }

}
