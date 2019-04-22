package ejercicio6;
import java.io.*;

public class CrearListaTfnos 
{
	public static void main(String[] args) 
	{
		try {
			if (args.length == 1) {
				File file = new File(args[0]);
				char resp = 's';
				
				if (file.exists()) {
					System.out.println("El archivo ya existe, ¿quiere sobreescribirlo? (S/N)");
					resp = getRespuesta();
				}
				
				if (resp == 's') {
					crearFichero(file);
				}
			} else {
				throw new ParametrosException();
			}
		} catch (ParametrosException e) {
			System.out.printf("Excepción: %s\n", e.getMessage());
			System.out.println("Sintaxis correcta: java -jar <Programa> <Archivo>");
		} catch (Exception e) {
			System.out.printf("Excepción: %s\n", e.getMessage());
		}
	}
	public static void crearFichero(File file) {		
		System.out.println("Escribe caracteres y Crlt+D para terminar y escribir al fichero");
		FileWriter writer = null;
		
		try {
			writer = new FileWriter(file);
			
			int caracter;
			while ((caracter = System.in.read()) != -1) {
				writer.write((char)caracter);
			}
		} catch (IOException e) {
			System.out.println("Excepción: " + e.getMessage());
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				System.out.println("Excepción: " + e.getMessage());
			}
		}
		
		System.out.println("\nArchivo guardado y programa terminado");
	}
	public static char getRespuesta() {
		boolean respValida = true;
        char resp = '\0';
        do {
        	try {
        		 resp = (char)System.in.read();
                 System.in.skip(2);
        	} catch (IOException e) {
        		System.out.println("Error: " + e.getMessage());
        	}
           
        	resp = Character.toLowerCase(resp);
            respValida = (resp == 's' || resp == 'n');
            if (!respValida)
            	System.out.println("Error teclea s o n");
        } while (!respValida);
        
        return resp;
	}
}

class  ParametrosException extends Exception{
	public ParametrosException() 
	{
		super();
	}
}
