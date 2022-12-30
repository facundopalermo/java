package edu.up.consorcio.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import edu.up.consorcio.clase.Expensas;

public class ExpensasTableModel extends AbstractTableModel{

	private static final int COLUMNA_ID = 0;
	private static final int COLUMNA_MES = 1;
	private static final int COLUMNA_ANIO = 2;
	private static final int COLUMNA_DEUDA = 3;
	private static final int COLUMNA_INTERES = 4;
	private static final int COLUMNA_EXPENSAS = 5;
	private static final int COLUMNA_TOTAL = 6;
	private static final int COLUMNA_PAGADO = 7;
	private static final int COLUMNA_FECHA = 8;
	
	private String[] nombresColumnas = {"ID", "Mes", "Año", "Deuda", "Interes", "Expensas", "Total", "Pagado", "Fecha de Pago"};
	
	private Class[] tiposColumnas = {int.class, int.class, int.class, double.class, double.class, double.class, double.class, double.class, LocalDate.class};

	private List<Expensas> contenido;

	public ExpensasTableModel() {
		contenido = new ArrayList<Expensas>();
	}
	
	public ExpensasTableModel(List<Expensas> contenidoInicial) {
		contenido = contenidoInicial;
	}

	public int getColumnCount() {
		return nombresColumnas.length;
	}

	public int getRowCount() {
		return contenido.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Expensas ex = contenido.get(rowIndex);

		Object result = null;
		switch(columnIndex) {
		case COLUMNA_ID:
			result = ex.getId();
			break;
		case COLUMNA_MES:
			result = ex.getMes();
			break;
		case COLUMNA_ANIO:
			result = ex.getAnio();
			break;
		case COLUMNA_DEUDA:
			result = ex.getDeuda();
			break;
		case COLUMNA_INTERES:
			result = ex.getInteresDeuda();
			break;
		case COLUMNA_EXPENSAS:
			result = ex.getExpensaActual();
			break;
		case COLUMNA_TOTAL:
			result = ex.getTotal();
			break;
		case COLUMNA_PAGADO:
			result = ex.getPago();
			break;
		case COLUMNA_FECHA:
			result = ex.getFechaPago();
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
    
    public List<Expensas> getContenido() {
    	return contenido;
    }

    public void setContenido(List<Expensas> contenido) {
    	this.contenido = contenido;
    }

}
