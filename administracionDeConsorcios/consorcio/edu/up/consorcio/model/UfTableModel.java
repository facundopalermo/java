package edu.up.consorcio.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import edu.up.consorcio.clase.UF;

public class UfTableModel extends AbstractTableModel {
	private static final int COLUMNA_U = 0;
	private static final int COLUMNA_F = 1;
	private static final int COLUMNA_MC = 2;
	private static final int COLUMNA_OCUPANTE = 3;
	
	private String[] nombresColumnas = {"Piso", "Dpto", "mts\u00B2", "Ocupante"};
	
	private Class[] tiposColumnas = {int.class, int.class, int.class, String.class};

	private List<UF> contenido;

	public UfTableModel() {
		contenido = new ArrayList<UF>();
	}
	
	public UfTableModel(List<UF> contenidoInicial) {
		contenido = contenidoInicial;
	}

	public int getColumnCount() {
		return nombresColumnas.length;
	}

	public int getRowCount() {
		return contenido.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		
		UF uf = contenido.get(rowIndex);
		
		Object result = null;
		switch(columnIndex) {
		case COLUMNA_U:
			result = uf.getU();
			break;
		case COLUMNA_F:
			result = uf.getF();
			break;
		case COLUMNA_MC:
			result = uf.getSuperficie();
			break;
		case COLUMNA_OCUPANTE:
			result = uf.getOcupante();
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
    
    public List<UF> getContenido() {
    	return contenido;
    }

    public void setContenido(List<UF> contenido) {
    	this.contenido = contenido;
    }
}
