/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadenegocios;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author chava
 */
public class Cuenta {
    
  private int numeroCuenta;
  private String PIN;
  private String fechaCreacion;
  private double saldo = 0;
  private String estado;
  private Cliente duenio;
  private ArrayList<Operacion> operaciones;
  
  
  public Cuenta(int pNumeroCuenta, String pPIN, String pFechaCreacion, double pSaldo, String pEstado, Cliente pDuenio) {
    setNumeroCuenta(pNumeroCuenta);
    setPIN(pPIN);
    setFechaCreacion(pFechaCreacion);
    setSaldo(pSaldo);
    setEstado(pEstado);
    setCliente(pDuenio);
    operaciones = new ArrayList<Operacion>();
  }

    public Cuenta() {
    }
  
  public String calcularTotalComisionDepositoRetiro() {
	return "";
  }
  
  public String calcularTotalComisionDeposito() {
	return "";
  }
  
  public String calcularTotalComisionRetiro() {
    return "";
  }
  
  public void modificarPIN() {
	  
  }
  
  public void agregarOperacion(Date pFecha, String pTipoOperacion, boolean pCargoOperacion, double pMonto) {
    Operacion op = new Operacion(pFecha, pTipoOperacion, pCargoOperacion, pMonto);
    operaciones.add(op);
  }
  
  public int getNumeroCuenta() {
	return numeroCuenta;
  }
  
  public String getPIN() {
    return PIN;
  }
  
  public String getFechaCreacion() {
	return fechaCreacion;
  }
  
  public double getSaldo() {
	return saldo;
  }
  
  public String getEstado() {
    return estado;
  }
  
  public Cliente getCliente() {
	return duenio;
  }
  public void setNumeroCuenta(int pNumeroCuenta) {
    this.numeroCuenta = pNumeroCuenta;
  }
  
  public void setPIN(String pPIN) {
	PIN = pPIN;
  }
  
  public void setFechaCreacion(String pFechaCreacion) {
	this.fechaCreacion = pFechaCreacion;
  }
  
  public void setSaldo(double pSaldo) {
	this.saldo = pSaldo;
  }
  
  public void setEstado(String pEstado) {
	this.estado = pEstado;
  }
  
  public void setCliente(Cliente pDuenio) {
	  this.duenio = pDuenio;
  }
  
  public String toString() {
	  String mensaje = "";
	  mensaje += "\n Numero de cuenta: " + getNumeroCuenta();
	  mensaje += "\n PIN: " +getPIN();
	  mensaje += "\n Fecha de Creacion: " + getFechaCreacion();
	  mensaje += "\n Saldo: " + getSaldo();
	  mensaje += "\n Estado: " + getEstado();
	  mensaje += "\n Duenio: " + getCliente();
	  return mensaje;
  }    
    
}
