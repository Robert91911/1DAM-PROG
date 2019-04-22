package accesoAleatorio;

import java.io.File;
import java.util.Scanner;

public class TestBaseDeDatos 
{
	
	public static void main(String[] args) 
	{
		BaseDeDatos db = new BaseDeDatos("baseDeDatos.dat");
		db.operacionesMenu();
	}

}
