package interfazpilacoladinamica;

public class PilaDinamica implements InterfazDinamica{
	Nodo cima;
	
	public PilaDinamica() {
		cima = null;
	}

	@Override
	public void insertar(Object obj) {
		Nodo nuevo = new Nodo(obj, cima);
		cima = nuevo;
		
	}

	@Override
	public Object eliminar() {
		if(vacia()) {
			System.out.println("La pila esta vacia");
			return null;
		}
		Object x = cima.info;
		cima = cima.enlace;
		return x;
	}

	@Override
	public boolean vacia() {
		return (cima == null);
	}
	//////////////////////////
	public void rellenar() {
		for(char letra = 'a';letra <= 'z';letra++) {
			insertar(letra);
		}
}
	///////////////////////////
	public void vaciar() {
		if(vacia()) {
			System.out.println("La pila esta vacia");
		}else {
			while(!vacia()) {
				System.out.print(eliminar() + " ");
			}
		}
	}
}
