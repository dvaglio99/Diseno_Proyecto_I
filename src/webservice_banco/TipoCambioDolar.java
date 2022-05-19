package webservice_banco;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author USUARIO
 */
public class TipoCambioDolar {
  public static String getTipoCambioCompra() {
    final String url = "https://www.davivienda.cr/generales/tipo_cambio_new.asp";
    String compra = "";
    try {
      final Document document = Jsoup.connect(url).get();
      final Elements row = document.select("td.texto_cuerpo_negrita");
      //final String venta = row.select("td.texto_cuerpo_negrita:nth-of-type(4)").text();
      compra = row.select("td.texto_cuerpo_negrita:nth-of-type(3)").text();
 
      //System.out.println(venta);
      System.out.println(compra);

    } catch (IOException e) {
            e.printStackTrace();
        }
    return compra;
  }

    public static String getTipoCambioVenta() {
    final String url = "https://www.davivienda.cr/generales/tipo_cambio_new.asp";
    String venta = "";
    try {
      final Document document = Jsoup.connect(url).get();
      final Elements row = document.select("td.texto_cuerpo_negrita");
      venta = row.select("td.texto_cuerpo_negrita:nth-of-type(4)").text();
      //compra = row.select("td.texto_cuerpo_negrita:nth-of-type(3)").text();
 
      //System.out.println(venta);
      System.out.println(venta);

    } catch (IOException e) {
            e.printStackTrace();
        }
    return venta;
  }
}
