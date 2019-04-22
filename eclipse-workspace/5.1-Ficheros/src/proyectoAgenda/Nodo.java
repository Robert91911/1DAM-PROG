package proyectoAgenda;

import java.io.Serializable;

public class Nodo implements Serializable {
	
	Object info;
	Nodo enlace;
	
	public Nodo(Object info,Nodo enlace) {
		this.info= info;
		this.enlace=enlace;
	}
	
}
