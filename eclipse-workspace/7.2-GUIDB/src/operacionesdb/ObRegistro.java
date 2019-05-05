package operacionesdb;

/**
 * Clase que guarda cada registro (fila) de la tabla
 * Los datos se pasan al objeto por el contructor los datos tienen que tener los metodos get correspondientes
 * @author robert
 *
 */

public class ObRegistro {
	
	private String dni;
	private String nombre;
	private String apellido;
	private int edad;
	
	
	public ObRegistro(String dni, String nombre, String apellido, int edad) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}

	public ObRegistro() {
		
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
}
