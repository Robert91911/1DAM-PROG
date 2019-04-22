package listaenlazadasimple;

public class PruebaListaEnlazada {
	public static void main(String[] args) {
		ListaEnlazadaSimple lista = new ListaEnlazadaSimple();
		
		lista.insertarPrincipio("javier");
		lista.insertarPrincipio("olga");
		lista.verLista();
		
		lista.insertarFinal("pepe");
		lista.verLista();
		
		lista.eliminar("olga");
		lista.eliminar("pepe");
		lista.verLista();
	}
}
