package basculaTienda;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class TiendaMaster 
{
	private String productos[]={"Manzana","Peras","Naranjas","Patatas","Limones","Melones","Cebollas","Ajo","Platanos"};
	private double precioProducto[]={1.75,2.1,2.42,3,2.01,4.5,3.2,1.3,3.4};
	private JButton botonProducto[];
	private int pos;
	private boolean pesado;
	private boolean elegido;
	private double peso;
	private boolean enter;

	//Ventana
	private JFrame ventana;

	//Paneles
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	//Botones
	private JButton botonPeso;
	private JButton botonImprimir;
	private JButton cerrar;

	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel euros;

	//Contenedores
	private Container contenedor;

	//Area de Texto
	private JTextField textPesar;
	private JTextField coste;

	public TiendaMaster()
	{
		crearCom();
		colocar();
		registrar();
	}
////////////////////////////////////////////
	public void crearCom()
	{
		botonProducto = new JButton[productos.length];
		for(int i=0; i<botonProducto.length;i++)
		{
			botonProducto[i]= new JButton(productos[i]);
		}

		ventana = new JFrame ("Ventana");

		contenedor = ventana.getContentPane();

		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();

		label1 = new JLabel("Campo de peso");
		label2 = new JLabel("Coste");
		label3 = new JLabel("Pulsa intro despues de pesar algo");
		euros = new JLabel("€");

		botonPeso = new JButton("Peso");
		botonImprimir = new JButton("Imprimir");
		cerrar = new JButton("Cerrar");

		textPesar = new JTextField(10);
		textPesar.setEditable(false);
		coste = new JTextField(20);
	}
//////////////////////////////////////////////
	public void colocar()
	{
		panel1.setLayout(new GridLayout(4,3,5,10));
		ventana.setTitle("Fruteria");
		ventana.setSize(500,250);
		ventana.setVisible(true);
		ventana.setLocation(500,300);
		ventana.setResizable(true);
		ventana.setDefaultCloseOperation(ventana.EXIT_ON_CLOSE);

		contenedor.add(panel1, BorderLayout.CENTER);
		contenedor.add(panel2, BorderLayout.NORTH);
		contenedor.add(panel3, BorderLayout.SOUTH);

		panel2.add(label1);
		panel3.add(label2);
		panel2.add(textPesar);
		panel3.add(coste);
		panel3.add(euros);
		panel2.add(label3);

		for(int i=0; i<botonProducto.length;i++)
		{
			botonProducto[i]= new JButton(productos[i]);
			panel1.add(botonProducto[i]);
		}
		panel1.add(botonPeso);
		panel1.add(botonImprimir);
		panel1.add(cerrar);
	}
////////////////////////////////////////////////
	public void registrar()
	{
		botonPeso.addActionListener(new ManejadorBoton());
		botonImprimir.addActionListener(new ManejadorBoton());
		cerrar.addActionListener(new ManejadorBoton());
		for(int i=0;i<botonProducto.length;i++)
		{
			botonProducto[i].addActionListener(new ManejadorBoton());
		}
		textPesar.addActionListener(new ManejadorBoton());
	}
///////////////////////////////////////
	class ManejadorBoton implements ActionListener {

		public void actionPerformed(ActionEvent evento)
		{
			Object fuente = evento.getSource();

			if(fuente == cerrar)
			{
				int option = JOptionPane.showConfirmDialog(ventana, "¿Desea Salir?", "Salir", 0);
				if(option == 0)
				{
					ventana.dispose();
					System.exit(0);
				}
			}
			else if(fuente == botonPeso )
			{
				textPesar.setText("");
				coste.setText("");
				textPesar.setEditable(true);
			}
			else if(fuente == textPesar)
			{
				peso=Double.parseDouble(textPesar.getText());
				pesado=true;
			}
			else if(fuente == botonImprimir)
			{
				System.out.println(pesado+"\n"+elegido+"\n"+enter);
				if(pesado && elegido)
				{
					coste.setText(Double.toString(peso * precioProducto[pos]));
					pesado = false;
					elegido=false;
				}
				else
					JOptionPane.showMessageDialog(ventana, "No ha pesado nada o no ha elegido el producto");
				
			}
			//Buscar el producto que ha elegido
			else
			{
				buscarPrecio(evento.getActionCommand());
			}
		}
		public void buscarPrecio(String buscado)
		{
			pos=0;
			while(!(buscado.equals(productos[pos])))
			{
				pos++;
			}
			elegido=true;
		}
	}

	public static void main(String[] args) {
		new TiendaMaster();
	}
}