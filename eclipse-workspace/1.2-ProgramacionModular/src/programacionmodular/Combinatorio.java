package programacionmodular;

import java.util.Scanner;

public class Combinatorio 
{
	static Scanner entrada = new Scanner (System.in);
	public static void main(String[] args) 
	{
		int m = pedirM();
		int n = pedirN(m);
		int combinacion = calcularComb(m, n);
		verResultado(m, n, combinacion);
	}
	//////////////////////////
	private static int pedirM() 
	{	
		boolean mValido;
		System.out.println("Introduce un valor para m");
		int num;
		do 
		{
			num = entrada.nextInt();
			mValido = (num >= 0);
			if (!mValido)	
			{
			System.out.println("m no puede ser negativo, introduce un valor valido");
			}
		}while(!mValido);
		return num;
	}
	//////////////////////////
	private static int pedirN(int m) 
	{
		boolean nValido;
		System.out.println("Introduce un valor para n");
		int num;
		do 
		{
			num = entrada.nextInt();
			nValido = (num >= 0 && num <= m );
			if (!nValido)	
			System.out.println("n no puede ser negativo o mayor que m, introduce un valor valido");
		}while(!nValido);
		return num;
	}
	//////////////////////////
	private static int factorial(int num)
	{
		if (num==0)
			return 1;
		return num * factorial(num -1);
	}
	//////////////////////////
	private static int calcularComb(int m, int n)
	{
		return factorial(m) / (factorial(n) * factorial(m - n));
	}
	public static void verResultado(int m, int n, int combinacion)
	{
		System.out.println("El combinatorio de " + m + " y " + n + " es igual a " + combinacion);
	}
}
