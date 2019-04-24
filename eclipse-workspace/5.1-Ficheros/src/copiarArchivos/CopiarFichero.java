package copiarArchivos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

/**
 * El programa copia un archivo hacia otro pasandole, los valores por parametros
 * @author robert
 *
 */
public class CopiarFichero {
	
	public static void main(String[] args) 
	{
		File file = null;
		File copia = null;
		try 
		{
			if (args.length == 2) 
			{
				file = new File(args[0]);
				copia = new File(args[1]);
				
				if (file.exists()) 
				{
					if(copia.exists())
					{
						throw new IOException();
					}
					else
					{
					copiarFichero(file, copia);
					}
				}
				else
					System.out.println("El fichero con el nombre introducido no existe");
			} else {
				throw new ParametrosException();
			}
		}
		catch(IOException e)
		{
			System.err.println("La copia de ["+file+"] ya existe");
		}
		catch (ParametrosException e) 
		{
			System.out.printf("Excepción: %s\n", e.getMessage());
			System.out.println("Sintaxis correcta: java -jar <archivo_origen> <archivo_destino>");
		}
		catch (Exception e) 
		{
			System.out.printf("Excepción: %s\n", e.getMessage());
		}
	}

	
	public static void copiarFichero(File file, File copia) {	
		System.out.println("Se comenzará a copiar el fichero");
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream(file);
			fos = new FileOutputStream(copia);
			//No funciona por esto
			int b = 0; //b es donde apunta el puntero de lectura empezando en 0
			while((b = fis.read()) != -1) //Siendo -1 el final del fichero
			{
				fos.write(b);	
				//fos.write(fis.read()); Esto no funciona!, se queda en la mitad del fichero
			}
		} catch (IOException e) {
			System.out.println("Excepción: " + e.getMessage());
		} finally {
			try {
					fis.close();
					fos.close();
			} catch (IOException e) {
				System.out.println("Excepción: " + e.getMessage());
			}
		}
		System.out.println("\nArchivo guardado y programa terminado");
	}
	
	
	//////////////////////////////////////////////////////////////////
	
	}
	class  ParametrosException extends Exception{
		public ParametrosException() 
		{
			super();
		}
	}
	
