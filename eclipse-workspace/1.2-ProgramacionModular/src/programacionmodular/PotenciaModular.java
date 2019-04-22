package programacionmodular;
import java.util.Scanner;

public class PotenciaModular 
{
	static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) 
	{
		int base = pedirbase();
		int exponente = pedirExponente();
		int potencia = potenciaPotencia(base, exponente);
		verResultados(potencia, base, exponente);
	}
	////////////////////////////////////////////////////////////////////////
	private static int pedirbase()
	{
		System.out.println("Introduce la base");
		return teclado.nextInt();
	}
	//////////////////////////////////////////////////
	private static int pedirExponente()
	{
		System.out.println("¿A que lo quieres elevar?");
		return teclado.nextInt();
	}
	//////////////////////////////////////////////////////////////////////
	private static int potenciaPotencia(int base, int exponente)
	{
		int acumulador = 1; // se inicia en 1 porque hay que acumular el resultado y al ser la multiplicacion, siempre
		//se inicia en 1 porque si no nos daria 0 si se iniciase en 0. en multiplicacion SIEMPRE el aucmulador
		//vale 1 y en suma casi siempre es 0;
		for (int i = 1; i <= exponente; i++)
		{
			acumulador = acumulador * base;
		}
		return acumulador; //puede haber mas de un return dentro de un metodo pero no puede ejecutarse.
	}
	//////////////////////////////////////////////////////////////////////////
	private static void verResultados(int potencia, int base, int exponente)
	{
		System.out.println(base+ " elevado a "+exponente+ " es "+potencia);
	}

}
