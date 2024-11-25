package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import carForRent.Control;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class Menu extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPanel = new JPanel();
	private JTextField txtNoEmpleado;
	private JTextField txtUsuario;
	private JTextField txtNombre;
	private java.sql.Connection conexion;//Hace la conexión
	private java.sql.PreparedStatement ps;//Para ejecutar consultas SQL precompiladas y parametrizadas.
	private java.sql.Statement statementSql;//Realizar consultas

public Menu(String noEmpleado,String nombreUsuario) {
	//Inicializar clase control
	Control.inicializa();
	Control.cargarVehiculosDesdeBD();
	
	//Conexion a la base de datos
		try {
			conexion=DriverManager.getConnection("jdbc:mysql://localhost/proyectojava","root" ,"");
			statementSql=conexion.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error de conexión");
		}
		
		setTitle("Menú");
		setBounds(100, 100, 776, 670);
		contentPanel = new JPanel();
		contentPanel.setBackground(new Color(220, 220, 220));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		JMenuBar mbOpciones = new JMenuBar();
		mbOpciones.setForeground(new Color(0, 0, 0));
		mbOpciones.setBackground(new Color(255, 128, 255));
		mbOpciones.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mbOpciones.setBounds(54, 20, 366, 55);
		contentPanel.add(mbOpciones);
		
		JMenu menuInventario = new JMenu("Inventario");
		menuInventario.setBackground(new Color(240, 219, 231));
		menuInventario.setForeground(new Color(0, 0, 0));
		menuInventario.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 16));
		mbOpciones.add(menuInventario);
		
		JMenuItem mntmRegistrarV = new JMenuItem("Registrar vehículo");
		mntmRegistrarV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarVehiculo();
				
			}
		});
		mntmRegistrarV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuInventario.add(mntmRegistrarV);
		
		JMenuItem mntmModificar = new JMenuItem("Modificar");
		mntmModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarInventario();
			}
		});
		mntmModificar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuInventario.add(mntmModificar);
		
		JMenu menuAlquiler = new JMenu("Alquiler");
		menuAlquiler.setForeground(Color.BLACK);
		menuAlquiler.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 16));
		menuAlquiler.setBackground(new Color(201, 248, 243));
		mbOpciones.add(menuAlquiler);
		
		JMenuItem mntmCotizar = new JMenuItem("Cotizar");
		mntmCotizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cotizar();
			}
		});
		mntmCotizar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmCotizar.setBackground(new Color(240, 219, 231));
		menuAlquiler.add(mntmCotizar);
		
		JMenuItem mntmConsultarHistorial = new JMenuItem("Consultar historial");
		mntmConsultarHistorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarHistorial();
			}
		});
		mntmConsultarHistorial.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuAlquiler.add(mntmConsultarHistorial);
		menuAlquiler.setForeground(Color.BLACK);
		
		JMenu menuCliente = new JMenu("Cliente");
		menuCliente.setForeground(Color.BLACK);
		menuCliente.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 16));
		menuCliente.setBackground(new Color(240, 219, 231));
		mbOpciones.add(menuCliente);
		
		JMenuItem mntmRegistrarCliente = new JMenuItem("Registrar cliente");
		mntmRegistrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarCliente();
			}
		});
		mntmRegistrarCliente.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuCliente.add(mntmRegistrarCliente);
		
		JMenuItem mntmActualizarInfo = new JMenuItem("Actualizar información");
		mntmRegistrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarCliente();
			}
		});
		mntmActualizarInfo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuCliente.add(mntmActualizarInfo);
		
		JLabel lblFoto = new JLabel("FOTO");
		lblFoto.setBorder(BorderFactory.createLineBorder(Color.black));
		lblFoto.setBackground(Color.LIGHT_GRAY);
		lblFoto.setOpaque(true);
		lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFoto.setBounds(27, 130, 185, 220);
		contentPanel.add(lblFoto);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsuario.setBounds(250, 198, 134, 48);
		contentPanel.add(lblUsuario);
		
		JLabel lblId = new JLabel("Número de empleado:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblId.setBounds(250, 130, 218, 48);
		contentPanel.add(lblId);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombre.setBounds(250, 256, 134, 48);
		contentPanel.add(lblNombre);
		
		txtNoEmpleado = new JTextField();
		txtNoEmpleado.setEditable(false);
		txtNoEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNoEmpleado.setBounds(472, 137, 169, 31);
		contentPanel.add(txtNoEmpleado);
		txtNoEmpleado.setColumns(10);
		txtNoEmpleado.setText(noEmpleado);
		
		txtUsuario = new JTextField();
		txtUsuario.setEditable(false);
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(472, 198, 169, 31);
		contentPanel.add(txtUsuario);
		txtUsuario.setText(nombreUsuario);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNombre.setColumns(10);
		txtNombre.setBounds(394, 256, 358, 31);
		contentPanel.add(txtNombre);
		ResultSet registroEmpleado;
        try {
        	//Se selecciona todo de la tabla cuentausuario
            String consulta = "SELECT * FROM empleado WHERE id = ?";
            ps = statementSql.getConnection().prepareStatement(consulta);
            ps.setString(1, noEmpleado); //Empieza en la columna 1 de la tabla buscando el número de empleado (parametro de búsqueda)
            registroEmpleado = ps.executeQuery();//Devulve resultado donde noEmpleado coincida

            if (registroEmpleado.next()) {
            	txtNombre.setText(registroEmpleado.getString("nombre"));
            } 
            // Cerrar el ResultSet y PreparedStatement
            registroEmpleado.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(contentPanel, "Error al realizar la consulta: " + e.getMessage());
        }
		
		JLabel lblReloj = new JLabel("reloj");
		lblReloj.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblReloj.setBounds(550, 473, 45, 13);
		contentPanel.add(lblReloj);
		
	}

	public void registrarVehiculo() {
		//1 indica que se hará un registro y null que no hay un vehículo creado aún
		InformacionVehiculo v = new InformacionVehiculo(1,null);
		v.setVisible(true);
	}
	
	public void modificarInventario() {
		BuscarVehiculos v = new BuscarVehiculos();
		v.setVisible(true);
	}
	
	public void cotizar() {
		BuscarVehiculos v=new BuscarVehiculos();
		v.setVisible(true);
	}
	
	public void consultarHistorial() {
		JOptionPane.showMessageDialog(contentPanel, "1");
	}
	
	public void registrarCliente() {
		JOptionPane.showMessageDialog(contentPanel, "1");
	}
	
	public void actualizarCliente() {
		JOptionPane.showMessageDialog(contentPanel, "1");
	}
}
