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

	private DatosConexion conexion = new DatosConexion();
	private int posicionDelRegistro;
	private ObRegistro datos = new ObRegistro();
	
	public ObModificacion(int posicionDelRegistro, ObRegistro datos) {
		this.posicionDelRegistro = posicionDelRegistro;
		this.datos = datos;
		modificar();
	}
	
	public void modificar() {
		String Nombre, Apellido, DNI;
		int Edad;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String BaseDeDatos = "DATOS";
			Connection Conexion = DriverManager.getConnection(conexion.getUrl(), conexion.getLogin(), conexion.getPassword());
			Statement SentenciaSQL = Conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet Personas = SentenciaSQL.executeQuery("SELECT * FROM DatosPersonales");
			
			Personas.absolute(posicionDelRegistro);
				Nombre = Personas.getString("Nombre");
				Apellido = Personas.getString("Apellido");

					Personas.updateString("Nombre", datos.getNombre());
					Personas.updateString("Apellido", datos.getApellido());
					Personas.updateInt("Edad", datos.getEdad());
					Personas.updateString("DNI", datos.getDni());
					Personas.updateRow();
					System.out.println("Registro modificado");

			Personas.close();
			Conexion.close();
			SentenciaSQL.close();
		} catch (ClassNotFoundException e) {
			System.out.println("Clase no encontrada");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
