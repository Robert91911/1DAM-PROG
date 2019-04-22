package arrayscadenas;

public class ArraysCadenas 
{
	
	public static void main(String[] args)
	{
		String nombres1[] = {"Teresa","Lorenzo","Alejandro"};
		String nombres2[] = {"Jaime", "Ana","Jorge"};
		visualizarArray(nombres1);
		ordenacionBurbuja(nombres1);
		visualizarArray(nombres1);
		System.out.println();
		visualizarArray(nombres2);
		ordenacionBurbuja(nombres2);
		visualizarArray(nombres2);
		String nombres3[] = fusion(nombres1, nombres2);
		System.out.println();
		visualizarArray(nombres3);
		
	}
	
	public static boolean arrayVacio(String[] array)
	{
		return(array.length == 0);
	}
	public static void visualizarArray(String[] array)
	{
		if(!arrayVacio(array))
		{
			for(int i = 0; i < array.length; i++)
			{
				System.out.print(array[i] + " ");	
			}
			System.out.println();
		}
		else
		{
			System.out.println("El array no tiene elementos");
		}
	}
	public static void ordenacionBurbuja(String[]array)
	{
		boolean hayIntercambio;
		do
		{
			hayIntercambio = false;
			for(int i = 0; i < array.length-1; i++)
			{
				
				if(array[i].compareTo(array[i+1]) > 0)
				{
					//Intercambiamos los elementos
					String aux = array[i+1];
					array[i+1] = array[i];
					array[i] = aux;
					hayIntercambio = true;
				}
			}
		}while(hayIntercambio);
	}
	public static String[] fusion (String nombres1[],String[] nombres2)
	{
		//Creamos espacio para array3
		String array3[] = new String[nombres1.length + nombres2.length];
		//Nos situamos en la primera posición de los 3 arrays
		int i = 0;
		int j = 0;
		int k = 0;
		/*Recorremos ambos arrays mientras tengan elementos, comparamos los elementos
		 * y el elemento más pequeño lo almacenamos en el tercer array
		 */
		while(i < nombres1.length && j < nombres2.length) 
		{
			if(nombres1[i].compareTo(nombres2[i+1]) < 0)
			{
				array3[k] = nombres1[i];
				i++;
				k++;
			}
			else
			{
				array3[k] = nombres2[j];
				j++;
				k++;
			}	
		}
		//Almacenamos en el tercer array los elemenos restantes
		while(i < nombres1.length)
		{
			array3[k] = nombres1[i];
			i++;
			k++;
		}
		while(j < nombres2.length)
		{
			array3[k] = nombres2[j];
			j++;
			k++;
		}
		return array3;
	}

}
