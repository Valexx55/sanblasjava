package appinicialprofe.excepciones;

public class MainExceptions {
	
	public static void main(String[] args) {
		
		System.out.println("INICIO");
		String saludo = "HOLA";
		String saludo1 = null;
		try {
			saludo.charAt(4);
			saludo1.length();
			
		}
		catch (IndexOutOfBoundsException e) {
			System.err.println("FALLO Index ");
			e.printStackTrace();
		}
		catch (Exception e) {
			System.err.println("FALLO Exception ");
			e.printStackTrace();
		}catch (Throwable e) {
			System.err.println("FALLO Throwable ");
			e.printStackTrace();
		}
				
		System.out.println("FIN");
	}

}
