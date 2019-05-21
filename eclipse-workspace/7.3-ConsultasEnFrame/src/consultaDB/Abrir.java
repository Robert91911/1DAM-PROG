package consultaDB;

public class Abrir {

	public static void main(String[] args) {
		View view = new View();
		Controller controlador = new Controller(view);
		view.conectarControlador(controlador);
	}

}
