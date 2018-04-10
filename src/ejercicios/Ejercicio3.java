/**
 * 
 */
package ejercicios;

/**
 * A. Crear una clase Alumnno con los siguientes campos
 * (con sus respectivos getters, setters y constructor)
 * 
 * Persona -------------- Supongo que esto quiere decir que el alumno esta relacionado a una persona por eso realice las tarea asi
 * Legajo - Integer
 * 
 *  
 * @author examen
 *
 */
public class Ejercicio3 {

	/**
	 * 
	 */
	public Ejercicio3() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public class Alumno{
		
		Persona personaAlumno; /// Aclaración arriba 
		int legajo;
		
		public Persona getPersonaAlumno() {
			return personaAlumno;
		}
		public void setPersonaAlumno(Persona personaAlumno) {
			this.personaAlumno = personaAlumno;
		}
		public int getLegajo() {
			return legajo;
		}
		public void setLegajo(int legajo) {
			this.legajo = legajo;
		}
		
		public Alumno(Persona personaAlumno, int legajo){
			
			this.personaAlumno = personaAlumno;
			this.legajo= legajo;
			
		}
		
	}

}
