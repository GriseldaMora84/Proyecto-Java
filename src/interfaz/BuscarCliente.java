package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuscarCliente extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtTel;
	private JTextField txtEmail;
	private JTextField txtLic;
	private JRadioButton rdbNombre;
	private JRadioButton rdbNoTel;
	private JRadioButton rdbEmail;
	private JRadioButton rdbNoLic;
	private JButton okButton;
	private AbstractButton cancelButton;
	private ButtonGroup bg;
	
	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		try {
			BuscarCliente dialog = new BuscarCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public BuscarCliente() {
		setTitle("Filtrar lista de clientes");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(150, 241, 232));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		rdbNombre = new JRadioButton("Nombre");
		rdbNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbNombre.setBackground(new Color(150, 241, 232));
		rdbNombre.setBounds(26, 40, 103, 21);
		contentPanel.add(rdbNombre);
		
		rdbNoTel = new JRadioButton("No. teléfono");
		rdbNoTel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbNoTel.setBackground(new Color(150, 241, 232));
		rdbNoTel.setBounds(26, 78, 103, 21);
		contentPanel.add(rdbNoTel);
		
		rdbEmail = new JRadioButton("Email");
		rdbEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbEmail.setBackground(new Color(150, 241, 232));
		rdbEmail.setBounds(26, 113, 103, 21);
		contentPanel.add(rdbEmail);
		
		rdbNoLic = new JRadioButton("No. licencia");
		rdbNoLic.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbNoLic.setBackground(new Color(150, 241, 232));
		rdbNoLic.setBounds(26, 147, 103, 21);
		contentPanel.add(rdbNoLic);
		
		bg= new ButtonGroup();
		bg.add(rdbNombre);
		bg.add(rdbNoTel);
		bg.add(rdbEmail);
		bg.add(rdbNoLic);
		
		JLabel lblOpcFiltrado = new JLabel("Opción de búsqueda");
		lblOpcFiltrado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOpcFiltrado.setBounds(26, 10, 152, 24);
		contentPanel.add(lblOpcFiltrado);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombre.setBounds(171, 40, 129, 21);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		txtNombre.setVisible(false);
		
		txtTel = new JTextField();
		txtTel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTel.setColumns(10);
		txtTel.setBounds(171, 81, 129, 21);
		contentPanel.add(txtTel);
		txtTel.setVisible(false);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(171, 116, 129, 21);
		contentPanel.add(txtEmail);
		txtEmail.setVisible(false);
		
		txtLic = new JTextField();
		txtLic.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtLic.setColumns(10);
		txtLic.setBounds(171, 150, 129, 21);
		contentPanel.add(txtLic);
		txtLic.setVisible(false);
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(201, 248, 243));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ok();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			verificarRDB();
		}
	}
	
	public void verificarRDB() {
		  // Agregar ActionListeners a los botones de radio
	    rdbNombre.addActionListener(e -> {
	    	txtNombre.setVisible(true);
	        txtTel.setVisible(false);
	        txtEmail.setVisible(false);
	        txtLic.setVisible(false);
	    });
	    rdbNoTel.addActionListener(e -> {
	    	txtNombre.setVisible(false);
	        txtTel.setVisible(true);
	        txtEmail.setVisible(false);
	        txtLic.setVisible(false);
	    });
	    rdbEmail.addActionListener(e -> {
	    	txtNombre.setVisible(false);
	        txtTel.setVisible(false);
	        txtEmail.setVisible(true);
	        txtLic.setVisible(false);
	    });
	    rdbNoLic.addActionListener(e -> {
	    	txtNombre.setVisible(false);
	        txtTel.setVisible(false);
	        txtEmail.setVisible(false);
	        txtLic.setVisible(true);
	    });
	}
	
	public void ok() {
		//Verificar que se haya selleciondado algo
		if (bg.getSelection() == null) { 
			JOptionPane.showMessageDialog(contentPanel, "Elige una opción");
		}else {
			if (rdbNombre.isSelected()) {
				
	        } else if (rdbNoTel.isSelected()) {
	        	
	        } else if (rdbEmail.isSelected()) {
	        	
	        } else if (rdbNoLic.isSelected()) {
	        	
	        }
		}
	}
}