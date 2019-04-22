package ejercicio2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ejercicio2 
{
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws IOException
	{
		// Comprobamos si el numero de argumentos es correcto.
		try 
		{
		if (args.length != 1) 
			{
			// Lanzamos la excepcion
			throw new ErrorArgumentos();
			}
		else {
			for (int i = 0; i < args.length; i++) {

				File fichero = new File(args[i]);
				
					if (!fichero.exists()) 
					{
						crear(fichero);
					} else 
					{
						System.out.println("Desea sobreescribir el fichero? [S/N]");
						char respuesta = (char)System.in.read();
						System.in.skip(2);
						if(respuesta == 'S' | respuesta == 's')	
						{
							escribir(fichero);
						}else
							System.out.println("El archivo no se sobreescribirá");
					}
				} 
			}
		}catch (ErrorArgumentos error) {
			System.err.println("Error en el numero de argumentos");
			System.err.println("Sintaxis:");
			System.err.println("java PropiedadesFichero nomFich1... nomFichx");
		}

	}

	private static void escribir(File fichero) 
	{
	
	}

	private static void crear(File fichero) throws IOException 
	{
		BufferedWriter bw;
		bw = new BufferedWriter(new FileWriter(fichero));
	    bw.write("Fichero creado.....");
	    bw.close();
	}
}
class ErrorArgumentos extends Exception {
	public ErrorArgumentos() 
	{
		super();
	}
}
