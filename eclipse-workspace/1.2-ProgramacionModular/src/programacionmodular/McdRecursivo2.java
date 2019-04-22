package programacionmodular;

import java.util.Scanner;

public class McdRecursivo2 {
static Scanner entrada = new Scanner(System.in);
	public static void main(String[] args) {
		int num1= pedirnum1();
		int num2 = pedirnum2();
		int mcd=calcularmcd(num1,num2);//parametros originales
		verResultado(num1,num2,mcd);
	}
//////////////////////////////////////////////////////////////
			private static int pedirnum1() {
				System.out.println("Introduce el primer numero: ");
				return entrada.nextInt();	
				}
			/////////////////////////////////////////////////////////////////////
			private static int pedirnum2() {
				System.out.println("Introduce el segundo numero: ");
				return entrada.nextInt();
			}
			/////////////////////////////////////////////////////////////////
private static int calcularmcd(int num1,int num2)//parametro formal
			{
				if (num1 == num2) {
					return num1;
				}
				
					if(num1>num2) {
						num1=num1-num2;
					}
					else {
						num2=num2-num1;
					}
				
				return calcularmcd(num1,num2);
	
			}
////////////////////////////////////////////////////////////////////////////////////////////
			private static void verResultado(int num1,int num2, int calcularmcd) {
				System.out.println("El MCD de de " + num1 + " y " + num2 + " es " + calcularmcd);
			}
	



	}
