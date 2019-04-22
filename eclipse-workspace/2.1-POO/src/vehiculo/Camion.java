package vehiculo;

public class Camion extends Vehiculo
{
	private double limiteCarga;
	/////////////////////////////////
	
	public Camion(int numeroRuedas, double autonomia, double limiteCarga) {
		super(numeroRuedas, autonomia);
		this.limiteCarga = limiteCarga;
	}
	public void setLimiteCarga(double limiteCarga) {
		this.limiteCarga = limiteCarga;
	}
	
	////////////////////////////////
	public double getLimiteCarga() {
		return limiteCarga;
	}
	/////////////////////////////////
	
	public void verDatos()
	{
		System.out.println("Datos del camion");
		super.verDatos();
		System.out.println("Limite de carga: "+limiteCarga);
	}
}
