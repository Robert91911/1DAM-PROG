package estructurasdecontrol;

import java.util.Scanner;

/**
 * Este programa calcula el máximo común divisor entre dos numeros 
 * @author robert
 *
 */
public class MCD
{
	public static void main(String[] args) 
	{
		//Variables que utiliza el programa
		Scanner entrada = new Scanner(System.in);
		//Pedimos los números por teclado.
		System.out.println("Introduce el primer número: ");
		int num1 = entrada.nextInt();
		
		System.out.println("Introduce el segundo número:");
		int num2 = entrada.nextInt();
		
		//Calculamos el MCD.
		while(num1 != num2)
		{
			if(num1 > num2)
				num1 = num1 - num2;
			else
				num2 = num2 - num1;
		}
		//Imprimir en pantalla el resultado.
		System.out.println("El MCD es: " + num1);
		entrada.close();
	}

}