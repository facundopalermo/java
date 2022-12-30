package edu.up.usuarios.DAO;

import java.util.List;

import edu.up.config.excepciones.ClaveDuplicadaDAOException;
import edu.up.config.excepciones.ClaveDuplicadaServiceException;
import edu.up.config.excepciones.DAOException;
import edu.up.usuarios.clase.Usuario;

public interface UsuarioDAO {
	
	void crearUsuario(Usuario unUsuario) throws DAOException, ClaveDuplicadaDAOException;
	void borraUsuario(Usuario usuario) throws DAOException;
	void actualizaUsuario(Usuario unUsuario) throws DAOException;
	Usuario consultaUsuario(String username)throws DAOException;
	List<Usuario> listaTodosLosUsuarios()throws DAOException;
	
}
