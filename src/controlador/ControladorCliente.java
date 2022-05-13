package controlador;

import conexion.Conexion;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.ClienteDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import logicadenegocios.Cliente;
import validaciones.Validaciones;
import vista.ConsultarClientesOrdenados;
import vista.ConsultarInformacionClienteCuentas;
import vista.RegistrarCliente;

public class ControladorCliente implements ActionListener {
  Conexion conexion;
  public ResultSet rs;
  public JTable tabla;
  public RegistrarCliente vistaRegistrarCliente = new RegistrarCliente();
  public ConsultarClientesOrdenados vistaConsultarClientesOrdenados = new ConsultarClientesOrdenados();
  public ConsultarInformacionClienteCuentas vistaConsultarInformacionClienteCuentas = 
          new ConsultarInformacionClienteCuentas();
  public Cliente cliente;
  public ClienteDAO clienteDao;
  
  public ControladorCliente(RegistrarCliente pVistaRegistroCliente, Cliente pCliente) {
    vistaRegistrarCliente = pVistaRegistroCliente;
    cliente = pCliente;
    clienteDao = new ClienteDAO();
	        
    this.vistaRegistrarCliente.btnRegistrarCliente.addActionListener(this);
    this.vistaRegistrarCliente.btnVolver.addActionListener(this);
    this.vistaRegistrarCliente.btnLimpiar.addActionListener(this);
  }
  public ControladorCliente(ConsultarClientesOrdenados pVistaConsultarClientesOrdenados, 
          ClienteDAO pModelo) {
    vistaConsultarClientesOrdenados = pVistaConsultarClientesOrdenados;
    clienteDao = pModelo;

    this.vistaConsultarClientesOrdenados.btnVolver.addActionListener(this);
  }
  public ControladorCliente(ConsultarInformacionClienteCuentas pVistaConsultarInformacionClienteCuentas, 
          ClienteDAO pModelo) {
    vistaConsultarInformacionClienteCuentas = pVistaConsultarInformacionClienteCuentas;
    clienteDao = pModelo;

    this.vistaConsultarInformacionClienteCuentas.btnBuscar.addActionListener(this);
    this.vistaConsultarInformacionClienteCuentas.btnVolver.addActionListener(this);
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == vistaRegistrarCliente.btnRegistrarCliente) {
      registrarCliente();
    }
    if (e.getSource() == vistaConsultarInformacionClienteCuentas.btnBuscar){
        consultarInformacionClienteParticular();
    }
    if (e.getSource() == vistaRegistrarCliente.btnLimpiar) {
      limpiarCampos();
    }
    if (e.getSource() == vistaRegistrarCliente.btnVolver) {
      this.vistaRegistrarCliente.setVisible(false);
    }
    if (e.getSource() == vistaConsultarClientesOrdenados.btnVolver){
      this.vistaConsultarClientesOrdenados.setVisible(false);
    }
    if (e.getSource() == vistaConsultarInformacionClienteCuentas.btnVolver){
      this.vistaConsultarInformacionClienteCuentas.setVisible(false);
    }
  }
  	
  public void registrarCliente() {
    try{
      String primerApellido = vistaRegistrarCliente.txtPrimerApellido.getText();
      String segundoApellido =  vistaRegistrarCliente.txtSegundoApellido.getText();
      String nombre = vistaRegistrarCliente.txtNombre.getText();
      String identificacion = vistaRegistrarCliente.txtIdentificacion.getText();
      String fechaNacimiento = vistaRegistrarCliente.txtFechaNacimiento.getText();
      String numeroTelefonico = vistaRegistrarCliente.txtNumeroTelefonico.getText();
      String correoElectronico = vistaRegistrarCliente.txtCorreoElectronico.getText();
      if (Validaciones.validarFormatoCorreoElectronico(correoElectronico) == true && 
              Validaciones.obtenerFechaFormateada(fechaNacimiento) == true &&
              Validaciones.validarFormatoNumeroTelefonico(numeroTelefonico)) {
               
        clienteDao.registrarCliente(primerApellido, segundoApellido, nombre, identificacion,
        fechaNacimiento, numeroTelefonico, correoElectronico);
        JOptionPane.showMessageDialog(vistaRegistrarCliente, "Se ha creado un nuevo cliente"
                + " en el sistema, los datos que fueron almacenados son: "
	     	+ "\n Nombre: "+ primerApellido+ " " + segundoApellido + " " 
	      	+ nombre + "\n Identificacion:" + identificacion + "\n Fecha Nacimiento: " 
		+ fechaNacimiento + "\n Numero Telefonico: " +numeroTelefonico
	    	+ "\n Correo Electronico: " + correoElectronico);
      } else {
        JOptionPane.showMessageDialog(vistaRegistrarCliente, "ERROR: Por favor ingrese"
                + " correctamente los datos segun el formato que se pide.");
        }
                  
	     
	       
    } catch (HeadlessException | IOException ex) {
        Logger.getLogger(ControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  public void consultarInformacionClienteParticular(){
    String cliente = vistaConsultarInformacionClienteCuentas.cbxClientes.getSelectedItem().
        toString();
    rs = clienteDao.consultarInformacionClienteParticular(cliente);
    DefaultTableModel dfm = new DefaultTableModel();
    tabla = vistaConsultarInformacionClienteCuentas.tablaInformeClienteParticular;
    tabla.setModel(dfm);
    dfm.setColumnIdentifiers(new Object[]{"ID Cliente","Cedula", "Primer Apellido", "Segundo Apellido",
        "Nombre","Fecha Nacimiento", "Numero Telefonico", "Correo Electronico", "Numero de cuenta",
        "Estado de la cuenta"});
    try {
      while (rs.next()) {
        dfm.addRow(new Object[] {rs.getString("Cliente_ID"), rs.getInt("Identificacion"),
        rs.getString("PrimerApellido"),rs.getString("SegundoApellido"), rs.getString("Nombre"),
        rs.getString("FechaNacimiento"), rs.getString("NumTelefonico"), rs.getString("Correo"),
        rs.getInt("Numero_Cuenta"), rs.getString("Estado")});
      }    
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null,ex); 
    }
  }

  public void limpiarCampos() {
    vistaRegistrarCliente.txtPrimerApellido.setText("");
    vistaRegistrarCliente.txtSegundoApellido.setText("");
    vistaRegistrarCliente.txtNombre.setText("");
    vistaRegistrarCliente.txtIdentificacion.setText("");
    vistaRegistrarCliente.txtFechaNacimiento.setText("");
    vistaRegistrarCliente.txtNumeroTelefonico.setText("");
    vistaRegistrarCliente.txtCorreoElectronico.setText("");
  }
}
