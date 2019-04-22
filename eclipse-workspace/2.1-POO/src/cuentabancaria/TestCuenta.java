package cuentabancaria;

public class TestCuenta 
{
	
	public static void main(String[] args) 
	{
		Cuenta cuenta1 = new Cuenta ("Lorenzo", "ES203232", 0.05, 300);
		Cuenta cuenta2 = new Cuenta(cuenta1);
		System.out.println("El saldo de cuenta 1 es: " + cuenta1.getSaldo());
		System.out.println("El saldo de la cuenta 2 es: " + cuenta2.getSaldo());
		System.out.println("El nombre de la cuenta 2 es: " + cuenta2.getNombre());
		cuenta1.ingreso(100);
		cuenta1.reintegro(50);
		System.out.println("El saldo de la cuenta 1 es: " + cuenta1.getSaldo());	
	}
}
