package figuraplana;

class Rectangulo extends FiguraPlana
{
	public Rectangulo (double base, double altura)
	{
		super(base,altura);
	}
	
    public double area()
    {
    	return getBase()*getAltura();
    }
}