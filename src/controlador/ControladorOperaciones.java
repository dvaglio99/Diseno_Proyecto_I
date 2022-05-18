package controlador;

import dao.CuentaDAO;
import dao.OperacionesDAO;

import vista.ConsultarGananciasComisionesCuentaParticular;
import vista.ConsultarGananciasComisionesTotalizado;
import vista.RealizarDeposito;
import vista.RealizarRetiro;
import vista.RealizarTransferencia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 * Abstraccion de la clase ControladorOperaciones
 * Utiliza las funcionalidades de las operaciones de la solucion
 * @author Daniel Vaglio Fallas y Jafet Chavarria Moreno
 * @version Proyecto Programado I
 */
public class ControladorOperaciones implements ActionListener {
  public OperacionesDAO operacionDao; 
  public CuentaDAO cuentaDao;
  public RealizarDeposito vistaRealizarDeposito = new  RealizarDeposito();
  public RealizarRetiro vistaRealizarRetiro = new RealizarRetiro();
  public RealizarTransferencia vistaRealizarTransferencia = new RealizarTransferencia();
  public ConsultarGananciasComisionesTotalizado vistaConsultarGananciasComisionesTotalizado =
      new ConsultarGananciasComisionesTotalizado();
  public ConsultarGananciasComisionesCuentaParticular 
      vistaConsultarGananciasComisionesCuentaParticular = 
      new ConsultarGananciasComisionesCuentaParticular();
  ResultSet rs;
  ResultSet rs2;
  
  /**
   * Metodo constructor para la vista de Realizar Deposito en colones
   * @param pVistaRealizarDeposito
   * @param pCuentaDao
   * @param pOperacionesDao 
   */  
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
  
  /**
   * Metodo constructor que abre la vista de Realizar Retiro en Colones
   * @param pVistaRealizarRetiro
   * @param pCuentaDao
   * @param pOperacionesDao 
   */
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
  
  /**
   * Metodo que abre la vista de realizar Transferencia
   * @param pVistaRealizarTransferencia
   * @param pCuentaDao
   * @param pOperacionesDao 
   */
  public ControladorOperaciones (RealizarTransferencia pVistaRealizarTransferencia, 
          CuentaDAO pCuentaDao, OperacionesDAO pOperacionesDao){
      vistaRealizarTransferencia = pVistaRealizarTransferencia;
      cuentaDao = pCuentaDao;
      operacionDao = pOperacionesDao;
      this.vistaRealizarTransferencia.btnBuscarCliente.addActionListener(this);
      this.vistaRealizarTransferencia.btnBuscarClienteDestino.addActionListener(this);
      this.vistaRealizarTransferencia.btnTransferir.addActionListener(this);
      this.vistaRealizarTransferencia.btnVerificarPIN.addActionListener(this);
      this.vistaRealizarTransferencia.btnVerificarPalabraClave.addActionListener(this);
      this.vistaRealizarTransferencia.btnVolver.addActionListener(this);
      this.vistaRealizarTransferencia.txtPropietarioCuenta.setEditable(false);
      this.vistaRealizarTransferencia.txtCantidadOperaciones.setEditable(false);
      this.vistaRealizarTransferencia.txtNumeroTelefonicoCliente.setEditable(false);
      this.vistaRealizarTransferencia.txtPINNoModificable.setEditable(false);
      this.vistaRealizarTransferencia.txtPalabraClaveNoModificable.setEditable(false);
      this.vistaRealizarTransferencia.txtPropietarioCuentaDestino.setEditable(false);
      this.vistaRealizarTransferencia.txtSaldoNoModificable.setEditable(false);
  }
  
  /**
   * Metodo que abre la vista de Consultar Ganancias por Comisiones Totalizado
   * @param pVistaConsultarGananciasComisionesTotalizado
   * @param pOperacionesDAO 
   */
  public ControladorOperaciones (ConsultarGananciasComisionesTotalizado 
      pVistaConsultarGananciasComisionesTotalizado, OperacionesDAO pOperacionesDAO){
    vistaConsultarGananciasComisionesTotalizado = pVistaConsultarGananciasComisionesTotalizado;
    operacionDao = pOperacionesDAO;
    this.vistaConsultarGananciasComisionesTotalizado.btnCalcularTotalComisiones.
        addActionListener(this);
    this.vistaConsultarGananciasComisionesTotalizado.btnVolver.addActionListener(this);
  }
  
  /**
   * Metodo que abre la vista de Consultar Ganancias por Comisiones para una cuenta en particular
   * @param pVistaConsultarGananciasComisionesCuentaParticular
   * @param pOperacionesDAO 
   */
  public ControladorOperaciones (ConsultarGananciasComisionesCuentaParticular 
      pVistaConsultarGananciasComisionesCuentaParticular, OperacionesDAO pOperacionesDAO){
    vistaConsultarGananciasComisionesCuentaParticular = 
        pVistaConsultarGananciasComisionesCuentaParticular;
    operacionDao = pOperacionesDAO;
    this.vistaConsultarGananciasComisionesCuentaParticular.btnCalcularTotalComisiones.
        addActionListener(this);
    this.vistaConsultarGananciasComisionesCuentaParticular.btnBuscar.addActionListener(this);
    this.vistaConsultarGananciasComisionesCuentaParticular.btnVolver.addActionListener(this);
    this.vistaConsultarGananciasComisionesCuentaParticular.txtPropietarioCuenta.setEditable(false);
  }
  
  /**
   * Metodo que ejecuta las diferentes opciones del menu de modificaciones
   * @param e recibe la accion del boton
   */
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
      verificarPINRetiro();
    }
    if(e.getSource() == vistaRealizarRetiro.btnVerificarPalabraClave) {
      verificarPalabraClaveRetiro();
    }
    if(e.getSource() == vistaRealizarRetiro.btnRetirar) {
      realizarRetiro();
    }
    if(e.getSource() == vistaRealizarTransferencia.btnBuscarCliente) {
      buscarNombreClienteTransferencia();
    }
    if(e.getSource() == vistaRealizarTransferencia.btnBuscarClienteDestino) {
      buscarNombreClienteDestinoTransferencia();
    }
    if(e.getSource()== vistaRealizarTransferencia.btnVerificarPIN){
      verificarPINTransferencia();
    }
    if(e.getSource() == vistaRealizarTransferencia.btnVerificarPalabraClave) {
      verificarPalabraClaveTransferencia();
    }
    if(e.getSource() == vistaRealizarTransferencia.btnTransferir) {
      realizarTransferencia();
    }
    if(e.getSource() == vistaConsultarGananciasComisionesTotalizado.btnCalcularTotalComisiones) {
      calcularTotalComisiones();
    }
    if(e.getSource() == vistaConsultarGananciasComisionesCuentaParticular.btnBuscar) {
      buscarNombreClienteConsultaComisionesTotales();
    }
    if(e.getSource() == vistaConsultarGananciasComisionesCuentaParticular.
        btnCalcularTotalComisiones){
      calcularTotalComisionesCuentaParticular();
    }
    if(e.getSource() == vistaRealizarDeposito.btnVolver) {
      this.vistaRealizarDeposito.setVisible(false);
    }
    if(e.getSource() == vistaRealizarRetiro.btnVolver) {
      this.vistaRealizarRetiro.setVisible(false);
    }
    if(e.getSource() == vistaRealizarTransferencia.btnVolver) {
      this.vistaRealizarTransferencia.setVisible(false);
    }
    if(e.getSource() == vistaConsultarGananciasComisionesTotalizado.btnVolver){
      this.vistaConsultarGananciasComisionesTotalizado.setVisible(false);
    }
    if(e.getSource() == vistaConsultarGananciasComisionesCuentaParticular.btnVolver){
      this.vistaConsultarGananciasComisionesCuentaParticular.setVisible(false);
    }
   }
  
  /**
   * Metodo que busca el nombre del cliente para realizar un deposito
  */  
  public void buscarNombreCliente() {
    int numeroCuenta = Integer.parseInt(vistaRealizarDeposito.cbxCuentas.getSelectedItem().
        toString());
    rs = operacionDao.buscarNombreCliente(numeroCuenta);
    rs2 = operacionDao.verificarSiCobrarComisionDeposito(numeroCuenta);
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
  
  /**
   * Metodo que busca el nombre del cliente para realizar un retiro
  */ 
  public void buscarNombreClienteRetiro() {
    ResultSet rs3;
    ResultSet rs4;
    ResultSet rs5;
    int numeroCuenta = Integer.parseInt(vistaRealizarRetiro.cbxCuentas.getSelectedItem().
        toString());
    rs = operacionDao.buscarNombreCliente(numeroCuenta);
    rs2 = operacionDao.verificarSiCobrarComisionRetiro(numeroCuenta);
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
  
  /**
   * Metodo que busca el nombre del cliente de la cuenta origen para realizar una transferencia
  */ 
  public void buscarNombreClienteTransferencia() {
    ResultSet rs3;
    ResultSet rs4;
    ResultSet rs5;
    int numeroCuentaOrigen = Integer.parseInt(vistaRealizarTransferencia.cbxCuentas.getSelectedItem().
        toString());
    
    rs = operacionDao.buscarNombreCliente(numeroCuentaOrigen);
    rs2 = operacionDao.verificarSiCobrarComisionRetiro(numeroCuentaOrigen);
    rs3 = cuentaDao.buscarPIN(numeroCuentaOrigen);
    rs4 = operacionDao.obtenerNumeroTelefonicoCliente(numeroCuentaOrigen);
    rs5 = operacionDao.obtenerSaldoCliente(numeroCuentaOrigen);
    try {
      if (rs.next()) {
        vistaRealizarTransferencia.txtPropietarioCuenta.setText(rs.getString(1)+ " " + rs.getString(2)+
        " " + rs.getString(3));
      }
      if (rs2.next()){
        vistaRealizarTransferencia.txtCantidadOperaciones.setText(rs2.getString(1));
      } 
       if (rs3.next()){
        vistaRealizarTransferencia.txtPINNoModificable.setText(rs3.getString(1));
      }
      if (rs4.next()){
        vistaRealizarTransferencia.txtNumeroTelefonicoCliente.setText(rs4.getString(1));
      }
      if (rs5.next()){
        vistaRealizarTransferencia.txtSaldoNoModificable.setText(rs5.getString(1));
      }
      
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null,ex); 
    }

  }
  
  /**
   * Metodo que busca el nombre del cliente de la cuenta destino para realizar una transferencia
  */ 
  public void buscarNombreClienteDestinoTransferencia(){
    int numeroCuentaDestino = Integer.parseInt(vistaRealizarTransferencia.cbxCuentasDestino.
        getSelectedItem().toString());
    rs = operacionDao.buscarNombreCliente(numeroCuentaDestino);
    try {
      if (rs.next()) {
        vistaRealizarTransferencia.txtPropietarioCuentaDestino.setText(rs.getString(1)+ " " + 
            rs.getString(2) + " " + rs.getString(3));
      }
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null,ex); 
    }
  }
  
  /**
   * Metodo que busca el nombre del cliente de la cuenta para consultar las ganancias de comisiones
  */ 
  public void buscarNombreClienteConsultaComisionesTotales(){
    int numeroCuenta = Integer.parseInt(vistaConsultarGananciasComisionesCuentaParticular.
        cbxCuentas.getSelectedItem().toString());
    rs = operacionDao.buscarNombreCliente(numeroCuenta);
    try {
      if (rs.next()) {
        vistaConsultarGananciasComisionesCuentaParticular.txtPropietarioCuenta.
            setText(rs.getString(1)+ " " + rs.getString(2) + " " + rs.getString(3));
        JTable tabla;
        DefaultTableModel dfm = new DefaultTableModel();
        rs2 = operacionDao.obtenerComisionesTotalesCuentaParticular(numeroCuenta);
        tabla = vistaConsultarGananciasComisionesCuentaParticular.tablaComisiones;
        tabla.setModel(dfm);
        dfm.setColumnIdentifiers(new Object[]{"Monto Comision", "Numero de cuenta",
            "Numero de Operacion"});
        while (rs2.next()) {
          dfm.addRow(new Object[] {rs2.getString("MontoComision"),rs2.getString("NumeroCuenta_Comision"),
              rs2.getString("NumeroOperacion_Comision")});
        }
      }
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null,ex);
    }
  }
  
  /**
   * Metodo que realiza un deposito 
   */
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
  
  /**
   * Metodo que verifica el PIN de un retiro 
   */
  public void verificarPINRetiro() {
    String PINNoModificable = vistaRealizarRetiro.txtPINNoModificable.getText();
    String PIN = vistaRealizarRetiro.txtPIN.getText();
    String numeroTelefonico = vistaRealizarRetiro.txtNumeroTelefonicoCliente.getText();
     if (PINNoModificable.equals(PIN)){
       JOptionPane.showMessageDialog(vistaRealizarRetiro, "El PIN ingresdo coincide con el PIN "
         + "registrado en la cuenta");
       String palabraClave = util.EnviarSMS.generarPalabra();
       operacionDao.enviarPalabraClave(numeroTelefonico, palabraClave);
       JOptionPane.showMessageDialog(vistaRealizarRetiro, ": Estimado usuario se ha " +
        "enviado una palabra por mensaje de texto, por favor revise sus mensajes y " +
        "proceda a digitar la palabra enviada");
       vistaRealizarRetiro.txtPalabraClaveNoModificable.setText(palabraClave);
     } else{
       JOptionPane.showMessageDialog(vistaRealizarRetiro, "El PIN ingresdo no coincide con el PIN "
         + "registrado en la cuenta. Intente de nuevo.");
       vistaRealizarRetiro.txtPIN.setText("");
     }
  }
  
  /**
   * Metodo que verifica la palabra clave para realizar un retiro 
   */
  public void verificarPalabraClaveRetiro() {
    String palabraClaveNoModificable = vistaRealizarRetiro.txtPalabraClaveNoModificable.getText();
    String palabraClave = vistaRealizarRetiro.txtPalabraClave.getText();
    if (palabraClaveNoModificable.equals(palabraClave)){
      JOptionPane.showMessageDialog(vistaRealizarRetiro, "La palabra clave ingresda coincide con "
          + "la palabra enviada por SMS. Por favor continue con la operacion");
    } else {
      JOptionPane.showMessageDialog(vistaRealizarRetiro, "La palabra clave ingresda no coincide con "
           + "la palabra enviada por SMS. Por favor, intente de nuevo.");
      vistaRealizarRetiro.txtPalabraClave.setText("");
    } 
  }
  
  /**
   * Metodo que verifica si el saldo de la cuenta es mayor que el monto a retirar para realizar un
   * retiro
   */
  public void verificarSaldoMayorQueMontoRetiro() {
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
  
  /**
   * Metodo que realiza un retiro 
   */
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
            verificarSaldoMayorQueMontoRetiro();
            operacionDao.cobrarComision(montoComision, numeroCuenta, numeroOperacion);
            JOptionPane.showMessageDialog(vistaRealizarRetiro, "Estimado usuario, el monto de "
                + "este retiro es de"+ montoRetiro +" colones.\n" +
                "El monto cobrado por concepto de comisión fue de "+ montoComision+" colones, "
                + "que fueron rebajados automáticamente de su saldo actual");
          } else {
            verificarSaldoMayorQueMontoRetiro();
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
  
  /**
   * Metodo para verificar si el PIN coincide con el ingresado para una trasnferencia
   */
  public void verificarPINTransferencia() {
    String PINNoModificable = vistaRealizarTransferencia.txtPINNoModificable.getText();
    String PIN = vistaRealizarTransferencia.txtPIN.getText();
    String numeroTelefonico = vistaRealizarTransferencia.txtNumeroTelefonicoCliente.getText();
     if (PINNoModificable.equals(PIN)){
       JOptionPane.showMessageDialog(vistaRealizarTransferencia, "El PIN ingresdo coincide con el PIN "
         + "registrado en la cuenta");
       String palabraClave = util.EnviarSMS.generarPalabra();
       operacionDao.enviarPalabraClave(numeroTelefonico, palabraClave);
       JOptionPane.showMessageDialog(vistaRealizarTransferencia, ": Estimado usuario se ha " +
        "enviado una palabra por mensaje de texto, por favor revise sus mensajes y " +
        "proceda a digitar la palabra enviada");
       vistaRealizarTransferencia.txtPalabraClaveNoModificable.setText(palabraClave);
     } else{
       JOptionPane.showMessageDialog(vistaRealizarTransferencia, "El PIN ingresdo no coincide con el PIN "
         + "registrado en la cuenta. Intente de nuevo.");
       vistaRealizarTransferencia.txtPIN.setText("");
     }
  }
  
  /**
   * Metodo para verificar si la palabra clave coincide con la ingresada para una trasnferencia
   */
  public void verificarPalabraClaveTransferencia() {
    String palabraClaveNoModificable = vistaRealizarTransferencia.txtPalabraClaveNoModificable.getText();
    String palabraClave = vistaRealizarTransferencia.txtPalabraClave.getText();
    if (palabraClaveNoModificable.equals(palabraClave)){
      JOptionPane.showMessageDialog(vistaRealizarTransferencia, "La palabra clave ingresda coincide con "
          + "la palabra enviada por SMS. Por favor continue con la operacion");
    } else {
      JOptionPane.showMessageDialog(vistaRealizarTransferencia, "La palabra clave ingresda no coincide con "
           + "la palabra enviada por SMS. Por favor, intente de nuevo.");
      vistaRealizarTransferencia.txtPalabraClave.setText("");
    } 
  }
  
   /**
   * Metodo que verifica si el saldo de la cuenta es mayor que el monto a retirar para 
   * una transferencia
   */
  public void verificarSaldoMayorQueMontoTransferencia() {
    String montoValidacion = vistaRealizarTransferencia.txtMonto.getText();
    String saldoCuenta = vistaRealizarTransferencia.txtSaldoNoModificable.getText();
    double saldoCuentaNumero = Double.parseDouble(saldoCuenta);
    int montoRetiro = Integer.parseInt(montoValidacion);
    int numeroCuentaOrigen = Integer.parseInt(vistaRealizarTransferencia.cbxCuentas.getSelectedItem()
         .toString());
    int numeroCuentaDestino = Integer.parseInt(vistaRealizarTransferencia.cbxCuentasDestino.getSelectedItem()
         .toString());
    if (montoRetiro <= saldoCuentaNumero){
        operacionDao.registrarTransferencia(montoRetiro, numeroCuentaOrigen, numeroCuentaDestino);
    } else {
          JOptionPane.showMessageDialog(vistaRealizarRetiro, "Estimado usuario, el monto de "
            + "este retiro es de"+ montoRetiro +" colones \n" +
            "el cual supera el saldo actual de su cuenta. Intente de nuevo");
          vistaRealizarRetiro.txtMonto.setText("");
    }  
  }
  
  /**
   * Metodo que realiza una transferencia
   */
  public void realizarTransferencia() {
    ResultSet rs3;
    String montoValidacion = vistaRealizarTransferencia.txtMonto.getText();    
    if (validaciones.Validaciones.validarMontoSinDecimal(montoValidacion) != true){
      
      JOptionPane.showMessageDialog(vistaRealizarTransferencia, "ERROR: no sido posible validar el monto:"
          + "  " + montoValidacion);
        
    } else {
      int montoRetiro = Integer.parseInt(montoValidacion);
      int montoComision = (int) (montoRetiro * 0.02);
      int numeroCuenta = Integer.parseInt(vistaRealizarTransferencia.cbxCuentas.getSelectedItem()
         .toString());
      
      rs3 = operacionDao.obtenerUltimaOperacion();
      try {
        if (rs3.next()){
          vistaRealizarTransferencia.lblNumOp.setText(rs3.getString(1));
          int numeroOperacion = Integer.parseInt(vistaRealizarTransferencia.lblNumOp.getText());
          int numeroCantidadOperacionesEfectuadas = Integer.parseInt(vistaRealizarTransferencia.
            txtCantidadOperaciones.getText());
            
          if (numeroCantidadOperacionesEfectuadas >= 3) {
            verificarSaldoMayorQueMontoTransferencia();
            operacionDao.cobrarComision(montoComision, numeroCuenta, numeroOperacion);
            JOptionPane.showMessageDialog(vistaRealizarTransferencia, "Estimado usuario, "
                + "la transferencia de fondos se ejecutó satisfactoriamente.\n" +
                "El monto retirado de la cuenta origen y depositado en la cuenta destino es " +
                montoRetiro + " colones.\n [El monto cobrado por concepto de comisión a la cuenta "
                + "origen fue de " + montoComision +" colones, que fueron rebajados automáticamente "
                + "de su saldo actual]");
          } else {
            verificarSaldoMayorQueMontoTransferencia();
            JOptionPane.showMessageDialog(vistaRealizarTransferencia, "Estimado usuario, "
                + "la transferencia de fondos se ejecutó satisfactoriamente.\n" +
                "El monto retirado de la cuenta origen y depositado en la cuenta destino es " +
                montoRetiro + " colones.\n [El monto cobrado por concepto de comisión a la cuenta "
                + "origen fue de 0.00 colones.");
            }  
      
        }
      }    catch (SQLException ex) {
            Logger.getLogger(ControladorOperaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
  }
  
  /**
   * Metodo que calcula el total de ganancias de comisiones para el universo de cuentas
   */
  public void calcularTotalComisiones(){
    rs = operacionDao.consultarGananciasComisionesTotalizado();
    try {
      if (rs.next()) {
        JOptionPane.showMessageDialog(vistaConsultarGananciasComisionesTotalizado, "Estimado "
            + "usuario el monto total de ganancias producto del cobro de comisiones para todas "
            + "las cuentas es de "+ rs.getString(1)+ " colones.");
      }
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null,ex); 
    } 
  }
  
  /**
   * Metodo que calcula el total de ganancias de comisiones para una cuenta en especifico
   */
  public void calcularTotalComisionesCuentaParticular(){
    int numeroCuenta = Integer.parseInt(vistaConsultarGananciasComisionesCuentaParticular.
        cbxCuentas.getSelectedItem().toString());
    rs = operacionDao.obtenerGananciasComisionesTotalesCuentaParticular(numeroCuenta);
    try {
      if (rs.next()) {
        JOptionPane.showMessageDialog(vistaConsultarGananciasComisionesTotalizado, "Estimado "
            + "usuario el monto total de ganancias producto del cobro de comisiones para la cuenta "
            + numeroCuenta+ " es de "+ rs.getString(1)+ " colones.");
      }
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null,ex); 
    } 
  }
}