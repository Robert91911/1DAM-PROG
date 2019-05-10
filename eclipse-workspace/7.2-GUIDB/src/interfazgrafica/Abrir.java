package interfazgrafica;

import java.util.Scanner;

/*
import operacionesdb.ObBorrado;
import operacionesdb.ObConsulta;
import operacionesdb.ObInsercion;
import operacionesdb.ObModificacion;
import operacionesdb.ObRegistro;
*/

public class Abrir 
{
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		 View vista  = new View();
		 Controller contr = new Controller(vista);
		 vista.conectarControlador(contr);
		 
		 /****************PRUEBAS INSERCION***************************/
		 //ObRegistro registro = new ObRegistro();
		 //registro.setDni("X9197650L");
		 //registro.setNombre("Robert Marian");
		 //registro.setApellido("Amariutei");
		 //registro.setEdad(20);
		 //ObInsercion insertar = new ObInsercion(registro);
		
		 /****************PRUEBAS BUSCAR***************************/
		 //ObConsulta consulta = new ObConsulta("50858949M");
		 //consulta.buscar();
		 //System.out.println(consulta.posicionEncontrada());
		 
		 /****************PRUEBAS MODIFICAR***************************/
		 //ObRegistro datos = new ObRegistro("X9197651L", "Modificacion", "Amariutei", 12);
		 //ObModificacion modi = new ObModificacion(2, datos);
		 /****************PRUEBAS BORRAR***************************/
		 //ObBorrado borrar = new ObBorrado(6);
	}
}
