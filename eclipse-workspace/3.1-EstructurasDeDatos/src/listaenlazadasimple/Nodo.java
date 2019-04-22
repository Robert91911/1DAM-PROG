package listaenlazadasimple;

public class Nodo {
	public Object info;
	public Nodo enlace;
	
	public Nodo(Object info, Nodo enlace) {
		this.info = info;
		this.enlace = enlace;
	}
}
