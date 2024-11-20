package interfaz;

import java.awt.EventQueue;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsuario;
	private JPasswordField pwdPassword;
	private JComponent panel_1;
	private AbstractButton btnCancelar;
	private AbstractButton btnAceptar;
	private Component lblPassword;

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Login() {
		setTitle("Login");

		setForeground(new Color(0, 0, 0));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(150, 241, 232));
		contentPanel.setForeground(new Color(240, 219, 231));
		contentPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(150, 241, 232));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 255), null, null, null));
		panel.setBounds(51, 35, 320, 178);
		contentPanel.add(panel);
		panel.setLayout(null);

		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(131, 29, 136, 21);
		panel.add(txtUsuario);
		
		//Validacion para que no se ingrese un nombre de usuario mayor de lo permitido
		txtUsuario.addKeyListener(new KeyAdapter() {
			String temp;
			@Override
			public void keyTyped(KeyEvent e) {
				temp=txtUsuario.getText();
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				String v=txtUsuario.getText().trim();
				if(v.length()>8) {//El usuario es de 8 caracteres
					JOptionPane.showMessageDialog(null, "El nombre de usuario no debe ser exceder de 3 caracteres");
					txtUsuario.setText(temp);
				}
			}
		});

		pwdPassword = new JPasswordField();
		pwdPassword.setEchoChar('*');
		pwdPassword.setColumns(10);
		pwdPassword.setBounds(131, 67, 136, 17);
		panel.add(pwdPassword);

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(211, 251, 252));
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(8, 106, 304, 48);
		panel.add(panel_1);

		btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBackground(new Color(216, 191, 216));
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCancelar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
				btnAceptar = new JButton("ACEPTAR");
				btnAceptar.setBackground(new Color(216, 191, 216));
				btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 13));
				btnAceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						aceptar();
					}
				});
				panel_1.add(btnAceptar);
		panel_1.add(btnCancelar);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsuario.setBounds(77, 34, 46, 11);
		panel.add(lblUsuario);

		lblPassword = new JLabel("Clave");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPassword.setBounds(86, 70, 37, 11);
		panel.add(lblPassword);
		
		JLabel iconLogin = new JLabel("");
		iconLogin.setBounds(30, 36, 37, 48);
		panel.add(iconLogin);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}

	private void aceptar() {
		String usuario=txtUsuario.getText();
		String clave=new String (pwdPassword.getPassword());

		if(usuario.equals("")|| clave.equals("")) {
			JOptionPane.showMessageDialog(contentPanel, "Favor de ingresar el usuario o contraseña");
		}else {
			try {
				Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost/proyectojava","root" ,"");
				Statement comando=conexion.createStatement();
				ResultSet registroUsuario = comando.executeQuery("select nombreUsuario,contrasenia from cuentausuario where codigo="+usuario);
				if (registroUsuario.next()==true) {
					JOptionPane.showMessageDialog(contentPanel, "Encontrado");
				} else {
					JOptionPane.showMessageDialog(contentPanel, "NoEncontrado");
				}
				conexion.close();
			} catch(SQLException ex){
				setTitle(ex.toString());
			}
			
			/*dispose();
			Menu menu=new Menu(usuario);
			menu.setVisible(true);*/
			/*if(Control.verificarCliente(usuario)!=null && clave.equals("1234")) {
				Control.setClienteActual(usuario);//usuario es curp
				
				JOptionPane.showMessageDialog(contentPanel, "Bienvenido \n"
						+Control.getClienteActual().getNombre());
				dispose();
				MenuPrincipal menuPrincipal=new MenuPrincipal(usuario);
				menuPrincipal.setVisible(true);
			}
			else {numero = (int) (Math.random() * 1000) + 1;
				JOptionPane.showMessageDialog(contentPanel, "Usuario o contraseña incorrecta");
			}*/
		}
	}
}

