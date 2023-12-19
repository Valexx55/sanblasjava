package appapuestas.bd;

import java.util.List;

import appapuestas.bean.Apuesta;

//@FunctionalInterface
public interface CRUDApuestas {
	
	//escribir las cabaceras de los métoso para
	//crear una apuesta en base datos
	//read / leer una apuesta de base da datos
	//read / leer todas las apuestas de la base de datos
	//update / actualizar una apuesta
	//delete / borrar una apuesta
	
	
	boolean crearApuesta (Apuesta apuesta);
	
	List<Apuesta> leerApuestas();

}
