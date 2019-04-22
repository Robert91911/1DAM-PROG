package programacionmodular;

import java.util.Scanner;

public class MCD {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int num1 = pedirNumero();
		int num2 = pedirNumero();
		int mcd =  calcularMcd(num1, num2);
		verResultado(num1, num2, mcd);
		

	}
//////////////////////////////////////////////////
	private static int pedirNumero()
	{
		System.out.println("Introduce el numero: ");
		return sc.nextInt();
	}
//////////////////////////////////////////////////
	private static int calcularMcd(int num1, int num2)
	{
		while(num1 != num2)
		{
			if(num1 > num2)
				num1 = num1 - num2;
			else
				num2 = num2 - num1;
		}
	return num1;
	}
//////////////////////////////////////////////////
	private static void verResultado(int num1, int num2, int mcd)
	{
		System.out.println("El MCD de " + num1 + " y " + num2 +  " es " + mcd);
	}
//////////////////////////////////////////////////
	
//////////////////////////////////////////////////
}
