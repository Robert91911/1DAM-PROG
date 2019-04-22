package ejercicio1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ejercicio1Miguel 
{
	public static void main(String[] arg) 
	{
		// Comprobamos si el numero de argumentos es correcto.
		try 
		{
		if (arg.length == 0) 
			{
			// Lanzamos la excepcion
			throw new ErrorArgumentos();
			}
		else {
			for (int i = 0; i < arg.length; i++) {

				File fichero = new File(arg[i]);
				
					if (fichero.exists()) {
						propiedades(fichero);
					} else {
						throw new FileNotFoundException();
					}
				} 
			}
		
		}catch (ErrorArgumentos error) {
			System.err.println("Error en el numero de argumentos");
			System.err.println("Sintaxis:");
			System.err.println("java PropiedadesFichero nomFich1... nomFichx");
		}
		catch (FileNotFoundException error) {
			System.err.println("El fichero no existe");
		}
		
		
	}

	private static void propiedades(File fichero) {
		System.out.println("----------------------------------");
		// Comprobamos si es un fichero ordinario.
		 	if (fichero.isFile()) {
			System.out.println("Es un fichero ordinario," + " con nombre: " + fichero.getName());
				if (fichero.canExecute()) {
				System.out.print("El fichero se puede ejecutar.");
				} else {
				System.out.print("El fichero no se puede ejecutar");
				}
				if (fichero.canRead()) {
				System.out.print("El fichero se puede leer.");
				} else {
				System.out.print("El fichero no se puede leer.");
				}
				if (fichero.canWrite()) {
				System.out.println("El fichero se puede escribir.");
				} else {
				System.out.println("El fichero no se puede escribir.");
				}
		 	} else if (fichero.isDirectory()) {
		 		System.out.println("Es un directorio.");
		 		String nomFicheros[] = fichero.list();
		 		System.out.println("Ficheros dentro del directorio: " + fichero.getName());
		 		for (int i = 0; i < nomFicheros.length; i++) {

		 			System.out.println(i + ":" + nomFicheros[i]);
		 		}
		 	}
		}
}

class ErrorArgumentos extends Exception {
	public ErrorArgumentos() {
		super();
	}
}