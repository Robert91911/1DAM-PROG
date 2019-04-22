package ejemplos;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.event.*;

public class  GuiBienHecho
{
    private JFrame ventana;
    private JButton botonEsp;
    private JButton botonSalir;
    private JTextField campoTexto;
    private Container cp;

    public GuiBienHecho(String titulo, String mensaje[])
    {
        crearComponentes();
        colocarComponentes(mensaje, titulo);
        registrarEventos();

    }
    ///////////////////////////////////
    public void crearComponentes()
    {
        ventana = new JFrame();
        botonEsp = new JButton("Esperar");
        botonSalir = new JButton("Salir");
        campoTexto = new JTextField(20);
    }
    ///////////////////////////////////
    public void colocarComponentes(String mensaje[], String titulo)
    {
        cp = ventana.getContentPane();
        ventana.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));
        
        ventana.setTitle(titulo);
        ventana.setSize(200,300); //tamano
        ventana.setResizable(true);  //redimensonable
        cp.setForeground(Color.blue); //Color del fondo
        for(int i = 0; i < mensaje.length; i++)
            ventana.add(new JLabel(mensaje[i]));   
        ventana.add(botonEsp);
        ventana.add(botonSalir);
        ventana.add(campoTexto);   
        ventana.setVisible(true);
    }
    ///////////////////////////////////
    public void registrarEventos()
    {
        botonEsp.addActionListener(new ManejadorBoton());
        botonSalir.addActionListener(new ManejadorBoton());
        
       
        ventana.addWindowListener(new CerrarVentana());
    }
    ///////////////////////////////////
    class ManejadorBoton implements ActionListener 
    {
    	public void actionPerformed(ActionEvent e)
    	{
            //getSource devuelve la referencia del objeto fuente que ha detectado el evento
            if(e.getSource() == botonSalir)
            {
                ventana.setVisible(false);
                ventana.dispose(); //liberar los recursos del Frame
                System.exit (0); //sale de la aplicaci¢n a lo bestia
            }
            else
            {
                if(e.getSource() == botonEsp)
                {
                    campoTexto.setText("Ji, Ji,sigue esperando");
                    cp.setBackground(Color.red);
                }
            }
    	}
    }
    ///////////////////////////////////
    public static void main(String args[])
    {
     String mensaje[] = {
          "A V I S O",
          "Si estudias, Java te resultará  sencillo",
          "es posible que llegue a gustarte",
          "pulsa salir para abandonar el programa"};

      GuiBienHecho f = new GuiBienHecho("Ejemplo3GUI", mensaje);

     }
}
///////////////////////////////////
class CerrarVentana extends WindowAdapter
{
    public void windowClosing(WindowEvent e)
    {
            System.exit(0);
    }
}