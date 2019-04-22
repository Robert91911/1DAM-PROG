package cadena;

import java.io.IOException;

public class TestCadena 
{

	public static void main(String[] args) throws IOException 
	{
		Cadena cadena1 = new Cadena(20);
		cadena1.leerCadena();
		cadena1.escribirCadenaFor();
		/*Cadena cadena2 = new Cadena(cadena1);
		System.out.println("La segunda cadena es: ");
		cadena2.escribirCadenaWhile();
		cadena2.contadorCaracteres();
		cadena2.eliminarVocales();
		cadena2.escribirCadenaWhile();*/
		if(cadena1.isPalindromo())
			System.out.println( "Cadena 1 es un palindromo");
		else 
			System.out.println("No es un palindromo ");
	}

}
