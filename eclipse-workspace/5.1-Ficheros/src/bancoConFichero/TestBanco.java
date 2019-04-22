package bancoConFichero;

import java.io.*;
import java.util.Scanner;

public class TestBanco 
{
static Scanner sc = new Scanner(System.in);
	
public static void main(String[] args) 
	{
		Banco banco = new Banco();
		
		System.out.println("Introduce el nombre del fichero");
		File file = new File(sc.nextLine());
		
		if(file.exists()) 
		{
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
				banco =(Banco)ois.readObject();
			}
			catch(EOFException e) 
			{
				System.out.println("----------Fin de la lectura----------");
			}
			catch(IOException e) 
			{
				e.printStackTrace();
			}
			catch(ClassNotFoundException e)
			{
				e.printStackTrace();
			}
		}
		
		banco.operacionesMenu();
		try
		{
			ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(file));
			ous.writeObject(banco);
			ous.close();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

}
