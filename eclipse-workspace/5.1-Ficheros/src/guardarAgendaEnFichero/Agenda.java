package guardarAgendaEnFichero;

import java.util.Scanner;
import java.io.*;

/**
 * Codigo fuente para manipular una agenda de contactos utilizando un 
 * array dinámico
 * @author alumno
 *
 */
public class Agenda implements Serializable
{
	/**
	 * Atributos
	 */
	private static int numContactos;
	private static Contacto array[];
	
	/**
	 * Constructor
	 */
	public Agenda()
	{
		numContactos = 0;
		array = new Contacto[numContactos];
	}
	//////////////////////////
	/**
	 * unElementoMas es un método que pide memoria para un elemento más
	 * y copio en ese nuevo array los elementos que ya estaban en el 
	 * original. Para hacer esto, no tenemos más remedio que utilizar un array
	 * auxiliar que apunte a la misma dirección que apunta array.
	 */
	//////////////////////////
	private void unElementoMas(Contacto aux[])
	{
		//Pedimos memoria para un elemento más
		array = new Contacto[numContactos +1];
		//Copiamos los contactos anteriores en array
		for(int i = 0; i < numContactos; i++)
		{
			array[i] = aux[i];
		} 
		//Actualizamos el número de contactos
		numContactos ++;
	}
	//////////////////////////
	/**
	 * Añade un elemento a la agenda
	 * @param contacto
	 */
	public void anadir(Contacto contacto)
	{
		unElementoMas(array);
		insertar(contacto, numContactos-1);
	}
	//////////////////////////
	/**
	 * Inserta un contacto en la posición válida indicada
	 */
	public void insertar(Contacto contacto, int posicion)
	{
		//Validamos la posición
		if(posicion >= 0 && posicion < numContactos)
		{
			array[posicion] = contacto;
		}
		else 
			System.out.println("La posición no es válida.");
	}
	/**
	 * Este método pide memoria para uno menos y copia en el array
	 * los elementos que no estén marcados.
	 * Borrar un contacto
	 */
	//////////////////////////
	private void unElementoMenos(Contacto aux[])
	{
		
		//Pedimos memoria para un elemento menos
		array = new Contacto[numContactos -1];
		/**
		 * Índice para posicionarme en el array destino
		 */
		int j = 0;
		//Copiamos en array todos aquellos menos el marcado con null
		for(int i = 0; i < numContactos; i++)
		{
			if(aux[i] != null)
			{
				array[j] = aux[i];
				j++;
			}
		}
		numContactos --;
	}
	//////////////////////////
	/**
	 * Realiza una busqueda secuencial del contacto que le hemos pasado.
	 * Devuelve la posición en caso de que lo encuentre y -1 en caso contrario.
	 * @param contacto
	 * @return
	 */
	private int busqueda(Contacto contacto)
	{
		for(int i = 0; i < numContactos; i++)
		{
			if(contacto.equals(array[i]))
			{
				return i;
			}	
		}
		return -1;
	}
	//////////////////////////
	/**
	 * Recibe la posición donde está el elemento que quiero eliminar y lo 
	 * marca asignándole un null.
	 * @return
	 */
	private boolean marcar(int pos)
	{
		array[pos] = null;
		unElementoMenos(array);
		return true;
	}
	//////////////////////////
	private int verMenu()
	{
		Scanner entrada = new Scanner (System.in);
		boolean opcionValida = true;
		int opcion;
		
		System.out.println("1.Nuevo Contacto");
		System.out.println("2.Consultar");
		System.out.println("3.Eliminar");
		System.out.println("4.Modificar");
		System.out.println("5.Ver agenda");
		System.out.println("6.Salir y guardar la agenda");
		System.out.println("7.Salir sin guardar");	
		do 
		{ 	
			System.out.println("Introduzca una opción: ");
			opcion = entrada.nextInt();	
			opcionValida = (opcion >=1 && opcion <=7);
			if (!opcionValida) 
			{
				System.err.println("Error, introduce una opción válida del 1 al 7");	
			}
		}while (!opcionValida);
		return opcion;	
	}
	//////////////////////////
	public void arrancarAplicacion()
	{
		boolean salir = false;
		int opcion = verMenu();
		salir = (opcion == 7);
		
		if (!salir)
		{
		do 
		{
			switch(opcion)
			{ 
			case 1:
				nuevoContacto();
				break;
			case 2:
				consultas();
				break;
			case 3:
				eliminar();
				break;
			case 4:
				modificar();
				break;
			case 5:
				verAgenda();
				break;
			case 6:
				//guardarDatos();
				break;
			case 7:
				salir = true;
				break;
			}
			
			//Introducimos otra opción
			System.out.println("Introduce otra opción");
			opcion = verMenu();
		}while (!salir);
		}else
			System.out.println("Se ha decidido salir de la aplicación");
		System.out.println("Programa finalizado");
	}
	
	
	
	
	
	
	private void modificar() 
	{
		Scanner entrada = new Scanner(System.in);
		if(agendaVacia())
		{
			System.out.println("La agenda está vacia");
		}
		else
		{
			Contacto contacto1 = introducirDatos();
			//Comprobamos si existe el contacto
			int posicion = busqueda(contacto1);
			boolean existe = (posicion != -1);
			if(existe)
			{
				System.out.println("Modifica los datos");
				System.out.println("Introduce el nuevo teléfono");
				array[posicion].setTelefono(entrada.nextLine());
			}
			else
				System.out.println("El contacto no existe");
		}
		
	}
	//////////////////////////
	private void verAgenda() 
	{
		if(agendaVacia())
		{
			System.out.println("La agenda está vacía");
		}
		else
		{
			for(int i = 0; i < numContactos; i++)
			{
				array[i].mostrarDatos();	
			}
		}
	}
	private void eliminar() 
	{
		if(agendaVacia())
		{
			System.out.println("La agenda está vacia");
		}
		else
		{
			Contacto contacto1 = introducirDatos();
			//Comprobamos si existe el contacto
			int posicion = busqueda(contacto1);
			boolean existe = (posicion != -1);
			if(existe)
			{
				//Si existe, lo marcamos para eliminarlo
				if(marcar(posicion))
				{
					System.out.println("El contacto ha sido eliminado");
				}
			}
			else
				System.out.println("El contacto no existe");
		}
	}
	//////////////////////////
	/**
	 * Este método añade un nuevo contacto a la agenda
	 */
	private void nuevoContacto()
	{	
		Contacto contacto1 = introducirDatos();
		//Comprobamos si existe el contacto
		int posicion = busqueda(contacto1);
		boolean existe = (posicion != -1);
		if(existe)
		{
			System.out.println("Este contacto ya existe");
		}
		else
		{
			anadir(contacto1);
		}
	}
	//////////////////////////
	private void consultas()
	{
		
		//Comprobamos si la agenda está vacia
		if(agendaVacia())
		{
			System.out.println("La agenda está vacía.");
		}
		else
		{
			Contacto contacto1 = introducirDatos();
			int posicion = busqueda(contacto1);
			boolean existe = (posicion != -1);
			if(existe)
			{
				//Enviar a pantalla información de ese contacto
				contacto1.mostrarDatos();
			}
			else
				System.out.println("El contacto no existe");
		}
	}
	//////////////////////////
	private Contacto introducirDatos()
	{
		//Introducimos los datos
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce el nombre");
		String nombre = entrada.nextLine();
		System.out.println("Introduce el teléfono");
		String telefono = entrada.nextLine();
				
		//Instanciamos y devolvemos un nuevo contacto
				
		return new Contacto(nombre, telefono);
	}
	//////////////////////////
	private static boolean agendaVacia()
	{
		return (numContactos == 0);
	}
}