package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import carForRent.Vehiculo;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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
	
	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		try {
			InformacionVehiculo dialog = new InformacionVehiculo(1,null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public InformacionVehiculo(int opc,Vehiculo vehiculo ) {
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
				JLabel lblAvisoKilometraje = new JLabel("Km/h");
				lblAvisoKilometraje.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblAvisoKilometraje.setBounds(265, 210, 64, 13);
				contentPanel.add(lblAvisoKilometraje);
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
		
		if(opc==1){
			cbTipo.setModel(new DefaultComboBoxModel(new String[] {"", "VAN", "COMPACTO", "PICK UP"}));
			cbMarca.setModel(new DefaultComboBoxModel(new String[] {"", "NISSAN", "TOYOTA", "FORD", "OTRO"}));
			//Verificar que panel activar
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
		}else{
			cbTipo.setModel(new DefaultComboBoxModel(new String[] {"PICK UP"}));
			cbMarca.setModel(new DefaultComboBoxModel(new String[] { "NISSAN"}));
			txtModelo.setText("aa");
			txtModelo.setEditable(false);
			txtAnio.setText("bb");
			txtAnio.setEditable(false);
			txtNoPlaca.setText("dd");
			txtNoPlaca.setEditable(false);
			txtColor.setText("cc");
			txtColor.setEditable(false);
			txtKilometraje.setText("ff");
			txtKilometraje.setEditable(false);
			txtPrecioRenta.setText("vv");
			txtPrecioRenta.setEditable(false);
			txtEficiencia.setText("uu");
			txtEficiencia.setEditable(false);
			txtPotencia.setText("gg");
			txtPotencia.setEditable(false);
			//Verificar que panel activar
			if(cbTipo.getSelectedItem().equals("VAN")){
				panelVan.setVisible(true);
				txtDimMaleteroVan.setText("ff");
				txtDimMaleteroVan.setEditable(false);
				txtTipoAsiento.setText("ff");
				txtTipoAsiento.setEditable(false);
				txtCapRemolque.setText("ff");
				txtCapRemolque.setEditable(false);
				txtTipoAcceso.setText("ff");
				txtTipoAcceso.setEditable(false);
			}else if(cbTipo.getSelectedItem().equals("COMPACTO")) {
				panelCompacto.setVisible(true);
				txtDimMaletero.setText("ff");
				txtDimMaletero.setEditable(false);
			}else {
				panelPickUp.setVisible(true);
				txtTraccion.setText("ff");
				txtTraccion.setEditable(false);
				txtCabina.setText("ff");
				txtCabina.setEditable(false);
				txtTorque.setText("ff");
				txtTorque.setEditable(false);
				txtCubierta.setText("ff");
				txtCubierta.setEditable(false);
				txtAreaCarga.setText("ff");
				txtAreaCarga.setEditable(false);
			}
		}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(201, 248, 243));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnSig = new JButton("Siguiente");
				btnSig.setActionCommand("OK");
				buttonPane.add(btnSig);
				getRootPane().setDefaultButton(btnSig);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
}
