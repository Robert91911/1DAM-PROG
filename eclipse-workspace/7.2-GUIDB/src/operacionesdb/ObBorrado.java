package operacionesdb;

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
	int posicionBuscada;
	
	public ObBorrado(int posicionBuscada) {
		this.posicionBuscada = posicionBuscada;
		borrar();
	}

	private void borrar() {
		try {
			Statement stmt = Bd.getConexion().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			ResultSet resultadoConsulta = stmt.executeQuery("SELECT * FROM DatosPersonales");
			
			resultadoConsulta.absolute(posicionBuscada);
			resultadoConsulta.deleteRow();
			
			resultadoConsulta.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error SQL."+e);
		}
	}
}
