package estructurasdecontrol;

import java.io.IOException;

public class DoWhile {

/*Programa que pida por teclado una respuesta, sabiendo que son válidas la S y la N. 
 * En caso de que no sea válida, tiene que volver a pedirla*/	
	
	public static void main(String[] args) throws IOException
	{
	//Variables
	//Char porque es un caracter	
	char resp;
	System.out.println("Introduce una 'S' o una 'N': ");
	
	// "&&"  es equivalente a y	.
	do {
		resp = (char) System.in.read();
		
		//Para que funcione tecleando minusculas y mayusculas.
		resp = Character.toUpperCase(resp);
		
		//La siguiente linea salta dos caracteres en el buffer de teclado
		System.in.skip(2);
		
		if (resp != 'S' && resp != 'N')
			System.out.println("Respuesta no valida, teclea 'S' o una 'N': ");
		} 
			while (resp != 'S' && resp != 'N');
	
	}
}
