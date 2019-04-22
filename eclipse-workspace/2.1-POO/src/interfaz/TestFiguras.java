package interfaz;

public class TestFiguras {

	public static void main(String[] args) {
		Geometria interfaz;
		Rectangulo1 rprueba=null;
		System.out.println(rprueba);
		//Rectangulo1 r1 = new Rectangulo1(2, 3);
		//System.out.println(r1);
		interfaz=new Rectangulo1(2,3);
		System.out.println("El area de un rectangulo " + interfaz.area());
		System.out.println("El perimetro del rectangulo es " +interfaz.perimetro());
		Circunferencia1 c1 =  new Circunferencia1(4);
		interfaz=c1;
		System.out.println("El area del circulo es "+interfaz.area());
		System.out.println("El perimetro del circulo es " +interfaz.perimetro());
		
	}

}
