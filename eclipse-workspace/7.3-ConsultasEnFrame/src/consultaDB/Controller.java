package consultaDB;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Controller implements ActionListener {

	View view;
	
	public Controller(View view) {
		this.view = view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		switch (comando) {
		case "CONECTAR":
			System.out.println("conectando");
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
		Bd bd = new Bd();
		if(!view.txtUsuario.getText().equals("") && !view.txtContrasenya.getText().equals("")) {
			if(view.txtUsuario.getText().equals(bd.usuario) && view.txtContrasenya.getText().equals(bd.clave)){
				new Listado(view.dtm);
				JOptionPane.showMessageDialog(view.ventana, "Conectado con éxito");
			}else
				JOptionPane.showMessageDialog(view.ventana, "Error. La contraseña o el usuario no son correctos");
		}else
			JOptionPane.showMessageDialog(view.ventana, "Error. Algun campo está en blanco");
		
	}


	private void consultar() {
		
		
	}

	private void borrar() {
		
		
	}

}
