package edu.up.config.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.up.config.excepciones.DAOException;


public abstract class EntidadDAOH2Impl {
	
	public void psExecuteUpdate(String sentenciaSQL, List<Object> valores) throws DAOException{
        Connection c = null;
        int i=1;
        
        try{
        	c = DBManager.connect();
            PreparedStatement ps = c.prepareStatement(sentenciaSQL);
            
            for (Object val : valores){
            	if (val instanceof String)
            		ps.setString(i, val.toString());
            	else if (val instanceof Integer)
            		ps.setInt(i, (Integer) val);
            	else if (val instanceof Double)
            		ps.setDouble(i, (Double) val);
            	else if (val instanceof LocalDate)
            		ps.setDate(i, java.sql.Date.valueOf((LocalDate) val));
            	i++;
            }

            if (ps.executeUpdate() == 0) {
                throw new DAOException("La operación solicitada no surtió ningún efecto");
            }
            
            c.commit();
            
        }catch (SQLException ex){
        	try {
				c.rollback();
	            throw new DAOException(ex, ex.getErrorCode());
			} catch (SQLException e) {
                throw new DAOException(e);
			}
        }finally{
        	try {
        		if (c!=null)
        			c.close();
			} catch (SQLException e) {
                throw new DAOException(e);
			}
        }
	}
	
	public List<Map<String, Object>> psExecuteQuerySelect(String sentenciaSQL, List<Object> valores) throws DAOException{
        Connection c = null;
        ResultSet rs = null;
        List<Map<String, Object>> lista = new ArrayList<>();
        int i = 1;
        int cont_filas = 0;
        try {
        	c = DBManager.connect();
        	PreparedStatement ps = c.prepareStatement(sentenciaSQL);
            
            for (Object val : valores){
            	if (val instanceof String)
            		ps.setString(i, val.toString());
            	else if (val instanceof Integer)
            		ps.setInt(i, (Integer) val);
            	i++;
            }
            
            rs = ps.executeQuery();
            
            while (rs.next()){
            	int cont_columnas = rs.getMetaData().getColumnCount();
            	Map<String, Object> map = new HashMap<String, Object>();
            	for (int j=1; j<=cont_columnas; j++)
            		map.put(rs.getMetaData().getColumnName(j), rs.getObject(j));
            	lista.add(map);
            	cont_filas++;
            }
            if (cont_filas == 0)
            	throw new DAOException("No existe el registro solicitado en la Base de Datos");
        } catch (SQLException ex) {
        	try {
				c.rollback();
	            throw new DAOException(ex);
			} catch (SQLException e) {
                throw new DAOException(e);
			}
        } finally {
	    	try {
	    		if (c!=null)
	    			c.close();
			} catch (SQLException e) {
	            throw new DAOException(e);
			}
        }
        return lista;
	}
	
	public List<Map<String, Object>> psExecuteQueryListar(String sentenciaSQL) throws DAOException{
        Connection c = null;
        ResultSet rs = null;
        List<Map<String, Object>> lista = new ArrayList<>();
        try {
        	c = DBManager.connect();
            Statement s = c.createStatement();
            
            rs = s.executeQuery(sentenciaSQL);
            while (rs.next()){
            	int cols = rs.getMetaData().getColumnCount();
            	Map<String, Object> map = new HashMap<String, Object>();
            	for (int j=1; j<=cols; j++)
            		map.put(rs.getMetaData().getColumnName(j), rs.getObject(j));
            	lista.add(map);
            }
        } catch (SQLException ex) {
        	try {
				c.rollback();
	            throw new DAOException(ex);
			} catch (SQLException e) {
                throw new DAOException(e);
			}
        }
        finally {
        	try {
        		if (c!=null)
        			c.close();
			} catch (SQLException e) {
                throw new DAOException(e);
			}
        }
        return lista;
	}
}
