package estructurasdecontrol;

import java.util.Scanner;

/**
 * Esta aplicación calcula la nota media de un conjunto de notas introducidas por teclado
 * hasta que el usuario introduzca -99
 * @author robert
 *
 */
public class NotaMedia 
{
	public static void main(String[] args) 
	{
		Scanner entrada = new Scanner (System.in);
		/** Necesitamos las siguientes variables:
		 * - Un contador para saber cuantas notas hay que dividir
		 * - Otra variable para guardar la nota
		 * - Un acumulador para sumar las notas
		 * - Salir, va a ser un boolean, para salir del bucle.
		 * - Un bucle **/

	
		System.out.println("Introduce los datos para la nota media, para salir teclee -99: ");
		int cont = 0;
		boolean fin = false;
		double sumaNotas = 0;
		
		do 
		{
			//Introdcimos la nota.
			double nota = entrada.nextDouble();
			fin = (nota == -99);
			if(!fin)
			{
				//Incrementamos el contador de notas.
				cont++;
				//Acumulamos la suma de notas.
				sumaNotas = sumaNotas + nota; 
			}
		}
		while(!fin);
		if (cont == 0) 
		{
			System.out.println("No has introducido ninguna nota.");
		}
		else
		{
			//Calculamos la nota media.
			double notaMedia = sumaNotas / cont;
			//Imprimimos en pantalla la nota media;
			System.out.println("La nota media es: " + notaMedia);
		}
		entrada.close();
	}
}
