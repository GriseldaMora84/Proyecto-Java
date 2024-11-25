package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import carForRent.Vehiculo;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;

public class Cotizar extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	
	public Cotizar(Vehiculo vehiculo) {
		setBounds(100, 100, 450, 479);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(150, 241, 232));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblIndicaciones = new JLabel("Llena los siguientes estapacios:");
			lblIndicaciones.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblIndicaciones.setBounds(10, 21, 197, 24);
			contentPanel.add(lblIndicaciones);
		}
		{
			JLabel lblFechaInicio = new JLabel("Fecha de inicio:");
			lblFechaInicio.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblFechaInicio.setBounds(10, 55, 197, 24);
			contentPanel.add(lblFechaInicio);
		}
		
		JComboBox cbDiaI = new JComboBox();
		cbDiaI.setModel(new DefaultComboBoxModel(new String[] {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cbDiaI.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbDiaI.setBounds(10, 89, 48, 21);
		contentPanel.add(cbDiaI);
		
		JComboBox cbMesI = new JComboBox();
		cbMesI.setModel(new DefaultComboBoxModel(new String[] {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		cbMesI.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbMesI.setBounds(68, 89, 139, 21);
		contentPanel.add(cbMesI);
		
		JComboBox cbAnioI = new JComboBox();
		cbAnioI.setModel(new DefaultComboBoxModel(new String[] {"", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032"}));
		cbAnioI.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbAnioI.setBounds(217, 90, 92, 21);
		contentPanel.add(cbAnioI);
		
		JLabel lblFechaFin = new JLabel("Fecha de finalización:");
		lblFechaFin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFechaFin.setBounds(10, 125, 197, 24);
		contentPanel.add(lblFechaFin);
		
		JComboBox cbDiaIF = new JComboBox();
		cbDiaIF.setModel(new DefaultComboBoxModel(new String[] {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cbDiaIF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbDiaIF.setBounds(10, 158, 48, 21);
		contentPanel.add(cbDiaIF);
		
		JComboBox cbMesF = new JComboBox();
		cbMesF.setModel(new DefaultComboBoxModel(new String[] {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		cbMesF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbMesF.setBounds(68, 159, 139, 21);
		contentPanel.add(cbMesF);
		
		JComboBox cbAnioF = new JComboBox();
		cbAnioF.setModel(new DefaultComboBoxModel(new String[] {"", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032"}));
		cbAnioF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbAnioF.setBounds(217, 159, 92, 21);
		contentPanel.add(cbAnioF);
		
		JButton btnCotizar = new JButton("OK");
		btnCotizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCotizar.setActionCommand("OK");
		btnCotizar.setBounds(127, 206, 100, 31);
		contentPanel.add(btnCotizar);
		
		JLabel lblTarifa = new JLabel("Tarifa:");
		lblTarifa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTarifa.setBounds(10, 261, 197, 24);
		contentPanel.add(lblTarifa);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setEditable(false);
		textField.setBounds(127, 266, 122, 31);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JCheckBox chkClienteRegistrado = new JCheckBox("¿El cliente ya está registrado?");
		chkClienteRegistrado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chkClienteRegistrado.setBounds(19, 332, 246, 31);
		contentPanel.add(chkClienteRegistrado);
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
