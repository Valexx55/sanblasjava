package appapuestas.bd;

import appapuestas.bean.Apuesta;

public class MainBDApuestas {
	
	public static void main(String[] args) {
		CRUDApuestas ca1 = new IValeCRUDApuestas();
		CRUDApuestas ca2 = new IAllisonCRUDApuestas();
		
		ca1.crearApuesta(new Apuesta());
		ca2.crearApuesta(new Apuesta());
		
	}

}
