package vehiculo;

public class TestVehiculo{

	public static void main(String[] args) 
	{
		Coche coche1 = new Coche(4, 1000, 2);
		coche1.verDatos();
		System.out.println();
		/////////////////////////
		Camion camion1 = new Camion(6, 5000, 2000);
		camion1.verDatos();
		System.out.println(camion1.getClass());
		Vehiculo vehiculo = coche1;
		vehiculo.verDatos();
		Coche coche2 = new Coche(coche1);
		coche2.verDatos();
		
	}

}
