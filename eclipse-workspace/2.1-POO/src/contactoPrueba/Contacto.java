package contactoPrueba;


public class Contacto implements Comparable<Object>{
	private String nombre;
	private String telefono;
	
	public Contacto(String nombre, String telefono) {
		this.nombre = nombre;
		this.telefono = telefono;
	}
	/**
	 * Metodos set y get
	 * @return
	 */
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	/**
	 * Envia a pantalla los datos de un contacto
	 */
	
	
	public void verDatos(){
		System.out.println("+----------------------+");
		System.out.println("| Datos del contacto:  |");
		System.out.println("+----------------------+");
		System.out.println();
		System.out.println(">Nombre: "+ nombre);
		System.out.println(">Telefono: "+ telefono);
		System.out.println();
		
	}
	
	//sobrecarga de toString
	
	public String toString()
	{
		String cadena = "Contacto:"+ nombre + " teléfono: "+ telefono;
		return cadena;
	}
	
	//sobrecarga de equals
	
	public boolean equals(Contacto otroContacto)
	{
		
		if(nombre.equals(otroContacto.nombre) &&
			telefono.equals(telefono))
			return true;
		
		return false;
	}
	@Override
	public int compareTo(Object obj)
	{
		
		Contacto contacto = (Contacto)obj;
			
		if(nombre.compareTo(contacto.nombre)> 0)	
			return 1;
		if(nombre.compareTo(contacto.nombre)< 0)
			return -1;
		return 0;
		
	}
}


