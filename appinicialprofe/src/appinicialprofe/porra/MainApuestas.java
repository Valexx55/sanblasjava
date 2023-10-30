package appinicialprofe.porra;

public class MainApuestas {

	public static void main(String[] args) {
		//creo una apuesta
		Apuesta apuesta1 = new Apuesta();
		apuesta1.nombreJugador = "ADRI";
		apuesta1.golesVisitante = 1;
		apuesta1.golesLocal = 1;
		
		Apuesta[] arrayApuestas = new Apuesta[5];
		
		arrayApuestas[0] = apuesta1;
	}
}
