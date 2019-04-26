package datosPersonales;

import java.sql.*;

public class Insercion {

	static String bd = "DATOS";
	static String login = "robert9191";
	static String password = "Clave_00";
	static String url = "jdbc:mysql://localhost/" + bd;

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String BaseDeDatos = "DATOS";
			Connection Conexion = DriverManager.getConnection(url, login, password);
			Statement SentenciaSQL = Conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet Personas = SentenciaSQL.executeQuery("SELECT * FROM DatosPersonales");

			Personas.moveToInsertRow();
			Personas.updateString("DNI", "50839979M");
			Personas.updateString(2, "Pedro");
			Personas.updateString("Apellido", "Cela");
			Personas.updateInt("Edad", 78);
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

}