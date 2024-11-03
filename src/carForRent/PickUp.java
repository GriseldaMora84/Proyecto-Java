package carForRent;

public class PickUp extends Vehiculo{
	private String traccion;
	private String cabina;
	private String torque;
	private String cubierta;//Si tiene cubierta el area de carga
	private String areaCarga;//Dimensiones de area de carga
	
	public PickUp(String traccion, String cabina, String torque, String cubierta, String areaCarga, String marca, 
			String modelo, int anio, String placa, String color, String kilometraje, double precioRenta, 
			String eficiencia, String potencia) {
		super(marca,modelo,anio,placa,color,kilometraje,precioRenta,eficiencia,potencia);
		this.traccion=traccion;
		this.cabina=cabina;
		this.torque=torque;
		this.cubierta=cubierta;
		this.areaCarga=areaCarga;
	}
	
	public void setCubierta(String cubierta) {
		this.cubierta=cubierta;
	}
	
	public String getTraccion() {
		return traccion;
	}
	
	public String getCabina() {
		return cabina;
	}
	
	public String getTorque() {
		return torque;
	}
	
	public String getCubierta() {
		return cubierta;
	}
	
	public String getAreaCarga() {
		return areaCarga;
	}

}
