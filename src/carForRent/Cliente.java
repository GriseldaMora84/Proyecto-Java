package carForRent;

import java.util.ArrayList;

public class Cliente extends Persona{
	private int noCliente;
	private String noLicencia;
	private String fechaExpLicencia;//Fecha de expiracion
	private ArrayList<Alquiler> listaAlquileres;
	
	public Cliente(int noCliente,String noLicencia,String fechaExpLicencia,String nombre, String noCelular, String email) {
		super(nombre, noCelular, email);
		this.noCliente=noCliente;
		this.noLicencia=noLicencia;
		this.fechaExpLicencia=fechaExpLicencia;
		listaAlquileres=new ArrayList<Alquiler>();
	}
	
	public void setNoLicencia(String noLicencia) {
		this.noLicencia=noLicencia;
	}
	
	public void setFechaExpLicencia(String fechaExpLicencia) {
		this.fechaExpLicencia=fechaExpLicencia;
	}
	
	public int getNoCliente() {
		return noCliente;
	}
	
	public String getNoLicencia() {
		return noLicencia;
	}
	
	public String getFechaExpLicencia() {
		return fechaExpLicencia;
	}
	
	public String ingresaAlquiler(Alquiler a) {
		listaAlquileres.add(a);
		return "Venta exitosa";
	}
	
	public ArrayList<Alquiler> getListaAlquileres() {
		return listaAlquileres;
	}

}
