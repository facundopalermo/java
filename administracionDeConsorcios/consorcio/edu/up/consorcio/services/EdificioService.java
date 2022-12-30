package edu.up.consorcio.services;

import java.util.ArrayList;
import java.util.List;

import edu.up.config.excepciones.ClaveDuplicadaDAOException;
import edu.up.config.excepciones.ClaveDuplicadaServiceException;
import edu.up.config.excepciones.DAOException;
import edu.up.config.excepciones.DAOServiceException;
import edu.up.consorcio.DAO.EdificioDAO;
import edu.up.consorcio.DAO.EdificioDAOH2Impl;
import edu.up.consorcio.clase.Edificio;

public class EdificioService {
	
	private static EdificioDAO dao = new EdificioDAOH2Impl();
	
	public static void CrearEdificio(Edificio edificio) throws DAOServiceException, ClaveDuplicadaServiceException {
		try {
			dao.crearEdificio(edificio);
		} catch (DAOException e) {
			throw new DAOServiceException();
		} catch (ClaveDuplicadaDAOException e) {
			throw new ClaveDuplicadaServiceException(e);
		}
	}
	
	public static void GuardarEdificio(Edificio edificio) throws DAOServiceException {
		try {
			dao.modificarEdificio(edificio);
		} catch (DAOException e) {
			throw new DAOServiceException(e);
		}
	}
	
	public static void BorrarEdificio(Edificio edificio) throws DAOServiceException {
		try {
			dao.borrarEdificio(edificio);
		} catch (DAOException e) {
			throw new DAOServiceException(e);
		}
	}
	
	public static List<Edificio> obtenerDatos() throws DAOServiceException{
		
		List<Edificio> datos = new ArrayList<Edificio>();
		try {
			datos = dao.listarEdificios();
		} catch (DAOException e) {
			throw new DAOServiceException(e);
		}
		return datos;
	}
}
