package interfazgrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import operacionesdb.*;

public class Controller implements ActionListener, MouseListener {

	View vista;

	public Controller(View vista) {
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String comando = arg0.getActionCommand();
		switch (comando) {
		case "CONECTAR":
			conectar();
			break;
		case "LIMPIAR":
			vaciarCamposTxt();
			break;
		case "INSERTAR":
			insertar();
			break;
		case "LISTAR":
			vaciarTabla();
			new ObListado(vista.dtm);
			break;
		case "BUSCAR":
			buscar();
			break;
		case "BORRAR":
			borrar();
			break;
		case "MODIFICAR":
			modificar();
			break;
		case "SALIR": {
			// Si se ha realizado la conexion la podemos cerrar, en caso contrario salimos
			// sin cerrar la conexion
			if (Bd.getConexion() != null) {
				try {
					Bd.getConexion().close();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(vista.ventana,
							"Error al cerrar la base de datos: " + e1.getSQLState());
				}
			}
			System.exit(0);
			break;
		}
		}
	}
	public void conectar() {
		Bd bd = new Bd();
		if(!vista.txtUsuario.getText().equals("") && !vista.txtContrasenya.getText().equals("")){
			if(vista.txtUsuario.getText().equals(bd.usuario) && vista.txtContrasenya.getText().equals(bd.clave)) {
				vista.login.setVisible(false);
				new ObListado(vista.dtm);
				vista.colocarComponentesOperaciones();
			}
			else
				JOptionPane.showMessageDialog(vista.ventana, "Usuario o contraseña incorrectos");
		}else
			JOptionPane.showMessageDialog(vista.ventana, "Campos vacios, inserte datos");
	}
	
	private void insertar() {
		if(!vista.txtDNI.getText().equals("") && !vista.txtNombre.equals("") && !vista.txtApellido.equals("") && !vista.txtEdad.equals("")){
			ObRegistro registro = new ObRegistro(vista.txtDNI.getText(), vista.txtNombre.getText(), vista.txtApellido.getText(), Integer.parseInt(vista.txtEdad.getText()));
			if(new ObConsulta(registro.getDni()).posicionEncontrada() == -1){
				new ObInsercion(registro);
				JOptionPane.showMessageDialog(vista.ventana, "Insertado con exito");
				vaciarCamposTxt();
				vaciarTabla();
				new ObListado(vista.dtm);
			}else
				JOptionPane.showMessageDialog(vista.ventana, "Error. El DNI está duplicado");
		}else
			JOptionPane.showMessageDialog(vista.ventana, "Error. Faltan datos");
	}
	
	private void buscar() {
		if(!vista.txtDNI.getText().equals("")) {
			ObConsulta consulta = new ObConsulta(vista.txtDNI.getText());
			if(consulta.posicionEncontrada() != -1) {
				vaciarCamposTxt();
				vaciarTabla();
				ObRegistro registro = consulta.dameDatos();
				Object datos[] = {registro.getDni(), registro.getNombre(), registro.getApellido(), registro.getEdad()};
				vista.dtm.addRow(datos);
			}else
				JOptionPane.showMessageDialog(vista.ventana, "No se ha encontrado el DNI en la base de datos");
		}else
			JOptionPane.showMessageDialog(vista.ventana, "El campo DNI no puede estar vacio en una busqueda");	
	}
	
	private void borrar() {
		if(!vista.txtDNI.getText().equals("")) {
			ObConsulta consulta = new ObConsulta(vista.txtDNI.getText());
			int numFila = consulta.posicionEncontrada();
			if(numFila != 0){
				new ObBorrado(numFila);
				JOptionPane.showMessageDialog(vista.ventana, "Borrado con exito");
				vaciarCamposTxt();
				vaciarTabla();
				new ObListado(vista.dtm);
			}else{
				JOptionPane.showMessageDialog(vista.ventana, "El DNI introducido no coincide con ninguno almacenado");
			}
		}else
			JOptionPane.showMessageDialog(vista.ventana, "El campo DNI no puede estar vacio");	
	}

	public void modificar() {
		if(!vista.txtDNI.getText().equals("")){
			ObConsulta consulta = new ObConsulta(vista.txtDNI.getText());
			if(consulta.posicionEncontrada() != 0){
				if(!vista.txtNombre.equals("") && !vista.txtApellido.equals("") && !vista.txtEdad.equals("")){
					ObRegistro registroNuevo = new ObRegistro(vista.txtDNI.getText(), vista.txtNombre.getText(), vista.txtApellido.getText(), Integer.parseInt((vista.txtEdad.getText())));
					new ObModificacion(consulta.posicionEncontrada(),registroNuevo);
					vaciarCamposTxt();
					vaciarTabla();
					new ObListado(vista.dtm);
				}else
					JOptionPane.showMessageDialog(vista.ventana, "Error. Debe introducir datos");
			}else{
				JOptionPane.showMessageDialog(vista.ventana, "El DNI introducido no coincide con ninguno almacenado");
			}
		}else{
			JOptionPane.showMessageDialog(vista.ventana, "Introduzca un DNI para poder modificar un registro");
		}
	}
	
	public void vaciarCamposTxt(){
		vista.txtDNI.setText("");
		vista.txtNombre.setText("");
		vista.txtApellido.setText("");
		vista.txtEdad.setText("");
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void vaciarTabla(){
		for(int i = 0; i < vista.dtm.getRowCount(); i++){
			vista.dtm.removeRow(i);
			i -= 1;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
        //Recoger qué fila se ha pulsadao en la tabla
        int filaPulsada = this.vista.tabla.getSelectedRow();
        //Si se ha pulsado una fila
        if(filaPulsada>=0){
            //Se recoge el id de la fila marcada
        	ObConsulta consulta = new ObConsulta((String) this.vista.dtm.getValueAt(filaPulsada, 0));
            ObRegistro registro = consulta.dameDatos();
            vista.txtDNI.setText(registro.getDni());
            vista.txtNombre.setText(registro.getNombre());
            vista.txtApellido.setText(registro.getApellido());
            vista.txtEdad.setText(Integer.toString(registro.getEdad()));
        }
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
