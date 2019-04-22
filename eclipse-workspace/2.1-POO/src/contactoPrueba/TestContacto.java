package contactoPrueba;

public class TestContacto 
{

	

	public static void main(String[] args)
	{
		Contacto contacto = new Contacto("Pepe", "6567799");
		System.out.println(contacto.toString());
		System.out.println(contacto);
		System.out.println(contacto.toString());
		
		Contacto otroContacto = new Contacto("Pepe", "6567799");
		
		System.out.println(contacto == otroContacto);
		
		System.out.println(contacto.equals(otroContacto));
		 
		int resultado = contacto.compareTo(otroContacto);
		
		System.out.println(resultado);
	}	

}