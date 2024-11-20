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
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class Cotizar extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Cotizar dialog = new Cotizar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Cotizar() {
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
		cbDiaI.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbDiaI.setBounds(10, 89, 48, 21);
		contentPanel.add(cbDiaI);
		
		JComboBox cbMesI = new JComboBox();
		cbMesI.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbMesI.setBounds(68, 89, 139, 21);
		contentPanel.add(cbMesI);
		
		JComboBox cbAnioI = new JComboBox();
		cbAnioI.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbAnioI.setBounds(217, 90, 92, 21);
		contentPanel.add(cbAnioI);
		
		JLabel lblFechaFin = new JLabel("Fecha de inicio:");
		lblFechaFin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFechaFin.setBounds(10, 125, 197, 24);
		contentPanel.add(lblFechaFin);
		
		JComboBox cbDiaIF = new JComboBox();
		cbDiaIF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbDiaIF.setBounds(10, 158, 48, 21);
		contentPanel.add(cbDiaIF);
		
		JComboBox cbMesF = new JComboBox();
		cbMesF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbMesF.setBounds(68, 159, 139, 21);
		contentPanel.add(cbMesF);
		
		JComboBox cbAnioF = new JComboBox();
		cbAnioF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbAnioF.setBounds(217, 159, 92, 21);
		contentPanel.add(cbAnioF);
		
		JButton btnCotizar = new JButton("OK");
		btnCotizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCotizar.setActionCommand("OK");
		btnCotizar.setBounds(127, 206, 100, 31);
		contentPanel.add(btnCotizar);
		
		JLabel lblTarifa = new JLabel("Fecha de inicio:");
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
