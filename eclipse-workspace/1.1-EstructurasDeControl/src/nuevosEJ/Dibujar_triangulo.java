package nuevosEJ;

public class Dibujar_triangulo 
{
	
	public static void main(String[] args) 
	{
		int tamaño = 10;
		for(int i = 1; i <= tamaño; i++)
		{
			for(int j = 1; j <= i; j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
