package carForRent;

import java.util.ArrayList;

public class Empleado extends Persona{
	private int noEmpleado;
	private ArrayList<Alquiler> listaAlquileres;
	
	
	public Empleado(int noEmpleado, String nombre, String noCelular, String email) {
		super(nombre, noCelular, email);
		this.noEmpleado=noEmpleado;
		listaAlquileres=new ArrayList<Alquiler>();
	}
	
	public int getNoEmpleado() {
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
