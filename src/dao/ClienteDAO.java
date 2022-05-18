package dao;


import conexion.Conexion;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 * Abstraccion de la clase ClienteDAO
 * Utiliza los procedimientos correspondientes a los clientes.
 * @author Daniel Vaglio Fallas y Jafet Chavarria Moreno
 * @version Proyecto Programado I
 */
public class ClienteDAO {
	Conexion conexion;
  
  /**
   * Metodo Constructor
   */
  public ClienteDAO() {
    conexion = new Conexion();
  }

  /**
   * Metodo para llenar el comboBox de las identificaciones de los clientes
   * @return el modelo de combo box  
   */
  public DefaultComboBoxModel llenarComboBox() {
    DefaultComboBoxModel modelo = new DefaultComboBoxModel();
    try {
      CallableStatement cmd = conexion.Conexion().prepareCall("{CALL [dbo].[Combo_IdentificacionClientes]}");
      ResultSet resultado = cmd.executeQuery();    
      while (resultado.next()) {
        modelo.addElement(resultado.getString(1));
      }
    } catch (SQLException e) {
    }
      return modelo;
  }
  
  /**
   * Metodo que registra una persona y la vez un cliente
   * @param primerApellido
   * @param segundoApellido
   * @param nombre
   * @param identificacion
   * @param fechaNacimiento
   * @param numeroTelefonico
   * @param correoElectronico
   * @throws IOException 
   */
  public void registrarCliente(String primerApellido, String segundoApellido, String nombre,
          String identificacion, String fechaNacimiento, String numeroTelefonico,
          String correoElectronico) throws IOException {
    PreparedStatement ps;
    Connection conect = conexion.Conexion();    		   
    try {
      CallableStatement cstmt2 = conect.prepareCall("{call dbo.registrarPersona(?,?,?,?,?,?,?)}");
      cstmt2.setString(1, primerApellido);
      cstmt2.setString(2, segundoApellido);
      cstmt2.setString(3, nombre);
      cstmt2.setString(4, identificacion);
      cstmt2.setString(5, fechaNacimiento);
      cstmt2.setString(6, numeroTelefonico);
      cstmt2.setString(7, correoElectronico);
      cstmt2.executeUpdate();
      CallableStatement cstmt = conect.prepareCall("{call dbo.registrarCliente(?,?,?,?,?,?,?)}");
      cstmt.setString(1, primerApellido);
      cstmt.setString(2, segundoApellido);
      cstmt.setString(3, nombre);
      cstmt.setString(4, identificacion);
      cstmt.setString(5, fechaNacimiento);
      cstmt.setString(6, numeroTelefonico);
      cstmt.setString(7, correoElectronico);
      cstmt.executeUpdate();		         
    } catch (SQLException e) {
      System.err.println(e);
    }
    finally{
      try{
        conect.close();
      } catch(SQLException e){
	System.err.println(e);
      }
    }  
  }
  
  /**
   * Metodo que consulta los clientes ordenados ascendentemente en funcion del primer apellido.
   * @return el resultado de ejecutar el procedimiento almacenado
   */
  public ResultSet consultarClientesOrdenados() {
    Statement ejecutor;
    ResultSet rs = null;
    try {
      Connection con = conexion.Conexion();
      ejecutor = con.createStatement();
      rs = ejecutor.executeQuery("execute dbo.ordenarClientesAscendentemente");
    } catch (SQLException e) {
    }  
    return rs;
  }
  
  /**
   * Metodo que consulta la informacion de un Cliente en particular
   * @param pCliente
   * @return el resultado de ejecutar el procedimiento almacenado
   */
  public ResultSet consultarInformacionClienteParticular(String pCliente) {
    Statement ejecutor;
    ResultSet rs = null;
    try {
      Connection con = conexion.Conexion();
      ejecutor = con.createStatement();
      rs = ejecutor.executeQuery("execute dbo.consultarInformacionClienteParticular '" 
          + pCliente +"'");
    } catch (SQLException ex) {
      Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);

    }  
    return rs;
  }
}
