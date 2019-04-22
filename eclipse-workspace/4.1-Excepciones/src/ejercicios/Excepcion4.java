package ejercicios;

import java.io.IOException;

public class Excepcion4 {
    public static void main(String arg[])
    {
        try
        {
            System.out.println("Desea continuar...(s/n)");
            char resp=getRespuesta();
        }
        catch(IOException error)
        {
        }

    }
        public static char getRespuesta() throws IOException
        {
           /* char resp;
            do
            {
                 resp=(char)System.in.read();
            }while((resp!='s') && (resp!='n'));
            */

            boolean respValida=true;
            char resp;
            do{
                resp=(char)System.in.read();
                resp=Character.toLowerCase(resp);
                System.in.skip(2);
                respValida=(resp=='s' || resp=='n');
                if(!respValida)
                    System.out.println("Error teclea s o n");
            }while(!respValida);
            return resp;
         }
}
