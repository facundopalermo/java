package edu.up.main;

import edu.up.config.db.DBManager;
import edu.up.panelManager.PanelManager;

public class Main {

	public static void main(String[] args) {
		
		DBManager.validarDB();
		PanelManager manejador = new PanelManager();

	}
}
