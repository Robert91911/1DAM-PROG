package ejercicios;

import java.io.*;
public class Leer
{
  public static String dato()
  {
    String sdato = "";
    try
    {
      // Definir un flujo de caracteres de entrada: flujoE
      InputStreamReader isr = new InputStreamReader(System.in);
      BufferedReader flujoE = new BufferedReader(isr);
      // Leer. La entrada finaliza al pulsar la tecla Entrar
      sdato = flujoE.readLine();
    }
    catch(IOException e)
    {
      System.err.println("Error: " + e.getMessage());
    }
    return sdato; // devolver el dato tecleado
  }
  
  public static short datoShort()
  {
    try
    {
      return Short.parseShort(dato());
    }
    catch(NumberFormatException e)
    {
      return Short.MIN_VALUE; // valor m�s peque�o
    }
  }
  
    public static int datoInt()
    {
      try{
      String sdato = dato();
      if  ( sdato == null)
      {
         System.out.println();
         return Integer.MIN_VALUE;
      }
      else
         return Integer.parseInt(sdato);
       }
        catch(NumberFormatException  e)
    {
    System.out.print("Ese dato no es válido. Teclee otro:  ");
     return datoInt();
   }
  }
  
  public static long datoLong()
  {
    try
    {
      return Long.parseLong(dato());
    }
    catch(NumberFormatException e)
    {
      return Long.MIN_VALUE; // valor m�s peque�o
    }
  }
  
  public static float datoFloat()
  {
    try
    {
      Float f = new Float(dato());
      return f.floatValue();
    }
    catch(NumberFormatException e)
    {
      return Float.NaN; // No es un N�mero; valor float.
    }
  }
  
  public static double datoDouble()
    {
      try{
     
         return Double.parseDouble(dato());
       }
        catch(NumberFormatException  e)
    {
    System.out.print("Ese dato no es válido. Teclee otro:  ");
     return datoDouble();
   }
  }
}
