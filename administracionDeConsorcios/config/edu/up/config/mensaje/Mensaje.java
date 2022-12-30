package edu.up.config.mensaje;

import java.awt.Component;

import javax.swing.*;

public class Mensaje extends JFrame {
	
	private static String mensaje="";
	
	public static void error(Component componente, String texto, String titulo, Exception infoException) {
		
		mensaje=texto;
		if (!(infoException==null)) {
			mensaje+="\n\nInfo error:\n\n" + infoException.getMessage();
		}
		
		JOptionPane.showMessageDialog(componente, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
	}
	
	public static int pregunta(Component componente, String texto, String titulo) {
		int result=JOptionPane.showConfirmDialog(componente, texto, titulo, JOptionPane.YES_OPTION);
		return result;
	}
	
	public static void info(Component componente, String texto, String titulo) {
		JOptionPane.showMessageDialog(componente, texto, titulo, JOptionPane.INFORMATION_MESSAGE);
	}
}
