package estructurasdecontrol;

/**
 * Suma una serie de numeros
 * @author robert
 *
 */
public class SumaNumeros 
{
	public static void main(String[] args)
	{

		int suma = 0;
		
		for(int cont = 3; cont<=1500; cont = cont + 4)
		{
			suma = suma + cont;
		}

		System.out.println("EL resultado es: " + suma);
	}
}