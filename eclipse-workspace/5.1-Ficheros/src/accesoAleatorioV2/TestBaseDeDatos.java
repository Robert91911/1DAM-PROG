package accesoAleatorioV2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class TestBaseDeDatos
{
	static BaseDeDatos db = new BaseDeDatos(new File("bbdd.dat"));
	public static void main(String[] args) 
	{

		operacionesMenu();
	}
	/**
	 * Segun la opcioon seleccionada llama a unos metodos o a otros
	 */
	public static void operacionesMenu()
	{	
		boolean salir = false;
		do 
		{
			int opcion = verMenuGeneral();
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
						db.anadirRegistro();
						break;
					case 4:
						db.modificarRegistro();
						break;
					case 5:
						db.eliminarRegistro();
						break;
					case 6:
						db.leerRegistro();
						break;
				}
			}
		}while (!salir);	
		System.out.println("Programa finalizado");
		db.cerrar();
		
	}
	/**
	 * Muestra el menu, comprueba que la opcion es valida y devuelve la opcion
	 * @return
	 */
	static public int verMenuGeneral() 
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
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Crea un fichero nuevo, vacio si el fichero no existe
	 */
	public static void crearFichero() 
	{
		File fichero = new File("bbdd.dat");
		boolean existe = fichero.exists();
		do
		{
			if(existe) 
			{
				System.out.println("El archivo ya existe");
				fichero.list();
			}
			else
			{
				try {
				  if (existe)
				  {
						fichero.createNewFile();
						System.out.println("El fichero se ha creado correcnumRegistroente");
				  }
				  else
					    System.out.println("El fichero no se puede crear");
				} catch (IOException ioe) 
					{
				  ioe.printStackTrace();
					}
				}
		}
		while(!existe);
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void abrirFichero()
	{
		try 
		{
			BaseDeDatos db = new BaseDeDatos(new File("bbdd.dat"));
			System.out.println("El fichero ahora está abierto");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
