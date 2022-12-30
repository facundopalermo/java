package edu.up.usuarios.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import edu.up.config.db.EntidadDAOH2Impl;
import edu.up.config.excepciones.ClaveDuplicadaDAOException;
import edu.up.config.excepciones.ClaveDuplicadaServiceException;
import edu.up.config.excepciones.DAOException;
import edu.up.usuarios.clase.Administrador;
import edu.up.usuarios.clase.Usuario;

public class UsuarioDAOH2Impl extends EntidadDAOH2Impl implements UsuarioDAO{
	
	@Override
	public void crearUsuario(Usuario unUsuario) throws DAOException, ClaveDuplicadaDAOException {
		String sql="INSERT INTO usuarios (user, pass, email, nombre, apellido, tipo) VALUES (?,?,?,?,?,?)";
		ArrayList<Object> objs = new ArrayList<Object>();
		objs.add(unUsuario.getUser());
		objs.add(unUsuario.getPass());
		objs.add(unUsuario.getEmail());
		objs.add(unUsuario.getNombre());
		objs.add(unUsuario.getApellido());
        int tipo=0;
        if(unUsuario instanceof Administrador) {
        	tipo=1;
        }
        objs.add(tipo);
        
        try {
        	psExecuteUpdate(sql, objs);
        }catch(DAOException e){
            if(e.getErrorCode() == 23505) {
                throw new ClaveDuplicadaDAOException();
            }
        }
	}

	@Override
	public void borraUsuario(Usuario unUsuario) throws DAOException {
		String sql = "DELETE FROM usuarios WHERE user = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(unUsuario.getUser());
		
		psExecuteUpdate(sql, objs);		
	}

	@Override
	public void actualizaUsuario(Usuario unUsuario) throws DAOException {
		String sql = "UPDATE usuarios SET pass = ?, email = ?, nombre = ?, apellido = ?, tipo = ? WHERE user = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(unUsuario.getPass());
		objs.add(unUsuario.getEmail());
		objs.add(unUsuario.getNombre());
		objs.add(unUsuario.getApellido());
        int tipo=0;
        if(unUsuario instanceof Administrador) {
        	tipo=1;
        }
        objs.add(tipo);
        objs.add(unUsuario.getUser());
        
        psExecuteUpdate(sql, objs);
	}

	@Override
	public Usuario consultaUsuario(String username) throws DAOException {
		Usuario usuario = null;
		String sql = "SELECT * FROM usuarios WHERE user = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(username);
		
		List<Map<String, Object>> resultado = psExecuteQuerySelect(sql, objs);
	
		Map<String, Object> map = resultado.get(0);
			
        int id = (int)map.get("ID");
        String user = map.get("USER").toString();
        String email = map.get("EMAIL").toString();
        String pass = map.get("PASS").toString();
        String nombre = map.get("NOMBRE").toString();
        String apellido = map.get("APELLIDO").toString();
        int tipo = (int)map.get("TIPO");
			
        if (tipo==1) {
            usuario = new Administrador(id, user, pass, email, nombre, apellido);
        }else {
            usuario = new Usuario(id, user, pass, email, nombre, apellido);
        }  
		
		return usuario;
	}

	@Override
	public List<Usuario> listaTodosLosUsuarios() throws DAOException {
		
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		
		String sql = "SELECT * FROM usuarios";
		
		List<Map<String, Object>> resultado = psExecuteQueryListar(sql);
		
		for(int i=0;i<resultado.size();i++) {
			Map<String, Object> map = resultado.get(i);
            
        	int id = (int)map.get("ID");
            String user = map.get("USER").toString();
            String email = map.get("EMAIL").toString();
            String pass = map.get("PASS").toString();
            String nombre = map.get("NOMBRE").toString();
            String apellido = map.get("APELLIDO").toString();
            int tipo = (int)map.get("TIPO");
			
            Usuario usuario;
            
			if (tipo==1) {
            	usuario = new Administrador(id, user, pass, email, nombre, apellido);
            }else {
            	usuario = new Usuario(id, user, pass, email, nombre, apellido);
            }
			
			listaUsuarios.add(usuario);
		}
		
		return listaUsuarios;
	}
}