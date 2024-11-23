package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
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
import javax.swing.border.TitledBorder;

public class Login extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsuario;
	private JPasswordField pwdPassword;
	private JComponent panel_1;
	private AbstractButton btnCancelar;
	private AbstractButton btnAceptar;
	private Component lblPassword;
	private JLabel lblNewLabel;

	public static void main(String[] args) {
		//com.jtattoo.plaf.smart.SmartLookAndFeel
		//com.jtattoo.plaf.fast.FastLookAndFeel
		try {
			//UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
			UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
			//UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/pictures/Car-icon.png")));
		
		setTitle("Login \t\t\t\t\t\tCar For Rent");	
		//setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/interfaz/pictures/Car-icon.png")));

		setForeground(new Color(0, 0, 0));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(220, 220, 220));
		contentPanel.setForeground(new Color(240, 219, 231));
		contentPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 220, 220));
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(53, 29, 320, 201);
		contentPanel.add(panel);
		panel.setLayout(null);

		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(151, 67, 136, 24);
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
		pwdPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pwdPassword.setEchoChar('*');
		pwdPassword.setColumns(10);
		pwdPassword.setBounds(151, 98, 136, 24);
		panel.add(pwdPassword);

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(220, 220, 220));
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 143, 304, 48);
		panel.add(panel_1);

		btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(53, 10, 97, 25);
		btnCancelar.setBackground(new Color(255, 255, 255));
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCancelar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel_1.setLayout(null);
		panel_1.add(btnCancelar);
		
				btnAceptar = new JButton("ACEPTAR");
				btnAceptar.setBounds(160, 10, 89, 25);
				btnAceptar.setBackground(new Color(255, 255, 255));
				btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 13));
				btnAceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						aceptar();
					}
				});
				panel_1.add(btnAceptar);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsuario.setBounds(97, 72, 46, 11);
		panel.add(lblUsuario);

		lblPassword = new JLabel("Clave");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPassword.setBounds(106, 108, 37, 11);
		panel.add(lblPassword);
		
		JLabel iconLogin = new JLabel("");
		iconLogin.setIcon(new ImageIcon(Login.class.getResource("/pictures/Car-icon.png")));
		iconLogin.setBounds(33, 74, 57, 48);
		panel.add(iconLogin);
		
		lblNewLabel = new JLabel("     I N I C I O  D E  S E S I Ó N ");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 23, 277, 34);
		panel.add(lblNewLabel);
	}

	private void aceptar() {
		String usuario=txtUsuario.getText();
		String clave=new String (pwdPassword.getPassword());

		if(usuario.equals("")|| clave.equals("")) {
			JOptionPane.showMessageDialog(contentPanel, "Favor de ingresar el usuario o contraseña");
		}else {
			dispose();
			Menu menu=new Menu(usuario);
			menu.setVisible(true);
			/*if(Control.verificarCliente(usuario)!=null && clave.equals("1234")) {
				Control.setClienteActual(usuario);//usuario es curp
				
				JOptionPane.showMessageDialog(contentPanel, "Bienvenido \n"
						+Control.getClienteActual().getNombre());
				dispose();
				MenuPrincipal menuPrincipal=new MenuPrincipal(usuario);
				menuPrincipal.setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(contentPanel, "Usuario o contraseña incorrecta");
			}*/
		}
	}
}

