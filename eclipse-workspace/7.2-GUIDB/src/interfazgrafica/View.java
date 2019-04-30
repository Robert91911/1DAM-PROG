package interfazgrafica;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

	/**
	 * Clase que contiene todos los componentes gráficos.... CLASE EN DESARROLLO!
	 * @author robert
	 *
	 */
	
public class View extends JFrame {
	/******************************** ATRIBUTOS ********************************/
	//CONTENEDOR PRINCIPAL
	private JPanel contenedor;
	private JPanel login;
	
	//DEFINICION DE LAS ETIQUETAS
	private JLabel lbusuario;
	private JLabel lbcontrasenya;
	
	private JLabel lbdni;
	private JLabel lbnombre;
	private JLabel lbapellido;
	private JLabel lbedad;
	
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
		
		login = new JPanel();
		getContentPane().add(login);
		
		contenedor = new JPanel();
		getContentPane().add(contenedor);
		
		//CREAR EL CONTENEDOR PRINCIPAL Y AÑADIRLO A LA VENTANA
		SpringLayout sp = new SpringLayout();
		login.setLayout(sp);
		contenedor.setLayout(sp);
		
		/************************ ETIQUETAS ************************/
		lbusuario = new JLabel("Usuario:");
		login.add(lbusuario);
		sp.putConstraint(SpringLayout.NORTH, lbnombre, 10, SpringLayout.NORTH, login);
		sp.putConstraint(SpringLayout.WEST, lbnombre, 10, SpringLayout.WEST, login);

		lbcontrasenya = new JLabel("Contraseña:");
		login.add(lbcontrasenya);
		sp.putConstraint(SpringLayout.NORTH, lbcontrasenya, 50, SpringLayout.NORTH, login);
		sp.putConstraint(SpringLayout.WEST, lbcontrasenya, 10, SpringLayout.NORTH, login);
		
		lbdni = new JLabel("DNI:");
		contenedor.add(lbdni);
		sp.putConstraint(SpringLayout.NORTH, lbdni, 10, SpringLayout.NORTH, contenedor);
		sp.putConstraint(SpringLayout.WEST, lbdni, 10, SpringLayout.WEST, contenedor);
		
		lbnombre = new JLabel("Nombre:");
		contenedor.add(lbnombre);
		sp.putConstraint(SpringLayout.NORTH, lbnombre, 50, SpringLayout.NORTH, contenedor);
		sp.putConstraint(SpringLayout.WEST, lbnombre, 10, SpringLayout.WEST, contenedor);
		
		lbapellido = new JLabel("Apellido:");
		contenedor.add(lbapellido);
		sp.putConstraint(SpringLayout.NORTH, lbapellido, 90, SpringLayout.NORTH, contenedor);
		sp.putConstraint(SpringLayout.WEST, lbapellido, 10, SpringLayout.WEST, contenedor);
				
		lbedad = new JLabel("Edad:");
		contenedor.add(lbedad);
		sp.putConstraint(SpringLayout.NORTH, lbedad, 120, SpringLayout.NORTH, contenedor);
		sp.putConstraint(SpringLayout.WEST, lbedad, 10, SpringLayout.WEST, contenedor);
		
		/************************ CUADROS TXT ************************/
		txtUsuario = new JTextField();
		login.add(txtUsuario);
        sp.putConstraint(SpringLayout.NORTH, txtUsuario, 10, SpringLayout.NORTH, login);
		sp.putConstraint(SpringLayout.WEST, txtUsuario, 100, SpringLayout.WEST, login);
		sp.putConstraint(SpringLayout.EAST, txtUsuario, 300, SpringLayout.WEST, login);
		
		txtContrasenya = new JTextField();
		login.add(txtContrasenya);
        sp.putConstraint(SpringLayout.NORTH, txtContrasenya, 50, SpringLayout.NORTH, login);
		sp.putConstraint(SpringLayout.WEST, txtContrasenya, 100, SpringLayout.WEST, login);
		sp.putConstraint(SpringLayout.EAST, txtContrasenya, 300, SpringLayout.WEST, login);
		
		txtDNI = new JTextField();
		contenedor.add(txtDNI);
        sp.putConstraint(SpringLayout.NORTH, txtDNI, 10, SpringLayout.NORTH, contenedor);
		sp.putConstraint(SpringLayout.WEST, txtDNI, 100, SpringLayout.WEST, contenedor);
		sp.putConstraint(SpringLayout.EAST, txtDNI, 300, SpringLayout.WEST, contenedor);
		
		txtNombre = new JTextField();
		contenedor.add(txtNombre);
        sp.putConstraint(SpringLayout.NORTH, txtNombre, 50, SpringLayout.NORTH, contenedor);
		sp.putConstraint(SpringLayout.WEST, txtNombre, 100, SpringLayout.WEST, contenedor);
		sp.putConstraint(SpringLayout.EAST, txtNombre, 300, SpringLayout.WEST, contenedor);
		
		txtApellido = new JTextField();
		contenedor.add(txtApellido);
        sp.putConstraint(SpringLayout.NORTH, txtApellido, 90, SpringLayout.NORTH, contenedor);
		sp.putConstraint(SpringLayout.WEST, txtApellido, 100, SpringLayout.WEST, contenedor);
		sp.putConstraint(SpringLayout.EAST, txtApellido, 300, SpringLayout.WEST, contenedor);
		
		txtEdad = new JTextField();
		contenedor.add(txtEdad);
        sp.putConstraint(SpringLayout.NORTH, txtEdad, 120, SpringLayout.NORTH, contenedor);
		sp.putConstraint(SpringLayout.WEST, txtEdad, 100, SpringLayout.WEST, contenedor);
		sp.putConstraint(SpringLayout.EAST, txtEdad, 300, SpringLayout.WEST, contenedor);
		
		/************************ TABLA ************************/
		scroll = new JScrollPane();
		cabecera = new String[] {"DNI","Nombre","Apellido","Edad"};
		dtm = new DefaultTableModel(datos,cabecera);
		tabla = new JTable(dtm);
		scroll.setViewportView(tabla);
		//Colocacion del scroll pane
		contenedor.add(scroll);
        sp.putConstraint(SpringLayout.NORTH, scroll, 120, SpringLayout.NORTH, contenedor);
		sp.putConstraint(SpringLayout.WEST, scroll,10, SpringLayout.WEST, contenedor);
		sp.putConstraint(SpringLayout.EAST, scroll,  -10, SpringLayout.EAST, contenedor);
		sp.putConstraint(SpringLayout.SOUTH, scroll, -50, SpringLayout.SOUTH, contenedor);
		
		/************************ BOTONES ************************/
		btConectar = new JButton("Conectar");
		login.add(btConectar);
        sp.putConstraint(SpringLayout.SOUTH, btConectar,-10, SpringLayout.SOUTH, login);
        sp.putConstraint(SpringLayout.WEST, btConectar, 50, SpringLayout.WEST, login);
        
		btInsertar = new JButton("Insetar");
		login.add(btInsertar);
        sp.putConstraint(SpringLayout.SOUTH, btInsertar, -10, SpringLayout.SOUTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, btInsertar, 100, SpringLayout.WEST, contenedor);
        
		btListado = new JButton("Listar");
		login.add(btListado);
        sp.putConstraint(SpringLayout.SOUTH, btListado, -10, SpringLayout.SOUTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, btListado, 150, SpringLayout.WEST, contenedor);
        
		btBorrar = new JButton("Borrar");
		login.add(btBorrar);
        sp.putConstraint(SpringLayout.SOUTH, btBorrar, -10, SpringLayout.SOUTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, btBorrar, 200, SpringLayout.WEST, contenedor);
        
		btModificar = new JButton("Modificar");
		login.add(btModificar);
        sp.putConstraint(SpringLayout.SOUTH, btModificar, -10, SpringLayout.SOUTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, btModificar, 250, SpringLayout.WEST, contenedor);
        
		btSalir = new JButton("Salir");
		login.add(btSalir);
        sp.putConstraint(SpringLayout.SOUTH, btSalir, -10, SpringLayout.SOUTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, btSalir, 300, SpringLayout.WEST, contenedor);
        
        //Hacemos visible la ventana
        setVisible(true);
        
	}

}
