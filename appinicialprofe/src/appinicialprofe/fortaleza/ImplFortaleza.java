package appinicialprofe.fortaleza;

public class ImplFortaleza  implements Fortaleza {

	/**
	 * fuerte si tiene más de 7 caracteres e incluye mayúsuclas, minúsculas, 
números y al menos un caracter de control entre los siguientes

!	"	#	$	%	&	'	(	)	*	+	,	-	.	/	

media si tiene más de 7 caracteres e incluye mayúsuclas, minúsculas y números

débil si no es media ni fuerte
	 */
	
	private boolean tieneMayusculas (String password)
	{
		boolean mayus = false;
		
		//tengo que ver si password contiene una letra de A (65) a la Z (90)
		//MIENTRAS NO APAREZCA UNA MAYÚSCULA Y ME QUEDE CADENA
		//RECORRO VOY PREGUNTADO
			//OBTENGO LA LETRA ACTUAL
			//LA PASO A NÚMERO
		    //SI ESTÁ ENTRE 65 Y 90 , ES UNA MAY
			//SI NO, VOY A LA SIGUIENTE POSICION
		
		return mayus;
	}
	
	private boolean tieneMinusculas (String password)
	{
		boolean minus = false;
		
		return minus;
	}
	
	private boolean tieneNumeros (String password)
	{
		boolean numeros = false;
		
		return numeros;
	}
	
	private boolean tieneCaracterControl (String password)
	{
		boolean charControl = false;
		
		return charControl;
	}
	
	@Override
	public String tipoPassword(String password) {
		String tipo = null;
		int longitud = password.length();
		
			if ((longitud>7)&&tieneMayusculas(password)&&tieneMinusculas(password)&&tieneNumeros(password)&&tieneCaracterControl(password))
			{
				tipo = "FUERTE";
			} else if ((longitud>7)&&tieneMayusculas(password)&&tieneMinusculas(password)&&tieneNumeros(password))
			{
				tipo = "MEDIA";
			} else {
				tipo = "DÉBIL";
			}
			
		
		
		return tipo;
	}

	

}
