package ejercicio6;

import java.io.BufferedOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CrearListaTfnosMiguelC {
	public static void main(String[] args) {
		try {
			if (args.length == 1) {
				File fichero = new File(args[0]);
				char resp = 's';
				if (fichero.exists()) {
					System.out.println("Desea sobreescribirlo?: ");
					resp = getRespuesta();
				}
				if (resp == 's') {
					crearFichero(fichero);
				}
			} else {
				throw new FalloArgs();
			}
		} catch (FalloArgs e) {
			System.err.println("Error en los argumentos.");
		}
	}
	///////////////////////////////////////////////////

	private static void crearFichero(File fichero) {
		DataOutputStream dos = null;
		Scanner sc = new Scanner(System.in);

		try {
			dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fichero)));

			do {
				System.out.println("Introduzca el nombre: ");
				String nombre = sc.nextLine();
				dos.writeUTF(nombre);

				System.out.println("Introduzca el telefono: ");
				String telefono = sc.nextLine();
				dos.writeUTF(telefono);
				System.out.println("Desea seguir escribiendo datos?");
			} while (getRespuesta() == 's');

		} catch (IOException e) {
			System.out.println("Error en E/S." + e.getMessage());
		} finally {
			try {
				dos.close();
			} catch (IOException e) {
				System.out.println("Error al cerrar el flujo de datos");
			}
		}
	}

	//////////////////////////////////////////////////

	public static char getRespuesta() {

		boolean respValida = true;
		char resp = 0;

		do {
			try {
				resp = (char) System.in.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resp = Character.toLowerCase(resp);
			try {
				System.in.skip(2);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			respValida = (resp == 's' || resp == 'n');
			if (!respValida)
				System.out.println("Error teclea s o n");
		} while (!respValida);
		return resp;
	}
}

class FalloArgs extends Exception {
	public FalloArgs() {
		super();
	}
}