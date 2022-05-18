package logicadenegocios;

/**
 * Abstraccion de la clase Usuario
 * Estructura de los clientes.
 * @author Daniel Vaglio Fallas y Jafet Chavarria Moreno
 * @version Proyecto Programado I
 */
public class Usuario extends Persona{
 
  /**
   * Metodo Constructor
   * @param pPrimerApellido
   * @param pSegundoApellido
   * @param pNombre
   * @param pIdentificacion
   * @param pFechaNacimiento
   * @param pNumTelefonico
   * @param pCorreoElectronico 
   */
  public Usuario(String pPrimerApellido, String pSegundoApellido, String pNombre, String pIdentificacion,
			String pFechaNacimiento, String pNumTelefonico, String pCorreoElectronico) {
    super(pPrimerApellido, pSegundoApellido, pNombre, pIdentificacion, pFechaNacimiento, pNumTelefonico,
				pCorreoElectronico);
  }

  @Override
  public void registrarCuenta() {
	// TODO Auto-generated method stub
		
  }
	

}
