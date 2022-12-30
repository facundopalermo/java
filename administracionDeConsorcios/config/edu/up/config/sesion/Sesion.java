package edu.up.config.sesion;

import edu.up.config.excepciones.DAOException;
import edu.up.config.mensaje.Mensaje;
import edu.up.panelManager.PanelManager;
import edu.up.usuarios.DAO.UsuarioDAO;
import edu.up.usuarios.DAO.UsuarioDAOH2Impl;
import edu.up.usuarios.clase.Administrador;
import edu.up.usuarios.clase.Usuario;

public class Sesion {
	private static Usuario usuario;
	private static PanelManager manejador;
	
	private Sesion () {
	}

	public static Usuario getUsuario() {
		verificaDatos();
		return usuario;
	}

	public static void setUsuario(Usuario usuario) {
		Sesion.usuario = usuario;
	}
	
	public static void setManejador(PanelManager manejador) {
		Sesion.manejador = manejador;
	}
	
	public static PanelManager getManejador() {
		return manejador;
	}
	
	public static void verificaDatos() {
		Usuario usuarioActualizado=null;
		UsuarioDAO dao = new UsuarioDAOH2Impl();
		try {
			usuarioActualizado = dao.consultaUsuario(usuario.getUser());
		} catch (DAOException e) {
			Mensaje.error(null, "Error critico en la sesión. El programa finalizará", "Error Crítico", e);
			System.exit(0);
		}
		Sesion.setUsuario(usuarioActualizado);
	}

	public static boolean isAdmin() {
		if(usuario instanceof Administrador) {
			return true;
		}
		return false;
	}
	
}
