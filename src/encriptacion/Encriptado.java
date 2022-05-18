
package encriptacion;

/**
 * Abstraccion de la clase Encriptado
 * Encripta informacion sensible del sistema de software
 * @author Daniel Vaglio Fallas y Jafet Chavarria Moreno
 * @version Proyecto Programado I
 */
public class Encriptado {
  /**
   * Metodo que utiliza la encriptacion cesar para codificar texto
   * @param texto
   * @return el texto codificado
   */
  public static String codificar(String texto){
    String letras = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZabcdefghijklmnñopqrstuvwxyz";
    String textoCodificado = "";
    char caracter;
    for (int i = 0; i < texto.length(); i++) {
      caracter = texto.charAt(i);
      int pos = letras.indexOf(caracter);
      if(pos == -1){
        textoCodificado += caracter;
      }else{
        textoCodificado += letras.charAt( (pos + 3) % letras.length() );
      }
    }
 
    return textoCodificado;
  } 
  
  /**
   * Metodo que decodifica un texto encriptado por encriptacion tipo cesar
   * @param texto
   * @return el texto decodificado
   */
  public static String decodificar(String texto){
    String textoDecodificado = "";
    String letras = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZabcdefghijklmnñopqrstuvwxyz";
    char caracter;
    for (int i = 0; i < texto.length(); i++) {
      caracter = texto.charAt(i);
      int pos = letras.indexOf(caracter);
      if(pos == -1){
        textoDecodificado += caracter;
      }else{
        if(pos - 3 < 0){
          textoDecodificado += letras.charAt( letras.length() + (pos - 3) );
        }else{
         textoDecodificado += letras.charAt( (pos - 3) % letras.length() );
        }
      }
    }
    return textoDecodificado;
  }
  
  /**
   * Metodo que codifica numeros por encriptacion tipo cesar
   * @param numero
   * @return los numeros codificados
   */
  public static String codificarNumeros(String numero){
    String digitos = "0123456789";
    String textoCodificado = ""; 
    char caracter;
    for (int i = 0; i < numero.length(); i++) {
      caracter = numero.charAt(i);
      int pos = digitos.indexOf(caracter);
      if(pos == -1){
        textoCodificado += caracter;
      }else{
        textoCodificado += digitos.charAt( (pos + 3) % digitos.length() );
      }
    }
    return textoCodificado;
  } 
}
