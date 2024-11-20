package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class RegistrarCliente extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNoCliente;
	private JTextField txtNombre;
	private JTextField txtTel;
	private JTextField txtEmail;
	private JTextField txtNoLic;
	private JTextField txtExpLic;

	public RegistrarCliente() {
		setTitle("Registrar información del cliente");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(150, 241, 232));
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
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(201, 248, 243));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
