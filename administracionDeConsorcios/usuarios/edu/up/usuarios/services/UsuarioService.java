package edu.up.usuarios.services;

import java.util.ArrayList;
import java.util.List;

import edu.up.config.excepciones.ClaveDuplicadaDAOException;
import edu.up.config.excepciones.ClaveDuplicadaServiceException;
import edu.up.config.excepciones.DAOException;
import edu.up.config.excepciones.DAOServiceException;
import edu.up.usuarios.DAO.UsuarioDAO;
import edu.up.usuarios.DAO.UsuarioDAOH2Impl;
import edu.up.usuarios.clase.Usuario;

public class UsuarioService  {
	
	private static UsuarioDAO dao = new UsuarioDAOH2Impl();
	
	public static void Guardar(Usuario usuario) throws DAOServiceException{
		try {
			dao.actualizaUsuario(usuario);
		} catch (DAOException e) {
			throw new DAOServiceException();
		}
	}
	
	public static void Crear(Usuario usuario) throws DAOServiceException, ClaveDuplicadaServiceException{
		try {
			dao.crearUsuario(usuario);
		} catch (ClaveDuplicadaDAOException e) {
			throw new ClaveDuplicadaServiceException(e);
		} catch (DAOException e) {
            throw new DAOServiceException(e);
		}
	}
	
	public static void Borrar(Usuario usuario) throws DAOServiceException{
		try {
			dao.borraUsuario(usuario);
		} catch (DAOException e) {
			throw new DAOServiceException(e);
		}
	}
	
	public static List<Usuario> obtenerDatos() throws DAOServiceException{
		
		List<Usuario> datos = new ArrayList<Usuario>();
		UsuarioDAO dao = new UsuarioDAOH2Impl();
		try {
			datos = dao.listaTodosLosUsuarios();
		} catch (DAOException e) {
			throw new DAOServiceException(e);
		}
		return datos;
	}

}
