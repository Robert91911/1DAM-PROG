package accesoaleatorio;

import java.io.*;
import java.util.Scanner;

public class BaseDeDatos 
{
	private File fichero;
	public RandomAccessFile flujo;
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
	public Registro leerRegistro(int pos)
	{
		try {
			
			flujo.seek(pos*longitud);
			Registro r = new Registro(flujo.readUTF(),flujo.readUTF(),flujo.readDouble());
			return r;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Marca el registro seleccionado con borrado para su posterior eliminación
	 */
	public boolean eliminarRegistro(String buscado)
	{
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

	public void modificarReferencia(int pos, String referencia) 
	{
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
	public void modificarDesc(int pos, String descripcion) 
	{
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
	public void modificarPrecio(int pos, Double precio) 
	{
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
	public void salirYGuardar() 
	{
		
		if(flujo!=null) //Si flijo es null, es que hay flujos abieros
		{
			cerrar();
			System.out.println("Guardando el archivo");
		}else
			System.out.println("No hay nada que cerrar");
	}
	public void salirSinGuardar() 
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
