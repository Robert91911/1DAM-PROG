package bancoConFichero;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Banco implements Serializable
{
	/**
	 * Atributos
	 */
	private int numCuentas;
	private CCuenta array[];
		
	/**
	 * Constructor
	 */
	public Banco()
	{
		numCuentas = 0;
		array = new CCuenta[numCuentas];
	}
	//////////////////////////
	private void unElementoMas(CCuenta aux[])
	{
		//Pedimos memoria para un elemento más
		array = new CCuenta[numCuentas +1];
		//Copiamos las cuentas anteriores en array
		for(int i = 0; i < numCuentas; i++)
		{
			array[i] = aux[i];
		} 
		//Actualizamos el número de cuentas
		numCuentas ++;
	}
	//////////////////////////
	/**
	 * Este método inserta un objeto de tipo cuenta en una posición del array
	 * @param cuenta
	 * @param posicion
	 */
	public void insertarEn(CCuenta cuenta, int posicion)
	{
		//Validamos la posición
		if(posicion >= 0 && posicion < numCuentas)
		{
			array[posicion] = cuenta;
		}
		else 
			System.out.println("La posición no es válida.");
	}
	//////////////////////////
	public CCuenta retornarValor(int posicion)
	{
		//Validamos la posición
		if(posicion >= 0 && posicion < numCuentas)
		{
			return array[posicion];
		}
		else 
			return null;
	}
	//////////////////////////
	private boolean arrayVacio()
	{
		return (numCuentas == 0);
	}
	//////////////////////////
	/**
	 * Añade una cuenta al banco
	 * @param cuenta
	 */
	public void anadir(CCuenta cuenta)
	{
		unElementoMas(array);
		insertarEn(cuenta, numCuentas-1);
	}
	//////////////////////////
	private void unElementoMenos(CCuenta aux[])
	{
		
		//Pedimos memoria para un elemento menos
		array = new CCuenta[numCuentas -1];
		/**
		 * Indice para posicionarme en el array destino
		 */
		int j = 0;
		//Copiamos en array todos aquellos menos el marcado con null
		for(int i = 0; i < numCuentas; i++)
		{
			if(aux[i] != null)
			{
				array[j] = aux[i];
				j++;
			}
		}
		numCuentas --;
	}
	//////////////////////////
	/**
	 * Este método recibe una posición, marca con un null el contenido del array en esa 
	 * posición y pide memoria para un elemento menos
	 * @param posicion
	 */
	private void eliminar(int posicion) 
	{			
		array[posicion] = null;
		unElementoMenos(array);
	}
	//////////////////////////
	/**
	 * Este método realiza una búsqueda con un bucle for por todo el array para
	 * ver si la cuenta introducida existe, en caso afirmativo, devuelve la posición,
	 * en caso contrario, devuelve -1
	 * @param cuenta
	 * @return
	 */
	private int busqueda(String cuenta)
	{
		for(int i = 0; i < numCuentas; i++)
		{
			if(cuenta.equals(array[i].getCuenta()))
			{ 
				return i;
			}	
		}
		return -1;
	}
	//////////////////////////
	private int verMenu()
	{
		Scanner entrada = new Scanner (System.in);
		boolean opcionValida = true;
		int opcion;
		
		System.out.println("1.Consultar saldo");
		System.out.println("2.Ingreso");
		System.out.println("3.Reintegro");
		System.out.println("4.Altas");
		System.out.println("5.Bajas");
		System.out.println("6.Mantenimiento");	
		System.out.println("7.Salir");	
		do 
		{ 	
			System.out.println("Elige una opción: ");
			opcion = entrada.nextInt();	
			opcionValida = (opcion >=1 && opcion <=7);
			if (!opcionValida) 
			{
				System.err.println("Error, introduce una opción válida del 1 al 7");	
			}
		}while (!opcionValida);
		return opcion;	
	}
	//////////////////////////
	public void operacionesMenu()
	{
		boolean salir = false;
		
		do 
		{
			int opcion = verMenu();
			salir = (opcion == 7);
			if(!salir)
			{	
				switch(opcion)
				{ 
					case 1:
						consulta();
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
				}
			}	
		}while (!salir);	
		System.out.println("Programa finalizado");
	}
	//////////////////////////
	/**
	 * Este método visualiza las opciones de cuenta a elegir, validando la opción y 
	 * llama a leerDatos
	 */
	private void altas() 
	{
		Scanner entrada = new Scanner (System.in);
		boolean opcionValida = true;
		int opcion;
		
		System.out.println("1.Cuenta ahorro");
		System.out.println("2.Cuenta corriente");
		System.out.println("3.Cuenta corriente con intereses");
		
		System.out.println("Elige el tipo de cuenta: ");
		do 
		{			
			opcion = entrada.nextInt();	
			opcionValida = (opcion >=1 && opcion <=3);
			if (!opcionValida) 
			{
				System.err.println("Error, introduce una opción válida del 1 al 3");	
			}
		}while (!opcionValida);
		
		leerDatos(opcion);
	}
	//////////////////////////
	/**
	 * Este método comprueba si la cuenta introducida existe, si no es el caso, creará
	 * un objeto de tipo cuenta de la opción elegida con los datos que pasamos por teclado
	 * y llamará al método anadir
	 * @param opcion
	 */
	private void leerDatos(int opcion) 
	{
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introduce el número de cuenta");
		String numCuenta = entrada.nextLine();
		int posicion = busqueda(numCuenta);
		boolean existe = (posicion != -1);
		if(existe)
			System.out.println("Ese número de cuenta ya existe");
		else
		{	
			System.out.println("Introduce el nombre del titular");
			String nombre = entrada.nextLine();
			System.out.println("Introduce el tipo de interes");
			double interes = entrada.nextDouble();
			System.out.println("Introduce el saldo");
			double saldo = entrada.nextDouble();
			
			CCuenta cuenta = null;
			
			if(opcion == 1)
			{
				System.out.println("Introduce la cuota de mantenimiento");
				double cuotaMantenimiento = entrada.nextDouble();
				cuenta = new CCuentaAhorro(nombre, numCuenta, interes, 
						saldo, cuotaMantenimiento);
			}
			else
			{
				System.out.println("Introduce el importe por transacción");
				double importePorTrans = entrada.nextDouble();
				System.out.println("Introduce el número de transacciones exentas");
				int transExentas = entrada.nextInt();
				if(opcion == 2)
				{
					cuenta = new CCuentaCorriente(nombre, numCuenta, 
							interes, saldo, importePorTrans, transExentas);	
				}
				else
				{
					cuenta = new CCuentaCorrienteConIn(nombre, numCuenta, 
							interes, saldo, importePorTrans, transExentas);
				}
			}	
			anadir(cuenta);
		}
	}
	//////////////////////////
	/**
	 * Este método busca la cuenta indicada y en caso de existir, muestra los valores
	 * nombre, nº cuenta y saldo de esa cuenta.
	 */
	private void consulta() 
	{
		Scanner entrada = new Scanner(System.in);
		if(arrayVacio())
		{
			System.out.println("No hay cuentas en el banco");
		}
		else
		{
			System.out.println("Introduce el número de cuenta a buscar");
			String cuenta = entrada.nextLine();
			int posicion = busqueda(cuenta);
			boolean existe = (posicion != -1);
			if(existe)
			{
				//Enviar a pantalla información de esa cuenta
				System.out.println("Titular: " + array[posicion].getNombre());
				System.out.println("Número de cuenta: " + array[posicion].getCuenta());
				System.out.println("Saldo: " + array[posicion].getSaldo());
				System.out.println(retornarValor(posicion));
			}
			else
				System.out.println("La cuenta no existe");
		}
	}
	//////////////////////////
	/**
	 * Este método ingresa saldo en una cuenta existente
	 */
	private void ingreso()
	{
		Scanner entrada = new Scanner(System.in);
		if(arrayVacio())
		{
			System.out.println("No hay cuentas en el banco");
		}
		else
		{
			System.out.println("Introduce el número de cuenta");
			String cuenta = entrada.nextLine();
			int posicion = busqueda(cuenta);
			boolean existe = (posicion != -1);
			if(existe)
			{
				System.out.println("Introduce la cantidad a ingresar");
				array[posicion].ingreso(entrada.nextDouble());
			}
			else
				System.out.println("La cuenta no existe");
		}
	}
	//////////////////////////
	/**
	 * Este método retira saldo en una cuenta existente
	 */
	private void reintegro()
	{
		Scanner entrada = new Scanner(System.in);
		if(arrayVacio())
		{
			System.out.println("No hay cuentas en el banco");
		}
		else
		{
			System.out.println("Introduce el número de cuenta");
			String cuenta = entrada.nextLine();
			int posicion = busqueda(cuenta);
			boolean existe = (posicion != -1);
			if(existe)
			{
				System.out.println("Introduce la cantidad a retirar");
				array[posicion].reintegro(entrada.nextDouble());
			}
			else
				System.out.println("La cuenta no existe");
		}
	}
	//////////////////////////
	/**
	 * Este método borra una cuenta existente, realizando la búsqueda y llamando al 
	 * método eliminar
	 */
	private void bajas()
	{
		Scanner entrada = new Scanner(System.in);
		if(arrayVacio())
		{
			System.out.println("No hay cuentas en el banco");
		}
		else
		{
			System.out.println("Introduce el número de cuenta");
			String cuenta = entrada.nextLine();
			int posicion = busqueda(cuenta);
			boolean existe = (posicion != -1);
			if(existe)
			{
				eliminar(posicion);
				System.out.println("La cuenta ha sido eliminada");
			}
			else
				System.out.println("La cuenta no existe");
		}
	}
	//////////////////////////
	/**
	 * Este método funciona el primer día de cada mes y llama a los métodos intereses
	 * y comisiones en todo el contenido del array
	 */
	private void mantenimiento()
	{
		if(!arrayVacio())
		{
			GregorianCalendar fecha = new GregorianCalendar();
			int dia = fecha.get(Calendar.DAY_OF_MONTH);
			if(dia == 21) 
			{
				for(int i = 0; i < numCuentas; i++)
				{
					array[i].intereses();
					array[i].comisiones();
				}
				System.out.println("Mantenimiento realizado");
			}
			else
				System.out.println("Hoy no es primer día de mes");
		}
		else
			System.out.println("El banco no tiene cuentas");
	}
}
