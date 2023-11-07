package appdniprofe;

public class Nie extends Dni {
	
	private char prefijo;//X/Y/Z
	
	public Nie() {
	// TODO Auto-generated constructor stub
	}
	

	public Nie(int numero, char letra, char prefijo) {
		super(numero, letra);//llama al constructor de Dni Clase Padre
		this.prefijo = prefijo;
	}


	public Nie(int numero, char letra) {
		super(numero, letra);
	}


	public char getPrefijo() {
		return prefijo;
	}

	public void setPrefijo(char prefijo) {
		this.prefijo = prefijo;
	}
	
	
	

}
