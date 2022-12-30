package edu.up.consorcio.services;

import edu.up.consorcio.DAO.MovimientoDAOH2Impl;
import edu.up.config.excepciones.DAOException;
import edu.up.config.excepciones.DAOServiceException;
import edu.up.consorcio.DAO.MovimientoDAO;
import edu.up.consorcio.clase.Edificio;
import edu.up.consorcio.clase.Movimiento;

public class MovimientoService {

	private static MovimientoDAO dao = new MovimientoDAOH2Impl();
	
	public static void crearMovimiento(Movimiento mv, Edificio edificio) throws DAOServiceException {
		
		try {
			dao.crearMovimiento(mv, edificio);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new DAOServiceException(e);
		}
		
	}

}
