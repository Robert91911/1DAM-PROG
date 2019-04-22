package interfazpilacoladinamica;

public class TestInterface {

	public static void main(String[] args) {
		InterfazDinamica interfaz ;
		ColaDinamica cola = new ColaDinamica();
		interfaz = cola;
		interfaz.rellenar();
		interfaz.vaciar();
		System.out.println(" \n ");
		
		PilaDinamica pila = new PilaDinamica();
		interfaz = pila;
		interfaz.rellenar();
		interfaz.vaciar();
	}

}
