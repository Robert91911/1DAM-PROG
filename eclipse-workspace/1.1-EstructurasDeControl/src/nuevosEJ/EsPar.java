package nuevosEJ;

import java.util.Scanner;

public class EsPar {

	/**
	 * Este programa nos dice si un numero es par o impar.
	 * @param args
	 */
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) 
	{
		int numero;
		System.out.println("Introduce un numero decimal");
		numero = sc.nextInt();
		if(numero % 2 == 0)
			System.out.println("El numero es par");
		else
			System.out.println("El numero es impar");
	}

}
