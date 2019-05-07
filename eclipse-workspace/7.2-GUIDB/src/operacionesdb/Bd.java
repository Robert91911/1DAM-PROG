package operacionesdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Bd {

	private String  maquina     = "localhost";
	public String  usuario     		= "robert9191";
	public String  clave       		= "Clave_00";
    private int puerto          = 3306;
    private String  servidor    = "";
    private static Connection conexion  = null;
    
    public Bd(){
    	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver no encontrado " + e.getMessage());
			System.exit(-1);
		}
		try {
			conexion = DriverManager.getConnection(
					   "jdbc:mysql://localhost:3306/DATOS", "robert9191", "Clave_00");
		} catch (SQLException e) {
			JOptionPane panel = new JOptionPane("Error base de datos");
		}
    }
	
	public static Connection getConexion(){
		return conexion;
	}
}