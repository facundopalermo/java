package edu.up.consorcio.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import edu.up.config.excepciones.DAOServiceException;
import edu.up.config.excepciones.ExpensasServiceExeption;
import edu.up.config.mensaje.Mensaje;
import edu.up.config.otros.ImprimirTablaModel;
import edu.up.config.sesion.Sesion;
import edu.up.config.ui.comun.BotoneraPanel;
import edu.up.consorcio.clase.Edificio;
import edu.up.consorcio.clase.Expensas;
import edu.up.consorcio.clase.UF;
import edu.up.consorcio.model.ExpensasTableModel;
import edu.up.consorcio.services.ExpensasService;
import edu.up.consorcio.services.GenerarResumen;
import edu.up.panelManager.PanelManager;

public class ExpensasTablePanel extends JPanel implements ActionListener {
	
	private JTable tablaExpensas;
	private ExpensasTableModel modelo;
	private PanelManager manejador = Sesion.getManejador();
	JScrollPane scrollPaneParaTabla;
	private UF uf;
	private Edificio edificio;
	
	JToolBar toolboxFiltrar = new JToolBar();
	JTextField anio_txt = new JTextField();
	JLabel anio_lbl = new JLabel("Año (yyyy):");
	JButton botonFiltrar = new JButton("Filtrar");
	JLabel labelparaalgo_lbl = new JLabel();
	JButton imprimirExpensas = new JButton("Imprimir Expensas");
	
	BotoneraPanel botonera = new BotoneraPanel(false, false, true, true, true);
	private String consolidado;
	
	
	public ExpensasTablePanel(UF uf, Edificio edificio) {
		super();
		this.uf=uf;
		this.edificio=edificio;
		armarPanel();
	}
	
	private void armarPanel() {
		this.setLayout(new BorderLayout());
		
		botonFiltrar.addActionListener(this);
		
		toolboxFiltrar.add(anio_lbl);
		toolboxFiltrar.add(anio_txt);
		toolboxFiltrar.add(botonFiltrar);
		toolboxFiltrar.setFloatable(false);
		
		modelo = new ExpensasTableModel();
		tablaExpensas = new JTable(modelo);
		
		scrollPaneParaTabla = new JScrollPane(tablaExpensas);
		
		tablaExpensas.setPreferredScrollableViewportSize(new Dimension(600, 500));
		
		tablaExpensas.getColumn("ID").setPreferredWidth(13);
		tablaExpensas.getColumn("Mes").setPreferredWidth(13);
		tablaExpensas.getColumn("Año").setPreferredWidth(20);
		tablaExpensas.getColumn("Deuda").setPreferredWidth(50);
		tablaExpensas.getColumn("Interes").setPreferredWidth(50);
		tablaExpensas.getColumn("Expensas").setPreferredWidth(50);
		tablaExpensas.getColumn("Total").setPreferredWidth(50);
		tablaExpensas.getColumn("Pagado").setPreferredWidth(50);
		tablaExpensas.getColumn("Fecha de Pago").setPreferredWidth(70);
		
		
		setContenido(0);
	
		JPanel piePanel = new JPanel();
		piePanel.setLayout(new BorderLayout());
		labelparaalgo_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		
		piePanel.add(labelparaalgo_lbl, BorderLayout.NORTH);
		piePanel.add(botonera, BorderLayout.SOUTH);
		botonera.getBotonMod().setText("Ingresar pago");
		
		botonera.add(imprimirExpensas);
		
		botonera.getBotonMod().addActionListener(this);
		botonera.getBotonCerrar().addActionListener(this);
		botonera.getBotonImprimir().addActionListener(this);
		imprimirExpensas.addActionListener(this);
		
		this.add(toolboxFiltrar, BorderLayout.NORTH);
		this.add(scrollPaneParaTabla,BorderLayout.CENTER);
		this.add(piePanel, BorderLayout.SOUTH);
		
	}
	
	public void setContenido(int anio) {

		List<Expensas> expensas = new ArrayList<Expensas>();
		
		if(anio==0) {
			
			for(Expensas ex: uf.getListaExpensas()){
					expensas.add(ex);
			}
		}else{

			for(Expensas ex: uf.getListaExpensas()) {
					
					if(ex.getAnio()==anio) {
						expensas.add(ex);
					}
				}

		}

		modelo.setContenido(expensas);
		modelo.fireTableDataChanged();
	}
	
	public void setContenido(int mes, int anio) {

		List<Expensas> expensas = new ArrayList<Expensas>();

		for(Expensas ex: uf.getListaExpensas()) {
					
			if(ex.getAnio()==anio && ex.getMes()==mes) {
				expensas.add(ex);
			}
		}

		modelo.setContenido(expensas);
		modelo.fireTableDataChanged();
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==botonFiltrar) {
			try {
				if(!anio_txt.getText().equals("") && Integer.valueOf(anio_txt.getText())>0){
					setContenido(Integer.valueOf(anio_txt.getText()));
				}else {
					setContenido(0);
				}
			}catch (NumberFormatException n) {Mensaje.error(this, "El año debe tener formato yyyy", "Error al filtrar", null);}
		}else
		if(e.getSource()==botonera.getBotonCerrar()) {
			SwingUtilities.getWindowAncestor(botonera.getBotonCerrar()).dispose();
		}else 
		if(e.getSource()==botonera.getBotonImprimir()) {
			ImprimirTablaModel imprimir=new ImprimirTablaModel();
			imprimir.imprimirTabla(tablaExpensas, "Resumen UF: " + uf.getU() + "° " + uf.getF()+"°" , String.valueOf(LocalDate.now()), true);
		}else
		if(e.getSource()==botonera.getBotonMod()) {
			try {
				ExpensasService.ingresarPago(this, edificio, uf);
				manejador.actualizarTablaEdificio();
					
				if(!anio_txt.getText().equals("") && Integer.valueOf(anio_txt.getText())>0){
					setContenido(Integer.valueOf(anio_txt.getText()));
				}else {setContenido(0);}
			}catch (IndexOutOfBoundsException iobe) {Mensaje.info(this, "No hay registro de expensas para pagar", "Falta de carga de expensas");		
			}catch (NumberFormatException n) {Mensaje.error(this, "Verifique el filtro por favor, solo admite año formato yyyy", "Error al filtrar", null);
			}catch (ExpensasServiceExeption e1) {Mensaje.error(this, "El monto ingresado debe ser un numero tal que: \n - Sea un real\n- La parte decimal separado por un punto (.)", "Error en el monto", null);
			}catch (DAOServiceException e1) {Mensaje.error(this, "Error al registrar el pago", "Error", e1);}
		}else
		if(e.getSource()==imprimirExpensas) {
			GenerarResumen generarResumen = new GenerarResumen();
			int fila = tablaExpensas.getSelectedRow();
			int mes, anio;
			try {
				mes = modelo.getContenido().get(fila).getMes();
				anio = modelo.getContenido().get(fila).getAnio();
				generarResumen.armar(mes, anio, edificio, uf);
			} catch(IndexOutOfBoundsException iobe) {Mensaje.info(this, "Debe seleccionar una fila", "Imprimir expensas");
			} catch (ExpensasServiceExeption e1) {Mensaje.info(this, "Operacion cancelada", "Error en la impresion");}
		}
	}

	public JTable getTablaMov() {
		return tablaExpensas;
	}
}
