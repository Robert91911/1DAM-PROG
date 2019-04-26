package datosPersonales;

import java.sql.*;

public class Modificar {
	static String bd = "DATOS";
	static String login = "robert9191";
	static String password = "Clave_00";
	static String url = "jdbc:mysql://localhost/" + bd;

	public static void main(String[] args) {
		String Nombre, Apellido, DNI;
		int Edad;
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
					// IMPORTANTE: por cada getXxxxx("Campo") hay que realizar
					// un updateXxxxx("Campo")
					Personas.updateString("Nombre", "Luis");
					Personas.updateString("Apellido", "Reverte");
					Personas.updateInt("Edad", 45);
					Personas.updateString("DNI", "47645876F");
					Personas.updateRow();
					System.out.println("Registro modificado");
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