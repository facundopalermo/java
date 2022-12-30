package edu.up.usuarios.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import edu.up.config.excepciones.DAOServiceException;
import edu.up.config.mensaje.Mensaje;
import edu.up.config.otros.ImprimirTablaModel;
import edu.up.config.sesion.Sesion;
import edu.up.config.ui.comun.BotoneraPanel;
import edu.up.panelManager.PanelManager;
import edu.up.usuarios.clase.Usuario;
import edu.up.usuarios.services.UsuarioService;
import edu.up.usuarios.tablemodel.UsuarioTableModel;

public class TablaUsuariosPanel extends JPanel implements ActionListener {
	private JTable tablaUsuarios;
	private UsuarioTableModel modelo;
	private PanelManager manejador = Sesion.getManejador();
	private BotoneraPanel botonera;

	private JScrollPane scrollPaneParaTabla;
	
	public TablaUsuariosPanel() {
		super();
		armarPanel();
	}

	private void armarPanel() {
		
		botonera=new BotoneraPanel(true);
		
		this.setLayout(new BorderLayout());
		modelo = new UsuarioTableModel();
		tablaUsuarios = new JTable(modelo);
		scrollPaneParaTabla = new JScrollPane(tablaUsuarios);
		this.add(scrollPaneParaTabla,BorderLayout.NORTH);
		
		try {
			modelo.setContenido(UsuarioService.obtenerDatos());
		} catch (DAOServiceException e) {
			Mensaje.error(this, "Error al intentar mostrar los datos de la tabla", "Error de datos", e);
		}
		
		botonera.getBotonNuevo().addActionListener(this);
		botonera.getBotonMod().addActionListener(this);
		botonera.getBotonBorrar().addActionListener(this);
		botonera.getBotonImprimir().addActionListener(this);
		botonera.getBotonCerrar().addActionListener(this);
		
		this.add(botonera,BorderLayout.SOUTH);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		int filaSeleccionada = this.tablaUsuarios.getSelectedRow();
		
		
		if (e.getSource() == botonera.getBotonNuevo()) {
			manejador.mostrarNuevoUsuario();
		}else 
		if (e.getSource()==botonera.getBotonMod()) {
			try {
			Usuario usuario = this.modelo.getContenido().get(filaSeleccionada);
			manejador.modificarUsuario(usuario);
			}catch(IndexOutOfBoundsException e1) {Mensaje.info(this, "Debe seleccionar una fila de la tabla.", "Modificar usuario");}
		}else
		if (e.getSource()==botonera.getBotonBorrar()) {
			try {
				Usuario usuario = this.modelo.getContenido().get(filaSeleccionada);

				int opcion=Mensaje.pregunta(this,"¿Está seguro de eliminar el usuario seleccionado?", "Borrar usuario");
				
				if (opcion==JOptionPane.YES_OPTION) {
					try {
						UsuarioService.Borrar(usuario);
					} catch (DAOServiceException e1) {Mensaje.error(this, "Ha ocurrido un error y el usuario no ha podido ser borrado", "Error al borrar el usuario", e1);}
					setContenido();
				}
			}catch(IndexOutOfBoundsException e1) {Mensaje.info(this, "Debe seleccionar una fila de la tabla.", "Borrar usuario");}
		}else
		if(e.getSource()==botonera.getBotonCerrar()) {
			manejador.mostrarPanel(null,true);
		}else
		if(e.getSource()==botonera.getBotonImprimir()) {
			ImprimirTablaModel imprimir=new ImprimirTablaModel();
			imprimir.imprimirTabla(tablaUsuarios, "Lista de usuarios", "Sistema Administracion de Consorcios - Laboratorio I - Universidad de Palermo", true);
		}
		
	}
	
	public void setContenido() {
		try {
			modelo.setContenido(UsuarioService.obtenerDatos());
		} catch (DAOServiceException e) {Mensaje.error(this, "Error al intentar mostrar los datos de la tabla", "Error de datos", e);}
		modelo.fireTableDataChanged();
	}
}
