/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class OperacionesDAO {
  Conexion conexion;
  
  public OperacionesDAO() {
      conexion = new Conexion();
  }
  
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
}
