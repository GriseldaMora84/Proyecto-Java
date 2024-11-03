package carForRent;

public class Pago {
	private String referencia;
	private long noTarjeta;
	private int mesExpiracion;
	private int anioExpiracion;
	private int cvv;
	private String fechaPago;
	private Alquiler alquiler;
	
	public Pago(String referencia,long noTarjeta,int mesExpiracion,int anioExpiracion,String fechaPago,Alquiler alquiler) {
		this.referencia=referencia;
		this.noTarjeta=noTarjeta;
		this.mesExpiracion=mesExpiracion;
		this.anioExpiracion=anioExpiracion;
		this.fechaPago=fechaPago;
		this.alquiler=alquiler;
	}
	
	public String referencia() {
		return referencia;
	}
	
	public long noTarjeta() {
		return noTarjeta;
	}
	
	public int mesExpiracion() {
		return mesExpiracion;
	}
	
	public int anioExpiracion() {
		return anioExpiracion;
	}
	
	public int getCvv() {
		return cvv;
	}
	
	public String getFechaPago() {
		return fechaPago;
	}
	
	public Alquiler getAlquiler() {
		return alquiler;
	}
}
