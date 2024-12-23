package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;

import carForRent.Alquiler;
import carForRent.Control;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Pagar extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtReferencia;
	private JTextField txtTipo;
	private JTextField txtNoTarjeta;
	private JTextField txtCvv;
	private JTextField txtMonto;
	private boolean cvvValido=false;
	private boolean tarjetaValida=false;
	private java.sql.Connection conexion;//Hace la conexión
	private java.sql.PreparedStatement ps;//Para ejecutar consultas SQL precompiladas y parametrizadas.
	private java.sql.Statement statementSql;//Realizar consultas
	

	public Pagar(Alquiler alquiler) {
		//Conexion a la base de datos
		try {
			conexion=DriverManager.getConnection("jdbc:mysql://localhost/proyectojava","root" ,"");
			statementSql=conexion.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error de conexión");
		}
		setTitle("Procesar pago");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(211, 211, 211));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblReferencia = new JLabel("Referencia:");
			lblReferencia.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblReferencia.setBounds(20, 12, 70, 17);
			contentPanel.add(lblReferencia);
		}
		{
			txtReferencia = new JTextField();
			txtReferencia.setEditable(false);
			txtReferencia.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtReferencia.setBounds(136, 11, 168, 23);
			contentPanel.add(txtReferencia);
			txtReferencia.setColumns(10);
			int numero=(int) ((Math.random() * 1000) + 1);
			txtReferencia.setText( String.valueOf(numero));
			alquiler.setReferencia(txtReferencia.getText());
		}
		{
			txtTipo = new JTextField();
			txtTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtTipo.setColumns(10);
			txtTipo.setBounds(136, 44, 168, 21);
			contentPanel.add(txtTipo);
			txtTipo.setText("TARJETA");
		}
		{
			JLabel lblTipo = new JLabel("Tipo:");
			lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblTipo.setBounds(20, 45, 70, 17);
			contentPanel.add(lblTipo);
		}
		{
			JLabel lblNoTarjeta = new JLabel("No. tarjeta:");
			lblNoTarjeta.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNoTarjeta.setBounds(20, 88, 95, 17);
			contentPanel.add(lblNoTarjeta);
		}
		{
			JLabel lblFecha = new JLabel("Fecha de expiración:");
			lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblFecha.setBounds(20, 133, 138, 17);
			contentPanel.add(lblFecha);
		}
		{
			JLabel lblCvv = new JLabel("CVV:");
			lblCvv.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblCvv.setBounds(20, 172, 95, 17);
			contentPanel.add(lblCvv);
		}
		{
			txtNoTarjeta = new JTextField();
			txtNoTarjeta.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtNoTarjeta.setColumns(10);
			txtNoTarjeta.setBounds(136, 85, 168, 23);
			contentPanel.add(txtNoTarjeta);
			
			txtNoTarjeta.addKeyListener(new KeyAdapter() {//Validaación para la tarjeta que sean 16 digitos y solo enteros
				String temp;
				
				@Override
				public void keyTyped(KeyEvent e) {
					char caracter=e.getKeyChar();
					if(((caracter < '0') || (caracter > '9')) && (caracter != '\b') ///*corresponde a BACK_SPACE*  
				        	 && (caracter!='.')   ){		  	 		    	  
							e.consume();  // ignorar el evento de teclado      
						}
					temp=txtNoTarjeta.getText();
				}
				@Override
				public void keyReleased(KeyEvent arg0) {
					//no mayor
					String v=txtNoTarjeta.getText();
					if(v.length()>16) {//La tarjeta debe ser de 16 caracteres
						txtNoTarjeta.setText(temp);
						JOptionPane.showMessageDialog(null, "Numero de tarjeta incorrecto");
					}				
					tarjetaValida=true;

				}
				
			});
		}
		{
			txtCvv = new JTextField();
			txtCvv.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtCvv.setColumns(10);
			txtCvv.setBounds(136, 171, 57, 19);
			contentPanel.add(txtCvv);
			//Validacion para que solo reciba numeros en el CVV y sean 3 digitos
			txtCvv.addKeyListener(new KeyAdapter() {
				String temp;
				@Override
				public void keyTyped(KeyEvent e) {
					char caracter=e.getKeyChar();
					if(((caracter < '0') || (caracter > '9')) && (caracter != '\b') ///*corresponde a BACK_SPACE*  
				        	 && (caracter!='.')   ){		  	 		    	  
							e.consume();  // ignorar el evento de teclado      
						}
					temp=txtCvv.getText();
				}
				@Override
				public void keyReleased(KeyEvent arg0) {
					//no mayor
					String v=txtCvv.getText();
					if(v.length()>3) {//El cvv solo debe ser de 3 caracteres
						txtCvv.setText(temp);
						JOptionPane.showMessageDialog(null, "CVV incorrecto");	
					}
					cvvValido=true;
				}
				
			});
		}
		
		JComboBox cbDia = new JComboBox();
		cbDia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbDia.setModel(new DefaultComboBoxModel(new String[] {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		cbDia.setBounds(158, 131, 63, 21);
		contentPanel.add(cbDia);
		
		JComboBox cbMes = new JComboBox();
		cbMes.setModel(new DefaultComboBoxModel(new String[] {"", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036"}));
		cbMes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbMes.setBounds(235, 131, 57, 21);
		contentPanel.add(cbMes);
		
		JLabel lblPago = new JLabel("Monto:");
		lblPago.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPago.setBounds(20, 201, 95, 17);
		contentPanel.add(lblPago);
		
		txtMonto = new JTextField();
		txtMonto.setEditable(false);
		txtMonto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMonto.setColumns(10);
		txtMonto.setBounds(136, 202, 57, 19);
		txtMonto.setText(String.valueOf(alquiler.getCostoTotal()));
		contentPanel.add(txtMonto);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(147, 112, 219)));
			buttonPane.setBackground(new Color(211, 211, 211));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						aceptar(alquiler);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public void aceptar(Alquiler alquiler) {
		if(tarjetaValida && cvvValido) {
			String consulta = "INSERT INTO alquiler (noAlquiler, inicio, fin, noCliente, idVehiculo, idEmpleado, refPago, costoTotal) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			try {
			    // Actualizar la información del cliente
			    ps = conexion.prepareStatement(consulta);
			    ps.setString(1, alquiler.getNoAqluiler());
			    ps.setString(2, alquiler.getInicioAqluiler());
			    ps.setString(3, alquiler.getFinAqluiler());
			    ps.setInt(4, alquiler.getCliente().getNoCliente());
			    ps.setInt(5, alquiler.getVehiculo().getId());
			    ps.setInt(6, (int) alquiler.getIdEmpleado());
			    ps.setString(7, alquiler.getRefPago());
			    ps.setDouble(8,alquiler.getCostoTotal());
			    ps.executeUpdate();  // Ejecuta la actualización del cliente
			    Control.ingresaAlquiler(alquiler);
			    alquiler.getCliente().ingresaAlquiler(alquiler);
			    alquiler.getVehiculo().ingresaAlquiler(alquiler);
			    Control.getEmpleado(alquiler.getIdEmpleado()).ingresaAlquiler(alquiler);
			    JOptionPane.showMessageDialog(contentPanel, "Alquiler registrado exitosamente");
			    dispose();
			} catch (SQLException e) {
			    e.printStackTrace();
			    JOptionPane.showMessageDialog(contentPanel, "Error al modificar el cliente o registrar el alquiler");
			}
		}
	}
}