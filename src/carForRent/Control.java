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
	
	public static void cargarVehiculosDesdeBD() {
        String consulta = "SELECT * FROM vehiculocompacto";
        try (ResultSet ps = statementSql.executeQuery(consulta)) {
            while (ps.next()) {
                Vehiculo v = new Compacto(
                	ps.getString("dimMaletero"),
                    ps.getInt("id"),
                    ps.getString("marca"),
                    ps.getString("modelo"),
                    ps.getInt("anio"),
                    ps.getString("placa"),
                    ps.getString("color"),
                    ps.getString("kilometraje"),
                    ps.getDouble("precioRenta"),
                    ps.getString("eficiencia"),
                    ps.getString("potencia"),
                    "COMPACTO");
                vehiculos.add(v); // Agregar vehículo a la lista
                System.out.print("hola");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar vehículos: " + e.getMessage());
        }
        
        String consulta1 = "SELECT * FROM vehiculovan";
        try (ResultSet ps1 = statementSql.executeQuery(consulta1)) {
            while (ps1.next()) {
                Vehiculo v = new Van(
                	ps1.getString("dimMaletero"),
                	ps1.getString("asientos"),
                	ps1.getString("capRemolque"),
                	ps1.getString("tipoAcceso"),
                    ps1.getInt("id"),
                    ps1.getString("marca"),
                    ps1.getString("modelo"),
                    ps1.getInt("anio"),
                    ps1.getString("placa"),
                    ps1.getString("color"),
                    ps1.getString("kilometraje"),
                    ps1.getDouble("precioRenta"),
                    ps1.getString("eficiencia"),
                    ps1.getString("potencia"),
                    "VAN");
                vehiculos.add(v); // Agregar vehículo a la lista
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar vehículos: " + e.getMessage());
        }
        
        String consulta2 = "SELECT * FROM vehiculopickup";
        try (ResultSet ps2 = statementSql.executeQuery(consulta2)) {
            while (ps2.next()) {
                Vehiculo v = new PickUp(	
                	ps2.getString("traccion"),
                	ps2.getString("cabina"),
                	ps2.getString("torque"),
                	ps2.getString("cubierta"),
                	ps2.getString("areaCarga"),
                    ps2.getInt("id"),
                    ps2.getString("marca"),
                    ps2.getString("modelo"),
                    ps2.getInt("anio"),
                    ps2.getString("placa"),
                    ps2.getString("color"),
                    ps2.getString("kilometraje"),
                    ps2.getDouble("precioRenta"),
                    ps2.getString("eficiencia"),
                    ps2.getString("potencia"),
                    "VAN");
                vehiculos.add(v); // Agregar vehículo a la lista
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar vehículos: " + e.getMessage());
        }
    }
	
	public static Vehiculo getVehiculo(String placa) {
	    for (Vehiculo v : vehiculos) {
	        if (v.getPlaca().equals(placa)) {
	            return v; // Regresar el vehículo si coincide
	        }
	    }
	    // Si no se encuentra regresar null
	    return null;
	}
	
	public static ArrayList<Vehiculo> getVehiculos() {
		return vehiculos;
	}
}
