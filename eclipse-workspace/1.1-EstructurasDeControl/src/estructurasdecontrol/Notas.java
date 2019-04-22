package estructurasdecontrol;

import java.util.Scanner;

/**
 * Esta aplicación te dice la nota más alta y la más baja, según las notas introducidas.
 * @author robert
 *
 */
public class Notas {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		int alta = 0;
		int baja = 10;
		boolean inValida;
		System.out.println("Introduce notas");

		for (int i = 0; i <= 3; i++) {

			do 
			{
				int nota = entrada.nextInt();
				inValida = (nota < 1 || nota > 10);

				if (inValida) 
				{
					System.out.println("La nota introducida no es valida, introducela de nuevo");
				}
				else 
				{
					if (nota > alta) 
						alta = nota;
					if (nota < baja)
						baja = nota;
				}
			} while (inValida);
		}
		System.out.println("La nota mas alta es: " + alta);
		System.out.println("La nota mas baja es: " + baja);
		
		entrada.close();
	}
}
