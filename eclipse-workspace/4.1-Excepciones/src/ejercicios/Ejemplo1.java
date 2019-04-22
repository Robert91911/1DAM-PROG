package ejercicios;

public class Ejemplo1 
{

	public static void main(String[] args) 
	{
		try 
		{
			long numeros [] = new long [1000000000];
		}
		catch (OutOfMemoryError error)
		{
			System.err.println("Error. No hay espacio suficiente.");
		}
	}

}
