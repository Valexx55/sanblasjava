package appinicialprofe.basico;

/**
 * 
 * @author Val
 *
 *         El código de esta clase, es un poco misterioso. Algún programador
 *         Clase "C", no ha usado nombres descriptivos y ahora, nos toca
 *         pegarnos y descubrir qué narices hace este código, para poder usarlo
 *         en nuestro proyecto.
 *
 *
 *         Se pide:
 *
 *         1) Adivinar la funcionalidad del método adivinaQueHace 2) Una vez
 *         descubierto, aplicar un nombre apropiado al método y a la clase 3)
 *         Idear un método equivalente, pero distinto. Es decir, crear un método
 *         que haga lo mismo que adivinaQueHace, pero de otra manera. 4) EXTRA:
 *         Sólo si resolviste los puntos anteriores, implementa una versión
 *         recursiva
 *
 */
public class CompruebaCadenas {

	private static boolean esCadenaPalindroma(String cad) {
		boolean palindroma = true;

		int posicionInicial = 0;
		int posicionFinal = cad.length() - 1;

		while ((posicionInicial <= posicionFinal) && (palindroma)) {
			palindroma = cad.charAt(posicionInicial) == cad.charAt(posicionFinal);
			posicionInicial++;
			posicionFinal--;
		}

		return palindroma;
	}

	private static boolean palabraPalindrimos(String cadenaOriginal) {

		boolean palindromo = false;
		String cadenaInvertida = null;

		StringBuilder stringBuilder = new StringBuilder(cadenaOriginal);
		cadenaInvertida = stringBuilder.reverse().toString();
		if (cadenaOriginal.equals(cadenaInvertida)) {
			palindromo = true;
		}

		return palindromo;

	}

	private static void imprimirHasta100(int n)

	{
		if (n < 100) {
			System.out.println(n);
			n = n + 1;
			imprimirHasta100(n);
		}

	}

	private static boolean esPalindromoRecursivo(String cad, int posInicial, int posicionFinal) {

		boolean res = false;

		if (posInicial >= posicionFinal) {
			res = true;
		} else {
			res = cad.charAt(posInicial) == cad.charAt(posicionFinal) && esPalindromoRecursivo(cad, posInicial + 1, posicionFinal - 1);
		}
		return res;

	}

	public static void main(String[] args) {

		imprimirHasta100(0);
		if (esCadenaPalindroma("vale")) {
			System.out.println("VERDADERO");
		} else {
			System.out.println("FALSO");
		}

		if (palabraPalindrimos("pop")) {
			System.out.println("VERDADERO");
		} else {
			System.out.println("FALSO");
		}
		String pruebaRecursiva = "ROMAOAMOR";
		boolean palinrec = esPalindromoRecursivo("ROMAOAMOR" , 0, pruebaRecursiva.length()-1);
		System.out.println(palinrec);
		pruebaRecursiva = "MADRID";
		palinrec = esPalindromoRecursivo("MADRID" , 0, pruebaRecursiva.length()-1);
		System.out.println(palinrec);
	}

}