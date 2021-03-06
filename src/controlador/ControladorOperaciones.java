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
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vista.ConsultarTipoCambio;
import vista.RealizarDepositoDolares;
import vista.RealizarRetiroDolares;
import webservice_banco.TipoCambioDolar;


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
  public RealizarDepositoDolares vistaRealizarDepositoDolares = new RealizarDepositoDolares();
  public RealizarRetiro vistaRealizarRetiro = new RealizarRetiro();
  public RealizarRetiroDolares vistaRealizarRetiroDolares = new RealizarRetiroDolares();
  public RealizarTransferencia vistaRealizarTransferencia = new RealizarTransferencia();
  public ConsultarTipoCambio vistaConsultarTipoCambio = new ConsultarTipoCambio();
  public ConsultarGananciasComisionesTotalizado vistaConsultarGananciasComisionesTotalizado =
      new ConsultarGananciasComisionesTotalizado();
  public ConsultarGananciasComisionesCuentaParticular 
      vistaConsultarGananciasComisionesCuentaParticular = 
      new ConsultarGananciasComisionesCuentaParticular();
  public TipoCambioDolar tipoCambio = new TipoCambioDolar();
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
   * Metodo constructor para la vista de Realizar Deposito en colones
   * @param pVistaRealizarDeposito
   * @param pCuentaDao
   * @param pOperacionesDao 
   */  
  public ControladorOperaciones(RealizarDepositoDolares pVistaRealizarDepositoDolares,
      CuentaDAO pCuentaDao, OperacionesDAO pOperacionesDao) {
    vistaRealizarDepositoDolares = pVistaRealizarDepositoDolares;
    cuentaDao = pCuentaDao;
    operacionDao = pOperacionesDao;
    this.vistaRealizarDepositoDolares.btnBuscarCliente.addActionListener(this);
    this.vistaRealizarDepositoDolares.btnVolver.addActionListener(this);
    this.vistaRealizarDepositoDolares.btnDepositar.addActionListener(this);
    this.vistaRealizarDepositoDolares.txtPropietarioCuenta.setEditable(false);
    this.vistaRealizarDepositoDolares.txtCantidadOperaciones.setEditable(false);
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
  
  public ControladorOperaciones(RealizarRetiroDolares pVistaRealizarRetiroDolares, CuentaDAO pCuentaDao,
      OperacionesDAO pOperacionesDao) {
    vistaRealizarRetiroDolares = pVistaRealizarRetiroDolares;
    cuentaDao = pCuentaDao;
    operacionDao = pOperacionesDao;
    this.vistaRealizarRetiroDolares.btnBuscarCliente.addActionListener(this);
    this.vistaRealizarRetiroDolares.btnVolver.addActionListener(this);
    this.vistaRealizarRetiroDolares.btnRetirar.addActionListener(this);
    this.vistaRealizarRetiroDolares.btnVerificarPIN.addActionListener(this);
    this.vistaRealizarRetiroDolares.btnVerificarPalabraClave.addActionListener(this);
    this.vistaRealizarRetiroDolares.txtPropietarioCuenta.setEditable(false);
    this.vistaRealizarRetiroDolares.txtCantidadOperaciones.setEditable(false);
    this.vistaRealizarRetiroDolares.txtPINNoModificable.setEditable(false);
    this.vistaRealizarRetiroDolares.txtPalabraClaveNoModificable.setEditable(false);
    this.vistaRealizarRetiroDolares.txtNumeroTelefonicoCliente.setEditable(false);
    this.vistaRealizarRetiroDolares.txtSaldoNoModificable.setEditable(false);
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
  
  public ControladorOperaciones(ConsultarTipoCambio pVistaConsultarTipoCambio,
      OperacionesDAO pOperacionesDao){
    vistaConsultarTipoCambio = pVistaConsultarTipoCambio;
    operacionDao = pOperacionesDao;
    this.vistaConsultarTipoCambio.btnConsultarCompra.addActionListener(this);
    this.vistaConsultarTipoCambio.btnConsultarVenta.addActionListener(this);
    this.vistaConsultarTipoCambio.btnVolver.addActionListener(this);
      
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
    if(e.getSource() == vistaRealizarDepositoDolares.btnBuscarCliente) {
      buscarNombreClienteDepositoDolares();
    }
    if(e.getSource() == vistaRealizarDepositoDolares.btnDepositar) {
      realizarDepositoEnDolares();
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
    if(e.getSource() == vistaRealizarRetiroDolares.btnBuscarCliente) {
      buscarNombreClienteRetiroDolares();
    }
     if(e.getSource()== vistaRealizarRetiroDolares.btnVerificarPIN){
      verificarPINRetiroDolares();
    }
    if(e.getSource() == vistaRealizarRetiroDolares.btnVerificarPalabraClave) {
      verificarPalabraClaveRetiroDolares();
    }
    if(e.getSource() == vistaRealizarRetiroDolares.btnRetirar) {
      realizarRetiroDolares();
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
    if(e.getSource() == vistaConsultarTipoCambio.btnConsultarCompra) {
      consultarTipoCambioCompra();
    }
    if(e.getSource() == vistaConsultarTipoCambio.btnConsultarVenta) {
      consultarTipoCambioVenta();
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
    if(e.getSource() == vistaRealizarDepositoDolares.btnVolver) {
      this.vistaRealizarDepositoDolares.setVisible(false);
    }
    if(e.getSource() == vistaRealizarRetiro.btnVolver) {
      this.vistaRealizarRetiro.setVisible(false);
    }
    if(e.getSource() == vistaRealizarRetiroDolares.btnVolver) {
      this.vistaRealizarRetiroDolares.setVisible(false);
    }
    if(e.getSource() == vistaRealizarTransferencia.btnVolver) {
      this.vistaRealizarTransferencia.setVisible(false);
    }
    if(e.getSource() == vistaConsultarTipoCambio.btnVolver) {
      this.vistaConsultarTipoCambio.setVisible(false);
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
   * Metodo que busca el nombre del cliente para realizar un deposito en dolares
  */  
  public void buscarNombreClienteDepositoDolares() {
    int numeroCuenta = Integer.parseInt(vistaRealizarDepositoDolares.cbxCuentas.getSelectedItem().
        toString());
    rs = operacionDao.buscarNombreCliente(numeroCuenta);
    rs2 = operacionDao.verificarSiCobrarComisionDeposito(numeroCuenta);
    try {
      if (rs.next()) {
        vistaRealizarDepositoDolares.txtPropietarioCuenta.setText(rs.getString(1)+ " " + rs.getString(2)+
        " " + rs.getString(3));
      }
      if (rs2.next()){
        vistaRealizarDepositoDolares.txtCantidadOperaciones.setText(rs2.getString(1));
      } else{
        vistaRealizarDepositoDolares.txtCantidadOperaciones.setText("0");
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
   * Metodo que busca el nombre del cliente para realizar un retiro en dolares
  */ 
  public void buscarNombreClienteRetiroDolares() {
    ResultSet rs3;
    ResultSet rs4;
    ResultSet rs5;
    int numeroCuenta = Integer.parseInt(vistaRealizarRetiroDolares.cbxCuentas.getSelectedItem().
        toString());
    rs = operacionDao.buscarNombreCliente(numeroCuenta);
    rs2 = operacionDao.verificarSiCobrarComisionRetiro(numeroCuenta);
    rs3 = cuentaDao.buscarPIN(numeroCuenta);
    rs4 = operacionDao.obtenerNumeroTelefonicoCliente(numeroCuenta);
    rs5 = operacionDao.obtenerSaldoCliente(numeroCuenta);
    try {
      if (rs.next()) {
        vistaRealizarRetiroDolares.txtPropietarioCuenta.setText(rs.getString(1)+ " " + rs.getString(2)+
        " " + rs.getString(3));
      }
      if (rs2.next()){
        vistaRealizarRetiroDolares.txtCantidadOperaciones.setText(rs2.getString(1));
      }
      if (rs3.next()){
        vistaRealizarRetiroDolares.txtPINNoModificable.setText(rs3.getString(1));
      }
      if (rs4.next()){
        vistaRealizarRetiroDolares.txtNumeroTelefonicoCliente.setText(rs4.getString(1));
      }
      if (rs5.next()){
        vistaRealizarRetiroDolares.txtSaldoNoModificable.setText(rs5.getString(1));
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
                "El monto cobrado por concepto de comisi??n fue de "+montoComision+" colones, que " +
          "     fueron rebajados autom??ticamente de su saldo actual");
            } else {
                JOptionPane.showMessageDialog(vistaRealizarDeposito, "Estimado usuario, se han depositado "
          + " correctamente "+ montoDeposito+" colones\n" +
          "El monto real depositado a su cuenta "+numeroCuenta+" es de "+montoDeposito+" colones\n"+
          "El monto cobrado por concepto de comisi??n fue de 0.00 colones");
            }
        }  
      } catch (SQLException ex) {
            Logger.getLogger(ControladorOperaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  }
  
  public void realizarDepositoEnDolares() {
    ResultSet rs3;
    String montoValidacion = vistaRealizarDepositoDolares.txtMonto.getText();
    
    Double tipoDeCambioDolar = Double.parseDouble(tipoCambio.getTipoCambioCompra());
    int tipoDeCambioDolarConvertidoAInt = tipoDeCambioDolar.intValue();
    
    if (validaciones.Validaciones.validarMontoSinDecimal(montoValidacion) != true){
      
      JOptionPane.showMessageDialog(vistaRealizarDepositoDolares, "ERROR: no sido posible validar el monto:"
          + "  " + montoValidacion);
        
    } else {
      int montoDeposito = Integer.parseInt(montoValidacion);
      int montoDepositoEnDolares = montoDeposito*tipoDeCambioDolarConvertidoAInt;
      int montoComision = (int) (montoDepositoEnDolares * 0.02);
      int numeroCuenta = Integer.parseInt(vistaRealizarDepositoDolares.cbxCuentas.getSelectedItem()
         .toString());
      operacionDao.registrarDeposito(montoDepositoEnDolares, numeroCuenta);
      rs3 = operacionDao.obtenerUltimaOperacion();
      try {
        if (rs3.next()){
            vistaRealizarDepositoDolares.lblNumOp.setText(rs3.getString(1));
            int numeroOperacion = Integer.parseInt(vistaRealizarDepositoDolares.lblNumOp.getText());
            int numeroCantidadOperacionesEfectuadas = Integer.parseInt(vistaRealizarDepositoDolares.
               txtCantidadOperaciones.getText());
            if (numeroCantidadOperacionesEfectuadas >= 3) {
              operacionDao.cobrarComision(montoComision, numeroCuenta, numeroOperacion);
              JOptionPane.showMessageDialog(vistaRealizarDepositoDolares, "Seg??n el Banco Central de Costa Rica el Tipo de Cambio de Compra del D??lar es "
                + tipoDeCambioDolar+" para hoy "+ LocalDate.now().toString() + "\n" +
                "El monto real depositado a su cuenta "+numeroCuenta+" es de "+montoDepositoEnDolares+" despu??s de la conversi??n a d??lares a colones\n"+
                "El monto cobrado por concepto de comisi??n fue de "+montoComision+" colones, que " +
          "     fueron rebajados autom??ticamente de su saldo actual");
            } else {
                JOptionPane.showMessageDialog(vistaRealizarDepositoDolares, "Seg??n el Banco Central de Costa Rica el Tipo de Cambio de Compra del D??lar es "
               + tipoDeCambioDolar+" a d??a de hoy\n" +
          "El monto real depositado a su cuenta "+numeroCuenta+" es de "+montoDepositoEnDolares+" despu??s de la conversi??n de d??lares a colones\n"+
          "El monto cobrado por concepto de comisi??n fue de 0.00 colones");
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
                "El monto cobrado por concepto de comisi??n fue de "+ montoComision+" colones, "
                + "que fueron rebajados autom??ticamente de su saldo actual");
          } else {
            verificarSaldoMayorQueMontoRetiro();
            JOptionPane.showMessageDialog(vistaRealizarRetiro, "Estimado usuario, el monto de "
                + "este retiro es de"+ montoRetiro +" colones.\n" +
                "El monto cobrado por concepto de comisi??n fue de 0.00 colones.");
            }  
      
        }
      }    catch (SQLException ex) {
            Logger.getLogger(ControladorOperaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }     
  }
  
  /**
   * Metodo que verifica el PIN de un retiro en dolares
   */
  public void verificarPINRetiroDolares() {
    String PINNoModificable = vistaRealizarRetiroDolares.txtPINNoModificable.getText();
    String PIN = vistaRealizarRetiroDolares.txtPIN.getText();
    String numeroTelefonico = vistaRealizarRetiroDolares.txtNumeroTelefonicoCliente.getText();
     if (PINNoModificable.equals(PIN)){
       JOptionPane.showMessageDialog(vistaRealizarRetiroDolares, "El PIN ingresdo coincide con el PIN "
         + "registrado en la cuenta");
       String palabraClave = util.EnviarSMS.generarPalabra();
       operacionDao.enviarPalabraClave(numeroTelefonico, palabraClave);
       JOptionPane.showMessageDialog(vistaRealizarRetiroDolares, ": Estimado usuario se ha " +
        "enviado una palabra por mensaje de texto, por favor revise sus mensajes y " +
        "proceda a digitar la palabra enviada");
       vistaRealizarRetiroDolares.txtPalabraClaveNoModificable.setText(palabraClave);
     } else{
       JOptionPane.showMessageDialog(vistaRealizarRetiroDolares, "El PIN ingresdo no coincide con el PIN "
         + "registrado en la cuenta. Intente de nuevo.");
       vistaRealizarRetiroDolares.txtPIN.setText("");
     }
  }
  
  /**
   * Metodo que verifica la palabra clave para realizar un retiro en dolares
   */
  public void verificarPalabraClaveRetiroDolares() {
    String palabraClaveNoModificable = vistaRealizarRetiroDolares.txtPalabraClaveNoModificable.getText();
    String palabraClave = vistaRealizarRetiroDolares.txtPalabraClave.getText();
    if (palabraClaveNoModificable.equals(palabraClave)){
      JOptionPane.showMessageDialog(vistaRealizarRetiroDolares, "La palabra clave ingresda coincide con "
          + "la palabra enviada por SMS. Por favor continue con la operacion");
    } else {
      JOptionPane.showMessageDialog(vistaRealizarRetiroDolares, "La palabra clave ingresda no coincide con "
           + "la palabra enviada por SMS. Por favor, intente de nuevo.");
      vistaRealizarRetiroDolares.txtPalabraClave.setText("");
    } 
  }
   /**
   * Metodo que verifica si el saldo de la cuenta es mayor que el monto a retirar para realizar un
   * retiro
   */
  public void verificarSaldoMayorQueMontoRetiroDolares() {
    String montoValidacion = vistaRealizarRetiroDolares.txtMonto.getText();
    String saldoCuenta = vistaRealizarRetiroDolares.txtSaldoNoModificable.getText();
    double saldoCuentaNumero = Double.parseDouble(saldoCuenta);
    int montoRetiro = Integer.parseInt(montoValidacion);
    int numeroCuenta = Integer.parseInt(vistaRealizarRetiroDolares.cbxCuentas.getSelectedItem()
         .toString());
    if (montoRetiro <= saldoCuentaNumero){
        operacionDao.registrarRetiro(montoRetiro, numeroCuenta);  
      } else {
          JOptionPane.showMessageDialog(vistaRealizarRetiroDolares, "Estimado usuario, el monto de "
            + "este retiro es de"+ montoRetiro +" colones \n" +
            "el cual supera el saldo actual de su cuenta. Intente de nuevo");
          vistaRealizarRetiroDolares.txtMonto.setText("");
        }
  }
   /**
   * Metodo que realiza un retiro en dolares 
   */
  public void realizarRetiroDolares(){
    ResultSet rs3;
    Double tipoDeCambioDolar = Double.parseDouble(tipoCambio.getTipoCambioVenta());
    int tipoDeCambioDolarConvertidoAInt = tipoDeCambioDolar.intValue();
    String montoValidacion = vistaRealizarRetiroDolares.txtMonto.getText();    
    if (validaciones.Validaciones.validarMontoSinDecimal(montoValidacion) != true){
      
      JOptionPane.showMessageDialog(vistaRealizarRetiroDolares, "ERROR: no sido posible validar el monto:"
          + "  " + montoValidacion);
        
    } else {
      int montoRetiro = Integer.parseInt(montoValidacion);
      int montoRetiroEnDolares = montoRetiro*tipoDeCambioDolarConvertidoAInt;
      int montoComision = (int) (montoRetiroEnDolares * 0.02);
      int numeroCuenta = Integer.parseInt(vistaRealizarRetiroDolares.cbxCuentas.getSelectedItem()
         .toString());
      
      rs3 = operacionDao.obtenerUltimaOperacion();
      try {
        if (rs3.next()){
          vistaRealizarRetiroDolares.lblNumOp.setText(rs3.getString(1));
          int numeroOperacion = Integer.parseInt(vistaRealizarRetiroDolares.lblNumOp.getText());
          int numeroCantidadOperacionesEfectuadas = Integer.parseInt(vistaRealizarRetiroDolares.
            txtCantidadOperaciones.getText());
            
          if (numeroCantidadOperacionesEfectuadas >= 3) {
            verificarSaldoMayorQueMontoRetiroDolares();
            operacionDao.cobrarComision(montoComision, numeroCuenta, numeroOperacion);
            JOptionPane.showMessageDialog(vistaRealizarRetiroDolares, "Estimado usuario, el monto de "
                + "este retiro es de "+ montoRetiroEnDolares +" colones.\n" +
                "El monto cobrado por concepto de comisi??n fue de "+ montoComision+" colones, "
                + "que fueron rebajados autom??ticamente de su saldo actual");
          } else {
            verificarSaldoMayorQueMontoRetiroDolares();
            JOptionPane.showMessageDialog(vistaRealizarRetiroDolares, "Estimado usuario, el monto de "
                + "este retiro es de"+ montoRetiroEnDolares +" colones.\n" +
                "El monto cobrado por concepto de comisi??n fue de 0.00 colones.");
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
                + "la transferencia de fondos se ejecut?? satisfactoriamente.\n" +
                "El monto retirado de la cuenta origen y depositado en la cuenta destino es " +
                montoRetiro + " colones.\n [El monto cobrado por concepto de comisi??n a la cuenta "
                + "origen fue de " + montoComision +" colones, que fueron rebajados autom??ticamente "
                + "de su saldo actual]");
          } else {
            verificarSaldoMayorQueMontoTransferencia();
            JOptionPane.showMessageDialog(vistaRealizarTransferencia, "Estimado usuario, "
                + "la transferencia de fondos se ejecut?? satisfactoriamente.\n" +
                "El monto retirado de la cuenta origen y depositado en la cuenta destino es " +
                montoRetiro + " colones.\n [El monto cobrado por concepto de comisi??n a la cuenta "
                + "origen fue de 0.00 colones.");
            }  
      
        }
      }    catch (SQLException ex) {
            Logger.getLogger(ControladorOperaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
  }
  
  public void consultarTipoCambioCompra(){
    Double tipoDeCambioDolar = Double.parseDouble(tipoCambio.getTipoCambioCompra());
    int tipoDeCambioDolarConvertidoAInt = tipoDeCambioDolar.intValue();
    JOptionPane.showMessageDialog(vistaConsultarTipoCambio, "El tipo de cambio del dolar en la compra"
            + " a la fecha : " +LocalDate.now().toString()+" \nes de: " 
            +tipoDeCambioDolarConvertidoAInt +" colones.");
  }
  
  public void consultarTipoCambioVenta(){
    Double tipoDeCambioDolar = Double.parseDouble(tipoCambio.getTipoCambioVenta());
    int tipoDeCambioDolarConvertidoAInt = tipoDeCambioDolar.intValue();
    JOptionPane.showMessageDialog(vistaConsultarTipoCambio, "El tipo de cambio del dolar en la venta"
            + " a la fecha : " +LocalDate.now().toString()+" \nes de: " 
            +tipoDeCambioDolarConvertidoAInt +" colones");
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