package consultaDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Bd {
	public String usuario = "robert9191";
	public String clave = "Clave_00";
	private String url = "jdbc:mysql://localhost:3306/DATOS";
	private static Connection conexion = null;
	
	public Bd() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			System.out.println("Driver no encontrado "+e.getMessage());
			System.exit(-1);
		}
		try {
			conexion = DriverManager.getConnection(url, usuario, clave);
		}catch (SQLException e) {
			System.out.println("Error SQL. "+e);
		}
	}
	
	public static Connection getConexion() {
		return conexion;
	}
}
