package edu.up.consorcio.model;

import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;

import edu.up.config.excepciones.DAOServiceException;
import edu.up.config.mensaje.Mensaje;
import edu.up.consorcio.clase.Edificio;
import edu.up.consorcio.services.EdificioService;

//De recuerdo nomas, no lo usé

public class EdificioComboBoxModel extends DefaultComboBoxModel<Edificio> {

	public EdificioComboBoxModel() {
		super();
		setDatos();
		// TODO Auto-generated constructor stub
	}

	public EdificioComboBoxModel(Edificio[] items) {
		super(items);
		// TODO Auto-generated constructor stub
	}

	public EdificioComboBoxModel(Vector<Edificio> v) {
		super(v);
		// TODO Auto-generated constructor stub
	}
	
	private void setDatos() {
		Vector<Edificio>vector = new Vector<Edificio>();
		
		List<Edificio> aux=null;
		try {
			aux = EdificioService.obtenerDatos();
		} catch (DAOServiceException e) {
			Mensaje.error(null, "Error critico al intentar obtener los datos", "Error Crítico", e);
		}
		
		for(Edificio v :aux) {
			vector.addElement(v);
		}
		
		super.addAll(vector);
	}
	
	public void actualizarDatos() {
		setDatos();
	}
	
	
}
