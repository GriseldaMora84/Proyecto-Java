package carForRent;

import java.sql.Date;

public class Alquiler {
	private String noAlquiler;
	private String inicioAlquiler;
	private String finAlquiler;
	private double costoTotal;
	private Cliente cliente;
	private Vehiculo vehiculo;
	private long idEmpleado;
	private String refPago;
	
	public Alquiler(String noAlquiler, String inicioAlquiler, String finAlquiler,  
			Cliente cliente, Vehiculo vehiculo,
			long idEmpleado, String refPago,double costoTotal) {
		this.noAlquiler=noAlquiler;
		this.inicioAlquiler=inicioAlquiler;
		this.finAlquiler=finAlquiler;
		this.cliente=cliente;
		this.vehiculo=vehiculo;
		this.idEmpleado=idEmpleado;
		this.refPago=refPago;
		this.costoTotal=costoTotal;
	}
	
	public void setFinAlquiler(String finAlquiler) {
		this.finAlquiler=finAlquiler;
	}
	
	public String getNoAqluiler() {
		return noAlquiler;
	}
	
	public String getInicioAqluiler() {
		return inicioAlquiler;
	}
	
	public String getFinAqluiler() {
		return finAlquiler;
	}
	
	public double getCostoTotal() {
		return costoTotal;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	
	public long getIdEmpleado() {
		return idEmpleado;
	}
	
	public String getRefPago() {
		return refPago;
	}
}
