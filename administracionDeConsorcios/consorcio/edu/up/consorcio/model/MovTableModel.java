package edu.up.consorcio.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import edu.up.consorcio.clase.Movimiento;

public class MovTableModel extends AbstractTableModel {
	private static final int COLUMNA_FECHA = 0;
	private static final int COLUMNA_DESCRIPCION = 1;
	private static final int COLUMNA_ENTRADA = 2;
	private static final int COLUMNA_SALIDA = 3;
	
	
	private String[] nombresColumnas = {"Fecha", "Descripción", "Entrada", "Salida"};
	
	private Class[] tiposColumnas = {LocalDate.class, String.class, double.class, double.class};

	private List<Movimiento> contenido;

	public MovTableModel() {
		contenido = new ArrayList<Movimiento>();
	}
	
	public MovTableModel(List<Movimiento> contenidoInicial) {
		contenido = contenidoInicial;
	}

	public int getColumnCount() {
		return nombresColumnas.length;
	}

	public int getRowCount() {
		return contenido.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Movimiento mv = contenido.get(rowIndex);
		
		Object result = null;
		
		switch(columnIndex) {
		case COLUMNA_FECHA:
			result = mv.getFecha();
			break;
		case COLUMNA_DESCRIPCION:
			result = mv.getDetalle();
			break;
		case COLUMNA_ENTRADA:
			result = String.format("%.2f",mv.getEntrada());
			break;
		case COLUMNA_SALIDA:
			result = String.format("%.2f",mv.getSalida());
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
    
    public List<Movimiento> getContenido() {
    	return contenido;
    }

    public void setContenido(List<Movimiento> contenido) {
    	this.contenido = contenido;
    }
}
