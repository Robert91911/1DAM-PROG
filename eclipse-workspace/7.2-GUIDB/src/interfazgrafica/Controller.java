package interfazgrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import modelovistacontrolador.Bd;

public class Controller implements ActionListener,MouseListener{

	private View view;
	
	Controller(View view) {
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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

	 protected void cargarTabla(){
	        //Objeto para ejecutar los procedimientos almacenados en la base de datos
	        CallableStatement cs;
	        //Objeto para recoger los datos devueltos por el procedimiento almacenado
	        ResultSet rs;
	        //Objeto para recorrer el resultado del procedimiento almacenado y
	        //  añadirlo a la tabla definida en la clase View
	        Vector<Object> fila;
	 
	        //Limpiar los datos de la tabla
	        for(int i=this.view.dtm.getRowCount(); i>0; i--){
	            this.view.dtm.removeRow(i-1);
	        }
	 
	        //Cargar datos en la tabla
	        try {
	            //Preparar la llamada
	            cs  = Bd.getConexion().prepareCall(
	                            "{CALL getClientes()}");
	            //Ejecutarla y recoger el resultado
	            rs  = cs.executeQuery();
	            //Recorrer el resultado
	            while(rs.next()){
	                //Añadir registro a registro en el vector
	                fila    = new Vector<Object>();
	                fila.add(rs.getInt("id"));
	                fila.add(rs.getString("nombre"));
	                fila.add(rs.getString("nif"));
	                //Añadir el vector a la tabla de la clase View
	                this.view.dtm.addRow(fila);
	            }
	 
	        } catch (SQLException e) {
	            System.err.println("Error al CARGAR DATOS");
	        }
	    }

}
