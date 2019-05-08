package operacionesdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Modifica los datos de la base de datos sabiendo la posicion del regsitro y los
 * nuevos valores que queremos introducir 
 * @author robert
 *
 */

public class ObModificacion {
	
	public ObModificacion(int posicionDelRegistro, ObRegistro datos) {
		try{
			//Creo el Statement con la conexion realizada desde la Bd creada
			Statement stmt = Bd.getConexion().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			//Ejecuto una consulta sql y la almaceno
			ResultSet resultadoConsulta = stmt.executeQuery("SELECT * FROM DatosPersonales");
			
			//Realizo un bucle while y voy directamente a la posicion proporcionada
			resultadoConsulta.absolute(posicionDelRegistro);
			resultadoConsulta.updateString("DNI", datos.getDni());
			resultadoConsulta.updateString("Nombre", datos.getNombre());
			resultadoConsulta.updateString("Apellido", datos.getApellido());
			resultadoConsulta.updateInt("Edad", datos.getEdad());
			resultadoConsulta.updateRow();

			resultadoConsulta.close();
			stmt.close();
		}catch(SQLException e){
			System.out.println("Error de base de datos " + e.getMessage());
		};
	}
}
