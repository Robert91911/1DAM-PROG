package rectangulo;

public class TestRectangulo {

	public static void main(String[] args)
	{
		//Construimos o instanciamos un rectángulo
		Rectangulo rec1 = new Rectangulo(4, 2);
		Rectangulo rec3 = rec1;
		System.out.println("La base de rec3 es " + rec3.getBase());
		//Modificamos la base del rectángulo
		rec1.setBase(6);
		//invocamos al constructor copia
		rec3 = new Rectangulo(rec1);
		/*Comprobamos que la modificación se ha hecho*/
		System.out.println("La base del rectángulo rect3 es " +rec3.getBase());
		//Enviamos a pantalla el área del triángulo
		System.out.println("El área es " + rec1.area());
		//Enviamo a pantalla el périmetro del triangulo
		System.out.println("El périmetro del rectángulo es" +rec1.perimetro());
		
		//Creamos otro rectángulo.
		Rectangulo rec2 = new Rectangulo();
		rec2.setBase(8);
		//Visualizamos el área de este rectángulo.
		System.out.println("El área de este rectángulo es " + rec2.area());
		System.out.println("la altura del rectángulo es " + rec2.getAltura());
	}
	

}
