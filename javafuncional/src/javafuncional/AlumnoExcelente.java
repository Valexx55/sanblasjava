package javafuncional;

import java.util.function.Predicate;

public class AlumnoExcelente implements Predicate<Alumno> {

	
	/**
	 * recibo un alumno y digo si  es excelente (true) o no (false)
	 */
	@Override
	public boolean test(Alumno t) {
		boolean excelente = false;
		
		//excelente = (t.getNota() > 7);//(t.getNota() > 7) ? true : false;
		if (t.getNota()>7)
		{
			excelente = true;
		}
		
		return excelente;
	}

}
