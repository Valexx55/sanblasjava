package appapuestas.bean;

public class Apuesta {
	
	//ATRIBUTOS A NIVEL DE CLASE
	public static String equipoLocal;
	public static String equipoVisitante;
	
	
	
	//ATRIBUTOS A NIVEL DE OBJETO
	private String nombre;
	//Resultado
	private int golesLocal;
	private int golesVisitante;
	private float valorApuesta;
	
	//SECCIÓN QUE SIRVE PARA INICIALIZAR
	//ATRIBUTOS DE LA CLASE
	static {
		//sección de código que se ejecuta al inicio
		//automáticamente, cuando Java lee 
		//el nombre de la clase por primera vez
		// en el código
		
		Apuesta.equipoLocal = "RAYO VALLECANO";
		Apuesta.equipoVisitante = "GIRONA";
		
		System.out.println("En la sección static de Apuesta");
		
	}
	
	
	
	public static String getEquipoLocal() {
		return equipoLocal;
	}
	
	public static void setEquipoLocal(String equipoLocal) {
		Apuesta.equipoLocal = equipoLocal;
	}
	
	public static String getEquipoVisitante() {
		return equipoVisitante;
	}
	
	public static void setEquipoVisitante(String equipoVisitante) {
		Apuesta.equipoVisitante = equipoVisitante;
	}
	
	
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getGolesLocal() {
		return golesLocal;
	}
	
	public void setGolesLocal(int golesLocal) {
		this.golesLocal = golesLocal;
	}
	
	public int getGolesVisitante() {
		return golesVisitante;
	}
	
	public void setGolesVisitante(int golesVisitante) {
		this.golesVisitante = golesVisitante;
	}

	public float getValorApuesta() {
		return valorApuesta;
	}

	public void setValorApuesta(float valorApuesta) {
		this.valorApuesta = valorApuesta;
	}

	public Apuesta(String nombre, int golesLocal, int golesVisitante) {
		super();
		this.nombre = nombre;
		this.golesLocal = golesLocal;
		this.golesVisitante = golesVisitante;
	}
	
	public Apuesta() {
		// TODO Auto-generated constructor stub
	}
    
	public Apuesta(String nombre, int golesLocal, int golesVisitante, float valorApuesta) {
		super();
		this.nombre = nombre;
		this.golesLocal = golesLocal;
		this.golesVisitante = golesVisitante;
		this.valorApuesta = valorApuesta;
	}

	@Override
	public String toString() {
		return "Apuesta [nombre=" + this.nombre + ", golesLocal=" + this.golesLocal + ", golesVisitante=" + this.golesVisitante + ", valorApuesta = " + this.valorApuesta + " ]";
	}
	
	public void mostrarApuesta ()
	{
		//Alison 1-0
		System.out.println(this.nombre + " " + this.golesLocal+"-"+this.golesVisitante +" " +this.valorApuesta);
	}
	
	
	
	
	
	
	

}
