package appinicialprofe.fortaleza;

@FunctionalInterface
public interface Fortaleza {
	
	/**
	 * Función que calcula la fortaleza de una contraseña
	 *  
	 * @param password la contraseña del usuario
	 * @return "DÉBIL" "MEDIA" O "FUERTE" según el criterio
	 * del enunciado
	 */
	
	String tipoPassword (String password);
	

}
