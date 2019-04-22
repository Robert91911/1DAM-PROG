package calculadora;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculadora {
	private JFrame ventana;
    private Container cp;
    private Label lab;
    private Label lab1;
    private Label lab2;
    private JTextField primerNumero;
    private JTextField segundoNumero;
    private JTextField resultado;
    private JButton sumar;
    private JButton restar;
    private JButton multiplicar;
    private JButton dividir;
    private JButton borrar;
    private JButton salir;
    private JPanel panel1;
    private JPanel panel2;

    
    public Calculadora(String titulo, String mensaje[])
    {
    	crearComponentes();
        colocarComponentes(mensaje, titulo);
    }
    public void crearComponentes()
    {
        ventana = new JFrame();
        //labels
    	lab = new Label("Primer número");
        lab1 = new Label("Segundo número");
        lab2 = new Label("Resultado");
        
        //textfields
        primerNumero = new JTextField(20);
        segundoNumero = new JTextField(20);
        resultado = new JTextField(20);
        
        //botones
        sumar = new JButton("+");
        restar = new JButton("-");
        multiplicar = new JButton("*");
        dividir = new JButton("/");
        borrar = new JButton("Borrar");
        salir = new JButton("Salir");
        
        //paneles
        panel1 = new JPanel();
        panel2 = new JPanel();
        
    }
    public void colocarComponentes(String mensaje[], String titulo)
    {
        cp = ventana.getContentPane();
        
        
        ventana.setTitle(titulo);
        ventana.setSize(250,300); //tamano
        ventana.setResizable(true);  //redimensonable
        cp.setForeground(Color.blue); //Color del fondo
        panel1.setLayout(new GridLayout(0,2));
        ventana.add(lab);
        ventana.add(primerNumero);
        ventana.add(lab1);
        ventana.add(segundoNumero);
        ventana.add(lab2);
        ventana.add(resultado);
        panel2.setLayout(new FlowLayout());
        ventana.add(sumar);
        ventana.add(restar);
        ventana.add(multiplicar);
        ventana.add(dividir);
        ventana.add(borrar);
        ventana.add(salir);
        ventana.setVisible(true);
       
    }
    public static void main(String args[])
    {
     String mensaje[] = {
          "Calculadora",
          "Puede hacer operaciones muy básicas"};

      Calculadora f = new Calculadora("Calculadora", mensaje);

     }
}
class CerrarVentana extends WindowAdapter
{
    public void windowClosing(WindowEvent e)
    {
            System.exit(0);
    }
}
