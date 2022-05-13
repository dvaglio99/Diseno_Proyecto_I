/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validaciones;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 *
 * @author chava
 */
public class Validaciones {
    
  public static boolean validarFormatoNumeroTelefonico(String pNumeroTelefonico) {
	  final String PHONE_REGEX = "^[5-9]\\d{3}-?\\d{4}$";
	  final Pattern pattern = Pattern.compile(PHONE_REGEX);      
	  pNumeroTelefonico=pNumeroTelefonico.replaceAll("[\\-\\+]", "");
	  //System.out.println(phone);
	  final Matcher matcher = pattern.matcher(pNumeroTelefonico);
	  if (matcher.matches() == true) { 
	   return true;
	  } 
	  return false;
  } 

  public static boolean obtenerFechaFormateada(String fecha) {
	  /* Check if date is 'null' */
		if (fecha.trim().equals(""))
		{
		    return true;
		}
		/* Date is not 'null' */
		else
		{
		    /*
		     * Set preferred date format,
		     * For example MM-dd-yyyy, MM.dd.yyyy,dd.MM.yyyy etc.*/
		    SimpleDateFormat sdfrmt = new SimpleDateFormat("dd-MM-yyyy");
		    sdfrmt.setLenient(false);
		    /* Create Date object
		     * parse the string into date 
	             */
		    try
		    {
		        Date javaDate = sdfrmt.parse(fecha); 
		        //System.out.println(fecha +" is valid date format");
		        
		    }
		    /* Date format is invalid */
		    catch (ParseException e)
		    {
		        //System.out.println(fecha +" is Invalid Date format");
		        return false;
		    }
		    /* Return true if date format is valid */
		    return true;
		}
  }
  
  public static boolean validarFormatoCorreoElectronico(String pCorreo) {
	// PatrÃ³n para validar el email
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
