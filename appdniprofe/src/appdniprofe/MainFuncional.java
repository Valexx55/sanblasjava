package appdniprofe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainFuncional {
	
	public static void main(String[] args) {

		List<Dni> listaDni = new ArrayList<Dni>();
		Dni dnivale = new Dni(53130985, 'H');
		Dni dnikevin = new Dni(2740120, 'Y');
		Dni dnialba = new Dni(5945376, 'Z');
		listaDni.add(dnikevin);
		listaDni.add(dnivale);
		listaDni.add(dnialba);
		
		long numdenis = listaDni.stream().count();
		System.out.println("tengo " + numdenis + " dnis");
		
		List<Dni> listaDniPares 
		= listaDni.stream().filter(d -> d.getNumero()%2==0).toList();
		System.out.println("lista pares " + listaDniPares);
		
		//TODO imprimir sólo los números del DNI
		for (Dni dni : listaDni) {
			System.out.println(dni.getNumero());
		}
		
		System.out.println();
		
		listaDni.forEach((Dni dni)-> {
			System.out.println(dni.getNumero());
			System.out.println(dni.getLetra());
			}
		);
		
		System.out.println();
		
		Collections.sort(listaDni, 
			(Dni dni1, Dni dni2) -> 
				{
					return dni1.getNumero()-dni2.getNumero();	
				}
			);
		
		System.out.println("DESPUÉS DE ORDENAR");
		
		listaDni.forEach((Dni dni)-> {
			System.out.println(dni.getNumero());
			System.out.println(dni.getLetra());
			}
		);
	}

}
