package edu.up.usuarios.tablemodel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import edu.up.usuarios.clase.Usuario;
import edu.up.usuarios.clase.Administrador;

public class UsuarioTableModel extends AbstractTableModel {
	
	private static final int COLUMNA_NOMBRE = 0;
	private static final int COLUMNA_APELLIDO = 1;
	private static final int COLUMNA_EMAIL = 2;
	private static final int COLUMNA_USUARIO = 3;
	private static final int COLUMNA_TIPO = 4;
	
	private String[] nombresColumnas = {"Nombre", "Apellido", "Email", "Usuario", "Tipo"};
	
	private Class[] tiposColumnas = {String.class, String.class, String.class, String.class, String.class};

	private List<Usuario> contenido;

	public UsuarioTableModel() {
		contenido = new ArrayList<Usuario>();
	}
	
	public UsuarioTableModel(List<Usuario> contenidoInicial) {
		contenido = contenidoInicial;
	}

	public int getColumnCount() {
		return nombresColumnas.length;
	}

	public int getRowCount() {
		return contenido.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Usuario u = contenido.get(rowIndex);
		
		Object result = null;
		switch(columnIndex) {
		case COLUMNA_NOMBRE:
			result = u.getNombre();
			break;
		case COLUMNA_APELLIDO:
			result = u.getApellido();
			break;
		case COLUMNA_EMAIL:
			result = u.getEmail();
			break;
		case COLUMNA_USUARIO:
			result = u.getUser();
			break;
		case COLUMNA_TIPO:
			if(u instanceof Administrador) {
				result = "Administrador";
			}else {
				result = "Usuario";
			}
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
    
    public List<Usuario> getContenido() {
    	return contenido;
    }

    public void setContenido(List<Usuario> contenido) {
    	this.contenido = contenido;
    }
}

