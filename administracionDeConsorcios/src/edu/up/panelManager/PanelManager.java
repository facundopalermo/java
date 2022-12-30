package edu.up.panelManager;


import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import edu.up.config.mensaje.Mensaje;
import edu.up.config.sesion.Sesion;
import edu.up.config.ui.comun.Frame;
import edu.up.consorcio.clase.Edificio;
import edu.up.consorcio.clase.UF;
import edu.up.consorcio.ui.AdministraEdificiosPanel;
import edu.up.consorcio.ui.DatosEdificioPanel;
import edu.up.consorcio.ui.DatosMVPanel;
import edu.up.consorcio.ui.DatosUFPanel;
import edu.up.consorcio.ui.ExpensasTablePanel;
import edu.up.consorcio.ui.MovimientosTablePanel;
import edu.up.consorcio.ui.UFTablePanel;
import edu.up.usuarios.clase.Usuario;
import edu.up.usuarios.ui.UsuarioPanel;
import edu.up.usuarios.ui.LoginPanel;
import edu.up.usuarios.ui.TablaUsuariosPanel;

public class PanelManager {
	private Frame frame;
	private Usuario user;
	private TablaUsuariosPanel tablaUsuarios;
	AdministraEdificiosPanel consorcio;
	private JPanel contenido;
	LoginPanel login;

	
	public PanelManager() {
		Sesion.setManejador(this);
		iniciarSesion();
	}
	
	public void iniciarManager() {
		armarManager();
		mostrarAdministrarEdificios();
		showFrame();
	}
	
	
	//En el PanelManager
	public void mostrarListaUsuarios() {
		tablaUsuarios = new TablaUsuariosPanel();
		mostrarPanel(tablaUsuarios,false);
	}
	
	public void mostrarAdministrarEdificios() {
		consorcio = new AdministraEdificiosPanel();
		mostrarPanel(consorcio,false);
	}

	//En nueva ventana
	
	public void iniciarSesion() {
		login = new LoginPanel();
		mostrarVentana("Iniciar Sesion", login, 350, 150);
	}

	public void mostrarNuevoUsuario() {
		UsuarioPanel nuevoUsuario = new UsuarioPanel();
		nuevoUsuario.armar();
		nuevoUsuario.mostrarCamposCrear();
		mostrarVentana("Nuevo Usuario", nuevoUsuario, 400, 270);
	}
	
	public void modificarUsuario(Usuario usuario) {
		UsuarioPanel modUsuario = new UsuarioPanel();
		modUsuario.armar();
		modUsuario.mostrarCamposModificar();
		modUsuario.llenarFormulario(usuario);
		mostrarVentana("Modificar Usuario", modUsuario, 400, 270);
	}
	
	public void cambiarPassword(Usuario usuario) {
		UsuarioPanel modPass = new UsuarioPanel();
		modPass.armar();
		modPass.llenarFormulario(usuario);
		modPass.mostrarCamposPass();
		mostrarVentana("Modificar Contraseña", modPass, 350, 150);
	}
	
	public void mostrarNuevoEdificio() {
		DatosEdificioPanel nuevoEdificio = new DatosEdificioPanel();
		nuevoEdificio.armar();
		nuevoEdificio.mostrarCamposCrear();
		mostrarVentana("Nuevo edificio", nuevoEdificio, 380, 200);
	}
	
	public void mostrarModificarEdificio(Edificio edificio) {
		DatosEdificioPanel modificarEdificio = new DatosEdificioPanel();
		modificarEdificio.armar();
		modificarEdificio.llenarFormulario(edificio);
		modificarEdificio.mostrarCamposModificar();
		mostrarVentana("Nuevo edificio", modificarEdificio, 380, 200);
	}
	
	public void mostrarNuevoUF(Edificio edificio, UFTablePanel ufTablePanel) {
		DatosUFPanel nuevoUF = new DatosUFPanel(ufTablePanel);
		nuevoUF.armar("nuevo", edificio, null);
		mostrarVentana("Nueva UF", nuevoUF, 380, 200);
	}
	
	public void mostrarModificarUF(Edificio edificio, UF uf, UFTablePanel ufTablePanel) {
		DatosUFPanel nuevoUF = new DatosUFPanel(ufTablePanel);
		nuevoUF.armar("mod", edificio, uf);
		mostrarVentana("Modificar UF", nuevoUF, 380, 200);
	}
	
	public void mostrarCrearMovimiento(Edificio edificio) {
		DatosMVPanel nuevoMV = new DatosMVPanel(edificio);
		mostrarVentana("Registrar Movimiento", nuevoMV, 380, 150);
	}
	
	public void mostrarVerMovimiento(Edificio edificio) {
		MovimientosTablePanel movimientosTabla = new MovimientosTablePanel(edificio);
		mostrarVentana("Ver Movimiento", movimientosTabla, 600, 500);
	}
	
	public void mostrarVerExpensas(UF uf, Edificio edificio) {
		ExpensasTablePanel expensasTabla = new ExpensasTablePanel(uf, edificio);
		mostrarVentana("Ver Movimiento", expensasTabla, 600, 500);
	}
	
	//Otros
	
	public void mostrarPanel(JPanel panel, boolean limpiar) {
		contenido.removeAll();
		if(!limpiar){contenido.add(panel);}
		contenido.validate();
		contenido.repaint();
	}
	
	public void mostrarVentana(String titulo, Component componente, int ancho, int alto) {
		Frame ventanita = new Frame(ancho, alto, titulo, false, JFrame.DISPOSE_ON_CLOSE);
		ventanita.add(componente);
		ventanita.setVisible(true);
	}

	public void actualizarTablaEdificio() {
		consorcio.setContenido();
		consorcio.actualizarDatosDelEdificio();
	}
	
	public void actualizarTablaUsuarios() {
		tablaUsuarios.setContenido();
	}
	
	public void mostrarSalir() {
		if(Mensaje.pregunta(frame, "Esta seguro de salir?", "Salir?")==JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	
	//PANELMANAGER///////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////
	
	public void armarManager() {
		this.user = Sesion.getUsuario();
		int tipo=0;
		if(Sesion.isAdmin()) {tipo=1;}
		
		String titulo="Sistema Administración de Consorcios - " + user.getNombre() + " " + user.getApellido();
		frame = new Frame(1024, 550, titulo, false, JFrame.EXIT_ON_CLOSE);;

		
		JPanel generalPanel = new JPanel();
		generalPanel.setLayout(new BorderLayout());
		
		JPanel menuPanel = new JPanel();
		BoxLayout menuPanel_bx = new BoxLayout(menuPanel, BoxLayout.X_AXIS);
		menuPanel.setLayout(menuPanel_bx);
		
		contenido = new JPanel();
		BoxLayout contenido_bx = new BoxLayout(contenido, BoxLayout.X_AXIS);
		contenido.setLayout(contenido_bx);
		
		BarraMenu menu = new BarraMenu(tipo);
		menuPanel.add(menu);
		
		generalPanel.add(menuPanel,BorderLayout.NORTH);
		generalPanel.add(contenido);
		
		frame.getContentPane().add(generalPanel);
		
	}

	public void showFrame() {
		frame.setVisible(true);
	}
}
