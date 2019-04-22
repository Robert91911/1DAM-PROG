package cadena;

import java.io.IOException;
import java.util.Scanner;

public class Cadena  
{
	private int tamMax;
	private char cadena[];
	//////////////////////////
	public Cadena(int tamMax)
	{
		this.tamMax= tamMax;
		cadena = new char[tamMax+1];
	}
	//////////////////////////
	public Cadena(Cadena copia)
	{
		tamMax = copia.tamMax;
		cadena = new char[tamMax+1];
		int i;
		for(i = 0; copia.cadena[i] != '\0'; i++)
		{
			cadena[i] = copia.cadena[i];
		}
		cadena[i] = '\0';
	}
	//////////////////////////
	public void leerCadena() throws IOException
	{
		char letra;
		int numElem = 0;
		System.out.println("Escribe una cadena ");
		do 
		{
			letra = (char) System.in.read();
			if(letra != '\n')
			{
				if(numElem < tamMax)
				{
					cadena[numElem] = letra;
					numElem ++;
				}
			}
			else
				cadena[numElem] = '\0';
		}while(letra != '\n');
	}
	//////////////////////////
	public void leerCadenaWhile() throws IOException
	{
		int i = 0;
		System.out.println("Introduce una cadena");
		char letra = (char) System.in.read();
		
		while(i < tamMax && letra != '\n')
		{
			cadena[i] = letra;
			i++;
			letra = (char) System.in.read();
		}	
		cadena[i] = '\0';
	}
	///////////////////////////
	public void escribirCadenaFor()
	{
		for(int i = 0; cadena[i] != '\0'; i++)
		{
			System.out.print(cadena[i]);	
		}
		System.out.println();
	}
	//////////////////////////
	public void escribirCadenaWhile()
	{
		int i = 0;
		while(cadena[i] != '\0')
		{
			System.out.print(cadena[i]);
			i++;
		}
		System.out.println();
	}
	////////////////////////////////////////
	public int longitud() 
	{
		int i = 0;
		while(cadena[i] != '\0')
		{
			i++;
		}
		return i;
	}
	//////////////////////////
	public void eliminarVocales()
	{
		for(int i = 0; cadena[i] != '\0'; i++)
		{
			if(esVocal(cadena[i]))
			{
				for(int j = i; cadena[j] != '\0'; j++)
				{
					cadena[j] = cadena[j+1];
				}
			}
			
		}
	}
	//////////////////////////
	public boolean esVocal(char letra)
	{
		letra = Character.toLowerCase(letra);
		
		return (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u');
	}
	
	////////////////////////////////
	public boolean isPalindromo2() {
		boolean esPalindromo=true;
		int ultimaPosicion = longitud()-1;
		
		
		for( int i=0; i<ultimaPosicion/2;i++){
			
			if(cadena[i] != cadena[ultimaPosicion]) {
				esPalindromo=false;
			}
			ultimaPosicion--;
		}
		return esPalindromo;
	}
	//FUNCIONA
	////////////////////////////////////////
	public boolean isPalindromo() {
		
		int ultimaPosicion = longitud()-1;
		
		
		for( int i=0; i<ultimaPosicion/2;i++){
			
			if(cadena[i] != cadena[ultimaPosicion-i]) {
				return false;
			}
			
		}
		return true;
	}
}
