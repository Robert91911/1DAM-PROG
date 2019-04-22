package programacionmodular;

import java.io.IOException;
import java.util.Scanner;

public class Salarios 
{
	static Scanner entrada = new Scanner (System.in);
	
	public static void main(String[] args) throws IOException 
	{
		int trabajadores = pedirTrabajadores();
		double tarifa = pedirTarifa();
		calcularSalario(trabajadores, tarifa);
	}
	/////////////////////////////////////////////////
	private static void calcularSalario(int trabajadores, double tarifa) throws IOException 
	{
		for(int i = 1; i <= trabajadores; i++)
		{
			int horasTrabajadas = pedirHorasTrabajadas();
		
			double bruto = salarioBruto(tarifa, horasTrabajadas);
			double impuestos = calcularImpuestos(bruto);
			//imprimir datos
			System.out.println("Salario bruto: " + bruto);
			System.out.println("Impuestos :" + impuestos);
			double neto = bruto-impuestos;
			System.out.println("El salario neto :" + neto);
		}
	}
	/////////////////////////////////////////////////
	private static double calcularImpuestos(double bruto) 
	{
		final double tramo1 = (bruto - 600);
		final double tramo2 = (bruto - 1200);
		double impuestos;
		if (bruto <= 600)
			impuestos = 0;
		else if(bruto <= 1200)
			impuestos = tramo1 * 0.25;
		else {
			impuestos = 600 * 0.25 + tramo2 * 0.45;
		}
		return impuestos;
	}
	///////////////////////////////////////////////////
	private static double salarioBruto(double tarifa, int horasTrabajadas) 
	{
		//Declaracion de una constante en Java= datos cuyo valor no varia
		//durante la ejecucion de un programa
		final double salarioFijo = horasTrabajadas * tarifa;
		int horasExtras = horasTrabajadas - 38;
		double bruto = (horasExtras * 1.5) + salarioFijo;
		return bruto;
	}
	///////////////////////////////////////////////
	private static int pedirHorasTrabajadas() 
	{
		int horas;
		System.out.println("Introduce las horas");
		do {
			horas = entrada.nextInt();
			if(horas < 38)
				System.out.println("Las horas tienen que ser mayor o igual de 38");
		}while(horas < 38);
		return horas;
	}
	////////////////////////////////////////////

	private static double pedirTarifa() 
	{
		double tarifa;
		System.out.println("Introduce la tarifa ordinaria");
		do {
			tarifa = entrada.nextDouble();
			if(tarifa <= 0)
				System.out.println("La tarifa tiene que ser mayor de 0");
		}while(tarifa <= 0);
		return tarifa;
	}
	/////////////////////////////////////////////
	private static int pedirTrabajadores() 
	{
		int numTrabajadores;
		System.out.println("Introduce el numero de trabajadores");
		do{
			numTrabajadores = entrada.nextInt();
			if(numTrabajadores <= 0)
				System.out.println("Los trabajadores tienen que ser mayor de 0");
		}while(numTrabajadores <= 0);
		return numTrabajadores;
	}
	
	/////////////////////////////////////////////
	
}
