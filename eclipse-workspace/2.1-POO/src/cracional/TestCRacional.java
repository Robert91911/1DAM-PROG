package cracional;

public class TestCRacional {

	
		 public static void main (String[] args)
		 {
		 // Punto de entrada a la aplicaci�n
		 CRacional r1 = new CRacional(1,3); // crear un objeto CRacional
		 CRacional r2 = new CRacional(2,5);
//		 System.out.println(r1.getNum()+" / " + r1.getDen());
//		 System.out.println(r2.getNum()+" / " + r2.getDen());
		 CRacional r3 =r1.suma(r2);
		 r3.verRacional();
		 CRacional r4 = CRacional.sumaStatic(r1, r2);
		 r4.verRacional();
		 }
	}


