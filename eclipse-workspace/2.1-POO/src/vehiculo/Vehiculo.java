package vehiculo;

public class Vehiculo 
{
	protected int numeroRuedas;
	protected double autonomia;
	///////////////////////////////////////
	
	public Vehiculo(int numeroRuedas, double autonomia) 
	{
		this.numeroRuedas = numeroRuedas;
		this.autonomia = autonomia;
	}
	//////////////////////////////////////
	
	public int getNumeroRuedas() {
		return numeroRuedas;
	}
	public void setNumeroRuedas(int numeroRuedas) {
		this.numeroRuedas = numeroRuedas;
	}
	public double getAutonomia() {
		return autonomia;
	}
	public void setAutonomia(double autonomia) {
		this.autonomia = autonomia;
	}
	///////////////////////////////////////
	
	public void verDatos()
	{
		System.out.println("Rueda: "+numeroRuedas);
		System.out.println("Autonomía: "+autonomia);
	}
	
}
