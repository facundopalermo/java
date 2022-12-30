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

import edu.up.config.excepciones.FechaException;
import edu.up.config.mensaje.Mensaje;
import edu.up.config.otros.FechaUtil;
import edu.up.config.otros.ImprimirTablaModel;
import edu.up.config.sesion.Sesion;
import edu.up.config.ui.comun.BotoneraPanel;
import edu.up.consorcio.clase.Edificio;
import edu.up.consorcio.clase.Movimiento;
import edu.up.consorcio.model.MovTableModel;
import edu.up.panelManager.PanelManager;

public class MovimientosTablePanel extends JPanel implements ActionListener {
	private JTable tablaMov;

	private MovTableModel modelo;
	private PanelManager manejador = Sesion.getManejador();
	JScrollPane scrollPaneParaTabla;
	private Edificio edificio;
	
	JToolBar toolboxFiltrar = new JToolBar();
	JTextField fechaDesde_txt = new JTextField();
	JTextField fechaHasta_txt = new JTextField();
	JLabel fechaDesde_lbl = new JLabel("Fecha desde (dd/MM/yyyy):");
	JLabel fechaHasta_lbl = new JLabel("Fecha hasta (dd/MM/yyyy):");
	JButton botonFiltrar = new JButton("Filtrar");
	JLabel consolidado_lbl = new JLabel();
	
	BotoneraPanel botonera = new BotoneraPanel(false, false, false, true, true);
	private String consolidado;
	
	
	public MovimientosTablePanel(Edificio edificio) {
		super();
		this.edificio=edificio;
		armarPanel();
	}
	
	private void armarPanel() {
		this.setLayout(new BorderLayout());
		
		botonFiltrar.addActionListener(this);
		
		toolboxFiltrar.add(fechaDesde_lbl);
		toolboxFiltrar.add(fechaDesde_txt);
		toolboxFiltrar.add(fechaHasta_lbl);
		toolboxFiltrar.add(fechaHasta_txt);
		toolboxFiltrar.add(botonFiltrar);
		toolboxFiltrar.setFloatable(false);
		
		modelo = new MovTableModel();
		tablaMov = new JTable(modelo);
		
		scrollPaneParaTabla = new JScrollPane(tablaMov);
		
		tablaMov.setPreferredScrollableViewportSize(new Dimension(600, 500));
		
		tablaMov.getColumn("Fecha").setPreferredWidth(50);
		tablaMov.getColumn("Descripción").setPreferredWidth(300);
		tablaMov.getColumn("Entrada").setPreferredWidth(75);
		tablaMov.getColumn("Salida").setPreferredWidth(75);
		
		setContenido("","");
	
		JPanel piePanel = new JPanel();
		piePanel.setLayout(new BorderLayout());
		consolidado_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		
		piePanel.add(consolidado_lbl, BorderLayout.NORTH);
		piePanel.add(botonera, BorderLayout.SOUTH);
		botonera.getBotonCerrar().addActionListener(this);
		botonera.getBotonImprimir().addActionListener(this);
		
		
		this.add(toolboxFiltrar, BorderLayout.NORTH);
		this.add(scrollPaneParaTabla,BorderLayout.CENTER);
		this.add(piePanel, BorderLayout.SOUTH);
		
	}
	
	public void setContenido(String desde, String hasta) {
		
		
		LocalDate fecha_desde;
		LocalDate fecha_hasta;
		double ingresos=0;
		double egresos=0;
		List<Movimiento> MVfechados = new ArrayList<Movimiento>();
		
		if(desde.equals("") || hasta.equals("")) {
			
			for(Movimiento mv:edificio.getMovimientos()){
					MVfechados.add(mv);
					ingresos+=mv.getEntrada();
					egresos+=mv.getSalida();
			}
		}else{
			try {
				fecha_desde = FechaUtil.StringToLocalDate(desde);
				fecha_hasta = FechaUtil.StringToLocalDate(hasta);
				
				for(Movimiento mv:edificio.getMovimientos()) {
					
					if(mv.getFecha().isAfter(fecha_desde.plusDays(-1)) && mv.getFecha().isBefore(fecha_hasta.plusDays(1))) {
						MVfechados.add(mv);
						
						ingresos+=mv.getEntrada();
						egresos+=mv.getSalida();
					}
				}
			}catch (FechaException e) {
					Mensaje.error(this, "La fecha a filtrar debe tener formato dd/MM/yyyy", "Error en las fechas", e);
			}
		}
		
		consolidado = "Ingresos ($ " + String.format("%.2f",ingresos) + ") - Egresos ($ " + String.format("%.2f",egresos) + ") = $ " + String.format("%.2f",(ingresos - egresos));
		consolidado_lbl.setText(consolidado);
		modelo.setContenido(MVfechados);
		modelo.fireTableDataChanged();
	}
	
public String setContenido(int mes, int anio) {
		
		double ingresos=0;
		double egresos=0;
		List<Movimiento> MVfechados = new ArrayList<Movimiento>();
		
		for(Movimiento mv:edificio.getMovimientos()) {
					
			if(mv.getFecha().getMonth().getValue()==mes && mv.getFecha().getYear()==anio) {
				MVfechados.add(mv);
						
				ingresos+=mv.getEntrada();
				egresos+=mv.getSalida();
			}
		}
		modelo.setContenido(MVfechados);
		modelo.fireTableDataChanged();
		
		consolidado = "Ingresos ($ " + String.format("%.2f",ingresos) + ") - Egresos ($ " + String.format("%.2f",egresos) + ") = $ " + String.format("%.2f",(ingresos - egresos));
		return consolidado;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==botonFiltrar) {
			
			if((!fechaDesde_txt.getText().equals("")) && (!fechaHasta_txt.getText().equals(""))){
				setContenido(fechaDesde_txt.getText(),fechaHasta_txt.getText());
			}else {
				setContenido("", "");
			}
		}else
		if(e.getSource()==botonera.getBotonCerrar()) {
			SwingUtilities.getWindowAncestor(botonera.getBotonCerrar()).dispose();
		}else 
		if(e.getSource()==botonera.getBotonImprimir()) {
			ImprimirTablaModel imprimir=new ImprimirTablaModel();
			imprimir.imprimirTabla(tablaMov, "Posición consolidada ("+edificio.getNombre()+")" , consolidado, true);
		}
	}
	
	public JTable getTablaMov() {
		return tablaMov;
	}
}
