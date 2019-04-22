package interfaz;

public class Rectangulo1 implements Geometria {
double base;
double altura;
public Rectangulo1(double base, double altura) {
	this.base=base;
	this.altura=altura;
}
	@Override
	public double area() {
		double a =base*altura;
		return a;
	}

	@Override
	public double perimetro() {
		double p = base*2+altura*2;
		return p;
	}
	

}
