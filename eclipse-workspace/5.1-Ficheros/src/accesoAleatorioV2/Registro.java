package accesoAleatorioV2;

public class Registro 
{
	private String referencia;
	private String descripcion;
	private double precio;
	
	public Registro(String referencia, String descripcion, double precio)
	{
		this.referencia = referencia;
		this.descripcion = descripcion;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescricion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
}
