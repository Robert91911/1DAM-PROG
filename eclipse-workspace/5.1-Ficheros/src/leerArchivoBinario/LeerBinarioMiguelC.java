
package leerArchivoBinario;

import java.io.*;

import java.io.Serializable;


public class LeerBinarioMiguelC{
	public static void main(String[] args) {

		try {
			if (args.length == 1) {
				File fichero = new File(args[0]);
				char resp = 's';
				if (fichero.exists()) {
					leerFichero(fichero);
				} else {
					throw new FicheroNoExiste();
				}
			} else {
				throw new FalloArgs();
			}
		} catch (FalloArgs e) {
			System.err.println("Error en los argumentos.");
		} catch (FicheroNoExiste e) {
			System.err.println("El fichero no existe");
		}
	}

	public static void leerFichero(File fichero) {
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(new BufferedInputStream(new FileInputStream(fichero)));
			while (true) {
				System.out.println("Nombre: " + dis.readUTF());
				System.out.println("Telefono: " + dis.readUTF());
			}
		} catch (EOFException e) {
			System.out.println("Hemos alcanzado el fin del fichero.");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally { // bug error de eclipse no hay ningun error
			try {
				dis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class FalloArgs extends Exception {
	public FalloArgs() {
		super();
	}
}

class FicheroNoExiste extends Exception {
	public FicheroNoExiste() {
		super();
	}
}