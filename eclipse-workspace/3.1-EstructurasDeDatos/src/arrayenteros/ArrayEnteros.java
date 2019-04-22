package arrayenteros;

import java.util.Scanner;

public class ArrayEnteros
{
	
	//atributos
	private int array[];
	private int tamMax;
	private int numElem;
	//Constructores
	public ArrayEnteros(int tamMax) 
	{
		this.tamMax = tamMax;
		array = new int[tamMax];
		numElem = 0;
	}
	////////////////////////////////
	public ArrayEnteros()
	{
	//Introducimos por teclado el tamaño máximo
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce el tamaño máximo del array:");
		tamMax = entrada.nextInt();
		array = new int[tamMax];
		numElem = 0;
	}
	////////////////////////////////
	//Constructor copia
	public ArrayEnteros(ArrayEnteros copia)
	{
		tamMax = copia.tamMax;
		numElem = copia.numElem;
		array = new int[tamMax];
		for(int i = 0; i < numElem; i++)
		{
			array[i] = copia.array[i];
		}
	}
	//////////////////////////////////////
	public void introducirDatos()
	{
		Scanner entrada = new Scanner(System.in);
		boolean salir;
		System.out.println("Introduce los datos, teclea 999 para salir:");
		do
		{	
			
			int dato = entrada.nextInt();
			salir = (dato == 999 || numElem == tamMax);
			if(!salir)
			{
				array[numElem] = dato;
				numElem++;
			}
		}while(!salir);
	}
	/////////////////////////////////////////
	public void visualizarArray()
	{	
		if(!arrayVacio())
		{
			System.out.println("\n\n");
			for(int i = 0; i < numElem; i++)
			{
				System.out.print(array[i] + " ");
			}
		}
		else {
			System.out.println("El array no tiene elementos");
		}

	}
	////////////////////////////////////////
	public boolean arrayVacio() 
	{
		return(numElem == 0);
	}
	////////////////////////////////////////
	public boolean arrayLleno()
	{
		return(numElem == tamMax);
	}
	////////////////////////////////////////
	/**
	 * este método pide por teclado la posición
	 * donde vamos a insertarel elemento. Tiene que ser
	 * una posición ocupada, de manera que no se pierda
	 * la información que tenia el array.
	 */
	public void insertar()
	{
		if(arrayLleno())
		{
			System.out.println("El array esta lleno");
		}else
		{
			
			//creamos escaner para introducir por teclado la posicion y el elemento.
			Scanner entrada = new Scanner(System.in);
			//introducir una posición valida.
			boolean posValida;
			int pos;
			System.out.println("Introduce la posición.");
			do
			{
				pos = entrada.nextInt();
				posValida = (pos >= 0 && pos < numElem);
				if(!posValida)
				{
					System.out.println("Posición no válida.");
				}
			}while(!posValida);
			
			//Introducimos el elemento.
			System.out.println("Introduzca el elemento que va ha insertar: ");
			int elem = entrada.nextInt();
			//Movemos los elemetos a la siguiente posición.
			for(int i = numElem; i > pos; i--)
			{
				array[i] = array[i-1];
			}
			//Guardamos el elemento en la posición.
			array[pos] = elem;
			numElem++;
			
		}
		
	}
	/////////////////////////////////////////
	public void eliminar()
	{
		if(arrayVacio())
		{
			System.out.println("El array esta vacío");
		}else
		{
			
			//creamos escaner para introducir por teclado la posicion y el elemento.
			Scanner entrada = new Scanner(System.in);
			//introducir una posición valida.
			boolean posValida;
			int pos;
			System.out.println("Introduce la posición.");
			do
			{
				pos = entrada.nextInt();
				posValida = (pos >= 0 && pos < numElem);
				if(!posValida)
				{
					System.out.println("Posición no válida.");
				}
			}while(!posValida);
			/*Eliminamos el elemento que está en la posición
			moviendo los elementos a la posición anterior */
			for(int i = pos; i < numElem - 1; i++)
			{
				array[i] = array[i+1];
			}
			
			//actualizamos el numero de elementos
			numElem--;
		}
	}
	//////////////////////////////////////////////
	/**
	 * Búsqueda secuencial, busca un elemento devolviendo
	 * la posición donde está la primera ocurriencia
	 * Si el elemento no está devuelve un -1.
	 */
	public int busquedaSecuencialV1(int buscado)
	{
		for(int i = 0; i < numElem; i++)
		{
			if(array[i] == buscado)
			{
				return i;
			} 
		}
		return -1;
	}
	
	//////////////////////////////////////
	
	public int busquedaSecuencialV2(int buscado) {
		boolean encontrado = false;
		int i = 0;
		//Mientras que no lo encuentre y ademas no haya recorrido todo el array
		while(i < numElem && !encontrado) {
			if (array[i] == buscado) {
				encontrado = true;
			}
			//Avanzar a la siguiente posición
			else {
				i++;
			}
		}
		//Comprobamos si lo ha encontrado
		if(encontrado) {
			return i;
		}
		return -1;
	}
	
	///////////////////////////////////////////
	
	public int busquedaSecuencialV3(int buscado) {
		//Nos situamos en la primera posición del Array
		int i = 0;
		
		//Recorremos el array mientras que la posición sea valida y además
		//el elemento que busco sea distinto del que tiene el array
		
		while (i < numElem && buscado != array[i])
		{
			//Avanzamos a la siguiente posición
			i++;
		}
		
		//Comprobamos si lo ha encontrado
		
		if ( i < numElem)
			return i;
		
		return -1;
	}
	/**
	 * Algoritmo de ordenación de la burbuja:
	 * Recorremos el array, comparando elementos
	 * adyacentes. Si no están bien ordenados,
	 * los intercambiamos.
	 * El proceso anterior, se repite siempre y 
	 * cuando haya habido algún intercambio.
	 */
	public void ordenacionBurbuja()
	{
		boolean hayIntercambio;
		do
		{
			hayIntercambio = false;
			for(int i = 0; i < numElem-1 ; i++)
			{
				if(array[i] > array[i+1])
				{
					//Intercambiamos los elementos.
					int aux = array[i+1];
					array[i+1] = array[i];
					array[i] = aux;
					hayIntercambio = true;
				}	
			}
		}while(hayIntercambio);
			
			
	}
	//////////////////////////////////////////
	/**
	 * Algoritmo de busqueda binaria o dicoatomica
	 * Partimos de un array que debe estar previamente ordenado.
	 * Elegimos un elemento central y comparamos el elemento
	 * buscado con el elemento en la posicion central.
	 * Este proceso se repite siempre y cuando primero 
	 * sea <= ultimo y ademas, que elemento buscado sea
	 * distinto que el que está en la posicion central
	 * Devuelve -1 si no lo encuentra y central cuando lo encuentra
	 */
	public int busquedaBinaria(int buscado) {
		int primero = 0;
		int ultimo = numElem - 1;
		int central;
		do {
			// Calculamos central
			central = (primero + ultimo) / 2;
			if (buscado > array[central]) {
				primero = central + 1;
			} else if (buscado < array[central]){
				ultimo = central - 1;
			}
		} while (primero <= ultimo 
				&& buscado != array[central]);
		if (buscado == array[central]) {
			return central;
		}
		return -1;
	}
	//////////////////////////////
	/**
	 *Algoritmo de mezcla o fusión de dos arrays.
	 *Los arrays tienen que estar previamente ordenados 
	 *y el array resultante tiene que quedar perfectamente 
	 *ordenado.
	 *
	 **/
	///////////////////////////////
	public ArrayEnteros fusion (ArrayEnteros array2)
	{
		// Creamos espacio para array3
		ArrayEnteros array3 = new ArrayEnteros(numElem + array2.numElem);
		
		// Nos situamos en la primera posicion de los tres
		// arrays
		
		int i = 0;
		int j = 0;
		int k = 0;
		
		/*
		 * Recorremos ambos arrays mientras tengan elementos, comparamos
		 * comparamos los elementos, y el elemento mas pequeño lo almacenamos
		 * en el tercer array.
		 */ 
		while (i < numElem && j < array2.numElem) 
		{
			if(array[i] < array2.array[j]) 
			{
				// Almacenamos en array3 el elemento de array1.
				array3.array[k] = array[i];
				i++;
				k++;
			}else 
			{
				// Almacenamos en array3 el elemento de array2.
				array3.array[k] = array2.array[j];
				j++;
				k++;
			}	
		}
		// Almacenamos en el tercer array los elementos sin guardar.
		while(i < numElem) 
		{
			array3.array[k]=array[i];
			k++;
			i++;
		}
		while (j < array2.numElem)
		{
			array3.array[k] = array2.array[j];
			k++;
			j++;
		}
		
		array3.numElem = k;
		return array3;
		
	}
	//////////////////////
	/**
	 * Envia a pantalla la suma de los elementos 
	 * pares e impares que tiene el array
	 */
	public void sumaParesImpares() 
	{
		
		int sumaPares = 0;
		int sumaImpares = 0;
		
		for (int i=0; i < numElem;i++) 
		{
			if (array[i] % 2 == 0){
				sumaPares += array[i];
			}else
			{
				sumaImpares += array[i];
			}	
		}
		System.out.println("La suma de los pares es igual a : " + sumaPares );
		System.out.println("La suma de los impares es igual a : "+ sumaImpares);
		
	}
	//////////////////////
	/**
	 * Envia a pantalla el producto de todos los numeros primos 
	 * que hay en el array.
	 * 
	 **/
	public void productoNumerosPrimos() 
	{
		int productoPrimos = 1;
		int contPrimos = 0;
		
		for (int i = 0; i < numElem ; i++ ) 
		{
			if (esPrimo(array[i])) 
			{
				contPrimos++;
				productoPrimos *= array[i];
			}
			
		}
		if(contPrimos > 0)
			System.out.println("El producto de los numeros primos es: " + productoPrimos);
		else 
			System.out.println("array sin numeros primos");
			
	}
	////////////////////
	public boolean esPrimo(int numero)
	{
		for(int div=2;div <= numero/2;div++) 
		{
			//Comprobamos si un divisor es propio (Resto = 0)
			if (numero % div == 0)
			{
				return false;
			}
		}
		return true;
	}
	///////////////////
	
	/**
	 * Este método devuelve el elemento mayor o 
	 * maximo de este array
	 */

}
