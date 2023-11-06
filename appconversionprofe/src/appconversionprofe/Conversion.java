package appconversionprofe;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * vamos a hacer una clase para convertir unidades de medida
 * 
 */
public class Conversion {

	// TODO cada uno de los alumnos va a hacer un método
	// todos son public static

	// FER de KM a Millas
	// VINI de Millas a KM
	// KEVIN de CM a Pulgadas
	// WILL de Pulgadas a CM
	// BRENDA de Kg a Libras
	// ALISON de lIBRAS A KG
	// ALBA de OZ a Ml
	// ELHIEZER de Ml Oz
	// HARRISON DE Horas a Minutos
	// ANDREI DE Minutos a Horas
	// ADRI DE € a $
	// SHEILA DE € a Soles
	// Antonio de Yenes a Euro

	private  double redondear (double d)
	{
		double nr = 0;
		
			DecimalFormat nf = new DecimalFormat("#,###,###.000");
			 nf.format(d);
		
		return nr;
	}
	
	/**
	 * * Programa que convierte pulgadas a centimetros
	 * 
	 * @param pul cantidad de pulgadas a convertir.
	 * @return pulgadas convertidas a centimetros.
	 */

	public static double conversionPulgadasACentimetros(double pul) {
		double centimetros = 0;

		centimetros = pul * 2.25;

		return centimetros;

	}

	/**
	 * Programa que Calcula de horas por minutos
	 * 
	 * @param horas po cada hora 60 minutos
	 * @return
	 */
	public static double convertirHorasMinutos(float horas) {

		double minutos = 0; // variable numerica

		minutos = horas * 60;

		return minutos;

	}

	/**
	 * Programa para convertir minutos a horas
	 * 
	 * @param horas   1 hora = 60 minutos
	 * @param minutos 60 minutos = 60 segundos El programa consiste en pedir los
	 *                minutos que quiera y me los devuelva en horas,tanto con
	 *                decimales como sin ellos.
	 */
	public static double minutosAhoras(float minutos) {

		double horas = 0;

		horas = minutos / 60;

		return horas;
	}

	/**
	 * Conversión km a millas
	 * @param km a convertir
	 * @return equivalencia en millas
	 */
	public static double conversionDeKmAmillas(double km)

	{

		double millas = 0;

		millas = km * 0.621371;

		// TODO para mejorar busca como redondear a 2 decimales

		DecimalFormat dc = new DecimalFormat("#.##");

		return Double.valueOf(dc.format(millas));
	}

	/**
	 * Este pograma realiza la conversion de onzas a militros y luego muuestra el
	 * resultado en mililitros.
	 * 
	 * @param numero
	 * @return
	 * 
	 */

	public static float convertirOnzasAMililitros(float numero) {
		float mililitros = 0;
		mililitros = (float) (numero * 29.57);
		System.out.println(mililitros); // imprimimos el resultado

		return mililitros;

	}

	/**
	 * generamos un metodo para convertir mililitros a onzas
	 * 
	 * @param dato //el dato es en mililitros (ml)
	 * @return onzas //nos retorna los mililitros convertido en onzas (Oz)
	 */
	public static float convertirMlAOnzas(float dato) {
		float onzas = 0;
		/**
		 * aplicamos la formula de conversión de mililitros a onzas
		 */
		onzas = (float) (dato * 0.0338140227);
		System.out.println(dato + " ml. = " + onzas + " Oz");
		return onzas;
	}

	/**
	 * Convertirá los euros a la moneda indicada devolviendo la cantidad obtenida.
	 *
	 * @param moneda
	 * @param euros
	 * @return
	 */
	public static double cambiarMoneda(String moneda, double euros) {
		double cambio = 0.0;
		switch (moneda) {
		case "LIBRAS":
			cambio = euros * 0.87;
			break;
		case "DOLARES":
			cambio = euros * 1.11;
			break;
		case "YENES":
			cambio = euros * 120.63;
			break;
		}
		return cambio;
	}

	// TODO hacer un metodo de convierta de una unidad de medida a otra

	/**
	 * Convierte euros en soles
	 * @param monedaorigen la cantidad en euros
	 * @return la equivalencia en soles
	 */
	public static double convertirEuroSoles(double monedaorigen) {// Función que convierte monedas en Euros a Soles

		double tasa = 4.0;// declaramos variable

		double monedadestino = monedaorigen * tasa;

		return monedadestino;

	}

	/**
	 * Convierte soles en euros
	 * @param monedaorigen la cantidad en soles
	 * @return la equivalencia en euros
	 */
	public static double convertirSolesEuro(double monedaorigen) {// Función que convierte monedas Soles a Euros

		double tasa = 4.0;// declaramos variable

		double monedadestino = monedaorigen / tasa;

		return monedadestino;

	}

}
