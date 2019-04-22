package figuraplana;
class TestFiguraPlana
{
	public static void main(String args[])
	{
		
		
		
		Rectangulo r =new Rectangulo(8,5);
		System.out.println("El area del rectangulo "+r.area());
		Triangulo tri =new Triangulo(4,8);
		System.out.println("El area del triangulo "+tri.area());
	}
}