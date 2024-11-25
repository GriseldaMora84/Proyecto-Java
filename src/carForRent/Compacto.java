package carForRent;

public class Compacto extends Vehiculo{
	private String dimMaletero;//Dimensiones del maletero
	
	public Compacto(String dimMaletero,int id,String marca, String modelo, int anio, String placa, String color, 
			String kilometraje, double precioRenta, String eficiencia, String potencia,String tipo) {
		super(id,marca,modelo,anio,placa,color,kilometraje,precioRenta,eficiencia,potencia,tipo);
		this.dimMaletero=dimMaletero;
	}
	
	public String getDimMaletero() {
		return dimMaletero;
	}

	public void setDimMaletero(String dimMaletero) {
		this.dimMaletero=dimMaletero;
	}
}
