package programacionmodular;

import java.util.Scanner;

public class Rectangulo 
{
/**
 * ejemplo de programacion modular 
 * que calcule el area y perimetro de un rectangulo
 * 
 */ 
	static Scanner sc = new Scanner(System.in);
	
	//////////////////////////////////////////
	public static void main(String[] args)
	{
		// introducimos la base y la altura
		double base = pedirBase();
		double altura = pedirAltura();
		
		//calcular area y perimetro
		double area = calcularArea(base, altura);
		double perimetro = calcularPerimetro (base, altura);
		//ver resultados
		verResultados(area, perimetro);
		
	}
	/////////////////////////////////////
	private static double pedirBase()
	{
		System.out.println("Introduce la base");
		return sc.nextDouble();
		
	}
	////////////////////////////////////
	private static double pedirAltura()
	{
		System.out.println("Introduce la altura");
		return sc.nextDouble();
		
	}
	/////////////////////////////////////	
	public static double calcularArea(double base, double altura)
	{
		return base * altura;
	}
	/////////////////////////////////////
	public static double calcularPerimetro(double base, double altura)
	{
		return 2 * (base + altura);
	}
	////////////////////////////////////
	public static void verResultados(double area, double perimetro)	
	{
		System.out.println("Area = " +area);
		System.out.println("Perimetro = " +perimetro);
		
	}
}
