package escribirarchivo;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class EscribirArchivoMaster
{
  private JFrame window;
  private Container contentPane;
  private JPanel textAreaContainer;
  private JPanel buttonContainer;
  private JTextArea textArea;
  private JFileChooser fileChooser;
  private JScrollPane scrollPane;
  private JButton fileChooserButton;
  private JButton loadButton;
  private boolean fileOpened = false;
  File file = null;
  
  public EscribirArchivoMaster()
  {
    createComponents();
    positionComponents();
    registerEvents();
  }
  
  public void createComponents()
  {
    this.window = new JFrame();
    
    this.contentPane = this.window.getContentPane();
    
    this.textAreaContainer = new JPanel();
    this.buttonContainer = new JPanel();
    
    this.textArea = new JTextArea(15, 30);
    this.scrollPane = new JScrollPane(this.textArea);
    
    this.fileChooser = new JFileChooser();
    
    this.fileChooserButton = new JButton("Select File");
    this.loadButton = new JButton("Save");
  }
  
  public void positionComponents()
  {
    this.window.setSize(600, 600);
    this.window.setLocation(200, 100);
    this.window.setTitle("File Writer");
    
    this.textAreaContainer.setLayout(new FlowLayout());
    this.textAreaContainer.add(this.textArea);
    this.textAreaContainer.add(this.scrollPane);
    
    this.buttonContainer.setLayout(new FlowLayout());
    this.buttonContainer.add(this.fileChooserButton);
    this.buttonContainer.add(this.loadButton);
    
    this.contentPane.add(this.textAreaContainer, "North");
    this.contentPane.add(this.buttonContainer, "South");
    
    this.window.setVisible(true);
    this.window.setDefaultCloseOperation(3);
  }
  
  public void registerEvents()
  {
    this.fileChooserButton.addActionListener(new EscribirArchivoMaster.ButtonOperationsReader());
    this.loadButton.addActionListener(new EscribirArchivoMaster.ButtonOperationsReader());
  }
  
  class ButtonOperationsReader
    implements ActionListener
  {
    ButtonOperationsReader() {}
    
    public void actionPerformed(ActionEvent paramActionEvent)
    {
      String str1 = paramActionEvent.getActionCommand();
      switch (str1)
      {
      case "Select File": 
        int j = EscribirArchivoMaster.this.fileChooser.showSaveDialog(null);
        if (j == 0)
        {
          EscribirArchivoMaster.this.file = EscribirArchivoMaster.this.fileChooser.getSelectedFile();
          EscribirArchivoMaster.this.fileOpened = true;
        }
        break;
      case "Save": 
        if (!EscribirArchivoMaster.this.fileOpened) {
          JOptionPane.showMessageDialog(EscribirArchivoMaster.this.window, "No file selected.");
        } else {
          try
          {
            FileWriter localFileWriter = new FileWriter(EscribirArchivoMaster.this.file);
            localFileWriter.write(EscribirArchivoMaster.this.textArea.getText());
            localFileWriter.close();
            JOptionPane.showMessageDialog(EscribirArchivoMaster.this.window, "File saved.");
          }
          catch (FileNotFoundException localFileNotFoundException)
          {
            System.out.println("Fichero no encontrado " + localFileNotFoundException.getMessage());
          }
          catch (IOException localIOException)
          {
            System.out.println("Error de entrada y salida " + localIOException.getMessage());
          }
        }
        break;
      }
    }
  }
  
  public static void main(String[] paramArrayOfString)
  {
    new EscribirArchivoMaster();
  }
}