package edu.up.consorcio.DAO;

import java.util.List;

import edu.up.config.excepciones.DAOException;
import edu.up.consorcio.clase.Edificio;
import edu.up.consorcio.clase.Movimiento;

public interface MovimientoDAO {
	
	void crearMovimiento(Movimiento movimiento, Edificio edificio) throws DAOException;
	List<Movimiento> listarMovimientos(int id) throws DAOException;
}
