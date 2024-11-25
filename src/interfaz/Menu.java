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
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import carForRent.Alquiler;
import carForRent.Cliente;
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
	//Variables para el reloj
	private JLabel lblHora;
	private int hora,minutos,segundos;
	private String ampM;


public Menu(String noEmpleado,String nombreUsuario) {
	//Inicializar clase control
	Control.inicializa();
	Control.cargarVehiculosDesdeBD();
	Control.cargarClientesDesdeBD();
	
	//Conexion a la base de datos
	//branch 'master' of https://github.com/GriseldaMora84/Proyecto-Java
		try {
			conexion=DriverManager.getConnection("jdbc:mysql://localhost/proyectojava","root" ,"");
			statementSql=conexion.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error de conexión");
		}

		setTitle("Menú");
		setBounds(100, 100, 776, 601);
		contentPanel = new JPanel();
		contentPanel.setBackground(new Color(220, 220, 220));
		contentPanel.setBorder(null);

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
		menuInventario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mbOpciones.add(menuInventario);

		JMenuItem mntmRegistrarV = new JMenuItem("Registrar vehículo");
		mntmRegistrarV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//registrarVehiculo();

				registrarVehiculo(Long.valueOf(noEmpleado));
				

			}
		});
		mntmRegistrarV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuInventario.add(mntmRegistrarV);

		JMenuItem mntmModificar = new JMenuItem("Modificar");
		mntmModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarInventario(Long.valueOf(noEmpleado));
			}
		});
		mntmModificar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuInventario.add(mntmModificar);

		JMenu menuAlquiler = new JMenu("Alquiler");
		menuAlquiler.setForeground(Color.BLACK);
		menuAlquiler.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuAlquiler.setBackground(new Color(201, 248, 243));
		mbOpciones.add(menuAlquiler);

		JMenuItem mntmCotizar = new JMenuItem("Cotizar");
		mntmCotizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cotizar(Long.parseLong(noEmpleado));
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
		menuCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
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
		mntmActualizarInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarCliente();
			}
		});
		mntmActualizarInfo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuCliente.add(mntmActualizarInfo);

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
		txtNoEmpleado.setBackground(new Color(211, 211, 211));
		txtNoEmpleado.setEditable(false);
		txtNoEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNoEmpleado.setBounds(472, 137, 169, 31);
		contentPanel.add(txtNoEmpleado);
		txtNoEmpleado.setColumns(10);
		txtNoEmpleado.setText(noEmpleado);

		txtUsuario = new JTextField();
		txtUsuario.setBackground(new Color(211, 211, 211));
		txtUsuario.setEditable(false);
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(472, 198, 169, 31);
		contentPanel.add(txtUsuario);
		txtUsuario.setText(nombreUsuario);

		txtNombre = new JTextField();
		txtNombre.setBackground(new Color(211, 211, 211));
		txtNombre.setEditable(false);
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNombre.setColumns(10);
		txtNombre.setBounds(350, 265, 293, 31);
		contentPanel.add(txtNombre);
		ResultSet registroEmpleado;//tipo de dato de java, regresa el resultado de la busqueda en la base de datos
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

		JLabel lblFotoUser = new JLabel("  ");
		lblFotoUser.setIcon(new ImageIcon(Menu.class.getResource("/pictures/perfil128.png")));
		lblFotoUser.setBounds(54, 153, 134, 128);
		contentPanel.add(lblFotoUser);
		
		
		lblHora = new JLabel("Hora:");
		lblHora.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHora.setBounds(647, 20, 105, 31);
		contentPanel.add(lblHora);
		
		JButton btnNewButton = new JButton(" ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login out=new Login();
				out.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(220, 220, 220));
		btnNewButton.setForeground(new Color(245, 245, 245));
		btnNewButton.setIcon(new ImageIcon(Menu.class.getResource("/pictures/logOut.png")));
		btnNewButton.setBounds(664, 494, 59, 36);
		contentPanel.add(btnNewButton);
		reloj();

	}

	public void registrarVehiculo(long noEmpleado) {
		//1 indica que se hará un registro y null que no hay un vehículo creado aún
		InformacionVehiculo v = new InformacionVehiculo(1,null,noEmpleado);
		v.setVisible(true);
		
	}


	public void modificarInventario(long noEmpleado) {
		BuscarVehiculos v = new BuscarVehiculos(3,noEmpleado);
		v.setVisible(true);
	}


	public void cotizar(long noEmpleado) {
		BuscarVehiculos v=new BuscarVehiculos(2,noEmpleado);
		v.setVisible(true);
	}

	public void consultarHistorial() {
		JOptionPane.showMessageDialog(contentPanel, "1");
	}

	public void registrarCliente() {
		Cliente cliente = new Cliente(1, "", "", "", "","");
		Alquiler alquiler=new Alquiler(String.valueOf( ((Math.random() * 1000) + 1)),"","",
	    		null,null,0,"0",0);//como se reutiliza la plantilla 
		InformacionCliente v = new InformacionCliente(1,cliente,alquiler);
		v.setVisible(true);
	}

	public void actualizarCliente() {
		Alquiler alquiler=new Alquiler(String.valueOf( ((Math.random() * 1000) + 1)),"","",
	    		null,null,0,"0",0);
		BuscarCliente v=new BuscarCliente(2,alquiler);
		v.setVisible(true);
	}

	private void reloj() {
		Runnable tarea = ()-> {
			while(true){
				calcula();
				lblHora.setText(hora+":"+minutos+":"+segundos+" "+ampM);
				try {
					Thread.sleep(1000);
				} catch(InterruptedException e) {}
			}
		};
		Thread hilo = new Thread(tarea);
		hilo.start();
	}

	public void calcula() {
		// Obtiene la hora actual del sistema
		GregorianCalendar calendario = new GregorianCalendar();
		hora = calendario.get(GregorianCalendar.HOUR); // Formato 12 horas
		minutos = calendario.get(GregorianCalendar.MINUTE);
		segundos = calendario.get(GregorianCalendar.SECOND);
		//ampm = Integer.toString(calendario.get(GregorianCalendar.AM_PM));
		int ampm=calendario.get(GregorianCalendar.AM_PM);
		if (ampm==1) {
			ampM="PM";
		}else {
			ampM="AM";
		}

	}
}
