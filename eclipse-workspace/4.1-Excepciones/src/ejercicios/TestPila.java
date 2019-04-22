package ejercicios;

import java.io.*;
public class TestPila
{
    public static void main(String args[])
    {
        PilaEstatica pl=new PilaEstatica();
        pl.rellenarPila();
        pl.insertar('x');
        pl.vaciarPila();
        System.out.println();
        pl.eliminar();
        pl.insertar('x');
        pl.eliminar();
    }
}