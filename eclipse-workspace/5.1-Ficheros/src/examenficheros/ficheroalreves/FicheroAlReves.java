package examenficheros.ficheroalreves;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import examenficheros.comprobarFicheros.ErrorArgumentos;

public class FicheroAlReves 
{
	public static void main(String[] args) 
	{
		try
		{
			if(args.length != 1)
				throw new ErrorArgumentos();
			else
			{
				File fichero = new File(args[0]);
					if(!fichero.exists())
					{
						System.out.println("El fichero no existe");
						throw new IOException();
					}
					else
						verAlReves(fichero);
			}
		}
		catch (ErrorArgumentos e)
		{
			System.out.println("Error en la sintaxis del programa");
			System.out.println("Sintaxis: java FicheroAlReves [nomFichero]");
		}
		catch(IOException e)
		{
			System.out.println("Error de E/S."+e.getMessage());
		}
	}

	private static void verAlReves(File fichero) 
	{
		RandomAccessFile flujo = null;
		try
		{
			flujo = new RandomAccessFile(fichero, "r");
			long tamFich = flujo.length() -1;
			while(tamFich>=0)
			{
				flujo.seek(tamFich);
				System.out.print((char)flujo.read());
				tamFich--;
			}
		}
		catch(IOException e)
		{
			System.out.println("Error E/S."+e.getMessage());
		}
		finally 
		{
			if(flujo != null)
				try {
					flujo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

	}
}
