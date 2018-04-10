package ejercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ejercicio4 {

	// listas de ejemplo, pueden variarse su contenido, 
	static Integer[] valoresLista1 = {1, 2, 5, 8, 10, 30, 20, 8, 9, 10};
	static Integer[] valoresLista2 = {1, 2, 4, 20, 5, 10, 7, 8, 10, 9};

	/**	 
	 * Para ejecutar el método main se debe hacer boton derecho sobre la clase
	 * "Run As --> Java Application" 
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("**** inicializando datos ****");
		
		List<Integer> lista1 = new ArrayList<Integer>(Arrays.asList(valoresLista1));
		List<Integer> lista2 = new ArrayList<Integer>(Arrays.asList(valoresLista2));
	
		System.out.println("**** inicializacion exitosa ****");

		// EJERCICIO 4.1: explicar salidas y sugerir mejoras---
		/// La mejora del metodo mas importate hacer submetodos en cada unos de los Syso 
		informacion(lista1, 10);
		
		// EJERCICIO 4.2: corregir el metodo
		List<Integer> union = unionListas(lista1, lista2);
		System.out.println("union: " + union.toString());
		
		// EJERCICIO 4.3: implementar
		List<Integer> interseccion = interseccionListas(lista1, lista2);
		System.out.println("interseccion: " + interseccion.toString());
		
		// EJERCICIO 4.4: implementar
		List<Integer> orden1 = ordenaListaAscendente(lista1);
		System.out.println("orden asc: " + orden1);
		
		// EJERCICIO 4.5: implementar
		List<Integer> orden2 = ordenaListaDescendente(lista2);
		System.out.println("orden desc: " + orden2);

		// EJERCICIO 4.6: implementar
		boolean b = tienenMismoContenido(lista1, lista2);
		System.out.println("mismo contenido: " + b);
		
	}

	private static void informacion(List<Integer> lista1, Integer numero) {
		// TODO: explicar salidas de los system out y sugerir alguna mejora a la implementacion
		
		int pares = 0;
		for (Integer n: lista1) {
			if (n % 2 == 0) {
				pares = pares + 1;
			}
		}
		
		System.out.println("... Cantidad de Multiplos de Dos (numeros pares) en toda la lista: " + pares);
		
		List<Integer> impares = new ArrayList<Integer>();
		for (Integer n: lista1) {
			if (n % 2 != 0) {
				impares.add(n);
			}
		}
		
		System.out.println("...Numeros de la lista que no son Multiplos de Dos (numeros impares): " + impares.toString());
		
		int p = lista1.size() / 2;
		
		System.out.println("...Numero de la lista que se encuentra en la posicion del medio de la lista: " + lista1.indexOf(p));
		
		int c = 0; //// Cantidad de numeros de las lista mayores a 10
		for (Integer n: lista1) {
			if (n > numero) {
				c = c + 1;  /// Mejora : Se podria comprar (c > lista1.size() / 2) dentro del For, entonces se podria evitar recorrer toda la lista y se tendria una salida mas r�pida
			
			}
		}
		if (c > lista1.size() / 2) {
			System.out.println("...Los numeros de las lista son en su mayoria mayores a 10"); 
		} else if (c > 0) { 
			System.out.println("...Los numeros de las lista son en su mayoria menores a 10"); 
		} else {
			System.out.println("...No se encuentras numeros de las lista mayores a 10");
		}
	}

	/***
	 * @param lista1
	 * @param lista2
	 * 
	 * retornar una lista que contenga los elementos de ambas listas, sin elementos repetidos 
	 * 
	 */
	private static List<Integer> unionListas(List<Integer> lista1, List<Integer> lista2) {
		// TODO: corregir el metodo para que funcione correctamente 
		
		/*List<Integer> union = null;*/ /// Inicial
		List<Integer> union = new ArrayList<Integer>(); // inicializar
				
		union.addAll(lista1);
		
		for (Integer m: lista2) {
			if (!union.contains(m)) {
				union.add(m);
			}
		}
		
		return union;
	}

	/***
	 * @param lista1
	 * @param lista2
	 * 
	 * retornar una lista que contenga los elementos que estan presentes en ambas listas, sin elementos repetidos 
	 * 
	 */
	private static List<Integer> interseccionListas(List<Integer> lista1, List<Integer> lista2) {
		// TODO:
		List<Integer> interseccion = new ArrayList<Integer>(); // inicializar
		
		
		for (Integer n: lista1) {
			for (Integer m: lista2) {
			  if(n.equals(m)){
				if (!interseccion.contains(m)) {
					interseccion.add(m);
				}
			  }
			}
		}
		return interseccion;
		
		
	}

	/***
	 * @param lista1
	 * 
	 * retornar la lista recibida, ordenada en forma ascendente
	 * 
	 */
	private static List<Integer> ordenaListaAscendente(List<Integer> lista1) {
		// TODO:
		
		Collections.sort(lista1, new Comparator<Integer>() {
		    @Override
		    public int compare(Integer o1, Integer o2) {
		        return o1.compareTo(o2);
		    }
		});
		
		
		return lista1;
	}

	/***
	 * @param lista2
	 * 
	 * retornar la lista recibida, ordenada en forma descendente
	 * 
	 */
	private static List<Integer> ordenaListaDescendente(List<Integer> lista2) {
		// TODO:
		Collections.sort(lista2, new Comparator<Integer>() {
		    @Override
		    public int compare(Integer o1, Integer o2) {
		        return o2.compareTo(o1);
		    }
		});
		
		
		return lista2;
	}

	/***
	 * @param lista1
	 * @param lista2
	 * 
	 * devuelve true si contienen los mismos elementos
	 * NO se considera valido que esten en diferente orden
	 * NO se considera valido que la cantidad de repeticiones de los elementos sea diferente -- no estoy muy segura si esta bien
	 * 
	 *
	 * 
	 */
	private static boolean tienenMismoContenido(List<Integer> lista1, List<Integer> lista2) {
		// TODO:	
		boolean respuesta = compararMismaPosicion(lista1, lista2);
		if(!respuesta){
		   System.out.println("NO se considera valido que esten en diferente orden");
		}else {
			respuesta = compararCantidadDeRepeticiones(lista1, lista2);
			if(!respuesta){
				   System.out.println("NO se considera valido que la cantidad de repeticiones de los elementos sea diferente");
				}
		}
		return respuesta;
	}
	
	
	public static boolean compararMismaPosicion(List<Integer> lista1, List<Integer> lista2){
		boolean respuesta = true;
		int cantidadElementosLista2=lista2.size();
		for (int i =0; i<lista1.size(); i++) {
			if(i<cantidadElementosLista2){
				if(!lista1.get(i).equals(lista2.get(i))){
					respuesta= false;
					break;
				}
				
			}else{
				break;
			}
			
		}
		return respuesta;
	}
	
	
	public static boolean compararCantidadDeRepeticiones(List<Integer> lista1, List<Integer> lista2){
		boolean respuesta = true;
		
		
		for (Integer m: lista1) {
			if(cantidadElementosRepetidosLista (lista1, m)!= cantidadElementosRepetidosLista (lista2, m)){
				respuesta=false;
				break;
				
			};
			
		}
		return respuesta;
	}
	
	
	public static int cantidadElementosRepetidosLista(List<Integer> lista, Integer elemento){
		int cantidad=0;
		
		for (Integer m: lista){
    	   if(m.equals(elemento)){
    		   cantidad=cantidad +1;
    	   }
			
			
		}
		
		return cantidad;
	}


}
