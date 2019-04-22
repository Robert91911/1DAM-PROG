package matriz;

import java.util.Scanner;

/**
 * autor: 1 º DAM
 * Clase para hacer operaciones muy básicas
 * de una matriz numérica.
 */
public class Matriz {
private int numColumnas;
private int numFilas;
private double matriz[][];

/**
 * Pedimos por teclado el número de filas
 * y de columnas.
 */
	public Matriz() 
	{
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce el numero de filas:");
		numFilas = entrada.nextInt();
		System.out.println("Introduce el numero de columnas:");
		numColumnas = entrada.nextInt();
		matriz = new double[numFilas][numColumnas];
	}
	/////////////////////
	public void introducirDatos()
	{
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce los valores de la matriz");
		for(int fila = 0; fila < numFilas; fila++)
		{
			for(int columna = 0; columna < numColumnas; columna++)
			{
				matriz[fila][columna] = entrada.nextDouble();
			}
		}
	}
	////////////////////
	public void verMatriz()
	{
		for(int fila = 0; fila < numFilas; fila++)
		{
			for(int columna = 0; columna < numColumnas; columna++)
			{
				System.out.print(matriz[fila][columna] + "\t");
			}
			System.out.println();
		}
	}
	//////////////////////////////
	public double sumaDiagonalV1()
	{
		double suma = 0;
		
		for(int fila=0; fila < numFilas; fila++)
		{
			for(int columna=0; columna < numColumnas; columna++)
			{	
				//comprobar que el elemento esta en la diagonal principal
			
				if(fila == columna)
				{
					suma +=  matriz[fila][columna];
				}
		
			}
		}
		return suma;
	}
	

	////////////////////////////////
	/**
	 * suma de los elementos  que están por encima
	 * de la diagonal principal
	 * @return
	 */
	public double sumaEncimaDiagonal()
	{
		double sumaEncima = 0;
		
		for(int fila=0; fila < numFilas; fila++)
		{
			for(int columna=0; columna < numColumnas; columna++)
			{
				if(fila < columna)
				{
					sumaEncima +=  matriz[fila][columna];
				}
			}
		}
		return sumaEncima;
	}
	//////////////////////
	//version 2 metodo anterior
	public double sumaEncimaDiagonalV2()
	{
		double sumaEncima = 0;
		
		for(int fila=0; fila < numFilas -1; fila++)
		{
			for(int columna=fila +1; columna < numColumnas; columna++)
			{
				sumaEncima +=  matriz[fila][columna];
			}
		}
		return sumaEncima;
	}
	///////////////////////////////////////
	public double sumaDiagonalV2()
	{	double acu = 0;
		for (int fila = 0; fila  < numFilas; fila++)
		{
			acu= acu + matriz[fila][fila];
			
		}
		return acu;
	}
	
	
//////////////////////////////////////////
	
	public double sumaDiagonalV3() 
	{
		double suma = 0;
		int columna = 0;
		for(int fila = columna; fila < numColumnas; fila++) {
			suma += matriz[fila][columna];
			columna++;
		}
		return suma;
		
	}
	///////////////////////////////////////////
	
	/**
	 * Este método visualiza en pantalla la suma de los 
	 * totales por fila y columna
	 */
	public void sumaTotalesFilasColumnas()
	{
		//Instanciamos los arrays de totales
		double sumaFilas [] = new double [numFilas];
		double sumaColumnas [] = new double [numColumnas];
		
		//Vamos a hacer el total por filas
		for(int fila = 0;fila < numFilas; fila++)
		{
			//Inicializamos el acumulador de fila
			sumaFilas[fila] = 0;
			
			for(int columna = 0; columna < numColumnas; columna++)
			{
				sumaFilas[fila] += matriz[fila][columna]; 
			}
		}
		
		//Suma totales columna
		for(int columna = 0;columna < numColumnas; columna++)
		{
			//Inicializamos el acumulador de fila
			sumaColumnas[columna] = 0;
			
			for(int fila = 0; fila < numFilas; fila++)
			{
				sumaColumnas[columna] += matriz[fila][columna]; 
			}
		}
		
		verMatriz();
		
		//Comprobamos el resultado
		System.out.println("Totales filas ");
		for(int fila = 0;fila < numFilas;fila++)
		{
			System.out.print(sumaFilas[fila]+" ");
		}
		System.out.println("\n\n");
		
		//Comprobamos el resultado
		System.out.println("Totales columnas ");
		
		for(int columna = 0;columna < numColumnas;columna++)
		{
			System.out.print(sumaColumnas[columna]+" ");
		}
		
		
	}
}
