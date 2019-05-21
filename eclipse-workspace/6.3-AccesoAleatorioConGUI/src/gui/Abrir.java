package gui;

public class Abrir {
	
	public static void main(String[] args) {
		View view = new View();
		Controller c = new Controller(view);
		view.conectarControlador(c);
	}
	
	
}
