package examenficheros.esnumeroperfecto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EsNumeroPerfecto 
{
	public static void main(String[] args) 
	{
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Introduce un número entero: ");
			int numero = Integer.parseInt(br.readLine());
			if(esPerfecto(numero))
				System.out.println(numero+" es perfecto.");
			else
				System.out.println(numero+" no es perfecto");
		}
		catch(IOException e)
		{
			System.err.println(e.getMessage());
		}
		catch(NumberFormatException e)
		{
			System.out.println("Error: no es un numero entero.");
		}
	}

	private static boolean esPerfecto(int numero) 
	{
		int acum = 0;
		for(int i = 1; i<numero; i++)
		{
			if((numero%i)==0)
				acum += i;
		}
		if(acum == numero)
			return true;
		else
			return false;
	}
}
