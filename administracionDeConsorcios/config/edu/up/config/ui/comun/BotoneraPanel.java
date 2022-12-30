package edu.up.config.ui.comun;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class BotoneraPanel extends JToolBar {
	
	private JButton botonNuevo;
	private JButton botonBorrar;
	private JButton botonMod;
	private JButton botonImprimir;
	private JButton botonGuardar;
	private JButton botonCrear;
	private JButton botonCerrar;
	
	//Para Tablas
	public BotoneraPanel(boolean nuevo, boolean borrar, boolean modificar, boolean imprimir, boolean cerrar ){
		armarBotonera(nuevo, borrar, modificar, imprimir, false, false, cerrar );
	}
	
	public BotoneraPanel(boolean todos){
		armarBotonera(todos, todos, todos, todos, false, false, todos);
	}
	
	//Para Paneles Crear/Modificar
	public BotoneraPanel(boolean guardar, boolean crear, boolean cerrar){
		armarBotonera(false, false, false, false, guardar, crear, cerrar);
	}


	public void armarBotonera(boolean nuevo, boolean borrar, boolean modificar, boolean imprimir, boolean guardar, boolean crear, boolean cerrar ) {
		
		setFloatable(false);
		setLayout(new FlowLayout());
		if (nuevo) {
			botonNuevo=new JButton("Nuevo");
			this.add(botonNuevo);
		}
		if (borrar) {
			botonBorrar=new JButton("Borrar");
			this.add(botonBorrar);
		}
		if (modificar) {
			botonMod=new JButton("Modificar");
			this.add(botonMod);
		}
		if (imprimir) {
			botonImprimir=new JButton("Imprimir");
			this.add(botonImprimir);
		}
		if (guardar) {
			botonGuardar=new JButton("Guardar");
			this.add(botonCerrar);
		}
		if (crear) {
			botonCrear=new JButton("Crear");
			this.add(botonCerrar);
		}
		if (cerrar) {
			botonCerrar=new JButton("Cerrar Vista");
			this.add(botonCerrar);
		}
		
	}

	public JButton getBotonNuevo() {
		return botonNuevo;
	}

	public JButton getBotonBorrar() {
		return botonBorrar;
	}

	public JButton getBotonMod() {
		return botonMod;
	}

	public JButton getBotonImprimir() {
		return botonImprimir;
	}
	public JButton getBotonGuardar() {
		return botonGuardar;
	}

	public void setBotonGuardar(JButton botonGuardar) {
		this.botonGuardar = botonGuardar;
	}

	public JButton getBotonCrear() {
		return botonCrear;
	}

	public void setBotonCrear(JButton botonCrear) {
		this.botonCrear = botonCrear;
	}

	public JButton getBotonCerrar() {
		return botonCerrar;
	}
	
}


