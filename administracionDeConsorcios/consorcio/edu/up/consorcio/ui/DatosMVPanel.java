package edu.up.consorcio.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import edu.up.config.excepciones.DAOServiceException;
import edu.up.config.mensaje.Mensaje;
import edu.up.config.otros.FechaUtil;
import edu.up.config.sesion.Sesion;
import edu.up.consorcio.clase.Edificio;
import edu.up.consorcio.clase.Movimiento;
import edu.up.consorcio.services.MovimientoService;
import edu.up.panelManager.PanelManager;


public class DatosMVPanel extends JPanel implements ActionListener {
	
	private PanelManager manejador = Sesion.getManejador();
	
	private JLabel tipo_lbl = new JLabel("Tipo");
	
	String[] tipo= {"Egreso", "Ingreso"};
	private JComboBox tipo_combo = new JComboBox(tipo);
	
	private JLabel fecha_lbl = new JLabel("Fecha");
	private JTextField fecha_txt = new JTextField();
	
	private JLabel descripcion_lbl = new JLabel("Descripción:");
	private JTextField descripcion_txt = new JTextField(100);
	
	private JLabel importe_lbl = new JLabel("Importe:");
	private JTextField importe_txt = new JTextField();
	
	private JButton guardarBoton = new JButton("Guardar");
	private JButton cancelarBoton = new JButton("Cancelar");
	private Edificio edificio;
	
	public DatosMVPanel(Edificio edificio) {
		super();
		armar();
		this.edificio=edificio;
	}
	
	private void armar() {
		setLayout(new GridLayout(5, 2));
		
		fecha_txt.setText(FechaUtil.getHoy());
		
		if(!Sesion.isAdmin()) {
			fecha_txt.setEditable(false);
			fecha_txt.setToolTipText("Solo administradores pueden establecer una fecha diferente a hoy");
		}
		
		
		add(tipo_lbl);
		add(tipo_combo);
		add(fecha_lbl);
		add(fecha_txt);
		add(descripcion_lbl);
		add(descripcion_txt);
		add(importe_lbl);
		add(importe_txt);
		add(guardarBoton);
		add(cancelarBoton);
		
		guardarBoton.addActionListener(this);
		cancelarBoton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==guardarBoton) {
			
			try {
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				Movimiento mv=new Movimiento(LocalDate.parse(fecha_txt.getText(), dtf), descripcion_txt.getText());
				
				if(tipo_combo.getSelectedItem().equals("Egreso")) {
					mv.setSalida(Double.valueOf(importe_txt.getText()));
					mv.setEntrada(0);
				}else {
					mv.setEntrada(Double.valueOf(importe_txt.getText()));
					mv.setSalida(0);
				}
				
				try {
					MovimientoService.crearMovimiento(mv, edificio);
					manejador.actualizarTablaEdificio();
					SwingUtilities.getWindowAncestor(cancelarBoton).dispose();
				} catch (DAOServiceException e1) {
					Mensaje.error(this, "Error crítico al intentar registrar un movimiento", "Crear movimiento", e1);
				}
			}catch(NumberFormatException e2) {
				Mensaje.error(this, "El campo importe debe contener un numero real", "Error de tipo",null);
			}catch(DateTimeParseException e3){
				Mensaje.error(this, "Error al intentar reconocer la fecha.\n\nUse formato dd/mm/yyyy", "Error en la fecha", null);
			}
		}else
		if(e.getSource()==cancelarBoton) {
			SwingUtilities.getWindowAncestor(cancelarBoton).dispose();
		}
		
	}
}
