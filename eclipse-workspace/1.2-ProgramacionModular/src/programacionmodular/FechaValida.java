package programacionmodular;

import java.util.Scanner;

public class FechaValida 
{
	static Scanner sc = new Scanner (System.in);
/////////////////////////////////
	public static void main(String[] args) 
	{
		arrancarAplicacion();
	}
//////////////////////////////////
	private static void arrancarAplicacion() 
	{
		boolean diaValido;
		int mes;
		int anno;
		int dia;
		mes = pedirMes();
		anno = pedirAnno();
		do 
		{
			dia = pedirDia();
			diaValido = validarFecha(mes, anno, dia);
			if(!diaValido)
				System.err.println("El dia es erroneo, vuelve a introducir los datos");	
		}while(!diaValido);
		
		System.out.println("La fecha es correcta: " + dia + "/" + mes + "/" + anno);	
	}
	////////////////////////////////////
	private static boolean validarFecha(int mes, int anno, int dia) 
	{	
		boolean diaValido = false;
		switch (mes)
				{
				case 1:
				case 3: 
				case 5:
				case 7:
				case 8: 
				case 10:
				case 12:
					diaValido =(dia >= 1 && dia <= 31);
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					diaValido = (dia >= 1 && dia <= 30);
					break;
				case 2:
					if(esBisiesto(anno))
						diaValido = (dia >=1 && dia <= 29);
					else
						diaValido = (dia >=1 && dia <= 28);
					break;
				}
			return diaValido;
	}
////////////////////////////////////
	private static boolean esBisiesto(int anno) 
	{
		return ((anno %4 ==0)&&(anno %100!=0)||(anno %400==0));
	}
////////////////////////////////
	private static int pedirDia() 
	{
		System.out.println("Introduce el dia");
		return sc.nextInt();
		
	}
/////////////////////////////////
	private static int pedirAnno() 
	{
		
		int anno;
		boolean annoValido;
		System.out.println("Introduce el año");
		do 
		{
			anno = sc.nextInt();
			annoValido = (anno >= 1582);
			if (!annoValido)
				System.err.println("Introduce un año valido mayor de 1582");
		}while(!annoValido);
		return anno;
	}
////////////////////////////////
	private static int pedirMes() 
	{
		int mes;
		boolean mesValido;
		System.out.println("Introduce el mes");
		do 
		{
			mes = sc.nextInt();
			mesValido = (mes >=1 && mes <=12);
			if (!mesValido)
				System.err.println("Introduce un mes valido entre 1 y 12");
		}while(!mesValido);
		return mes;
	}

}
