package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import accesoaleatorio.BaseDeDatos;
import accesoaleatorio.Registro;



public class Controller implements ActionListener {

	View view;
	BaseDeDatos db;
	int pos;
	Registro registro;
	
	public Controller(View view) {
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		switch (comando) 
		{ 
		case "Crear Fichero":
			crearFichero();
			break;
		case "Abrir Fichero":
			abrirFichero();
			break;
		case "Añadir Registro":
			if(verificarPosicion()) {
				Registro registro = new Registro(view.txtRef.getText(), view.txtDesc.getText(),  Double.parseDouble(view.txtPrecio.getText()));
				db.escribirRegistro(pos, registro);
			}
			break;
		case "Modificar Registro":
			view.panelPrincipal.setVisible(false);
			view.colocarComponentesModifiRegistro();
			break;
		case "Eliminar Registro":
			db.eliminarRegistro(view.txtRef.getText());
			break;
		case "Visualizar Registro":
			if(verificarPosicion()) {
				registro = db.leerRegistro(pos);
				view.txtRef.setText(registro.getReferencia());
				view.txtDesc.setText(registro.getDescripcion());
				view.txtPrecio.setText(Double.toString(registro.getPrecio()));
			}
			break;
		case "Salir":
			salir();
			break;
		case "Referencia":
			db.modificarReferencia(pos, view.txtRef.getText());
			break;
		case "Descripcion":
			if(verificarPosicion())
				db.modificarDesc(pos, view.txtDesc.getText());
			break;
		case "Precio":
			if(verificarPosicion()) {
				double precio = Double.parseDouble(view.txtRef.getText());
				db.modificarPrecio(pos, precio);
			}
			break;
		case "Salir y guardar":
			salirYGuardar();
			break;
		case "Salir sin guardar":
			salirSinGuardar();
			break;
		}

	}
	public boolean verificarPosicion() {
		if(!view.txtPos.getText().equals("")) {
			if(esEntero(view.txtPos.getText()))
				pos=Integer.parseInt(view.txtPos.getText());
				return true;
		}else
			JOptionPane.showMessageDialog(view.ventana, "El valor del campo Posicion no es un entero");
		return false;
	}
	
	private void salirSinGuardar() {	
		view.panelModificacion.setVisible(false);
		view.colocarComponentesPrincipal();
		view.panelPrincipal.setVisible(true);
	}

	private void salirYGuardar() {
		if(db.flujo!=null) //Si flijo es null, es que hay flujos abieros
		{
			
			JOptionPane.showMessageDialog(view.ventana, "Archivo guardado");
			view.panelModificacion.setVisible(false);
			view.colocarComponentesPrincipal();
			view.panelPrincipal.setVisible(true);

		}else
			JOptionPane.showMessageDialog(view.ventana, "No hay nada que cerrar, ya lo esta");	
		view.ventana.add(view.panelPrincipal);	
	}

	public void salir(){
		db.cerrar();
		System.exit(0);
	}
	public boolean esEntero(String numero) {
		try {
			Integer.parseInt(numero);
			return true;
		}catch (NumberFormatException e) {
			return false;
		}
	}
	public void crearFichero() 
	{
		File fichero = new File("bbdd.dat");
		boolean existe = fichero.exists();
		do
		{
			if(existe) 
			{
				System.out.println("El archivo ya existe");
				fichero.list();
			}
			else
			{
				try {
				  if (existe)
				  {
						fichero.createNewFile();
						JOptionPane.showMessageDialog(view.ventana, "El archivo se ha creado correctamente");
				  }
				  else
					  JOptionPane.showMessageDialog(view.ventana, "El archivo ya existe");
				} catch (IOException ioe) 
					{
				  ioe.printStackTrace();
					}
				}
		}
		while(!existe);
	}

	
	public void abrirFichero()
	{
		try 
		{
			db = new BaseDeDatos(new File("bbdd.dat"));
			JOptionPane.showMessageDialog(view.ventana, "El fichero ahora esta abierto");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}