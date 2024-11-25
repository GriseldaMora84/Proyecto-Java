package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import carForRent.Alquiler;
import carForRent.Cliente;
import carForRent.Control;
import carForRent.Vehiculo;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;

public class Cotizar extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtTarifa;
	private JComboBox cbDiaI;
	private JComboBox cbMesI;
	private JComboBox cbAnioI;
	private JComboBox cbDiaF;
	private JComboBox cbMesF;
	private JComboBox cbAnioF;
	private Alquiler alquiler;
	private JCheckBox chkClienteRegistrado;
	
	public Cotizar(Vehiculo vehiculo, long noEmpleado) {
		setBounds(100, 100, 445, 456);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(220, 220, 220));
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
		
		cbDiaI = new JComboBox();
		cbDiaI.setModel(new DefaultComboBoxModel(new String[] {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cbDiaI.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbDiaI.setBounds(10, 89, 48, 21);
		contentPanel.add(cbDiaI);
		
		cbMesI = new JComboBox();
		cbMesI.setModel(new DefaultComboBoxModel(new String[] {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		cbMesI.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbMesI.setBounds(68, 89, 139, 21);
		contentPanel.add(cbMesI);
		
		cbAnioI = new JComboBox();
		cbAnioI.setModel(new DefaultComboBoxModel(new String[] {"", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032"}));
		cbAnioI.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbAnioI.setBounds(217, 90, 92, 21);
		contentPanel.add(cbAnioI);
		
		JLabel lblFechaFin = new JLabel("Fecha de finalización:");
		lblFechaFin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFechaFin.setBounds(10, 125, 197, 24);
		contentPanel.add(lblFechaFin);
		
		cbDiaF = new JComboBox();
		cbDiaF.setModel(new DefaultComboBoxModel(new String[] {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cbDiaF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbDiaF.setBounds(10, 158, 48, 21);
		contentPanel.add(cbDiaF);
		
		cbMesF = new JComboBox();
		cbMesF.setModel(new DefaultComboBoxModel(new String[] {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		cbMesF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbMesF.setBounds(68, 159, 139, 21);
		contentPanel.add(cbMesF);
		
		cbAnioF = new JComboBox();
		cbAnioF.setModel(new DefaultComboBoxModel(new String[] {"", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032"}));
		cbAnioF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbAnioF.setBounds(217, 159, 92, 21);
		contentPanel.add(cbAnioF);
		
		JButton btnCotizar = new JButton("Cotizar");
		btnCotizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cotizar(vehiculo,noEmpleado);
			}
		});
		btnCotizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCotizar.setActionCommand("OK");
		btnCotizar.setBounds(127, 207, 100, 31);
		contentPanel.add(btnCotizar);
		
		JLabel lblTarifa = new JLabel("Tarifa:");
		lblTarifa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTarifa.setBounds(10, 261, 76, 24);
		contentPanel.add(lblTarifa);
		
		txtTarifa = new JTextField();
		txtTarifa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTarifa.setEditable(false);
		txtTarifa.setBounds(96, 258, 122, 31);
		contentPanel.add(txtTarifa);
		txtTarifa.setColumns(10);
		
		chkClienteRegistrado = new JCheckBox("¿El cliente ya está registrado?");
		chkClienteRegistrado.setBackground(new Color(220, 220, 220));
		chkClienteRegistrado= new JCheckBox("¿El cliente ya está registrado?");
		chkClienteRegistrado.setBackground(new Color(220, 220, 220));
		chkClienteRegistrado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chkClienteRegistrado.setBounds(19, 332, 246, 31);
		contentPanel.add(chkClienteRegistrado);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(220, 220, 220));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!txtTarifa.getText().isEmpty()){
							double tarifa=Double.parseDouble(txtTarifa.getText());
							if(alquiler!=null && tarifa>0) {
								alquilar();
							}
						}
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
	
	public void cotizar(Vehiculo vehiculo,long noEmpleado) {
		String diaInicio=(String) cbDiaI.getSelectedItem();
		String mesInicio=(String) cbMesI.getSelectedItem();
		String anioInicio=(String) cbAnioI.getSelectedItem();
		String diaFin=(String) cbDiaF.getSelectedItem();
		String mesFin=(String) cbMesF.getSelectedItem();
		String anioFin=(String) cbAnioF.getSelectedItem();
		if (diaInicio.isEmpty() || mesInicio.isEmpty() || anioInicio.isEmpty() ||
	            diaFin.isEmpty() || mesFin.isEmpty() || anioFin.isEmpty()) {
			JOptionPane.showMessageDialog(null,"Llenar todas las fechas.");
	    }
		else {
			// Crear objetos LocalDate para las fechas
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        LocalDate fechaInicio = LocalDate.parse(anioInicio + "-" + mesInicio + "-" + diaInicio, formatter);
	        LocalDate fechaFin = LocalDate.parse(anioFin + "-" + mesFin + "-" + diaFin, formatter);
	
	        // Calcular los días entre las fechas
	        long dias = ChronoUnit.DAYS.between(fechaInicio, fechaFin);
	
	        // Validar que la fecha de inicio no sea después de la fecha de fin
	        if (dias < 0) {
	        	JOptionPane.showMessageDialog(null, "La fecha de inicio debe ser anterior a la fecha de fin.");
	        	txtTarifa.setText("0");
	        }
	        else
	        	txtTarifa.setText(String.valueOf(Control.calcularCostoTotal((int)dias,vehiculo)));
		    String fechaInicioS=anioInicio + "-" + mesInicio + "-" + diaInicio;
		    String fechaFinS=anioFin + "-" + mesFin + "-" + diaFin;
		    //Creacion de alquiler provisional
		    alquiler=new Alquiler(String.valueOf( ((Math.random() * 1000) + 1)),fechaInicioS,fechaFinS,
		    		null,vehiculo,noEmpleado,"0",Double.parseDouble(txtTarifa.getText()));
		}
	}
	
	public void alquilar() {
		if(chkClienteRegistrado.isSelected()) {
			BuscarCliente v=new BuscarCliente(3,alquiler);
			v.setVisible(true);
			dispose();
		}
		else {
			Cliente cliente = new Cliente(0, "", "", "", "","");
			InformacionCliente v=new InformacionCliente(4,cliente,alquiler);
			v.setVisible(true);
			dispose();
		}
	}
}
