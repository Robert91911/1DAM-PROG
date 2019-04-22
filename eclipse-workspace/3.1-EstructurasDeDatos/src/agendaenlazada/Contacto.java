package agendaenlazada;

public class Contacto implements Comparable
{
	private String nombre;
	private String numero;
	private String cadena;
	
	public Contacto(String nombre, String numero)
	{
		this.nombre = nombre;
		this.numero = numero;
	}

	public String getNumero() 
	{
		return numero;
	}

	public void setNumero(String numero) 
	{
		this.numero = numero;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	//////////////////////////
	public void mostrarDatos()
	{
		System.out.println(nombre + ": " + numero);
	}
	//////////////////////////
	public String toString()
	{
		cadena = nombre + " " + numero;
		return cadena;
	}
	//////////////////////////
	public boolean equals(Object otro)
	{
		Contacto contacto1 = (Contacto) otro;
		
		/*return (nombre.equals(contacto1.nombre) && numero.equals(contacto1.numero))
		 */
		return (cadena.equals(contacto1.cadena));
		
	}
	//////////////////////////
	public boolean equalsLorenzo(Contacto otroContacto)
	{
		return (nombre.equals(otroContacto.nombre) && numero.equals(otroContacto.numero));	
	}
	//////////////////////////
	public boolean equals(Contacto otroContacto)
	{
		return (nombre.equals(otroContacto.nombre) && numero.equals(otroContacto.numero));
	}
	//////////////////////////
	public int compareTo(Contacto otro)
	{
		return 0;
	}

	@Override
	public int compareTo(Object o) 
	{
		return 0;
	}
}

/* Metodo final, no se puede sobrecargar
 * Clase final, no puede tener subclases
 * Variable final, es una constante*/
