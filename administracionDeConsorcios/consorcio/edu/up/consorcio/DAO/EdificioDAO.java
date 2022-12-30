package edu.up.consorcio.DAO;

import java.util.List;

import edu.up.config.excepciones.ClaveDuplicadaDAOException;
import edu.up.config.excepciones.DAOException;
import edu.up.consorcio.clase.Edificio;

public interface EdificioDAO {
	
	void crearEdificio(Edificio edificio) throws DAOException, ClaveDuplicadaDAOException;
	void borrarEdificio(Edificio edificio) throws DAOException;
	void modificarEdificio(Edificio edificio) throws DAOException;
	List<Edificio> listarEdificios() throws DAOException;
	
	//Edificio verEdificio(String nombre) throws DAOException;
		
}
