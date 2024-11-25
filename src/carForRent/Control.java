package carForRent;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import interfaz.Menu;

public class Control {
	private static ArrayList<Vehiculo> vehiculos;
	private static java.sql.Connection conexion;//Hace la conexión
	private static java.sql.PreparedStatement ps;//Para ejecutar consultas SQL precompiladas y parametrizadas.
	private static java.sql.Statement statementSql;//Realizar consultas
	
	public static void inicializa() {
		//Conexion a la base de datos
		try {
			conexion=DriverManager.getConnection("jdbc:mysql://localhost/proyectojava","root" ,"");
			statementSql=conexion.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error de conexión");
		}
		vehiculos=new ArrayList<Vehiculo>();
	}
	
	public static void ingresaVehiculo(Vehiculo vehiculo) {//Método para crear clientes
		vehiculos.add(vehiculo);
	}
	
	public static ArrayList<Vehiculo> getVehiculos() {
		return vehiculos;
	}
}
