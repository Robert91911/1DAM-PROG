package ejercicios;
import java.io.*;
public class PilaEstatica
{
    //miembros dato
    private char pila [];
    private final int tamMax;
    private int cima;
    
    public PilaEstatica()
    {
        tamMax='z'-'a'+1;
        cima=0;
        pila=new char [tamMax];
        
    }
    
    ///////////////////////////////////////////////////////////////////77
    
    public boolean pilaLlena()
    {
        return (cima==tamMax);
    }
    
    /////////////////////////////////////////////////////////////////////
    
    public boolean pilaVacia()
    {
        return (cima==0);
    }
    
    ///////////////////////////////////////////////////////////////////
    
    public void insertar(char car)
    {
        try
        {
           if(pilaLlena())
             throw new PilaEstaLlena();
            else
            {
                pila[cima]=car;
                cima++;
            }  
        }
        catch(PilaEstaLlena error)
        {
            System.out.println("La pila esta llena");
        }
         
    }
    
    /////////////////////////////////////////////////////////////////////
    
    public char eliminar()
    {
	    try {
	        if(pilaVacia())
	        {
	            throw new ErrorPilaVacia();
	        }
	        else
	        {
	            cima--;
	            return pila[cima];
	        }   
	    }
	    catch(ErrorPilaVacia error) {
	    	System.out.println("Error la pila esta vacia");
	    	return 0;
	    }
   }
    
    ////////////////////////////////////////////////////////////////////////
    
    public void rellenarPila()
    {
        char letra;
        for(letra='a';letra<='z';letra++)
        {
            insertar(letra);
        }
    }
    
    //////////////////////////////////////////////////////////////////////
    
    public void vaciarPila()
    {
        while(!pilaVacia())
            System.out.print(eliminar()+" ");
    }
}

///////////////////////////////////////////////////////////////////////////

class PilaEstaLlena extends Exception
{
    public PilaEstaLlena()
    {
        super();
    }
}
class ErrorPilaVacia extends Exception
{
	public ErrorPilaVacia()
	{
		super();
	}
}