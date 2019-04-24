
package ejercicios;

import java.io.IOException;

public class Excepcion3 {

    public static void main(String arg[]) //throws IOException
    {
        System.out.println("Pulse una tecla");
        try
        {
            char car = (char) System.in.read();
        }
        catch (IOException ex)
        {
        	System.out.println("Error");
        }

     }
}
