package apuestasbd.modelo;

import java.util.Comparator;

public class ComparadorEquiposPorId implements Comparator<Equipo> {


	@Override
	public int compare(Equipo o1, Equipo o2) {
		int valor = 0;
		
		/*System.out.println("llamado a comaprador ");
		System.out.println("EQUIPO 1 " + o1.toString() + " vs " + " EQUIPO 2" + o2);*/
		valor = o1.getIdequipo()-o2.getIdequipo();
		//valor = o2.getIdequipo()-o1.getIdequipo();

		/*if (o1.getIdequipo() > o2.getIdequipo()) {
			System.out.println("o1 es mayor");
			// devolvemos un número positivo
			valor = 7;
		} else if (o2.getIdequipo() > o1.getIdequipo()) {
			System.out.println("o2 es mayor");
			// devolvemos un número negativo
			valor = -3;
		} else {
			System.out.println("o1 es igual a o2");
			// devolvemos un cero
			valor = 0;
		}*/

		return valor;
	}

}
