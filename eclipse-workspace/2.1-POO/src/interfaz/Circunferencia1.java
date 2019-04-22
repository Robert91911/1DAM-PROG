package interfaz;

public class Circunferencia1 implements Geometria {
   double radio;
   
   public Circunferencia1(double radio) {
	   this.radio=radio;
	   
   }

@Override
public double area() {
	double a= radio*radio*Math.PI;
	return a;
	
	
}

@Override
public double perimetro() {
	double p =2*Math.PI*radio;
	return p;
}



   
   
}
