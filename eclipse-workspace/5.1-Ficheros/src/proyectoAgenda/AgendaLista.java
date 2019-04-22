package proyectoAgenda;

import java.io.Serializable;
import java.util.Scanner;

public class AgendaLista implements Serializable {
int numContactos;
Nodo inicio;

public AgendaLista() {
	inicio=null;
	numContactos=0;
}


	void insertarAlPrincipio(Contacto obj) {
		Nodo nuevo = new Nodo(obj, inicio);
		
		inicio=nuevo;
	}
	
	void verMenu() {
		System.out.println("1. Nuevo contacto");
		System.out.println("2. Consultar");
		System.out.println("3. Modificar");
		System.out.println("4. Eliminar");
		System.out.println("5. Ver Agenda");
		System.out.println("6. Salir");
		System.out.println(" \n Elige una opcion:");
	}
	
	
	void seleccionarOperacion() {
			boolean valido;
			int a;
			do {
			Scanner entrada = new Scanner(System.in);
			verMenu();
			
			
			do {
				 a= entrada.nextInt();
				valido=(a>=1&&a<=6);
				
			}while(!valido);
			if(a>=1 && a<=5) {
				switch(a) {
				
				case 1:
					nuevoContacto();
					break;
				case 2: 
					consultar();
					break;
				case 3: 
					modificar();
					break;
				case 4: 
					eliminar();
					break;
				case 5: 
					verAgenda();
					break;
				}
			}
			else
				System.out.println("Hasta pronto");
			
		}while(a!=6);
	}

	private void verAgenda() {
		// TODO Auto-generated method stub
		if(agendaVacia()) {
			System.out.println("La agenda esta vacia");
		}
		else {	
				Nodo actual = inicio;
		
			while(actual!=null) {
				System.out.println(actual.info);
				actual=actual.enlace;
			}	
		}
		
		
	}


	private boolean agendaVacia() {
		
		return inicio==null;
	}


	private void eliminar() {
		// TODO Auto-generated method stub
		if(agendaVacia()) {
			System.out.println("La agenda esta vacia");
		}
		else {
			Contacto contacto = introducirDatos();
			Nodo anterior = null;
			Nodo actual = inicio;
			boolean encontrado = false;
			while(actual!=null && !encontrado) {
				Contacto c1=(Contacto)actual.info;
				if(c1.equals(contacto)) {
					encontrado=true;
				}else {
					//Avanzamos al siguiente nodo
					anterior=actual;
					actual=actual.enlace;
				}
				
				if(encontrado) {
					//Comprobamos si es el primero
					if(actual==inicio) {
						/*
						 * El inicio de la lista pasa a ser el siguiente nodo
						 */
						inicio=inicio.enlace;
						
					}else {
						//Enlazamos el nodo anterior con el siguiente 
					anterior.enlace=actual.enlace;
					}
				}
			}
		}
	}


	private void modificar() {
		if(agendaVacia()) {
			System.out.println("La agenda esta vacia");
		}
		else {
			
			Contacto contacto = introducirDatos();
			boolean existe=false;
			//Comprobar si esxiste
			Nodo actual = busqueda(contacto);
			if(actual!=null) {
			Contacto c1 = (Contacto)actual.info;
			 existe = (c1.equals(contacto));
			
			}
			
			if(existe)
			{
				System.out.println("Introduce los nuevos datos");
				Contacto c= introducirDatos();
				actual.info=c;
			}
			else
			{
				System.out.println("Este contacto no existe");
			}
		}
		
	}


	private void consultar() {
		// TODO Auto-generated method stub
		
		if(agendaVacia()) {
			System.out.println("La agenda esta vacia");
		}
		else {
			
			Contacto contacto = introducirDatos();
			boolean existe=false;
			//Comprobar si esxiste
			Nodo actual = busqueda(contacto);
			if(actual!=null) {
			Contacto c1 = (Contacto)actual.info;
			 existe = (c1.equals(contacto));
			
			}
			
			if(existe)
			{
				System.out.println( actual.info);
			}
			else
			{
				System.out.println("Este contacto no existe");
			}
		}
	}

		
	


	private void nuevoContacto() {
		// TODO Auto-generated method stub
Contacto contacto = introducirDatos();
		boolean existe=false;
		//Comprobar si esxiste
		Nodo actual = busqueda(contacto);
		if(actual!=null) {
		Contacto c1 = (Contacto)actual.info;
		 existe = (c1.equals(contacto));
		
		}
		
		if(existe)
		{
			System.out.println("Este contacto ya existe ");
		}
		else
		{
			insertarAlPrincipio(contacto);
		}
	}


	private Nodo busqueda(Contacto contacto) {
		
		Scanner entrada = new Scanner(System.in);
		Contacto c2 = contacto;
		for(Nodo actual=inicio; actual!=null;actual=actual.enlace) {
			Contacto c1 = (Contacto)actual.info;
			if(c1.equals(c2)) {
				return actual;
			}
		}
		return null;
	}


	private Contacto introducirDatos() {
		Scanner entrada = new Scanner (System.in);
		
		System.out.println("Introduce el nombre. ");
		String nombre = entrada.nextLine();
		
		System.out.println(" Introduce el telefono: ");
		String telefono = entrada.nextLine();
		
		//Instanciamos y devolvemos un nuevo contacto
		return new Contacto (nombre, telefono);
	}
	
	public boolean equals(Object obj) {
		
		Contacto contacto = (Contacto)obj;
		
		
		
		return false;
		
	}
	
	
	
	
	
}
