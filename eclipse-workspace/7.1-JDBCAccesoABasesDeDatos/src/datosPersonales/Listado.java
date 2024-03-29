package datosPersonales;

import java.sql.*;

public class Listado {
	static String bd = "DATOS";
	static String login = "robert9191";
	static String password = "Clave_00";
	static String url = "jdbc:mysql://localhost/" + bd;

	public static void main(String[] args) {
		// Hay que memorizarlo para el examen
		String Nombre, Apellido, DNI;
		int Edad;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String BaseDeDatos = "DATOS";
			Connection Conexion = DriverManager.getConnection(url, login, password);
			Statement SentenciaSQL = Conexion.createStatement();
			ResultSet Personas = SentenciaSQL.executeQuery("SELECT * FROM DatosPersonales");
			while (Personas.next()) {
				DNI = Personas.getString("DNI");
				Nombre = Personas.getString("Nombre");
				Apellido = Personas.getString("Apellido");
				Edad = Personas.getInt("Edad");
				System.out.println(Nombre + " " + Apellido + ", " + Edad + ", " + DNI);
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