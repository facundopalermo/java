package edu.up.consorcio.ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import edu.up.config.excepciones.ClaveDuplicadaServiceException;
import edu.up.config.excepciones.DAOServiceException;
import edu.up.config.mensaje.Mensaje;
import edu.up.config.sesion.Sesion;
import edu.up.consorcio.clase.Edificio;
import edu.up.consorcio.services.EdificioService;
import edu.up.panelManager.PanelManager;

public class DatosEdificioPanel extends JPanel implements ActionListener {

	private PanelManager manejador=Sesion.getManejador();
	
	private JLabel lbl_nombre = new JLabel("Nombre: ");
	private JLabel lbl_direccion = new JLabel("Dirección: ");
	private JLabel lbl_numero = new JLabel("N°: ");
	private JLabel lbl_localidad = new JLabel("Localidad: ");
	private JLabel lbl_pisos = new JLabel("N° de pisos: ");
	
	private JTextField txt_nombre = new JTextField(20);
	private JTextField txt_direccion = new JTextField(15);
	private JTextField txt_numero = new JTextField(5);
	private JTextField txt_localidad = new JTextField(20);
	private JTextField txt_pisos = new JTextField(5);
	
	private JPanel panel_nombre = new JPanel();
	private JPanel panel_direccion = new JPanel();
	private JPanel panel_localidad = new JPanel();
	private JPanel panel_pisos = new JPanel();
	
	private JButton botonGuardar = new JButton("Guardar");
	private JButton botonCrear = new JButton("Crear");
	
	private JPanel panel_botonera = new JPanel();
	
	public void armar() {
		
		panel_nombre.setLayout(new FlowLayout());
		panel_direccion.setLayout(new FlowLayout());
		panel_localidad.setLayout(new FlowLayout());
		panel_pisos.setLayout(new FlowLayout());
		
		panel_nombre.add(lbl_nombre);
		panel_nombre.add(txt_nombre);
		txt_nombre.setEnabled(false);
		
		panel_direccion.add(lbl_direccion);
		panel_direccion.add(txt_direccion);
		panel_direccion.add(lbl_numero);
		panel_direccion.add(txt_numero);
		
		panel_localidad.add(lbl_localidad);
		panel_localidad.add(txt_localidad);
		
		panel_pisos.add(lbl_pisos);
		panel_pisos.add(txt_pisos);
				
		botonGuardar.addActionListener(this);
		botonCrear.addActionListener(this);
	}
	
	public void mostrarCamposCrear() {
		mostrarCamposModificar();
		panel_botonera.remove(botonGuardar);
		panel_botonera.add(botonCrear);
		txt_nombre.setEnabled(true);
	}
	
	public void mostrarCamposModificar() {
		this.add(panel_nombre);
		this.add(panel_direccion);
		this.add(panel_localidad);
		this.add(panel_pisos);
		panel_botonera.add(botonGuardar);
		panel_botonera.remove(botonCrear);
		this.add(panel_botonera);
	}
	
	public void llenarFormulario(Edificio edificio) {
		txt_nombre.setText(edificio.getNombre());
		txt_direccion.setText(edificio.getDir_calle());
		txt_numero.setText(String.valueOf(edificio.getDir_altura()));
		txt_localidad.setText(edificio.getDir_localidad());
		txt_pisos.setText(String.valueOf(edificio.getN_pisos()));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Edificio edificio = new Edificio(txt_nombre.getText(),txt_direccion.getText(),Integer.parseInt(txt_numero.getText()),txt_localidad.getText(),Integer.parseInt(txt_pisos.getText()));
		
		if(e.getSource()==botonCrear) {
			try {
				EdificioService.CrearEdificio(edificio);
				Mensaje.info(this, "Exito al crear el edificio", "Crear edificio");
				SwingUtilities.getWindowAncestor(botonCrear).dispose();
			} catch (DAOServiceException e1) {Mensaje.error(this, "Error critico al intentar crear el edificio", "Error Crítico", e1);
			} catch (ClaveDuplicadaServiceException e1) {Mensaje.info(this, "El edificio que intenta crear ya existe. No se ha guardado", "Error al crear edificio");
			}finally {
				manejador.actualizarTablaEdificio();
			}
		}else
			if(e.getSource()==botonGuardar) {
				try {
					EdificioService.GuardarEdificio(edificio);
					Mensaje.info(this, "Exito al guardar el edificio", "Modificar edificio");
					SwingUtilities.getWindowAncestor(botonGuardar).dispose();
				} catch (DAOServiceException e1) {Mensaje.error(this, "Error critico al intentar guardar el edificio", "Error Crítico", e1);
				}finally {
					manejador.actualizarTablaEdificio();
				}
			}
	}
}
