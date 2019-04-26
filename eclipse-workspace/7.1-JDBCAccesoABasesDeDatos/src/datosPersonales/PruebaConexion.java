package datosPersonales;

/**
*
* @author albertjh
*/
import java.sql.*;
public class PruebaConexion {

  static String bd = "DATOS";
  static String login = "robert9191";

  static String password = "Clave_00";
  static String url = "jdbc:mysql://localhost/"+bd;

  public static void main(String[] args) throws Exception {

     Connection conn = null;

     try {

        Class.forName("com.mysql.jdbc.Driver").newInstance();
        //System.out.print("Introduce la contraseña: ");
        //password=Leer.dato();
        conn = DriverManager.getConnection(url,login,password);
        
        if (conn != null) {
           System.out.println("Conexión a base de datos "+url+" ... Ok");
           Statement SentenciaSQL = conn.createStatement();
           ResultSet Personas = SentenciaSQL.executeQuery("SELECT * FROM DatosPersonales");
           Personas.close();
           SentenciaSQL.close();
           conn.close();
        }
     }
     catch(SQLException ex) {
        System.out.println("Hubo un problema al intentar conectarse con la base de datos "+url);
     }
     catch(ClassNotFoundException ex) {
        System.out.println(ex);
     }

  }
}