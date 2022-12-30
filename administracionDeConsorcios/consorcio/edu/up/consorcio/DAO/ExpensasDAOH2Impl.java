package edu.up.consorcio.DAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import edu.up.config.db.EntidadDAOH2Impl;
import edu.up.config.excepciones.DAOException;
import edu.up.consorcio.clase.Expensas;
import edu.up.consorcio.clase.UF;

public class ExpensasDAOH2Impl extends EntidadDAOH2Impl implements ExpensasDAO {

	@Override
	public void crearExpensas(UF uf, Expensas expensas) throws DAOException {
		String sql = "INSERT INTO expensas (uf, mes, anio, deuda, interesdeuda, expensaactual, total, pago) VALUES (?,?,?,?,?,?,?,?)";
		ArrayList<Object> objs = new ArrayList<Object>();
		objs.add(uf.getId());
		objs.add(expensas.getMes());
		objs.add(expensas.getAnio());
		objs.add(expensas.getDeuda());
		objs.add(expensas.getInteresDeuda());
		objs.add(expensas.getExpensaActual());
		objs.add(expensas.getTotal());
		objs.add(expensas.getPago());

        psExecuteUpdate(sql, objs);
	}

	@Override
	public void modificarExpensa(Expensas expensas) throws DAOException {
		String sql = "UPDATE expensas SET pago = ? , fechaPago = ? WHERE id = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(expensas.getPago());
		objs.add(expensas.getFechaPago());
		objs.add(expensas.getId());
		
		psExecuteUpdate(sql, objs);
	}


	@Override
	public List<Expensas> listarExpensas(int uf) throws DAOException {
		
		List<Expensas> listaExpensas = new ArrayList<Expensas>();
		
		String sql = "SELECT * FROM expensas WHERE uf = " + uf + "ORDER BY mes, anio";
		List<Map<String, Object>> resultado = psExecuteQueryListar(sql);
		
		for(int i=0; i<resultado.size(); i++) {
			
			Map<String, Object> map = resultado.get(i);

        	int id = (int)map.get("ID");
        	int mes = (int)map.get("MES");
            int anio = (int)map.get("ANIO");
            double deuda = (double)map.get("DEUDA");
            double interesDeuda = (double)map.get("INTERESDEUDA");
            double expensaActual = (double)map.get("EXPENSAACTUAL");
            double total = (double)map.get("TOTAL");
            double pago = (double)map.get("PAGO");
            LocalDate fechaPago;
            
            if((map.get("FECHAPAGO"))!=null) {
            	fechaPago = ((java.sql.Date) map.get("FECHAPAGO")).toLocalDate();
            }else {
            	fechaPago=null;
            }
            
            Expensas expensas= new Expensas(id, mes, anio, deuda, interesDeuda, expensaActual, total, pago, fechaPago);
            
            listaExpensas.add(expensas);
		}
		
		return listaExpensas;
	}

}
