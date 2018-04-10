package ejercicios;
/**
 * Ejercicio: analizar la siguente clase y realizar las correcciones
 * necesarias para que compile  
 * @author examen
 *
 */
public class Ejercicio1 {
	
	  	int count1;
	  	static int count2 =0;  /// Inicializacion 

	    public Ejercicio1() {
	    	count1 = 0;
	    	count2 ++;
	    }

	    public void incrementa1() {
	    	count1++;
	    }

	    public void incrementa2() {
	    	count2++;
	    }

//	    Metodo inicial
//	    public static void incrementa() {
//	    	count1++;
//	    }
	    
	    
	    /// Se supune que se quiere devolver una variable static
	    public static int  incrementa() {
          	return count2 ++;
	    }

}
