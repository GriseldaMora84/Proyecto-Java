package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import carForRent.Empleado; // Asumiendo que tienes una clase Empleado

public class InformacionEmpleado extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField txtIdEmpleado;
    private JTextField txtNombre;
    private JTextField txtTel;
    private JTextField txtEmail;
    
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        try {
            InformacionEmpleado dialog = new InformacionEmpleado(0, null);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public InformacionEmpleado(int opc, Empleado empleado) {
        setTitle("Información del Empleado");
        setBounds(100, 100, 450, 250);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(new Color(220, 220, 220));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        
        // Etiquetas y campos de texto para mostrar la información del empleado
        JLabel lblIdEmpleado = new JLabel("ID Empleado:");
        lblIdEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblIdEmpleado.setBounds(29, 21, 119, 17);
        contentPanel.add(lblIdEmpleado);
        
        txtIdEmpleado = new JTextField();
        txtIdEmpleado.setEditable(false); // Bloqueado para edición
        txtIdEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtIdEmpleado.setBounds(174, 22, 137, 19);
        contentPanel.add(txtIdEmpleado);
        txtIdEmpleado.setColumns(10);
        
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNombre.setBounds(29, 52, 84, 17);
        contentPanel.add(lblNombre);
        
        txtNombre = new JTextField();
        txtNombre.setEditable(false); // Bloqueado para edición
        txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtNombre.setColumns(10);
        txtNombre.setBounds(174, 51, 137, 19);
        contentPanel.add(txtNombre);
        
        JLabel lblTel = new JLabel("Teléfono:");
        lblTel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblTel.setBounds(29, 79, 137, 17);
        contentPanel.add(lblTel);
        
        txtTel = new JTextField();
        txtTel.setEditable(false); // Bloqueado para edición
        txtTel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtTel.setColumns(10);
        txtTel.setBounds(174, 79, 137, 19);
        contentPanel.add(txtTel);
        
        JLabel lblEmail = new JLabel("E-mail:");
        lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblEmail.setBounds(29, 106, 137, 17);
        contentPanel.add(lblEmail);
        
        txtEmail = new JTextField();
        txtEmail.setEditable(false); // Bloqueado para edición
        txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtEmail.setColumns(10);
        txtEmail.setBounds(174, 107, 137, 19);
        contentPanel.add(txtEmail);
        
        

        // Panel de botones
        JPanel buttonPane = new JPanel();
        buttonPane.setBackground(new Color(220, 220, 220));
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        // Botón OK
        JButton okButton = new JButton("OK");
        okButton.setActionCommand("OK");
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);

        // Botón Cancel
        JButton cancelButton = new JButton("Cancelar");
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);
    }
}
