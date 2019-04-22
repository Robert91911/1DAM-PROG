package coladinamica;

import listaenlazadasimple.Nodo;

public class ColaDinamica
{
	private Nodo primero;
	private Nodo ultimo;
	
	public ColaDinamica()
	{
		primero = null;
		ultimo = null;
	}
	////////////////////////////////////
	public boolean vacia()
	{
		return (primero == null);
	}
	////////////////////////////////////
	public void insertar(Object obj)
	{
		//Creamos un nuevo nodo
		Nodo nuevo = new Nodo(obj, null);
		
		//Comprobamos si la cola esta vacia
		if(vacia())
		{
			primero = nuevo;
			ultimo = nuevo;
		}
		else
		{
			//Enlazar el ultimo nodo con el nuevo
			ultimo.enlace = nuevo;
		}
		ultimo = nuevo;
	}
	////////////////////////////////////
	public Object eliminar()
	{
		if(vacia())
		{
			System.out.println("La cola esta vacia");
			return null;
		}
		else
		{
			Object aux = primero.info;
			primero = primero.enlace;
			
			/*
			 * Este codigo en java funciona perfectamente
			 * pero en c habria que hacer lo siguiente.Si la
			 * cola tuviera un solo elemento, despues de eliminarlo
			 * ultimo quedaria apuntado a ese nodo.La solucion
			 * seria:
			 */
			if(vacia())
			{
				ultimo = null;
			}
			return aux;	
		}
	}
	///////////////////////////////////////
	public void rellenar() 
	{
		for(char letra = 'a';letra <= 'z'; letra++) {
			insertar(letra);
		}
	}
	///////////////////////////////////////
	public void vaciar() 
	{
		if(vacia()) {
			System.out.print("La cola ya esta vacia");
		}
		else {
			while(!vacia()) {
				System.out.print(eliminar() + " ");
			}
		}
	}
	//////////////////////////////////////
}
