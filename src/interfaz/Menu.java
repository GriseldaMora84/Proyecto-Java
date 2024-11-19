package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class Menu extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

public Menu(String usuario) {
		setTitle("Menú");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 776, 670);
		contentPanel = new JPanel();
		contentPanel.setBackground(new Color(150, 241, 232));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		JMenuBar mbOpciones = new JMenuBar();
		mbOpciones.setForeground(new Color(0, 0, 0));
		mbOpciones.setBackground(new Color(255, 128, 255));
		mbOpciones.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mbOpciones.setBounds(54, 20, 366, 55);
		contentPanel.add(mbOpciones);
		
		JMenu menuInventario = new JMenu("Inventario");
		menuInventario.setBackground(new Color(240, 219, 231));
		menuInventario.setForeground(new Color(0, 0, 0));
		menuInventario.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 16));
		mbOpciones.add(menuInventario);
		
		JMenuItem mntmRegistrarV = new JMenuItem("Registrar vehículo");
		mntmRegistrarV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mntmRegistrarV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuInventario.add(mntmRegistrarV);
		
		JMenuItem mntmConsultar = new JMenuItem("Consultar");
		mntmConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmConsultar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuInventario.add(mntmConsultar);
		
		JMenu menuAlquiler = new JMenu("Alquiler");
		menuAlquiler.setForeground(Color.BLACK);
		menuAlquiler.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 16));
		menuAlquiler.setBackground(new Color(201, 248, 243));
		mbOpciones.add(menuAlquiler);
		
		JMenuItem mntmCotizar = new JMenuItem("Cotizar");
		mntmCotizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				}
		});
		mntmCotizar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmCotizar.setBackground(new Color(240, 219, 231));
		menuAlquiler.add(mntmCotizar);
		
		JMenuItem mntmConsultarHistorial = new JMenuItem("Consultar historial");
		mntmConsultarHistorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}

			
		});
		mntmConsultarHistorial.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuAlquiler.add(mntmConsultarHistorial);
		menuAlquiler.setForeground(Color.BLACK);
		
		JMenu menuCliente = new JMenu("Cliente");
		menuCliente.setForeground(Color.BLACK);
		menuCliente.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 16));
		menuCliente.setBackground(new Color(240, 219, 231));
		mbOpciones.add(menuCliente);
		
		JMenuItem mntmRegistrarCliente = new JMenuItem("Registrar cliente");
		mntmRegistrarCliente.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuCliente.add(mntmRegistrarCliente);
		
		JMenuItem mntmActualizarInfo = new JMenuItem("Actualizar información");
		mntmActualizarInfo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuCliente.add(mntmActualizarInfo);
		
		JLabel lblFoto = new JLabel("FOTO");
		lblFoto.setBorder(BorderFactory.createLineBorder(Color.black));
		lblFoto.setBackground(Color.LIGHT_GRAY);
		lblFoto.setOpaque(true);
		lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFoto.setBounds(27, 130, 185, 220);
		contentPanel.add(lblFoto);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsuario.setBounds(250, 198, 134, 48);
		contentPanel.add(lblUsuario);
		
		JLabel lblId = new JLabel("Número de empleado:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblId.setBounds(250, 130, 218, 48);
		contentPanel.add(lblId);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombre.setBounds(250, 256, 134, 48);
		contentPanel.add(lblNombre);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(472, 137, 169, 31);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(472, 198, 169, 31);
		contentPanel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(472, 256, 169, 31);
		contentPanel.add(textField_2);
		
		JLabel lblReloj = new JLabel("reloj");
		lblReloj.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblReloj.setBounds(550, 473, 45, 13);
		contentPanel.add(lblReloj);
		
	}
}
