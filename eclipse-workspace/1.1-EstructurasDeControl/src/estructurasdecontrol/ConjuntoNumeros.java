package estructurasdecontrol;

import java.util.Scanner;
/**
 * Este programa va a tener 6 números almacenados en memoria, y nos va a decir cuales son menores de 15, 
 * cuales son mayores de 55, y cuales están entre 45 y 55.
 * @author robert
 *
 */
public class ConjuntoNumeros 
{
	public static void main(String[] args) 
	{
		//Primero ponemos las variables que necesitamos.
		int num;
		int menor15 = 0;
		int mayor55 = 0;
		int entre45y55 = 0;
		//Ahora pedimos 6 numeros utilizando un bucle for
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce 6 números a tu elección: ");
		for(int cont = 1; cont <= 6; cont++)
		{
			num = entrada.nextInt();
			//Una vez introducidos los 6 números, decidimos cuáles son menores que 15
			//cuales son mayores que 55 y cuales están entre 45 y 55.
			if (num < 15)
				menor15++;
			else if(num > 55)
				mayor55++;
			else if(num >= 45)
				entre45y55++;
		}
		//Tras ver las condiciones mostramos por pantalla el resultado.
		System.out.println(menor15 + " números son menores que 15 \n" + mayor55 + " números son mayores que 55 \n" + entre45y55 + " números están entre 45 y 55.");
		entrada.close();
	}

}

