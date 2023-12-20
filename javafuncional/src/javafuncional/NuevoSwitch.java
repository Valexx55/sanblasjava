package javafuncional;

import java.util.Random;

public class NuevoSwitch {

	//info extra https://openjdk.org/jeps/361
	public static void main(String[] args) {
		
		int nota_numerica = new Random().nextInt(11);//generamos un número de uno a 10
		//TODO sacamos la nota alfabética
		String nota_alfa = switch (nota_numerica) {
		case 0, 1, 2, 3, 4 -> "SUSPENSO";
		case 5 -> "APROBADO";
		case 6 -> "BIEN";
		case 7, 8 -> {
			yield "NOTABLE";
		}
		default -> {
			yield "SOBRESALIENTE";
		}
	};//fin swtich-asignación
	    System.out.println("Nota numérica " + nota_numerica + " Nota alfabética " + nota_alfa);
	}

}
