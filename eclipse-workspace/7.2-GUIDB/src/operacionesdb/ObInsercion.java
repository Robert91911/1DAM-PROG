package operacionesdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Esta clase introduce los datos individuales de la clase ObRegistro en los
 * campos de la tabla
 * @author robert
 *
 */

public class ObInsercion {
	
	public ObInsercion(ObRegistro registro) {
		try {
			Statement conexion = Bd.getConexion().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			ResultSet personas = conexion.executeQuery("SELECT * FROM DatosPersonales");
			
			personas.moveToInsertRow();
			personas.updateString("DNI", registro.getDni());
			personas.updateString("Nombre", registro.getNombre());
			personas.updateString("Apellido", registro.getApellido());
			personas.updateInt("Edad", registro.getEdad());
			personas.insertRow();
			
			personas.close();
			conexion.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
}
	
