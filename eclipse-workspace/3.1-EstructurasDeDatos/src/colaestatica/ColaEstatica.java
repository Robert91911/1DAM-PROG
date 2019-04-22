package colaestatica;

public class ColaEstatica 
{
	/**
	 * La calse implementa una cola estática.
	 * En una cola se inserta por el final y se elimina
	 * por el principio, primero en entrar primero en 
	 * salir FIFO
	 */
	private int tam;
	private char cola[];
	private int principio;
	private int ultimo;
	
	public ColaEstatica()
	{
		tam = 'z'-'a'+1;
		cola = new char [tam];
		ultimo = 0;
		principio = 0;
		
	}
/////////////////////////////////////////////
	public boolean llena()
	{
		return(ultimo == tam);
	}
/////////////////////////////////////////////
	public boolean vacia()
	{
		return (principio == ultimo);
	}
/////////////////////////////////////////////
	public void meter(char letra)
	{
		if(llena())
			System.out.println("La cola esta llena");
		else
			{
				cola[ultimo] = letra;
				ultimo++;
			}
	}	
/////////////////////////////////////////////
		public char sacar()
		{
			if(vacia())
			{
				System.out.println("La cola esta vacia");
				return 0;
			}
			else
			{
				principio++;
				return cola[principio-1];
			}
				
		}
		///////////////////////////////
		public void rellenar()
		{
			for(char letra = 'a'; letra <= 'z';letra++)
			{
				meter(letra);
			}
		}
		/////////////////////////////
		public void vaciar()
		{
			while(!vacia())
			{
				System.out.print(sacar() + " ");
			}
		}
	}
	

