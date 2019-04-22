package piladinamica;

public class PilaDinamica {
	Nodo cima;
	
	public PilaDinamica() {
		cima = null;
		
	}
	
	/////////////////////////////
	
	public void insertar(Object obj) {
		Nodo nuevo = new Nodo(obj,cima);
		cima = nuevo;
	}
	
	/////////////////////////////
	
	public Object eliminar() {
		if(vacia()) {
			System.out.println("La pila est� vacia");
			return null;
		}
		Object x = cima.info;
		cima = cima.enlace;
		return x;
		
	}
	
	/////////////////////////////
	
	public void rellenar() {
		for(char letra = 'a';letra <= 'z'; letra++) {
			insertar(letra);
		}
	}
	
	/////////////////////////////
	
	public boolean vacia() {
		return (cima == null);
	}
	
	/////////////////////////////
	
	public void vaciar() {
		if(vacia()) {
			System.out.print("La pila ya est� vacia");
		}
		else {
			while(!vacia()) {
				System.out.print(eliminar() + " ");
			}
		}
	}

}
