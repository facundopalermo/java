package edu.up.consorcio.DAO;

import java.util.List;

import edu.up.config.excepciones.DAOException;
import edu.up.consorcio.clase.Expensas;
import edu.up.consorcio.clase.UF;

public interface ExpensasDAO {
	
	void crearExpensas(UF uf, Expensas expensas) throws DAOException;
	void modificarExpensa(Expensas expensas) throws DAOException;
	List<Expensas> listarExpensas(int uf) throws DAOException;
	
}
