package edu.up.panelManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import edu.up.config.sesion.Sesion;

public class BarraMenu extends JMenuBar {
	
	private PanelManager manejador = Sesion.getManejador();
	
	public BarraMenu(int tipoUsuario) {
		armarBarra(tipoUsuario);
	}
	
	public void armarBarra(int tipoUsuario) {
		JMenu inicio = new JMenu("Incio");
		JMenu administrar = new JMenu("Administrar edificios");
		JMenu usuarios = new JMenu("Usuarios");
		
		//INICIO
		JMenuItem salir = new JMenuItem("Salir");
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manejador.mostrarSalir();
			}
		});
		inicio.add(salir);
		
		
		//ADMINISTRAR EDIFICIOS
		
		JMenuItem administrarEdificios = new JMenuItem("Administrar edificios");
		administrarEdificios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manejador.mostrarAdministrarEdificios();
			}
		});
		
		JMenuItem nuevoEdificio = new JMenuItem("Dar de alta nuevo edificio");
		nuevoEdificio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manejador.mostrarNuevoEdificio();
			}
		});
		

		
		administrar.add(administrarEdificios);
		administrar.add(nuevoEdificio);
		
		//ADMINISTRAR USUARIOS

		JMenuItem administrarUsuarios = new JMenuItem("Administrar");
		administrarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manejador.mostrarListaUsuarios();
			}
		});
		
		JMenuItem cambiarPass = new JMenuItem("Cambiar contraseña");
		cambiarPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manejador.cambiarPassword(Sesion.getUsuario());
			}
		});
		
		if(tipoUsuario==1) {
			usuarios.add(administrarUsuarios);
		}
		
		usuarios.add(cambiarPass);

		this.add(inicio);
		this.add(administrar);
		this.add(usuarios);
		
	}
}
