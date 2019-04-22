// Ejemplo de tratamientos de excepiones con throw
/*la sentencia throw lanza una excepci�n, especificando el objeto que se
lanzar�. El operando de throw puede ser cualquier derivada de la
clase Throuwable. El flujo de ejecuci�n se detiene inmediatamente despu�s de
la sentencia throw, ya que el control sale del bloque try y pasa a un
manejador catch cuyo tipo coincide con el objeto */
package ejercicios;
import java.io.*;

public class ExceptionThrow
{
  public static void main(String args[])throws IOException
  {
   String txtOp1, txtOp2;//variables de tipo variables
   Double op1,op2; //objetos de tipo o clase Double no variables
   double resd;//almaceno el resultado
   BufferedReader entrada =
                   new BufferedReader(new InputStreamReader(System.in));
   //BufferedReader coge una "cadena" e indica el final
   //InputStreamReader transforma los bytes que a cogido y las transforma a una
   //cadena
   try{  //entre las llaves puede haber una anomalia

      //bucle infinito, si se produce una excepci�n salimos
      while(true)
      {
       System.out.print("\nNumerador:");
       txtOp1 = entrada.readLine();
       //almacena la cadena transformada en InputStreamReader
            //readLine CAPTURA UNA CADENA Y SABE CUANDO ACABA
       op1 = new Double(txtOp1);
       System.out.print("\nDenominador: ");
       txtOp2 = entrada.readLine();
       op2 = new Double(txtOp2);
       if (op2.doubleValue()==0)/*convierte el objeto de tipo double en un dato
                                             de tipo double*/
           throw new ArithmeticException();
       resd = op1.doubleValue() / op2.doubleValue();
       System.out.println("\nResultdo = " + Double.toString(resd) );
      }//while
     } //try

////////////////////////////// ENVIA UN MENSAJE AL ENCONTRAR LA ANOMALIA
      catch(ArithmeticException objeto)
      {
        System.out.println("\nError aritmetico ." );
      }

    char c = (char)System.in.read();
   }  //main
 }//class
