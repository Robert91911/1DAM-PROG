package ejercicios;


public class Excepcion {

    public static void main(String args[])
    {
        try
        {
        double array[]=new double[1000000000];
        }
        catch(OutOfMemoryError error)
        {
            System.out.print("Memoria insuficiente \n");
        }

    }

}
