package menudesplegable;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

public class Menu1 {
	public static void main(String[] args) {
		Menu1 m = new Menu1("Interfaz Menu");
	}

	/*
	 * Creamos los atributos.
	 */
	private JFrame ventana;
	

	// Scroll
	private JScrollPane scrollPane;
	
	// Partes del menu
	private JMenuBar barraMenu;
	private JMenu menu;
	private JMenuItem leerArchivo;
	private JMenuItem escribirArchivo;
	private JMenuItem salir;
	
	//Introducir texto
	private JTextArea areaTexto;

	public Menu1(String titulo) {
		crearComponentes();
		escribirComponentes(titulo);
		
		eventos();
	}

	private void crearComponentes() {
		ventana = new JFrame();
		barraMenu = new JMenuBar();
		menu = new JMenu("Menu");
		leerArchivo = new JMenuItem("Leer Archivo");
		escribirArchivo = new JMenuItem("Escribir Archivo");
		salir = new JMenuItem("Salir");
		areaTexto = new JTextArea();
		scrollPane = new JScrollPane(areaTexto);

	}

	private void escribirComponentes(String titulo) {
		

		ventana.setTitle(titulo);
		ventana.setSize(500, 500);
		ventana.setLocation(700, 250);

		// Añadimos los items en el menu.
		barraMenu.add(menu);
		menu.add(leerArchivo);
		menu.add(escribirArchivo);
		menu.add(salir);
		
		ventana.add(scrollPane);
		ventana.setJMenuBar(barraMenu);
		ventana.setVisible(true);
	}

	private void eventos() {
		ManjeadorEventos manejador = new ManjeadorEventos();
		leerArchivo.addActionListener(manejador);
		escribirArchivo.addActionListener(manejador);
		salir.addActionListener(manejador);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private class ManjeadorEventos implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == leerArchivo) {
				areaTexto.setText("");
				leerArchivo();
			} else if (e.getSource() == escribirArchivo) {
				escribirArchivo();
			} else if (e.getSource() == salir) {
				ventana.dispose();
			}
		}

		private void leerArchivo() {
			File fichero = elegirFichero();
			JOptionPane.showMessageDialog(ventana, "Fichero: " + fichero.getName());
			FileReader fr = null;
			try {
				String linea;
				BufferedReader bf = new BufferedReader(new FileReader(fichero));

				while ((linea = bf.readLine()) != null) {
					areaTexto.append(linea + "\n");
				}

			} catch (FileNotFoundException ex) {
				ex.printStackTrace();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		private void escribirArchivo() {
			File fichero = elegirFichero();
			FileWriter fw = null;
			try {
				fw = new FileWriter(fichero);
				fw.write(areaTexto.getText());
				JOptionPane.showMessageDialog(ventana, "Fichero guardado.");
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (fw != null) {
						fw.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

		private File elegirFichero() {
			File fichero = null;
			// Creamos el objeto JFileChooser
			JFileChooser fc = new JFileChooser("/home/alumno/Escritorio");
			int opcion = fc.showOpenDialog(ventana);
			// Si pulsa en aceptar
			if (opcion == fc.APPROVE_OPTION) {
				fichero = fc.getSelectedFile();
				return fichero;
			} else if (opcion == fc.CANCEL_OPTION) {
				JOptionPane.showMessageDialog(ventana, "No has elegido ningun fichero.");
			}
			return null;
		}
	}
}