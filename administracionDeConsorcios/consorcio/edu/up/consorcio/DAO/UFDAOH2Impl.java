package edu.up.consorcio.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import edu.up.config.db.EntidadDAOH2Impl;
import edu.up.config.excepciones.DAOException;
import edu.up.consorcio.clase.Edificio;
import edu.up.consorcio.clase.UF;

public class UFDAOH2Impl extends EntidadDAOH2Impl implements UFDAO {

	@Override
	public void crearUF(UF uf, Edificio edificio) throws DAOException {
		String sql = "INSERT INTO UF (edificio, u, f, mc, ocupante) VALUES (?,?,?,?,?)";
		ArrayList<Object> objs = new ArrayList<Object>();
		objs.add(edificio.getId());
		objs.add(uf.getU());
		objs.add(uf.getF());
		objs.add(uf.getSuperficie());
		objs.add(uf.getOcupante());
		
        psExecuteUpdate(sql, objs);
	}

	@Override
	public void borrarUF(UF uf) throws DAOException {
		String sql = "DELETE FROM UF WHERE id = ?";
		ArrayList<Object> objs = new ArrayList<Object>();
		objs.add(uf.getId());
		
		psExecuteUpdate(sql, objs);
	}

	@Override
	public void modificarUF(UF uf) throws DAOException {
		String sql = "UPDATE UF SET ocupante = ? WHERE id = ?";
		ArrayList<Object> objs = new ArrayList<Object>();
		objs.add(uf.getOcupante());
		objs.add(uf.getId());
		
		psExecuteUpdate(sql, objs);
	}

	@Override
	public UF verUF(int idUF) throws DAOException {
		UF uf=null;
		String sql = "SELECT * FROM UF WHERE id = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(idUF);
		
		List<Map<String, Object>> resultado = psExecuteQuerySelect(sql, objs);
		
		Map<String, Object> map = resultado.get(0);
			
        int id = (int)map.get("ID");
        int u = (int)map.get("U");
        int f = (int)map.get("F");
        int mc = (int)map.get("MC");
        String ocupante = map.get("OCUPANTE").toString();
        
        ExpensasDAO dao = new ExpensasDAOH2Impl();
        
        uf= new UF(id, u, f, mc, ocupante, dao.listarExpensas(id));
            
		return uf;
	}

	@Override
	public List<UF> listarUF(int edificio) throws DAOException {
		
		List<UF> listaUF = new ArrayList<UF>();
		
		String sql = "SELECT * FROM UF WHERE edificio = "+ edificio +" ORDER BY u, f";
		
		
		List<Map<String, Object>> resultado = psExecuteQueryListar(sql);
		
		for(int i=0; i<resultado.size(); i++) {
		
			Map<String, Object> map = resultado.get(i);
				
	        int id = (int)map.get("ID");
	        int u = (int)map.get("U");
	        int f = (int)map.get("F");
	        int mc = (int)map.get("MC");
	        String ocupante = map.get("OCUPANTE").toString();
	        ExpensasDAO dao = new ExpensasDAOH2Impl();
	        
	        UF uf= new UF(id, u, f, mc, ocupante, dao.listarExpensas(id));
	        
	        listaUF.add(uf);
		}
            
		return listaUF;
	}
	
	public void borrarUFEdificio(Edificio edificio) throws DAOException {
		String sql = "DELETE FROM UF WHERE edificio = ?";
		ArrayList<Object> objs = new ArrayList<Object>();
		objs.add(edificio.getId());
		
		psExecuteUpdate(sql, objs);
	}

}
