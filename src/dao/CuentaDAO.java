/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author USUARIO
 */
public class CuentaDAO {
  Conexion conexion;
  
  public CuentaDAO() {
    conexion = new Conexion();
  }
  
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
  
  public boolean cambiarPIN(String pPIN, int pNumeroCuenta) {
    boolean resultado = false;
    ResultSet rs = null;
    try {
      Connection con = conexion.Conexion();
      String query = "dbo.CambiarPIN @PIN = ?, @Numero_Cuenta = ?";
      CallableStatement consulta = con.prepareCall(query);
      consulta.setString(1, pPIN);
      consulta.setInt(2, pNumeroCuenta);
      consulta.execute();
      resultado = true;
    } catch (SQLException e) {
      Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
    }
    return resultado;
  }
  
  public String registrarCuentaAUnCliente(String pPIN, int ID_Duenio_Cuenta, String pFechaCreacion,
             double pSaldo, String pEstado) throws IOException {

             String resultado = null;

                try {
                 Connection conect = conexion.Conexion();
                 CallableStatement cstmt = conect.prepareCall("{call dbo.registrarCuenta(?,?,?,?,?)}");
                 cstmt.setString(1, pPIN);
                 cstmt.setInt(2, ID_Duenio_Cuenta);
                 cstmt.setString(3, pFechaCreacion);
                 cstmt.setDouble(4, pSaldo);
                 cstmt.setString(5, pEstado);

                 int respuesta = cstmt.executeUpdate();

                 if (respuesta > 0 ) {

                   resultado = "Registro exitoso";
                 }
               } catch (SQLException e) {
                   resultado = ("Error: Revise que los datos que esta ingresando coincidan con los formatos pedidos"
                              + " y vuelva a intentarlo.");
               }

             return resultado;
          }
public DefaultComboBoxModel llenarComboBoxRegistroCuenta() {

    DefaultComboBoxModel modelo = new DefaultComboBoxModel();

      try {
          CallableStatement cmd = conexion.Conexion().prepareCall("{CALL [dbo].[Combo_ID_Cliente]}");
          ResultSet resultado = cmd.executeQuery();

          while (resultado.next()) {
            modelo.addElement(resultado.getString(1));
          }
      } catch (Exception e) {
      }
      return modelo;
  }
}
