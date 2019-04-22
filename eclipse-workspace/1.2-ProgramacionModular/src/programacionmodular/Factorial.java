package programacionmodular;

import java.util.Scanner;

public class Factorial 
{
	static Scanner sc = new Scanner (System.in);
	//////////////////////////
	public static void main(String[] args) 
	{
		//Introducimos un número
		int num = pedirNumero();
		//Calculamos el factorial
		int factorial = calculaFactorial(num);
		//Ver resultados
		verResultado(num, factorial);
		

	}
	//////////////////////////
	private static int pedirNumero()
	{
		System.out.println("Introduce un número");
		return sc.nextInt();
	}
	//////////////////////////
	private static int calculaFactorial(int num)
	{
		int acum = 1;
			//Este bucle calcula el factor
			for(int cont = 1; cont <= num; cont ++)
				acum *= cont;
			return acum;
	}
	//////////////////////////
	public static void verResultado(int num, int factorial)
	{
		System.out.println("El factorial de " + num + " es " + factorial);
	}

}
