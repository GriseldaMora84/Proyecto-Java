package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        try {
            BuscarAlquiler dialog = new BuscarAlquiler();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public BuscarAlquiler() {
        setTitle("Buscar Alquiler");
        setBounds(100, 100, 600, 600);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(new Color(150, 241, 232));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel lblOpc = new JLabel("Escoge criterios de búsqueda:");
        lblOpc.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblOpc.setBounds(10, 10, 250, 20);
        contentPanel.add(lblOpc);

        // Crear y posicionar los componentes
        chkCliente = new JCheckBox("Nombre de Cliente");
        chkCliente.setBounds(20, 50, 150, 25);
        contentPanel.add(chkCliente);

        txtCliente = new JTextField();
        txtCliente.setBounds(180, 50, 150, 25);
        contentPanel.add(txtCliente);
        txtCliente.setVisible(false);

        chkEmpleado = new JCheckBox("Nombre de Empleado");
        chkEmpleado.setBounds(20, 90, 150, 25);
        contentPanel.add(chkEmpleado);

        txtEmpleado = new JTextField();
        txtEmpleado.setBounds(180, 90, 150, 25);
        contentPanel.add(txtEmpleado);
        txtEmpleado.setVisible(false);

        chkPlaca = new JCheckBox("Número de Placa");
        chkPlaca.setBounds(20, 130, 150, 25);
        contentPanel.add(chkPlaca);

        txtNoPlaca = new JTextField();
        txtNoPlaca.setBounds(180, 130, 150, 25);
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
        buttonPane.setBackground(new Color(201, 248, 243));
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton okButton = new JButton("Buscar");
        okButton.setActionCommand("Buscar");
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.setActionCommand("Cancelar");
        buttonPane.add(cancelButton);

        cancelButton.addActionListener(e -> dispose()); // Cerrar el diálogo al cancelar.

        // Acción de búsqueda (se pueden agregar filtros según los campos seleccionados)
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aquí agregarías el código para hacer la búsqueda de alquileres según los criterios
                // Usualmente consultarías una base de datos o una lista de objetos para obtener los resultados
                // Ejemplo ficticio de cómo llenar la tabla:

                // Limpiar la tabla antes de agregar los resultados
                DefaultTableModel model = (DefaultTableModel) tAlquileres.getModel();
                model.setRowCount(0);

                // Llenar la tabla con los datos (esto se reemplazaría con la lógica de búsqueda real)
                model.addRow(new Object[] { "Juan Pérez", "Carlos García", "ABC123", "2024-11-19", "$500" });
                model.addRow(new Object[] { "Ana López", "Pedro Gómez", "XYZ456", "2024-11-18", "$450" });
            }
        });
    }
}