package appdniprofe;

public class Dni {
	
	public static final String SECUENCIA_LETRAS_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";
	
	///ATRIBUTOS DE LA CLASE
	private int numero;
	private char letra;
	
	public static int contador;//llevo la cuenta de cuántos DNIS se crean
	
	//CONSTRUCTOR 1
	public Dni(int numero, char letra) {
		super();
		this.numero = numero;
		this.letra = letra;
		contador++;
	}
	//CONSTRUCTOR 2
	public Dni(int numero) {
		super();
		this.numero = numero;
		contador++;
	}

	//CONSTRUCTOR POR DEFECTO
	public Dni() {
		super();
		contador++;
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
	
	//TODO hacer un método estático
	//que reciba un array de dnis
	//y devuelva el número del mayor
	
	public static int obtenerDniMayor(Dni[] arrayDnis)
	{
		int dnimayor = 0;
		
		for (int i = 0; i < arrayDnis.length; i++) {
			
			//si el numero actual del dni es mayor que mayor
				//mayor = numero actual del dni
			
			if(arrayDnis[i].numero > dnimayor) {
				dnimayor=arrayDnis[i].numero;
				
			}
		}
		
		return dnimayor;
	}
	
	
	
	
	public static int obtenerDniMayorForEach(Dni[] arrayDnis)
	{
		int dnimayor = 0;
		
		for (Dni dni : arrayDnis)
		{

			if(dni.numero > dnimayor) {
				dnimayor=dni.numero;
				
			}
		}
		/*for (int i = 0; i < arrayDnis.length; i++) {
			
			//si el numero actual del dni es mayor que mayor
				//mayor = numero actual del dni
			
			if(arrayDnis[i].numero > dnimayor) {
				dnimayor=arrayDnis[i].numero;
				
			}
		}*/
		
		return dnimayor;
	}
	@Override
	public String toString() {
		return "Dni [numero=" + numero + ", letra=" + letra + "]";
	}
	
	
	

}
