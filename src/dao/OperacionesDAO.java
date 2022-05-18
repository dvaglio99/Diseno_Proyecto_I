package dao;

import conexion.Conexion;

import util.EnviarSMS;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Abstraccion de la clase OperacionesDAO
 * Utiliza los procedimientos correspondientes a las diversas operaciones.
 * @author Daniel Vaglio Fallas y Jafet Chavarria Moreno
 * @version Proyecto Programado I
 */
public class OperacionesDAO {
  Conexion conexion;
  
  /**
   * Metodo Constructor
   */
  public OperacionesDAO() {
      conexion = new Conexion();
  }
  
  /**
   * Metodo que busca el nombre del cliente a partir del numero de cuenta
   * @param pNumeroCuenta
   * @return el resultado de ejecutar el procedimiento almacenado 
   */
  public ResultSet buscarNombreCliente(int pNumeroCuenta) {
    Statement ejecutor;
    ResultSet rs = null;
    
    try {
      Connection con = conexion.Conexion();
      ejecutor = con.createStatement();
      rs = ejecutor.executeQuery("execute dbo.buscarNombreCliente '" + pNumeroCuenta +"'");
    } catch (SQLException e) {
      Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
    }
    return rs;
  }
  
  /**
   * Metodo que comprueba si se debe cobrar comision a partir de un deposito
   * @param pNumeroCuenta
   * @return el resultado de ejecutar el procedimiento almacenado
   */
  public ResultSet verificarSiCobrarComisionDeposito(int pNumeroCuenta) {
    Statement ejecutor;
    ResultSet rs = null;
    
    try {
      Connection con = conexion.Conexion();
      ejecutor = con.createStatement();
      rs = ejecutor.executeQuery("execute dbo.VerificarSiCobrarComisionDeposito '" 
          + pNumeroCuenta +"'");
    } catch (SQLException e) {
      Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
    }
    return rs;
  }
   
  /**
   * Metodo que comprueba si se debe cobrar comision a partir de un retiro
   * @param pNumeroCuenta
   * @return el resultado de ejecutar el procedimiento almacenado
   */
  public ResultSet verificarSiCobrarComisionRetiro(int pNumeroCuenta) {
    Statement ejecutor;
    ResultSet rs = null;
    
    try {
      Connection con = conexion.Conexion();
      ejecutor = con.createStatement();
      rs = ejecutor.executeQuery("execute dbo.VerificarSiCobrarComisionRetiro '" + pNumeroCuenta +"'");
    } catch (SQLException e) {
      Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
    }
    return rs;
  }
   
  /**
   * Metodo que obtiene la ultima operacion que se procesa
   * @return el resultado de ejecutar el procedimiento almacenado
   */
  public ResultSet obtenerUltimaOperacion() {
    Statement ejecutor;
    ResultSet rs = null;
    
    try {
      Connection con = conexion.Conexion();
      ejecutor = con.createStatement();
      rs = ejecutor.executeQuery("execute dbo.obtenerUltimaOperacion");
    } catch (SQLException e) {
      Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
    }
    return rs;
  } 
   
  /**
   * Metodo que registra un Deposito a una cuenta
   * @param pMonto
   * @param pNumeroCuenta 
   */
  public void registrarDeposito(int pMonto, int pNumeroCuenta) {
    PreparedStatement ps;
    Connection conect = conexion.Conexion();
    try {
      CallableStatement cstmt = conect.prepareCall("{call dbo.depositar(?,?)}");
      cstmt.setInt(1, pMonto);
      cstmt.setInt(2, pNumeroCuenta);
      cstmt.executeUpdate();    
    } catch (SQLException e) { 
        System.err.println(e);
    }
  }
  
  /**
   * Metodo que cobra la comision si es el caso de una operacion
   * @param pMonto
   * @param pNumeroCuenta
   * @param pNumeroOperacion 
   */
  public void cobrarComision(int pMonto, int pNumeroCuenta, int pNumeroOperacion) {
    PreparedStatement ps;
    Connection conect = conexion.Conexion();
    try {
      CallableStatement cstmt = conect.prepareCall("{call dbo.Cobrar_Comision(?,?,?)}");
      cstmt.setInt(1, pMonto);
      cstmt.setInt(2, pNumeroCuenta);
      cstmt.setInt(3, pNumeroOperacion);
      cstmt.executeUpdate();    
    } catch (SQLException e) { 
        System.err.println(e);
    }
  }
  
  /**
   * Metodo que obtiene el numero telefonico de un cliente a partir del numero de cuenta asociado
   * @param pNumeroCuenta
   * @return el resultado de ejecutar el procedimiento almacenado
   */
  public ResultSet obtenerNumeroTelefonicoCliente(int pNumeroCuenta) {
    Statement ejecutor;
    ResultSet rs = null;
    
    try {
      Connection con = conexion.Conexion();
      ejecutor = con.createStatement();
      rs = ejecutor.executeQuery("execute dbo.obtenerNumeroTelefonicoCliente '" + pNumeroCuenta +"'");
    } catch (SQLException e) {
      Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
    }
    return rs;
  }
  
  /**
   * metodo que obtiene el saldo de una cuenta en particular
   * @param pNumeroCuenta
   * @return el resultado de ejecutar el procedimiento almacenado
   */
  public ResultSet obtenerSaldoCliente(int pNumeroCuenta) {
    Statement ejecutor;
    ResultSet rs = null;
    
    try {
      Connection con = conexion.Conexion();
      ejecutor = con.createStatement();
      rs = ejecutor.executeQuery("execute dbo.buscarSaldoCuenta '" + pNumeroCuenta +"'");
    } catch (SQLException e) {
      Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
    }
    return rs;
  }
  
  /**
   * Metodo que envia el SMS con la palabra clave
   * @param pTelefono
   * @param pPalabraClave 
   */
  public void enviarPalabraClave(String pTelefono, String pPalabraClave) {
    EnviarSMS.enviarSMS(pTelefono, pPalabraClave);    
  }
  
  /**
   * Metodo que registra un retiro 
   * @param pMonto
   * @param pNumeroCuenta 
   */
  public void registrarRetiro(int pMonto, int pNumeroCuenta) {
    PreparedStatement ps;
    Connection conect = conexion.Conexion();
    try {
      CallableStatement cstmt = conect.prepareCall("{call dbo.retirar(?,?)}");
      cstmt.setInt(1, pMonto);
      cstmt.setInt(2, pNumeroCuenta);
      cstmt.executeUpdate();    
    } catch (SQLException e) { 
        System.err.println(e);
    }
  }
  
  /**
   * Metodo que registra una transferencia
   * @param pMonto
   * @param pNumeroCuentaOrigen
   * @param pNumeroCuentaDestino 
   */
  public void registrarTransferencia(int pMonto, int pNumeroCuentaOrigen, int pNumeroCuentaDestino) {
    PreparedStatement ps;
    Connection conect = conexion.Conexion();
    try {
      CallableStatement cstmt = conect.prepareCall("{call dbo.transferir(?,?,?)}");
      cstmt.setInt(1, pMonto);
      cstmt.setInt(2, pNumeroCuentaOrigen);
      cstmt.setInt(3, pNumeroCuentaDestino);
      cstmt.executeUpdate();    
    } catch (SQLException e) { 
        System.err.println(e);
    }
  }
  
  /**
   * metodo que obtiene las comisiones totales del universo de cuentas
   * @return el resultado de ejecutar el procedimiento almacenado 
   */
  public ResultSet obtenerComisionesTotalesCuentas() {
    Statement ejecutor;
    ResultSet rs = null;
    
    try {
      Connection con = conexion.Conexion();
      ejecutor = con.createStatement();
      rs = ejecutor.executeQuery("execute dbo.consultarComisionesTotalesCuentas");
    } catch (SQLException e) {
      Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
    }
    return rs;
  } 
  
  /**
   * Metodo que calcula y obtiene las ganancias producto de las comisiones para el universo de 
   * cuentas
   * @return el resultado de ejecutar el procedimiento almacenado
   */
  public ResultSet consultarGananciasComisionesTotalizado() {
    Statement ejecutor;
    ResultSet rs = null;
    
    try {
      Connection con = conexion.Conexion();
      ejecutor = con.createStatement();
      rs = ejecutor.executeQuery("execute dbo.consultarGananciasComisionesTotalizado");
    } catch (SQLException e) {
      Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
    }
    return rs;
  } 
  
  /**
   * Metodo que obtiene las comisiones de una cuenta en particular
   * @param pNumeroCuenta
   * @return el resultado de ejecutar el procedimiento almacenado
   */
  public ResultSet obtenerComisionesTotalesCuentaParticular(int pNumeroCuenta) {
    Statement ejecutor;
    ResultSet rs = null;
    
    try {
      Connection con = conexion.Conexion();
      ejecutor = con.createStatement();
      rs = ejecutor.executeQuery("execute dbo.consultarComisionesTotalesCuentaParticular '" 
          + pNumeroCuenta +"'");
    } catch (SQLException e) {
      Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
    }
    return rs;
  }
  
  /**
   * Metodo que calcula el ingreso por comisiones de una cuenta en particular
   * @param pNumeroCuenta
   * @return el resultado de ejecutar el procedimiento almacenado
   */
  public ResultSet obtenerGananciasComisionesTotalesCuentaParticular(int pNumeroCuenta) {
    Statement ejecutor;
    ResultSet rs = null;
    
    try {
      Connection con = conexion.Conexion();
      ejecutor = con.createStatement();
      rs = ejecutor.executeQuery("execute dbo.consultarGananciasComisionesTotalesCuentaParticular '" 
          + pNumeroCuenta +"'");
    } catch (SQLException e) {
      Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
    }
    return rs;
  }
}
