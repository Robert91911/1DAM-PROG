package estructurasdecontrol;
import java.util.Scanner;

/**
 * El programa calcula el factorial de un número y lo muestra por pantalla 
 * @author robert
 *
 */
public class Factorial 
{

	public static void main (String[] args)
	{
		//Instanciamos un objeto tipo scanner
		java.util.Scanner entrada = new Scanner(System.in);
		//Pedimos al usuario el numero
		System.out.println("Introduce el numero: ");
		int num = entrada.nextInt();
		int result = 1;
		
		for(int cont = num; cont >=1; cont--)
		{
			//Tambien se puede escribir result *= cont;
			result = result * cont;
		}
		System.out.println("Factorial de " + num + " es igual " + result);
		entrada.close();
	}
}
