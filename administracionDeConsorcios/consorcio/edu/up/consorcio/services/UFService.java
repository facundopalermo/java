package edu.up.consorcio.services;

import java.util.ArrayList;
import java.util.List;

import edu.up.config.excepciones.DAOException;
import edu.up.config.excepciones.DAOServiceException;
import edu.up.config.excepciones.PisoMaxServiceException;
import edu.up.consorcio.DAO.UFDAO;
import edu.up.consorcio.DAO.UFDAOH2Impl;
import edu.up.consorcio.clase.Edificio;
import edu.up.consorcio.clase.UF;

public class UFService {

	private static UFDAO dao = new UFDAOH2Impl();
	
	public static List<UF> obtenerDepartamentos(int edificio) throws DAOServiceException{
		
		List<UF> datos = new ArrayList<UF>();
		try {
			datos = dao.listarUF(edificio);
		} catch (DAOException e) {
			throw new DAOServiceException(e);
		}
		return datos;
	}
	
	public static void nuevaUF(UF uf, Edificio edificio) throws DAOServiceException{
		try {
			dao.crearUF(uf, edificio);
		} catch (DAOException e) {
			throw new DAOServiceException(e);
		}
	}

	public static void borrarUF(UF uf)throws DAOServiceException {
		try {
			dao.borrarUF(uf);
		} catch (DAOException e) {
			throw new DAOServiceException(e);
		}
		
	}

	public static void guardarUF(UF uf)throws DAOServiceException {
		try {
			dao.modificarUF(uf);
		} catch (DAOException e) {
			throw new DAOServiceException(e);
		}
		
	}
	
	public static void validarPiso(int piso, int pisoMax) throws PisoMaxServiceException {
		if(piso>pisoMax) {
			throw new PisoMaxServiceException(piso+" es mayor a "+pisoMax);
		}
	}

}
