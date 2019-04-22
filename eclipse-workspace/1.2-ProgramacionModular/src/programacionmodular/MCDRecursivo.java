package programacionmodular;

import java.util.Scanner;

public class MCDRecursivo 
{
		static Scanner sc = new Scanner(System.in);
		//////////////////////////
		public static void main(String[] args) 
		{
			int num1 = pedirNumero();
			int num2 = pedirNumero();
			int mcd = calcularMcd(num1, num2);
			verResultado(mcd, num1, num2);
		}
		//////////////////////////
		private static int pedirNumero()
		{
			System.out.println("Introduce un número");
			return sc.nextInt();
		}
		//////////////////////////
		private static int calcularMcd(int num1, int num2)
		{
			if (num1 == num2)
				return num1;
			
			if (num1 > num2) 
			{
				return calcularMcd(num1 - num2, num2);
			}
			else 
			{
				return calcularMcd(num1, num2 - num1);
			}			
			
		}
		//////////////////////////
		public static void verResultado(int mcd, int num1, int num2)
		{
			System.out.println("El MCD de " + num1 + " y " + num2 + " es " + mcd);
		}
}
