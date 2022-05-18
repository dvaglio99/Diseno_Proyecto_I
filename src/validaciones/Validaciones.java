package validaciones;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * Abstraccion de la clase Validaciones
 * 
 * @author Daniel Vaglio Fallas y Jafet Chavarria Moreno
 * @version Proyecto Programado I
 */
public class Validaciones {
  
  /**
   * Metodo que valida el Formato de un Numero Telefonico (Para numeros de C.R)
   * @param pNumeroTelefonico
   * @return Verdadero si el numero cumple con el formato, Falso en caso contrario
   */
  public static boolean validarFormatoNumeroTelefonico(String pNumeroTelefonico) {
    final String PHONE_REGEX = "^[5-9]\\d{3}-?\\d{4}$";
    final Pattern pattern = Pattern.compile(PHONE_REGEX);      
    pNumeroTelefonico=pNumeroTelefonico.replaceAll("[\\-\\+]", "");
    final Matcher matcher = pattern.matcher(pNumeroTelefonico);
    if (matcher.matches() == true) { 
      return true;
    } 
    return false;
  } 

  /**
   * Metodo para validar el formato de la fecha dd-MM-yyyy
   * @param fecha
   * @return 
   */
  public static boolean obtenerFechaFormateada(String fecha) {
    /* Check if date is 'null' */
    if (fecha.trim().equals("")) {
      return true;
    }
    /* Date is not 'null' */
    else {
    /*
     * Set preferred date format,
     * For example MM-dd-yyyy, MM.dd.yyyy,dd.MM.yyyy etc.*/
      SimpleDateFormat sdfrmt = new SimpleDateFormat("dd-MM-yyyy");
      sdfrmt.setLenient(false);
    /* Create Date object
     * parse the string into date 
     */
    try {
      Date javaDate = sdfrmt.parse(fecha); 
		        
    }
    /* Date format is invalid */
    catch (ParseException e) {	       
      return false;
    }
   /* Return true if date format is valid */
    return true;
    }
  }
  
  /**
   * Metodo para validr el formato del correo electronico
   * @param pCorreo
   * @return 
   */
  public static boolean validarFormatoCorreoElectronico(String pCorreo) {
    // Patron para validar el email
    Pattern pattern = Pattern
        .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

    // El email a validar
    Matcher mather = pattern.matcher(pCorreo);

    if (mather.find() == true) {
      return true;
    } else {
      return false;
    }
  }
  
  /**
   * Metodo para validar el formato del PIN
   * @param pPIN
   * @return 
   */
  public static boolean validarPIN(String pPIN){
    // ReGex to check if a string
    // contains uppercase, lowercase
    // special character & numeric value      
    String regex = "^(?=.*[0-9])"
        + "(?=.*[a-z])(?=.*[A-Z])"
        + "(?=.*[@#$%^&+=])"
        + "(?=\\S+$).{6,6}$"; 

    // Compile the ReGex
    Pattern p = Pattern.compile(regex);

    // If the string is empty
    // then print No
    if (pPIN == null) {
      System.out.println("No");
      return false;
    }

    // Find match between given string
    // & regular expression
    Matcher m = p.matcher(pPIN);

    // Print Yes if string
    // matches ReGex
    if (m.matches())
      return true;
    else
      return false;
  } 
  
  /**
   * Metodo para validar que un numero no tenga decimales
   * @param pMonto
   * @return 
   */
  public static boolean validarMontoSinDecimal(String pMonto) {
    // Patron para validar el monto sin decimales
    Pattern pattern = Pattern.compile("^\\d+$");

    // El monto a validar
    Matcher mather = pattern.matcher(pMonto);

    if (mather.find() == true) {
      return true;
    } else {
      return false;
    }
  } 
}