package datosPersonales;

import java.sql.*;

public class Borrado {
	static String bd = "DATOS";
	static String login = "robert9191";
	static String password = "Clave_00";
	static String url = "jdbc:mysql://localhost/" + bd;

	public static void main(String[] args) {
		String Nombre, Apellido;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String BaseDeDatos = "DATOS";
			Connection Conexion = DriverManager.getConnection(url, login, password);
			Statement SentenciaSQL = Conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet Personas = SentenciaSQL.executeQuery("SELECT * FROM DatosPersonales");

			while (Personas.next()) {
				Nombre = Personas.getString("Nombre");
				Apellido = Personas.getString("Apellido");
				if (Apellido.equalsIgnoreCase("Cela") && Nombre.equalsIgnoreCase("Pedro")) {
					System.out.println("Registro eliminado");
					Personas.deleteRow();
					break;
				}
			}
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