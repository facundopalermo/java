package edu.up.usuarios.ui;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import edu.up.config.excepciones.ClaveDuplicadaServiceException;
import edu.up.config.excepciones.DAOServiceException;
import edu.up.config.mensaje.Mensaje;
import edu.up.config.sesion.Sesion;
import edu.up.panelManager.PanelManager;
import edu.up.usuarios.clase.Administrador;
import edu.up.usuarios.clase.Usuario;
import edu.up.usuarios.services.UsuarioService;

public class UsuarioPanel extends JPanel implements ActionListener  {
	
	private PanelManager manejador = Sesion.getManejador();
	
	private JLabel lbl_usuario = new JLabel("Usuario: ");
	private JLabel lbl_nombre = new JLabel("Nombre: ");
	private JLabel lbl_apellido = new JLabel("Apellido: ");
	private JLabel lbl_email = new JLabel("Email: ");
	private JLabel lbl_pass = new JLabel("Contraseña: ");
	
	private JTextField txt_usuario = new JTextField(20);
	private JTextField txt_nombre = new JTextField(20);
	private JTextField txt_apellido = new JTextField(20);
	private JTextField txt_email = new JTextField(20);
	private JTextField txt_pass = new JTextField(20);
	
	private JPanel panel_usuario = new JPanel();
	private JPanel panel_nombre = new JPanel();
	private JPanel panel_apellido = new JPanel();
	private JPanel panel_email = new JPanel();
	private JPanel panel_pass = new JPanel();
	
	String[] tipoStrings = { "Comun", "Administrador"};
	private JComboBox combo_tipo = new JComboBox(tipoStrings);
	private JPanel panel_combo = new JPanel();
	
	private JButton botonGuardar = new JButton("Guardar");
	private JButton botonCrear = new JButton("Crear");
	
	private JButton botonCamPass = new JButton("Cambiar contraseña");
	
	private JPanel panel_botonera = new JPanel();
	
	public UsuarioPanel() {
		
	}
	
	public void armar() {
		
		for(Component c : this.getComponents()) {
			if(c instanceof JPanel) {
				((JPanel) c).setLayout(new FlowLayout());
			}
		}
		
		panel_usuario.add(lbl_usuario);
		panel_usuario.add(txt_usuario);
		txt_usuario.setEnabled(false);
		
		panel_nombre.add(lbl_nombre);
		panel_nombre.add(txt_nombre);
		
		panel_apellido.add(lbl_apellido);
		panel_apellido.add(txt_apellido);
		
		panel_email.add(lbl_email);
		panel_email.add(txt_email);
		
		panel_pass.add(lbl_pass);
		panel_pass.add(txt_pass);

		panel_combo.add(combo_tipo);
		
		botonGuardar.addActionListener(this);
		botonCrear.addActionListener(this);
		botonCamPass.addActionListener(this);
		
	}
	
	public void mostrarCamposCrear() {
		mostrarCamposModificar();
		panel_botonera.remove(botonGuardar);
		panel_botonera.add(botonCrear);
		txt_usuario.setEnabled(true);
	}
	
	public void mostrarCamposModificar() {
		this.add(panel_usuario);
		this.add(panel_nombre);
		this.add(panel_apellido);
		this.add(panel_email);
		this.add(panel_pass);
		panel_botonera.add(botonGuardar);
		panel_botonera.remove(botonCrear);
		this.add(panel_combo);
		this.add(panel_botonera);
	}
	
	public void mostrarCamposPass() {
		this.add(panel_usuario);
		this.add(panel_pass);
		panel_botonera.add(botonCamPass);
		panel_botonera.remove(botonCrear);
		this.add(panel_botonera);
	}
	
	public void llenarFormulario(Usuario usuario) {
		txt_usuario.setText(usuario.getUser());
		txt_nombre.setText(usuario.getNombre());
		txt_apellido.setText(usuario.getApellido());
		txt_email.setText(usuario.getEmail());
		txt_pass.setText(usuario.getPass());
		if(usuario instanceof Administrador) {
			combo_tipo.setSelectedIndex(1);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Usuario usuario;
		
		if(combo_tipo.getSelectedIndex()==1) {
			usuario = new Administrador(txt_usuario.getText(), txt_pass.getText(), txt_email.getText(), txt_nombre.getText(), txt_apellido.getText());
		}else {
			usuario = new Usuario(txt_usuario.getText(), txt_pass.getText(), txt_email.getText(), txt_nombre.getText(), txt_apellido.getText());
		}
		
		if (e.getSource()==botonGuardar) {
			if (validar(usuario)){
				try {
					UsuarioService.Guardar(usuario);
					Mensaje.info(this, "Exito al guardar el usuario", "Modificar usuario");
				} catch (DAOServiceException e1) {Mensaje.error(this, "Ha ocurrido un error y el los cambios no han sido guardados", "Error al guardar usuario", e1);
				}finally {
					SwingUtilities.getWindowAncestor(botonGuardar).dispose();
					manejador.actualizarTablaUsuarios();
				}
			}
		}else
			if (e.getSource()==botonCrear) {
				if (validar(usuario)){
					try {
						UsuarioService.Crear(usuario);
						Mensaje.info(this, "Exito al crear el usuario", "Crear usuario");
						SwingUtilities.getWindowAncestor(botonCrear).dispose();
					} catch (ClaveDuplicadaServiceException e1) {Mensaje.info(this, "El usuario que intenta crear ya existe. No se ha guardado", "Error al crear usuario");
					} catch (DAOServiceException e1) {Mensaje.error(this, "Error critico al intentar crear el usuario", "Error Crítico", e1);
					}finally {
						manejador.actualizarTablaUsuarios();
					}
				}
			}
		else
			if (e.getSource()==botonCamPass) {
				if (validar(usuario)){
					try {
						UsuarioService.Guardar(usuario);
						Mensaje.info(this, "Exito al guardar la contraseña", "Cambiar contraseña");
					} catch (DAOServiceException e1) {Mensaje.error(this, "Ha ocurrido un error y el la contraseña no se ha guardado", "Error al guardar usuario", e1);
					}finally {
						SwingUtilities.getWindowAncestor(botonCamPass).dispose();
					}
				}
			}	
	}
	
	private boolean validar(Usuario usuario) {
		if(usuario.getUser().length()>1 && usuario.getPass().length()>1) {
			return true;
		}else {
			Mensaje.info(this, "El usuario o la contraseña no pueden estar vacios", "Faltan datos..");
			return false;
		}
	}
}
