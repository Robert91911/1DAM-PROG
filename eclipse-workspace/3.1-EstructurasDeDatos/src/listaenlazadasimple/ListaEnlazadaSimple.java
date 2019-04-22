package listaenlazadasimple;

public class ListaEnlazadaSimple {
	/**
	 * Una lista enlazada simple es una colección de nodos
	 * enlazados. Cada nodo tendrá como minimo dos atributos:
	 * informacion y enlace. informacion será la referencia 
	 * del objeto que queremos almacenar y enlace será la
	 * referencia de otro nodo.
	 * Siempre tendremos una referencia llamada inicio que
	 * apunte al primer nodo de la lista. 
	 * El campo enlace del ultimo nodo tiene que valir `null`
	 * 
	 */
	
	Nodo inicio;
	
	public ListaEnlazadaSimple() {
		inicio = null;
	}
	
	///////////////////////////////////////
	
	public void insertarPrincipio(Object obj) {
		// Creamos un nuevo nodo
		Nodo nuevo = new Nodo(obj, inicio);
		
		// Inicio pasa a referenciar a nuevo
		inicio = nuevo;
	}
	
	///////////////////////////////////////
	
	public void verLista() {
		// Nos colocamos al principio de la lista
		Nodo actual = inicio;
		while (actual != null) {
			System.out.println(actual.info);
			// Avanzamos al siguiente nodo
			actual = actual.enlace;
		}
	}
	
	///////////////////////////////////////
	
	/**
	 * Este metodo inserta un nodo al final de la lista
	 * 
	 */
	public void insertarFinal(Object obj) {
		// Creamos un nuevo nodo
		Nodo nuevo = new Nodo(obj, null);
		
		if (estaVacia()) {
			inicio = nuevo;
		} else {
			// Nos situamos en el ultimo nodo
			Nodo actual = inicio;
			
			while (actual.enlace != null) {
				actual = actual.enlace;
			}
			
			// Enlazamos el ultimo nodo con el nuevo
			actual.enlace = nuevo;
		}
	}
	
	///////////////////////////////////////
	
	public boolean estaVacia() {
		return (inicio == null);
	}
	
	///////////////////////////////////////
	
	/**
	 * Este metodo busca el nodo a eliminar y lo elimina
	 * enlazando el nodo anterior con el siguiente
	 */
	public void eliminar(Object obj) {
		// Variables: 
		Nodo anterior = null;
		Nodo actual = inicio;
		boolean encontrado = false;
		
		while (actual != null && !encontrado) {
			if (actual.info.equals(obj)) {
				encontrado = true;
			} else {
				// Avanzamos al siguiente nodo
				anterior = actual;
				actual = actual.enlace;
			}
		}
		
		if (encontrado) {
			// Comprobamos si es el primero
			if (anterior == null) {
				// El inicio de la lista pasa a ser el siguiente nodo 
				inicio = inicio.enlace;
			} else {
				// Enlazamos en nodo anterior con el siguiente
				anterior.enlace = actual.enlace;
			}
		}
	}
}
