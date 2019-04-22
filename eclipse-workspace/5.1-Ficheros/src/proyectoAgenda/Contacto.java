package proyectoAgenda;

import java.io.Serializable;

public class Contacto implements Comparable,Serializable
{
	private String nombre;
	private String numero;
	
	////////////////////
	public Contacto(String nombre, String numero)
	{
		this.nombre=nombre;
		this.numero=numero;
	}
	/////////////////////
	public String getNombre()
	{
		return nombre;
	}
	//////////////////////
	public void setNombre(String nombre)
	{
		this.nombre=nombre;
	}
	/////////////////////////
	public String getNumero()
	{
		return numero;
	}
	//////////////////////////
	public void setNumero(String numero)
	{
		this.numero=numero;
	}
	/////////////////////////
	public String toString()
	{
		return this.nombre +" (" +this.numero+")";
	}
	/////////////////////////
	public boolean equals (Contacto otro)
	{
		return (nombre.equals(otro.getNombre()) && numero.equals(otro.numero));
	}
	//////////////////////////
	public boolean equals (Object otro)
	{
		Contacto contacto = (Contacto) otro;
		return (nombre.equals(contacto.nombre) && (numero.equals(contacto.numero)));
	}
	/////////////////////////////
	public boolean equalsJose (Contacto otro)
	{
		return (nombre.equals(otro.getNombre()) && numero.equals(otro.numero));
	}
	////////////////////////////////
	@Override
	public int compareTo(Object arg0) 
	{
		Contacto contacto = (Contacto) arg0;
		return (nombre.compareTo(nombre));
	}
	//////////////////////////////////
	public void mostrarDatos()
	{
		System.out.println(nombre + " " + numero);
	}
}