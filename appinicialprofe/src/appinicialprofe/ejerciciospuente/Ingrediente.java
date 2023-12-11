package appinicialprofe.ejerciciospuente;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Ingrediente {
	
	private int cantidad;
	private String nombre;
	
	

	public Ingrediente(int cantidad, String nombre) {
		super();
		this.cantidad = cantidad;
		this.nombre = nombre;
	}

	/*@Override
	public boolean equals(Object obj) {
		
		Ingrediente i = (Ingrediente)obj;
		
		return (this.cantidad==i.cantidad) && (this.nombre.equals(i.nombre));
	}*/


	public static void main(String[] args) {
		
		Ingrediente ingrediente = new Ingrediente(300, "macarrones");
		Ingrediente ingrediente1 = new Ingrediente(200, "lentejas");
		Ingrediente ingrediente2 = new Ingrediente(120, "chorizo");
		Ingrediente ingrediente3 = new Ingrediente(120, "chorizo");
		
		List<Ingrediente> li = List.of(ingrediente, ingrediente1, ingrediente2);
		List<Ingrediente> li1 = List.of(ingrediente, ingrediente1, ingrediente3);
		
		System.out.println(li.equals(li1));
		int res =  Arrays.mismatch(li.toArray(), li1.toArray());
		System.out.println(res);
	}
}
