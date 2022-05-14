/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import dao.CuentaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import logicadenegocios.Cuenta;
import vista.CambiarPIN;
import vista.ConsultarCuentasOrdenadas;
import vista.ConsultarInformacionCuentas;
import vista.RegistrarCuenta;

/**
 *
 * @author USUARIO
 */
public class ControladorCuenta implements ActionListener {
  Conexion conexion;
  public ResultSet rs;
  public PreparedStatement ps;
  public JTable tabla;
  public RegistrarCuenta vistaRegistrarCuenta = new RegistrarCuenta();
  public ConsultarCuentasOrdenadas vistaConsultarCuentasOrdenadas = new ConsultarCuentasOrdenadas();
  public ConsultarInformacionCuentas vistaConsultarInformacionCuentas = 
    new ConsultarInformacionCuentas();
  public CambiarPIN vistaCambiarPIN = new CambiarPIN();
  public Cuenta cuenta;
  public CuentaDAO cuentaDao;
  
  public ControladorCuenta(ConsultarCuentasOrdenadas pVistaConsultarCuentasOrdenadas, 
          CuentaDAO pModelo) {
    vistaConsultarCuentasOrdenadas = pVistaConsultarCuentasOrdenadas;
    cuentaDao = pModelo;

    this.vistaConsultarCuentasOrdenadas.btnVolver.addActionListener(this);
  }
  public ControladorCuenta(RegistrarCuenta pVistaRegistroCuenta, Cuenta pCuenta) {

    vistaRegistrarCuenta = pVistaRegistroCuenta;
    cuenta = pCuenta;
    cuentaDao = new CuentaDAO();

    this.vistaRegistrarCuenta.btnRegistrarCuenta.addActionListener(this);
    this.vistaRegistrarCuenta.btnVolver.addActionListener(this);
    this.vistaRegistrarCuenta.btnLimpiarCampos.addActionListener(this);

  }         
  public ControladorCuenta(ConsultarInformacionCuentas pVistaConsultarInformacionCuentas, 
          CuentaDAO pModelo) {
    vistaConsultarInformacionCuentas = pVistaConsultarInformacionCuentas;
    cuentaDao = pModelo;

    this.vistaConsultarInformacionCuentas.btnBuscar.addActionListener(this);
    this.vistaConsultarInformacionCuentas.btnVolver.addActionListener(this);
  }
  
  public ControladorCuenta(CambiarPIN pVistaCambiarPIN, 
          CuentaDAO pModelo) {
    vistaCambiarPIN = pVistaCambiarPIN;
    cuentaDao = pModelo;

    this.vistaCambiarPIN.btnBuscarPIN.addActionListener(this);
    this.vistaCambiarPIN.btnCambiarPIN.addActionListener(this);
    this.vistaCambiarPIN.btnVolver.addActionListener(this);
    this.vistaCambiarPIN.txtPINNoModificable.setEditable(false);
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == vistaRegistrarCuenta.btnRegistrarCuenta) {
      registrarCuenta();
    }
    if (e.getSource() == vistaConsultarInformacionCuentas.btnBuscar){
        consultarInformacionCuentaParticular();
    }
    if (e.getSource() == vistaConsultarInformacionCuentas.btnVolver) {
        this.vistaConsultarInformacionCuentas.setVisible(false);
    }
    if (e.getSource() == vistaConsultarCuentasOrdenadas.btnVolver) {
        this.vistaConsultarCuentasOrdenadas.setVisible(false);
    }
    if (e.getSource() == vistaCambiarPIN.btnBuscarPIN) {
        buscarPIN();
    }
    if (e.getSource() == vistaCambiarPIN.btnCambiarPIN) {
        cambiarPIN();
    }
    if (e.getSource() == vistaCambiarPIN.btnVolver) {
        this.vistaCambiarPIN.setVisible(false);
    }
    if (e.getSource() == vistaRegistrarCuenta.btnVolver) {
        this.vistaRegistrarCuenta.setVisible(false);
    }
    if (e.getSource() == vistaRegistrarCuenta.btnLimpiarCampos) {
        limpiarCampos();
    }
    
  }
  
   public void consultarInformacionCuentaParticular(){
    String cuenta = vistaConsultarInformacionCuentas.cbxCuentas.getSelectedItem().
        toString();
    rs = cuentaDao.consultarInformacionCuentaParticular(cuenta);
    DefaultTableModel dfm = new DefaultTableModel();
    tabla = vistaConsultarInformacionCuentas.tablaInformeCuentaParticular;
    tabla.setModel(dfm);
    dfm.setColumnIdentifiers(new Object[]{"Numero Cuenta","PIN", "ID duenio", "Fecha Creacion",
        "Saldo","Estado", "Primer Apellido", "Segundo Apellido", "Nombre"});
    try {
      while (rs.next()) {
        dfm.addRow(new Object[] {rs.getString("Numero_Cuenta"), rs.getString("PIN"),
        rs.getString("ID_Duenio_Cuenta"),rs.getString("FechaCreacion"), rs.getDouble("Saldo"),
        rs.getString("Estado"), rs.getString("PrimerApellido"), rs.getString("SegundoApellido"),
        rs.getString("Nombre")});
      }    
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null,ex); 
    }
  }    
   
  public void buscarPIN() {
    int numeroCuenta = Integer.parseInt(vistaCambiarPIN.cbxCuentas.getSelectedItem().toString());
    rs = cuentaDao.buscarPIN(numeroCuenta);
    try {
      if (rs.next()) {
        vistaCambiarPIN.txtPINNoModificable.setText(rs.getString(1));
      }
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null,ex); 
    }
  }
  
  public void cambiarPIN() {
  int numeroCuenta = Integer.parseInt(vistaCambiarPIN.cbxCuentas.getSelectedItem().toString());  
  String PINNoModificable = vistaCambiarPIN.txtPINNoModificable.getText().toString();
  String PIN = vistaCambiarPIN.txtPIN.getText().toString();
  String nuevoPIN = vistaCambiarPIN.txtNuevoPIN.getText().toString();
  String nuevoNuevoPIN = vistaCambiarPIN.txtNuevoNuevoPIN.getText().toString();
  if (PINNoModificable.equals(PIN) && nuevoPIN.equals(nuevoNuevoPIN) && 
      validaciones.Validaciones.validarPIN(nuevoPIN)) {
    try {
      cuentaDao.cambiarPIN(nuevoPIN, numeroCuenta);
      JOptionPane.showMessageDialog(vistaCambiarPIN, "Ha sido posible cambiar el "
            + "PIN de la cuenta numero:  " + numeroCuenta);      
    } catch (Exception e) {
      }
    } else {
      JOptionPane.showMessageDialog(vistaCambiarPIN, "ERROR: fallo en el ingreso de datos.  "
            + " No ha sido posible cambiar PIN de la cuenta numero:  " + 
              numeroCuenta + ". Por favor intente de nuevo."); 
      }

  }
  
  public void registrarCuenta() {

    String pPIN = vistaRegistrarCuenta.txtPIN.getText().toString();
    int pIDCliente = Integer.parseInt(vistaRegistrarCuenta.cbxCliente.getSelectedItem().toString());
    String pFechaCreacion = vistaRegistrarCuenta.txtFechaCreacion.getText().toString();
    int pSaldo = Integer.parseInt(vistaRegistrarCuenta.txtSaldoCuenta.getText().toString());
    String pEstado = vistaRegistrarCuenta.cbxEstadoCuenta.getSelectedItem().toString();

    if (validaciones.Validaciones.validarPIN(pPIN) && 
            validaciones.Validaciones.obtenerFechaFormateada(pFechaCreacion) == true) {

        try {

            cuentaDao.registrarCuentaAUnCliente(pPIN, pIDCliente, pFechaCreacion, pSaldo, pEstado);
            JOptionPane.showMessageDialog(vistaCambiarPIN, "Ha sido posible registar la cuenta"
            + "para el Cliente con el ID: " + pIDCliente);

        } catch (Exception e) {
        }

    } else {
      JOptionPane.showMessageDialog(vistaRegistrarCuenta, "ERROR: fallo en el ingreso de datos.  "
            + " No ha sido posible registrar la cuenta al Cliente con el ID  " + 
              pIDCliente+ ". Por favor intente de nuevo."); 

    }


  }
  
  public void limpiarCampos(){
      vistaRegistrarCuenta.txtPIN.setText("");
      vistaRegistrarCuenta.txtFechaCreacion.setText("");
      vistaRegistrarCuenta.txtSaldoCuenta.setText("");
  }
}
