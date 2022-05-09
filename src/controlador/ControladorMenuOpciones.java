package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import logicadenegocios.Cliente;
import vista.MenuConsultasAdicionales;
import vista.MenuOpciones;
import vista.RegistrarCliente;

public class ControladorMenuOpciones implements ActionListener{
  public MenuOpciones vista;
  
  public ControladorMenuOpciones(MenuOpciones pVista) {
	  vista = pVista;
	  
	  this.vista.btnRegistrarCliente.addActionListener(this);
          this.vista.btnConsultasAdicionales.addActionListener(this);
  }

@Override
  public void actionPerformed(ActionEvent e) {
	if (e.getSource() == vista.btnRegistrarCliente) {
	      registrarCliente();
	    }
        if (e.getSource() == vista.btnConsultasAdicionales) {
	      mostrarConsultasAdicionales();
	    }
	if (e.getSource() == vista.btnSalir) {
	      System.exit(0);
	      this.vista.setVisible(false);
	    }
  }

  private void registrarCliente() {
    RegistrarCliente registro = new RegistrarCliente();
    Cliente cliente = new Cliente();
    ControladorCliente controlador = new ControladorCliente(registro, cliente);
    controlador.vistaRegistrarCliente.setVisible(true);
    
  }
  
  public void mostrarConsultasAdicionales() {
    MenuConsultasAdicionales menu = new MenuConsultasAdicionales();
    ControladorMenuConsultasAdicionales controlador = new ControladorMenuConsultasAdicionales(menu);
    controlador.vistaConsultasAdicionales.setVisible(true);
  }
}