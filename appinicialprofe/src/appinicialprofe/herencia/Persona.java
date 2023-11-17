package appinicialprofe.herencia;

public class Persona {
	
	
	private String nombre;
	private int telefono;
	private String email;

	public Persona() {
		super();
	}

	public Persona(String nombre, int telefono, String email) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void mostrarPersona ()
	{
		System.out.println("NOMBRE = " + this.nombre);
		System.out.println("TELÉFONO = " + this.telefono);
		System.out.println("EMAIL = " + this.email);
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean soniguales = false;
		
		if (obj!=null)
		{
			if (obj instanceof Persona)
			{
				
				Persona p = (Persona)obj;//hacemos el casting
				//2 personas son iguales si
				//tienes mismo nombre, mismo email y mismo teléfono
				if (this.nombre.equals(p.nombre) &&
					this.email.equals(p.email)	&&
					this.telefono==p.telefono
					)
				{
					soniguales = true;
				}
			
			}
			
		}
		
		return soniguales;
	}

}

