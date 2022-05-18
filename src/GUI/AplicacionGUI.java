
package GUI;

import controlador.ControladorMenuOpciones;
import vista.MenuOpciones;

/**
 * Abstraccion de la clase AplicacionGUI
 * Clase que Inicializa la vista en GUI
 * @author Daniel Vaglio Fallas y Jafet Chavarria Moreno
 * @version Proyecto Programado I
 */
public class AplicacionGUI {
    
  public static void main(String[] args) {
      MenuOpciones inicio = new MenuOpciones();
      ControladorMenuOpciones controlador = new ControladorMenuOpciones(inicio);
      controlador.vista.setVisible(true);
    }
    
}
