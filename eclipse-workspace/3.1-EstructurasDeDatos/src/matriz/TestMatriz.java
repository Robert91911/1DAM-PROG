package matriz;

public class TestMatriz {

	

	public static void main(String[] args) 
	{
		Matriz matriz = new Matriz();
		matriz.introducirDatos();
		matriz.verMatriz();
		System.out.println("la suma de la diagonal principal es:" + matriz.sumaDiagonalV1());
		System.out.println("la suma encima de la diagonal principal es:" + matriz.sumaEncimaDiagonal());
		System.out.println("la suma encima de la diagonal principal es:" + matriz.sumaEncimaDiagonalV2());
		System.out.println("la suma encima de la diagonal principal V3 es:" + matriz.sumaDiagonalV3());
		matriz.sumaTotalesFilasColumnas();
	}

}
