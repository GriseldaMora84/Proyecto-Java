package carForRent;

public class Compacto extends Vehiculo{
	private String dimMaletero;//Dimensiones del maletero
	
	public Compacto(String dimMaletero,String marca, String modelo, int anio, String placa, String color, 
			String kilometraje, double precioRenta, String eficiencia, String potencia) {
		super(marca,modelo,anio,placa,color,kilometraje,precioRenta,eficiencia,potencia);
		this.dimMaletero=dimMaletero;
	}
	
	public String getDimMaletero() {
		return dimMaletero;
	}
}
