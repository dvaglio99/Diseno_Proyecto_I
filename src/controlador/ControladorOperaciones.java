/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.CuentaDAO;
import dao.OperacionesDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import vista.RealizarDeposito;

/**
 *
 * @author USUARIO
 */
public class ControladorOperaciones implements ActionListener {
  public OperacionesDAO operacionDao; 
  public CuentaDAO cuentaDao;
  public RealizarDeposito vistaRealizarDeposito = new  RealizarDeposito();
  ResultSet rs;
  
  public ControladorOperaciones(RealizarDeposito pVistaRealizarDeposito, CuentaDAO pCuentaDao,
      OperacionesDAO pOperacionesDao) {
    vistaRealizarDeposito = pVistaRealizarDeposito;
    cuentaDao = pCuentaDao;
    operacionDao = pOperacionesDao;
    this.vistaRealizarDeposito.btnBuscarCliente.addActionListener(this);
    this.vistaRealizarDeposito.btnVolver.addActionListener(this);
    this.vistaRealizarDeposito.btnDepositar.addActionListener(this);
    this.vistaRealizarDeposito.txtPropietarioCuenta.setEditable(false);
  }

    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource() == vistaRealizarDeposito.btnBuscarCliente) {
        buscarNombreCliente();
      }
      if (e.getSource() == vistaRealizarDeposito.btnDepositar) {
        realizarDeposito();
      }
      if(e.getSource() == vistaRealizarDeposito.btnVolver) {
        this.vistaRealizarDeposito.setVisible(false);
      }
    }
    
    public void buscarNombreCliente() {
      int numeroCuenta = Integer.parseInt(vistaRealizarDeposito.cbxCuentas.getSelectedItem().
          toString());
      rs = operacionDao.buscarNombreCliente(numeroCuenta);
      try {
        if (rs.next()) {
          vistaRealizarDeposito.txtPropietarioCuenta.setText(rs.getString(1)+ " " + rs.getString(2)
            + " " + rs.getString(3));
        }
      } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,ex); 
      }

    }
    
  public void realizarDeposito() {
    String montoValidacion = vistaRealizarDeposito.txtMonto.getText();
    
    if (validaciones.Validaciones.validarMontoSinDecimal(montoValidacion) != true){
      
      JOptionPane.showMessageDialog(vistaRealizarDeposito, "ERROR: no sido posible validar el monto:"
          + "  " + montoValidacion);
        
   
    } else {
      int montoDeposito = Integer.parseInt(montoValidacion);
      int numeroCuenta = Integer.parseInt(vistaRealizarDeposito.cbxCuentas.getSelectedItem()
         .toString());
      operacionDao.registrarDeposito(montoDeposito, numeroCuenta);
      JOptionPane.showMessageDialog(vistaRealizarDeposito, "Ha sido posible validar el monto:"
          + "  " + montoValidacion);
    }
  }
    
}
