package guardarAgendaEnFichero;

import java.io.*;

public class EscribirYLeer 
{

	public static void main(String[] args) 
	{
		
		EscribirYLeer eyl = new EscribirYLeer();
		System.out.println("¿Quieres guardar la agenda?");
        eyl.escribeFichero("fichero.dat");
        eyl.leeFichero("fichero.dat");
		
	}
	    public void escribeFichero(String fichero)
	    {
	        try
	        {
	            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(fichero));
	                Agenda a = new Agenda();
	                a.arrancarAplicacion();
	                oos.writeObject(a);
	                oos.close();
	        } catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	    }
	    
	    
	    /**
	     * Se leen todas las Persona en el fichero y se escriben por pantalla.
	     * @param fichero El path completo del fichero que contiene las Persona.
	     */
	    public void leeFichero(String fichero)
	    {
	        try
	        {
	            // Se crea un ObjectInputStream
	            ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(fichero));
        		Object aux = ois.readObject();
	            while (aux!=null)
	            {
	                if (aux instanceof Agenda)
	                    System.out.println(aux);
	                aux = ois.readObject();
	            }
	            ois.close();
	        }
	        catch (EOFException e1)
	        {
	            System.out.println ("Fin de fichero");
	        }
	        catch (Exception e2)
	        {
	            e2.printStackTrace();
	        }
	    }
	}