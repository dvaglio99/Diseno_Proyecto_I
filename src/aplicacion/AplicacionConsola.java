package aplicacion;

import validaciones.Validaciones;
import dao.ClienteDAO;
import conexion.Conexion;
import dao.CuentaDAO;
import dao.OperacionesDAO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import webservice_banco.TipoCambioDolar;

/**
 * Abstraccion de la clase AplicacionConsola
 * Clase que inicializa el sistema de software desde la consola
 * @author Daniel Vaglio Fallas y Jafet Chavarria Moreno
 * @version Proyecto Programado I
 */
public class AplicacionConsola {
    
  static BufferedReader in;
  static Conexion conexion;

  /**
   * Metodo Main
   *
   * @param args
   * @throws IOException
   * @throws NumberFormatException
   * @throws java.sql.SQLException
   */
  public static void main(String[] args) throws NumberFormatException, IOException, SQLException {
    
    in = new BufferedReader(new InputStreamReader(System.in));
    boolean noSalir;
    int opcion;
    do {

      mostrarMenu();
      opcion = leerOpcion();
      noSalir = ejecutarAccion(opcion);
    } while (noSalir);
  }

  /**
   * Metodo mostrarMenu() muestra las diferentes opciones que ofrece el sistema
   */
  static void mostrarMenu() {

    System.out.println("1. Registrar un Cliente");
    System.out.println("2. Registrar una Cuenta a un Cliente");
    System.out.println("3. Consultar Clientes ordenados ");
    System.out.println("4. Consultar Informacion de un Cliente en Particular ");
    System.out.println("5. Consultar Cuentas ordenadas ");
    System.out.println("6. Consultar Informacion de una Cuenta en Particular ");
    System.out.println("7. Cambiar PIN de una Cuenta ");
    System.out.println("8. Realizar Deposito en Colones ");
    System.out.println("9. Realizar Deposito con Cambio de Moneda ");
    System.out.println("10. Realizar Retiro en Colones ");
    System.out.println("11. Realizar Retiro con Compra de Moneda ");
    System.out.println("12. Realizar Transferencia con Moneda Local");
    System.out.println("13. Consultar Tipo de Cambio Compra de Divisa Extranjera ");
    System.out.println("14. Consultar Tipo de Cambio Venta de Divisa Extranjera ");
    System.out.println("15. Consultar Saldo Actual de una Cuenta ");
    System.out.println("16. Consultar Saldo Actual de una Cuenta Equivalente a la Divisa "
        + "Extranjera");
    System.out.println("17. Consultar Estado de una Cuenta ");
    System.out.println("18. Consultar Estado de una Cuenta con Montos Equivalentes a la Divisa "
        + "Extranjera");
    System.out.println("19. Consultar Estatus de una Cuenta ");
    System.out.println("20. Consultar Ganancias del Banco Producto del Cobro de Comisiones "
        + "Totalizado");
    System.out.println("21. Consultar Ganancias del Banco Producto del Cobro de Comisiones para una "
        + "Cuenta en Especifico");
    System.out.println("22. Salir");

  }

  /**
   * Metodo leerOpcion() lee la opcion que es insertada por teclado
   *
   * @return el numero con la opcion elegida
   * @throws IOException
   * @throws NumberFormatException
   */
  static int leerOpcion() throws NumberFormatException, IOException {
    int opcion;
    System.out.print("Seleccione una Opcion: ");
    opcion = Integer.parseInt(in.readLine());
    System.out.println();

    return opcion;

  }

  /**
   * Metodo ejecutarAccion() realiza la opcion elegida por el usuario
   *
   * @param opcion la opcion que es leida segun el numero que indique el usuario
   * @throws IOException
   * @throws SQLException
   */
  static boolean ejecutarAccion(int opcion) throws IOException, SQLException {

    boolean noSalir = true;
    
    switch (opcion) {

      case 1:
        registrarCliente();
        break;
      case 2:
        registrarCuenta();
        break;
      case 3:
        consultarClientesOrdenados();
        break;
      case 4:
        consultarInformacionClienteParticular();
        break;
      case 5:
        consultarCuentasOrdenadas();
        break;
      case 6: 
        consultarInformacionCuentaParticular();
        break;
      case 7:
        cambiarPINCuenta();
        break;
      case 8:
        realizarDeposito();
        break;
      case 9:
        realizarDepositoCambioMoneda();
        break;
        
      case 10:
        realizarRetiro();
        break;
      case 11:
        realizarRetiroCompraMoneda();
        break;
      case 12:
        realizarTransferencia();
        break;
      case 13:
        consultarTipoCambioCompraDivisaExtranjera();
        break;
        
      case 14:
        consultarTipoCambioVentaDivisaExtranjera();
        break;
        
      case 15:
        consultarSaldoActualCuenta();
        break;
      case 16:
        consultarSaldoActualCuentaDivisaExtranjera();
        break;
        
      case 17:
        consultarEstadoCuenta();
        break;
      case 18:
        consultarEstadoCuentaDivisaExtranjera();
        break;
      case 19:
        consultarEstatusCuenta();
        break;
      case 20:
        consultarGananciasComisionesTotalizado();
        break;
      case 21:
        consultarGananciasComisionesCuentaParticular();
        break;
      case 22:
        noSalir = false;
        break;
    }

    System.out.println();
    return noSalir;
  }
  
  /**
   * Metodo registrarCliente() registra el cliente en la base de datos
   * @throws IOException 
   */
  static void registrarCliente() throws IOException {
    ClienteDAO clienteDao = new ClienteDAO();
    String primerApellido;
    String segundoApellido;
    String nombre;
    String identificacion;
    String fechaNacimiento;
    String numeroTelefonico;
    String correoElectronico;
    System.out.print("\nIngrese el primer apellido del cliente: ");
    primerApellido = in.readLine();
    System.out.print("\nIngrese el segundo apellido del cliente: ");
    segundoApellido = in.readLine();
    System.out.print("Ingrese el nombre del cliente: ");
    nombre = in.readLine();
    System.out.print("\nIngrese la identificacion del cliente: ");
    identificacion = in.readLine();
    System.out.print("\nIngrese la fecha de nacimiento del cliente (formato dd-MM-AAAA): ");
    fechaNacimiento = in.readLine();
    System.out.print("\nIngrese el numero telefonico del cliente (formato ####-####): ");
    numeroTelefonico = in.readLine();
    System.out.print("\nIngrese el correo electronico del cliente: ");
    correoElectronico = in.readLine();
    if (Validaciones.validarFormatoCorreoElectronico(correoElectronico) == true
        && Validaciones.obtenerFechaFormateada(fechaNacimiento) == true
        && Validaciones.validarFormatoNumeroTelefonico(numeroTelefonico)) {
      clienteDao.registrarCliente(primerApellido, segundoApellido, nombre, identificacion, 
          fechaNacimiento, numeroTelefonico, correoElectronico);
            
      System.out.println("Se ha creado un nuevo cliente en el sistema, los datos que fueron "
          + "almacenados son: "
          + "\n Nombre: " + primerApellido + " " + segundoApellido + " "
          + nombre + "\n Identificacion:" + identificacion + "\n Fecha Nacimiento: "
          + fechaNacimiento + "\n Numero Telefonico: " + numeroTelefonico
          + "\n Correo Electronico: " + correoElectronico
        );
    }
  }
  
  /**
   * 
   * Metodo registrarCuenta() registra una cuenta y la asigna a un cliente existente en la BD
   * @throws IOException
   * @throws SQLException 
   */
  static void registrarCuenta() throws IOException, SQLException {
    CuentaDAO cuentaDao = new CuentaDAO();
    ResultSet rs;
    double saldo = 0;
    String estadoDeLaCuenta = "Activa";
    String fechaCreacion = null;
    String PIN = null;

    System.out.print("\nIngrese la identificación del cliente al cual quiere asignar la cuenta: ");
    int identificacionDuenio = Integer.parseInt(in.readLine());
    
    System.out.print("\nIngrese el PIN a usar (6 Digitos): ");
    System.out.print("\nNOTA: El PIN a ingresar debe contener al menos: "
        + "\n. un numero."
        + "\n. una Mayuscula."
        + "\n. un Caracter especial.\n "
        + "Ingrese el PIN: ");
    PIN = in.readLine();
    System.out.print("\nIngrese la fecha de creacion de la cuenta (dd-MM-yyyy): ");
    fechaCreacion = in.readLine();
    System.out.print("\nIngrese el monto inicial: ");
    saldo = Double.parseDouble(in.readLine());
    if (Validaciones.obtenerFechaFormateada(fechaCreacion) == true
        && Validaciones.validarPIN(PIN) == true) {

      cuentaDao.registrarCuentaAUnCliente(PIN, identificacionDuenio, fechaCreacion, saldo, estadoDeLaCuenta);
      rs = cuentaDao.consultarDatosDuenioCuenta(identificacionDuenio);
      if (rs.next()){
        System.out.println("Se ha creado una nueva cuenta en el "
            + "sistema, los datos de la cuenta son: \n\n"
            + "Estatus de la cuenta: " + estadoDeLaCuenta + "\nSaldo actual: " + saldo
            + "\n --- " + "\nNombre del dueño de la cuenta: " + rs.getString(1) + " " 
            + rs.getString(2) + " " + rs.getString(3) + "\nNumero de telefono asociado a la "
            + "cuenta: " + rs.getString(4) + "\nDireccion de correo electronico asociado a la "
            + "cuenta: " + rs.getString(5)
        );
      }
    } else {
      System.out.println("Error: Revise que los datos que esta ingresando coincidan con los formatos pedidos"
          + " y vuelva a intentarlo.");  
    } 
  }

  /**
   * Metodo consultarClientesOrdenados() consulta los clientes ordenados ascendentemente en funcion
   * del primer apellido
   * @throws SQLException 
   */
  static void consultarClientesOrdenados() throws SQLException {
    ClienteDAO clienteDao = new ClienteDAO();
    ResultSet rs;
    rs = clienteDao.consultarClientesOrdenados();
    while (rs.next()){
      String primerApellido = rs.getString(1);
      String segundoApellido =  rs.getString(2);
      String nombre = rs.getString(3);
      String idCliente = rs.getString(4);
      
      System.out.println("\nPrimer Apellido: " +primerApellido+ "\n"
           + "Segundo Apellido: " + segundoApellido + "\n"
           + "Nombre: " +nombre + "\n"
           + "ID del cliente: " + idCliente + "\n");
    }
  } 
  
  /**
   * metodo consultarInformacionClienteParticular() consulta la informacion de un cliente en
   * especifico
   * @throws SQLException
   * @throws IOException 
   */
  static void consultarInformacionClienteParticular() throws SQLException, IOException {
    ClienteDAO clienteDao = new ClienteDAO();
    ResultSet rs;
    System.out.print("\nIngrese la identificación del cliente al cual quiere ver la informacion: ");
    String identificacionCuenta = in.readLine();
    rs = clienteDao.consultarInformacionClienteParticular(identificacionCuenta);
    while (rs.next()){
      String idCliente = rs.getString(1);
      String cedula = rs.getString(2);
      String primerApellido = rs.getString(3);
      String segundoApellido =  rs.getString(4);
      String nombre = rs.getString(5);
      String fechaNacimiento = rs.getString(6);
      String numeroTelefonico = rs.getString(7);
      String correo = rs.getString(8);
      String numeroCuenta = rs.getString(9);
      String estadoCuenta = rs.getString(10);
      
      System.out.println("\nID del cliente: "+ idCliente+ "\n"
          + "Identificacion del cliente: " + cedula+ "\n"
          + "Primer Apellido: " + primerApellido+ "\n"
          + "Segundo Apellido: " + segundoApellido + "\n" 
          + "Nombre: " +nombre + "\n"
          + "Fecha de Nacimiento: " + fechaNacimiento + "\n"
          + "Numero de telefono: " + numeroTelefonico + "\n"
          + "Correo Electronico: " + correo + "\n"
          + "Numero de Cuenta: " + encriptacion.Encriptado.codificarNumeros(numeroCuenta) + "\n"
          + "Estado de la Cuenta: " + estadoCuenta + "\n");
    }
  }
  
  /**
   * Metodo consultarCuentasOrdenadas() consulta las cuentas ordenadas descendentemente en funcion
   * del Saldo
   * @throws SQLException 
   */
  static void consultarCuentasOrdenadas() throws SQLException {
    CuentaDAO cuentaDao = new CuentaDAO();
    ResultSet rs;
    rs = cuentaDao.consultarCuentasOrdenadas();
    while (rs.next()){
      String numeroCuenta = encriptacion.Encriptado.codificarNumeros(rs.getString(1));
      String estadoCuenta = rs.getString(2);
      String saldo = rs.getString(3);
      String idCliente = rs.getString(4);
      String primerApellido = rs.getString(5);
      String segundoApellido =  rs.getString(6);
      String nombre = rs.getString(7);
      
      System.out.println("Numero de Cuenta: " + numeroCuenta + "\n"
          + "Estado de la Cuenta: " + estadoCuenta+ "\n"
          + "Saldo: " + saldo + "\n"
          + "ID del cliente dueño: " + idCliente + "\n" 
          + "Primer Apellido: " + primerApellido+ "\n"
          + "Segundo Apellido: " + segundoApellido + "\n"
          + "Nombre: " +nombre + "\n"
        );
    }
  } 
  
  /**
   * Metodo consultarInformacionCuentaParticular() consulta la informacion de una cuenta en 
   * particular
   * @throws SQLException
   * @throws IOException 
   */
  static void consultarInformacionCuentaParticular() throws SQLException, IOException {
    CuentaDAO cuentaDao = new CuentaDAO();
    ResultSet rs;
    ResultSet rs2;
    System.out.print("\nIngrese el numero de cuenta al cual quiere ver la informacion: ");
    String pNumeroCuenta = in.readLine();
    int pNumeroCuentaValidar = Integer.parseInt(pNumeroCuenta);
    rs2 = cuentaDao.buscarNumeroCuentaCliente(pNumeroCuentaValidar);
    if(rs2.next()){
      if (rs2.getInt(1) == pNumeroCuentaValidar){
        rs = cuentaDao.consultarInformacionCuentaParticular(pNumeroCuenta);
        while (rs.next()){
          String numeroCuenta = encriptacion.Encriptado.codificarNumeros(rs.getString(1));
          String PIN = encriptacion.Encriptado.codificar(rs.getString(2));
          String idDuenio = rs.getString(3);
          String fechaCreacion = rs.getString(4);
          String saldo = encriptacion.Encriptado.codificarNumeros(rs.getString(5));
          String estadoCuenta = rs.getString(6); 
          String primerApellido = rs.getString(7);
          String segundoApellido =  rs.getString(8);
          String nombre = rs.getString(9);
            
          System.out.println("Numero de Cuenta: "+ numeroCuenta + "\n"
              + "PIN: " + PIN + "\n"
              + "ID del Cliente poseedor de la cuenta: " + idDuenio + "\n"
              + "Fecha de Creacion:" + fechaCreacion + "\n" 
              + "Saldo: " +saldo + "\n"
              + "Estado de la Cuenta: " + estadoCuenta + "\n"
              + "Primer Apellido"+ primerApellido+ "\n"
              + "Segundo Apellido: " + segundoApellido + "\n"
              + "Nombre: " + nombre + "\n");
        } 
      }
    } else {
      System.out.println("el numero de cuenta ingresado no existe en la base de datos."
          + " Por favor, intente de nuevo.");
    }
  } 
  
  /**
   * Metodo cambiarPIN() cambia el PIN de una cuenta
   * @throws IOException
   * @throws SQLException 
   */
  static void cambiarPINCuenta() throws IOException, SQLException{
    CuentaDAO cuentaDao = new CuentaDAO();
    ResultSet rs2;
    ResultSet rs3;
    System.out.print("\nIngrese el numero de cuenta al cual quiere cambiar el PIN: ");
    int pNumeroCuenta = Integer.parseInt(in.readLine());
    rs3 = cuentaDao.buscarNumeroCuentaCliente(pNumeroCuenta);
    if (rs3.next()){
      if (rs3.getInt(1) == pNumeroCuenta){
        rs2 = cuentaDao.buscarPIN(pNumeroCuenta);
        System.out.print("\nIngrese el PIN de la cuenta: ");
        String pPIN = in.readLine();
        if (rs2.next()){
          if (rs2.getString(1).equals(pPIN)) {
            System.out.println("PIN VALIDADO");
            System.out.print("\nIngrese el nuevo PIN de la cuenta: ");
            String pNuevoPIN = in.readLine();
            System.out.print("\nIngrese nuevamente el nuevo PIN de la cuenta: ");
            String pNuevoNuevoPIN = in.readLine();
            if (pNuevoPIN.equals(pNuevoNuevoPIN) && validaciones.Validaciones.validarPIN(pNuevoPIN)){
              cuentaDao.cambiarPIN(pNuevoPIN, pNumeroCuenta);
              System.out.println("Ha sido posible cambiar el " 
                  +"PIN de la cuenta numero: " + pNumeroCuenta);
            } else {
              System.out.println("No ha sido posible cambiar el PIN. Revise el formato e "
                      + "intente de nuevo.");
            }
          } else {
          System.out.println("el PIN no coincide. Intente de nuevo.");
          }
        }   
      }
    } else {
      System.out.println("el numero de cuenta ingresado no existe en la base de datos."
          + " Por favor, intente de nuevo.");
    }
  }
  
  /**
   * Metodo realizarDeposito() realiza un deposito a una cuenta y verifica si se cobra comision
   * @throws IOException
   * @throws SQLException 
   */
  static void realizarDeposito() throws IOException, SQLException {
    CuentaDAO cuentaDao = new CuentaDAO();
    OperacionesDAO operacionDao = new OperacionesDAO();
    ResultSet rs2;
    ResultSet rs3;
    ResultSet rs4;
    System.out.print("\nIngrese el numero de cuenta al cual se va a depositar: ");
    int pNumeroCuenta = Integer.parseInt(in.readLine());
    rs3 = cuentaDao.buscarNumeroCuentaCliente(pNumeroCuenta);
    if (rs3.next()){
      if (rs3.getInt(1) == pNumeroCuenta){
        System.out.print("\nIngrese el monto a depositar en la cuenta: ");
        String pMontoValidar = in.readLine(); 
         if (validaciones.Validaciones.validarMontoSinDecimal(pMontoValidar) == true){
              System.out.println("Monto validado \n");
              int montoDeposito = Integer.parseInt(pMontoValidar);
              int montoComision = (int) (montoDeposito * 0.02);
              operacionDao.registrarDeposito(montoDeposito, pNumeroCuenta);
              rs2 = operacionDao.obtenerUltimaOperacion();
              if (rs2.next()){
                  int ultimaOperacion = Integer.parseInt(rs2.getString(1));
                  rs4 = operacionDao.verificarSiCobrarComisionDeposito(pNumeroCuenta);
                  if (rs4.next()){
                    if (rs4.getInt(1) >= 3){
                      operacionDao.cobrarComision(montoComision, pNumeroCuenta, ultimaOperacion);
                        System.out.println("Estimado usuario, se han depositado "
                            + " correctamente "+ montoDeposito+" colones\n" +
                            "El monto real depositado a su cuenta "+pNumeroCuenta+" es de "
                            + montoDeposito+" colones\n"+ "El monto cobrado por concepto de "
                            + "comisión fue de "+montoComision+" colones, que fueron rebajados "
                            + "automáticamente de su saldo actual"
                        );
                    } else {
                        System.out.println("Estimado usuario, se han depositado correctamente "
                            + montoDeposito+" colones\n El monto real depositado a su cuenta "
                            +pNumeroCuenta+" es de "+montoDeposito+" colones\n"+
                            "El monto cobrado por concepto de comisión fue de 0.00 colones"
                        );
                    }
                  }
              }
         } else {
             System.out.println("Monto invalido, ingrese un numero entero");
         }
      } 
    } else {
        System.out.println("el numero de cuenta ingresado no existe en la base de datos."
          + " Por favor, intente de nuevo.");
      }
  }
  
  /**
   * Metodo realizarDeposito() realiza un deposito en dolares a una cuenta y verifica si se cobra comision
   * @throws IOException
   * @throws SQLException 
   */
  static void realizarDepositoCambioMoneda() throws SQLException, IOException{
    CuentaDAO cuentaDao = new CuentaDAO();
    OperacionesDAO operacionDao = new OperacionesDAO();
    TipoCambioDolar tipoCambio = new TipoCambioDolar();
    ResultSet rs2;
    ResultSet rs3;
    ResultSet rs4;
    Double tipoDeCambioDolar = Double.parseDouble(tipoCambio.getTipoCambioCompra());
    int tipoDeCambioDolarConvertidoAInt = tipoDeCambioDolar.intValue();
    System.out.print("\nIngrese el numero de cuenta al cual se va a depositar: ");
    int pNumeroCuenta = Integer.parseInt(in.readLine());
    rs3 = cuentaDao.buscarNumeroCuentaCliente(pNumeroCuenta);
    if (rs3.next()){
      if (rs3.getInt(1) == pNumeroCuenta){
        System.out.print("\nIngrese el monto en dolares a depositar en la cuenta: ");
        String pMontoValidar = in.readLine(); 
         if (validaciones.Validaciones.validarMontoSinDecimal(pMontoValidar) == true){
              System.out.println("Monto validado \n");
              int montoDeposito = Integer.parseInt(pMontoValidar);
              int montoDepositoEnDolares = montoDeposito*tipoDeCambioDolarConvertidoAInt;
              int montoComision = (int) (montoDepositoEnDolares * 0.02);
              operacionDao.registrarDeposito(montoDepositoEnDolares, pNumeroCuenta);
              rs2 = operacionDao.obtenerUltimaOperacion();
              if (rs2.next()){
                  int ultimaOperacion = Integer.parseInt(rs2.getString(1));
                  rs4 = operacionDao.verificarSiCobrarComisionDeposito(pNumeroCuenta);
                  if (rs4.next()){
                    if (rs4.getInt(1) >= 3){
                      operacionDao.cobrarComision(montoComision, pNumeroCuenta, ultimaOperacion);
                        System.out.println("Estimado usuario, se han depositado "
                            + " correctamente "+ montoDeposito+" colones\n" +
                            "El monto real depositado a su cuenta "+pNumeroCuenta+" es de "
                            + montoDeposito+" colones\n"+ "El monto cobrado por concepto de "
                            + "comisión fue de "+montoComision+" colones, que fueron rebajados "
                            + "automáticamente de su saldo actual"
                        );
                    } else {
                        System.out.println("Estimado usuario, se han depositado correctamente "
                            + montoDeposito+" colones\n El monto real depositado a su cuenta "
                            +pNumeroCuenta+" es de "+montoDeposito+" colones\n"+
                            "El monto cobrado por concepto de comisión fue de 0.00 colones"
                        );
                    }
                  }
              }
         } else {
             System.out.println("Monto invalido, ingrese un numero entero");
         }
      } 
    } else {
        System.out.println("el numero de cuenta ingresado no existe en la base de datos."
          + " Por favor, intente de nuevo.");
      }
  }
  
  /**
   * Metodo realizarRetiro() realiza un retiro de una cuenta y verifica si se cobra comision 
   * por la operacion.
   * @throws SQLException
   * @throws IOException 
   */
  static void realizarRetiro() throws SQLException, IOException{
    CuentaDAO cuentaDao = new CuentaDAO();
    OperacionesDAO operacionDao = new OperacionesDAO();
    ResultSet rs2;
    ResultSet rs3;
    ResultSet rs4;
    ResultSet rs5;
    ResultSet rs6;
    System.out.print("\nIngrese el numero de cuenta al cual se va a retirar: ");
    int pNumeroCuenta = Integer.parseInt(in.readLine());
    rs2 = cuentaDao.buscarNumeroCuentaCliente(pNumeroCuenta);
    if (rs2.next()){
      if (rs2.getInt(1) == pNumeroCuenta){
        System.out.print("\nIngrese el PIN de la cuenta: ");
        String PIN = in.readLine();
        rs3 = cuentaDao.buscarPIN(pNumeroCuenta);
        if (rs3.next()) {
          if (rs3.getString(1).equals(PIN)){
            System.out.println("PIN VALIDADO");
            System.out.print("\nIngrese el monto a retirar en la cuenta: ");
            String pMontoValidar = in.readLine(); 
            if (validaciones.Validaciones.validarMontoSinDecimal(pMontoValidar) == true){
              System.out.println("Monto validado \n");
              int montoRetiro = Integer.parseInt(pMontoValidar);
              int montoComision = (int) (montoRetiro * 0.02);
              rs4 = operacionDao.obtenerSaldoCliente(pNumeroCuenta);
              if(rs4.next()){
                if(montoRetiro <= rs4.getInt(1)){
                    operacionDao.registrarRetiro(montoRetiro, pNumeroCuenta);
                    rs5 = operacionDao.obtenerUltimaOperacion();
                    if (rs5.next()){
                      int ultimaOperacion = Integer.parseInt(rs5.getString(1));
                      rs6 = operacionDao.verificarSiCobrarComisionRetiro(pNumeroCuenta);
                      if(rs6.next()){
                        if (rs6.getInt(1) >= 3) {
                          operacionDao.cobrarComision(montoComision, pNumeroCuenta, ultimaOperacion);
                          System.out.println("Estimado usuario, el monto de este retiro "
                              + " es "+ montoRetiro +" colones\n" 
                              +"El monto cobrado por concepto de "
                              + "comisión fue de "+montoComision+" colones, que fueron rebajados "
                              + "automáticamente de su saldo actual"
                            );                        
                        } else {
                        System.out.println("Estimado usuario, el monto de este retiro "
                              + " es "+ montoRetiro +" colones\n" 
                              +"El monto cobrado por concepto de "
                              + "comisión fue de 0.00 colones."
                            ); 
                        } 
                      }
                    }
                } else {
                    System.out.println("El monto a retirar es mayor que el saldo de la cuenta. "
                        + "Por favor, intente de nuevo.");
                }
              }  
            } else {
              System.out.println("Monto invalido, ingrese un numero entero");
            }
         } else{
           System.out.println("El PIN ingresado no Coincide con el registrado en la cuenta."
              + " Por favor, intente de nuevo"); 
           } 
        }  
      }
    } else {
        System.out.println("el numero de cuenta ingresado no existe en la base de datos."
          + " Por favor, intente de nuevo.");
      }
  }
  
  /**
   * Metodo realizarRetiro() realiza un retiro de una cuenta y verifica si se cobra comision 
   * por la operacion.
   * @throws SQLException
   * @throws IOException 
   */
  static void realizarRetiroCompraMoneda() throws SQLException, IOException{
    CuentaDAO cuentaDao = new CuentaDAO();
    OperacionesDAO operacionDao = new OperacionesDAO();
    TipoCambioDolar tipoCambio = new TipoCambioDolar();
    ResultSet rs2;
    ResultSet rs3;
    ResultSet rs4;
    ResultSet rs5;
    ResultSet rs6;
    Double tipoDeCambioDolar = Double.parseDouble(tipoCambio.getTipoCambioVenta());
    int tipoDeCambioDolarConvertidoAInt = tipoDeCambioDolar.intValue();
    System.out.print("\nIngrese el numero de cuenta al cual se va a retirar: ");
    int pNumeroCuenta = Integer.parseInt(in.readLine());
    rs2 = cuentaDao.buscarNumeroCuentaCliente(pNumeroCuenta);
    if (rs2.next()){
      if (rs2.getInt(1) == pNumeroCuenta){
        System.out.print("\nIngrese el PIN de la cuenta: ");
        String PIN = in.readLine();
        rs3 = cuentaDao.buscarPIN(pNumeroCuenta);
        if (rs3.next()) {
          if (rs3.getString(1).equals(PIN)){
            System.out.println("PIN VALIDADO");
            System.out.print("\nIngrese el monto a retirar en la cuenta: ");
            String pMontoValidar = in.readLine(); 
            if (validaciones.Validaciones.validarMontoSinDecimal(pMontoValidar) == true){
              System.out.println("Monto validado \n");
              int montoRetiro = Integer.parseInt(pMontoValidar);
              int montoRetiroEnDolares = montoRetiro*tipoDeCambioDolarConvertidoAInt;
              int montoComision = (int) (montoRetiroEnDolares * 0.02);
              rs4 = operacionDao.obtenerSaldoCliente(pNumeroCuenta);
              if(rs4.next()){
                if(montoRetiroEnDolares <= rs4.getInt(1)){
                    operacionDao.registrarRetiro(montoRetiroEnDolares, pNumeroCuenta);
                    rs5 = operacionDao.obtenerUltimaOperacion();
                    if (rs5.next()){
                      int ultimaOperacion = Integer.parseInt(rs5.getString(1));
                      rs6 = operacionDao.verificarSiCobrarComisionRetiro(pNumeroCuenta);
                      if(rs6.next()){
                        if (rs6.getInt(1) >= 3) {
                          operacionDao.cobrarComision(montoComision, pNumeroCuenta, ultimaOperacion);
                          System.out.println("Estimado usuario, el monto de este retiro "
                              + " es "+ montoRetiroEnDolares +" colones\n" 
                              +"El monto cobrado por concepto de "
                              + "comisión fue de "+montoComision+" colones, que fueron rebajados "
                              + "automáticamente de su saldo actual"
                            );                        
                        } else {
                        System.out.println("Estimado usuario, el monto de este retiro "
                              + " es "+ montoRetiroEnDolares +" colones\n" 
                              +"El monto cobrado por concepto de "
                              + "comisión fue de 0.00 colones."
                            ); 
                        } 
                      }
                    }
                } else {
                    System.out.println("El monto a retirar es mayor que el saldo de la cuenta. "
                        + "Por favor, intente de nuevo.");
                }
              }  
            } else {
              System.out.println("Monto invalido, ingrese un numero entero");
            }
         } else{
           System.out.println("El PIN ingresado no Coincide con el registrado en la cuenta."
              + " Por favor, intente de nuevo"); 
           } 
        }  
      }
    } else {
        System.out.println("el numero de cuenta ingresado no existe en la base de datos."
          + " Por favor, intente de nuevo.");
      }
  }
  
  /**
   * Metodo realizarTransferencia() realiza una transferencia de una cuenta origen a una cuenta 
   * destino, ademas se verifica si en la cuenta origen se cobra comision
   * @throws IOException
   * @throws SQLException 
   */
  static void realizarTransferencia() throws IOException, SQLException{
    CuentaDAO cuentaDao = new CuentaDAO();
    OperacionesDAO operacionDao = new OperacionesDAO();
    ResultSet rs;
    ResultSet rs2;
    ResultSet rs3;
    ResultSet rs4;
    ResultSet rs5;
    ResultSet rs6;
    System.out.print("\nIngrese el numero de cuenta origen : ");
    int pNumeroCuenta = Integer.parseInt(in.readLine());
    rs = cuentaDao.buscarNumeroCuentaCliente(pNumeroCuenta);   
    if (rs.next()){
       if (rs.getInt(1) == pNumeroCuenta){
         System.out.print("\nIngrese el PIN de la cuenta origen: ");
         String PIN = in.readLine();
         rs2 = cuentaDao.buscarPIN(pNumeroCuenta);
         if (rs2.next()) {
           if (rs2.getString(1).equals(PIN)){
             System.out.println("PIN VALIDADO");
             System.out.print("\nIngrese el monto a transferir de la cuenta: ");
             String pMontoValidar = in.readLine(); 
             if (validaciones.Validaciones.validarMontoSinDecimal(pMontoValidar) == true){
               System.out.println("Monto validado.");
               int montoRetiro = Integer.parseInt(pMontoValidar);
                int montoComision = (int) (montoRetiro * 0.02);
                rs3 = operacionDao.obtenerSaldoCliente(pNumeroCuenta);
                if(rs3.next()){
                  if(montoRetiro <= rs3.getInt(1)){
                    System.out.print("\nIngrese el numero de cuenta destino : ");
                    int pNumeroCuentaDestino = Integer.parseInt(in.readLine()); 
                    rs4 = cuentaDao.buscarNumeroCuentaCliente(pNumeroCuentaDestino);
                    if (rs4.next()){
                      if (rs4.getInt(1) == pNumeroCuentaDestino) {
                        operacionDao.registrarTransferencia(montoRetiro, pNumeroCuenta, 
                            pNumeroCuentaDestino);
                        rs5 = operacionDao.obtenerUltimaOperacion();
                        if (rs5.next()){
                          int ultimaOperacion = Integer.parseInt(rs5.getString(1));
                          rs6 = operacionDao.verificarSiCobrarComisionRetiro(pNumeroCuenta);
                          if(rs6.next()){
                            if (rs6.getInt(1) >= 3) {
                              operacionDao.cobrarComision(montoComision, pNumeroCuenta, 
                                  ultimaOperacion);
                              System.out.println("Estimado usuario, la transferencia de fondos se "
                                  + "ejecutó satisfactoriamente.\n El monto retirado de la cuenta "
                                  + "origen y depositado en la cuenta destino es " + montoRetiro
                                  + "colones.\n [El monto cobrado por concepto de comisión a la "
                                  + "cuenta origen fue de "+montoComision+" colones " 
                                  + "que fueron rebajados automáticamente de su saldo actual]");
                            } else {
                              System.out.println("Estimado usuario, la transferencia de fondos se "
                                  + "ejecutó satisfactoriamente.\n El monto retirado de la cuenta "
                                  + "origen y depositado en la cuenta destino es " + montoRetiro
                                  + "colones.\n [El monto cobrado por concepto de comisión a la "
                                  + "cuenta origen fue de 0.00 colones"
                                );    
                            }
                          }    
                        }
                      }
                    }
                  }else {
                    System.out.println("El monto a retirar es mayor que el saldo de la cuenta. "
                        + "Por favor, intente de nuevo.");
                  }  
                }
             } else {
               System.out.println("Monto invalido, ingrese un numero entero");
             }
           }else{
           System.out.println("El PIN ingresado no Coincide con el registrado en la cuenta."
              + " Por favor, intente de nuevo"); 
           }
         }
       }
    } else {
      System.out.println("el numero de cuenta ingresado no existe en la base de datos."
          + " Por favor, intente de nuevo.");
    }
  }
  
  static void consultarTipoCambioCompraDivisaExtranjera(){
    TipoCambioDolar tipoCambio = new TipoCambioDolar();
    Double tipoDeCambioDolar = Double.parseDouble(tipoCambio.getTipoCambioCompra());
    int tipoDeCambioDolarConvertidoAInt = tipoDeCambioDolar.intValue();
      System.out.println("El tipo de cambio del dolar en la compra"
            + " a la fecha : " +LocalDate.now().toString()+" \nes de: " 
            +tipoDeCambioDolarConvertidoAInt +" colones.");
  }
  
  static void consultarTipoCambioVentaDivisaExtranjera(){
    TipoCambioDolar tipoCambio = new TipoCambioDolar();
    Double tipoDeCambioDolar = Double.parseDouble(tipoCambio.getTipoCambioVenta());
    int tipoDeCambioDolarConvertidoAInt = tipoDeCambioDolar.intValue();
      System.out.println("El tipo de cambio del dolar en la venta"
            + " a la fecha : " +LocalDate.now().toString()+" \nes de: " 
            +tipoDeCambioDolarConvertidoAInt +" colones.");
   
  }
  
  /**
   * Metodo consultarSaldoActualCuenta() Consulta el saldo actual de una cuenta en especifico
   * @throws IOException
   * @throws SQLException 
   */
  static void consultarSaldoActualCuenta() throws IOException, SQLException{
    CuentaDAO cuentaDao = new CuentaDAO();
    OperacionesDAO operacionDao = new OperacionesDAO();
    ResultSet rs;
    ResultSet rs2;
    ResultSet rs3;
    System.out.print("\nIngrese el numero de cuenta a consultar: ");
    int pNumeroCuenta = Integer.parseInt(in.readLine());
    rs = cuentaDao.buscarNumeroCuentaCliente(pNumeroCuenta);   
    if (rs.next()){
      if (rs.getInt(1) == pNumeroCuenta){
        System.out.print("\nIngrese el PIN de la cuenta: ");
         String PIN = in.readLine();
         rs2 = cuentaDao.buscarPIN(pNumeroCuenta);
         if (rs2.next()) {
           if (rs2.getString(1).equals(PIN)){
             System.out.println("PIN VALIDADO");
             rs3 = operacionDao.obtenerSaldoCliente(pNumeroCuenta);
             if (rs3.next()){
               System.out.println("Estimado Usuario, el Saldo actual de la cuenta es: "
                   + rs3.getString(1) + " colones");
             }
           } else{
           System.out.println("El PIN ingresado no Coincide con el registrado en la cuenta."
              + " Por favor, intente de nuevo"); 
           }
         }
      }
    } else {
      System.out.println("el numero de cuenta ingresado no existe en la base de datos."
          + " Por favor, intente de nuevo.");
    }
  }
  
  static void consultarSaldoActualCuentaDivisaExtranjera() throws SQLException, IOException{
    CuentaDAO cuentaDao = new CuentaDAO();
    OperacionesDAO operacionDao = new OperacionesDAO();
    TipoCambioDolar tipoCambio = new TipoCambioDolar();
    ResultSet rs;
    ResultSet rs2;
    ResultSet rs3;
    System.out.print("\nIngrese el numero de cuenta a consultar: ");
    int pNumeroCuenta = Integer.parseInt(in.readLine());
    rs = cuentaDao.buscarNumeroCuentaCliente(pNumeroCuenta);   
    if (rs.next()){
      if (rs.getInt(1) == pNumeroCuenta){
        System.out.print("\nIngrese el PIN de la cuenta: ");
         String PIN = in.readLine();
         rs2 = cuentaDao.buscarPIN(pNumeroCuenta);
         if (rs2.next()) {
           if (rs2.getString(1).equals(PIN)){
             System.out.println("PIN VALIDADO");
             Double tipoDeCambioDolar = Double.parseDouble(tipoCambio.getTipoCambioVenta());
             int tipoDeCambioDolarConvertidoAInt = tipoDeCambioDolar.intValue();
             rs3 = operacionDao.obtenerSaldoCliente(pNumeroCuenta);
             if (rs3.next()){
               System.out.println("Estimado Usuario, el Saldo actual de la cuenta es: "
                   + (rs3.getInt(1)/tipoDeCambioDolarConvertidoAInt) + " dolares");
             }
           } else{
           System.out.println("El PIN ingresado no Coincide con el registrado en la cuenta."
              + " Por favor, intente de nuevo"); 
           }
         }
      }
    } else {
      System.out.println("el numero de cuenta ingresado no existe en la base de datos."
          + " Por favor, intente de nuevo.");
    }
  }
  /**
   * Metodo consultarEstadoCuenta() Consulta el estado de una cuenta en especifico
   * @throws IOException
   * @throws SQLException 
   */
  static void consultarEstadoCuenta() throws IOException, SQLException{
    CuentaDAO cuentaDao = new CuentaDAO();
    ResultSet rs;
    ResultSet rs2;
    ResultSet rs3;
    System.out.print("\nIngrese el numero de cuenta a consultar: ");
    int pNumeroCuenta = Integer.parseInt(in.readLine());
    rs = cuentaDao.buscarNumeroCuentaCliente(pNumeroCuenta); 
    if (rs.next()){
      if (rs.getInt(1) == pNumeroCuenta){
        System.out.print("\nIngrese el PIN de la cuenta: ");
        String PIN = in.readLine();
        rs2 = cuentaDao.buscarPIN(pNumeroCuenta);
        if (rs2.next()) {
          if (rs2.getString(1).equals(PIN)){
            System.out.println("PIN VALIDADO\n");
            rs3 = cuentaDao.consultarEstadoCuenta(pNumeroCuenta);
            while (rs3.next()){
              String numeroCuenta = encriptacion.Encriptado.codificarNumeros(rs3.getString(1));
              String primerApellido = rs3.getString(2);
              String segundoApellido =  rs3.getString(3);
              String nombre = rs3.getString(4);
              String fechaCreacion = rs3.getString(5);
              String saldo = encriptacion.Encriptado.codificarNumeros(rs3.getString(6));
              String estadoCuenta = rs3.getString(7); 
          
              System.out.println("Numero de cuenta: " +numeroCuenta + "\n"
                  + "Primer Apellido: " + primerApellido + "\n"
                  + "Segundo Apellido: "+ segundoApellido + "\n"
                  + "Nombre: " + nombre + "\n"
                  + "Fecha de Creacion: " + fechaCreacion + "\n"
                  + "Saldo: " + saldo + "\n"
                  + "Estado de la cuenta: "+estadoCuenta
                );
            }
          } else{
           System.out.println("El PIN ingresado no Coincide con el registrado en la cuenta."
              + " Por favor, intente de nuevo"); 
           }
        }
      }
    } else {
      System.out.println("el numero de cuenta ingresado no existe en la base de datos."
          + " Por favor, intente de nuevo.");
    }
  }
  
  static void consultarEstadoCuentaDivisaExtranjera() throws SQLException, IOException{
    CuentaDAO cuentaDao = new CuentaDAO();
    TipoCambioDolar tipoCambio = new TipoCambioDolar();
    ResultSet rs;
    ResultSet rs2;
    ResultSet rs3;
    System.out.print("\nIngrese el numero de cuenta a consultar: ");
    int pNumeroCuenta = Integer.parseInt(in.readLine());
    rs = cuentaDao.buscarNumeroCuentaCliente(pNumeroCuenta); 
    if (rs.next()){
      if (rs.getInt(1) == pNumeroCuenta){
        System.out.print("\nIngrese el PIN de la cuenta: ");
        String PIN = in.readLine();
        rs2 = cuentaDao.buscarPIN(pNumeroCuenta);
        if (rs2.next()) {
          if (rs2.getString(1).equals(PIN)){
            System.out.println("PIN VALIDADO\n");
            rs3 = cuentaDao.consultarEstadoCuenta(pNumeroCuenta);
            Double tipoDeCambioDolar = Double.parseDouble(tipoCambio.getTipoCambioVenta());
            int tipoDeCambioDolarConvertidoAInt = tipoDeCambioDolar.intValue();

            while (rs3.next()){
              String numeroCuenta = encriptacion.Encriptado.codificarNumeros(rs3.getString(1));
              String primerApellido = rs3.getString(2);
              String segundoApellido =  rs3.getString(3);
              String nombre = rs3.getString(4);
              String fechaCreacion = rs3.getString(5);
              int saldo = (rs3.getInt(6)/tipoDeCambioDolarConvertidoAInt);
              String estadoCuenta = rs3.getString(7); 
          
              System.out.println("Numero de cuenta: " +numeroCuenta + "\n"
                  + "Primer Apellido: " + primerApellido + "\n"
                  + "Segundo Apellido: "+ segundoApellido + "\n"
                  + "Nombre: " + nombre + "\n"
                  + "Fecha de Creacion: " + fechaCreacion + "\n"
                  + "Saldo en Dolares: " + saldo + "\n"
                  + "Estado de la cuenta: "+estadoCuenta
                );
            }
          } else{
           System.out.println("El PIN ingresado no Coincide con el registrado en la cuenta."
              + " Por favor, intente de nuevo"); 
           }
        }
      }
    } else {
      System.out.println("el numero de cuenta ingresado no existe en la base de datos."
          + " Por favor, intente de nuevo.");
    }
  }
  
   /**
   * Metodo consultarEstatusCuenta() Consulta el estatus de una cuenta en especifico
   * @throws IOException
   * @throws SQLException 
   */
  static void consultarEstatusCuenta() throws IOException, SQLException{
    CuentaDAO cuentaDao = new CuentaDAO();
    ResultSet rs;
    ResultSet rs2;
    System.out.print("\nIngrese el numero de cuenta a consultar: ");
    int pNumeroCuenta = Integer.parseInt(in.readLine());
    rs = cuentaDao.buscarNumeroCuentaCliente(pNumeroCuenta);
    if(rs.next()){
       if (rs.getInt(1) == pNumeroCuenta){
         rs2 = cuentaDao.consultarEstatusCuenta(pNumeroCuenta);
         if (rs2.next()){
           System.out.println("Estimado Usuario, el Estatus actual de la cuenta es: "
               + rs2.getString(1) + ".\n");
         }
       }
    } else {
      System.out.println("el numero de cuenta ingresado no existe en la base de datos."
          + " Por favor, intente de nuevo.");
    }
  }
 
  /**
   * Metodo consultarGananciasComisionesTotalizado() consulta las ganancias obtenidas por el
   * cobro de comisiones para todo el universo de cuentas
   * @throws SQLException 
   */
  static void consultarGananciasComisionesTotalizado() throws SQLException{
    OperacionesDAO operacionDao = new OperacionesDAO();
    ResultSet rs;
    ResultSet rs2;
    
    rs = operacionDao.obtenerComisionesTotalesCuentas();
    while (rs.next()){
      String montoComision = rs.getString(1);
      String numeroCuentaComision = rs.getString(2);
      String numeroOperacionComision = rs.getString(3);
      
      System.out.println("Monto de comision: " + montoComision + "\n"
          + "Numero de cuenta a la que se le aplica la comision: " +numeroCuentaComision + "\n"
          + "Numero de Operacion efectuada: " +numeroOperacionComision +"\n");
    }
    rs2 = operacionDao.consultarGananciasComisionesTotalizado();
    if (rs2.next()) {
      System.out.println("Estimado usuario el monto total de ganancias producto del cobro de "
          + "comisiones para todas las cuentas es de " + rs2.getString(1)+ " colones.\n");
    }
  }
  
  /**
   * Metodo consultarGananciasComisionesCuentaParticular() consulta las ganancias obtenidas
   * a partir del cobro de comisiones de una cuenta en especifico
   * @throws IOException
   * @throws SQLException 
   */
  static void consultarGananciasComisionesCuentaParticular() throws IOException, SQLException{
    CuentaDAO cuentaDao = new CuentaDAO();
    OperacionesDAO operacionDao = new OperacionesDAO();
    ResultSet rs;
    ResultSet rs2;
    ResultSet rs3;
    System.out.print("\nIngrese el numero de cuenta a consultar: ");
    int pNumeroCuenta = Integer.parseInt(in.readLine());
    rs = cuentaDao.buscarNumeroCuentaCliente(pNumeroCuenta); 
    if (rs.next()){
      rs2 = operacionDao.obtenerComisionesTotalesCuentaParticular(pNumeroCuenta);
    while (rs2.next()){
      String montoComision = rs2.getString(1);
      String numeroCuentaComision = rs2.getString(2);
      String numeroOperacionComision = rs2.getString(3);
      System.out.println("Monto de comision: " + montoComision + "\n"
          + "Numero de cuenta a la que se le aplica la comision: " +numeroCuentaComision + "\n"
          + "Numero de Operacion efectuada: " +numeroOperacionComision +"\n");   
    }
    rs3 = operacionDao.obtenerGananciasComisionesTotalesCuentaParticular(pNumeroCuenta);
    if (rs3.next()){
      System.out.println("Estimado usuario el monto total de ganancias producto del cobro de "
            + "comisiones para todas las cuentas es de " + rs3.getString(1)+ " colones.\n");
    }
    } else {
      System.out.println("el numero de cuenta ingresado no existe en la base de datos."
          + " Por favor, intente de nuevo.");
    }
  }
}
