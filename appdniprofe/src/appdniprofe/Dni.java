package appdniprofe;

public class Dni {
	
	public static final String SECUENCIA_LETRAS_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";
	
	///ATRIBUTOS DE LA CLASE
	private int numero;
	private char letra;
	
	//CONSTRUCTOR 1
	public Dni(int numero, char letra) {
		super();
		this.numero = numero;
		this.letra = letra;
	}
	//CONSTRUCTOR 2
	public Dni(int numero) {
		super();
		this.numero = numero;
	}

	//CONSTRUCTOR POR DEFECTO
	public Dni() {
		super();
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public char getLetra() {
		return this.letra;
	}

	public void setLetra(char letra) {
		this.letra = letra;
	}
	
	public char calcularLetra()
	{
		char letraCalculada= ' ';//20
		int resto = 0;
		    
			resto = this.numero%23;
			letraCalculada = SECUENCIA_LETRAS_DNI.charAt(resto);
			
		return letraCalculada;
	}

}
