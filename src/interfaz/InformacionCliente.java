package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import carForRent.Alquiler;
import carForRent.Cliente;
import carForRent.Control;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class InformacionCliente extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNoCliente;
	private JTextField txtNombre;
	private JTextField txtTel;
	private JTextField txtEmail;
	private JTextField txtNoLic;
	private JTextField txtExpLic;
	private java.sql.Connection conexion;//Hace la conexión
	private java.sql.PreparedStatement ps;//Para ejecutar consultas SQL precompiladas y parametrizadas.
	private java.sql.Statement statementSql;//Realizar consultas
	
	public InformacionCliente(int opc, Cliente cliente,Alquiler alquiler) {
		//Conexion a la base de datos
		try {
			conexion=DriverManager.getConnection("jdbc:mysql://localhost/proyectojava","root" ,"");
			statementSql=conexion.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error de conexión");
		}
		setTitle("Registrar información del cliente");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(220, 220, 220));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblnoC = new JLabel("Número de cliente:");
		lblnoC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblnoC.setBounds(29, 21, 119, 17);
		contentPanel.add(lblnoC);
		
		txtNoCliente = new JTextField();
		txtNoCliente.setEditable(false);
		txtNoCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNoCliente.setBounds(174, 22, 137, 19);
		contentPanel.add(txtNoCliente);
		txtNoCliente.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(29, 52, 84, 17);
		contentPanel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombre.setColumns(10);
		txtNombre.setBounds(174, 51, 137, 19);
		contentPanel.add(txtNombre);
		
		JLabel lblTel = new JLabel("Número de teléfono:");
		lblTel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTel.setBounds(29, 79, 137, 17);
		contentPanel.add(lblTel);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(29, 106, 137, 17);
		contentPanel.add(lblEmail);
		
		txtTel = new JTextField();
		txtTel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTel.setColumns(10);
		txtTel.setBounds(174, 79, 137, 19);
		contentPanel.add(txtTel);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(174, 107, 137, 19);
		contentPanel.add(txtEmail);
		
		JLabel lblNoLicencia = new JLabel("No. licencia:");
		lblNoLicencia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNoLicencia.setBounds(29, 133, 137, 17);
		contentPanel.add(lblNoLicencia);
		
		txtNoLic = new JTextField();
		txtNoLic.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNoLic.setColumns(10);
		txtNoLic.setBounds(174, 134, 137, 19);
		contentPanel.add(txtNoLic);
		
		JLabel lblExpLic = new JLabel("Expiración licencia:");
		lblExpLic.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblExpLic.setBounds(26, 160, 204, 17);
		contentPanel.add(lblExpLic);
		
		txtExpLic = new JTextField();
		txtExpLic.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtExpLic.setColumns(10);
		txtExpLic.setBounds(174, 161, 137, 19);
		contentPanel.add(txtExpLic);
		
		if(opc!=1) {//Si no se va a registrar cliente mostrar su informacion
			txtNoCliente.setText( String.valueOf(cliente.getNoCliente()));
			txtNombre.setText(cliente.getNombre());
			txtTel.setText(cliente.getNoCelular());
			txtEmail.setText(cliente.getEmail());
			txtNoLic.setText(cliente.getNoLicencia());
			txtExpLic.setText(cliente.getFechaExpLicencia());
		}
		else {
			int numero=(int) ((Math.random() * 1000) + 1);
			txtNoCliente.setText( String.valueOf(numero));
		}
		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(new Color(220, 220, 220));
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		{
			JButton btnSiguiente = new JButton("Siguiente");
			btnSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					siguiente(opc, cliente,alquiler);
				}
			});
			btnSiguiente.setActionCommand("OK");
			buttonPane.add(btnSiguiente);
			getRootPane().setDefaultButton(btnSiguiente);
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
	
	public void siguiente(int opc, Cliente cliente,Alquiler alquiler) {
		if(opc==1) {
			int id = Integer.parseInt(txtNoCliente.getText());  // Obtener el ID del cliente
			String nombre = txtNombre.getText();  // Obtener el nombre del cliente
			String noCelular = txtTel.getText();  // Obtener el número de celular
			String email = txtEmail.getText();  // Obtener el correo electrónico
			String noLicencia = txtNoLic.getText();  // Obtener el número de licencia
			String fechaExpLicencia = txtExpLic.getText();  // Obtener la fecha de expiración de la licencia
	
			// Crear un objeto Cliente con los datos obtenidos
			Cliente c = new Cliente(id, noLicencia, fechaExpLicencia, nombre, noCelular, email);
	
			// Insertar el cliente en la base de datos
			String consulta = "INSERT INTO cliente (id, nombre, noCel, email, noLic, expLic) VALUES (?, ?, ?, ?, ?, ?)";
			try {
			    ps = conexion.prepareStatement(consulta);
			    ps.setInt(1, id);
			    ps.setString(2, nombre);
			    ps.setString(3, noCelular);
			    ps.setString(4, email);
			    ps.setString(5, noLicencia);
			    ps.setString(6, fechaExpLicencia);
			    // Ejecuta la actualización (INSERT)
			    ps.executeUpdate();
			    Control.ingresaCliente(c);
			    JOptionPane.showMessageDialog(contentPanel, "Cliente registrado exitosamente");
			} catch (SQLException e) {
			    e.printStackTrace();
			    JOptionPane.showMessageDialog(contentPanel, "Error al registrar cliente: " + e.getMessage());
			}
		}
		else {
			int id = Integer.parseInt(txtNoCliente.getText());  // Obtener el ID del cliente
			String nombre = txtNombre.getText();  // Obtener el nombre del cliente
			String noCelular = txtTel.getText();  // Obtener el número de celular
			String email = txtEmail.getText();  // Obtener el correo electrónico
			String noLicencia = txtNoLic.getText();  // Obtener el número de licencia
			String fechaExpLicencia = txtExpLic.getText();  // Obtener la fecha de expiración de la licencia

			// Actualizar los valores del cliente en base a lo que el usuario haya modificado
			cliente.setNombre(nombre);
			cliente.setNoCelular(noCelular);
			cliente.setEmail(email);
			cliente.setNoLicencia(noLicencia);
			cliente.setFechaExpLicencia(fechaExpLicencia);

			// Actualizar el cliente en la base de datos
			String consulta = "UPDATE cliente SET nombre = ?, noCelular = ?, email = ?, noLicencia = ?, expiracionLic = ? WHERE id = ?";
			try {
			    ps = conexion.prepareStatement(consulta);
			    ps.setString(1, nombre);
			    ps.setString(2, noCelular);
			    ps.setString(3, email);
			    ps.setString(4, noLicencia);
			    ps.setString(5, fechaExpLicencia);
			    ps.setInt(6, id);
			    // Ejecuta la actualización (UPDATE)
			    ps.executeUpdate();
			    if(opc==2){//Solo actualizar info
			    	JOptionPane.showMessageDialog(contentPanel, "Cliente modificado exitosamente");
			    	dispose();
			    }
			    else {//Alquilar vehiculo
			    	Pagar v=new Pagar(alquiler);
			    	v.setVisible(true);
			    	dispose();
			    }
			} catch (SQLException e) {
			    e.printStackTrace();
			    JOptionPane.showMessageDialog(contentPanel, "Error al modificar el cliente");
			}
		}
	}
}
