package controlador;

import dao.CuentaDAO;
import dao.OperacionesDAO;
import vista.MenuModificaciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.RealizarDeposito;

/**
 * Abstraccion de la clase ControladorMenuModificaciones
 * Utiliza las funcionalidades del menu de modificaciones
 * @author Daniel Vaglio Fallas y Jafet Chavarria Moreno
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
    this.vista.btnEliminarCursoDePlan.addActionListener(this);
    this.vista.btnEliminarCurso.addActionListener(this);
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
    if (e.getSource() == vista.btnEliminarCursoDePlan) {
      eliminarCursoDePlan();
    }
    if (e.getSource() == vista.btnEliminarCurso) {
      eliminarCurso();
    }
    if (e.getSource() == vista.btnVolver) {
      this.vista.setVisible(false);
    }    
  }
  
  /**
   * Metodo que abre la ventana para eliminar el requisito de un curso
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
   * Metodo que despliega la vista para elminar la relacion de un curso con un plan de estudio
   */
  public void eliminarCursoDePlan() {
    /*EliminarCursoDePlan eliminar = new EliminarCursoDePlan();
    CursoDAO dao = new CursoDAO();
    ControladorCurso controlador = new ControladorCurso(eliminar, dao);
    controlador.vistaEliminarCursoDePlan.setVisible(true); */
  }
  
  /**
   * Metodo que abre la ventana que para eliminar un curso
   */
  public void eliminarCurso() { /*
    EliminarCurso eliminar = new EliminarCurso();
    CursoDAO dao = new CursoDAO();
    ControladorCurso controlador = new ControladorCurso(eliminar, dao);
    controlador.vistaEliminarCurso.setVisible(true); */
  }
}
