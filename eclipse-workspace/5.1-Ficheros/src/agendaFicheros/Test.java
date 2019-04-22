package agendaFicheros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Test {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// instanciamos una agenda.
		Agenda agenda = new Agenda();

		// Declaramos un nombre para el fichero.
		System.out.println("Introduce el nombre del fichero de la agenda");
		String nombre;
		nombre = sc.nextLine();

		// Creamos el file para comprobar si existe.
		File fichero = new File(nombre);

		// Si existe, leemos la agenda.
		try 
		{
			if (fichero.exists()) 
			{
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
				agenda = (Agenda) ois.readObject();
			}
			agenda.arrancarAplicacion();
			ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(fichero));
			
			// Guardamos en el fichero la agenda.
			ous.writeObject(agenda);
			ous.close();
		}
		
		catch (IOException e) 
		{
			System.out.println("Error E/S");
		} 
		
		catch (ClassNotFoundException e) 
		{
			System.out.println("Error con la Clase");
		}

	}
}
