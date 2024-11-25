package carForRent;

public class Van extends Vehiculo{
	private String dimMaletero;//Dimensiones del maletero
	private String tipoAsientos;
	private String capRemolque;//Capacidad del remolque
	private String tipoAcceso;
	
	public Van(String dimMaletero, String tipoAsientos, String capRemolque, String tipoAcceso, int id,String marca, 
			String modelo, int anio, String placa, String color, String kilometraje, double precioRenta, 
			String eficiencia, String potencia,String tipo) {
		super(id,marca,modelo,anio,placa,color,kilometraje,precioRenta,eficiencia,potencia,tipo);
		this.dimMaletero=dimMaletero;
		this.tipoAsientos=tipoAsientos;
		this.capRemolque=capRemolque;
		this.tipoAcceso=tipoAcceso;
	}
	
	public String getDimMaletero() {
		return dimMaletero;
	}
	
	public String getTipoAsientos() {
		return tipoAsientos;
	}
	
	public String getCapRemolque() {
		return capRemolque;
	}
	
	public String getTipoAcceso() {
		return tipoAcceso;
	}

	public void setDimMaletero(String dimMaltero) {
		this.dimMaletero=dimMaletero;
		
	}

	public void setTipoAsientos(String tipoAsientos) {
		this.tipoAsientos=tipoAsientos;
	}

	public void setCapRemolque(String capRemolque) {
		this.capRemolque=capRemolque;
	}

	public void setTipoAcceso(String tipoAcceso) {
		this.tipoAcceso=tipoAcceso;
	}
}
