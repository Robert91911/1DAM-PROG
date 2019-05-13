package consultaDB;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		switch (comando) {
		case "CONECTAR":
			conectar();
			break;
		case "CONSULTAR":
			consultar();
			break;
		case "BORRAR":
			borrar();
			break;
		}
		
	}

	private void conectar() {
		
		
	}


	private void consultar() {
		
		
	}

	private void borrar() {
		
		
	}

}
