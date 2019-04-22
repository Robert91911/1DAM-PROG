package ejercicio1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class PropiedadesFicehro 
{
static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException, FileNoFoundException 
	{
		System.out.print("Introduce el nombre de un fichero o un directorio: ");
		String nombre = sc.nextLine();
		File fichero=new File(nombre);
		try 
		{
		if(args.length == 0)
		{
			//Lanzamos la excepción
			throw new ErrorArgumentos();
		}
		}catch(ErrorArgumentos error)
		{
			System.err.println("El numero de argumentos no es correcto");
			System.err.println("Sintaxis: ");
			System.err.println("java PropiedadesDelFichero Fichero");
		}
	
		if(fichero.exists())
		{
			if(fichero.isDirectory()) 
			{
				System.out.println("Es un directorio, se va a listar su contenido...................");
				File[] ficheros = fichero.listFiles();
				for (int i=0;i<ficheros.length;i++){
				  System.out.println(ficheros[i].getName());
				}
			}else
			{
				System.out.println("Es un fichero");
				System.out.println("Ruta relativa: "+fichero.getPath());
				System.out.println("Ruta absoluta: "+fichero.getAbsolutePath());
				if(fichero.canRead())
				System.out.println("Si se puede leer");
				else
					System.out.println("No se puede leer");
				if(fichero.canWrite())
				System.out.println("Si que puedo escribir");
				else
					System.out.println("No puedo escribir en este archivo");
			}
		}else
			throw new FileNoFoundException();
	}

	

}

	class FileNoFoundException extends Exception 
	{
		
	}
