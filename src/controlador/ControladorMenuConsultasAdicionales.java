package controlador;

import dao.ClienteDAO;
import dao.CuentaDAO;
import dao.OperacionesDAO;

import vista.MenuConsultasAdicionales;
import vista.ConsultarClientesOrdenados;
import vista.ConsultarInformacionClienteCuentas;
import vista.ConsultaEstadoCuenta;
import vista.ConsultarCuentasOrdenadas;
import vista.ConsultarEstatusCuenta;
import vista.ConsultarGananciasComisionesCuentaParticular;
import vista.ConsultarGananciasComisionesTotalizado;
import vista.ConsultarInformacionCuentas;
import vista.ConsultarSaldoCuenta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Abstraccion de la clase ControladorMenuConsultasAdicionales
 * Clase que utiliza las funcionalidades de la vista del menu de consultas adicionales
 * @author Daniel Vaglio Fallas y Jafet Chavarria Moreno
 * @version Proyecto Programado I
 */
public class ControladorMenuConsultasAdicionales implements ActionListener {
  public MenuConsultasAdicionales vistaConsultasAdicionales;
  
  /**
   * Metodo Constructor
   * @param pVista despliega la vista del menu de consultas adicionales
   */
  public ControladorMenuConsultasAdicionales(MenuConsultasAdicionales pVista) {
    vistaConsultasAdicionales = pVista;

    this.vistaConsultasAdicionales.btnConsultarClientesOrdenados.addActionListener(this);
    this.vistaConsultasAdicionales.btnConsultarInformacionCliente.addActionListener(this);
    this.vistaConsultasAdicionales.btnConsultarCuentasOrdenadas.addActionListener(this);
    this.vistaConsultasAdicionales.btnConsultarInformacionCuentaParticular.addActionListener(this);
    this.vistaConsultasAdicionales.btnConsultarSaldoActual.addActionListener(this); 
    this.vistaConsultasAdicionales.btnConsultarEstadoCuenta.addActionListener(this); 
    this.vistaConsultasAdicionales.btnConsultarEstatusCuenta.addActionListener(this);
    this.vistaConsultasAdicionales.btnConsultarGananciasComisionesTotalizado.
        addActionListener(this);
    this.vistaConsultasAdicionales.btnConsultarGananciasComisionesCuentaEspecifico.
        addActionListener(this);
    this.vistaConsultasAdicionales.btnVolver.addActionListener(this);
  }
  
  /**
   * Metodo para accionar y ejecutar los botones de la vista
   * @param e recibe la accion del boton
   */  
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == vistaConsultasAdicionales.btnConsultarClientesOrdenados) {
      consultarClientesOrdenados();
    }
    if (e.getSource() == vistaConsultasAdicionales.btnConsultarInformacionCliente) {
      consultarInformacionClienteParticular();
    }
    if (e.getSource() == vistaConsultasAdicionales.btnConsultarCuentasOrdenadas) {
      consultarCuentasOrdenadas();
    }
    if (e.getSource() == vistaConsultasAdicionales.btnConsultarInformacionCuentaParticular) {
      consultarInformacionCuentaParticular();
    }
    if (e.getSource() == vistaConsultasAdicionales.btnConsultarSaldoActual) {
      consultarSaldoActualCuenta();
    }
    if (e.getSource() == vistaConsultasAdicionales.btnConsultarEstadoCuenta) {
      consultarEstadoCuenta();
    }
    if (e.getSource() == vistaConsultasAdicionales.btnConsultarEstatusCuenta) {
      consultarEstatusCuenta();
    }
    if (e.getSource() == vistaConsultasAdicionales.btnConsultarGananciasComisionesTotalizado){
      consultarGananciasComisionesTotalizado();
    }
    if(e.getSource() == vistaConsultasAdicionales.btnConsultarGananciasComisionesCuentaEspecifico) {
      consultarGananciasComisionesCuentaParticular();
    }
    if (e.getSource() == vistaConsultasAdicionales.btnVolver) {
      this.vistaConsultasAdicionales.setVisible(false);
    } 
  }
  
  /**
   * Metodo consultarClientesOrdenados() para mostrar los clientes ordenados ascendentemente en 
   * funcion del primer apellido
   */
  public void consultarClientesOrdenados() {
    ConsultarClientesOrdenados consulta = new ConsultarClientesOrdenados();
    ClienteDAO clienteDao = new ClienteDAO();
    ControladorCliente controlador = new ControladorCliente(consulta,clienteDao);
    controlador.vistaConsultarClientesOrdenados.setVisible(true);
    ResultSet rs;
    JTable tabla;
    DefaultTableModel dfm = new DefaultTableModel();
    rs = clienteDao.consultarClientesOrdenados();
    tabla = consulta.tablaClientesOrdenados;
    tabla.setModel(dfm);
    dfm.setColumnIdentifiers(new Object[]{"Primer Apellido","Segundo Apellido", "Nombre", 
        "Identificacion"});
    try {
      while (rs.next()) {
        dfm.addRow(new Object[] {rs.getString("PrimerApellido"), rs.getString("SegundoApellido"),
            rs.getString("Nombre"), rs.getString("Identificacion")});
      }    
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null,ex); 
    }
  }
  
  /**
   * Metodo que abre la vista de consultar informacion de un cliente en particular
   */
  public void consultarInformacionClienteParticular(){
    ConsultarInformacionClienteCuentas consulta = new ConsultarInformacionClienteCuentas();
    ClienteDAO clienteDao = new ClienteDAO();
    ControladorCliente controlador = new ControladorCliente(consulta, clienteDao);
    controlador.vistaConsultarInformacionClienteCuentas.setVisible(true);
  }
 
  /**
   * Metodo consultarCuentasOrdenadas() para mostrar las cuentas ordenadas descendentemente en 
   * funcion del saldo
   */
  public void consultarCuentasOrdenadas() {
    ConsultarCuentasOrdenadas consulta = new ConsultarCuentasOrdenadas();
    CuentaDAO cuentaDao = new CuentaDAO();
    ControladorCuenta controlador = new ControladorCuenta(consulta,cuentaDao);
    controlador.vistaConsultarCuentasOrdenadas.setVisible(true);
    ResultSet rs;
    JTable tabla;
    DefaultTableModel dfm = new DefaultTableModel();
    rs = cuentaDao.consultarCuentasOrdenadas();
    tabla = consulta.tablaCuentasOrdenadas;
    tabla.setModel(dfm);
    dfm.setColumnIdentifiers(new Object[]{"Numero Cuenta", "Estado","Saldo","Identificacion",
        "Primer Apellido", "Segundo Apellido","Nombre"});
    try {
      while (rs.next()) {
        dfm.addRow(new Object[] {rs.getString("Numero_Cuenta"),rs.getString("Estado"),
            rs.getDouble("Saldo"), rs.getString("Identificacion"),rs.getString("PrimerApellido"), 
            rs.getString("SegundoApellido"), rs.getString("Nombre")});
      }    
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null,ex); 
    }
  }
  
  /**
   * Metodo que abre la vista de consultar informacion de una cuenta en particular
   */
  public void consultarInformacionCuentaParticular(){
    ConsultarInformacionCuentas consulta = new ConsultarInformacionCuentas();
    CuentaDAO cuentaDao = new CuentaDAO();
    ControladorCuenta controlador = new ControladorCuenta(consulta, cuentaDao);
    controlador.vistaConsultarInformacionCuentas.setVisible(true);
  }
  
  /**
   * Metodo que abre la vista de consultar saldo actual de una cuenta
   */
  public void consultarSaldoActualCuenta(){
    ConsultarSaldoCuenta consulta = new ConsultarSaldoCuenta();
    CuentaDAO cuentaDao = new CuentaDAO();
    OperacionesDAO operacionDao = new OperacionesDAO();
    ControladorCuenta controlador = new ControladorCuenta(consulta, cuentaDao, operacionDao);
    controlador.vistaConsultarSaldoCuenta.setVisible(true);
  }
  
  /**
   * Metodo que abre la vista de consultar estado actual de una cuenta
   */
  public void consultarEstadoCuenta(){
    ConsultaEstadoCuenta consulta = new ConsultaEstadoCuenta();
    CuentaDAO cuentaDao = new CuentaDAO();
    OperacionesDAO operacionDao = new OperacionesDAO();
    ControladorCuenta controlador = new ControladorCuenta(consulta, cuentaDao, operacionDao);
    controlador.vistaConsultaEstadoCuenta.setVisible(true);
  }
  
  /**
   * Metodo que abre la vista de consultar estatus actual de una cuenta
   */
  public void consultarEstatusCuenta(){
    ConsultarEstatusCuenta consulta = new ConsultarEstatusCuenta();
    CuentaDAO cuentaDao = new CuentaDAO();
    OperacionesDAO operacionDao = new OperacionesDAO();
    ControladorCuenta controlador = new ControladorCuenta(consulta, cuentaDao, operacionDao);
    controlador.vistaConsultarEstatusCuenta.setVisible(true);
  }
  
  /**
   * Metodo que muestra las comisiones cobradas para todo el universo de cuentas
   */
  public void consultarGananciasComisionesTotalizado(){
    ConsultarGananciasComisionesTotalizado consulta = new ConsultarGananciasComisionesTotalizado();
    OperacionesDAO operacionDao = new OperacionesDAO();
    ControladorOperaciones controlador = new ControladorOperaciones(consulta,operacionDao);
    controlador.vistaConsultarGananciasComisionesTotalizado.setVisible(true);
    ResultSet rs;
    JTable tabla;
    DefaultTableModel dfm = new DefaultTableModel();
    rs = operacionDao.obtenerComisionesTotalesCuentas();
    tabla = consulta.tablaComisiones;
    tabla.setModel(dfm);
    dfm.setColumnIdentifiers(new Object[]{"Monto Comision", "Numero de cuenta",
        "Numero de Operacion"});
    try {
      while (rs.next()) {
        dfm.addRow(new Object[] {rs.getString("MontoComision"),rs.getString("NumeroCuenta_Comision"),
            rs.getString("NumeroOperacion_Comision")});
      }    
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null,ex); 
    }
  }
  
  /**
   * Metodo que abre la vista de consultar las ganancias por comisiones de una cuenta en particular
   */
  public void consultarGananciasComisionesCuentaParticular(){
    ConsultarGananciasComisionesCuentaParticular consulta = 
            new ConsultarGananciasComisionesCuentaParticular();
    OperacionesDAO operacionDao = new OperacionesDAO();
    ControladorOperaciones controlador = new ControladorOperaciones(consulta,operacionDao);
    controlador.vistaConsultarGananciasComisionesCuentaParticular.setVisible(true);
  }
}
