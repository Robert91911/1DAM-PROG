package accesoAleatorioV2;

import java.io.*;
import java.util.Scanner;

public class BaseDeDatos 
{
	private File fichero;
	private RandomAccessFile flujo;
	private int numRegistros;
	private long longitud = 60;
	private boolean archivoAbierto;

	public BaseDeDatos(File fichero)
	{
		this.fichero = fichero;
		
		
		try {
			flujo = new RandomAccessFile(fichero,"rw");
			long tamFlujo = flujo.length();
			numRegistros = (int) Math.ceil((double)tamFlujo/(double) longitud);
			}catch (IOException e) {
				System.out.println("Error E/S en el constructor.");
		}
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//*****************************************************MENUS*************************************************************************//
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Segun la opcioon seleccionada llama a unos metodos o a otros
	 */
	public void operacionesMenuModificar(int posicion)
	{	
		boolean salir = false;
		do 
		{
			int opcion = verMenuModificar();
			salir = (opcion == 6);
			if(!salir)
			{	
				switch(opcion)
				{ 
					case 1:
						modificarReferencia(posicion);
						break;
					case 2:
						modificarDesc(posicion);
						break;
					case 3:
						modificarPrecio(posicion);
						break;
					case 4:
						salirYGuardar();
						break;
					case 5:
						salirSinGuardar();
						break;
				}
			}
		}while (!salir);	
		System.out.println("Programa finalizado");
	}
	/**
	 * Muestra el menu, comprueba que la opcion es valida y devuelve la opcion
	 * @return
	 */
	public int verMenuModificar() 
	{
		Scanner sc = new Scanner (System.in);
		boolean opcionValida = true;
		int opcion;
		System.out.println("Elige una opción: ");
		System.out.println("1.Referencia");
		System.out.println("2.Descripcion");
		System.out.println("3.Precio");
		System.out.println("4.Salir y guardar los datos");
		System.out.println("5.Salir sin guardar los datos");
		do 
		{			
			opcion = sc.nextInt();	
			opcionValida = (opcion >=1 && opcion <=5);
			if (!opcionValida) 
			{
				System.err.println("Error, introduce una opción válida del 1 al 5");	
			}
		}while (!opcionValida);
		return opcion;
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Cierra el flujo de datos
	 */
	public void cerrar()
	{
		try 
		{
			flujo.close();
			archivoAbierto = false;
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Crea un registro y se lo pasa a escibir registro indicandole la posicion en la que debe escribirlo
	 */
	public void anadirRegistro() 
	{
		Scanner sc = new Scanner (System.in);
		System.out.println("Introduce la posicion del registro que quieres modificar");
		int pos = sc.nextInt();
		System.out.println("Introduce la referencia del registro");
		sc.skip("[ \n]*");
		String referencia = sc.nextLine();
		System.out.println("Introduce la descripcion del registro");
		sc.skip("[ \n]*");
		String descripcion = sc.nextLine();
		System.out.println("Introduce el precio del registro");
		double precio = sc.nextDouble();
		Registro registro = new Registro(referencia, descripcion, precio);
		escribirRegistro(pos, registro);
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Recibe el registro y la posicion del registro y las esctibe en el fichero
	 * @param registro
	 * @param pos
	 * @return
	 */
	public boolean escribirRegistro(int pos, Registro registro)
	{
		 try {
			 if(pos >=0 && pos <= numRegistros) 
			 {
				 flujo.seek(pos*longitud);
				 //return new Registro(flujo.readUTF(), flujo.readUTF(), flujo.readDouble()) != null;
				 flujo.writeUTF(registro.getReferencia()); //registro.getReferencia
				 flujo.writeUTF(registro.getDescripcion()); //registro.getDescricion
				 flujo.writeDouble(registro.getPrecio()); //registro.getPrecio
				 return true;
			 }
		 }catch (Exception e) {
			e.printStackTrace();
		}
		 return false;
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Pasandole la posicion, muestra el registro
	 */
	public void leerRegistro()
	{
		int pos = pedirPosicion();
		try {
			flujo.seek(pos*longitud);
			System.out.print(flujo.readUTF()+" ");
			System.out.print(flujo.readUTF()+" ");
			System.out.println(flujo.readDouble());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Marca el registro seleccionado con borrado para su posterior eliminación
	 */
	public boolean eliminarRegistro()
	{
		String buscado = pedirReferencia();
		for(int i = 0; i<=numRegistros; i++)
		{
			try {
				flujo.seek(i*longitud);
				if(flujo.readUTF().contains(buscado))
				{
					flujo.writeUTF("borrado");
					return true;
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
			
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Pide por teclado la referencia de un objeto y si se ha encontrado se devuelve la referencia del registro, si no se devuelve -1
	 * @return int
	 */
	public long buscar()
	{
		String buscado = pedirReferencia();
		for(int i = 0; i<=numRegistros; i++)
		{
			try {
				flujo.seek(i*longitud);
				if(flujo.readUTF().contains(buscado))
				{
					return (i*longitud);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return -1;
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Se le pasa el nombre del archivo y copia el contenido del fichero original al copia evitanto los registros marcados como borrado.
	 * @param nombre
	 */
	public void actualizar(String nombre)
	{
		try {
			if(archivoAbierto = false)
			{
				this.fichero = new File(nombre);
				RandomAccessFile flujo = new RandomAccessFile(fichero, "rw");
				File aux = new File("aux");
				RandomAccessFile flujoAux = new RandomAccessFile(aux, "rw");
				int regEliminados = 0;
				for(int i = 0; i<=numRegistros; i++)
				{
						
						String registro = flujo.readUTF();
						if(registro != "borrado")
						{
							flujo.seek(i*longitud);
							flujoAux.seek(i*longitud);
							flujoAux.writeUTF(flujo.readUTF()); //Copia del flujo antiguo al nuevo si no esta la marca borrado
						}else
						{
							regEliminados++;
						}
				}
				numRegistros=-regEliminados; //Actualizamos el numero de regitros segun el numero de registros eliminados
				aux.renameTo(fichero); //Renombra el fichero copia con el nombre del original
			}else
			System.out.println("El fichero no está cerrado");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void modificarRegistro() 
	{
		int posicion = pedirPosicion();
		operacionesMenuModificar(posicion);
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private void modificarReferencia(int pos) 
	{
		System.out.println("Introduce una nueva referencia al regsitro");
		Scanner sc = new Scanner(System.in);
		String referencia = sc.nextLine();
		 try {
			 if(pos >=0 && pos <= numRegistros) 
			 {
				 flujo.seek(pos*longitud);
				Registro r =  new Registro();
				r.setReferencia(referencia);
			 }
		 }catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void modificarDesc(int pos) 
	{
		System.out.println("Introduce una nueva referencia al regsitro");
		Scanner sc = new Scanner(System.in);
		String descripcion = sc.nextLine();
		 try {
			 if(pos >=0 && pos <= numRegistros) 
			 {
				 flujo.seek(pos*longitud);
				Registro r =  new Registro();
				r.setDescricion(descripcion);;
			 }
		 }catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void modificarPrecio(int pos) 
	{
		System.out.println("Introduce una nueva referencia al regsitro");
		Scanner sc = new Scanner(System.in);
		double precio = sc.nextDouble();
		 try {
			 if(pos >=0 && pos <= numRegistros) 
			 {
				 flujo.seek(pos*longitud);
				Registro r =  new Registro();
				r.setPrecio(precio);
			 }
		 }catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void salirYGuardar() 
	{
		
		if(flujo!=null) //Si flijo es null, es que hay flujos abieros
		{
			cerrar();
			System.out.println("Guardando el archivo");
		}else
			System.out.println("No hay nada que cerrar");
	}
	private void salirSinGuardar() 
	{
		System.out.println("Saliendo sin guardar");
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Pide al usuario la posición de un registro
	 * @return pos
	 */
	public int pedirPosicion()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el numero del registro que quieres leer");
		int pos = sc.nextInt();
		
		return pos;
	}
	public String pedirReferencia()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Indica la referencia del registro buscado");
		String buscado = sc.nextLine();
		
		return buscado;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
