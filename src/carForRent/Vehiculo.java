package carForRent;

import java.util.ArrayList;

public class Vehiculo {
	protected String marca;
	protected String modelo;
	protected int anio;
	protected String placa;
	protected String color;
	protected String kilometraje;
	protected double precioRenta;
	protected String eficiencia;
	protected String potencia;
	protected ArrayList<Alquiler> listaAlquileres;
	
	public Vehiculo(String marca, String modelo, int anio, String placa, String color, String kilometraje,
			double precioRenta, String eficiencia, String potencia) {
		this.marca=marca;
		this.modelo=modelo;
		this.anio=anio;
		this.placa=placa;
		this.color=color;
		this.kilometraje=kilometraje;
		this.precioRenta=precioRenta;
		this.eficiencia=eficiencia;
		this.potencia=potencia;
		listaAlquileres=new ArrayList<Alquiler>();
	}
	
	public void setPlaca(String placa) {
		this.placa=placa;
	}
	
	public void setColor(String color) {
		this.color=color;
	}
	
	public void setKilometraje(String kilometraje) {
		this.kilometraje=kilometraje;
	}
	
	public void setPrecioRenta(double precioRenta) {
		this.precioRenta=precioRenta;
	}
	
	public void setEficiencia(String eficiencia) {
		this.eficiencia=eficiencia;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public int getAnio() {
		return anio;
	}
	
	public String getPlaca() {
		return placa;
	}
	
	public String getColor() {
		return color;
	}
	
	public String getKilometraje() {
		return kilometraje;
	}
	
	public double getPrecioRenta() {
		return precioRenta;
	}
	
	public String getEficiencia() {
		return eficiencia;
	}
	
	public ArrayList<Alquiler> getListaAlquileres() {
		return listaAlquileres;
	}
	
	public String ingresaAlquiler(Alquiler a) {
		listaAlquileres.add(a);
		return "Alquiler ingresado";
	}
}
