package edu.up.consorcio.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import edu.up.config.excepciones.DAOServiceException;
import edu.up.config.excepciones.PisoMaxServiceException;
import edu.up.config.mensaje.Mensaje;
import edu.up.config.sesion.Sesion;
import edu.up.consorcio.clase.Edificio;
import edu.up.consorcio.clase.UF;
import edu.up.consorcio.services.UFService;
import edu.up.panelManager.PanelManager;

public class DatosUFPanel extends JPanel implements ActionListener{
	
	private PanelManager manejador=Sesion.getManejador();
	private UFTablePanel ufTablePanel;
	private Edificio edificio;
	private UF uf;
	private int temp_id;
	
	private JLabel lbl_piso = new JLabel("Piso:");
	private JLabel lbl_dpto = new JLabel("Dpto:");
	private JLabel lbl_superficie = new JLabel("Superficie (M\u00B2):");
	private JLabel lbl_Ocupante = new JLabel("Ocupante:");
	
	private JTextField txt_piso = new JTextField(5);
	private JTextField txt_dpto = new JTextField(5);
	private JTextField txt_superficie = new JTextField(5);
	private JTextField txt_Ocupante = new JTextField(23);
	
	private JPanel aux=new JPanel();
	private JPanel aux_ocupante = new JPanel();
	private JPanel aux_boton = new JPanel(); //para que el boton no se agrande
	
	private JButton botonGuardar = new JButton("Guardar");
	private JButton botonCrear = new JButton("Crear");
	
	
	public DatosUFPanel(UFTablePanel ufTablePanel) {
		this.ufTablePanel=ufTablePanel;
	}

	public void armar(String tipo, Edificio edificio, UF uf) {
		
		this.edificio=edificio;
		this.uf=uf;
		
		aux.add(lbl_piso);
		aux.add(txt_piso);
		aux.add(lbl_dpto);
		aux.add(txt_dpto);
		aux.add(lbl_superficie);
		aux.add(txt_superficie);
		aux_ocupante.add(lbl_Ocupante);
		aux_ocupante.add(txt_Ocupante);
		
		setLayout(new GridLayout(3, 1));

		if(tipo.equals("nuevo")) {
			aux_boton.add(botonCrear);
			botonCrear.addActionListener(this);
		}else {
			aux_boton.add(botonGuardar);
			botonGuardar.addActionListener(this);
			txt_piso.setEditable(false);
			txt_dpto.setEditable(false);
			txt_superficie.setEditable(false);
			llenarFormulario();
		}
		
		this.add(aux);
		this.add(aux_ocupante);
		this.add(aux_boton);
	}
	
	private void llenarFormulario() {
		temp_id=uf.getId();
		txt_piso.setText(String.valueOf(uf.getU()));
		txt_dpto.setText(String.valueOf(uf.getF()));
		txt_superficie.setText(String.valueOf(uf.getSuperficie()));
		txt_Ocupante.setText(uf.getOcupante());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==botonCrear) {
			try {
				UFService.validarPiso(Integer.valueOf(txt_piso.getText()), edificio.getN_pisos());
				try {
					uf=new UF(Integer.valueOf(txt_piso.getText()), Integer.valueOf(txt_dpto.getText()), Integer.valueOf(txt_superficie.getText()), txt_Ocupante.getText());
					try {
						UFService.nuevaUF(uf, edificio);
						Mensaje.info(this, "Exito al crear el departamento", "Crear UF");
						SwingUtilities.getWindowAncestor(botonCrear).dispose();
					} catch (DAOServiceException e1) {Mensaje.error(this, "Error critico al intentar crear la UF", "Error Crítico", e1);	}	
				}catch(NumberFormatException num) {Mensaje.error(this,"Piso, dpto y superficie solo admiten números enteros", "Error de datos", null);}
				finally {
					ufTablePanel.updateContenido();
				}
			}catch(PisoMaxServiceException e2){Mensaje.error(this, "El piso no puede ser superior a la cantidad de pisos del edificio", "Error al crear UF", e2);
			}
		}else
		if(e.getSource()==botonGuardar) {
			uf=new UF(temp_id, Integer.valueOf(txt_piso.getText()), Integer.valueOf(txt_dpto.getText()), Integer.valueOf(txt_superficie.getText()), txt_Ocupante.getText());
			try {
				UFService.guardarUF(uf);
				Mensaje.info(this, "Exito al guardar la UF", "Modificar ocupante");
				SwingUtilities.getWindowAncestor(botonGuardar).dispose();
			} catch (DAOServiceException e1) {Mensaje.error(this, "Error critico al intentar guardar la UF", "Error Crítico", e1);
			}finally {
				ufTablePanel.updateContenido();
			}
		}
	}
}
