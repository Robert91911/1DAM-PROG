package agendaenlazada;

import java.util.Scanner;

import arraydinamico.Contacto;

public class AgendaEnlazada
{
	/**
	 * Una lista enlazada simple es una colección de nodos enlazados. Cada nodo tendrá como
	 * mínimo dos atributos: información y enlace. Información será la referencia del objeto
	 * que queremos almacenar y enlace será la referencia de otro nodo.
	 * Siempre tendremos una referencia llamada inicio que apunte al primer nodo de la lista.
	 * El campo enlace del último nodo tiene que valer null.
	 */
	Nodo inicio;
	public AgendaEnlazada()
	{
		inicio = null;
	}
	//////////////////////////
	public void insertarPrincipio(Contacto obj)
	{
		//Creamos un nuevo nodo
		Nodo nuevo = new Nodo(obj, inicio);
		//Inicio pasa a referenciar a nuevo
		inicio = nuevo;
	}
	//////////////////////////
	public void verLista()
	{
		if(listaVacia())
		{
			System.out.println("La agenda está vacía");
		}
		else
		{
			//Nos colocamos al inicio de la lista
			Nodo actual = inicio;
			while(actual != null)
			{
				System.out.println(actual.info);
				//Avanzamos al siguiente nodo
				actual = actual.enlace;
			}
		}
	}
	//////////////////////////
	/**
	 * Este método inserta un nodo al final de la lista
	 */
	public void insertarFinal(Contacto contacto)
	{
		//Creamos un nuevo nodo
		Nodo nuevo = new Nodo (contacto, null);
		if(listaVacia())
		{
			inicio = nuevo;
		}
		else
		{
			//Nos situamos en el último nodo
			Nodo actual = inicio;
			
			while(actual.enlace != null)
			{
				actual = actual.enlace;
			}
			//Enlazamos el último nodo con el nuevo 
			actual.enlace = nuevo;
		}
	}
	//////////////////////////
	public boolean listaVacia()
	{
		return (inicio == null);
	}
	//////////////////////////
	/**
	 * Este método busca el elemento a eliminar y lo elimina enlazando el nodo anterior con
	 * el siguiente
	 * @param obj
	 */
	public void eliminarNodo(Contacto contacto)
	{
		//Variables
		Nodo anterior = null;
		Nodo actual = inicio;
		boolean encontrado = false;
		
		while(actual != null && !encontrado)
		{
			if(contacto.equals((Contacto)actual.info))
			{
				encontrado = true;
			}
			else
			{
				//Avanzamos al siguiente nodo
				anterior = actual;
				actual = actual.enlace;
			}
		}
		if(encontrado)
		{
			//Comprobamos si es el primero
			if(anterior == null)
			{	
				//El inicio de la lista pasa a ser el siguiente nodo
				inicio = inicio.enlace;
			}
			else
				//Enlazamos el nodo anterior con el siguiente
				anterior.enlace = actual.enlace;
		}
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
		System.out.println("6.Salir");	
		System.out.println("Introduzca una opción: ");
		do 
		{ 	
			
			opcion = entrada.nextInt();	
			opcionValida = (opcion >=1 && opcion <=6);
			if (!opcionValida) 
			{
				System.err.println("Error, introduce una opción válida del 1 al 6");	
			}
		}while (!opcionValida);
		return opcion;	
	}
	//////////////////////////
	public void arrancarAplicacion()
	{
		boolean salir = false;
	
		
		do 
		{
			int opcion = verMenu();
			salir = (opcion == 6);
			if(!salir)
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
						verLista();
						break;
				}
			}	
			
			
		}while (!salir);	
		System.out.println("Programa finalizado");
	}
	
	//////////////////////////
	private void nuevoContacto()
	{	
		
		Contacto contacto = introducirDatos();
		//Comprobamos si existe el contacto
		Nodo actual = busqueda(contacto);
		boolean existe = (actual != null);
		if(existe)
		{
			System.out.println("Este contacto ya existe");
		}
		else
		{
			insertarPrincipio(contacto);
		}
	}
	//////////////////////////
	private Nodo busqueda(Contacto contacto)
	{
		
		
		for(Nodo actual = inicio; actual != null; actual = actual.enlace)
		{
			if(contacto.equals((Contacto)actual.info))
			{
				return actual;
			}
			
		}
		return null;
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
	private void eliminar() 
	{
		if(listaVacia())
		{
			System.out.println("La agenda está vacia");
		}
		else
		{
			Contacto contacto = introducirDatos();
			//Comprobamos si existe el contacto
			Nodo actual = busqueda(contacto);
			boolean existe = (actual != null);
			if(existe)
			{
				eliminarNodo(contacto);
				System.out.println("El contacto ha sido eliminado");
			}
			else
				System.out.println("El contacto no existe");
		}
	}
	//////////////////////////
	private void modificar() 
	{
		Scanner entrada = new Scanner(System.in);
		if(listaVacia())
		{
			System.out.println("La agenda está vacia");
		}
		else
		{
			Contacto contacto = introducirDatos();
			//Comprobamos si existe el contacto
			Nodo actual = busqueda(contacto);
			boolean existe = (actual != null);
			if(existe)
			{
				System.out.println("Modifica los datos");
				System.out.println("Introduce el nuevo teléfono");
				contacto = (Contacto)actual.info;
			    contacto.setTelefono(entrada.nextLine());
			}
			else
				System.out.println("El contacto no existe");
		}
	}
	//////////////////////////
	private void consultas()
	{
		//Comprobamos si la agenda está vacia
		if(listaVacia())
		{
			System.out.println("La agenda está vacía.");
		}
		else
		{
			Contacto contacto = introducirDatos();
			Nodo actual = busqueda(contacto);
			boolean existe = (actual != null);
			if(existe)
			{
				//Enviar a pantalla información de ese contacto
				contacto.mostrarDatos();
			}
			else
				System.out.println("El contacto no existe");
		}
	}
}