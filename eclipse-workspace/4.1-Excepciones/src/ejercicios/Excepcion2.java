/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pepe
 */

package ejercicios;
public class Excepcion2 {

    public static void main(String args[])
    {
        try
        {
        double array[]= new double[2];
        //array[5]=8.5;
        System.out.println("Introduzca el dividendo");
        double dividendo= Leer.datoDouble();
        System.out.println("Introduce el divisor");
        double divisor= Leer.datoDouble();
        if(divisor==0)
            throw new ErrorDivisorCero();
        else
        {
            double resultado=dividendo/divisor;
            System.out.println("El resultado es :" + resultado);
        }


        }
        catch(ErrorDivisorCero error)
        {
            System.out.println("Error, no se puede dividir por 0.");
        }
        catch(ArrayIndexOutOfBoundsException error)
        {
            System.out.println("La posición esta fuera del array");
        }
        finally
        {
            System.out.println("**Abandonando el programa**");
        }
}
}
    class ErrorDivisorCero extends Exception
    {
        public ErrorDivisorCero()
        {
            super();
        }
    }

