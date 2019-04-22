package figuraplana;



abstract class FiguraPlana
{
	//miembros dato
	private double base;
	private double altura;
	
	public FiguraPlana()
	{
	}
	
	/////////////////////////////
	
	public FiguraPlana(double base,double altura)
	{
		this.base=base;
		this.altura=altura;
	}
	
	public void setBase(double base)
	{
		this.base=base;
	}
	
	public void setAltura(double altura)
	
	{
		this.altura=altura;
	}
	
	public double getBase()
	{
		return base;
	}
	
	public double getAltura()
	{
		return altura;
	}
	
	public abstract double area();
}

