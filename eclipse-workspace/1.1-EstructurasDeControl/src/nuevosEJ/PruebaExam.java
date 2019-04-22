package nuevosEJ;

import java.util.Scanner;

public class PruebaExam {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int opcion;
		boolean valida;
		System.out.println("1 Suma");
		System.out.println("2 Resta");
		System.out.println("3 Multiplicaci�n");
		System.out.println("4 Divisi�n");
		System.out.println("5 Salir");
		System.out.println("Introduce la opcion");
		do
		{
			opcion=sc.nextInt();
			valida=(opcion>0 && opcion<6);
			if(!valida) 
			{
				System.out.println("Error! el operador elegido no se encuentra entre 1 y 5");
			}else
				System.out.println("Esta bien");
		}while(!valida);

	}

}
