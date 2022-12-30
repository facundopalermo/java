package edu.up.consorcio.DAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import edu.up.config.db.EntidadDAOH2Impl;
import edu.up.config.excepciones.DAOException;
import edu.up.consorcio.clase.Edificio;
import edu.up.consorcio.clase.Movimiento;

public class MovimientoDAOH2Impl extends EntidadDAOH2Impl implements MovimientoDAO {

	@Override
	public void crearMovimiento(Movimiento movimiento, Edificio edificio) throws DAOException {
		String sql = "INSERT INTO movimiento (edificio, fecha, detalle, entrada, salida) VALUES (?,?,?,?,?)";
		ArrayList<Object> objs = new ArrayList<Object>();
		
		objs.add(edificio.getId());
		objs.add(movimiento.getFecha());
		objs.add(movimiento.getDetalle());
		objs.add(movimiento.getEntrada());
		objs.add(movimiento.getSalida());
		
		psExecuteUpdate(sql, objs);
	}

	@Override
	public List<Movimiento> listarMovimientos(int edificio) throws DAOException {
		String sql = "SELECT * FROM movimiento WHERE edificio = " + edificio + " ORDER BY fecha";
		
		List<Movimiento> movimientos = new ArrayList<Movimiento>();
		
		List<Map<String, Object>> resultado = psExecuteQueryListar(sql);
		
		for(int i=0; i<resultado.size(); i++) {
			
			Map<String, Object> map = resultado.get(i);
			
			int id = (int)map.get("ID");
			LocalDate fecha = ((java.sql.Date) map.get("FECHA")).toLocalDate();
			String detalle = map.get("DETALLE").toString();
			double entrada = (double)map.get("ENTRADA");
			double salida = (double)map.get("SALIDA");
			
			Movimiento mv = new Movimiento(id, fecha, detalle, entrada, salida);
			
			movimientos.add(mv);
		}
		
		return movimientos;
		
	}

}
