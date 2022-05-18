
package dao;

import conexion.Conexion;

import java.io.IOException;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 * Abstraccion de la clase CuentaDAO
 * Utiliza los procedimientos correspondientes a las cuentas.
 * @author Daniel Vaglio Fallas y Jafet Chavarria Moreno
 * @version Proyecto Programado I
 */
public class CuentaDAO {
  Conexion conexion;
  
  /**
   * Metodo Constructor
   */
  public CuentaDAO() {
    conexion = new Conexion();
  }
  
  /**
   * Metodo que llena el combobox de los numeros de cuenta
   * @return el modelo para llenar el combobox
   */
  public DefaultComboBoxModel llenarComboBox() {
    DefaultComboBoxModel modelo = new DefaultComboBoxModel();
    try {
      CallableStatement cmd = conexion.Conexion().prepareCall("{CALL [dbo].[Combo_NumeroCuenta]}");
      ResultSet resultado = cmd.executeQuery();    
      while (resultado.next()) {
        modelo.addElement(resultado.getString(1));
      }
    } catch (SQLException e) {
    }
      return modelo;
  }
  
  /**
   * Metodo que consulta las cuentas ordenadas descendentemente en funcion del saldo
   * @return el resultado de ejecutar el procedimiento almacenado
   */
  public ResultSet consultarCuentasOrdenadas() {
    Statement ejecutor;
    ResultSet rs = null;
    try {
      Connection con = conexion.Conexion();
      ejecutor = con.createStatement();
      rs = ejecutor.executeQuery("execute dbo.ordenarCuentasDescendentemente");
    } catch (SQLException e) {
    }  
    return rs;
  }
  
  /**
   * Metodo que consulta la Informacion de una cuenta en particular
   * @param pCuenta
   * @return  el resultado de ejecutar el procedimiento almacenado
   */
  public ResultSet consultarInformacionCuentaParticular(String pCuenta) {
    Statement ejecutor;
    ResultSet rs = null;
    try {
      Connection con = conexion.Conexion();
      ejecutor = con.createStatement();
      rs = ejecutor.executeQuery("execute dbo.consultarInformacionCuentaParticular '" 
          + pCuenta +"'");
    } catch (SQLException ex) {
      Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);

    }  
    return rs;
  }
  
  /**
   * Metodo que busca el PIN de una cuenta
   * @param pNumeroCuenta
   * @return el resultado de ejecutar el procedimiento almacenado
   */
  public ResultSet buscarPIN(int pNumeroCuenta) {
    Statement ejecutor;
    ResultSet rs = null;
    
    try {
      Connection con = conexion.Conexion();
      ejecutor = con.createStatement();
      rs = ejecutor.executeQuery("execute dbo.buscarPIN '" 
          + pNumeroCuenta +"'");
    } catch (SQLException e) {
      Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
    }
    return rs;
  }
  
  /**
   * Metodo que cambia el PIN de una cuenta
   * @param pPIN
   * @param pNumeroCuenta 
   */
  public void cambiarPIN(String pPIN, int pNumeroCuenta) {
    try {
      Connection con = conexion.Conexion();
      String query = "dbo.CambiarPIN @PIN = ?, @Numero_Cuenta = ?";
      CallableStatement consulta = con.prepareCall(query);
      consulta.setString(1, pPIN);
      consulta.setInt(2, pNumeroCuenta);
      consulta.execute();
    } catch (SQLException e) {
      Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
    }
  }
  
  /**
   * Metodo que registra una cuenta a un cliente existente
   * @param pPIN
   * @param ID_Duenio_Cuenta
   * @param pFechaCreacion
   * @param pSaldo
   * @param pEstado
   * @throws IOException 
   */
  public void registrarCuentaAUnCliente(String pPIN, int ID_Duenio_Cuenta, String pFechaCreacion,
    double pSaldo, String pEstado) throws IOException {
    Connection conect = conexion.Conexion();
    try {
      CallableStatement cstmt = conect.prepareCall("{call dbo.registrarCuenta(?,?,?,?,?)}");
      cstmt.setString(1, pPIN);
      cstmt.setInt(2, ID_Duenio_Cuenta);
      cstmt.setString(3, pFechaCreacion);
      cstmt.setDouble(4, pSaldo);
      cstmt.setString(5, pEstado);
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
   * Metodo que llena el combobox de los ID's de los clientes
   * @return El modelo para llenar el combobox
   */
  public DefaultComboBoxModel llenarComboBoxRegistroCuenta() {

    DefaultComboBoxModel modelo = new DefaultComboBoxModel();

    try {
      CallableStatement cmd = conexion.Conexion().prepareCall("{CALL [dbo].[Combo_ID_Cliente]}");
      ResultSet resultado = cmd.executeQuery();

      while (resultado.next()) {
        modelo.addElement(resultado.getString(1));
      }
    } catch (SQLException e) {
    }
    return modelo;
  }
  
  /**
   * Metodo que consulta el estado de una cuenta
   * @param pNumeroCuenta
   * @return el resultado de ejecutar el procedimiento almacenado
   */
  public ResultSet consultarEstadoCuenta(int pNumeroCuenta) {
    Statement ejecutor;
    ResultSet rs = null;
    try {
      Connection con = conexion.Conexion();
      ejecutor = con.createStatement();
      rs = ejecutor.executeQuery("execute dbo.consultarEstadoCuenta '" 
          + pNumeroCuenta +"'");
    } catch (SQLException ex) {
      Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);

    }  
    return rs;
  }
  
  /**
   * Metodo que consulta el estatus de una cuenta
   * @param pNumeroCuenta
   * @return el resultado de ejecutar el procedimiento almacenado
  */
  public ResultSet consultarEstatusCuenta(int pNumeroCuenta) {
    Statement ejecutor;
    ResultSet rs = null;
    try {
      Connection con = conexion.Conexion();
      ejecutor = con.createStatement();
      rs = ejecutor.executeQuery("execute dbo.consultarEstatusCuenta '" 
          + pNumeroCuenta + "'");
    } catch (SQLException ex) {
      Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);

    }  
    return rs;
  }
  
  /**
   * Metodo que consulta la informacion de un cliente con respecto a su cuenta
   * @param pNumeroCuenta
   * @return el resultado de ejecutar el procedimiento almacenado
   */
  public ResultSet consultarDatosDuenioCuenta(int pNumeroCuenta) {
    Statement ejecutor;
    ResultSet rs = null;
    try {
      Connection con = conexion.Conexion();
      ejecutor = con.createStatement();
      rs = ejecutor.executeQuery("execute dbo.consultarDatosDuenioCuenta'" 
          + pNumeroCuenta + "'");
    } catch (SQLException e) {
    }  
    return rs;
  }
  
  /**
   * Metodo que obtiene el nombre del cliente a partir de una cuenta
   * @param pNumeroCuenta
   * @return el resultado de ejecutar el procedimiento almacenado
   */
  public ResultSet buscarNumeroCuentaCliente(int pNumeroCuenta) {
    Statement ejecutor;
    ResultSet rs = null;
    try {
      Connection con = conexion.Conexion();
      ejecutor = con.createStatement();
      rs = ejecutor.executeQuery("execute dbo.buscarNumeroCuenta'" 
          + pNumeroCuenta + "'");
    } catch (SQLException e) {
    }  
    return rs;
  }
}
