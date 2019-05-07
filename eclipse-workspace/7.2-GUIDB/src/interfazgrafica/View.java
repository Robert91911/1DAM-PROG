package interfazgrafica;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

	/**
	 * Clase que contiene todos los componentes gráficos.... CLASE EN DESARROLLO!
	 * @author robert
	 *
	 */
	
public class View {
	/******************************** ATRIBUTOS ********************************/
	//VENTANA
	JFrame ventana;
	
	//Container contenedor;
	
	//panelOperaciones PRINCIPAL
	JPanel panelOperaciones;
	JPanel login;
	
	//DEFINICION DE LAS ETIQUETAS
	JLabel lbusuario;
	JLabel lbcontrasenya;
	
	JLabel lbdni;
	JLabel lbnombre;
	JLabel lbapellido;
	JLabel lbedad;
	
	//DEFINICION DE LOS CUADROS DE TEXTO
	JTextField txtUsuario;
	JTextField txtContrasenya;

	JTextField txtDNI;
	JTextField txtNombre;
	JTextField txtApellido;
	JTextField txtEdad;

	//DEFINICION DE LOS BOTONES
	JButton btConectar;

	JButton btInsertar;
	JButton btListado;
	JButton btBorrar;
	JButton btModificar;
	JButton btSalir;
	
	//DEFINICION DE LOS OBJETOS DE PARA LA TABLA
	JScrollPane scroll; //Panel de scroll que contiene la tabla
	Object[][] datos; //Cuerpo de la tabla
	String[] cabecera; //Cabecera de la tabla
	DefaultTableModel dtm; //Con esto se une la tabla y la cabecera
	JTable tabla; //La propia tabla

	/******************************** MÉTODOS ********************************/
	//CONSTRUCTOR
	public View(){
		crearComponentes();
		colocarComponentesLogin();
	}
	
	public void crearComponentes() {
		ventana = new JFrame();
		//contenedor = new Container();
		login = new JPanel();
		panelOperaciones = new JPanel();

		/************************ ETIQUETAS ************************/
		lbusuario = new JLabel("Usuario:");
		lbcontrasenya = new JLabel("Contraseña:");
		lbdni = new JLabel("DNI:");
		lbnombre = new JLabel("Nombre:");
		lbapellido = new JLabel("Apellido:");
		lbedad = new JLabel("Edad:");
		/************************ CUADROS TXT ************************/
		txtUsuario = new JTextField("robert9191");
		txtContrasenya = new JTextField("Clave_00");
		txtDNI = new JTextField(20);
		txtNombre = new JTextField(20);
		txtApellido = new JTextField(20);
		txtEdad = new JTextField(20);
		/************************ TABLA ************************/
		scroll = new JScrollPane();
		cabecera = new String[] {"DNI","Nombre","Apellido","Edad"};
		dtm = new DefaultTableModel(datos,cabecera);
		tabla = new JTable(dtm);
		/************************ BOTONES ************************/
		btConectar = new JButton("Conectar");
		btInsertar = new JButton("Insetar");
		btListado = new JButton("Listar");
		btBorrar = new JButton("Borrar");
		btModificar = new JButton("Modificar");
		btSalir = new JButton("Salir");
	}
	
	public void colocarComponentesLogin() {
		ventana.setBounds(100,100,600,300); //Dimensiones de la ventana
		ventana.setTitle("BASE DE DATOS CON ENTORNO GRÁFICO"); //Barra de título
		
		SpringLayout sp = new SpringLayout();
		login.setLayout(sp);
		/************************ ETIQUETAS ************************/	
		login.add(lbusuario);
		sp.putConstraint(SpringLayout.NORTH, lbusuario, 50, SpringLayout.NORTH, login);
		sp.putConstraint(SpringLayout.WEST, lbusuario, 130, SpringLayout.WEST, login);

		login.add(lbcontrasenya);
		sp.putConstraint(SpringLayout.NORTH, lbcontrasenya, 90, SpringLayout.NORTH, login);
		sp.putConstraint(SpringLayout.WEST, lbcontrasenya, 130, SpringLayout.NORTH, login);
		
		
		/************************ CUADROS TXT ************************/	
		login.add(txtUsuario);
        sp.putConstraint(SpringLayout.NORTH, txtUsuario, 50, SpringLayout.NORTH, login);
		sp.putConstraint(SpringLayout.WEST, txtUsuario, 240, SpringLayout.WEST, login);
		sp.putConstraint(SpringLayout.EAST, txtUsuario, 430, SpringLayout.WEST, login);
				
		login.add(txtContrasenya);
        sp.putConstraint(SpringLayout.NORTH, txtContrasenya, 90, SpringLayout.NORTH, login);
		sp.putConstraint(SpringLayout.WEST, txtContrasenya, 240, SpringLayout.WEST, login);
		sp.putConstraint(SpringLayout.EAST, txtContrasenya, 430, SpringLayout.WEST, login);
		
		/************************ BOTONES ************************/
		login.add(btConectar);
        sp.putConstraint(SpringLayout.SOUTH, btConectar,-100, SpringLayout.SOUTH, login);
        sp.putConstraint(SpringLayout.WEST, btConectar, 250, SpringLayout.WEST, login);
        ventana.add(login);
        //Hacemos visible la ventana
        ventana.setVisible(true);
        
	}
	
	public void colocarComponentesOperaciones() {
		ventana.setBounds(100,100,600,300); //Dimensiones de la ventana
		ventana.setTitle("BASE DE DATOS CON ENTORNO GRÁFICO"); //Barra de título
		
		SpringLayout sp = new SpringLayout();
		
		panelOperaciones.setLayout(sp);
		/************************ ETIQUETAS ************************/		
		panelOperaciones.add(lbdni);
		sp.putConstraint(SpringLayout.NORTH, lbdni, 10, SpringLayout.NORTH, panelOperaciones);
		sp.putConstraint(SpringLayout.WEST, lbdni, 10, SpringLayout.WEST, panelOperaciones);
		
		panelOperaciones.add(lbnombre);
		sp.putConstraint(SpringLayout.NORTH, lbnombre, 50, SpringLayout.NORTH, panelOperaciones);
		sp.putConstraint(SpringLayout.WEST, lbnombre, 10, SpringLayout.WEST, panelOperaciones);
		
		panelOperaciones.add(lbapellido);
		sp.putConstraint(SpringLayout.NORTH, lbapellido, 90, SpringLayout.NORTH, panelOperaciones);
		sp.putConstraint(SpringLayout.WEST, lbapellido, 10, SpringLayout.WEST, panelOperaciones);
					
		panelOperaciones.add(lbedad);
		sp.putConstraint(SpringLayout.NORTH, lbedad, 130, SpringLayout.NORTH, panelOperaciones);
		sp.putConstraint(SpringLayout.WEST, lbedad, 10, SpringLayout.WEST, panelOperaciones);
		
		/************************ CUADROS TXT ************************/	
		login.add(txtUsuario);
        sp.putConstraint(SpringLayout.NORTH, txtUsuario, 50, SpringLayout.NORTH, login);
		sp.putConstraint(SpringLayout.WEST, txtUsuario, 240, SpringLayout.WEST, login);
		sp.putConstraint(SpringLayout.EAST, txtUsuario, 430, SpringLayout.WEST, login);
				
		login.add(txtContrasenya);
        sp.putConstraint(SpringLayout.NORTH, txtContrasenya, 90, SpringLayout.NORTH, login);
		sp.putConstraint(SpringLayout.WEST, txtContrasenya, 240, SpringLayout.WEST, login);
		sp.putConstraint(SpringLayout.EAST, txtContrasenya, 430, SpringLayout.WEST, login);
				
		panelOperaciones.add(txtDNI);
        sp.putConstraint(SpringLayout.NORTH, txtDNI, 10, SpringLayout.NORTH, panelOperaciones);
		sp.putConstraint(SpringLayout.WEST, txtDNI, 100, SpringLayout.WEST, panelOperaciones);
		sp.putConstraint(SpringLayout.EAST, txtDNI, 300, SpringLayout.WEST, panelOperaciones);
				
		panelOperaciones.add(txtNombre);
        sp.putConstraint(SpringLayout.NORTH, txtNombre, 50, SpringLayout.NORTH, panelOperaciones);
		sp.putConstraint(SpringLayout.WEST, txtNombre, 100, SpringLayout.WEST, panelOperaciones);
		sp.putConstraint(SpringLayout.EAST, txtNombre, 300, SpringLayout.WEST, panelOperaciones);
				
		panelOperaciones.add(txtApellido);
        sp.putConstraint(SpringLayout.NORTH, txtApellido, 90, SpringLayout.NORTH, panelOperaciones);
		sp.putConstraint(SpringLayout.WEST, txtApellido, 100, SpringLayout.WEST, panelOperaciones);
		sp.putConstraint(SpringLayout.EAST, txtApellido, 300, SpringLayout.WEST, panelOperaciones);	
		
		panelOperaciones.add(txtEdad);
        sp.putConstraint(SpringLayout.NORTH, txtEdad, 130, SpringLayout.NORTH, panelOperaciones);
		sp.putConstraint(SpringLayout.WEST, txtEdad, 100, SpringLayout.WEST, panelOperaciones);
		sp.putConstraint(SpringLayout.EAST, txtEdad, 300, SpringLayout.WEST, panelOperaciones);
		
		/************************ TABLA ************************/
		scroll.setViewportView(tabla);
		//Colocacion del scroll pane
		panelOperaciones.add(scroll);
        sp.putConstraint(SpringLayout.NORTH, scroll, 170, SpringLayout.NORTH, panelOperaciones);
		sp.putConstraint(SpringLayout.WEST, scroll,10, SpringLayout.WEST, panelOperaciones);
		sp.putConstraint(SpringLayout.EAST, scroll,  -10, SpringLayout.EAST, panelOperaciones);
		sp.putConstraint(SpringLayout.SOUTH, scroll, -50, SpringLayout.SOUTH, panelOperaciones);
		
		/************************ BOTONES ************************/        
		panelOperaciones.add(btInsertar);
        sp.putConstraint(SpringLayout.SOUTH, btInsertar, -10, SpringLayout.SOUTH, panelOperaciones);
        sp.putConstraint(SpringLayout.WEST, btInsertar, 40, SpringLayout.WEST, panelOperaciones);      

		panelOperaciones.add(btListado);
        sp.putConstraint(SpringLayout.SOUTH, btListado, -10, SpringLayout.SOUTH, panelOperaciones);
        sp.putConstraint(SpringLayout.WEST, btListado, 140, SpringLayout.WEST, panelOperaciones);
        
		panelOperaciones.add(btBorrar);
        sp.putConstraint(SpringLayout.SOUTH, btBorrar, -10, SpringLayout.SOUTH, panelOperaciones);
        sp.putConstraint(SpringLayout.WEST, btBorrar, 240, SpringLayout.WEST, panelOperaciones);
        
		panelOperaciones.add(btModificar);
        sp.putConstraint(SpringLayout.SOUTH, btModificar, -10, SpringLayout.SOUTH, panelOperaciones);
        sp.putConstraint(SpringLayout.WEST, btModificar, 340, SpringLayout.WEST, panelOperaciones);
        
		panelOperaciones.add(btSalir);
        sp.putConstraint(SpringLayout.SOUTH, btSalir, -10, SpringLayout.SOUTH, panelOperaciones);
        sp.putConstraint(SpringLayout.WEST, btSalir, 460, SpringLayout.WEST, panelOperaciones);
        ventana.add(panelOperaciones);
        //Hacemos visible la ventana
        ventana.setVisible(true);
       
	}
	
	public void conectarControlador(Controller c) {
		

		//LOGIN
		btConectar.addActionListener(c);
		btConectar.setActionCommand("CONECTAR");
		//INSERTAR
		btInsertar.addActionListener(c);
		btInsertar.setActionCommand("INSERTAR");
		//LISTAR
		btListado.addActionListener(c);
		btListado.setActionCommand("LISTAR");
		//BORRAR
		btBorrar.addActionListener(c);
		btBorrar.setActionCommand("BORRAR");
		//MODIFICAR
		btModificar.addActionListener(c);
		btModificar.setActionCommand("MODIFICAR");
		//SALIR
		btSalir.addActionListener(c);
		btSalir.setActionCommand("SALIR");
		//TABLA
		tabla.addMouseListener(c);
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	}
	
}
