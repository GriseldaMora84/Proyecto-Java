package carForRent;

import java.util.ArrayList;

public class Vehiculo {
	protected int id;
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
	protected String tipo;
	
	public Vehiculo(int id,String marca, String modelo, int anio, String placa, String color, String kilometraje,
			double precioRenta, String eficiencia, String potencia,String tipo) {
		this.id=id;
		this.marca=marca;
		this.modelo=modelo;
		this.anio=anio;
		this.placa=placa;
		this.color=color;
		this.kilometraje=kilometraje;
		this.precioRenta=precioRenta;
		this.eficiencia=eficiencia;
		this.potencia=potencia;
		this.tipo=tipo;
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
	
	public int getId() {
		return id;
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
	
	public String getPotencia() {
		return potencia;
	}
	
	public String getEficiencia() {
		return eficiencia;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public ArrayList<Alquiler> getListaAlquileres() {
		return listaAlquileres;
	}
	
	public String ingresaAlquiler(Alquiler a) {
		listaAlquileres.add(a);
		return "Alquiler ingresado";
	}
}
