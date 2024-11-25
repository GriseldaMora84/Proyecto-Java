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
import carForRent.Control;
import carForRent.Vehiculo;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JCheckBox;

public class BuscarVehiculos extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JCheckBox chkTipo;
    private JTextField txtTipo;
    private JCheckBox chkMarca;
    private JTextField txtMarca;
    private JCheckBox chkModelo;
    private JTextField txtModelo;
    private JCheckBox chkAnio;
    private JTextField txtAnio;
    private JCheckBox chkColor;
    private JTextField txtColor;
    private JCheckBox chkKilometraje;
    private JTextField txtKilometraje;
    private JCheckBox chkPrecioRenta;
    private JTextField txtPrecioRenta;
    private JCheckBox chkEficiencia;
    private JTextField txtEficiencia;
    private JCheckBox chkPotencia;
    private JTextField txtPotencia;
    private JCheckBox chkPlaca;
    private JTextField txtNoPlaca;
	private JTable tVehiculos;
	private Object scrollPane;
	private java.sql.Connection conexion;//Hace la conexión
	private java.sql.PreparedStatement ps;//Para ejecutar consultas SQL precompiladas y parametrizadas.
	private java.sql.Statement statementSql;//Realizar consultas
	private ArrayList<Vehiculo> vehiculos;

    public BuscarVehiculos(int opc,long noEmpleado) {
    	//Conexion a la base de datos
		try {
			conexion=DriverManager.getConnection("jdbc:mysql://localhost/proyectojava","root" ,"");
			statementSql=conexion.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error de conexión");
		}
		
        setTitle("Buscar Vehículos");
        setBounds(100, 100, 600, 743);
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
        chkTipo = new JCheckBox("Tipo");
        chkTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
        chkTipo.setBackground(new Color(220, 220, 220));
        chkTipo.setBounds(20, 90, 100, 25);
        contentPanel.add(chkTipo);

        txtTipo = new JTextField();
        txtTipo.setBounds(178, 92, 150, 25);
        contentPanel.add(txtTipo);
        txtTipo.setVisible(false);

        chkMarca = new JCheckBox("Marca");
        chkMarca.setFont(new Font("Tahoma", Font.PLAIN, 14));
        chkMarca.setBackground(new Color(220, 220, 220));
        chkMarca.setBounds(20, 130, 100, 25);
        contentPanel.add(chkMarca);

        txtMarca = new JTextField();
        txtMarca.setBounds(178, 127, 150, 25);
        contentPanel.add(txtMarca);
        txtMarca.setVisible(false);

        chkModelo = new JCheckBox("Modelo");
        chkModelo.setFont(new Font("Tahoma", Font.PLAIN, 14));
        chkModelo.setBackground(new Color(220, 220, 220));
        chkModelo.setBounds(20, 170, 100, 25);
        contentPanel.add(chkModelo);

        txtModelo = new JTextField();
        txtModelo.setBounds(178, 172, 150, 25);
        contentPanel.add(txtModelo);
        txtModelo.setVisible(false);

        chkAnio = new JCheckBox("Año");
        chkAnio.setFont(new Font("Tahoma", Font.PLAIN, 14));
        chkAnio.setBackground(new Color(220, 220, 220));
        chkAnio.setBounds(20, 210, 100, 25);
        contentPanel.add(chkAnio);

        txtAnio = new JTextField();
        txtAnio.setBounds(178, 207, 150, 25);
        contentPanel.add(txtAnio);
        txtAnio.setVisible(false);

        chkColor = new JCheckBox("Color");
        chkColor.setFont(new Font("Tahoma", Font.PLAIN, 14));
        chkColor.setBackground(new Color(220, 220, 220));
        chkColor.setBounds(20, 250, 100, 25);
        contentPanel.add(chkColor);

        txtColor = new JTextField();
        txtColor.setBounds(178, 252, 150, 25);
        contentPanel.add(txtColor);
        txtColor.setVisible(false);

        chkKilometraje = new JCheckBox("Kilometraje");
        chkKilometraje.setFont(new Font("Tahoma", Font.PLAIN, 14));
        chkKilometraje.setBackground(new Color(220, 220, 220));
        chkKilometraje.setBounds(20, 290, 100, 25);
        contentPanel.add(chkKilometraje);

        txtKilometraje = new JTextField();
        txtKilometraje.setBounds(178, 287, 150, 25);
        contentPanel.add(txtKilometraje);
        txtKilometraje.setVisible(false);

        chkPrecioRenta = new JCheckBox("Precio de Renta");
        chkPrecioRenta.setFont(new Font("Tahoma", Font.PLAIN, 14));
        chkPrecioRenta.setBackground(new Color(220, 220, 220));
        chkPrecioRenta.setBounds(20, 321, 150, 25);
        contentPanel.add(chkPrecioRenta);

        txtPrecioRenta = new JTextField();
        txtPrecioRenta.setBounds(178, 323, 150, 25);
        contentPanel.add(txtPrecioRenta);
        txtPrecioRenta.setVisible(false);

        chkEficiencia = new JCheckBox("Eficiencia");
        chkEficiencia.setFont(new Font("Tahoma", Font.PLAIN, 14));
        chkEficiencia.setBackground(new Color(220, 220, 220));
        chkEficiencia.setBounds(20, 362, 100, 25);
        contentPanel.add(chkEficiencia);

        txtEficiencia = new JTextField();
        txtEficiencia.setBounds(178, 358, 150, 25);
        contentPanel.add(txtEficiencia);
        txtEficiencia.setVisible(false);

        chkPotencia = new JCheckBox("Potencia");
        chkPotencia.setFont(new Font("Tahoma", Font.PLAIN, 14));
        chkPotencia.setBackground(new Color(220, 220, 220));
        chkPotencia.setBounds(20, 397, 100, 25);
        contentPanel.add(chkPotencia);

        txtPotencia = new JTextField();
        txtPotencia.setBounds(178, 393, 150, 25);
        contentPanel.add(txtPotencia);
        txtPotencia.setVisible(false);
        
        chkPlaca = new JCheckBox("Número de placa");
        chkPlaca.setFont(new Font("Tahoma", Font.PLAIN, 14));
        chkPlaca.setBackground(new Color(220, 220, 220));
        chkPlaca.setBounds(20, 50, 150, 25);
        contentPanel.add(chkPlaca);
        
        txtNoPlaca = new JTextField();
        txtNoPlaca.setBounds(178, 57, 150, 25);
        contentPanel.add(txtNoPlaca);
        txtNoPlaca.setColumns(10);
        txtNoPlaca.setVisible(false);
        
        // Cambiar la visibilidad de txtTipo según si chkTipo está seleccionado o no
        chkPlaca.addActionListener(e -> {
            txtNoPlaca.setVisible(chkPlaca.isSelected());
        });
        
        chkTipo.addActionListener(e -> {
            txtTipo.setVisible(chkTipo.isSelected());
        });
        
        chkMarca.addActionListener(e -> {
            txtMarca.setVisible(chkMarca.isSelected());
        });
        
        chkModelo.addActionListener(e -> {
            txtModelo.setVisible(chkModelo.isSelected());
        });
        
        chkAnio.addActionListener(e -> {
            txtAnio.setVisible(chkAnio.isSelected());
        });
        
        chkColor.addActionListener(e -> {
            txtColor.setVisible(chkColor.isSelected());
        });
        
        chkKilometraje.addActionListener(e -> {
            txtKilometraje.setVisible(chkKilometraje.isSelected());
        });
        
        chkPrecioRenta.addActionListener(e -> {
            txtPrecioRenta.setVisible(chkPrecioRenta.isSelected());
        });
        
        chkEficiencia.addActionListener(e -> {
            txtEficiencia.setVisible(chkEficiencia.isSelected());
        });
        
        chkPotencia.addActionListener(e -> {
            txtPotencia.setVisible(chkPotencia.isSelected());
        });
        
        JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 490, 566, 190);
		contentPanel.add(scrollPane);
		{
			tVehiculos= new JTable();
			tVehiculos.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
							"No. placa", "Modelo", "Marca", "Año","Color", "Precio renta"
					}
					));
			tVehiculos.getColumnModel().getColumn(2).setPreferredWidth(90);
			scrollPane.setViewportView(tVehiculos);
		}

        // Panel de botones
        JPanel buttonPane = new JPanel();
        buttonPane.setBounds(111, 437, 389, 31);
        contentPanel.add(buttonPane);
        buttonPane.setBackground(new Color(220, 220, 220));
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		buscar(opc,noEmpleado);
        	}
        });
        btnBuscar.setActionCommand("OK");
        buttonPane.add(btnBuscar);
        getRootPane().setDefaultButton(btnBuscar);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);

        cancelButton.addActionListener(e -> dispose()); // Cerrar el diálogo al cancelar
    }
    
    public void buscar(int opc,long noEmpleado) {
    	vehiculos=Control.getVehiculos();
	 // Crear una lista temporal para los resultados
	    ArrayList<Vehiculo> vehiculosEncontrados = new ArrayList<Vehiculo>();
	
	    // Iterar sobre el ArrayList de vehículos
	    for (Vehiculo v : vehiculos) {
	        boolean coincide = true;
	
	        // Verificar los criterios seleccionados y filtrar
	        //Se usa contains para búsqueda flexible. 
	        //Si el usuario ingresa solo una parte de la placa (por ejemplo, "ABC"), se verificaría si esa parte existe 
	        //dentro de la placa completa (por ejemplo, "AB123"). 
	        if (chkPlaca.isSelected() && !v.getPlaca().contains(txtNoPlaca.getText())) {
	            coincide = false;  // Si no coincide con la placa, no agregarlo
	        }
	        //Compara dos cadenas de texto para ver si son iguales, ignorando las diferencias de mayúsculas y minúsculas. 
	        if (chkTipo.isSelected() && !v.getTipo().equalsIgnoreCase(txtTipo.getText())) {
	            coincide = false;  // Si no coincide con el tipo, no agregarlo
	        }
	        if (chkMarca.isSelected() && !v.getMarca().equalsIgnoreCase(txtMarca.getText())) {
	            coincide = false;  // Si no coincide con la marca, no agregarlo
	        }
	        if (chkModelo.isSelected() && !v.getModelo().equalsIgnoreCase(txtModelo.getText())) {
	            coincide = false;  // Si no coincide con el modelo, no agregarlo
	        }
	        if (chkAnio.isSelected() && v.getAnio() != Integer.parseInt(txtAnio.getText())) {
	            coincide = false;  // Si no coincide con el año, no agregarlo
	        }
	        if (chkColor.isSelected() && !v.getColor().equalsIgnoreCase(txtColor.getText())) {
	            coincide = false;  // Si no coincide con el color, no agregarlo
	        }
	        if (chkKilometraje.isSelected() && !v.getKilometraje().contains(txtKilometraje.getText())) {
	            coincide = false;  // Si no coincide con el kilometraje, no agregarlo
	        }
	        if (chkPrecioRenta.isSelected() && v.getPrecioRenta() != Double.parseDouble(txtPrecioRenta.getText())) {
	            coincide = false;  // Si no coincide con el precio de renta, no agregarlo
	        }
	        if (chkEficiencia.isSelected() && !v.getEficiencia().equalsIgnoreCase(txtEficiencia.getText())) {
	            coincide = false;  // Si no coincide con la eficiencia, no agregarlo
	        }
	        if (chkPotencia.isSelected() && !v.getPotencia().equalsIgnoreCase(txtPotencia.getText())) {
	            coincide = false;  // Si no coincide con la potencia, no agregarlo
	        }
	        // Si todos los criterios coinciden, agregar el vehículo a la lista de resultados
	        if (coincide) {
	            vehiculosEncontrados.add(v);
	        }
	    }
	
	    // Mostrar los resultados en la tabla
	    actualizarTabla(opc,vehiculosEncontrados,noEmpleado);
	}
	
	public void actualizarTabla(int opc,ArrayList<Vehiculo> vehiculosEncontrados,long noEmpleado) {
	    // Limpiar la tabla antes de agregar nuevos resultados
	    DefaultTableModel model = (DefaultTableModel) tVehiculos.getModel();
	    model.setRowCount(0);  // Limpiar la tabla
	
	    // Agregar los vehículos encontrados a la tabla
	    for (Vehiculo v : vehiculosEncontrados) {
	        model.addRow(new Object[] {
	            v.getPlaca(),
	            v.getModelo(),
	            v.getMarca(),
	            v.getAnio(),
	            v.getColor(),
	            v.getPrecioRenta()
	        });
	    }
	    tVehiculos.setDefaultEditor(Object.class, null);//Evitar que el usuario edite las celdas
		//ya que se agregaron los datos, repintar la tabla
	    tVehiculos.repaint();
	    ListSelectionModel seleccion = 	    tVehiculos.getSelectionModel();

		seleccion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        seleccion.addListSelectionListener(new ListSelectionListener() {    
            public void valueChanged(ListSelectionEvent e) {    
                // Verificar si la selección está ajustada
                if (!e.getValueIsAdjusting()) {
                    int filaSeleccionada = tVehiculos.getSelectedRow();
                    if (filaSeleccionada != -1) {
                    	String placa = (String) tVehiculos.getValueAt(filaSeleccionada, 0);
                    	InformacionVehiculo v =new InformacionVehiculo(opc,Control.getVehiculo(placa),noEmpleado);
                    	v.setVisible(true);
    					try {
							conexion.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
    					dispose();
                    }
                }
            }
        });
	}
}
	
