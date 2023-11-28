package appapuestas;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

import appapuestas.bean.Apuesta;

public class MainArrayEstadisticos {
	
	public static void main(String[] args) {
		
		//Apuesta[] arrayApuestas = new Apuesta[10];
		
		//List<Apuesta> la = Arrays.asList(arrayApuestas);
		Random r = new Random();
		
		Supplier<Apuesta> genApuestas = () -> {
			Apuesta a = new Apuesta();
			a.setValorApuesta(r.nextFloat(100));
			return a;
		};
		List<Apuesta> la = Stream.generate(genApuestas).limit(10).toList();
		
		
		double media = la.stream().mapToDouble((Apuesta a)->a.getValorApuesta()).average().orElse(0);
		System.out.println("media = " +media);
		
		double max = la.stream().mapToDouble((Apuesta a)->a.getValorApuesta()).max().orElse(0);
		System.out.println("max = " +max);
		
		DoubleSummaryStatistics ds = la.stream().mapToDouble((Apuesta a)->a.getValorApuesta()).summaryStatistics();
		ds.getAverage();
		ds.getMax();
		ds.getMin();
		
		la.forEach(a -> System.out.println(a.getValorApuesta()));
	}

}
