package operacionesdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Consulta los datos propocionandole un DNI tendrá que guardar la posicion y el regirtro que se encuentra el registro
 * tambien dispone de los metodos: 
 * posicionEncontrada que devuelve la posicion
 * dameDatos Que devuelve un objeto tipo registro
 * @author robert
 *
 */

public class ObConsulta {

	private int posicion;
	private String DNIPedido;
	private ObRegistro datosPersona = new ObRegistro();
	private DatosConexion conexion = new DatosConexion();
	private boolean encontrado = false;
	
	public ObConsulta(String DNIPedido) {
		this.DNIPedido = DNIPedido;
		buscar();
	}
	
	public void buscar() {
		String Nombre, Apellido, DNI;
		int Edad;
		posicion = 1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String BaseDeDatos = "DATOS";
			Connection Conexion = DriverManager.getConnection(conexion.getUrl(), conexion.getLogin(), conexion.getPassword());
			Statement SentenciaSQL = Conexion.createStatement();
			ResultSet Personas = SentenciaSQL.executeQuery("SELECT * FROM DatosPersonales");
			while (Personas.next()) {
				DNI = Personas.getString("DNI");
				if(DNI.equals(DNIPedido)) {
					Nombre = Personas.getString("Nombre");
					Apellido = Personas.getString("Apellido");
					Edad = Personas.getInt("Edad");
					encontrado = true;
					datosPersona.setDni(DNI);
					datosPersona.setNombre(Nombre);
					datosPersona.setApellido(Apellido);
					datosPersona.setEdad(Edad);
					break;
				}
				posicion++;
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
	
	public int posicionEncontrada()	{
		if(encontrado) {
			return posicion;
		}else
			return -1;
	}
	
	public ObRegistro dameDatos() {
		if(encontrado)
			return datosPersona;
		else
			return null;
	}
}
