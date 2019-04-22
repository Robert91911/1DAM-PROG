package pilaestatica;
/**
 * Implementacion de una pila estatica
 * 
 * Una pila el último elemento en entrar es el primero 
 * en salir
 * @author profesor
 *
 */
public class PilaEstatica 
{
	//Miembros datos
	private int tam;
	private char pila[];
	
	/*Cima va a ser la posicion donde insertamos y 
	 * eliminamos en la pila
	**/
	private int cima;
	//Constructor
	public PilaEstatica() 
	{
		tam = 'z'-'a'+1;
		pila = new char[tam];
		cima = 0;	
	}
//////////////////////////////////////////////////
	public boolean llena()
	{
		return (cima == tam);
	}
//////////////////////////////////////////////////
	/**
	 * Este metodo inserta una letra del abecedario en la
	 * pila
	 */
	public void meter(char letra)
	{
		//Comprobamos si esta llena
		if(llena())
			System.out.println("La pila esta llena");
		else
			{
				pila[cima] = letra;
				cima++;				
			}
	}
//////////////////////////////////////////////////
	public char sacar()
	{
		if(vacia())
		{
			System.out.println("Error la pila esta vacia");
			return 0;
		}		
		else
			{
				//Nos situamos donde esta el ultimo elemento
				cima--;
				return pila[cima];
			}
	}
//////////////////////////////////////////////////
	public boolean vacia()
	{
		return (cima == 0);
	}
//////////////////////////////////////////////////
	public void rellenar()
	{
		for(char letra = 'a';letra <= 'z';letra++)
		{
			meter(letra);
		}
	}
//////////////////////////////////////////////////
	public void vaciar()
	{
		while(!vacia())
		{
			System.out.print(sacar()+" ");
		}
	}
}
