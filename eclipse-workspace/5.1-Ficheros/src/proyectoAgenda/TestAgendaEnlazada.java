package proyectoAgenda;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class TestAgendaEnlazada {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AgendaLista agenda = new AgendaLista();
		Scanner entrada = new Scanner(System.in);
		System.out.println("Nombre del fichero:");
		File file = new File(entrada.nextLine());

		if (file.exists()) {
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
				agenda=(AgendaLista)ois.readObject();
				
			} catch(EOFException e) {
				System.out.println("Fin de lectura");
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		agenda.seleccionarOperacion();
		try {
			ObjectOutputStream ous = new ObjectOutputStream( new FileOutputStream(file));
			ous.writeObject(agenda);
			ous.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
