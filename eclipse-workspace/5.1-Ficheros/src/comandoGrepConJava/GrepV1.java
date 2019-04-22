package comandoGrepConJava;

//Este ejercicio lo puso en un examen....

import java.io.File;

public class GrepV1 
{
	public static void main(String[] args) 
	{
		try
		{
			if(args.length < 2)
			{
				int numFicheros = args.length;
				for(int i = 1; i<numFicheros; i++)
				{
					File fichero = new File(args[i]);
					if(fichero.exists())
					{
						buscarEnFichero(fichero);
					}else
					{
						throw new FicheroNoExiste();
					}
				}
			}else
			{
				throw new FalloArgs();
			}
			
		}catch (Exception e) {
			
		}
	}

	/**
	 * Lee el fichero y lo manda por pantalla
	 * @param fichero
	 */
	private static void buscarEnFichero(File fichero) 
	{
		//Crear el metodo que busca en cada fichero la palabra indicada por el primer carácter
		
	}
}
class FalloArgs extends Exception {
	public FalloArgs() {
		super();
	}
}

class FicheroNoExiste extends Exception {
	public FicheroNoExiste() {
		super();
	}
}