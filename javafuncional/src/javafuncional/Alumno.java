package javafuncional;

public class Alumno {
	
	private int nota;
	private String nombre;
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Alumno(int nota, String nombre) {
		super();
		this.nota = nota;
		this.nombre = nombre;
	}
	public Alumno() {
		super();
	}
	@Override
	public String toString() {
		return "Alumno [nota=" + nota + ", nombre=" + nombre + "]";
	}
	
	

}
