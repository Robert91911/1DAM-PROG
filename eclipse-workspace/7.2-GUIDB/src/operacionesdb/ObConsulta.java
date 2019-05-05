package operacionesdb;

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
	private ObRegistro DatosPersona = new ObRegistro();
	private String DNIPedido;
	
	public ObConsulta(String DNIPedido) {
		this.DNIPedido = DNIPedido;
	}
	
	public void buscar() {
		
	}
}
