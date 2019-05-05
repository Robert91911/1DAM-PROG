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

	private DatosConexion datConex = new DatosConexion();
	private ObRegistro registro = new ObRegistro(); 
	
	public ObInsercion(ObRegistro registro) {
		this.registro = registro;
	}
	
	public void insertar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String BaseDeDatos = "DATOS";
			Connection Conexion = DriverManager.getConnection(datConex.getUrl(), datConex.getLogin(), datConex.getPassword());
			Statement SentenciaSQL = Conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet Personas = SentenciaSQL.executeQuery("SELECT * FROM DatosPersonales");

			Personas.moveToInsertRow();
			Personas.updateString("DNI", registro.getDni());
			Personas.updateString("Nombre", registro.getNombre());
			Personas.updateString("Apellido", registro.getApellido());
			Personas.updateInt("Edad", registro.getEdad());
			Personas.insertRow();
			// Personas.moveToCurrentRow();

			Personas.close();
			Conexion.close();
			SentenciaSQL.close();
		} catch (ClassNotFoundException e) {
			System.out.println("Clase no encontrada");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	//MÉTODOS
	//moveToInsertRow
	
	//insertRow
}
