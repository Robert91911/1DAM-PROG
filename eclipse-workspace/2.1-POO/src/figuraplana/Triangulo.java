package figuraplana;

class Triangulo extends FiguraPlana
{
	public Triangulo (double base, double altura)
	{
		super(base,altura);
	}
	
    public double area()
    {
    	return (getBase()*getAltura())/2;
    }
 
}