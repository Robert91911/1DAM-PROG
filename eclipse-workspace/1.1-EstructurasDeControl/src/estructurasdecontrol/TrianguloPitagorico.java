package estructurasdecontrol;

import java.io.IOException;
import java.util.Scanner;

/**
 * Tiene que tener la misma base que la altura, el numero de fila en la que estoy coincide con el numero de 
 * caracteres.
 * @author robert
 *
 */
public class TrianguloPitagorico 
{
	public static void main(String[] args) throws IOException 
	{
		java.util.Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce el caracter con el que desea dibujar: ");
		char caracter = (char) System.in.read();
		System.out.println("Introduce la altura del triangulo");
		int altura = entrada.nextInt();	

		for(int i = 1 ; i <= altura; i++)
		{
			for (int  j = 1 ; j <= i; j++)
			{
				System.out.print(caracter);	
			}
			System.out.println();
		}
		entrada.close();
	}
}
