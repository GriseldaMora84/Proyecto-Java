package carForRent;

import java.util.ArrayList;

public class Empleado extends Persona{
	private long noEmpleado; 
	private ArrayList<Alquiler> listaAlquileres;
	
	
	public Empleado(long noEmpleado, String nombre, String noCelular, String email) {
		super(nombre, noCelular, email);
		this.noEmpleado=noEmpleado;
		listaAlquileres=new ArrayList<Alquiler>();
	}
	
	public long getNoEmpleado() {
		return noEmpleado;
	}
	
	public String ingresaAlquiler(Alquiler a) {
		listaAlquileres.add(a);
		return "Venta exitosa";
	}
	
	public ArrayList<Alquiler> getListaAlquileres() {
		return listaAlquileres;
	}

}
