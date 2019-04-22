package estructurasdecontrol;

import java.io.IOException;

/**
 * Este programa pride que escribamos una frase, cuando acabemos escribimos un punto
 * y cuenta las letras que hay en la frase.
 * @author robert
 *
 */
public class CuentaPalablas
{
	public static void main(String argas[]) throws IOException
	{
		//Colocamos las variables que vamos a utilizar
		int contPalabras;
		char alfanumerico;
		int cont=0;
		boolean punto=false;
		boolean espacio=true;
		
		System.out.println("Introduce frase, escribe un '.' para finalizar");
		
		do
		{
			alfanumerico=(char)System.in.read();
			punto=(alfanumerico == '.');
				
			if(!punto)
				{
					espacio=(alfanumerico==' ');
					if(espacio)
							cont=cont+1;
				}		
		}while(!punto);
		
		if(cont==0)
			System.out.println("No has introducido nada");
		else
		{
			contPalabras=cont+1;
			System.out.println("El numero de palabras es "+contPalabras);
		}
	}
}
