package arrayenteros;

import java.util.Scanner;

public class TestArraysEnteros {

	public static void main(String[] args) {
		ArrayEnteros array1 = new ArrayEnteros(5);
		array1.introducirDatos();
		array1.visualizarArray();
		array1.productoNumerosPrimos();
	/*	array1.ordenacionBurbuja();
		array1.visualizarArray();
		
		ArrayEnteros array2 = new ArrayEnteros(5);
		array2.introducirDatos();
		array2.ordenacionBurbuja();
		array2.visualizarArray();*/
		
		
		
		
/*
		ArrayEnteros array3 = array1.fusion(array2);
		array3.visualizarArray();
		
		array3.sumaParesImpares();
		
		/*
		int buscado = pedirBuscado();
		int posicion = array1.busquedaBinaria(buscado);
		boolean encontrado = (posicion != -1);
		if(encontrado)
		{
			System.out.println(buscado+" Ha sido encontrado en la posicion "+posicion);
		} else
		{
			System.out.println(buscado+" No ha sido encontrado");
		}
		/*
		 * array1.visualizarArray();
		ArrayEnteros array2 = new ArrayEnteros(array1);
		array2.visualizarArray();
		ArrayEnteros array3 = new ArrayEnteros();
		array3.introducirDatos();
		array3.visualizarArray();
		
		//array1.insertar();
		//array1.visualizarArray();
		//array1.eliminar();
		//array1.visualizarArray();
		int buscado = pedirBuscado();
		int posicion = array1.busquedaSecuencialV1(buscado);
		boolean encontrado = (posicion != -1);
		if(encontrado)
		{
			System.out.println(buscado+" Ha sido encontrado en la posicion "+posicion);
		} else
		{
			System.out.println(buscado+" No ha sido encontrado");
		}
		System.out.println("Probando la version 2");
		
		posicion = array1.busquedaSecuencialV2(buscado);
		encontrado = (posicion != -1);
		if(encontrado)
		{
			System.out.println(buscado+" Ha sido encontrado en la posicion "+posicion);
		} else
		{
			System.out.println(buscado+" No ha sido encontrado");
		}
		System.out.println("Probando la version 3");
		
		posicion = array1.busquedaSecuencialV3(buscado);
		encontrado = (posicion != -1);
		if(encontrado)
		{
			System.out.println(buscado+" Ha sido encontrado en la posicion "+posicion);
		} else
		{
			System.out.println(buscado+" No ha sido encontrado");
		}
		*/
		
	}
	
	
	/////////////////////////////////////////////////
	
	
	
	public static int pedirBuscado()
	{
		System.out.println("Introduzca el número a buscar");
		Scanner entrada = new Scanner(System.in);
		return entrada.nextInt();
	}
	
	//////////////////////////////////

	
	

}
