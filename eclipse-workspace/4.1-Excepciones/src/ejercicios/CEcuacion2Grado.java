package ejercicios;

import java.io.*;
 public class CEcuacion2Grado

 {
 	public static void main (String args[] )
 	{
 		//Variables
 		double a;
 		double b=0;
 		double c=0;
 		double re;
 		double d;
 		double im;
 		
 		System.out.println("Introduce a");
 		a=Leer.datoDouble();
 		System.out.println("Introduce b");
 		b=Leer.datoDouble();
 		System.out.println("Introduce c");
 		c=Leer.datoDouble();
 		
        try
          {
           if(a==0 && b==0)
 			throw new Degenerada();
 			
 			else
 				if(a==0)
 				{
 					re=-c/b;
 					System.out.println("La ecuacion es "+re);
 				}	
 					else
 					{
 						re=-b/(2*a);
 						d=b*b-4*a*c;
 						im=Math.sqrt(Math.abs(d))/(2*a);
 			
 						if (d>=0)
 						{
 							System.out.println("Raices reales");
 							System.out.println((re+im)+","+(re-im));
 						}		
 							else
 							{
 								throw new Compleja();
 								
 							}//finsi
 					
                                         }//finelse
                }
                catch(Degenerada error )
                {
                    System.out.println("La ecuacion es degenerada");
                }
                catch(Compleja error )
                {
                    System.out.println("La ecuacion es compleja");
                }
 				
 			
 	}//fin main
 }
        
        class Degenerada extends Exception
        {
            public Degenerada()
            { 
            super();
            }
        }
        
        class Compleja extends Exception
        {
            public Compleja()
            { 
            super();
            }
        }

  