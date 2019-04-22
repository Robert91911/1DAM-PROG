package examenficheros.comprobarFicheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 * 
 * @author robert
 * Este programa Compara dos ficheros de texto y si son diferentes te marca en que linea y caracter lo han sido.
 */
public class CompararFicheros 
{
	/**
	 * Comprueba el numero de argumentos y si los ficheros existen, despues llama al método comparar
	 * @param args
	 */
	public static void main(String[] args) 
	{
		if(args.length != 2) //Comprobamos que el numero de argumentos es correcto
		{
			try 
			{
				throw new ErrorArgumentos(); //Creamos una excepcion tipo ErrorArgumentos
			}
			catch (ErrorArgumentos e) //Sacamos por pantalla los mensajes que han llevado a esa excepcion
			{
				System.err.println("El numero de argumentos no es correcto");
				System.err.println("Sintaxis: java CompararFicheros nomFich1 nomFich2");
			}
		}
		else
		{
			try
			{
				File fich1 = new File(args[0]); //Creamos un nuevo fichero con el nombre/ruta del argumento 0
				if(fich1.exists()) //Comprobamos si existe
				{
					File fich2 = new File(args[1]); //Creamos el segundo fichero
					if(fich2.exists()) //Comprobamos que este exista tambien
					{
						comparar(fich1, fich2); //Llamamos al método comparar pasandole los dos ficheros
					}
					else
						throw new FileNotFoundException(); //Si no existe creamos una excepcion
				}
				else
					throw new FileNotFoundException(); //Si no existe creamos una excepcion
			}
			catch (FileNotFoundException e) 
			{
				System.err.println("No se ha encontrado el archivo");
				System.out.println(e.getMessage());
			}
		}
	}
	/**
	 * Este método compara los ficheros entre sí indicando la linea y el numero de caracter en el que dos ficheros son diferentes
	 * @param fich1
	 * @param fich2
	 */	
	private static void comparar(File fich1, File fich2) 
	{
		int contLinea=1; //Creamos los contadores que nos sirven para que el programa nos diga en que linea y caracter son diferentes
		int contCar=1;
		try 
		{
			//Creamos los BufferedReader que lee los dos ficheros
			BufferedReader br1 = new BufferedReader(new FileReader(fich1)); 
			BufferedReader br2 = new BufferedReader(new FileReader(fich2));
			
			//Creamos el caracter de cada bufferedReader
			char car1 = (char)br1.read();
			char car2 = (char)br2.read();
			
			//Comprobamos mediante un while si cada fichero ha llegado al final o si los ficheros ya no son iguales
			while(car1 != (char)-1 && car2 != (char)-1 && car1==car2)
			{
				contCar++; //Avanzamos el contador en 1
				if((char)car1 == '\n') //Si hay un salto de linea suminios el contador de lineas y reseteamos el de caracter
				{
					contLinea++;
					contCar=1;
				}
				//Cogemos el siguiente caracter de cada ficheros para que el while lo compruebe
				car1 = (char) br1.read();
				car2 = (char) br2.read();
			}
			//Si al salir del bucle los caracteres son diferentes, decimos al usuario donde ha pasado
			if(car1 != car2)
			{
				System.out.println("Caracter distinto "+contCar+" en la linea "+contLinea);
			}
			else //Si son iguales
			{
				System.out.println("Los dos ficheros son iguales...");
			}
			//Cerramos los bufferedReader antes de terminar
			br1.close();
			br2.close();
		}
		catch(IOException e) //Capturamos los errores que puedan ocurrir
		{
			e.printStackTrace();
		}
	}
}
