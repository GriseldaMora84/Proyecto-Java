package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import carForRent.Alquiler;
import carForRent.Control;
import carForRent.Vehiculo;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JCheckBox;

public class BuscarAlquiler extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JCheckBox chkCliente;
    private JTextField txtCliente;
    private JCheckBox chkEmpleado;
    private JTextField txtEmpleado;
    private JCheckBox chkPlaca;
    private JTextField txtNoPlaca;
    private JTable tAlquileres;
	private ArrayList<Alquiler> alquileres;

    public BuscarAlquiler() {
        setTitle("Buscar Alquiler");
        setBounds(100, 100, 600, 600);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(new Color(220, 220, 220));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel lblOpc = new JLabel("Escoge criterios de búsqueda:");
        lblOpc.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblOpc.setBounds(10, 10, 250, 20);
        contentPanel.add(lblOpc);

        // Crear y posicionar los componentes
        chkCliente = new JCheckBox("Nombre de Cliente");
        chkCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
        chkCliente.setBackground(new Color(220, 220, 220));
        chkCliente.setBounds(20, 50, 150, 25);
        contentPanel.add(chkCliente);

        txtCliente = new JTextField();
        txtCliente.setBounds(217, 50, 150, 25);
        contentPanel.add(txtCliente);
        txtCliente.setVisible(false);

        chkEmpleado = new JCheckBox("Nombre de Empleado");
        chkEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 14));
        chkEmpleado.setBackground(new Color(220, 220, 220));
        chkEmpleado.setBounds(20, 90, 173, 25);
        contentPanel.add(chkEmpleado);

        txtEmpleado = new JTextField();
        txtEmpleado.setBounds(217, 90, 150, 25);
        contentPanel.add(txtEmpleado);
        txtEmpleado.setVisible(false);

        chkPlaca = new JCheckBox("Número de Placa");
        chkPlaca.setFont(new Font("Tahoma", Font.PLAIN, 14));
        chkPlaca.setBackground(new Color(220, 220, 220));
        chkPlaca.setBounds(20, 130, 150, 25);
        contentPanel.add(chkPlaca);

        txtNoPlaca = new JTextField();
        txtNoPlaca.setBounds(217, 130, 150, 25);
        contentPanel.add(txtNoPlaca);
        txtNoPlaca.setVisible(false);

        // Cambiar la visibilidad de los campos de texto según si el checkbox está seleccionado
        chkCliente.addActionListener(e -> txtCliente.setVisible(chkCliente.isSelected()));
        chkEmpleado.addActionListener(e -> txtEmpleado.setVisible(chkEmpleado.isSelected()));
        chkPlaca.addActionListener(e -> txtNoPlaca.setVisible(chkPlaca.isSelected()));

        // Crear tabla para mostrar los resultados de la búsqueda
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 253, 566, 300);
        contentPanel.add(scrollPane);

        tAlquileres = new JTable();
        tAlquileres.setModel(new DefaultTableModel(
                new Object[][] {},
                new String[] { "Cliente", "Empleado", "No. Placa", "Fecha de inicio", "Fecha fin", "Precio Renta" }
        ));
        scrollPane.setViewportView(tAlquileres);

        // Panel de botones
        JPanel buttonPane = new JPanel();
        buttonPane.setBounds(100, 194, 389, 31);
        contentPanel.add(buttonPane);
        buttonPane.setBackground(new Color(220, 220, 220));
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton okButton = new JButton("Buscar");
        okButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        okButton.setActionCommand("Buscar");
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        cancelButton.setActionCommand("Cancelar");
        buttonPane.add(cancelButton);

        cancelButton.addActionListener(e -> dispose()); // Cerrar el diálogo al cancelar.

        // Acción de búsqueda (se pueden agregar filtros según los campos seleccionados)
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	buscar();
            }
        });
    }
    
    public void buscar() {
    	alquileres=Control.getAlquileres();
   	 // Crear una lista temporal para los resultados
   	    ArrayList<Alquiler> alquileresEncontrados = new ArrayList<Alquiler>();
   	
   	    // Iterar sobre el ArrayList de vehículos
   	    for (Alquiler a : alquileres) {
   	        boolean coincide = true;
	    	if (chkCliente.isSelected() && !a.getCliente().getNombre().contains(txtCliente.getText())) {
	            coincide = false;  // Si no coincide con la placa, no agregarlo
	        }
	        //Compara dos cadenas de texto para ver si son iguales, ignorando las diferencias de mayúsculas y minúsculas. 
	        if (chkEmpleado.isSelected() && !(a.getIdEmpleado()==Long.parseLong(txtEmpleado.getText()))) {
	            coincide = false;  // Si no coincide con el tipo, no agregarlo
	        }
	        if (chkPlaca.isSelected() && !a.getVehiculo().getPlaca().equalsIgnoreCase(txtNoPlaca.getText())) {
	            coincide = false;  // Si no coincide con la marca, no agregarlo
	        }
	        // Si todos los criterios coinciden, agregar el alquiler a la lista de resultados
	        if (coincide) {
	            alquileresEncontrados.add(a);
	        }
	        actualizarTabla(alquileresEncontrados);
   	    }
    }
    
    public void actualizarTabla(ArrayList<Alquiler> alquileresEncontrados) {
    	// Limpiar la tabla antes de agregar nuevos resultados
	    DefaultTableModel model = (DefaultTableModel) tAlquileres.getModel();
	    model.setRowCount(0);  // Limpiar la tabla
	
	    // Agregar los vehículos encontrados a la tabla
	    for (Alquiler a : alquileresEncontrados) {
	        model.addRow(new Object[] {
	            a.getCliente().getNoCliente(),
	            a.getIdEmpleado(),
	            a.getVehiculo().getPlaca(),
	            a.getInicioAqluiler(),
	            a.getFinAqluiler(),
	            a.getCostoTotal()
	        });
	    }
	    tAlquileres.setDefaultEditor(Object.class, null);//Evitar que el usuario edite las celdas
		//ya que se agregaron los datos, repintar la tabla
	    tAlquileres.repaint();
    }
}