package programacionmodular;

import java.util.Scanner;

public class FactorialRecursivo 
{
/**
 * En este programa realizaremos un número factorial
 * usando recursividad.
 * @param args
 */
	
	//////////////////////////////////////
	public static void main(String[] args) 
	{
		//Pedimos un número
		int num = pedirNumero();
		//Calculamos el factorial
		int fact = factorial(num);
		//Mostramos por pantalla el resultado
		verResultado(num, fact);
	}
	/////////////////////////////////////
	public static int pedirNumero()
	{
		boolean numValido;
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce el número: ");
		int num;
		do
		{
			num = entrada.nextInt();
			numValido = (num >= 0);
			if (!numValido)
			System.out.println("Teclea un numero mayor o igual a 0");
		}while(!numValido);
		entrada.close();
		return num;
	}
	//////////////////////////////////////
	/**
	 * Calcula el factorial utilizando un método
	 * recursivo.
	 */
	public static int factorial(int num)
	{
		if(num == 0)
		{
			return 1;
		}
		
		
		return num * factorial(num - 1);
		
	}
	///////////////////////////////////////
	public static void verResultado(int num, int fact)
	{
		System.out.println("El factorial de " + num + " es " + fact);
	}

}
