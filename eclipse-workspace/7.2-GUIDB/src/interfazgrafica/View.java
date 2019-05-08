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
	public JFrame ventana;
	
	//Container contenedor;
	
	//panelOperaciones PRINCIPAL
	public JPanel panelOperaciones;
	public JPanel login;
	
	//DEFINICION DE LAS ETIQUETAS
	public JLabel lbusuario;
	public JLabel lbcontrasenya;
	
	public JLabel lbdni;
	public JLabel lbnombre;
	public JLabel lbapellido;
	public JLabel lbedad;
	
	//DEFINICION DE LOS CUADROS DE TEXTO
	public JTextField txtUsuario;
	public JTextField txtContrasenya;

	public JTextField txtDNI;
	public JTextField txtNombre;
	public JTextField txtApellido;
	public JTextField txtEdad;

	//DEFINICION DE LOS BOTONES
	public JButton btConectar;

	public JButton btInsertar;
	public JButton btBuscar;
	public JButton btListado;
	public JButton btBorrar;
	public JButton btModificar;
	public JButton btSalir;
	public JButton btLimpiar;
	
	//DEFINICION DE LOS OBJETOS DE PARA LA TABLA
	public JScrollPane scroll; //Panel de scroll que contiene la tabla
	public Object[][] datos; //Cuerpo de la tabla
	public String[] cabecera; //Cabecera de la tabla
	public DefaultTableModel dtm; //Con esto se une la tabla y la cabecera
	public JTable tabla; //La propia tabla

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
		
		btBuscar = new JButton("Buscar");
		btInsertar = new JButton("Insetar");
		btListado = new JButton("Listar");
		btBorrar = new JButton("Borrar");
		btModificar = new JButton("Modificar");
		btSalir = new JButton("Salir");
		btLimpiar = new JButton("Limpiar");
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
		ventana.setBounds(100,100,600,500); //Dimensiones de la ventana
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
		panelOperaciones.add(btLimpiar);
		sp.putConstraint(SpringLayout.NORTH, btLimpiar, 65, SpringLayout.NORTH, panelOperaciones);
        sp.putConstraint(SpringLayout.WEST, btLimpiar, 390, SpringLayout.WEST, panelOperaciones);      

		panelOperaciones.add(btInsertar);
        sp.putConstraint(SpringLayout.SOUTH, btInsertar, -10, SpringLayout.SOUTH, panelOperaciones);
        sp.putConstraint(SpringLayout.WEST, btInsertar, 10, SpringLayout.WEST, panelOperaciones);      

		panelOperaciones.add(btListado);
        sp.putConstraint(SpringLayout.SOUTH, btListado, -10, SpringLayout.SOUTH, panelOperaciones);
        sp.putConstraint(SpringLayout.WEST, btListado, 110, SpringLayout.WEST, panelOperaciones);
        
        panelOperaciones.add(btBuscar);
        sp.putConstraint(SpringLayout.SOUTH, btBuscar, -10, SpringLayout.SOUTH, panelOperaciones);
        sp.putConstraint(SpringLayout.WEST, btBuscar, 200, SpringLayout.WEST, panelOperaciones);
        
		panelOperaciones.add(btBorrar);
        sp.putConstraint(SpringLayout.SOUTH, btBorrar, -10, SpringLayout.SOUTH, panelOperaciones);
        sp.putConstraint(SpringLayout.WEST, btBorrar, 300, SpringLayout.WEST, panelOperaciones);
        
		panelOperaciones.add(btModificar);
        sp.putConstraint(SpringLayout.SOUTH, btModificar, -10, SpringLayout.SOUTH, panelOperaciones);
        sp.putConstraint(SpringLayout.WEST, btModificar, 390, SpringLayout.WEST, panelOperaciones);
        
		panelOperaciones.add(btSalir);
        sp.putConstraint(SpringLayout.SOUTH, btSalir, -10, SpringLayout.SOUTH, panelOperaciones);
        sp.putConstraint(SpringLayout.WEST, btSalir, 520, SpringLayout.WEST, panelOperaciones);
        ventana.add(panelOperaciones);
        //Hacemos visible la ventana
        ventana.setVisible(true);
       
	}
	
	public void conectarControlador(Controller c) {
		//LOGIN
		btConectar.addActionListener(c);
		btConectar.setActionCommand("CONECTAR");
		//LIMPIAR
		btLimpiar.addActionListener(c);
		btLimpiar.setActionCommand("LIMPIAR");
		//INSERTAR
		btInsertar.addActionListener(c);
		btInsertar.setActionCommand("INSERTAR");
		//LISTAR
		btListado.addActionListener(c);
		btListado.setActionCommand("LISTAR");
		//BUSCAR
		btBuscar.addActionListener(c);
		btBuscar.setActionCommand("BUSCAR");
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
