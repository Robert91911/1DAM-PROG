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

	ObRegistro datosPersona;
	boolean encontrado = false;
	int posicion = 1;
	
	public ObConsulta(String dniPedido) {
		String nombre, apellido;
		int edad;
		try {
			//Creo el Statement con la conexion realizada desde la Bd creada
			Statement stmt = Bd.getConexion().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			//Ejecuto una consulta sql y la almaceno
			ResultSet resultadoConsulta = stmt.executeQuery("SELECT * FROM DatosPersonales");
			
			while(resultadoConsulta.next()){
				if(resultadoConsulta.getString("DNI").equals(dniPedido)){
					encontrado = true;
					nombre = resultadoConsulta.getString("Nombre");
					apellido = resultadoConsulta.getString("Apellido");
					edad = resultadoConsulta.getInt("Edad");
					datosPersona = new ObRegistro(dniPedido, nombre, apellido, edad);
					break;
				}
				posicion++;
			}
			//Cierro la consulta y el Statement
			resultadoConsulta.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public void buscar() {

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
