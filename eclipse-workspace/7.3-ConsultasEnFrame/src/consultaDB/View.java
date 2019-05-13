package consultaDB;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

public class View {
	
	private JFrame ventana;
	private Container contPrincipal;
	
	/******************************  LABELS  ******************************/
	private JLabel lbUsuario;
	private JLabel lbPassword;
	private JLabel lbURL;
	private JLabel lbSentencia;
	
	/******************************  CAMPOS DE TEXTO  ******************************/
	private JTextField txtUsuario;
	private JTextField txtContrasenya;
	private JTextField txtURL;
	private JTextField txtSentencia;
	
	/******************************  BOTONES  ******************************/
	private JButton btResetConex;
	private JButton btEjecutarConsulta;
	private JButton btBorrar;
	
	/******************************  SCROLL PANELS  ******************************/
	private JScrollPane scrollSentencia;
	private JScrollPane scrollTabla;
	
	public JScrollPane scroll;
	public Object[][] datos;
	public String[] cabecera;
	public DefaultTableModel dtm;
	public JTable tabla;
	
	public View() {
		crearComponentes();
		colocarComponentes();
	}
	
	public void crearComponentes() {
		ventana = new JFrame();
		contPrincipal = new Container();
		
		lbUsuario = new JLabel("Usuario");
		lbPassword = new JLabel("Contraseña");
		lbURL = new JLabel("Url de la BD");
		lbSentencia = new JLabel("Sentencia SQL");

		
		txtUsuario = new JTextField(11);
		txtContrasenya = new JTextField(11);
		txtURL = new JTextField(25);
		txtSentencia = new JTextField();
		
		btResetConex = new JButton("Resetear conexion");
		btEjecutarConsulta = new JButton("Consultar");
		btBorrar = new JButton("Borrar");
		
		scrollSentencia = new JScrollPane();
		scrollTabla = new JScrollPane();
		
		scroll = new JScrollPane();
		cabecera = new String[] {"DNI","Nombre","Apellido","Edad"};
		dtm = new DefaultTableModel(datos,cabecera);
		tabla = new JTable(dtm);
	}
	
	public void colocarComponentes() {
		ventana.setBounds(100, 200, 815, 500);
		ventana.setTitle("Consultas directas");
		ventana.setDefaultCloseOperation(2);
		
		SpringLayout sp = new SpringLayout();
		contPrincipal.setLayout(sp);
		
		/********************************************  LABELS  ********************************************/
		contPrincipal.add(lbUsuario);
		sp.putConstraint(SpringLayout.NORTH, lbUsuario, 10, SpringLayout.NORTH, contPrincipal);
		sp.putConstraint(SpringLayout.WEST, lbUsuario, 10, SpringLayout.WEST, contPrincipal);
		contPrincipal.add(lbPassword);
		sp.putConstraint(SpringLayout.NORTH, lbPassword, 10, SpringLayout.NORTH, contPrincipal);
		sp.putConstraint(SpringLayout.WEST, lbPassword, 200, SpringLayout.WEST, contPrincipal);
		contPrincipal.add(lbURL);
		sp.putConstraint(SpringLayout.NORTH, lbURL, 10, SpringLayout.NORTH, contPrincipal);
		sp.putConstraint(SpringLayout.WEST, lbURL, 425, SpringLayout.WEST, contPrincipal);
		contPrincipal.add(lbSentencia);
		sp.putConstraint(SpringLayout.NORTH, lbSentencia, 180, SpringLayout.NORTH, contPrincipal);
		sp.putConstraint(SpringLayout.WEST, lbSentencia, 70, SpringLayout.WEST, contPrincipal);
		
		/********************************************  CAMPOS DE TEXTO  ********************************************/
		contPrincipal.add(txtUsuario);
		sp.putConstraint(SpringLayout.NORTH, txtUsuario, 10, SpringLayout.NORTH, contPrincipal);
		sp.putConstraint(SpringLayout.WEST, txtUsuario, 60, SpringLayout.WEST, contPrincipal);
		contPrincipal.add(txtContrasenya);
		sp.putConstraint(SpringLayout.NORTH, txtContrasenya, 10, SpringLayout.NORTH, contPrincipal);
		sp.putConstraint(SpringLayout.WEST, txtContrasenya, 290, SpringLayout.WEST, contPrincipal);
		contPrincipal.add(txtURL);
		sp.putConstraint(SpringLayout.NORTH, txtURL, 10, SpringLayout.NORTH, contPrincipal);
		sp.putConstraint(SpringLayout.WEST, txtURL, 520, SpringLayout.WEST, contPrincipal);
		scrollSentencia.setViewportView(txtSentencia);
		contPrincipal.add(scrollSentencia);
        sp.putConstraint(SpringLayout.NORTH, scrollSentencia, 60, SpringLayout.NORTH, contPrincipal);
		sp.putConstraint(SpringLayout.WEST, scrollSentencia, 210, SpringLayout.WEST, contPrincipal);
		sp.putConstraint(SpringLayout.EAST, scrollSentencia,  -120, SpringLayout.EAST, contPrincipal);
		sp.putConstraint(SpringLayout.SOUTH, scrollSentencia, -180, SpringLayout.SOUTH, contPrincipal);
		
		scrollTabla.setViewportView(tabla);
		contPrincipal.add(scrollTabla);
        sp.putConstraint(SpringLayout.NORTH, scrollTabla, 320, SpringLayout.NORTH, contPrincipal);
		sp.putConstraint(SpringLayout.WEST, scrollTabla, 80, SpringLayout.WEST, contPrincipal);
		sp.putConstraint(SpringLayout.EAST, scrollTabla,  -120, SpringLayout.EAST, contPrincipal);
		sp.putConstraint(SpringLayout.SOUTH, scrollTabla, -10, SpringLayout.SOUTH, contPrincipal);
		
		/********************************************  BOTONES  ********************************************/
		contPrincipal.add(btResetConex);
		sp.putConstraint(SpringLayout.NORTH, btResetConex, 140, SpringLayout.NORTH, contPrincipal);
		sp.putConstraint(SpringLayout.WEST, btResetConex, 15, SpringLayout.WEST, contPrincipal);
		contPrincipal.add(btEjecutarConsulta);
		sp.putConstraint(SpringLayout.NORTH, btEjecutarConsulta, 140, SpringLayout.NORTH, contPrincipal);
		sp.putConstraint(SpringLayout.EAST, btEjecutarConsulta, -10, SpringLayout.EAST, contPrincipal);
		contPrincipal.add(btBorrar);
		sp.putConstraint(SpringLayout.SOUTH, btBorrar, -70, SpringLayout.SOUTH, contPrincipal);
		sp.putConstraint(SpringLayout.EAST, btBorrar, -20, SpringLayout.EAST, contPrincipal);
		
		ventana.add(contPrincipal);
		ventana.setVisible(true);
	}
	
	public void conectarControlador(Controller c) {
		btResetConex.addActionListener(c);
		btResetConex.setActionCommand("CONECTAR");
		
		btEjecutarConsulta.addActionListener(c);
		btEjecutarConsulta.setActionCommand("CONSULTAR");
		
		btBorrar.addActionListener(c);
		btBorrar.setActionCommand("BORRAR");
	}
}
