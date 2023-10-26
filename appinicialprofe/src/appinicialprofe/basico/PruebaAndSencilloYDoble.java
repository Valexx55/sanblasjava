package appinicialprofe.basico;

public class PruebaAndSencilloYDoble {
	
	public static void main(String[] args) {
		int n = 2&3;//entre números, es el y logico bit a bit
		boolean resultado = (2==0+1)&&(2+2==4);//Y AND lógico cortocircuito: si la primera condición no se cumple, no sigue
		boolean resultado2 = (2==0+1)&(2+2==4);//Y AND lógico normal: aunque la primera condición no se cumple, sigue
		boolean resultado1 = (1==0+1)||(2+2==4);//O logico OR
		System.out.println(n);
		System.out.println(resultado);
		System.out.println(resultado2);
		System.out.println(resultado1);
		
	}

}
