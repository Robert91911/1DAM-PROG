package agendaFicheros;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

/**
 * <h1>Agenda</h1>
 * 
 * <p>
 * Codigo fuente para manipular una agenda de contactos utilizando un array
 * dinámico
 * </p>
 * 
 * @author alumno
 * 
 *         <a href="https://github.com/minauz/JavaDoc"> GitHub Agenda</a>
 *
 */
public class Agenda implements Serializable {
	/**
	 * Atributos
	 */
	public int numContactos;
	public Contacto array[];

	/**
	 * Constructor para crear una agenda.
	 */
	public Agenda() {
		numContactos = 0;
		array = new Contacto[numContactos];
	}

	//////////////////////////
	/**
	 * unElementoMas es un método que pide memoria para un elemento más y copio en
	 * ese nuevo array los elementos que ya estaban en el original. Para hacer esto,
	 * no tenemos más remedio que utilizar un array auxiliar que apunte a la misma
	 * dirección que apunta array.
	 * 
	 * @param aux array auxiliar con las cuentas.
	 */
	//////////////////////////
	public void unElementoMas(Contacto aux[]) {
		// Pedimos memoria para un elemento más
		array = new Contacto[numContactos + 1];
		// Copiamos los contactos anteriores en array
		for (int i = 0; i < numContactos; i++) {
			array[i] = aux[i];
		}
		// Actualizamos el número de contactos
		numContactos++;
	}

	//////////////////////////
	/**
	 * Añade un elemento a la agenda
	 * 
	 * @param contacto un objeto del tipo Contacto
	 */
	public void anadir(Contacto contacto) {
		unElementoMas(array);
		insertar(contacto, numContactos - 1);
	}

	//////////////////////////
	/**
	 * Inserta un contacto en la posición válida indicada
	 * 
	 * @param contacto un objeto del tipo Contacto, posicion es la posicion donde
	 *                 desea insertar ese Contacto
	 */
	public void insertar(Contacto contacto, int posicion) {
		// Validamos la posición
		if (posicion >= 0 && posicion < numContactos) {
			array[posicion] = contacto;
		} else
			System.out.println("La posición no es válida.");
	}

	//////////////////////////
	/**
	 * Este metodo pide memoria para un elemento menos. Y hace un bucle que
	 * selecciona las cuentas que desea copiar siendo != null. Y actualiza el banco.
	 * 
	 * @param aux array con todas las cuentas.
	 */
	public void unElementoMenos(Contacto aux[]) {
		// Pedimos memoria para un elemento menos
		array = new Contacto[numContactos - 1];
		int j = 0;
		// Copiamos en array todos aquellos menos el marcado con null
		for (int i = 0; i < numContactos; i++) {
			if (aux[i] != null) {
				array[j] = aux[i];
				j++;
			}
		}
		numContactos--;
	}

	//////////////////////////
	/**
	 * Realiza una busqueda secuencial del contacto que le hemos pasado.
	 * 
	 * @param contacto un objeto del tipo Contacto
	 * @return Devuelve la posición en caso de que lo encuentre y -1 en caso
	 *         contrario.
	 */
	public int busqueda(Contacto contacto) {
		for (int i = 0; i < numContactos; i++) {
			if (contacto.equals(array[i])) {
				return i;
			}
		}
		return -1;
	}

	//////////////////////////
	/**
	 * Recibe la posición donde está el elemento que quiero eliminar y lo marca
	 * asignándole un null.
	 * 
	 * @return Si lo marca, devuelve true, si no false.
	 */
	public boolean marcar(int pos) {
		array[pos] = null;
		unElementoMenos(array);
		return true;
	}

	//////////////////////////
	/**
	 * Metodo que muestra un menú con diversas opciones.
	 * 
	 * @return Devuelve la opcion a elegir
	 */
	public int verMenu() {
		Scanner entrada = new Scanner(System.in);
		boolean opcionValida = true;
		int opcion;

		System.out.println("1.Nuevo Contacto");
		System.out.println("2.Consultar");
		System.out.println("3.Eliminar");
		System.out.println("4.Modificar");
		System.out.println("5.Ver agenda");
		System.out.println("6.Salir.");
		do {
			System.out.println("Introduzca una opción: ");
			opcion = entrada.nextInt();
			opcionValida = (opcion >= 1 && opcion <= 6);
			if (!opcionValida) {
				System.err.println("Error, introduce una opción válida del 1 al 6");
			}
		} while (!opcionValida);
		if (opcion == 6) {
			System.out.println("Opcion 6 tecleada.");
		}
		return opcion;
	}

	//////////////////////////
	/**
	 * Mediante este metodo arrancamos la aplicacion, haciendo una serie de
	 * comprobaciones.
	 */
	public void arrancarAplicacion() {
		boolean salir = false;
		int opcion = 0;
		salir = (opcion == 6);

		if (!salir)
			do {
				switch (opcion) {
				case 1:
					nuevoContacto();
					break;
				case 2:
					consultas();
					break;
				case 3:
					eliminar();
					break;
				case 4:
					modificar();
					break;
				case 5:
					verAgenda();
					break;
				case 6:
					salir = true;
				}
				// Introducimos otra opción
				if (!salir) {
					System.out.println("Introduce otra opción");
					opcion = verMenu();
				}
			} while (!salir);
		System.out.println("Programa finalizado");
	}

	/////////////////////////////////////////////////////////
	/**
	 * Este metodo hace una agenda en un archivo
	 */

	private void guardarAgenda() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el nombre de la agenda:");
		File archivo = new File(sc.nextLine());
		char resp = 's';
		if (archivo.exists()) {
			System.out.println("Desea sobreescribirlo?");
			resp = getRespuesta();
		}
		if (resp == 's') {
			// Creamos la agenda.datos
			ObjectOutputStream oos = null;
			try {
				oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(archivo)));

				for (int i = 0; i < array.length; i++) {
					Contacto contacto = new Contacto(array[i].getNombre(), array[i].getTelefono());
					oos.writeObject(contacto);
				}
				System.out.println("Agenda creada correctamente.");
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private void salir() {

	}

	/**
	 * Este metodo modifica los datos de un contacto
	 */
	public void modificar() {
		Scanner entrada = new Scanner(System.in);
		if (agendaVacia()) {
			System.out.println("La agenda está vacia");
		} else {
			Contacto contacto1 = introducirDatos();
			// Comprobamos si existe el contacto
			int posicion = busqueda(contacto1);
			boolean existe = (posicion != -1);
			if (existe) {
				System.out.println("Modifica los datos");
				System.out.println("Introduce el nuevo teléfono");
				array[posicion].setTelefono(entrada.nextLine());
			} else
				System.out.println("El contacto no existe");
		}

	}

	//////////////////////////
	/**
	 * Este metodo muestra por pantalla la agenda completa.
	 */
	public void verAgenda() {
		if (agendaVacia()) {
			System.out.println("La agenda está vacía");
		} else {
			for (int i = 0; i < numContactos; i++) {
				array[i].mostrarDatos();
			}
		}
	}

	///////////////////////////////
	/**
	 * Este metodo elimina una cuenta del banco (array).
	 */
	public void eliminar() {
		if (agendaVacia()) {
			System.out.println("La agenda está vacia");
		} else {
			Contacto contacto1 = introducirDatos();
			// Comprobamos si existe el contacto
			int posicion = busqueda(contacto1);
			boolean existe = (posicion != -1);
			if (existe) {
				// Si existe, lo marcamos para eliminarlo
				if (marcar(posicion)) {
					System.out.println("El contacto ha sido eliminado");
				}
			} else
				System.out.println("El contacto no existe");
		}
	}

	//////////////////////////
	/**
	 * Este método añade un nuevo contacto a la agenda
	 */
	public void nuevoContacto() {
		Contacto contacto1 = introducirDatos();
		// Comprobamos si existe el contacto
		int posicion = busqueda(contacto1);
		boolean existe = (posicion != -1);
		if (existe) {
			System.out.println("Este contacto ya existe");
		} else {
			anadir(contacto1);
		}
	}

	//////////////////////////
	/**
	 * Metodo que te muestra el contacto por pantalla.
	 */
	public void consultas() {

		// Comprobamos si la agenda está vacia
		if (agendaVacia()) {
			System.out.println("La agenda está vacía.");
		} else {
			Contacto contacto1 = introducirDatos();
			int posicion = busqueda(contacto1);
			boolean existe = (posicion != -1);
			if (existe) {
				// Enviar a pantalla información de ese contacto
				contacto1.mostrarDatos();
			} else
				System.out.println("El contacto no existe");
		}
	}
	//////////////////////////

	/**
	 * Metodo que introduce los datos de una cuenta.
	 * 
	 * @return Devuelve un contacto con su nombre y telefono.
	 */

	public Contacto introducirDatos() {
		// Introducimos los datos
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce el nombre");
		String nombre = entrada.nextLine();
		System.out.println("Introduce el teléfono");
		String telefono = entrada.nextLine();

		// Instanciamos y devolvemos un nuevo contacto

		return new Contacto(nombre, telefono);
	}

	//////////////////////////
	/**
	 * Metodo que comprueba si la agenda esta vacia.
	 * 
	 * @return Devuelve un 'true' si esta vacia y si esta llena 'false'.
	 */
	public boolean agendaVacia() {
		return (numContactos == 0);
	}

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
