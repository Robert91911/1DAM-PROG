/**
 * 
 * Modificar TestBanco, incluyendo una funcion denominada getRespuesta() que sirva
para confirmar si desea eliminar un elemento, atrapando y manejando la excepcion
que se pueda producir. 
 */

package bancomiguel;

import java.io.IOException;
import java.util.Scanner;

public class TestBanco {
	static Scanner entrada = new Scanner(System.in);
	static Banco banco = new Banco();

	public static void main(String[] args) {

		operacionesMenu();
	}

	////////////////////////////////
	static void operacionesMenu() {
		boolean salir = false;
		do {
			int opcion = verMenu();
			salir = (opcion == 8);
			switch (opcion) {
			case 1:
				consultarSaldo();
				break;
			case 2:
				ingreso();
				break;
			case 3:
				reintegro();
				break;
			case 4:
				altas();
				break;
			case 5:
				bajas();
				break;
			case 6:
				mantenimiento();
				break;
			case 7:
				banco.verBanco();
				break;
			}
		} while (!salir);
		System.out.println("El programa ha finalizado");
	}

	/////////////////////////////////
	static int verMenu() {

		int opcion;
		boolean opCorrecta;
		System.out.println("1- CONSULTAR SALDO");
		System.out.println("2- INGRESO");
		System.out.println("3- REINTEGRO");
		System.out.println("4- ALTAS");
		System.out.println("5- BAJAS");
		System.out.println("6- MANTENIMIENTO");
		System.out.println("7- VER CUENTAS");
		System.out.println("8- SALIR");
		do {
			opcion = entrada.nextInt();
			opCorrecta = (opcion >= 1 && opcion <= 8);
			if (!opCorrecta) {
				System.out.println("Error, la opcion es incorrecta: (Teclee del 1 al 8)");
			}
		} while (!opCorrecta);
		return opcion;
	}

	//////////////////////////////
	static void consultarSaldo() {
		if (banco.arrayVacio()) {
			System.out.println("El banco no tiene ninguna cuenta. ");
		} else {
			String bug = entrada.nextLine();
			String numCuenta = introducirDatos();
			int posicion = banco.busquedaCuenta(numCuenta);
			boolean existe = (posicion != -1);
			if (existe) {
				banco.verCuenta(posicion);
			} else {
				System.out.println("La cuenta no existe");
			}
		}
	}

	////////////////////////////////
	static void altas() {
		int tipoCuenta;
		boolean cuentaCorrecta;
		System.out.println("1- CUENTA AHORRO");
		System.out.println("2- CUENTA CORRIENTE");
		System.out.println("3- CUENTA CORRIENTE CON INTERESES");
		do {
			tipoCuenta = entrada.nextInt();
			cuentaCorrecta = (tipoCuenta >= 1 && tipoCuenta <= 3);
			if (!cuentaCorrecta) {
				System.out.println("Porfavor, introduzca un tipo de cuenta correcta.");
			}
		} while (!cuentaCorrecta);

		leerDatos(tipoCuenta);
	}

	static void leerDatos(int tipoCuenta) {
		String fixerror = entrada.nextLine();

		CCuenta cuenta = null;
		System.out.println("Introduce el nombre de la cuenta: ");
		String nombre = entrada.nextLine();

		String numCuenta = introducirDatos();

		System.out.println("Introduce los intereses de la cuenta: ");
		double interes = entrada.nextDouble();

		double saldo = 0;
		System.out.println("Introduce el saldo de la cuenta: ");

		do {
			System.out.println("El saldo de la cuenta tiene que ser superior a 0.");
			saldo = entrada.nextDouble();
		} while (saldo <= 0);

		if (tipoCuenta == 1) {
			System.out.println("Introduce la cuota de mantenimiento: ");
			double cuotaMantenimiento = entrada.nextDouble();
			cuenta = new CCuentaAhorro(nombre, numCuenta, interes, saldo, cuotaMantenimiento);

		} else {
			System.out.println("Introduce el importe por transacción: ");
			double importePorTrans = entrada.nextDouble();

			if (tipoCuenta == 2) {
				System.out.println("Introduce el importe por transacion exenta: ");
				int transExen = entrada.nextInt();
				cuenta = new CCuentaCorriente(nombre, numCuenta, interes, saldo, importePorTrans, transExen);

			} else {
				System.out.println("Introduce el importe por transacion exenta: ");
				int transExentas = entrada.nextInt();
				cuenta = new CCuentaCorrienteConIn(nombre, numCuenta, interes, saldo, importePorTrans, transExentas);
			}
		}
		banco.anadir(cuenta);
	}

	/////////////////////////////////////

	static void bajas() {
		String bug = entrada.nextLine();
		String numCuenta = introducirDatos();

		if (banco.eliminar(numCuenta)) {
			System.out.println("La cuenta ha sido eliminada.");
		} else {
			System.out.println("La cuenta no existe");
		}
	}

	////////////////////////////
	static void ingreso() {
		String bug = entrada.nextLine();
		String numCuenta = introducirDatos();
		int posicion = banco.busquedaCuenta(numCuenta);

		CCuenta cuenta = banco.retornarValor(posicion);

		if (cuenta == null) {
			System.out.println("La cuenta no existe");
		} else {
			System.out.println("Introduzca la cantidad deseada a ingresar: ");
			double cantidad = entrada.nextDouble();
			cuenta.ingreso(cantidad);
		}
	}

	////////////////////////////
	static void reintegro() {
		String bug = entrada.nextLine();
		String numCuenta = introducirDatos();
		int posicion = banco.busquedaCuenta(numCuenta);

		CCuenta cuenta = banco.retornarValor(posicion);

		if (cuenta == null) {
			System.out.println("La cuenta no existe");
		} else {
			System.out.println("Introduzca la cantidad deseada a retirar: ");
			double cantidad = entrada.nextDouble();
			cuenta.reintegro(cantidad);
		}
	}

	////////////////////////
	static void mantenimiento() {
		for (int i = 0; i < banco.getNumClientes(); i++) {
			CCuenta cuenta = banco.retornarValor(i);

			cuenta.comisiones();
			cuenta.intereses();
		}
	}

	////////////////////////////
	static String introducirDatos() {
		System.out.println("Introduzca el numero de cuenta");
		String numCuenta = entrada.nextLine();

		return numCuenta;
	}
	////////////////////////////

	public static char getRespuesta() {
		char resp = 0;
		boolean respValida = false;
		System.out.println("Desea eliminar el usuario? (S/N) : ");
		do {
			try {
				resp = (char) System.in.read();
				System.in.skip(2);
			} 
			
			catch (IOException error) {
				System.out.println("Error E/S. " + error.getMessage());
			}
			resp = Character.toLowerCase(resp);
			respValida = (resp == 's' || resp == 'n');
			if (!respValida) {
				System.out.println("Introduzca un caracter correcto 'S' o 'N': ");
			}
		} while (!respValida);
		return resp;
	}
}