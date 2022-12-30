package edu.up.consorcio.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import edu.up.config.db.EntidadDAOH2Impl;
import edu.up.config.excepciones.ClaveDuplicadaDAOException;
import edu.up.config.excepciones.DAOException;
import edu.up.config.mensaje.Mensaje;
import edu.up.consorcio.clase.Edificio;

public class EdificioDAOH2Impl extends EntidadDAOH2Impl implements EdificioDAO{

	@Override
	public void crearEdificio(Edificio edificio) throws DAOException, ClaveDuplicadaDAOException {
		String sql = "INSERT INTO edificios (nombre, calle, altura, localidad, pisos) VALUES (?,?,?,?,?)";
		ArrayList<Object> objs = new ArrayList<Object>();
		objs.add(edificio.getNombre());
		objs.add(edificio.getDir_calle());
		objs.add(edificio.getDir_altura());
		objs.add(edificio.getDir_localidad());
		objs.add(edificio.getN_pisos());
		
        try {
        	psExecuteUpdate(sql, objs);
        }catch(DAOException e){
            if(e.getErrorCode() == 23505) {
                throw new ClaveDuplicadaDAOException();
            }
        }
	}	
	
	@Override
	public void borrarEdificio(Edificio edificio) throws DAOException {
		
		UFDAO dao = new UFDAOH2Impl();
		
		try {
			dao.borrarUFEdificio(edificio);
		}catch(DAOException e){
			Mensaje.info(null, "El edificio no tenía UF asignadas.\nEl sistema continuará con la eliminación", "Eliminando...");
		}finally {
			String sql = "DELETE FROM edificios WHERE nombre = ?";
			List<Object> objs = new ArrayList<Object>();
			objs.add(edificio.getNombre());
			
			psExecuteUpdate(sql, objs);
		}
	}
	
	@Override
	public void modificarEdificio(Edificio edificio) throws DAOException {
		String sql = "UPDATE edificios SET calle = ?, altura = ?, localidad = ?, pisos = ? WHERE nombre = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(edificio.getDir_calle());
		objs.add(edificio.getDir_altura());
		objs.add(edificio.getDir_localidad());
		objs.add(edificio.getN_pisos());
		objs.add(edificio.getNombre());
		
		psExecuteUpdate(sql, objs);
	}
	
	@Override
	public List<Edificio> listarEdificios() throws DAOException {
		
		List<Edificio> listaEdificios = new ArrayList<Edificio>();
		
		String sql = "SELECT * FROM edificios";
		List<Map<String, Object>> resultado = psExecuteQueryListar(sql);
		
		for(int i=0; i<resultado.size(); i++) {
			
			Map<String, Object> map = resultado.get(i);
			
        	int id = (int)map.get("ID");
            String nombre = map.get("NOMBRE").toString();
            String calle = map.get("CALLE").toString();
            int altura = (int)map.get("ALTURA");
            String localidad = map.get("LOCALIDAD").toString();
            int pisos = (int)map.get("PISOS");

            UFDAO dao = new UFDAOH2Impl();
            
            MovimientoDAO dao2 = new MovimientoDAOH2Impl();
            
            Edificio edificio= new Edificio(id, nombre, calle, altura, localidad, pisos, dao.listarUF(id), dao2.listarMovimientos(id));
            
            listaEdificios.add(edificio);
		}
		
		return listaEdificios;
		
	}
}
