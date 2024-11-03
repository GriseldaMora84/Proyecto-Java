package carForRent;

public class CuentaUsuario {
	private String nombreUsuario;
	private String password;
	private long noEmpleado;
	
	public CuentaUsuario(String nombreUsuario, String password,long noEmpleado) {
		this.nombreUsuario=nombreUsuario;
		this.password=password;
		this.noEmpleado=noEmpleado;
	}
	
	public void setPassword(String password) {
		this.password=password;
	}
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public String getPassword() {
		return password;
	}
	
	public long idEmpleado() {
		return noEmpleado;
	}
}
