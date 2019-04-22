package leerArchivoBinario;

import java.io.*;

public class LeerArchivoBinario {
/**
	public static void main(String[] args) 
	{
		try {
			if (args.length == 1) {
				File file = new File(args[0]);
				if (file.exists()) {
					leerFichero(file);
				}else {
					throw new ParametrosException();
				}
		} catch (ParametrosException e) {
			System.out.printf("Excepción: %s\n", e.getMessage());
			System.out.println("Sintaxis correcta: java -jar <Programa> <Archivo>");
		} catch (Exception e) {
			System.out.println("El archivo no existe");
		}
		
	}

	private static void leerFichero(File file) {
		DataInputStream dis = null;
				try {
					dis = DataInputStream(new BufferedInputStream(new File file))
						while(true) {
							System.out.println("");
							System.out.println("");
						}
				}catch(EOFException e)
				{
					System.out.println("Fin del fichero");
				}catch(IOException e){
					System.out.println(e.getMessage());
				}
				
				
		
	}
*/
}
class ParametrosException extends Exception{
	public ParametrosException() 
	{
		super();
	}
}
