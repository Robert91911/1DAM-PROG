/* Proyecto ejemplo para controlar errores

	 Este ejemplo es una calculadora. Para ello se introducen
	 tres par�metros: operaci�n, primer operando y segundo
	 operando. El resultado ser� algo as�:
	 	
	 + 7 8 dar�a 15
	 
	 . 9 2 dar�a 18
	 
	 
	 Errores a controlar:
	 	
	 + 7 Falta un par�metro
	 
	 / 7 0 Runtime Exception
	 
	 - Luis Jos� No se puede convertir a entero   */
	 
package ejercicios;
import java.io.*;

class CalculadoraV4
{
	public static void main(String arg[])  throws IOException
	{

		
    /* a diferencia de C++, los par�metros si deben aparecer en la
    declaraci�n de m�todo main, el nombre del programa no forma parte de
    los argumentos que se pasan al programa, el siguiente bucle imprime
    la lista de argumentos que se pasan al programa  */

    	for( int i = 0; i < arg.length; i++)
       		System.out.println(arg[i]);

    	System.out.println("\n Tratamiento de Excepciones");
		try
		{
        	if (arg.length != 3)
            	throw new ErrorArgumentos();
            else
            {
				switch (arg[0].charAt(0))
				{
					case '+':
						System.out.println ("Suma "+arg[1]+" y "+arg[2]+"\n");
						System.out.println ("Resultado= "+(Integer.parseInt
							(arg[1])+Integer.parseInt(arg[2])));
					break;
					case '-':
						System.out.println ("Resta "+arg[1]+" y "+arg[2]+"\n");
						System.out.println ("Resultado= "+(Integer.parseInt
							(arg[1])-Integer.parseInt(arg[2])));
					break;
					case '.':
						System.out.println ("Multiplica "+arg[1]+" y "+arg[2]+"\n");
						System.out.println ("Resultado= "+(Integer.parseInt
							(arg[1])*Integer.parseInt(arg[2])));
					break;
					case '/':
						System.out.println ("Divide "+arg[1]+" y "+arg[2]+"\n");
						System.out.println ("Resultado= "+(Integer.parseInt
							(arg[1])/Integer.parseInt(arg[2])));
					break;
				} // switch
			}

		} // try

		// Errores no verificables que se van a controlar


		catch(ArrayIndexOutOfBoundsException error)
		{
         	System.out.println("\n Desbordamiento ");
		}
		
		catch(ErrorArgumentos error)
        {
        	System.out.println("Numero de argumentos incorrectos. Los argumentos deben de ser 3");
        }

		catch(ArithmeticException error)
		{
			System.out.println("No se puede dividir por cero");
		}
		
		catch(NumberFormatException error)
		{
			System.out.println("Los parametros deben ser enteros");
		}

		finally
		{
			System.out.println("Adios");
		}

    	char a =(char) System.in.read() ;

	} // main
} // class

class ErrorArgumentos extends Exception
{
	public ErrorArgumentos()
	{
    	super();
 	}

}


