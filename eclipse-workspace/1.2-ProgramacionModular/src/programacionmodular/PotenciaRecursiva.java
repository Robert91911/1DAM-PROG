package programacionmodular;

import java.util.Scanner;

public class PotenciaRecursiva 
{

	static Scanner entrada = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		
		int base = pedirBase();
		int exp = pedirExp();
		int poten = potencia(base, exp);
		verResult(base, exp, poten);
	}
	
	//////////////////////////
	private static int pedirBase()
	{
	System.out.println("Introduce la base:");
	return entrada.nextInt();
	}
	
	//////////////////
	private static int pedirExp()
	{
		System.out.println("Introduce el exponente.");
		return entrada.nextInt();
	}
	
	//////////////////
	private static int potencia(int base, int exp)
	{
		if (exp == 0)
		{
			return 1;
		}
		return base * potencia(base, exp -1);
	
	}
	
	/////////////////
	public static void verResult(int base, int exp, int poten)
	{
		System.out.println(base + " elevado a " + exp + " es " + poten);
	}
}

