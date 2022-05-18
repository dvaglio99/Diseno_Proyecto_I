package controlador;

import dao.CuentaDAO;
import dao.OperacionesDAO;

import vista.MenuModificaciones;
import vista.RealizarDeposito;
import vista.RealizarRetiro;
import vista.RealizarTransferencia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Abstraccion de la clase ControladorMenuModificaciones
 * Utiliza las funcionalidades del menu de modificaciones
 * @author Daniel Vaglio Fallas y Jafet Chavarria Moreno
 * @version Proyecto Programado I
 */
public class ControladorMenuModificaciones implements ActionListener {  
  public MenuModificaciones vista;

  /**
   * Metodo Constructor
   * @param pVista la vista del menu de modificaciones que se despliega en la interfaz
   */
  public ControladorMenuModificaciones(MenuModificaciones pVista) {
    vista = pVista;
    
    this.vista.btnRealizarDepositoColones.addActionListener(this);
    this.vista.btnRealizarDepositoCambioMoneda.addActionListener(this);
    this.vista.btnRealizarRetiroColones.addActionListener(this);
    this.vista.btnRealizarRetiroCompraMoneda.addActionListener(this);
    this.vista.btnRealizarTransferencia.addActionListener(this);
    this.vista.btnVolver.addActionListener(this);
  }

  /**
   * Metodo que ejecuta las diferentes opciones del menu de modificaciones
   * @param e recibe la accion del boton
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == vista.btnRealizarDepositoColones) {
      realizarDepositoColones();
    }
    if (e.getSource() == vista.btnRealizarDepositoCambioMoneda) {
      realizarDepositoCambioMoneda();
    }
    if (e.getSource() == vista.btnRealizarRetiroColones) {
      realizarRetiroColones();
    }
    if (e.getSource() == vista.btnRealizarTransferencia) {
      realizarTransferencia();
    }
    if (e.getSource() == vista.btnVolver) {
      this.vista.setVisible(false);
    }    
  }
  
  /**
   * Metodo que abre la ventana para realizar un deposito en colones
   */
  public void realizarDepositoColones() {
    RealizarDeposito depositar = new RealizarDeposito();
    CuentaDAO cuentaDao = new CuentaDAO();
    OperacionesDAO operacionDao = new OperacionesDAO();
    ControladorOperaciones controlador = new ControladorOperaciones(depositar,cuentaDao,
        operacionDao);
    controlador.vistaRealizarDeposito.setVisible(true);
  }
  
  /**
   * Metodo que abre la ventana para realizar un deposito con cambio de moneda
   */
  public void realizarDepositoCambioMoneda() {
    
  }
  
  /**
   * Metodo que abre la ventana que para realizar un retiro en colones
   */
  public void realizarRetiroColones() { 
    RealizarRetiro retirar = new RealizarRetiro();
    CuentaDAO cuentaDao = new CuentaDAO();
    OperacionesDAO operacionDao = new OperacionesDAO();
    ControladorOperaciones controlador = new ControladorOperaciones(retirar, cuentaDao, operacionDao);
    controlador.vistaRealizarRetiro.setVisible(true);
  }
  
  /**
   * Metodo que abre la ventana que para realizar una transferencia en colones
   */
  public void realizarTransferencia(){
    RealizarTransferencia transferir = new RealizarTransferencia();
    CuentaDAO cuentaDao = new CuentaDAO();
    OperacionesDAO operacionDao = new OperacionesDAO();
    ControladorOperaciones controlador = new ControladorOperaciones(transferir, cuentaDao, operacionDao);
    controlador.vistaRealizarTransferencia.setVisible(true);
  }
}
