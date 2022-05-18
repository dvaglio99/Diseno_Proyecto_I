package controlador;

import conexion.Conexion;
import dao.CuentaDAO;
import dao.OperacionesDAO;
import java.awt.HeadlessException;
import logicadenegocios.Cuenta;

import vista.CambiarPIN;
import vista.ConsultaEstadoCuenta;
import vista.ConsultarCuentasOrdenadas;
import vista.ConsultarEstatusCuenta;
import vista.ConsultarInformacionCuentas;
import vista.ConsultarSaldoCuenta;
import vista.RegistrarCuenta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 * Abstraccion de la clase ControladorCuenta
 * Clase que controla las funciones de la cuenta en la interfaz grafica de usuario
 * @author Daniel Vaglio Fallas y Jafet Chavarria Moreno
 * @version Proyecto Programado I
 */
public class ControladorCuenta implements ActionListener {
  Conexion conexion;
  public ResultSet rs;
  public ResultSet rs2;
  public PreparedStatement ps;
  public JTable tabla;
  public RegistrarCuenta vistaRegistrarCuenta = new RegistrarCuenta();
  public ConsultarCuentasOrdenadas vistaConsultarCuentasOrdenadas = new ConsultarCuentasOrdenadas();
  public ConsultarInformacionCuentas vistaConsultarInformacionCuentas = 
    new ConsultarInformacionCuentas();
  public ConsultarSaldoCuenta vistaConsultarSaldoCuenta = new ConsultarSaldoCuenta();
  public ConsultaEstadoCuenta vistaConsultaEstadoCuenta = new ConsultaEstadoCuenta();
  public ConsultarEstatusCuenta vistaConsultarEstatusCuenta = new ConsultarEstatusCuenta();
  public CambiarPIN vistaCambiarPIN = new CambiarPIN();
  public Cuenta cuenta;
  public CuentaDAO cuentaDao;
  public OperacionesDAO operacionDao;
  
  /**
   * Metodo constructor para la vista de mostrar las cuentas ordenadas descendentemente
   * @param pVistaConsultarCuentasOrdenadas
   * @param pModelo 
   */
  public ControladorCuenta(ConsultarCuentasOrdenadas pVistaConsultarCuentasOrdenadas, 
      CuentaDAO pModelo) {
    vistaConsultarCuentasOrdenadas = pVistaConsultarCuentasOrdenadas;
    cuentaDao = pModelo;

    this.vistaConsultarCuentasOrdenadas.btnVolver.addActionListener(this);
  }
  
  /**
   * Metodo Constructor para la vista de registro de una cuenta
   * @param pVistaRegistroCuenta
   * @param pCuenta 
   */
  public ControladorCuenta(RegistrarCuenta pVistaRegistroCuenta, Cuenta pCuenta) {

    vistaRegistrarCuenta = pVistaRegistroCuenta;
    cuenta = pCuenta;
    cuentaDao = new CuentaDAO();

    this.vistaRegistrarCuenta.btnRegistrarCuenta.addActionListener(this);
    this.vistaRegistrarCuenta.btnVolver.addActionListener(this);
    this.vistaRegistrarCuenta.btnLimpiarCampos.addActionListener(this);

  }
  
  /**
   * Metodo constructor para la vista de consulta de informacion de cuentas
   * @param pVistaConsultarInformacionCuentas
   * @param pModelo 
   */
  public ControladorCuenta(ConsultarInformacionCuentas pVistaConsultarInformacionCuentas, 
          CuentaDAO pModelo) {
    vistaConsultarInformacionCuentas = pVistaConsultarInformacionCuentas;
    cuentaDao = pModelo;

    this.vistaConsultarInformacionCuentas.btnBuscar.addActionListener(this);
    this.vistaConsultarInformacionCuentas.btnVolver.addActionListener(this);
  }
  
  /**
   * Metodo Constructor para la vista de cambiar PIN de una cuenta
   * @param pVistaCambiarPIN
   * @param pModelo 
   */
  public ControladorCuenta(CambiarPIN pVistaCambiarPIN, CuentaDAO pModelo) {
    vistaCambiarPIN = pVistaCambiarPIN;
    cuentaDao = pModelo;

    this.vistaCambiarPIN.btnBuscarPIN.addActionListener(this);
    this.vistaCambiarPIN.btnCambiarPIN.addActionListener(this);
    this.vistaCambiarPIN.btnVolver.addActionListener(this);
    this.vistaCambiarPIN.txtPINNoModificable.setEditable(false);
  }
  
  /**
   * Metodo constructor para la vista de consulta del saldo de una cuenta
   * @param pVistaConsultarSaldoCuenta
   * @param pCuentaDao
   * @param pOperacionDao 
   */
  public ControladorCuenta(ConsultarSaldoCuenta pVistaConsultarSaldoCuenta, CuentaDAO pCuentaDao,
      OperacionesDAO pOperacionDao){
    vistaConsultarSaldoCuenta = pVistaConsultarSaldoCuenta;
    cuentaDao = pCuentaDao;
    operacionDao= pOperacionDao;
    this.vistaConsultarSaldoCuenta.btnBuscar.addActionListener(this);
    this.vistaConsultarSaldoCuenta.btnBuscarSaldo.addActionListener(this);
    this.vistaConsultarSaldoCuenta.btnVolver.addActionListener(this);
    this.vistaConsultarSaldoCuenta.txtPropietarioCuenta.setEditable(false);
    this.vistaConsultarSaldoCuenta.txtPINNoModificable.setEditable(false);
  }
  
  /**
   * Metodo constructor para la vista de consulta del estado de una cuenta
   * @param pVistaConsultaEstadoCuenta
   * @param pCuentaDao
   * @param pOperacionDao 
   */
  public ControladorCuenta(ConsultaEstadoCuenta pVistaConsultaEstadoCuenta, CuentaDAO pCuentaDao,
      OperacionesDAO pOperacionDao){
    vistaConsultaEstadoCuenta = pVistaConsultaEstadoCuenta;
    cuentaDao = pCuentaDao;
    operacionDao= pOperacionDao;
    this.vistaConsultaEstadoCuenta.btnBuscar.addActionListener(this);
    this.vistaConsultaEstadoCuenta.btnBuscarEstadoCuenta.addActionListener(this);
    this.vistaConsultaEstadoCuenta.btnVolver.addActionListener(this);
    this.vistaConsultaEstadoCuenta.txtPropietarioCuenta.setEditable(false);
    this.vistaConsultaEstadoCuenta.txtPINNoModificable.setEditable(false);
  }
  
  /**
   * Metodo constructor para la vista de consulta del estatus de una cuenta
   * @param pVistaConsultarEstatusCuenta
   * @param pCuentaDao
   * @param pOperacionDao 
   */
  public ControladorCuenta(ConsultarEstatusCuenta pVistaConsultarEstatusCuenta, CuentaDAO pCuentaDao,
      OperacionesDAO pOperacionDao){
    vistaConsultarEstatusCuenta = pVistaConsultarEstatusCuenta;
    cuentaDao = pCuentaDao;
    operacionDao= pOperacionDao;
    
    this.vistaConsultarEstatusCuenta.btnBuscar.addActionListener(this);
    this.vistaConsultarEstatusCuenta.btnBuscarEstatus.addActionListener(this);
    this.vistaConsultarEstatusCuenta.btnVolver.addActionListener(this);
    this.vistaConsultarEstatusCuenta.txtPropietarioCuenta.setEditable(false);
   }
  
  /**
   * Metodo que le da accion a los botones de las vistas
   * @param e 
   */
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
    if(e.getSource() == vistaConsultarSaldoCuenta.btnBuscar) {
        buscarNombreClienteConsultaSaldo();
    }
    if(e.getSource() == vistaConsultarSaldoCuenta.btnBuscarSaldo) {
        consultarSaldoCuenta();
    }
    if(e.getSource() == vistaConsultaEstadoCuenta.btnBuscar) {
        buscarNombreClienteConsultaEstado();
    }
    if(e.getSource() == vistaConsultaEstadoCuenta.btnBuscarEstadoCuenta) {
        consultarEstadoCuenta();
    }
    if(e.getSource() == vistaConsultarEstatusCuenta.btnBuscar) {
        buscarNombreClienteConsultaEstatus();
    }
    if(e.getSource() == vistaConsultarEstatusCuenta.btnBuscarEstatus) {
        buscarEstatusCuenta();
    }
    if (e.getSource() == vistaCambiarPIN.btnVolver) {
        this.vistaCambiarPIN.setVisible(false);
    }
    if (e.getSource() == vistaRegistrarCuenta.btnVolver) {
        this.vistaRegistrarCuenta.setVisible(false);
    }
    if (e.getSource() == vistaConsultarSaldoCuenta.btnVolver) {
        this.vistaConsultarSaldoCuenta.setVisible(false);
    }
    if (e.getSource() == vistaConsultaEstadoCuenta.btnVolver) {
        this.vistaConsultaEstadoCuenta.setVisible(false);
    }
    if (e.getSource() == vistaConsultarEstatusCuenta.btnVolver) {
        this.vistaConsultarEstatusCuenta.setVisible(false);
    }
    if (e.getSource() == vistaRegistrarCuenta.btnLimpiarCampos) {
        limpiarCampos();
    }
    
  }
  
  /**
   * Metodo consultarInformacionCuentaParticular() Para mostrar la informacion de una cuenta 
   * en particular
   */
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
        dfm.addRow(new Object[] {encriptacion.Encriptado.codificarNumeros(rs.getString("Numero_Cuenta")), 
           encriptacion.Encriptado.codificar(rs.getString("PIN")),rs.getString("ID_Duenio_Cuenta"),
           rs.getString("FechaCreacion"), encriptacion.Encriptado.codificarNumeros(rs.getString("Saldo")),
           rs.getString("Estado"),rs.getString("PrimerApellido"), rs.getString("SegundoApellido"),
           rs.getString("Nombre")});
      }    
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null,ex); 
    }
  }    
  
  /**
   * Metodo buscarPIN() busca el PIN de una cuenta para validarlo mas adelante
   */
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
  
  /**
   * Metodo cambiarPIN() cambia el PIN de una cuenta
   */
  public void cambiarPIN() {
  int numeroCuenta = Integer.parseInt(vistaCambiarPIN.cbxCuentas.getSelectedItem().toString());  
  String PINNoModificable = vistaCambiarPIN.txtPINNoModificable.getText();
  String PIN = vistaCambiarPIN.txtPIN.getText();
  String nuevoPIN = vistaCambiarPIN.txtNuevoPIN.getText();
  String nuevoNuevoPIN = vistaCambiarPIN.txtNuevoNuevoPIN.getText();
  if (PINNoModificable.equals(PIN) && nuevoPIN.equals(nuevoNuevoPIN) && 
      validaciones.Validaciones.validarPIN(nuevoPIN)) {
    try {
      cuentaDao.cambiarPIN(nuevoPIN, numeroCuenta);
      JOptionPane.showMessageDialog(vistaCambiarPIN, "Ha sido posible cambiar el "
            + "PIN de la cuenta numero:  " + numeroCuenta);      
    } catch (HeadlessException e) {
      }
    } else {
      JOptionPane.showMessageDialog(vistaCambiarPIN, "ERROR: fallo en el ingreso de datos.  "
            + " No ha sido posible cambiar PIN de la cuenta numero:  " + 
              numeroCuenta + ". Por favor intente de nuevo."); 
    }
  }
  
  /**
   * Metodo registrarCuenta() registra una cuenta y la asigna a un cliente existente
   */
  public void registrarCuenta() {
    String pPIN = vistaRegistrarCuenta.txtPIN.getText();
    int pIDCliente = Integer.parseInt(vistaRegistrarCuenta.cbxCliente.getSelectedItem().toString());
    String pFechaCreacion = vistaRegistrarCuenta.txtFechaCreacion.getText();
    int pSaldo = Integer.parseInt(vistaRegistrarCuenta.txtSaldoCuenta.getText());
    String pEstado = vistaRegistrarCuenta.cbxEstadoCuenta.getSelectedItem().toString();
    if (validaciones.Validaciones.validarPIN(pPIN) && 
        validaciones.Validaciones.obtenerFechaFormateada(pFechaCreacion) == true) {
      try {
        cuentaDao.registrarCuentaAUnCliente(pPIN, pIDCliente, pFechaCreacion, pSaldo, pEstado);
        rs = cuentaDao.consultarDatosDuenioCuenta(pIDCliente);
        if (rs.next()){
          JOptionPane.showMessageDialog(vistaCambiarPIN, "Se ha creado una nueva cuenta en el "
              + "sistema, los datos de la cuenta son: \n\n"
              + "Estatus de la cuenta: " + pEstado + "\nSaldo actual: " + pSaldo
              + "\n --- " + "\nNombre del dueño de la cuenta: " + rs.getString(1) + " " 
              + rs.getString(2) + " " + rs.getString(3) + "\nNumero de telefono asociado a la "
              + "cuenta: " + rs.getString(4) + "\nDireccion de correo electronico asociado a la "
              + "cuenta: " + rs.getString(5));
        }        

        } catch (HeadlessException | IOException | SQLException e) {
        }

    } else {
      JOptionPane.showMessageDialog(vistaRegistrarCuenta, "ERROR: fallo en el ingreso de datos.  "
            + " No ha sido posible registrar la cuenta al Cliente con el ID  " + 
              pIDCliente+ ". Por favor intente de nuevo."); 
    }
  }
  
  /**
   * Metodo buscarNombreClienteConsultaSaldo() Busca el nombre del cliente para la vista de
   * consultar Saldo de una cuenta
   */
  public void buscarNombreClienteConsultaSaldo() {
    int numeroCuenta = Integer.parseInt(vistaConsultarSaldoCuenta.cbxCuentas.getSelectedItem().
        toString());
    rs = operacionDao.buscarNombreCliente(numeroCuenta);
    rs2 = cuentaDao.buscarPIN(numeroCuenta);
    try {
      if (rs.next()) {
        vistaConsultarSaldoCuenta.txtPropietarioCuenta.setText(rs.getString(1)+ " " + rs.getString(2)+
        " " + rs.getString(3));
      }
      if (rs2.next()){
        vistaConsultarSaldoCuenta.txtPINNoModificable.setText(rs2.getString(1));
      }
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null,ex); 
    }
  }
  
  /**
   * Metodo consultarSaldoCuenta() consulta el saldo actual de una cuenta
   */
  public void consultarSaldoCuenta(){
    int numeroCuenta = Integer.parseInt(vistaConsultarSaldoCuenta.cbxCuentas.getSelectedItem().
        toString());
    String PINNoModificable = vistaConsultarSaldoCuenta.txtPINNoModificable.getText();
    String PIN = vistaConsultarSaldoCuenta.txtPIN.getText();
    if (PINNoModificable.equals(PIN)){
      rs = operacionDao.obtenerSaldoCliente(numeroCuenta);
      try {
        if (rs.next()) {
          JOptionPane.showMessageDialog(vistaConsultarSaldoCuenta, "Estimado usuario el saldo actual "
             + "de su cuenta es "+ rs.getString(1)+ " colones.");
        }
      } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,ex); 
      }  
    } else {
        JOptionPane.showMessageDialog(vistaConsultarSaldoCuenta, "El PIN ingresdo no coincide con "
            + "el PIN registrado en la cuenta. Intente de nuevo.");
       vistaConsultarSaldoCuenta.txtPIN.setText("");
    }
    
  }
  
  /**
   * Metodo buscarNombreClienteConsultaEstado() Busca el nombre del cliente para la vista de
   * consultar Estado de una cuenta
   */
  public void buscarNombreClienteConsultaEstado() {
    int numeroCuenta = Integer.parseInt(vistaConsultaEstadoCuenta.cbxCuentas.getSelectedItem().
        toString());
    rs = operacionDao.buscarNombreCliente(numeroCuenta);
    rs2 = cuentaDao.buscarPIN(numeroCuenta);
    try {
      if (rs.next()) {
        vistaConsultaEstadoCuenta.txtPropietarioCuenta.setText(rs.getString(1)+ " " + rs.getString(2)+
        " " + rs.getString(3));
      }
      if (rs2.next()){
        vistaConsultaEstadoCuenta.txtPINNoModificable.setText(rs2.getString(1));
      }
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null,ex); 
    }
  }
  
  /**
   * Metodo consultarEstadoCuenta() consulta el estado actual de una cuenta
   */
  public void consultarEstadoCuenta(){
    int numeroCuenta = Integer.parseInt(vistaConsultaEstadoCuenta.cbxCuentas.getSelectedItem().
        toString());
    String PINNoModificable = vistaConsultaEstadoCuenta.txtPINNoModificable.getText();
    String PIN = vistaConsultaEstadoCuenta.txtPIN.getText();
    if (PINNoModificable.equals(PIN)){
      rs = cuentaDao.consultarEstadoCuenta(numeroCuenta);
      DefaultTableModel dfm = new DefaultTableModel();
      tabla = vistaConsultaEstadoCuenta.tablaEstadoCuenta;
      tabla.setModel(dfm);
      dfm.setColumnIdentifiers(new Object[]{"Numero Cuenta","Primer Apellido", "Segundo Apellido", 
        "Nombre","Fecha Creacion","Saldo","Estado"});
    try {
      while (rs.next()) {
        dfm.addRow(new Object[] {encriptacion.Encriptado.
        codificarNumeros(rs.getString("Numero_Cuenta")),rs.getString("PrimerApellido"), 
        rs.getString("SegundoApellido"), rs.getString("Nombre"),rs.getString("FechaCreacion"), 
        encriptacion.Encriptado.codificarNumeros(rs.getString("Saldo")), rs.getString("Estado")});
      }    
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null,ex); 
    }
    }else {
        JOptionPane.showMessageDialog(vistaConsultaEstadoCuenta, "El PIN ingresdo no coincide con "
            + "el PIN registrado en la cuenta. Intente de nuevo.");
       vistaConsultaEstadoCuenta.txtPIN.setText("");
    }
  }
  
  /**
   * Metodo buscarNombreClienteConsultaEstatus() Busca el nombre del cliente para la vista de
   * consultar Estatus de una cuenta
   */
  public void buscarNombreClienteConsultaEstatus() {
    int numeroCuenta = Integer.parseInt(vistaConsultarEstatusCuenta.cbxCuentas.getSelectedItem().
        toString());
    rs = operacionDao.buscarNombreCliente(numeroCuenta);
    try {
      if (rs.next()) {
        vistaConsultarEstatusCuenta.txtPropietarioCuenta.setText(rs.getString(1)+ " " + rs.getString(2)+
        " " + rs.getString(3));
      }
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null,ex); 
    }
  }
  
  /**
   * Metodo buscarEstatusCuenta() consulta el estatus actual de una cuenta
   */
  public void buscarEstatusCuenta(){
    int numeroCuenta = Integer.parseInt(vistaConsultarEstatusCuenta.cbxCuentas.getSelectedItem().
        toString());
    rs = cuentaDao.consultarEstatusCuenta(numeroCuenta);
      try {
        if (rs.next()) {
          JOptionPane.showMessageDialog(vistaConsultarEstatusCuenta, "Estimado usuario la cuenta "
              + "numero "+numeroCuenta+" tiene estatus de "+ rs.getString(1));
        }
      } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,ex); 
      }
  }
  
  /**
   * Metodo que limpia los campos de texto del registro de la cuenta
   */
  public void limpiarCampos(){
    vistaRegistrarCuenta.txtPIN.setText("");
    vistaRegistrarCuenta.txtFechaCreacion.setText("");
    vistaRegistrarCuenta.txtSaldoCuenta.setText("");
  }
}
