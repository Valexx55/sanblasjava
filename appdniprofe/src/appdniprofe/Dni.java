package appdniprofe;

public class Dni {
	
	//TODO EJERCICIO HALLOWEEN
	//Implementar / programar
	//dentro de la clase de dni
	//un método/ una función
	//calcule la letra de un dni
	
	//así, desde el main, un programador
	//puede decir: "calcúlame la letra de ESTE dni"
	
	//PENSAD: Nombre, Entradas, Salidas
	//DIFICIL utilizad bien el this
	
	//ATRIBUTOS DE LA CLASE
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
	
	

}
