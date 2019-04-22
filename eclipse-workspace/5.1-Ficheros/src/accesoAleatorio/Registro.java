package accesoAleatorio;

public class Registro 
{
	private String referencia;
	private String nombre;
	private double precio;
	
	public Registro(String referencia, String nombre, double precio)
	{
		this.referencia = referencia;
		this.nombre = nombre;
		this.precio = precio;
	}
	
	public Registro() 
	{
		
	}


	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
}
