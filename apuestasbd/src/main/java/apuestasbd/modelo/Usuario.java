package apuestasbd.modelo;

public class Usuario {
	
	private int id;
	private String nombre;
	private String email;
	private String password;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Usuario(int id, String nombre, String email, String password) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.password = password;
	}
	
	public Usuario() {
		super();
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", email=" + email + ", password=" + password + "]";
	}
	
	
	
}
