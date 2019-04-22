package pilaestatica;

public class TestPilaEstatica {

	public static void main(String[] args) 
	{
		PilaEstatica pila = new PilaEstatica();
		pila.rellenar();
		pila.meter('h');
		pila.vaciar();
		pila.sacar();

	}

}
