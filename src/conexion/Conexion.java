
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Abstraccion de la clase Conexion
 * Clase que realiza la conexion a la base de datos en SQL Server
 * @author Daniel Vaglio Fallas y Jafet Chavarria Moreno
 * @version Proyecto Programado I
 */
public class Conexion {
    
  //Conexion BD Jafet
  //String connectionURL = "jdbc:sqlserver://localhost\\SQLEXPRESS01:1434;databaseName=SistemaBancario;user=usuario;password=1234;";
  //Conexion BD Daniel
  String connectionURL = "jdbc:sqlserver://DESKTOP-N2DB42H\\ADMIN:1433;databaseName=SistemaBancario;user=admin;password=123;";
  Connection con = null;
  
  /**
   * Metodo que realiza la conexion a la base de datos
   * @return la conexion efectuada a la base de datos
   */  
  public Connection Conexion() {
    try {
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
      con = DriverManager.getConnection(connectionURL);
      //System.out.println("ConexiÃ³n exitosa.");
          
    } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
      Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
    }
    return con;
  }
  
/**
 * Metodo que realiza la desconexion de la base de datos
 */  
  public void desconectar() {
    try{
      System.out.println("Cerrando conexion");
      con.close();
    } catch(SQLException ex){
      System.out.println(ex.getErrorCode());
    }
  } 
}
