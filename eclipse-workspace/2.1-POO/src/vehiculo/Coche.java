package vehiculo;

public class Coche extends Vehiculo 
{
	private int numeroPasajeros;
	/////////////////////////////////////////
	
	public Coche(int numeroRuedas, double autonomia, int numeroPasajeros) {
		super(numeroRuedas, autonomia);
		this.numeroPasajeros = numeroPasajeros;
	}
	//////////////////////////////////////////
	
	public Coche(Coche copia)
	{
		super(copia.numeroRuedas, copia.autonomia);
		numeroPasajeros = copia.numeroPasajeros;
	}
	
	//////////////////////////////////////////
	
	public int getNumeroPasajeros() {
		return numeroPasajeros;
	}

	public void setNumeroPasajeros(int numeroPasajeros) {
		this.numeroPasajeros = numeroPasajeros;
	}
	///////////////////////////////////////////
	
	public void verDatos()
	{
		System.out.println("Datos del coche: ");
		super.verDatos();
		System.out.println("Numero de pasajeros "+numeroPasajeros);
	}

}

