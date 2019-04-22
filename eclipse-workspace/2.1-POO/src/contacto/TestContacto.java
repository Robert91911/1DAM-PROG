package contacto;

public class TestContacto {

	public static void main(String[] args) {
		
		Contacto c1 = new Contacto("Pepe", "999999999");
		Contacto c2 = new Contacto("Pepa", "997999999");		
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c1.toString());
		
		System.out.println(c1==c2);
		
		System.out.println(c1.equals(c2));
		System.out.println(c1.equals(c2));
		System.out.println(c1.equalsVictor(c2));
		System.out.println(c1.compareTo(c2));
		System.out.println(c1.compareTo(c2));
	}
	
}
