package edu.up.consorcio.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import edu.up.config.excepciones.DAOServiceException;
import edu.up.config.excepciones.ExpensasServiceExeption;
import edu.up.config.mensaje.Mensaje;
import edu.up.config.otros.FechaUtil;
import edu.up.config.sesion.Sesion;
import edu.up.config.ui.comun.BotoneraPanel;
import edu.up.consorcio.clase.Edificio;
import edu.up.consorcio.services.EdificioService;
import edu.up.consorcio.services.ExpensasService;
import edu.up.panelManager.PanelManager;

public class DatosEdificioSeleccionado extends JPanel implements ActionListener {
	
	BotoneraPanel botonera = new BotoneraPanel(false, true, true, false, true);
	JToolBar toolBar = new JToolBar();
	PanelManager manejador = Sesion.getManejador();
	JButton movimientoBoton = new JButton("Egreso/Ingreso");
	JButton verMovimientosBoton = new JButton("Movimientos");
	JButton generarExpensas = new JButton("Generar Expensas");
	
	JLabel botonera_lbl = new JLabel("ADMINISTRAR: ");
	private Edificio edificio;
	
	public DatosEdificioSeleccionado(Edificio edificio){
		super();
		this.edificio=edificio;
		armar(this.edificio);
	}

	public void armar(Edificio edificio) {
		
		JLabel lbl_nombre = new JLabel("Nombre: " + edificio.getNombre());
		JLabel lbl_direccion = new JLabel("Dirección: " + edificio.getDir_calle() + " " + edificio.getDir_altura());
		JLabel lbl_localidad = new JLabel("Localidad: " + edificio.getDir_localidad());
		JLabel lbl_pisos = new JLabel("N° de pisos: " + edificio.getN_pisos());
		JLabel lbl_sup = new JLabel("Sup. total: " + edificio.getSuperficieTotal() + " mts\u00B2");
		
		JPanel panel_nombre = new JPanel();
		JPanel panel_direccion = new JPanel();
		JPanel panel_localidad = new JPanel();
		JPanel panel_pisos = new JPanel();
		JPanel panel_sup = new JPanel();
		
		setLayout(new BorderLayout());

		panel_nombre.add(lbl_nombre);
		panel_direccion.add(lbl_direccion);
		panel_localidad.add(lbl_localidad);
		panel_pisos.add(lbl_pisos);
		panel_sup.add(lbl_sup);
		
		JPanel aux = new JPanel();
		
		aux.add(panel_nombre);
		aux.add(panel_direccion);
		aux.add(panel_localidad);
		aux.add(panel_pisos);
		aux.add(panel_sup);
		
		this.add(aux, BorderLayout.NORTH);
		
		
	//TOOLBAR ==>>
		
		botonera.getBotonBorrar().setText("Eliminar Edificio");
		botonera.getBotonMod().setText("Editar Edificio");
		
		botonera.addSeparator();
		botonera.add(botonera_lbl);
		botonera.add(movimientoBoton);
		botonera.add(verMovimientosBoton);
		
		
		movimientoBoton.addActionListener(this);
		verMovimientosBoton.addActionListener(this);
		
		botonera.getBotonCerrar().addActionListener(this);
		botonera.getBotonBorrar().addActionListener(this);
		botonera.getBotonMod().addActionListener(this);
		
		botonera.add(generarExpensas);
		generarExpensas.addActionListener(this);
		

		
	//<<== TOOLBAR
		
		this.add(botonera,BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==botonera.getBotonCerrar()) {
			manejador.mostrarAdministrarEdificios();
		}else 
		if(e.getSource()==botonera.getBotonBorrar()){
			if(Mensaje.pregunta(this, "¿Está seguro de eliminar este edificio?\nImportante: Se eliminará junto a todas los departamentos", "Eliminar edificio")==JOptionPane.YES_OPTION) {
				try {
					EdificioService.BorrarEdificio(this.edificio);
				} catch (DAOServiceException e1) {Mensaje.error(this, "Error al intentar borrar el edificio", "Borrar edificio", e1);
				}finally {
					manejador.actualizarTablaEdificio();
				}
			}
		}else 
		if(e.getSource()==botonera.getBotonMod()){
			manejador.mostrarModificarEdificio(this.edificio);				
		}else
		if (e.getSource()==movimientoBoton) {
			manejador.mostrarCrearMovimiento(edificio);
		}else
		if (e.getSource()==verMovimientosBoton) {
			manejador.mostrarVerMovimiento(edificio);
		}else
		if(e.getSource()==generarExpensas) {   // <- validar mes / año, etc.....
			
			String mesAnterior="";
			
			if (FechaUtil.mesActual()==1) {
				mesAnterior=FechaUtil.mes_Texto(12);
			}else {
				mesAnterior=FechaUtil.mes_Texto(FechaUtil.mesActual()-1);
			}
			
			
			String [] meses = { mesAnterior, FechaUtil.mes_Texto(FechaUtil.mesActual()), "Cancelar" };
			
			
			try {
				int opcion = JOptionPane.showOptionDialog(this, "Seleccione mes para generar Expensas", "Generar Expensas", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, meses, meses[0]);
				
				switch (opcion) {
				case 0: {
					if(FechaUtil.mesActual()==1) {ExpensasService.generarExpensas(edificio, 12, FechaUtil.anioActual()-1);
					}else { ExpensasService.generarExpensas(edificio, FechaUtil.mesActual()-1, FechaUtil.anioActual());}
					break;
				}case 1: {
					if(FechaUtil.mesActual()==12) {ExpensasService.generarExpensas(edificio, 1, FechaUtil.anioActual()+1);
					}else {ExpensasService.generarExpensas(edificio, FechaUtil.mesActual(), FechaUtil.anioActual());}
					break;
				}case 2: {break;
				}default:
					throw new IllegalArgumentException("Unexpected value: " + opcion);
				}
				
				Mensaje.info(this, "Expensas generadas correctamente", "Generar expensas");
				
			} catch (DAOServiceException e1) {Mensaje.error(this, "Error al generar las expensas", "Error", e1);
			} catch (ExpensasServiceExeption e1) {Mensaje.error(this, "La expensa para el mes seleccionado ya fué emitida", "Error al generar expensa", null);
			}finally {
				manejador.actualizarTablaEdificio();
			}
		}
		
	}
}
