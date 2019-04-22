package accesoAleatorio;

import java.io.*;
import java.util.Scanner;



public class BaseDeDatos 
{
	private File fichero;
	private RandomAccessFile flujo;
	private long numRegistro;

	
	
	public BaseDeDatos(String nombre)
	{
		this.fichero = new File(nombre);
		try 
		{
			RandomAccessFile flujo = new RandomAccessFile(fichero, "rw");

		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void crearFichero() 
	{
		boolean existe;
		do
		{
			existe = fichero.exists();
			if(existe) 
			{
				System.out.println("El archivo ya existe");
			}
			else
			{
				try {
				  if (fichero.createNewFile())
					    System.out.println("El fichero se ha creado correcnumRegistroente");
					  else
					    System.out.println("No ha podido ser creado el fichero");
					} catch (IOException ioe) {
					  ioe.printStackTrace();
					}
				}
		}
		while(!existe);
	}
	public void abrirFichero() 
	{
		
	}
	public void anadirRegistro() 
	{
		Scanner sc = new Scanner (System.in);
		System.out.println("Introduce la posicion del registro que quieres modificar");
		int pos = sc.nextInt();
		System.out.println("Introduce la referencia del registro");
		String referencia = sc.nextLine();
		System.out.println("Introduce el nombre del registro");
		String nombre = sc.nextLine();
		System.out.println("Introduce el precio del registro");
		double precio = sc.nextDouble();
		Registro registro = new Registro(referencia, nombre, precio);
		escribirRegistro(registro, pos);
	}
	public void modificarRegistro() 
	{
		//Le paso el registro que quiero escribir, llama a escribir registro y le paso la posicion y el registro
		Scanner sc = new Scanner (System.in);
		System.out.println("Introduce la posicion del registro que desea modificar");
		int pos = sc.nextInt();
		System.out.println("Introduce la referencia del registro");
		String referencia = sc.nextLine();
		System.out.println("Introduce el nombre del registro");
		String nombre = sc.nextLine();
		System.out.println("Introduce el precio del registro");
		double precio = sc.nextDouble();
		Registro registro = new Registro(referencia, nombre, precio);
		escribirRegistro(registro, pos);
		}
	public void eliminarRegistro() 
	{
		// TODO Auto-generated method stub
		
	}
	public void visualizarRegistro() 
	{
		
	}
	public void cerrar()
	{
		try 
		{
			flujo.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public long longitud()
	{
		try 
		{
			long numRegistros = flujo.length()/numRegistro;
			return numRegistros;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	/**
	 * Recibe el registro y la posicion del registro y las esctibe en el fichero
	 * @param registro
	 * @param pos
	 * @return
	 */
	 public boolean escribirRegistro(Registro registro, int pos)
	 {
		 try {
			 if(pos >=0 && pos <= numRegistro) 
			 {
				 flujo.seek(pos*60);
				 return new Registro(flujo.readUTF(), flujo.readUTF(), flujo.readDouble()) != null;
			 }
		 }catch (Exception e) {
			e.printStackTrace();
		}
		 return false;
	 }
		public int verMenu() 
		{
			Scanner sc = new Scanner (System.in);
			boolean opcionValida = true;
			int opcion;
			System.out.println("Elige una opción: ");
			System.out.println("1.Crear nuevo");
			System.out.println("2.Abrir fichero");
			System.out.println("3.Añadir registro");
			System.out.println("4.Modificar registro");
			System.out.println("5.Eliminar registro");
			System.out.println("6.Visualizar registro");	
			System.out.println("7.Salir");
			do 
			{			
				opcion = sc.nextInt();	
				opcionValida = (opcion >=1 && opcion <=7);
				if (!opcionValida) 
				{
					System.err.println("Error, introduce una opción válida del 1 al 7");	
				}
			}while (!opcionValida);
			return opcion;
		}
		public void operacionesMenu()
		{	
			boolean salir = false;
			do 
			{
				int opcion = verMenu();
				salir = (opcion == 7);
				if(!salir)
				{	
					switch(opcion)
					{ 
						case 1:
							crearFichero();
							break;
						case 2:
							abrirFichero();
							break;
						case 3:
							anadirRegistro();
							break;
						case 4:
							modificarRegistro();
							break;
						case 5:
							eliminarRegistro();
							break;
						case 6:
							visualizarRegistro();
							break;
					}
				}	
			}while (!salir);	
			System.out.println("Programa finalizado");
		}
	/**
	 * public boolean escribirRegistro(Registro registro, int pos)
	 * {
	 * if(pos >=0 && pos <= numRegistro)
	 * flujo.seek(pos*60)
	 * return new Registro(fujo.readUTF(), flujo.readUTF(), flujo.readDouble())
	 * }
	 * return null
	 */
}
