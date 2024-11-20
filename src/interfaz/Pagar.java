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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Pagar extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtReferencia;
	private JTextField txtTipo;
	private JTextField txtNoTarjeta;
	private JTextField txtCvv;

	public Pagar() {
		setTitle("Procesar pago");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(150, 241, 232));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblReferencia = new JLabel("Referencia:");
			lblReferencia.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblReferencia.setBounds(10, 10, 70, 17);
			contentPanel.add(lblReferencia);
		}
		{
			txtReferencia = new JTextField();
			txtReferencia.setEditable(false);
			txtReferencia.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtReferencia.setBounds(153, 11, 168, 19);
			contentPanel.add(txtReferencia);
			txtReferencia.setColumns(10);
		}
		{
			txtTipo = new JTextField();
			txtTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtTipo.setColumns(10);
			txtTipo.setBounds(153, 44, 168, 19);
			contentPanel.add(txtTipo);
		}
		{
			JLabel lblTipo = new JLabel("Tipo:");
			lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblTipo.setBounds(10, 49, 70, 17);
			contentPanel.add(lblTipo);
		}
		{
			JLabel lblNoTarjeta = new JLabel("No. tarjeta:");
			lblNoTarjeta.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNoTarjeta.setBounds(10, 83, 95, 17);
			contentPanel.add(lblNoTarjeta);
		}
		{
			JLabel lblFecha = new JLabel("Fecha de expiración:");
			lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblFecha.setBounds(10, 117, 138, 17);
			contentPanel.add(lblFecha);
		}
		{
			JLabel lblCvv = new JLabel("CVV:");
			lblCvv.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblCvv.setBounds(10, 144, 95, 17);
			contentPanel.add(lblCvv);
		}
		{
			txtNoTarjeta = new JTextField();
			txtNoTarjeta.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtNoTarjeta.setColumns(10);
			txtNoTarjeta.setBounds(153, 84, 168, 19);
			contentPanel.add(txtNoTarjeta);
		}
		{
			txtCvv = new JTextField();
			txtCvv.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtCvv.setColumns(10);
			txtCvv.setBounds(153, 145, 168, 19);
			contentPanel.add(txtCvv);
		}
		
		JComboBox cbDia = new JComboBox();
		cbDia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbDia.setModel(new DefaultComboBoxModel(new String[] {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		cbDia.setBounds(153, 117, 57, 21);
		contentPanel.add(cbDia);
		
		JComboBox cbMes = new JComboBox();
		cbMes.setModel(new DefaultComboBoxModel(new String[] {"", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036"}));
		cbMes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbMes.setBounds(231, 117, 57, 21);
		contentPanel.add(cbMes);
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
