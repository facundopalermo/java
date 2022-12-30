package edu.up.usuarios.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import edu.up.config.excepciones.DAOServiceException;
import edu.up.config.excepciones.LoginServiceException;
import edu.up.config.mensaje.Mensaje;
import edu.up.config.sesion.Sesion;
import edu.up.config.ui.comun.Frame;
import edu.up.panelManager.PanelManager;
import edu.up.usuarios.clase.Usuario;
import edu.up.usuarios.services.LoginService;

public class LoginPanel extends JPanel implements ActionListener{
	
	private PanelManager manejador = Sesion.getManejador();
	
	private JButton entrar = new JButton("Entrar");
	private JTextField usuario_txt = new JTextField(15);
	private JTextField pass_txt = new JTextField(15);
	
	public LoginPanel() {
		
		armar();
	}
	
	private void armar() {
			
		BoxLayout caja_panel = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(caja_panel);
			
		JPanel contenedor_general = new JPanel();
		BoxLayout caja = new BoxLayout(contenedor_general, BoxLayout.X_AXIS);
		contenedor_general.setLayout(caja);
			
		JLabel imagen = new JLabel();
		imagen.setIcon(new ImageIcon("img/login.png"));
			
		JPanel contenedor_imagen = new JPanel();
		contenedor_imagen.add(imagen);
		
		JPanel contenedor_label = new JPanel();
			
		JPanel aux1 = new JPanel();
		JPanel aux2 = new JPanel();
				
		JLabel usuario_lbl = new JLabel("Usuario:");
		JLabel pass_lbl = new JLabel("Contraseña:");	
		
		aux1.add(usuario_lbl);
		aux2.add(pass_lbl);
				
		BoxLayout caja_labels = new BoxLayout(contenedor_label, BoxLayout.Y_AXIS);
		contenedor_label.setLayout(caja_labels);
				
		contenedor_label.add(aux1);
		contenedor_label.add(aux2);
		
		JPanel contenedor_txt = new JPanel();
		JPanel aux3 = new JPanel();
		JPanel aux4 = new JPanel();
				
					
		aux3.add(usuario_txt);
		aux4.add(pass_txt);

		BoxLayout caja_txt = new BoxLayout(contenedor_txt, BoxLayout.Y_AXIS);
		contenedor_txt.setLayout(caja_txt);
				
		contenedor_txt.add(aux3);
		contenedor_txt.add(aux4);
				
		entrar.addActionListener(this);

		JPanel aux5 = new JPanel();
					
		BoxLayout caja_entrar = new BoxLayout(aux5, BoxLayout.X_AXIS);
		aux5.setLayout(caja_entrar);
		aux5.add(entrar);
					
		contenedor_general.add(contenedor_imagen);
		contenedor_general.add(contenedor_label);
		contenedor_general.add(contenedor_txt);
		this.add(contenedor_general);
		this.add(aux5);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==entrar) {
			
			Usuario usuario = null;
			
			try {
				usuario = LoginService.validarUsuario(usuario_txt.getText(), pass_txt.getText());
			} catch (DAOServiceException e1) {Mensaje.error(this,"El usuario ingresado no existe. Ingrese un usuario válido", "Inciar Sesión", null);
			} catch (LoginServiceException e1) {Mensaje.error(this,"La contraseña es incorrecta. Ingrese una contraseña válida", "Inciar Sesión", null);}
			
			if(usuario!=null) {
				Sesion.setUsuario(usuario);
				manejador.iniciarManager();
				SwingUtilities.getWindowAncestor(entrar).dispose();
			}
			
		}

	}
}
