package edu.up.usuarios.services;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import edu.up.usuarios.clase.Usuario;
import edu.up.config.excepciones.DAOException;
import edu.up.config.excepciones.DAOServiceException;
import edu.up.config.excepciones.LoginServiceException;
import edu.up.config.mensaje.Mensaje;
import edu.up.config.sesion.Sesion;
import edu.up.panelManager.PanelManager;
import edu.up.usuarios.DAO.UsuarioDAO;
import edu.up.usuarios.DAO.UsuarioDAOH2Impl;


public class LoginService{
	
	
	public static Usuario validarUsuario(String user, String pass) throws DAOServiceException, LoginServiceException {	
		UsuarioDAO dao = new UsuarioDAOH2Impl();
		Usuario usuario = null;
		
			try {
				usuario = dao.consultaUsuario(user);
			} catch (DAOException e) {
				throw new DAOServiceException(e);
			}
		
		if(usuario!=null && usuario.getPass().equals(pass)) {
			return usuario;
		}else {
			throw new LoginServiceException();
		}
	}
}
