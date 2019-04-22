package manejarapi;

import java.util.Scanner;

public class ClaseString 
{

	public static void main(String[] args) 
	{
		String S = "Hola Mundo";
		String S1 = "Hola Mundo";
		String S2 = "Hola Mundo";
		String S3 = "Hola mundo";
		////////////////////////////////////////////////////////
		System.out.println("La longitud de S es " + S.length());
		System.out.println("El carácter que está en la cuarta posición de S es " + "Hola Mundo".charAt(3));
		if(S1.equals(S2))
			System.out.println("S1 y S2 son iguales.");
		else
			System.err.println("S1 y S2 no son iguales.");
		if(S1.compareTo(S2) == 0)
			System.out.println("S1 y S2 son alfabéticamente iguales.");
		else
			System.err.println("S1 y S2 no son alfabéticamente iguales.");
		/////////////////////////////////////////////////////
		if(S1.equalsIgnoreCase(S3))
			System.out.println("S1 y S3 son iguales.");
		else
			System.err.println("S1 y S3 no son iguales.");
		/////////////////////////////////////////////////////////
		if(S2.equals(S3))
			System.out.println("S2 y S3 son léxicamente iguales.");
		else
			System.err.println("S2 y S3 no son léxicamente iguales.");
		//////////////////////////////////////////////////////////////
		System.out.println("La posición de U en la cadena Hola Mundo es " + S.indexOf('u'));
		//////////////////////////////////////////////////////////////////////////////////////
		double num1 = 5.6;
		String Num = String.valueOf(num1);
		System.out.println("El valor de NUM es: " + Num);
		/////////////////////////////////////////////////////////////////////////////////////
		S2 = S2.replace('o', 'e');
		System.out.println(S2);
		/////////////////////////////////////////////////////////////////////////////////////
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);
		System.out.println("Introduzca la cadena deseada: ");
		String Cadena = leer.nextLine();
		StringBuilder Obj = new StringBuilder(Cadena);
		String cadenaInversa = Obj.reverse().toString();
		System.out.println("Cadena invertida: " + cadenaInversa);
		///////////////////////////////////////////////////////////////////////////////////////
	}
}
