package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class View {
	public JFrame ventana;
	
	public JPanel panelPrincipal;
	public JPanel panelModificacion;
	
	public String nombreBotones[] = {"Crear Fichero", "Abrir Fichero", "Añadir Registro","Modificar Registro", "Eliminar Registro", "Visualizar Registro", "Salir", "Referencia", "Descripcion", "Precio","Salir y guardar", "Salir sin guardar"};
	public JButton botones[] = new JButton[nombreBotones.length];
	
	public JLabel lbPos;
	public JLabel lbRef;
	public JLabel lbDesc;
	public JLabel lbPrecio;
	
	public JTextField txtPos;
	public JTextField txtRef;
	public JTextField txtDesc;
	public JTextField txtPrecio;
	
	public View() {
		crearComponentes();
		colocarComponentesPrincipal();
	}
	
	public void crearComponentes() {
		ventana = new JFrame();
		panelPrincipal = new JPanel();
		panelModificacion = new JPanel();
		int i = 0;
		while(i < nombreBotones.length) {
			botones[i] = new JButton(nombreBotones[i]);
			i++;
		}
		txtPos = new JTextField();
		txtRef = new JTextField();
		txtDesc = new JTextField();
		txtPrecio = new JTextField();
		
		lbPos = new JLabel("Posicion");
		lbRef = new JLabel("Referencia");
		lbDesc = new JLabel("Descripcion");
		lbPrecio = new JLabel("Precio");
	}
	public void colocarComponentesPrincipal() {
		ventana.setBounds(100,100,600,300);
		ventana.setTitle("Acceso aleatorio con GUI");
		ventana.setDefaultCloseOperation(2);
		SpringLayout sp = new SpringLayout();
		panelPrincipal.setLayout(sp);
		int i = 0;
		while(i < 7) {
			panelPrincipal.add(botones[i]);
			sp.putConstraint(SpringLayout.NORTH, botones[i], 10+i*40, SpringLayout.NORTH, panelPrincipal);
			sp.putConstraint(SpringLayout.WEST, botones[i], 20, SpringLayout.WEST, panelPrincipal);
			i++;
		}
		
		panelPrincipal.add(txtPos);
        sp.putConstraint(SpringLayout.NORTH, txtPos, 50, SpringLayout.NORTH, panelPrincipal);
		sp.putConstraint(SpringLayout.WEST, txtPos, 390, SpringLayout.WEST, panelPrincipal);
		sp.putConstraint(SpringLayout.EAST, txtPos, 590, SpringLayout.WEST, panelPrincipal);
		
		panelPrincipal.add(txtRef);
        sp.putConstraint(SpringLayout.NORTH, txtRef, 100, SpringLayout.NORTH, panelPrincipal);
		sp.putConstraint(SpringLayout.WEST, txtRef, 390, SpringLayout.WEST, panelPrincipal);
		sp.putConstraint(SpringLayout.EAST, txtRef, 590, SpringLayout.WEST, panelPrincipal);
		
		panelPrincipal.add(txtDesc);
        sp.putConstraint(SpringLayout.NORTH, txtDesc, 150, SpringLayout.NORTH, panelPrincipal);
		sp.putConstraint(SpringLayout.WEST, txtDesc, 390, SpringLayout.WEST, panelPrincipal);
		sp.putConstraint(SpringLayout.EAST, txtDesc, 590, SpringLayout.WEST, panelPrincipal);
		
		panelPrincipal.add(txtPrecio);
        sp.putConstraint(SpringLayout.NORTH, txtPrecio, 200, SpringLayout.NORTH, panelPrincipal);
		sp.putConstraint(SpringLayout.WEST, txtPrecio, 390, SpringLayout.WEST, panelPrincipal);
		sp.putConstraint(SpringLayout.EAST, txtPrecio, 590, SpringLayout.WEST, panelPrincipal);
		
		panelPrincipal.add(lbPos);
		sp.putConstraint(SpringLayout.NORTH, lbPos, 50, SpringLayout.NORTH, panelPrincipal);
		sp.putConstraint(SpringLayout.WEST, lbPos, 300, SpringLayout.WEST, panelPrincipal);
		
		panelPrincipal.add(lbRef);
		sp.putConstraint(SpringLayout.NORTH, lbRef, 100, SpringLayout.NORTH, panelPrincipal);
		sp.putConstraint(SpringLayout.WEST, lbRef, 300, SpringLayout.WEST, panelPrincipal);

		panelPrincipal.add(lbDesc);
		sp.putConstraint(SpringLayout.NORTH, lbDesc, 150, SpringLayout.NORTH, panelPrincipal);
		sp.putConstraint(SpringLayout.WEST, lbDesc, 300, SpringLayout.WEST, panelPrincipal);
		
		panelPrincipal.add(lbPrecio);
		sp.putConstraint(SpringLayout.NORTH, lbPrecio, 200, SpringLayout.NORTH, panelPrincipal);
		sp.putConstraint(SpringLayout.WEST, lbPrecio, 300, SpringLayout.WEST, panelPrincipal);
		ventana.add(panelPrincipal);
		ventana.setVisible(true);
		//colocarComponentesModifiRegistro();
	}
	
	public void colocarComponentesModifiRegistro() {
		ventana.setBounds(100,100,600,300);
		ventana.setTitle("Modificar registro");
		SpringLayout sp = new SpringLayout();
		panelModificacion.setLayout(sp);
		int i = 7;
		while(i < 12) {
			panelModificacion.add(botones[i]);
			sp.putConstraint(SpringLayout.NORTH, botones[i], 10+(i-7)*40, SpringLayout.NORTH, panelModificacion);
			sp.putConstraint(SpringLayout.WEST, botones[i], 10, SpringLayout.WEST, panelModificacion);
			i++;
		}
		panelModificacion.add(txtPos);
        sp.putConstraint(SpringLayout.NORTH, txtPos, 50, SpringLayout.NORTH, panelModificacion);
		sp.putConstraint(SpringLayout.WEST, txtPos, 390, SpringLayout.WEST, panelModificacion);
		sp.putConstraint(SpringLayout.EAST, txtPos, 590, SpringLayout.WEST, panelModificacion);
		
		panelModificacion.add(txtRef);
        sp.putConstraint(SpringLayout.NORTH, txtRef, 100, SpringLayout.NORTH, panelModificacion);
		sp.putConstraint(SpringLayout.WEST, txtRef, 390, SpringLayout.WEST, panelModificacion);
		sp.putConstraint(SpringLayout.EAST, txtRef, 590, SpringLayout.WEST, panelModificacion);
		
		panelModificacion.add(txtDesc);
        sp.putConstraint(SpringLayout.NORTH, txtDesc, 150, SpringLayout.NORTH, panelModificacion);
		sp.putConstraint(SpringLayout.WEST, txtDesc, 390, SpringLayout.WEST, panelModificacion);
		sp.putConstraint(SpringLayout.EAST, txtDesc, 590, SpringLayout.WEST, panelModificacion);
		
		panelModificacion.add(txtPrecio);
        sp.putConstraint(SpringLayout.NORTH, txtPrecio, 200, SpringLayout.NORTH, panelModificacion);
		sp.putConstraint(SpringLayout.WEST, txtPrecio, 390, SpringLayout.WEST, panelModificacion);
		sp.putConstraint(SpringLayout.EAST, txtPrecio, 590, SpringLayout.WEST, panelModificacion);
		
		panelModificacion.add(lbPos);
		sp.putConstraint(SpringLayout.NORTH, lbPos, 50, SpringLayout.NORTH, panelModificacion);
		sp.putConstraint(SpringLayout.WEST, lbPos, 300, SpringLayout.WEST, panelModificacion);
		
		panelModificacion.add(lbRef);
		sp.putConstraint(SpringLayout.NORTH, lbRef, 100, SpringLayout.NORTH, panelModificacion);
		sp.putConstraint(SpringLayout.WEST, lbRef, 300, SpringLayout.WEST, panelModificacion);

		panelModificacion.add(lbDesc);
		sp.putConstraint(SpringLayout.NORTH, lbDesc, 150, SpringLayout.NORTH, panelModificacion);
		sp.putConstraint(SpringLayout.WEST, lbDesc, 300, SpringLayout.WEST, panelModificacion);
		
		panelModificacion.add(lbPrecio);
		sp.putConstraint(SpringLayout.NORTH, lbPrecio, 200, SpringLayout.NORTH, panelModificacion);
		sp.putConstraint(SpringLayout.WEST, lbPrecio, 300, SpringLayout.WEST, panelModificacion);
		
		ventana.add(panelModificacion);
	}
	public void conectarControlador(Controller c) {
		int i = 0;
		while(i < 12) {
			botones[i].addActionListener(c);
			i++;
		}
	}
}
