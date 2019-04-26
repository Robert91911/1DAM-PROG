package guidb;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class View extends JFrame {
	/******************************** ATRIBUTOS ********************************/
	//CONTENEDOR PRINCIPAL
	private JPanel contenedor;
	
	//DEFINICION DE LAS ETIQUETAS
	private JLabel usuario;
	private JLabel contrasenya;
	
	private JLabel dni;
	private JLabel nombre;
	private JLabel apellido;
	private JLabel edad;
	
	//DEFINICION DE LOS CUADROS DE TEXTO
	protected JTextField txtUsuario;
	protected JTextField txtContrasenya;

	protected JTextField txtDNI;
	protected JTextField txtNombre;
	protected JTextField txtApellido;
	protected JTextField txtEdad;

	//DEFINICION DE LOS BOTONES
	protected JButton btConectar;

	protected JButton btInsertar;
	protected JButton btListado;
	protected JButton btBorrar;
	protected JButton btModificar;
	protected JButton btSalir;
	
	//DEFINICION DE LOS OBJETOS DE PARA LA TABLA
	private JScrollPane scroll; //Panel de scroll que contiene la tabla
	protected Object[][] datos; //Cuerpo de la tabla
	protected String[] cabecera; //Cabecera de la tabla
	protected DefaultTableModel dtm; //Con esto se une la tabla y la cabecera
	protected JTable tabla; //La propia tabla

	/******************************** MÉTODOS ********************************/
	//CONSTRUCTOR
	View(){
		//Métodos del JFrame
		setBounds(100,100,450,300); //Dimensiones de la ventana
		setTitle("BASE DE DATOS CON ENTORNO GRÁFICO"); //Barra de título
		setDefaultCloseOperation(EXIT_ON_CLOSE); //Accion a pulsar en salir
		
		//CREAR EL CONTENEDOR PRINCIPAL Y AÑADIRLO A LA VENTANA
		contenedor = new JPanel();
		getContentPane().add(contenedor);
		
		//UTILIZAREMOS SPRINGLAYOUT
		
	}

}
