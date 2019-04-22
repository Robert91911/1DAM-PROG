package crearListaTfnosSerializable;

import java.io.Serializable;

public class Persona implements Serializable
{

	private String nombre;
	private String direccion;
	private String telefono;

public Persona(String nombre, String direccion, String telefono) {
	super();
	this.nombre = nombre;
	this.direccion = direccion;
	this.telefono = telefono;
}
public Persona() {
	
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getDireccion() {
	return direccion;
}

public void setDireccion(String direccion) {
	this.direccion = direccion;
}

public String getTelefono() {
	return telefono;
}

public void setTelefono(String telefono) {
	this.telefono = telefono;
}

}