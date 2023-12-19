package javafuncional;

public class Comerciante {
	
	private String licencia;
	private String tipoComercio;
	private String nombreEncargado;
	public String getLicencia() {
		return licencia;
	}
	public void setLicencia(String licencia) {
		this.licencia = licencia;
	}
	public String getTipoComercio() {
		return tipoComercio;
	}
	public void setTipoComercio(String tipoComercio) {
		this.tipoComercio = tipoComercio;
	}
	public String getNombreEncargado() {
		return nombreEncargado;
	}
	public void setNombreEncargado(String nombreEncargado) {
		this.nombreEncargado = nombreEncargado;
	}
	public Comerciante(String licencia, String tipoComercio, String nombreEncargado) {
		super();
		this.licencia = licencia;
		this.tipoComercio = tipoComercio;
		this.nombreEncargado = nombreEncargado;
	}
	
	public Comerciante() {
		// TODO Auto-generated constructor stub
	}
	

}
