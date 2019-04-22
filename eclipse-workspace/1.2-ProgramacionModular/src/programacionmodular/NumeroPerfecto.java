package programacionmodular;

import java.util.Scanner;


public class NumeroPerfecto {
	static Scanner entrada = new Scanner(System.in);
/**
 * Este programa indica si el numero es perfecto
 * @param args
 */
	public static void main(String[] args) 
	{
		int numero = pedirNumero();
		if(esPerfecto(numero))
			System.out.println(numero + " es perfecto");
		else
			System.out.println(numero + " no es perfecto");
		entrada.close();
	}
///////////////////////////////////////////////////
	private static int pedirNumero()
	{
		System.out.println("Introduce un numero:");
		return entrada.nextInt();
	}
//////////////////////////////////////////////////
	/**
	 * Un numero es perfecto cuando la suma de sus divisores
	 * propios es igaul al propio numero.
	 * Un divisor propio es aquel que implica que al dividir
	 * el numero por el divisor el resto es 0.
	 * @param numero
	 * @return
	 */
	private static boolean esPerfecto(int numero)
	{
		/*Acumulador para comprobar que la suma de
		los divisores propios son iguales o no al propio
		numero
		*/
		int acumu = 0;
		for(int i = 1; i <= numero/2; i++)
		{
			//Comprobamos si un numero es divisor propio de 6
			if(numero % i == 0)
				acumu = acumu + i;
		}
		
		//Comprobamos si el numero es perfecto
		if(acumu == numero)
			return true;
		
		return false;
	}
}
