package escribirarchivo;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.FileChooserUI;


public class EscribirArchivo 
{
	private JFrame ventana;
	
	private Container contenedor;
	
	private JScrollPane panelDeslizable;
	
	private JPanel panelTexto;
	private JPanel panelBotones;
	
	private JTextArea areaDeTexto;
	
	private JButton sleArchivo;
	private JButton guardarArchivo;
	
	private JFileChooser mostratFicheros;
	private File fichero;
    FileReader fr = null;
    BufferedReader br = null;
	
	public EscribirArchivo() 
	{
		crearComponentes();
		posicionarComponentes();
		registrarComponentes();
	}

	private void crearComponentes() 
	{
		//Ventana
		ventana = new JFrame();
		//Content pane
		contenedor = ventana.getContentPane();
		//Paneles
		panelTexto = new JPanel();
		panelDeslizable = new JScrollPane(panelTexto);
		panelBotones = new JPanel();
		//contenido
		areaDeTexto = new JTextArea(20, 40);
		sleArchivo = new JButton("Seleccionar archivo");
		guardarArchivo = new JButton("Guardar el fichero");
		
	}

	private void posicionarComponentes()
	{
		//Ventana y sus propiedades
		ventana.setSize(500,400);
		ventana.setLocation(700, 350);
		ventana.setTitle("Escribir texto en un fichero");
		
		//Añadir elementos al contenedor
		panelTexto.setLayout(new FlowLayout());
		panelTexto.add(areaDeTexto);
		panelBotones.setLayout(new GridLayout(1, 2));
		panelBotones.add(sleArchivo);
		panelBotones.add(guardarArchivo);
		
		//Paneles
		contenedor.add(panelDeslizable, BorderLayout.NORTH);
		contenedor.add(panelBotones, BorderLayout.SOUTH);
		
		//Ventana
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void registrarComponentes() 
	{
		
		sleArchivo.addActionListener(new OperacionesConBotones());
		guardarArchivo.addActionListener(new OperacionesConBotones());
	}
	
		class OperacionesConBotones implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				JButton sourceButton = null;
				
				if(e.getSource() == sleArchivo)
				{
				    JFileChooser chooser = new JFileChooser();
				    int returnVal = chooser.showOpenDialog(contenedor);
				    if (returnVal == JFileChooser.APPROVE_OPTION)
				    {
				       File fichero = chooser.getSelectedFile();
				       FileWriter writer = null;
				       try {	
				    	   fr = new FileReader (fichero);
				           br = new BufferedReader(fr);
					} catch (IOException e1) {
						e1.printStackTrace();
					}finally {
						try{                    
				            if( null != fr ){   
				               fr.close();     
				            }                  
				         }catch (Exception e2){ 
				            e2.printStackTrace();
				         }
					}
				    }
				}
				else if(sourceButton == guardarArchivo)
				{
				
					
				}

			}

		}
		public static void main(String[] args) 
		{
			new EscribirArchivo();
		}
	
}
