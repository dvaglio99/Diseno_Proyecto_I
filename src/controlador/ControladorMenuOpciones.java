package controlador;

import logicadenegocios.Cliente;
import logicadenegocios.Cuenta;
import dao.CuentaDAO;

import vista.CambiarPIN;
import vista.MenuConsultasAdicionales;
import vista.MenuModificaciones;
import vista.MenuOpciones;
import vista.RegistrarCliente;
import vista.RegistrarCuenta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Abstraccion de la clase ControladorMenuOpciones
 * Utiliza las funcionalidades del menu de Opciones
 * @author Daniel Vaglio Fallas y Jafet Chavarria Moreno
 * @version Proyecto Programado I
 */
public class ControladorMenuOpciones implements ActionListener{
  public MenuOpciones vista;
  
  /**
   * Metodo Constructor
   * @param pVista la vista del menu de opciones que se despliega en la interfaz
   */
  public ControladorMenuOpciones(MenuOpciones pVista) {
    vista = pVista;
    
    this.vista.btnRegistrarCliente.addActionListener(this);
    this.vista.btnRegistrarCuenta.addActionListener(this);
    this.vista.btnConsultasAdicionales.addActionListener(this);
    this.vista.btnCambiarPIN.addActionListener(this);
    this.vista.btnOperaciones.addActionListener(this);
    this.vista.btnSalir.addActionListener(this);
  }
  
  /**
   * Metodo que ejecuta las diferentes opciones del menu de modificaciones
   * @param e recibe la accion del boton
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == vista.btnRegistrarCliente) {
      registrarCliente();
    }
    if (e.getSource() == vista.btnRegistrarCuenta) {
        registrarCuenta();
    }
    if (e.getSource() == vista.btnConsultasAdicionales) {
      mostrarConsultasAdicionales();
    }
    if (e.getSource() == vista.btnCambiarPIN) {
      cambiarPIN();
    }
    if (e.getSource() == vista.btnOperaciones) {
       mostrarMenuOperaciones();
    }
    if (e.getSource() == vista.btnSalir) {
      System.exit(0);
      this.vista.setVisible(false);
    }
  }

  /**
   * Metodo que abre la ventana de registro de cliente
   */
  private void registrarCliente() {
    RegistrarCliente registro = new RegistrarCliente();
    Cliente cliente = new Cliente();
    ControladorCliente controlador = new ControladorCliente(registro, cliente);
    controlador.vistaRegistrarCliente.setVisible(true);
  }
  
  /**
   * Metodo que abre la ventana de registro de cuenta
   */
  public void registrarCuenta() {
    RegistrarCuenta nuevaCuenta = new RegistrarCuenta();
    Cuenta cuenta = new Cuenta();
    ControladorCuenta controlador = new ControladorCuenta(nuevaCuenta, cuenta);
    controlador.vistaRegistrarCuenta.setVisible(true);
  }
  
  /**
   * Metodo que abre la ventana del menu de consultas adicionales
   */
  public void mostrarConsultasAdicionales() {
    MenuConsultasAdicionales menu = new MenuConsultasAdicionales();
    ControladorMenuConsultasAdicionales controlador = new ControladorMenuConsultasAdicionales(menu);
    controlador.vistaConsultasAdicionales.setVisible(true);
  }
  
  /**
   * Metodo que abre la ventana de cambio de PIN
   */
  public void cambiarPIN() {
    CambiarPIN cambio = new CambiarPIN();
    CuentaDAO cuentaDao = new CuentaDAO();
    ControladorCuenta controlador = new ControladorCuenta(cambio, cuentaDao);
    controlador.vistaCambiarPIN.setVisible(true);
  }
  
  /**
   * Metodo que abre la ventana del menu de operaciones
   */
  public void mostrarMenuOperaciones() {
    MenuModificaciones menu = new MenuModificaciones();
    ControladorMenuModificaciones controlador = new ControladorMenuModificaciones(menu);
    controlador.vista.setVisible(true);
  }
}