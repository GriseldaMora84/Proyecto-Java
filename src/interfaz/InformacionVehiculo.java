package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import carForRent.Compacto;
import carForRent.Control;
import carForRent.PickUp;
import carForRent.Van;
import carForRent.Vehiculo;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class InformacionVehiculo extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JComboBox cbTipo;
	private JTextField txtMarca;
	private JComboBox cbMarca;
	private JTextField txtAnio;
	private JTextField txtNoPlaca;
	private JTextField txtColor;
	private JTextField txtKilometraje;
	private JTextField txtPrecioRenta;
	private JTextField txtEficiencia;
	private JTextField txtPotencia;
	private JTextField txtModelo;
	private JTextField txtID;
	private JTextField txtDimMaletero;
	private JTextField txtDimMaleteroVan;
	private JTextField txtTipoAsiento;
	private JTextField txtCapRemolque;
	private JTextField txtTipoAcceso;
	private JTextField txtTraccion;
	private JTextField txtCabina;
	private JTextField txtTorque;
	private JTextField txtCubierta;
	private JTextField txtAreaCarga;
	private JPanel panelCBmarcaNueva;
	private JPanel panelCompacto;
	private JPanel panelVan;
	private JPanel panelPickUp;
	private java.sql.Connection conexion;//Hace la conexión
	private java.sql.PreparedStatement ps;//Para ejecutar consultas SQL precompiladas y parametrizadas.
	private java.sql.Statement statementSql;//Realizar consultas
	
	public InformacionVehiculo(int opc,Vehiculo vehiculo ) {
		//Conexion a la base de datos
		try {
			conexion=DriverManager.getConnection("jdbc:mysql://localhost/proyectojava","root" ,"");
			statementSql=conexion.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error de conexión");
		}
		
		setTitle("Información del vehículo");
		setBounds(100, 100, 450, 592);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(150, 241, 232));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblMarca = new JLabel("Marca:");
			lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblMarca.setBounds(42, 71, 64, 17);
			contentPanel.add(lblMarca);
		}
		{
			JLabel lblTipo = new JLabel("Tipo:");
			lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblTipo.setBounds(42, 44, 64, 17);
			contentPanel.add(lblTipo);
		}
		{
			JLabel lblModelo = new JLabel("Modelo:");
			lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblModelo.setBounds(42, 98, 64, 17);
			contentPanel.add(lblModelo);
		}
		{
			JLabel lblAnio = new JLabel("Año:");
			lblAnio.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblAnio.setBounds(42, 125, 64, 17);
			contentPanel.add(lblAnio);
		}
		{
			JLabel lblPlaca = new JLabel("No. placa:");
			lblPlaca.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblPlaca.setBounds(42, 152, 64, 17);
			contentPanel.add(lblPlaca);
		}
		{
			JLabel lblColor = new JLabel("Color:");
			lblColor.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblColor.setBounds(42, 179, 64, 17);
			contentPanel.add(lblColor);
		}
		{
			JLabel lblKilometraje = new JLabel("Kilometraje:");
			lblKilometraje.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblKilometraje.setBounds(42, 213, 75, 17);
			contentPanel.add(lblKilometraje);
		}
		{
			JLabel lblPrecioRenta = new JLabel("Precio de renta:");
			lblPrecioRenta.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblPrecioRenta.setBounds(21, 240, 117, 17);
			contentPanel.add(lblPrecioRenta);
		}
		{
			JLabel lblEficiencia = new JLabel("Eficiencia:");
			lblEficiencia.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEficiencia.setBounds(42, 267, 64, 17);
			contentPanel.add(lblEficiencia);
		}
		{
			JLabel lblPotencia = new JLabel("Potencia:");
			lblPotencia.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblPotencia.setBounds(42, 294, 64, 17);
			contentPanel.add(lblPotencia);
		}
		
		cbTipo = new JComboBox();
		cbTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbTipo.setBounds(125, 42, 130, 21);
		contentPanel.add(cbTipo);
		
		JPanel panelCBmarcaDado = new JPanel();
		panelCBmarcaDado.setBackground(new Color(150, 241, 232));
		panelCBmarcaDado.setBounds(124, 55, 131, 33);
		contentPanel.add(panelCBmarcaDado);
		panelCBmarcaDado.setLayout(null);
		{
			cbMarca = new JComboBox();
			cbMarca.setBounds(0, 10, 130, 21);
			panelCBmarcaDado.add(cbMarca);
			cbMarca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		{
			panelCBmarcaNueva = new JPanel();
			panelCBmarcaNueva.setLayout(null);
			panelCBmarcaNueva.setBackground(new Color(150, 241, 232));
			panelCBmarcaNueva.setBounds(278, 55, 131, 42);
			contentPanel.add(panelCBmarcaNueva);
			{
				txtMarca = new JTextField();
				txtMarca.setBounds(0, 10, 131, 19);
				panelCBmarcaNueva.add(txtMarca);
				txtMarca.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtMarca.setColumns(10);
			}
			{
				txtAnio = new JTextField();
				txtAnio.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtAnio.setColumns(10);
				txtAnio.setBounds(124, 120, 131, 19);
				contentPanel.add(txtAnio);
			}
			{
				txtNoPlaca = new JTextField();
				txtNoPlaca.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtNoPlaca.setColumns(10);
				txtNoPlaca.setBounds(124, 149, 131, 19);
				contentPanel.add(txtNoPlaca);
			}
			{
				txtColor = new JTextField();
				txtColor.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtColor.setColumns(10);
				txtColor.setBounds(124, 178, 131, 19);
				contentPanel.add(txtColor);
			}
			{
				txtKilometraje = new JTextField();
				txtKilometraje.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtKilometraje.setColumns(10);
				txtKilometraje.setBounds(124, 207, 131, 19);
				contentPanel.add(txtKilometraje);
			}
			{
				txtPrecioRenta = new JTextField();
				txtPrecioRenta.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtPrecioRenta.setColumns(10);
				txtPrecioRenta.setBounds(124, 236, 131, 19);
				contentPanel.add(txtPrecioRenta);
			}
			{
				txtEficiencia = new JTextField();
				txtEficiencia.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtEficiencia.setColumns(10);
				txtEficiencia.setBounds(124, 265, 131, 19);
				contentPanel.add(txtEficiencia);
			}
			{
				txtPotencia = new JTextField();
				txtPotencia.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtPotencia.setColumns(10);
				txtPotencia.setBounds(124, 293, 131, 24);
				contentPanel.add(txtPotencia);
			}
			{
				txtModelo = new JTextField();
				txtModelo.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtModelo.setColumns(10);
				txtModelo.setBounds(125, 97, 131, 19);
				contentPanel.add(txtModelo);
			}
			{
				JLabel lblId = new JLabel("ID:");
				lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblId.setBounds(42, 17, 64, 17);
				contentPanel.add(lblId);
			}
			{
				txtID = new JTextField();
				txtID.setEditable(false);
				txtID.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtID.setColumns(10);
				txtID.setBounds(125, 16, 131, 19);
				contentPanel.add(txtID);
			}
			panelCBmarcaNueva.setVisible(false);
			
			panelCompacto = new JPanel();
			panelCompacto.setBackground(new Color(150, 241, 232));
			panelCompacto.setBounds(21, 327, 405, 54);
			contentPanel.add(panelCompacto);
			panelCompacto.setLayout(null);
			{
				JLabel lblDimMaletero = new JLabel("Dimensión del maletero:");
				lblDimMaletero.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblDimMaletero.setBounds(10, 10, 165, 17);
				panelCompacto.add(lblDimMaletero);
			}
			{
				txtDimMaletero = new JTextField();
				txtDimMaletero.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtDimMaletero.setColumns(10);
				txtDimMaletero.setBounds(179, 11, 131, 19);
				panelCompacto.add(txtDimMaletero);
			}
			panelCompacto.setVisible(false);
			
			panelVan = new JPanel();
			panelVan.setBounds(21, 370, 384, 114);
			contentPanel.add(panelVan);
			panelVan.setBackground(new Color(150, 241, 232));
			panelVan.setLayout(null);
			{
				JLabel lblDimMaletero = new JLabel("Dimensión del maletero:");
				lblDimMaletero.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblDimMaletero.setBounds(10, 10, 165, 17);
				panelVan.add(lblDimMaletero);
			}
			{
				txtDimMaleteroVan = new JTextField();
				txtDimMaleteroVan.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtDimMaleteroVan.setColumns(10);
				txtDimMaleteroVan.setBounds(179, 11, 131, 19);
				panelVan.add(txtDimMaleteroVan);
			}
			{
				JLabel lblTipoAsiento = new JLabel("Tipo de asientos:");
				lblTipoAsiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblTipoAsiento.setBounds(10, 37, 165, 17);
				panelVan.add(lblTipoAsiento);
			}
			{
				txtTipoAsiento = new JTextField();
				txtTipoAsiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtTipoAsiento.setColumns(10);
				txtTipoAsiento.setBounds(179, 38, 131, 19);
				panelVan.add(txtTipoAsiento);
			}
			{
				JLabel lblCapRemolque = new JLabel("Capacidad de remolque:");
				lblCapRemolque.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblCapRemolque.setBounds(10, 64, 165, 17);
				panelVan.add(lblCapRemolque);
			}
			{
				txtCapRemolque = new JTextField();
				txtCapRemolque.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtCapRemolque.setColumns(10);
				txtCapRemolque.setBounds(179, 65, 131, 19);
				panelVan.add(txtCapRemolque);
			}
			{
				JLabel lblTipoAcceso = new JLabel("Tipo de acceso:");
				lblTipoAcceso.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblTipoAcceso.setBounds(10, 91, 165, 17);
				panelVan.add(lblTipoAcceso);
			}
			{
				txtTipoAcceso = new JTextField();
				txtTipoAcceso.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtTipoAcceso.setColumns(10);
				txtTipoAcceso.setBounds(179, 92, 131, 19);
				panelVan.add(txtTipoAcceso);
			}
			panelVan.setVisible(false);
			
			panelPickUp = new JPanel();
			panelPickUp.setBounds(21, 330, 364, 147);
			contentPanel.add(panelPickUp);
			panelPickUp.setLayout(null);
			panelPickUp.setBackground(new Color(150, 241, 232));
			{
				JLabel lblTraccion = new JLabel("Tracción:");
				lblTraccion.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblTraccion.setBounds(10, 10, 165, 17);
				panelPickUp.add(lblTraccion);
			}
			{
				txtTraccion = new JTextField();
				txtTraccion.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtTraccion.setColumns(10);
				txtTraccion.setBounds(179, 11, 131, 19);
				panelPickUp.add(txtTraccion);
			}
			{
				JLabel lblCabina = new JLabel("Cabina:");
				lblCabina.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblCabina.setBounds(10, 37, 165, 17);
				panelPickUp.add(lblCabina);
			}
			{
				txtCabina = new JTextField();
				txtCabina.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtCabina.setColumns(10);
				txtCabina.setBounds(179, 38, 131, 19);
				panelPickUp.add(txtCabina);
			}
			{
				JLabel lblTorque = new JLabel("Torque:");
				lblTorque.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblTorque.setBounds(10, 64, 165, 17);
				panelPickUp.add(lblTorque);
			}
			{
				txtTorque = new JTextField();
				txtTorque.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtTorque.setColumns(10);
				txtTorque.setBounds(179, 65, 131, 19);
				panelPickUp.add(txtTorque);
			}
			{
				JLabel lblCubierta = new JLabel("Cubierta:");
				lblCubierta.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblCubierta.setBounds(10, 91, 165, 17);
				panelPickUp.add(lblCubierta);
			}
			{
				txtCubierta = new JTextField();
				txtCubierta.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtCubierta.setColumns(10);
				txtCubierta.setBounds(179, 92, 131, 19);
				panelPickUp.add(txtCubierta);
			}
			
			JLabel lblAreaCarga = new JLabel("Area de carga:");
			lblAreaCarga.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblAreaCarga.setBounds(10, 116, 165, 17);
			panelPickUp.add(lblAreaCarga);
			
			txtAreaCarga = new JTextField();
			txtAreaCarga.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtAreaCarga.setColumns(10);
			txtAreaCarga.setBounds(179, 117, 131, 19);
			panelPickUp.add(txtAreaCarga);
		}
		panelPickUp.setVisible(false);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(201, 248, 243));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnSig = new JButton("Siguiente");
				btnSig.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						siguiente(opc, vehiculo);
					}
				});
				btnSig.setActionCommand("OK");
				buttonPane.add(btnSig);
				getRootPane().setDefaultButton(btnSig);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		
		//Vericar que panales activar y si los txt estarán activos
		if(opc==1){//Registrar vehiculo
			int numero=(int) ((Math.random() * 1000) + 1);
			txtID.setText(String.valueOf(numero));
			cbTipo.setModel(new DefaultComboBoxModel(new String[] {"", "VAN", "COMPACTO", "PICK UP"}));
			cbMarca.setModel(new DefaultComboBoxModel(new String[] {"", "NISSAN", "TOYOTA", "FORD", "OTRO"}));
			//Verificar que panel activar dependiendo del vehiculo elegido
			cbTipo.addActionListener(e -> {
				if(cbTipo.getSelectedItem().equals("VAN")) {
					panelVan.setVisible(true);
					panelCompacto.setVisible(false);
					panelPickUp.setVisible(false);
				}else if(cbTipo.getSelectedItem().equals("COMPACTO")) {
					panelCompacto.setVisible(true);
					panelPickUp.setVisible(false);
					panelVan.setVisible(false);
				}else if(cbTipo.getSelectedItem().equals("PICK UP")){
					panelPickUp.setVisible(true);
					panelCompacto.setVisible(false);
					panelVan.setVisible(false);
				}else {
					panelCompacto.setVisible(false);
					panelPickUp.setVisible(false);
					panelVan.setVisible(false);
				}
			});
			//Proceso para verificar que se ingresó un double
			txtPrecioRenta.addKeyListener(new KeyAdapter() {
				String temp;
				@Override			
				public void keyTyped(KeyEvent e) {
					char caracter = e.getKeyChar();
					// Verificar si la tecla pulsada no es un digito
					if(((caracter < '0') || (caracter > '9')) && (caracter != '\b') ///*corresponde a BACK_SPACE*  
			        	 && (caracter!='.')   ){		  	 		    	  
						e.consume();  // ignorar el evento de teclado      
					}
					temp=txtPrecioRenta.getText();
				}
				@Override
				public void keyReleased(KeyEvent arg0) {//Verifcar que se ingrese un double
				  	String v=txtPrecioRenta.getText().trim();
				    	double d;
				    	 try {
				    	  //trata de convertir
				    		  if(!v.equals(""))
				    			  d=Double.parseDouble(v);
				    	  }catch(Exception e) {
				    		  JOptionPane.showMessageDialog(null, "Número incorrecto");
				    		  txtPrecioRenta.setText(temp);
				    	  }
					}
				});
		}else if(opc==2){//Consulta de vehículos
			txtID.setText(String.valueOf(vehiculo.getId()));
			cbTipo.setModel(new DefaultComboBoxModel(new String[] {vehiculo.getTipo()}));
			cbMarca.setModel(new DefaultComboBoxModel(new String[] { vehiculo.getMarca()}));
			txtModelo.setText(vehiculo.getModelo());
			txtModelo.setEditable(false);
			txtAnio.setText(String.valueOf(vehiculo.getAnio()));
			txtAnio.setEditable(false);
			txtNoPlaca.setText(vehiculo.getPlaca());
			txtNoPlaca.setEditable(false);
			txtColor.setText(vehiculo.getColor());
			txtColor.setEditable(false);
			txtKilometraje.setText(vehiculo.getKilometraje());
			txtKilometraje.setEditable(false);
			txtPrecioRenta.setText(String.valueOf(vehiculo.getPrecioRenta()));
			txtPrecioRenta.setEditable(false);
			txtEficiencia.setText(vehiculo.getEficiencia());
			txtEficiencia.setEditable(false);
			txtPotencia.setText(vehiculo.getPotencia());
			txtPotencia.setEditable(false);
			//Verificar que panel activar dependiendo de lo ya registrado
			if(vehiculo instanceof Van){
				Van van = (Van) vehiculo;
				panelVan.setVisible(true);
				txtDimMaleteroVan.setText(van.getDimMaletero());
				txtDimMaleteroVan.setEditable(false);
				txtTipoAsiento.setText(van.getTipoAsientos());
				txtTipoAsiento.setEditable(false);
				txtCapRemolque.setText(van.getCapRemolque());
				txtCapRemolque.setEditable(false);
				txtTipoAcceso.setText(van.getTipo());
				txtTipoAcceso.setEditable(false);
			}else if(vehiculo instanceof Compacto) {
				panelCompacto.setVisible(true);
				Compacto compacto = (Compacto) vehiculo;
				txtDimMaletero.setText(compacto.getDimMaletero());
				txtDimMaletero.setEditable(false);
			}else {
				PickUp pu = (PickUp) vehiculo;
				panelPickUp.setVisible(true);
				txtTraccion.setText(pu.getTraccion());
				txtTraccion.setEditable(false);
				txtCabina.setText(pu.getCabina());
				txtCabina.setEditable(false);
				txtTorque.setText(pu.getTorque());
				txtTorque.setEditable(false);
				txtCubierta.setText(pu.getCubierta());
				txtCubierta.setEditable(false);
				txtAreaCarga.setText(pu.getAreaCarga());
				txtAreaCarga.setEditable(false);
			}
		}else{//Modicación de información
			txtID.setText(String.valueOf(vehiculo.getId()));
			cbTipo.setModel(new DefaultComboBoxModel(new String[] {vehiculo.getTipo()}));
			cbMarca.setModel(new DefaultComboBoxModel(new String[] { vehiculo.getMarca()}));
			txtModelo.setText(vehiculo.getModelo());
			txtAnio.setText(String.valueOf(vehiculo.getAnio()));
			txtNoPlaca.setText(vehiculo.getPlaca());
			txtColor.setText(vehiculo.getColor());
			txtKilometraje.setText(vehiculo.getKilometraje());
			txtPrecioRenta.setText(String.valueOf(vehiculo.getPrecioRenta()));
			txtEficiencia.setText(vehiculo.getEficiencia());
			txtPotencia.setText(vehiculo.getPotencia());
			//Verificar que panel activar dependiendo de lo ya registrado
			if(vehiculo instanceof Van) {
				Van van = (Van) vehiculo;
				txtDimMaleteroVan.setText(van.getDimMaletero());
				txtTipoAsiento.setText(van.getTipoAsientos());
				txtCapRemolque.setText(van.getCapRemolque());
				txtTipoAcceso.setText(van.getTipo());
			}else if(vehiculo instanceof Compacto) {
				Compacto compacto = (Compacto) vehiculo;
				txtDimMaletero.setText(compacto.getDimMaletero());
			}else {
				PickUp pu = (PickUp) vehiculo;
				txtTraccion.setText(pu.getTraccion());
				txtCabina.setText(pu.getCabina());
				txtTorque.setText(pu.getTorque());
				txtCubierta.setText(pu.getCubierta());
				txtAreaCarga.setText(pu.getAreaCarga());
			}
		}
	}
	
	public void siguiente(int opc, Vehiculo vehiculo) {
		if(opc==1) {
			registrar();
		}
		else if(opc==2) {
			consultar(vehiculo);
		}
		else {
			modificar(vehiculo);
		}
	}
	
	public void registrar() {
		int id=Integer.parseInt(txtID.getText());
		String tipo=(String) cbTipo.getSelectedItem();
		String marca=(String) cbTipo.getSelectedItem();
		if(marca.equals("OTRO"))
			marca=txtMarca.getText();
		String modelo=txtModelo.getText();
		int anio=Integer.parseInt(txtAnio.getText());
		String placa=txtNoPlaca.getText();
		String color=txtColor.getText();
		String kilometraje=txtKilometraje.getText();
		double precioRenta=Double.parseDouble(txtPrecioRenta.getText());
		String eficiencia=txtEficiencia.getText();
		String potencia=txtPotencia.getText();
		if(tipo.equals("COMPACTO")) {
			String dimMal=txtDimMaletero.getText();
			Vehiculo vCompacto= new Compacto(dimMal,id,marca,modelo,anio,placa,color,kilometraje,
					precioRenta,eficiencia,potencia,tipo);
			Control.ingresaVehiculo(vCompacto);
			String consulta = "INSERT INTO vehiculocompacto (id, marca, modelo, anio, placa, color, kilometraje, precioRenta, eficiencia, potencia, dimMaletero) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			try {
				ps=conexion.prepareStatement(consulta);
				ps.setInt(1, id);
				ps.setString(2, marca);
			    ps.setString(3, modelo);
			    ps.setInt(4, anio);
			    ps.setString(5, placa);
			    ps.setString(6, color);
			    ps.setString(7, kilometraje);
			    ps.setDouble(8, precioRenta);
			    ps.setString(9, eficiencia);
			    ps.setString(10, potencia);
			    ps.setString(11, dimMal); 
			    // Ejecuta la actualización (INSERT)
			    ps.executeUpdate();
				JOptionPane.showMessageDialog(contentPanel, "Auto registrado exitosamente");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(contentPanel, "Error");
			}
		}
		else if(tipo.equals("VAN")){
			String dimMalVan=txtDimMaleteroVan.getText();
			String tipoAsientos=txtTipoAsiento.getText();
			String capRemolque=txtCapRemolque.getText();
			String tipoAcceso=txtTipoAcceso.getText();
			Vehiculo vVan= new Van(dimMalVan,tipoAsientos,capRemolque,tipoAcceso,id,marca,modelo,anio,placa,color,kilometraje,
					precioRenta,eficiencia,potencia,tipo);
			Control.ingresaVehiculo(vVan);
			String consulta = "INSERT INTO vehiculovan(id, marca, modelo, anio, placa, color, kilometraje, precioRenta, eficiencia, potencia, dimMaletero, tipoAsietos, capRemolque, tipoAcceso) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			try {
				ps=conexion.prepareStatement(consulta);
				ps.setInt(1, id);
				ps.setString(2, marca);
			    ps.setString(3, modelo);
			    ps.setInt(4, anio);
			    ps.setString(5, placa);
			    ps.setString(6, color);
			    ps.setString(7, kilometraje);
			    ps.setDouble(8, precioRenta);
			    ps.setString(9, eficiencia);
			    ps.setString(10, potencia);
			    ps.setString(11, dimMalVan); 
			    ps.setString(12, tipoAsientos);
			    ps.setString(13, capRemolque);
			    ps.setString(14, tipoAcceso);
			    // Ejecuta la actualización (INSERT)
			    ps.executeUpdate();
				JOptionPane.showMessageDialog(contentPanel, "Auto registrado exitosamente");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(contentPanel, "Error");
			}
		}else {
			String traccion=txtTraccion.getText();
			String cabina=txtCabina.getText();
			String torque=txtTorque.getText();
			String cubierta=txtCubierta.getText();
			String areaCarga=txtAreaCarga.getText();
			Vehiculo vPickUp=new PickUp(traccion,cabina,torque,cubierta,areaCarga,id,marca,modelo,anio,placa,color,kilometraje,
					precioRenta,eficiencia,potencia,tipo);
			Control.ingresaVehiculo(vPickUp);
			String consulta = "INSERT INTO vehiculopickup (id, marca, modelo, anio, placa, color, kilometraje, precioRenta, eficiencia, potencia, traccion, cabina, torque, areaCarga) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			try {
				ps=conexion.prepareStatement(consulta);
				ps.setInt(1, id);
				ps.setString(2, marca);
			    ps.setString(3, modelo);
			    ps.setInt(4, anio);
			    ps.setString(5, placa);
			    ps.setString(6, color);
			    ps.setString(7, kilometraje);
			    ps.setDouble(8, precioRenta);
			    ps.setString(9, eficiencia);
			    ps.setString(10, potencia);
			    ps.setString(11, traccion); 
			    ps.setString(12, cabina);
			    ps.setString(13, torque);
			    ps.setString(14, cubierta);
			    ps.setString(15, areaCarga);
			    // Ejecuta la actualización (INSERT)
			    ps.executeUpdate();
				JOptionPane.showMessageDialog(contentPanel, "Auto registrado exitosamente");
				dispose();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(contentPanel, "Error");
			}
		}
	}
	
	public void consultar(Vehiculo vehiculo) {
		Cotizar v = new Cotizar(vehiculo);
		v.setVisible(true);
		dispose();
	}
	
	public void modificar(Vehiculo vehiculo) {
	    int id = Integer.parseInt(txtID.getText());
	    
	    if (vehiculo != null) {
	        // Obtener los nuevos valores del vehículo desde los campos de texto
	        String tipo = (String) cbTipo.getSelectedItem();
	        String marca = (String) cbTipo.getSelectedItem();
	        if (marca.equals("OTRO"))
	            marca = txtMarca.getText();
	        String modelo = txtModelo.getText();
	        int anio = Integer.parseInt(txtAnio.getText());
	        String placa = txtNoPlaca.getText();
	        String color = txtColor.getText();
	        String kilometraje = txtKilometraje.getText();
	        double precioRenta = Double.parseDouble(txtPrecioRenta.getText());
	        String eficiencia = txtEficiencia.getText();
	        String potencia = txtPotencia.getText();

	        // Actualizar los valores del vehículo en base a lo que el usuario haya modificado
	        vehiculo.setMarca(marca);
	        vehiculo.setModelo(modelo);
	        vehiculo.setAnio(anio);
	        vehiculo.setPlaca(placa);
	        vehiculo.setColor(color);
	        vehiculo.setKilometraje(kilometraje);
	        vehiculo.setPrecioRenta(precioRenta);
	        vehiculo.setEficiencia(eficiencia);
	        vehiculo.setPotencia(potencia);

	        // Dependiendo del tipo de vehículo, actualizar también otros atributos específicos
	        if (tipo.equals("COMPACTO")) {
	            String dimMal = txtDimMaletero.getText();
	            //Vehiculo instanciar a compacto para acceder a atributos especificos
	            Compacto vCompacto = (Compacto) vehiculo;
	            vCompacto.setDimMaletero(dimMal);
	            
	            // Actualizar el vehículo en la base de datos
	            String consulta = "UPDATE vehiculocompacto SET marca = ?, modelo = ?, anio = ?, placa = ?, color = ?, kilometraje = ?, precioRenta = ?, eficiencia = ?, potencia = ?, dimMaletero = ? WHERE id = ?";
	            try {
	                ps = conexion.prepareStatement(consulta);
	                ps.setString(1, marca);
	                ps.setString(2, modelo);
	                ps.setInt(3, anio);
	                ps.setString(4, placa);
	                ps.setString(5, color);
	                ps.setString(6, kilometraje);
	                ps.setDouble(7, precioRenta);
	                ps.setString(8, eficiencia);
	                ps.setString(9, potencia);
	                ps.setString(10, dimMal);
	                ps.setInt(11, id);
	                ps.executeUpdate();
	                JOptionPane.showMessageDialog(contentPanel, "Auto modificado exitosamente");
	            } catch (SQLException e) {
	                e.printStackTrace();
	                JOptionPane.showMessageDialog(contentPanel, "Error al modificar el auto");
	            }
	        } else if (tipo.equals("VAN")) {
	            // Similar para el caso "VAN"
	            String dimMalVan = txtDimMaleteroVan.getText();
	            String tipoAsientos = txtTipoAsiento.getText();
	            String capRemolque = txtCapRemolque.getText();
	            String tipoAcceso = txtTipoAcceso.getText();
	            Van vVan = (Van) vehiculo;
	            vVan.setDimMaletero(dimMalVan);
	            vVan.setTipoAsientos(tipoAsientos);
	            vVan.setCapRemolque(capRemolque);
	            vVan.setTipoAcceso(tipoAcceso);

	            String consulta = "UPDATE vehiculovan SET marca = ?, modelo = ?, anio = ?, placa = ?, color = ?, kilometraje = ?, precioRenta = ?, eficiencia = ?, potencia = ?, dimMaletero = ?, tipoAsietos = ?, capRemolque = ?, tipoAcceso = ? WHERE id = ?";
	            try {
	                ps = conexion.prepareStatement(consulta);
	                ps.setString(1, marca);
	                ps.setString(2, modelo);
	                ps.setInt(3, anio);
	                ps.setString(4, placa);
	                ps.setString(5, color);
	                ps.setString(6, kilometraje);
	                ps.setDouble(7, precioRenta);
	                ps.setString(8, eficiencia);
	                ps.setString(9, potencia);
	                ps.setString(10, dimMalVan);
	                ps.setString(11, tipoAsientos);
	                ps.setString(12, capRemolque);
	                ps.setString(13, tipoAcceso);
	                ps.setInt(14, id);
	                ps.executeUpdate();
	                JOptionPane.showMessageDialog(contentPanel, "Van modificada exitosamente");
	            } catch (SQLException e) {
	                e.printStackTrace();
	                JOptionPane.showMessageDialog(contentPanel, "Error al modificar la van");
	            }
	        } else {
	            // Similar para el caso "PICKUP"
	            String traccion = txtTraccion.getText();
	            String cabina = txtCabina.getText();
	            String torque = txtTorque.getText();
	            String cubierta = txtCubierta.getText();
	            String areaCarga = txtAreaCarga.getText();
	            PickUp vPickUp = (PickUp) vehiculo;
	            vPickUp.setTraccion(traccion);
	            vPickUp.setCabina(cabina);
	            vPickUp.setTorque(torque);
	            vPickUp.setCubierta(cubierta);
	            vPickUp.setAreaCarga(areaCarga);

	            String consulta = "UPDATE vehiculopickup SET marca = ?, modelo = ?, anio = ?, placa = ?, color = ?, kilometraje = ?, precioRenta = ?, eficiencia = ?, potencia = ?, traccion = ?, cabina = ?, torque = ?, areaCarga = ? WHERE id = ?";
	            try {
	                ps = conexion.prepareStatement(consulta);
	                ps.setString(1, marca);
	                ps.setString(2, modelo);
	                ps.setInt(3, anio);
	                ps.setString(4, placa);
	                ps.setString(5, color);
	                ps.setString(6, kilometraje);
	                ps.setDouble(7, precioRenta);
	                ps.setString(8, eficiencia);
	                ps.setString(9, potencia);
	                ps.setString(10, traccion);
	                ps.setString(11, cabina);
	                ps.setString(12, torque);
	                ps.setString(13, cubierta);
	                ps.setString(14, areaCarga);
	                ps.setInt(15, id);
	                ps.executeUpdate();
	                JOptionPane.showMessageDialog(contentPanel, "PickUp modificada exitosamente");
	            } catch (SQLException e) {
	                e.printStackTrace();
	                JOptionPane.showMessageDialog(contentPanel, "Error al modificar la PickUp");
	            }
	        }
	    } else {
	        JOptionPane.showMessageDialog(contentPanel, "No se encontró el vehículo con ese ID");
	    }
	}
}
