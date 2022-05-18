
package logicadenegocios;

import java.util.List;

/**
 * Abstraccion de la clase Cliente
 * Estructura de los clientes.
 * @author Daniel Vaglio Fallas y Jafet Chavarria Moreno
 * @version Proyecto Programado I
 */
public class Cliente extends Persona implements Comparable<Cliente>{
  private String codigoCliente;
  private List<Cuenta> misCuentas;
  
  /**
   * metodo Constructor vacio
   */
  public Cliente() {
    super();
  }
  
  /**
   * Metodo Constructor 
   * @param pPrimerApellido
   * @param pSegundoApellido
   * @param pNombre
   * @param pIdentificacion
   * @param pFechaNacimiento
   * @param pNumTelefonico
   * @param pCorreoElectronico
   * @param pCodigoCliente 
   */
  public Cliente(String pPrimerApellido, String pSegundoApellido, String pNombre, 
          String pIdentificacion, String pFechaNacimiento, String pNumTelefonico, 
          String pCorreoElectronico, String pCodigoCliente){
      
    super(pPrimerApellido, pSegundoApellido, pNombre, pIdentificacion, pFechaNacimiento,
            pNumTelefonico, pCorreoElectronico);    
    setCodigoCliente(pCodigoCliente);
  }
  
  @Override
  public void registrarCuenta() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
    
  /**
   * Metodo que agrega una cuenta a un cliente
   * @param pCuenta 
   */
  void agregarCuenta(Cuenta pCuenta) {
	  misCuentas.add(pCuenta);
  }
	
  public String getCodigoCliente() {
    return codigoCliente;
  }

  public void setCodigoCliente(String pCodigoCliente) {
	this.codigoCliente = pCodigoCliente;
  }
  
  /**
   * Metodo que imprime los datos de un cliente
   * @return 
   */
  public String toString() {
    String mensaje = "";
    mensaje += super.toString();
    mensaje +=" \nCodigo Cliente: " + getCodigoCliente();
    return mensaje;
  }
 
  /**
   * Metodo que compara los clientes en funcion del primer apellido
   * @param o
   * @return el orden de los clientes
   */
  public int compareTo(Cliente o) {
	return this.getPrimerApellido().compareTo(o.getPrimerApellido());
  }
}
