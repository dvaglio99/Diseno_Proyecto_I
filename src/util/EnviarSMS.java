package util;

import com.twilio.Twilio; 
import com.twilio.rest.api.v2010.account.Message; 
import com.twilio.type.PhoneNumber;

/**
 * Abstraccion de la clase EnviarSMS
 * 
 * @author Daniel Vaglio Fallas y Jafet Chavarria Moreno
 * @version Proyecto Programado I
 */
public class EnviarSMS {
  // Find your Account Sid and Token at twilio.com/user/account
  private static final String ACCOUNT_SID = "AC2cf8f610873feaa18fd83da5ae15a043";
  private static final String AUTH_TOKEN = "3fee5b8b9681c6c7c3e4da372d41f16b";
  
  /**
   * Metodo que genera una palabra clave aleatoria
   * @return la palabra clave generada
   */
  public static String generarPalabra(){
  //La variable palabra almacena el resultado final
  String palabra = "";
  //La longitud de la palabra la decidimos al azar
  int longitud = (int)(Math.random() * 9) + 1;
  //Generamos palabra
  for (int i=0; i<longitud; i++){
      int codigoAscii = (int)Math.floor(Math.random()*(122 - 97)+97);
      //para pasar el código a carácter basta con hacer un cast a char
      palabra = palabra + (char)codigoAscii;
  }
  return palabra;
  }
  
  /**
   * Metodo que envia el mensaje al numero de telefono y con la palabra clave
   * @param pTelefono
   * @param pPalabraClave 
   */
  public static void enviarSMS(String pTelefono, String pPalabraClave){
  Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    Message message = Message.creator(new PhoneNumber("+506"+pTelefono), 
        new PhoneNumber("+19802916814"),pPalabraClave).create();
  System.out.println(message.getSid()); 
  }
}
