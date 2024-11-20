package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class RegistrarVehiculo extends JDialog {

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
	private JTextField txtPotenica;
	private JTextField txtTipo;
	private JTextField txtID;
	
	public RegistrarVehiculo() {
		setTitle("Registrar información del vehículo");
		setBounds(100, 100, 450, 380);
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
		cbTipo.setModel(new DefaultComboBoxModel(new String[] {"", "VAN", "COMPACTO", "PICK UP"}));
		cbTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbTipo.setBounds(125, 69, 130, 21);
		contentPanel.add(cbTipo);
		
		JPanel panelCBmarcaDado = new JPanel();
		panelCBmarcaDado.setBackground(new Color(150, 241, 232));
		panelCBmarcaDado.setBounds(124, 86, 131, 33);
		contentPanel.add(panelCBmarcaDado);
		panelCBmarcaDado.setLayout(null);
		{
			cbMarca = new JComboBox();
			cbMarca.setBounds(0, 10, 130, 21);
			panelCBmarcaDado.add(cbMarca);
			cbMarca.setModel(new DefaultComboBoxModel(new String[] {"", "NISSAN", "TOYOTA", "FORD", "OTRO"}));
			cbMarca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		{
			JPanel panelCBmarcaNueva = new JPanel();
			panelCBmarcaNueva.setLayout(null);
			panelCBmarcaNueva.setBackground(new Color(150, 241, 232));
			panelCBmarcaNueva.setBounds(279, 88, 131, 42);
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
				txtPotenica = new JTextField();
				txtPotenica.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtPotenica.setColumns(10);
				txtPotenica.setBounds(124, 293, 131, 19);
				contentPanel.add(txtPotenica);
			}
			{
				txtTipo = new JTextField();
				txtTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtTipo.setColumns(10);
				txtTipo.setBounds(124, 45, 131, 19);
				contentPanel.add(txtTipo);
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
