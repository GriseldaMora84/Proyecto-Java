package carForRent;

public class Persona {
	protected String nombre;
	protected String noCelular;
	protected String email;
	
	public Persona(String nombre, String noCelular, String email) {
		this.nombre=nombre;
		this.noCelular=noCelular;
		this.email=email;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public void setNoCelular(String noCelular) {
		this.noCelular=noCelular;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getNoCelular() {
		return noCelular;
	}
	
	public String getEmail() {
		return email;
	}
}
