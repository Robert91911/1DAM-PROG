package basculaTienda;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import ejemplos.GuiBienHecho;


public class Tienda 
{
	private JFrame ventana;
	private Container contenedor;
	private JPanel pnPeso;
	private JPanel pnBotones;
	private JPanel pnPrecio;
	private JLabel lab1;
	private JLabel lab2;
	private JLabel lab3;
	private JLabel lab4;
	private JTextArea txPeso;
	private JTextArea txPrecio;
	private String nombreProducto[] = {"Manzana","Peras","Naranjas","Patatas","Limones","Melones","Cebollas","Ajo","Platanos"};
	private double precioProducto[] = {4.55,6.22,1.52,6.28,2.89,6.74,1.12,9.99,6.54};
	private JButton botonesFruta[] = new JButton[nombreProducto.length];
	private JButton btPeso;
	private JButton btImprimir;
	private JButton btCerrar;
	private int posicion;
	private boolean elegido;
	private boolean pesado;
	private double peso;
	private boolean enter;
	
	public Tienda()
	{
		crearComponentes();
		posicionarComponentes();
		registrarComponentes();
	}

	private void crearComponentes() 
	{
		ventana = new JFrame("Mercadona");
		contenedor = ventana.getContentPane();
		pnPeso = new JPanel();
		lab1 = new JLabel("Campo de peso: ");
		txPeso = new JTextArea();
		lab2 = new JLabel("Pulsa intro despues de introducir el peso");
		pnBotones = new JPanel();
		btPeso = new JButton("Peso");
		btImprimir = new JButton("Imprimir");
		btCerrar = new JButton("Cerrar");
		pnPrecio = new JPanel();
		lab3 = new JLabel("Coste: ");
		txPrecio = new JTextArea();
		lab4 = new JLabel("€");
		for (int i = 0; i < botonesFruta.length;i++) {
			botonesFruta[i] = new JButton(nombreProducto[i]);
		}
		
	}
	private void posicionarComponentes() 
	{
		ventana.setSize(500,400);
	    ventana.setLocation(700, 350);
	    pnPeso.setLayout(new FlowLayout());
	    pnPeso.add(lab1);
	    pnPeso.add(txPeso);
	    pnPeso.add(lab2);
	    pnBotones.setLayout(new GridLayout(0, 3));
		for(int i = 0; i<botonesFruta.length;i++)
			{
				pnBotones.add(botonesFruta[i]);
			}
		pnBotones.add(btPeso);
		pnBotones.add(btImprimir);
		pnBotones.add(btCerrar);
		pnPrecio.setLayout(new FlowLayout());
	    pnPeso.add(lab3);
	    pnPeso.add(txPrecio);
	    pnPeso.add(lab4);
	    contenedor.add(pnPeso , BorderLayout.NORTH);
	    contenedor.add(pnBotones, BorderLayout.CENTER);
	    contenedor.add(pnPrecio, BorderLayout.SOUTH);
	    ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void registrarComponentes() 
	{
		btCerrar.addActionListener(new ManejadorBoton());
		for(int i = 0; i<botonesFruta.length;i++)
		{
			botonesFruta[i].addActionListener(new ManejadorBoton());
		}
		btPeso.addActionListener(new ManejadorBoton());
		btImprimir.addActionListener(new ManejadorBoton());
		ventana.addWindowListener(new CerrarVentana());
		
	}
	class ManejadorBoton implements ActionListener 
    {
		private double peso;
		
    	public void actionPerformed(ActionEvent e)
    	{
            if(e.getSource() == btCerrar)
            {
                ventana.setVisible(false);
                ventana.dispose();
                System.exit (0);
            }
            else
            {
                if(e.getSource() == btPeso)
                {
                    pedirPeso();
                }else if(e.getSource() == btImprimir)
                {
                	imprimirCantidad();
                }
                else if(e.getSource() == txPeso) {
                	peso=Double.parseDouble(txPeso.getText());
    				pesado=true;
                }
                else 
                {
                	buscarProducto(e.getActionCommand());
                }
                
            }
    	}

		private void pedirPeso() 
		{
			txPeso.setText("");
			txPrecio.setText("");
			txPrecio.setEditable(true);
		}

		private void imprimirCantidad() 
		{
			System.out.println(pesado+"\n"+elegido+"\n"+enter);
			if(pesado && elegido)
			{
				txPrecio.setText(Double.toString(peso * precioProducto[posicion]));
				pesado = false;
				elegido= false;
			}
			else
				JOptionPane.showMessageDialog(ventana, "No ha pesado nada o no ha elegido el producto");
		}

		private void buscarProducto(String buscado) 
		{
			posicion=0;
			while(!(buscado.equals(nombreProducto[posicion])))
			{
				posicion++;
			}
			elegido=true;
		}
    }
    public static void main(String args[])
	  {
	      Tienda t1 = new Tienda();
	  }
}
class CerrarVentana extends WindowAdapter
{
    public void windowClosing(WindowEvent e)
    {
            System.exit(0);
    }
}
