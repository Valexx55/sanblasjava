package appinicialprofe.herencia;

public class Estudiante extends Persona {
	
	private int numero;
	private int promedio;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getPromedio() {
		return promedio;
	}

	public void setPromedio(int promedio) {
		this.promedio = promedio;
	}

	public Estudiante(int numero, int promedio) {
		super();
		this.numero = numero;
		this.promedio = promedio;
	}

	public Estudiante() {
		super();
	}
	
	
	@Override //"redefinir un método en la clase HIJA
	public void mostrarPersona() {
			System.out.println("NOMBRE = " + this.getNombre());
			System.out.println("TELÉFONO = " + this.getTelefono());
			System.out.println("EMAIL = " + this.getEmail());
			System.out.println("NÚMERO ESTUDIANTE = " + this.numero);
			System.out.println("NOTA MEDIA = " + this.promedio);
			
	
	}
	
	
	@Override
	public boolean equals(Object obj) {
		boolean iguales = false;
		
		if (obj!=null)
		{
			if (obj instanceof Estudiante)//(obj instanceof Estudiante e)//https://docs.oracle.com/en/java/javase/20/language/pattern-matching-switch-expressions-and-statements.html#GUID-E69EEA63-E204-41B4-AA7F-D58B26A3B232
			{
				
				Estudiante e = (Estudiante)obj;//hacemos el casting
				//2 estudiantes son iguales si
				//tienes mismo nombre, mismo email y mismo teléfono
				if (this.getNombre().equals(e.getNombre()) &&
					this.getEmail().equals(e.getEmail())	&&
					this.getTelefono()==e.getTelefono() &&
					this.getNumero()==e.getNumero() &&
					this.getPromedio()==e.getPromedio() 
					)
				{
					iguales = true;
				}
			
			}
			
		}
		
		return iguales;
	}

	@Override
	public String toString() {
		return "Estudiante [numero=" +this.numero + ", promedio=" + this.promedio + ", getNombre()=" + this.getNombre()
				+ ", getTelefono()=" + this.getTelefono() + ", getEmail()=" + this.getEmail() + "]";
	}
	
	
	
	
	
	
	
	

}