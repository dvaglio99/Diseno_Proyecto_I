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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vista.RealizarDeposito;
import vista.RealizarRetiro;

/**
 *
 * @author USUARIO
 */
public class ControladorOperaciones implements ActionListener {
  public OperacionesDAO operacionDao; 
  public CuentaDAO cuentaDao;
  public RealizarDeposito vistaRealizarDeposito = new  RealizarDeposito();
  public RealizarRetiro vistaRealizarRetiro = new RealizarRetiro();
  ResultSet rs;
  ResultSet rs2;
  
  public ControladorOperaciones(RealizarDeposito pVistaRealizarDeposito, CuentaDAO pCuentaDao,
      OperacionesDAO pOperacionesDao) {
    vistaRealizarDeposito = pVistaRealizarDeposito;
    cuentaDao = pCuentaDao;
    operacionDao = pOperacionesDao;
    this.vistaRealizarDeposito.btnBuscarCliente.addActionListener(this);
    this.vistaRealizarDeposito.btnVolver.addActionListener(this);
    this.vistaRealizarDeposito.btnDepositar.addActionListener(this);
    this.vistaRealizarDeposito.txtPropietarioCuenta.setEditable(false);
    this.vistaRealizarDeposito.txtCantidadOperaciones.setEditable(false);
  }
  public ControladorOperaciones(RealizarRetiro pVistaRealizarRetiro, CuentaDAO pCuentaDao,
      OperacionesDAO pOperacionesDao) {
    vistaRealizarRetiro = pVistaRealizarRetiro;
    cuentaDao = pCuentaDao;
    operacionDao = pOperacionesDao;
    this.vistaRealizarRetiro.btnBuscarCliente.addActionListener(this);
    this.vistaRealizarRetiro.btnVolver.addActionListener(this);
    this.vistaRealizarRetiro.btnRetirar.addActionListener(this);
    this.vistaRealizarRetiro.btnVerificarPIN.addActionListener(this);
    this.vistaRealizarRetiro.btnVerificarPalabraClave.addActionListener(this);
    this.vistaRealizarRetiro.txtPropietarioCuenta.setEditable(false);
    this.vistaRealizarRetiro.txtCantidadOperaciones.setEditable(false);
    this.vistaRealizarRetiro.txtPINNoModificable.setEditable(false);
    this.vistaRealizarRetiro.txtPalabraClaveNoModificable.setEditable(false);
    this.vistaRealizarRetiro.txtNumeroTelefonicoCliente.setEditable(false);
    this.vistaRealizarRetiro.txtSaldoNoModificable.setEditable(false);
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getSource() == vistaRealizarDeposito.btnBuscarCliente) {
      buscarNombreCliente();
    }
    if (e.getSource() == vistaRealizarDeposito.btnDepositar) {
      realizarDeposito();
    }
    if(e.getSource() == vistaRealizarRetiro.btnBuscarCliente) {
      buscarNombreClienteRetiro();
    }
    if(e.getSource()== vistaRealizarRetiro.btnVerificarPIN){
      verificarPIN();
    }
    if(e.getSource() == vistaRealizarRetiro.btnVerificarPalabraClave) {
      verificarPalabraClave();
    }
    if(e.getSource() == vistaRealizarRetiro.btnRetirar) {
      realizarRetiro();
    }
    if(e.getSource() == vistaRealizarDeposito.btnVolver) {
      this.vistaRealizarDeposito.setVisible(false);
    }
    if(e.getSource() == vistaRealizarRetiro.btnVolver) {
      this.vistaRealizarRetiro.setVisible(false);
    }
   }
    
  public void buscarNombreCliente() {
    int numeroCuenta = Integer.parseInt(vistaRealizarDeposito.cbxCuentas.getSelectedItem().
        toString());
    rs = operacionDao.buscarNombreCliente(numeroCuenta);
    rs2 = operacionDao.verificarSiCobrarComision(numeroCuenta);
    try {
      if (rs.next()) {
        vistaRealizarDeposito.txtPropietarioCuenta.setText(rs.getString(1)+ " " + rs.getString(2)+
        " " + rs.getString(3));
      }
      if (rs2.next()){
        vistaRealizarDeposito.txtCantidadOperaciones.setText(rs2.getString(1));
      } else{
        vistaRealizarDeposito.txtCantidadOperaciones.setText("0");
      }
      
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null,ex); 
    }

  }
  
  public void buscarNombreClienteRetiro() {
    ResultSet rs3;
    ResultSet rs4;
    ResultSet rs5;
    int numeroCuenta = Integer.parseInt(vistaRealizarRetiro.cbxCuentas.getSelectedItem().
        toString());
    rs = operacionDao.buscarNombreCliente(numeroCuenta);
    rs2 = operacionDao.verificarSiCobrarComision(numeroCuenta);
    rs3 = cuentaDao.buscarPIN(numeroCuenta);
    rs4 = operacionDao.obtenerNumeroTelefonicoCliente(numeroCuenta);
    rs5 = operacionDao.obtenerSaldoCliente(numeroCuenta);
    try {
      if (rs.next()) {
        vistaRealizarRetiro.txtPropietarioCuenta.setText(rs.getString(1)+ " " + rs.getString(2)+
        " " + rs.getString(3));
      }
      if (rs2.next()){
        vistaRealizarRetiro.txtCantidadOperaciones.setText(rs2.getString(1));
      } else{
        vistaRealizarRetiro.txtCantidadOperaciones.setText("0");
      }
      if (rs3.next()){
        vistaRealizarRetiro.txtPINNoModificable.setText(rs3.getString(1));
      }
      if (rs4.next()){
        vistaRealizarRetiro.txtNumeroTelefonicoCliente.setText(rs4.getString(1));
      }
      if (rs5.next()){
        vistaRealizarRetiro.txtSaldoNoModificable.setText(rs5.getString(1));
      }
      
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null,ex); 
    }

  }
  
  public void realizarDeposito() {
    ResultSet rs3;
    String montoValidacion = vistaRealizarDeposito.txtMonto.getText();
    
    if (validaciones.Validaciones.validarMontoSinDecimal(montoValidacion) != true){
      
      JOptionPane.showMessageDialog(vistaRealizarDeposito, "ERROR: no sido posible validar el monto:"
          + "  " + montoValidacion);
        
    } else {
      int montoDeposito = Integer.parseInt(montoValidacion);
      int montoComision = (int) (montoDeposito * 0.02);
      int numeroCuenta = Integer.parseInt(vistaRealizarDeposito.cbxCuentas.getSelectedItem()
         .toString());
      operacionDao.registrarDeposito(montoDeposito, numeroCuenta);
      rs3 = operacionDao.obtenerUltimaOperacion();
      try {
        if (rs3.next()){
            vistaRealizarDeposito.lblNumOp.setText(rs3.getString(1));
            int numeroOperacion = Integer.parseInt(vistaRealizarDeposito.lblNumOp.getText());
            int numeroCantidadOperacionesEfectuadas = Integer.parseInt(vistaRealizarDeposito.txtCantidadOperaciones.
                getText());
            if (numeroCantidadOperacionesEfectuadas >= 3) {
              operacionDao.cobrarComision(montoComision, numeroCuenta, numeroOperacion);
              JOptionPane.showMessageDialog(vistaRealizarDeposito, "Estimado usuario, se han depositado "
                + " correctamente "+ montoDeposito+" colones\n" +
                "El monto real depositado a su cuenta "+numeroCuenta+" es de "+montoDeposito+" colones\n"+
                "El monto cobrado por concepto de comisión fue de "+montoComision+" colones, que " +
          "     fueron rebajados automáticamente de su saldo actual");
            } else {
                JOptionPane.showMessageDialog(vistaRealizarDeposito, "Estimado usuario, se han depositado "
          + " correctamente "+ montoDeposito+" colones\n" +
          "El monto real depositado a su cuenta "+numeroCuenta+" es de "+montoDeposito+" colones\n"+
          "El monto cobrado por concepto de comisión fue de 0.00 colones");
            }
        }  
      } catch (SQLException ex) {
            Logger.getLogger(ControladorOperaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  }
  
  public void verificarPIN() {
    String PINNoModificable = vistaRealizarRetiro.txtPINNoModificable.getText();
    String PIN = vistaRealizarRetiro.txtPIN.getText();
    String numeroTelefonico = vistaRealizarRetiro.txtNumeroTelefonicoCliente.getText();
     if (PINNoModificable.equals(PIN)){
       JOptionPane.showMessageDialog(vistaRealizarDeposito, "El PIN ingresdo coincide con el PIN "
         + "registrado en la cuenta");
       String palabraClave = util.EnviarSMS.generarPalabra();
       operacionDao.enviarPalabraClave(numeroTelefonico, palabraClave);
       JOptionPane.showMessageDialog(vistaRealizarDeposito, ": Estimado usuario se ha " +
        "enviado una palabra por mensaje de texto, por favor revise sus mensajes y " +
        "proceda a digitar la palabra enviada");
       vistaRealizarRetiro.txtPalabraClaveNoModificable.setText(palabraClave);
     } else{
       JOptionPane.showMessageDialog(vistaRealizarDeposito, "El PIN ingresdo no coincide con el PIN "
         + "registrado en la cuenta. Intente de nuevo.");
       vistaRealizarRetiro.txtPIN.setText("");
     }
  }
    
  public void verificarPalabraClave() {
    String palabraClaveNoModificable = vistaRealizarRetiro.txtPalabraClaveNoModificable.getText();
    String palabraClave = vistaRealizarRetiro.txtPalabraClave.getText();
    if (palabraClaveNoModificable.equals(palabraClave)){
      JOptionPane.showMessageDialog(vistaRealizarDeposito, "La palabra clave ingresda coincide con "
          + "la palabra enviada por SMS. Por favor continue con la operacion");
    } else {
      JOptionPane.showMessageDialog(vistaRealizarDeposito, "La palabra clave ingresda no coincide con "
           + "la palabra enviada por SMS. Por favor, intente de nuevo.");
      vistaRealizarRetiro.txtPalabraClave.setText("");
    } 
  }
  
  public void verificarSaldoMayorQueMonto() {
    String montoValidacion = vistaRealizarRetiro.txtMonto.getText();
    String saldoCuenta = vistaRealizarRetiro.txtSaldoNoModificable.getText();
    double saldoCuentaNumero = Double.parseDouble(saldoCuenta);
    int montoRetiro = Integer.parseInt(montoValidacion);
    int numeroCuenta = Integer.parseInt(vistaRealizarRetiro.cbxCuentas.getSelectedItem()
         .toString());
    if (montoRetiro <= saldoCuentaNumero){
        operacionDao.registrarRetiro(montoRetiro, numeroCuenta);  
      } else {
          JOptionPane.showMessageDialog(vistaRealizarRetiro, "Estimado usuario, el monto de "
            + "este retiro es de"+ montoRetiro +" colones \n" +
            "el cual supera el saldo actual de su cuenta. Intente de nuevo");
          vistaRealizarRetiro.txtMonto.setText("");
        }
    
  }
  
  public void realizarRetiro(){
    ResultSet rs3;
    String montoValidacion = vistaRealizarRetiro.txtMonto.getText();    
    if (validaciones.Validaciones.validarMontoSinDecimal(montoValidacion) != true){
      
      JOptionPane.showMessageDialog(vistaRealizarRetiro, "ERROR: no sido posible validar el monto:"
          + "  " + montoValidacion);
        
    } else {
      int montoRetiro = Integer.parseInt(montoValidacion);
      int montoComision = (int) (montoRetiro * 0.02);
      int numeroCuenta = Integer.parseInt(vistaRealizarRetiro.cbxCuentas.getSelectedItem()
         .toString());
      
      rs3 = operacionDao.obtenerUltimaOperacion();
      try {
        if (rs3.next()){
          vistaRealizarRetiro.lblNumOp.setText(rs3.getString(1));
          int numeroOperacion = Integer.parseInt(vistaRealizarRetiro.lblNumOp.getText());
          int numeroCantidadOperacionesEfectuadas = Integer.parseInt(vistaRealizarRetiro.
            txtCantidadOperaciones.getText());
            
          if (numeroCantidadOperacionesEfectuadas >= 3) {
            verificarSaldoMayorQueMonto();
            operacionDao.cobrarComision(montoComision, numeroCuenta, numeroOperacion);
            JOptionPane.showMessageDialog(vistaRealizarRetiro, "Estimado usuario, el monto de "
                + "este retiro es de"+ montoRetiro +" colones.\n" +
                "El monto cobrado por concepto de comisión fue de "+ montoComision+" colones, "
                + "que fueron rebajados automáticamente de su saldo actual");
          } else {
            verificarSaldoMayorQueMonto();
            JOptionPane.showMessageDialog(vistaRealizarRetiro, "Estimado usuario, el monto de "
                + "este retiro es de"+ montoRetiro +" colones.\n" +
                "El monto cobrado por concepto de comisión fue de 0.00 colones.");
            }  
      
        }
      }    catch (SQLException ex) {
            Logger.getLogger(ControladorOperaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }     
  }
}