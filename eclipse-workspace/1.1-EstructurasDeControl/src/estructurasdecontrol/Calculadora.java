package estructurasdecontrol;

import java.util.Scanner;
/**
 * Este progrma pide dos numeros por teclado y los puede sumar, restar, multiplixar o dividir
 * segun decida el usuario
 * @author robert
 *
 */
public class Calculadora 
{
	public static void main(String[] args) 
	{
		//Instanciamos un Objeto tipo Scanner.
		Scanner entrada = new Scanner(System.in);
		//Creamos las variables que utilizaremos en nuestro programa
		int opcion=1;
		double num1=0;
		double num2=0;
		double result=0;
		boolean salir = false;
		//Creamos un bucle do while para que se repita hasta que salir sea true
		do
		{		
			System.out.println("1 Suma");
			System.out.println("2 Resta");
			System.out.println("3 Multiplicación");
			System.out.println("4 División");
			System.out.println("5 Salir");
			System.out.println("Introduzca la operación a realizar:");
			
			//Comprobamos que la opcion sea válida
			boolean entre1y5;
			do
			{
				opcion=entrada.nextInt();
				entre1y5=(opcion>=1 && opcion<=5);
				if(!entre1y5) 
				{
					System.out.println("Error! el operador elegido no se encuentra entre 1 y 5");
				}
			}while(!entre1y5);
			salir = (opcion==5);
			//Si salir no es true, solicitamos los numeros para realizar la operacion.
			if(!salir) 
			{
				System.out.println("Introduzca numero 1:");
				num1=entrada.nextDouble();
				System.out.println("Introduce numero 2:");
				num2=entrada.nextDouble();
				
				switch(opcion)
				{
					case 1:
						result=num1+num2;
						break;
					case 2:
						result=num1-num2;
						break;
					case 3: 
						result=num1*num2;	
						break;
					case 4: 
						if(num2==0) 
						{
							System.out.println();
						}
						else 
						{
							result=num1/num2;
						}
						break;
				}	
			}
			//Si la operacion es una división y el segundo numero es 0, lanzamos un error
			if(opcion==4 && num2==0) 
			{
				System.out.println("No se puede dividir por cero elija otra operación");
			}
			else 
				if(salir) 
				{		
					System.out.println("Hasta pronto.");
				}else
				System.out.println("El resultado de tus operacion es: " + result );
			}while(!salir);
			System.out.println("Programa finalizado!");
			//Cerramos el scanner
			entrada.close();
	}
}