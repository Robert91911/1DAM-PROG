package estructurasdecontrol;

import java.io.IOException;

public class DoWhileV2 {
	
	public static void main(String[] args) throws IOException
	{
		//Variables
		//Char porque es un caracter	
		char resp;
		boolean respValida = true;
		System.out.println("Introduce una 'S' o una 'N': ");
		
		// "&&"  es equivalente a y	.
		do {
			resp = (char) System.in.read();
			//La siguiente linea salta dos caracteres en el buffer de teclado
			System.in.skip(2);
			
			//Para que funcione tecleando minusculas y mayusculas.
			resp = Character.toUpperCase(resp);
			
			respValida = (resp == 'S' || resp == 'N');
			
			
			if (!respValida)
				System.out.println("Respuesta no valida, teclea 'S' o una 'N': ");
			} 
				while (!respValida); //!respValida equiVale a respValida = false
		
		
	}

}
