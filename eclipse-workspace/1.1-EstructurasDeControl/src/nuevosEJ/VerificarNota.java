package nuevosEJ;

import java.util.Scanner;

public class VerificarNota {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Inserta la nota que quieres validar");
		int nota = sc.nextInt();
		switch(nota)
		{
			case 1: case 2: case 3: case 4: System.out.println("Has suspendido");
				break;
			case 5: System.out.println("Has aprobado");
				break;
			case 6: case 7: System.out.println("Has sacado un bien");
				break;
			case 8: case 9: System.out.println("Has sacado un notable");
				break;
			case 10: System.out.println("Has sacado un sobresaliente");
				break;
			default: System.out.println("El numero está fuera de rango");
		}
		sc.close();
	}

}
