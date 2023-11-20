package appinicialprofe.fortaleza.enumerado;

public class ImplFortaleza implements Fortaleza {

	/**
	 * fuerte si tiene más de 7 caracteres e incluye mayúsuclas, minúsculas, números
	 * y al menos un caracter de control entre los siguientes
	 * 
	 * ! " # $ % & ' ( ) * + , - . /
	 * 
	 * media si tiene más de 7 caracteres e incluye mayúsuclas, minúsculas y números
	 * 
	 * débil si no es media ni fuerte
	 */

	private boolean tieneMayusculas(String password) {
		boolean mayus = false;
		int longitud = password.length();
		int pos = 0;
		char letraActual = ' ';
		int numLetra = 0;

		while (!mayus && (pos < longitud)) {
			letraActual = password.charAt(pos);
			numLetra = (int) letraActual;
			if ((numLetra >= 65) && (numLetra <= 90)) {
				mayus = true;
			} else
			{
				mayus = false;
				pos++;
			}
		}
		return mayus;
	}

	private boolean tieneMinusculas(String password) {
		boolean minus = false;
		int longitud = password.length();
		int pos = 0;
		char letraActual = ' ';
		int numLetra = 0;

		while (!minus && (pos < longitud)) {
			letraActual = password.charAt(pos);
			numLetra = (int) letraActual;
			if ((numLetra >= 97) && (numLetra <= 122)) {
				minus = true;
			} else
			{
				minus = false;
				pos++;
			}
		}

		return minus;
	}

	private boolean tieneNumeros(String password) {
		boolean numeros = false;
		int longitud = password.length();
		int pos = 0;
		char letraActual = ' ';
		int numLetra = 0;

		while (!numeros && (pos < longitud)) {
			letraActual = password.charAt(pos);
			numLetra = (int) letraActual;
			if ((numLetra >= 48) && (numLetra <= 57)) {
				numeros = true;
			} else
			{
				numeros = false;
				pos++;
			}
		}

		return numeros;
	}

	private boolean tieneCaracterControl(String password) {
		boolean charControl = false;
		int longitud = password.length();
		int pos = 0;
		char letraActual = ' ';
		int numLetra = 0;

		while (!charControl && (pos < longitud)) {
			letraActual = password.charAt(pos);
			numLetra = (int) letraActual;
			if ((numLetra >= 33) && (numLetra <= 47)) {
				charControl = true;
			} else
			{
				charControl = false;
				pos++;
			}
		}
		return charControl;
	}
	
	
	private boolean tieneCaracterEnRango(String password, int rangoInferior, int rangoSuperior) {
		boolean tieneCaracterEnRango = false;
		int longitud = password.length();
		int pos = 0;
		char letraActual = ' ';
		int numLetra = 0;

		while (!tieneCaracterEnRango && (pos < longitud)) {
			letraActual = password.charAt(pos);
			numLetra = (int) letraActual;
			if ((numLetra >= rangoInferior) && (numLetra <= rangoSuperior)) {
				tieneCaracterEnRango = true;
			} else
			{
				tieneCaracterEnRango = false;
				pos++;
			}
		}
		return tieneCaracterEnRango;
	}

	@Override
	public TipoFortaleza tipoPassword(String password) {
		TipoFortaleza tipoFortaleza;
		int longitud = password.length();

	
		if ((longitud >= 7) && tieneMayusculas(password) && tieneMinusculas(password) && tieneNumeros(password)
				&& tieneCaracterControl(password)) {
			tipoFortaleza = TipoFortaleza.FUERTE;
		} else if ((longitud >= 7) && tieneMayusculas(password) && tieneMinusculas(password) && tieneNumeros(password)) {
			tipoFortaleza = TipoFortaleza.MEDIA;
		} else {
			tipoFortaleza = TipoFortaleza.DEBIL;
		}

		return tipoFortaleza;
	}
	
	public static void main(String[] args) {
		Fortaleza f = new ImplFortaleza();
		System.out.println("asdc es "+ f.tipoPassword("asdc"));
		System.out.println("asdc12M es "+ f.tipoPassword("asdc12M"));
		System.out.println("asdc12M! es "+ f.tipoPassword("asdc12M!"));
	}

}
