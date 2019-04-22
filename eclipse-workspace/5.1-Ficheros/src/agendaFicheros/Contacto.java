package agendaFicheros;

import java.io.Serializable;

/**
 * <h1>
 * Contacto
 * </h1>
 * <p>Clase la cual nos sirve para realizar todo tipo de acciones sobre un
 * contacto.</p>
 * 
 * @author alumno
 *
 */

public class Contacto implements Comparable, Serializable {
	private String nombre;
	private String telefono;
	

	/**
	 * Constructor que sirve para crear un nuevo contacto.
	 * 
	 * @param nombre   Nombre del contacto
	 * @param telefono Numero del telefono.
	 */
	public Contacto(String nombre, String telefono) {
		this.nombre = nombre;
		this.telefono = telefono;
	}

	/**
	 * Metodo que devuelve el numero de telefono.
	 * 
	 * @return telefono, devuelve el numero de telefono.
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Metodo para crear un telefono de un contacto
	 * 
	 * @param telefono Numero de telefono del contacto
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Metodo que devuelve el numero de telefono de un contacto.
	 * 
	 * @return nombre Nombre del contacto
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo para crear un nombre de un contacto
	 * 
	 * @param nombre Nombre del contacto.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo que devuelve el nombre y el telefono con '(' y ')'.
	 * 
	 * @return devuelve un string con el nombre y el telefono.
	 */
	public String toString() { // este m�todo dobrecargado muestra los atributos de la clase
		return this.nombre + " (" + this.telefono + ")";
	}

	/**
	 * Metodo que sirve para comparar dos contactos y ver si el nombre y el telefono
	 * son iguales.
	 * 
	 * @param otro contacto a comparar
	 * @return devuelve true si son iguales y false en caso contrario.
	 */
	public boolean equals(Contacto otro) {

		return (nombre.equals(otro.nombre) && otro.telefono.equals(telefono));

	}

///////////////////////////////////
	/**
	 * Metodo sobreescrito, sirve para comparar dos contactos si tienen el nombre y
	 * el telefono iguales.
	 * 
	 * @return devuelve un true si son iguales y un false si son diferentes.
	 */
	public boolean equals(Object otro) {
		Contacto contacto = (Contacto) otro;
		return (nombre.equals(contacto.nombre) && telefono.equals(contacto.telefono));

	}

////////////////////////////////////
	/**
	 * Metodo que se utilizara para buscar un contacto en la Agenda.
	 * 
	 * @param other contacto que usamos para buscarlo en la agenda
	 * @return devuelve la posicion de ese contacto
	 */
	public int compareTo(Contacto other) {

		return this.nombre.compareTo(other.getNombre());

	}

	/////////////////////////////////////////

	@Override
	/**
	 * Metodo sobreescrito que se utilizara para buscar un contacto en la Agenda.
	 * 
	 * @param arg0 Objeto que luego utilizaremos como un Contacto
	 * @return devuelve la posicion de ese contacto
	 */
	public int compareTo(Object arg0) {
		Contacto contacto = (Contacto) arg0;
		return (nombre.compareTo(contacto.nombre));
	}

	/////////////////////////////////////////
	/**
	 * Metodo para ver los datos de un contacto.
	 */
	public void mostrarDatos() {
		System.out.println(nombre + "\t" + telefono);
	}
}
