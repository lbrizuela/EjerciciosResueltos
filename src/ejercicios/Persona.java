package ejercicios;

import java.util.Date;

public class Persona {

	public Persona() {
		// TODO Auto-generated constructor stub
	}
	public enum TipoDocumento { /// Aunque esto no se debe usar como string, no le encuentro otro 
		 ///motivo como para agregarle contructores o complejidad extra.
		DNI,LIBRETACIVICA
		
	};
	private TipoDocumento tipoDocumento;
	private int nroDocumento;
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	
	
	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public int getNroDocumento() {
		return nroDocumento;
	}
	public void setNroDocumento(int nroDocumento) {
		this.nroDocumento = nroDocumento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	 

}
