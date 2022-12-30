package edu.up.consorcio.ui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.BorderFactory;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import edu.up.config.excepciones.DAOServiceException;
import edu.up.config.mensaje.Mensaje;
import edu.up.config.sesion.Sesion;
import edu.up.consorcio.clase.Edificio;
import edu.up.consorcio.model.EdificioTableModel;
import edu.up.consorcio.services.EdificioService;
import edu.up.panelManager.PanelManager;

public class AdministraEdificiosPanel extends JPanel implements MouseListener{
	
	private JPanel listaEdificios = new JPanel();
	private JPanel dentroDelEdificio = new JPanel();
	private JPanel datosDelEdificio = new JPanel();
	private JPanel ufDelEdificio = new JPanel();
	private JTable tablaEdificio;
	private EdificioTableModel modeloListaEdificio;
	Edificio edificio;
	int fila;
	
	//JComboBox<Edificio> EdificioComboBox;
	//private EdificioComboBoxModel combomodel; 
	
	private PanelManager manejador = Sesion.getManejador();

	private JScrollPane scrollPaneParaTablaEdificios;
	
	public AdministraEdificiosPanel() {
		super();
		armar();
	}
	
	public void armar() {
		
		this.setLayout(null);
		
		modeloListaEdificio = new EdificioTableModel();
		this.tablaEdificio = new JTable(modeloListaEdificio);
		scrollPaneParaTablaEdificios = new JScrollPane(tablaEdificio);
		scrollPaneParaTablaEdificios.setSize(200, 550);
		
		listaEdificios.setLayout(null);
		dentroDelEdificio.setLayout(null);

		//combomodel = new EdificioComboBoxModel();
		//EdificioComboBox=new JComboBox<Edificio>(combomodel);
		//listaEdificios.add(EdificioComboBox);
		
		listaEdificios.add(scrollPaneParaTablaEdificios);
		listaEdificios.setBounds(0, 0, 200, 530);
		
		dentroDelEdificio.setBounds(200, 0, 820, 500);
		dentroDelEdificio.setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
		
		datosDelEdificio.setBounds(0, 0, 807, 105);
		datosDelEdificio.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		
		ufDelEdificio.setBounds(0,105,807,395);
		
		//EdificioComboBox.setBounds(0, 0, 200, 20);

		
		this.add(listaEdificios);
		this.add(dentroDelEdificio);
		
		setContenido();
		
		this.tablaEdificio.addMouseListener(this);
		
	}
	
	public void setContenido() {
		List<Edificio> aux=null;
		
		try {
			aux = EdificioService.obtenerDatos();
		} catch (DAOServiceException e) {
			Mensaje.error(this, "Error al intentar obtener los datos", "Listar edificio", e);
		}
		
		modeloListaEdificio.setContenido(aux);
		
		modeloListaEdificio.fireTableDataChanged();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		fila = this.tablaEdificio.getSelectedRow();
		actualizarDatosDelEdificio();
		//System.out.println(vector.get(EdificioComboBox.getSelectedIndex()).getDir_localidad());
	}
	
	public void limpiarDatosDelEdificio() {
		this.dentroDelEdificio.removeAll();
		this.dentroDelEdificio.validate();
		this.dentroDelEdificio.repaint();
	}
	
	public void actualizarDatosDelEdificio() {
		if (fila>=0) { 
			try {
				edificio = this.modeloListaEdificio.getContenido().get(fila);
				this.datosDelEdificio.removeAll();
				this.ufDelEdificio.removeAll();
				
				this.datosDelEdificio.add(new DatosEdificioSeleccionado(edificio));
				this.ufDelEdificio.add(new UFTablePanel(edificio));
				
				dentroDelEdificio.add(datosDelEdificio);
				dentroDelEdificio.add(ufDelEdificio);
				
				this.datosDelEdificio.validate();
				this.ufDelEdificio.validate();
				this.datosDelEdificio.repaint();
				this.ufDelEdificio.repaint();
				
				this.tablaEdificio.setRowSelectionInterval(fila, fila);
			}catch(IndexOutOfBoundsException e1){
				this.fila--;
				actualizarDatosDelEdificio();
			}
		}else {
			manejador.mostrarAdministrarEdificios();
			Mensaje.info(this, "No hay edificios creados.", "Base de datos vacía");
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
}
