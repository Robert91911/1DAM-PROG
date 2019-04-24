package comandoGrepConJava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GrepV1 
{

	public static void main(String[] args) throws IOException 
	{
		try
		{
			if(args.length < 2)
				throw new ArgumentosErroneos();
			else
			{
				for(int i = 1; i < args.length; i++)
				{
					File fichero = new File(args[i]);
					if (fichero.exists())
						buscarPalabra(fichero, args[0]);
					else
						throw new FileNotFoundException();
				}
			}
		}
		catch(ArgumentosErroneos error)
		{
			System.err.println("Número de argumentos incorrecto");
			System.err.println("Sintaxis: ");
			System.err.println(" java Grep palabra nomFich1...nomFichn");
		}
		catch(FileNotFoundException error)
		{
			System.out.println("Fichero no encontrado");
		}
	}

	private static void buscarPalabra(File fichero, String palabra) 
	{
		BufferedReader leer = null;
		try
		{
			leer = new BufferedReader(new FileReader(fichero));
			String linea;
			int cont = 1;
			boolean encontrado = false;
			System.out.println("Nombre fichero: " + fichero.getName());
			while((linea = leer.readLine()) != null)
			{
				
				if(linea.indexOf(palabra) != -1)
				{
					encontrado = true;
					if(encontrado)
					{
						System.out.println("La linea que contiene la palabra es: " + linea);
						System.out.println("El número de linea: " + cont);
					}
				}
				cont++;
			}
			if(!encontrado)
			{
				System.out.println("El archivo no contiene la palabra a buscar");
			}
		}
		catch (IOException e) 
		{
			System.err.println("Error al cerrar el flujo de datos.");
		}
		finally
		{
			
			try 
			{
				leer.close();
			} 
			catch (IOException e) 
			{
				System.err.println("Error al cerrar el flujo de datos.");
			}
			
		}
	}
}
class ArgumentosErroneos extends Exception
{
	public ArgumentosErroneos()
	{
		super();
	}
}