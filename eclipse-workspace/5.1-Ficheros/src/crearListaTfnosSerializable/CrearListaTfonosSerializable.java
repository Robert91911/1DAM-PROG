package crearListaTfnosSerializable;

import java.io.*;
import java.util.Scanner;


public class CrearListaTfonosSerializable
{
	public static void main(String[] args) 
	{
		try 
		{
			//Comprobamos que el numero de argumentos sea el correcto
			if (args.length == 1) 
			{
				//Si es correcto, creamos un fichero con el nombre del argumento que le hemos pasado
				File fichero = new File(args[0]);
				//Creamos un char resp con el valor por defecto s
				char resp = 's';
				//Si el fichero existe preguntamos al usuario si desea sobreescribirlo
				if (fichero.exists()) 
				{
					System.out.println("Desea sobreescribirlo?: ");
					//Llamamos al metodo getRespuesta()
					resp = getRespuesta();
				}
				if (resp == 's') 
				{
					//Si la respuesta es 's' entonces llamamos al método crearFichero
					crearFichero(fichero);
				}
				//verFichero(fichero);
			} 
			else 
			{
				throw new FalloArgs();
			}
		} 
		catch (FalloArgs e) 
		{
			System.err.println("Error en los argumentos.");
		}
	
	}

	private static void verFichero(File fichero) {
		ObjectInputStream ois = null;
		try {
		    ois = new ObjectInputStream(new FileInputStream(fichero));
		    String nombre = ois.readUTF();
			String direccion = ois.readUTF();
			String telefono = ois.readUTF();
			System.out.println("Nombre: "+nombre+" Direccion: "+direccion+" Telefono: "+telefono);
			
		}
		catch (IOException e) {
			System.err.println("Error en la E/S."+e.getMessage());
		}
		catch (Exception e) {
			System.err.println("Error");
		}
		finally {
			try {
				ois.close();
			}
			catch (Exception e) {
				System.err.println("Error al cerrar el flujo."+e.getMessage());
			}
		}
	}

	private static void crearFichero(File fichero) 
	{
		//Creamos un data output stream y le asignamos de valor predefinido null
		ObjectOutputStream dos = null;
		
		//Creamos un scanner
		Scanner sc = new Scanner(System.in);

		try 
		{
			//Creamos el flujo de datos creando tambien un bufferOutputStream y un FileOutputStream
			dos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fichero)));
			
			do 
			{
				//Preguntamos cada uno de los datos del contacto
				System.out.println("Introduzca el nombre: ");
				String nombre = sc.nextLine();
				System.out.println("Introduce la direccion del contacto");
				String direccion = sc.nextLine();
				System.out.println("Introduzca el telefono: ");
				String telefono = sc.nextLine();
				//Creamos un nuevo concacto de la clase Persona con los datos recogidos anteriormente
				Persona contacto = new Persona(nombre, direccion, telefono);
				//Preguntamos si quiere introducir más datos en el flujo
				System.out.println("Desea seguir escribiendo datos?");
				dos.writeObject(contacto);
			}
			//Si la respuesta es s, repetimos el bucle
			while (getRespuesta() == 's');

		}
		
		catch (IOException e) 
		{
			//Si hay un error E/S lo sacamos por pantalla
			System.out.println("Error en E/S." + e.getMessage());
		} 
		finally 
		{
			try 
			{
				//En el finally intentamos cerrar el flujo de datos
				dos.close();
				//ois.close();
			} 
			catch (IOException e) 
			{
				//Recogemos la excepcion de E/S y sacamos un mensaje por pantalla
				System.out.println("Error al cerrar el flujo de datos");
			}
		}
	}
	private void writeObject(java.io.ObjectOutputStream stream)
		     throws IOException
		{
		   
		}


	public static char getRespuesta() 
	{
		//Creamos un booleano para saber si la repsuestta es valida. Por defecto lo es...
		boolean respValida = true;
		char resp = 0;

		do 
		{
			try 
			{
				//Leemos  de teclado la respuesta
				resp = (char) System.in.read();
			} 
			catch (IOException e) 
			{
				//Si hay un error de E/S lo imprimimos
				e.printStackTrace();
			}
			//Transformamos el char a minusculas
			resp = Character.toLowerCase(resp);
			try 
			{
				//Esto es para que al pulsar enter funcione bien
				System.in.skip(2);
			} 
			catch (IOException e) 
			{
				//Si hay error de E/S lo imprimimos
				e.printStackTrace();
			}
			//La variable booleana que creamos al principio es cierta si se culple alguna de estas dos condiciones
			respValida = (resp == 's' || resp == 'n');
			//Si no es una respuesta valida sacamos por pantalla el siguiente mensaje
			if (!respValida)
				System.out.println("Error teclea s o n");
		}
		//Si la repsuesta no ha sido valida volvemos a repetir todo el do
		while (!respValida);
		//Devuelve la repsuesta
		return resp;
	}
}

class FalloArgs extends Exception {
	public FalloArgs() {
		super();
	}
}