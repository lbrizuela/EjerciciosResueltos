package ejercicios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ejercicios.Persona.TipoDocumento;

/**
 * A. Crear una clase Persona con los siguientes campos
 * (con sus respectivos getters, setters y constructor)
 * 
 * TipoDocumento - enum (dni/libretacivica)   se encuentra dentro del paquete
 * NroDocumento - Integer
 * Nombre - String
 * Apellido - String
 * FechaNacimiento - Date
 * 
 * B. En el método main de la clase "Ejercicio2" crear una nueva instancia
 * de la clase persona y settearle valores reales con tus datos
 * 
 * 
 * C. En el método main de la clase "Ejercicio 2" imprimir los valores en 
 * consola 
 * (crear método main e imprimir valores) 
 *  
 * @author examen
 *
 */
public class Ejercicio2 {

	/**
	 * 
	 */
	public Ejercicio2() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona mipersona= agregarNuevaPersona();
		mostrarPersona(mipersona);

	}
	
	
	public static Persona agregarNuevaPersona(){
		Persona mipersona= new Persona();
		mipersona.setApellido("Brizuela");
		mipersona.setNombre("Luisina");
		mipersona.setNroDocumento(37279593);
		mipersona.setTipoDocumento(TipoDocumento.DNI);
		mipersona.setFechaNacimiento(tranformarStringDate("07-03-1994"));
		return mipersona;
	}
	
	public static void mostrarPersona (Persona mipersona){
		System.out.println("Apellido: " +  mipersona.getApellido());
		System.out.println("Nombre: " + mipersona.getNombre());
		System.out.println("Tipo Documento: " + mipersona.getTipoDocumento().toString());
		System.out.println("Numero Documento: "+ String.valueOf(mipersona.getNroDocumento()));
		System.out.println("Fecha Nacimiento: "+ tranformarDateString(mipersona.getFechaNacimiento()));
	}
	
	
	public static Date tranformarStringDate(String fechanacimiento){
		SimpleDateFormat sm = new SimpleDateFormat("dd-mm-yyyy");
	   
	    Date fecha=null;
		try {
			fecha = sm.parse(fechanacimiento);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return fecha;
	    
	}
	
	
	public static String tranformarDateString(Date fechanacimiento){
		SimpleDateFormat sm = new SimpleDateFormat("dd-mm-yyyy");
	   
	    String fecha = sm.format(fechanacimiento);
	    
	    return fecha;
	    
	}
	
	
	

}
