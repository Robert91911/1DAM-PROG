package interfazpilacoladinamica;

public class ColaDinamica implements InterfazDinamica{
	Nodo primero;
	Nodo ultimo;
	
	public ColaDinamica() {
		primero = null;
		ultimo = null;
	}

	@Override
	public void insertar(Object obj) {
		Nodo nuevo = new Nodo(obj, null);
		//comprobamos si la cola esta vacia.
		if(vacia()) {
			primero = nuevo;
		}else {
			//enlazar el ultimo nodo con el nuevo.
			ultimo.enlace = nuevo;		
		}
		ultimo = nuevo;
		
	}

	@Override
	public Object eliminar() {
		if(vacia()) {
			System.out.println("La cola esta vacia");
			return null;
		}
		Object aux = primero.info;
		primero = primero.enlace;
		
		/**
		 * este codigo en java funciona perfectamente.
		 * pero en c tendriamos que hacer lo siguiente. Si la cola tuviera un solo elemento,
		 * despues de eliminarlo ultimo quedaria apuntando a esa zona de memoria.
		 * La solucion seria:
		 */
		if(vacia()) {
			ultimo = null;	
		}
		return aux;
}
	@Override
	public boolean vacia() {
		return (primero == null);
	}
	//////////////////////////////////
	public void vaciar() {
		if(vacia()) {
			System.out.println("La pila esta vacia");
		}else {
			while(!vacia()) {
				System.out.print(eliminar() + " ");
			}
		}
	}
	////////////////////////////////
	public void rellenar() {
		for(char letra = 'a';letra <= 'z';letra++) {
			insertar(letra);
		}
	}
}
