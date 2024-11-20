package carForRent;

public class Alquiler {
	private String noAlquiler;
	private String inicioAlquiler;
	private String finAlquiler;
	private double costoTotal;
	private Cliente cliente;
	private Vehiculo vehiculo;
	private Pago pago;
	private long idEmpleado;
	private int idCliente;
	private String refPago;
	
	public Alquiler(String noAlquiler, String inicioAlquiler, String finAlquiler,  
			Cliente cliente, Vehiculo vehiculo, Pago pago,
			long idEmpleado, int idCliente, String refPago) {
		this.noAlquiler=noAlquiler;
		this.inicioAlquiler=inicioAlquiler;
		this.finAlquiler=finAlquiler;
		this.cliente=cliente;
		this.vehiculo=vehiculo;
		this.pago=pago;
		this.idEmpleado=idEmpleado;
		this.idCliente=idCliente;
		this.refPago=refPago;
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
	
	public Pago getPago() {
		return pago;
	}
	
	public long getIdEmpleado() {
		return idEmpleado;
	}
	
	public int getIdCliente() {
		return idCliente;
	}
	
	public String getRefPago() {
		return refPago;
	}
	
	public void calcularCostoTotal() {
		double costoAdicional=500;
		costoTotal=costoAdicional+vehiculo.getPrecioRenta();
	}
}
