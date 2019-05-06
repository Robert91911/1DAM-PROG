package operacionesdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Esta clase recibe la posicionBuscada y con esa posicion borra esa fila
 * de la base de datos
 * @author robert
 *
 */

public class ObBorrado {
	private DatosConexion conexion = new DatosConexion();
	int posicionBuscada;
	
	public ObBorrado(int posicionBuscada) {
		this.posicionBuscada = posicionBuscada;
		borrar();
	}

	private void borrar() {
		String Nombre, Apellido;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String BaseDeDatos = "DATOS";
			Connection Conexion = DriverManager.getConnection(conexion.getUrl(), conexion.getLogin(), conexion.getPassword());
			Statement SentenciaSQL = Conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet Personas = SentenciaSQL.executeQuery("SELECT * FROM DatosPersonales");

			
			Personas.absolute(posicionBuscada);
				System.out.println("Registro eliminado");
				Personas.deleteRow();
				
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
