package cracional;


public class CRacional
{
 private int num;
 private int den;

 public CRacional(int num, int den) {
	 if(den==0)
		den=1;
	 this.num=num;
	 this.den=den;
 }
 ////////////////////
 public void setNum (int num){
	this.num=num; 
 }
 ///////////////////////////////////////////////
 public int  getNum( ) {
	 return num;
 }
 ///////////////////////////////////////////////////////////
 public void setDen(int den) {
	 if(den==0)
		 den=1;
//	 Denominador no puede ser cero
	 this.den=den;
	 
	 
 }
 /////////////////////////////////////////////////////////////////
 public int getDen() {
	 return den;
 }
 ///////////////////////////////////////////////////////////////////////////
 public CRacional(CRacional a) {
	 num=a.num;
	 den=a.den;
 }
 
 //////////////////////////////////////////////////////////////////
 
 public  CRacional suma(CRacional r2) {
	
	int num= (this.num*r2.den+r2.num*this.den);
	int den= (this.den*r2.den);
	 return new CRacional(num,den) ;
 }
 ///////////////////
 public void verRacional( ) {
	 System.out.println(num +"/"+den);
 }
 //////////////////////////////
 static public  CRacional sumaStatic(CRacional r1,CRacional r2) {
		
		int num= (r1.num*r2.den+r2.num*r1.den);
		int den= (r1.den*r2.den);
		 return new CRacional(num,den) ;
	 }
 


}
