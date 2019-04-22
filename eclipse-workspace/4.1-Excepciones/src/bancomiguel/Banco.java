package bancomiguel;

import java.util.Scanner;



/**
 * Esta clase utilizará un array dinámico denominado clientes que almacene la
 * referencia al tipo de cuenta manejada en un momento determinado. El número de
 * elementos del array será otro miembro de la clase.
 * 
 * @author miguel
 *
 */
public class Banco {
	private CCuenta array[];
	private int numClientes;

	/*
	 * Un constuctor sin parámetros que inicialice el número de cuentas y reserve
	 * espacio en memoria para el array.
	 */

	public Banco() {
		numClientes = 0;
		array = new CCuenta[numClientes];
	}

	//////////////////////////
	// Métodos

	void unElementoMas(CCuenta aux[]) {
		// Un elemento más
		array = new CCuenta[numClientes + 1];

		// Copiamos los elementos en array
		for (int i = 0; i < numClientes; i++) {
			array[i] = aux[i];
		}
		// Actualizamos el numero de clientes.
		numClientes++;
	}

	//////////////////////
	int busquedaCuenta(String numCuenta) {
		for (int i = 0; i < numClientes; i++) {
			if (array[i].getCuenta().equals(numCuenta)) {
				return i;
			}
		}
		return -1;
	}

	/////////////////////////

	void unElementoMenos(CCuenta copia[]) {
		// Solicitamos la eliminacion de un elemento menos.
		array = new CCuenta[numClientes - 1];

		// Recorremos el array hasta encontrar el null
		// Creamos una variable para incrementar solo cuando el contacto sea !null
		int copiado = 0;

		for (int i = 0; i < numClientes; i++) {
			if (copia[i] != null) {
				array[copiado] = copia[i];
				copiado++;
			}
		}
		numClientes--;
	}

	/////////////////////

	boolean marcar(int posicion) {
		array[posicion] = null;
		unElementoMenos(array);
		return true;
	}

	//////////////////////

	void insertarEn(CCuenta nueva, int posicion) {

		if (posicion < numClientes && posicion >= 0) {// Validar posicion
			array[posicion] = nueva;
		} else
			System.out.println("La posicion no es correcta.");
	}

	/////////////////////

	void anadir(CCuenta cliente) {
		unElementoMas(array);
		insertarEn(cliente, numClientes - 1);
	}

	///////////////////
	CCuenta retornarValor(int posicion) {

		if (posicion < numClientes && posicion >= 0) {
			return array[posicion];
		}

		return null;

	}

	///////////////////
	boolean arrayVacio() {
		return (numClientes == 0);
	}

	//////////////////
	boolean eliminar(String numCuenta) {
		// Comprobamos si esta vacia.
		if (arrayVacio()) {
			System.out.println("El banco no tiene ninguna cuenta. ");
		} else {
			// Comprobar si existe.
			int posicion = busquedaCuenta(numCuenta);
			boolean existe = (posicion != -1);
			if (existe) {
				// Si existe lo marcamos para eliminar
				if (TestBanco.getRespuesta() == 's') {
					if (marcar(posicion)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	///////////////

	void verBanco() {
		if (arrayVacio()) {
			System.out.println("Banco vacio.");
		} else {
			System.out.println("CUENTAS: ");
			for (int i = 0; i < numClientes; i++) {
				array[i].verDatos();
			}
		}
	}

	/////////////
	void verCuenta(int pos) {
		array[pos].verDatos();
	}

	///////////
	int getNumClientes() {
		return numClientes;
	}
}
