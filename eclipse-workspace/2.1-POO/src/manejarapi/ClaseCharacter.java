package manejarapi;


import java.io.IOException;


public class ClaseCharacter {

	public static void main(String[] args) throws IOException {
		
		Character c1 = new Character('A');
		System.out.println("El caracter es " + c1);
		System.out.println("Introduce un caracter");
		char car = (char) System.in.read();
		System.out.println("Has introducido " + car);
		
		if(Character.isDigit(car))
		{
			System.out.println(car + " es igual a un número");	
		}
		else
		{
			//Comprobamos si es una letra
			if (Character.isLetter(car))
			{
				System.out.println(car + " Es una letra");
				//Compruebo si está en mayuscula
				if(Character.isUpperCase(car)) 
				{
					System.out.println(car + " Está en mayúscula");
					//La convertimos a minuscula
					car = Character.toLowerCase(car);
					System.out.println(car + " convertido a minuscula");
					
				}
				else
				{
					System.out.println(car + " es minuscula");
					car = Character.toUpperCase(car);
					System.out.println(car + "convertida a mayuscula" );
				}
			}
			else
			{
				
				System.out.println(car+ " no es una letra");
				if (car == '\n')
					System.out.println("Es un salto de linea");
					
			}
			
				
			
		}
		

	}

}
