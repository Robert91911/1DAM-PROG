package circulo;

public class TestCirculo {

	public static void main(String[] args) {

		Circulo cir1 = new Circulo();
		
		System.out.println("El radio del ciruclo es: " + cir1.getRadio());
		
		System.out.println("El area del circulo es de: " + cir1.area());
		
		Circulo cir2 = new Circulo(10);
		
		System.out.println("El radio del ciruclo es: " + cir2.getRadio());
		
		System.out.println("El area del circulo es de: " + cir2.area());
		
		System.out.println("El perimetro del circulo es de: " + cir2.perimetro());
		
		
		
	}


}