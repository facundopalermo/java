package edu.up.consorcio.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import edu.up.config.excepciones.DAOServiceException;
import edu.up.config.mensaje.Mensaje;
import edu.up.config.sesion.Sesion;
import edu.up.config.ui.comun.BotoneraPanel;
import edu.up.consorcio.clase.Edificio;
import edu.up.consorcio.clase.UF;
import edu.up.consorcio.model.UfTableModel;
import edu.up.consorcio.services.UFService;
import edu.up.panelManager.PanelManager;

public class UFTablePanel extends JPanel implements ActionListener, MouseListener {
	private JTable tablaUF;
	private UfTableModel modelo;
	private PanelManager manejador = Sesion.getManejador();
	private JScrollPane scrollPaneParaTabla;
	private BotoneraPanel botonera;
	private Edificio edificio;
	private int fila;
	
	public UFTablePanel(Edificio edificio) {
		super();
		this.edificio=edificio;
		armarPanel();
	}
	
	private void armarPanel() {
		
		botonera=new BotoneraPanel(true,true,true,false,false);
		
		this.setLayout(new BorderLayout());
		modelo = new UfTableModel();
		tablaUF = new JTable(modelo);
		scrollPaneParaTabla = new JScrollPane(tablaUF);
		
		tablaUF.setPreferredScrollableViewportSize(new Dimension(800, 315));
		tablaUF.getColumn("Piso").setPreferredWidth(50);
		tablaUF.getColumn("Dpto").setPreferredWidth(50);
		tablaUF.getColumn("mts\u00B2").setPreferredWidth(50);
		tablaUF.getColumn("Ocupante").setPreferredWidth(150);
			
		botonera.getBotonNuevo().addActionListener(this);
		botonera.getBotonMod().addActionListener(this);
		botonera.getBotonBorrar().addActionListener(this);
		
		this.add(scrollPaneParaTabla,BorderLayout.NORTH);
		this.add(botonera,BorderLayout.SOUTH);
		
		modelo.setContenido(edificio.getDepartamento());
		tablaUF.addMouseListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int filaSeleccionada = this.tablaUF.getSelectedRow();
		
		if (e.getSource() == botonera.getBotonNuevo()) {
			manejador.mostrarNuevoUF(edificio, this);
		}else 
		if(e.getSource()==botonera.getBotonMod()) {
			try {
				manejador.mostrarModificarUF(edificio, this.modelo.getContenido().get(filaSeleccionada), this);
			}catch(IndexOutOfBoundsException e1){
				Mensaje.info(this, "Debe seleccionar un departamento para modificar", "Modificar UF");
			}
		}else
		if (e.getSource()==botonera.getBotonBorrar()) {
			
			try {
				UF uf = this.modelo.getContenido().get(filaSeleccionada);
				try {
					if(Mensaje.pregunta(this, "¿Está seguro de borrar el departamento selecciondo?", "Borrar UF")==JOptionPane.YES_OPTION) {
						UFService.borrarUF(uf);
					}
				} catch (DAOServiceException e1) {
					Mensaje.error(this, "Error al intentar borrar la UF", "Borrar UF", e1);
				}
			}catch(IndexOutOfBoundsException e1) {
				Mensaje.info(this, "Debe seleccionar un departamento para borrar", "Borrar UF");
			}finally {
				updateContenido();
			}
		}
	}
	
	/*	
		if(e.getSource()==botonera.getBotonImprimir()) {
			ImprimirModel imprimir=new ImprimirModel();
			imprimir.imprimirTabla(tablaUsuarios, "Lista de usuarios", "Sistema Administracion de Consorcios - Laboratorio I - Universidad de Palermo", true);
		}

	*/
	
	public void updateContenido() {
		manejador.actualizarTablaEdificio();
		modelo.fireTableDataChanged();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount()==2) {
			fila = this.tablaUF.getSelectedRow();
			manejador.mostrarVerExpensas(this.modelo.getContenido().get(fila), edificio);
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub	
	}
}
