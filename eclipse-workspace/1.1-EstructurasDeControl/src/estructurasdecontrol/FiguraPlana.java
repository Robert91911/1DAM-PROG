package estructurasdecontrol;

import java.io.IOException;
import java.util.Scanner;

/**
 * Progrma que dibuja una figura plana con un tipo de caracter y un tamaño que el usuario ha especificado
 * @author robert
 *
 */

public class FiguraPlana 
{

	public static void main(String[] args) throws IOException 
	{
		//Creamos las variables necesarias
		char caracter;
		int base;
		int altura;
		//Introducimos el carácter deseado, la base y la altura.
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introduce el carácter deseado: ");
		caracter = (char) System.in.read();
		
		System.out.println("Introduce la base: ");
		base = entrada.nextInt();
		
		System.out.println("Introduce la altura: ");
		altura = entrada.nextInt();
		//Una vez tenemos los datos, procedemos a la creación de un bucle que imprima por pantalla
		//los caracteres deseados y realice una figura.
		for(int i = 1; i <= altura; i++)
		{
			for(int j = 1; j <= base; j++)
			{
				System.out.print(caracter);
			}
			System.out.println();
		}
		entrada.close();
	}

}