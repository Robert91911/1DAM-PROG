package estructurasdecontrol;

import java.util.Scanner;

/**
 * Esta aplicación calcula la potencia de un número
 * @author robert
 *
 */
public class Potencia 
{
    public static void main(String[] args) 
    {
        //Introducimos los datos
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Introduce la base: ");
        int base = entrada.nextInt();
        
        System.out.println("Introduce el exponente: ");    
        int exp = entrada.nextInt();
        
        //Calculamos la potencia
        if (exp == 0) 
        {
            System.out.println("El resultado es 1");
        }
        else 
        {
            
            int resultado = 1;

            for(int cont = 1; cont <= exp; cont++) 
            {
                resultado = base * resultado;
            }
            //Enviamos a pantalla los resultados
            System.out.println( base + " elevado a " + exp + " es igual a " + resultado);
        }
        entrada.close();
    }
}