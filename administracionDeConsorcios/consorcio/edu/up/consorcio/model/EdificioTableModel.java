package edu.up.consorcio.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import edu.up.consorcio.clase.Edificio;


public class EdificioTableModel extends AbstractTableModel {

	private static final int COLUMNA_NOMBRE = 0;
	
	private String[] nombresColumnas = {"Edificio"};
	
	private Class[] tiposColumnas = {String.class};

	private List<Edificio> contenido;

	public EdificioTableModel() {
		contenido = new ArrayList<Edificio>();
	}
	
	public EdificioTableModel(List<Edificio> contenidoInicial) {
		contenido = contenidoInicial;
	}

	public int getColumnCount() {
		return nombresColumnas.length;
	}

	public int getRowCount() {
		return contenido.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Edificio r = contenido.get(rowIndex);
		
		Object result = null;
		switch(columnIndex) {
		case COLUMNA_NOMBRE:
			result = r.getNombre();
			break;
		default:
			result = new String("");
		}
		
		return result;
	}

	public String getColumnName(int col) {
        return nombresColumnas[col];
    }

    public Class getColumnClass(int col) {
        return tiposColumnas[col];
    }
    
    public List<Edificio> getContenido() {
    	return contenido;
    }

    public void setContenido(List<Edificio> contenido) {
    	this.contenido = contenido;
    }

}
