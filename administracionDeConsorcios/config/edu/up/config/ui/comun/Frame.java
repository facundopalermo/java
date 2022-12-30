package edu.up.config.ui.comun;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;


public class Frame extends JFrame {

		public Frame(){
			
		}
		
		public Frame(int alto, int ancho, String titulo, boolean resizable, int CloseOperation) {
			this.setSize(alto, ancho);
			this.setTitle(titulo);
			this.setResizable(resizable);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(CloseOperation);
			
			setIcono();
		
		}

		private void setIcono(){
			Image icono = Toolkit.getDefaultToolkit().getImage("img/icono.png");
			this.setIconImage(icono);
		}
}
