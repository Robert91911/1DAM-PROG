package rectangulo;

import java.util.Scanner;

public class Rectangulo 
{
	static Scanner entrada = new Scanner(System.in);
	//Atributos o miembros dato
	private double base;
	private double altura;
	
	//Constructor
	/*Un constructor es un método especial cuyo objetivo.
	 Es inicializar los atributos de un objeto.
	Un constructor se llama siempre igual que la clase.*/
	 public Rectangulo(double base, double altura)
	 {
		 this.base = base;
		 this.altura = altura;
	 }
	 /////////////////////////////////
	 public Rectangulo()
	 {
		 System.out.println("Introduzca base:");
		 base = entrada.nextDouble();
		 System.out.println("Introduzca altura:");
		 altura = entrada.nextDouble();
	 }
	 
	 //////////////////////
	 //Constructor copia.
	 public Rectangulo(Rectangulo copia)
	 {
		 
		 base = copia.base;
		 altura = copia.altura;
	 }
	
	//Miembros método u operaciones que puedo hacer con el objeto
	public double getBase()
	{
		return base;
	}
	////////////////////////////////////////////
	public void setBase(double base) 
	{
		this.base = base;
	}
	///////////////////////////////////////
	public double getAltura()
	{
	return altura;
	}
	////////////////////////////////////////
	public void setAltura(double altura) 
	{
	this.altura = altura;
	}
	///////////////////////////////////////////
	public double area()
	{
		return base * altura;
	}
	/////////////////////////////////////////
	public double perimetro()
	{
		return 2*(base + altura);
	}
	
	
	
}
