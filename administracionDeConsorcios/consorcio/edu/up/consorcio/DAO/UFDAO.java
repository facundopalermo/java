package edu.up.consorcio.DAO;

import java.util.List;

import edu.up.config.excepciones.DAOException;
import edu.up.consorcio.clase.Edificio;
import edu.up.consorcio.clase.UF;

public interface UFDAO {
	
	void crearUF(UF uf, Edificio edificio) throws DAOException;
	void borrarUF(UF uf) throws DAOException;
	void modificarUF(UF uf) throws DAOException;
	UF verUF(int id) throws DAOException;
	List<UF> listarUF(int edificio) throws DAOException;
	void borrarUFEdificio(Edificio edificio) throws DAOException;
	
}
