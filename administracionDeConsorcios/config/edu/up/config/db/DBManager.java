package edu.up.config.db;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import edu.up.config.mensaje.Mensaje;

public class DBManager {
	private static final String DB_DRIVER = "org.h2.Driver";
	private static final String DB_USERNAME = "sa";
	private static final String DB_PASSWORD = "";

	public static Connection connect() {
		Connection c = null;
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			Mensaje.error(null, "Error critico: La clase no se encuentra.\nEl programa finalizará", "Error Crítico", e);
			System.exit(0);
		}
		try {
			String url = "jdbc:h2:tcp://localhost//{DIR}/db";
			url = url.replace("{DIR}", getDirectorioBase());
			c = DriverManager.getConnection(url, DB_USERNAME, DB_PASSWORD);
			c.setAutoCommit(false);
		} catch (SQLException e) {
			Mensaje.error(null, "Error critico al intentar conectar con la base de datos. El programa finalizará", "Error Crítico", e);
			System.exit(0);
		}
		return c;
	}

	private static String getDirectorioBase(){
		File currDir = new File("h2/base_de_datos/");
		return currDir.getAbsolutePath();
	}

	public static void validarDB(){
		File db = new File(getDirectorioBase()+"/db.h2.db");
		if(db.exists()==false) {
			Mensaje.error(null, "No se encuentra el archivo de base de datos db.h2.db.\nEl programa finalizará.", "Error al iniciar", null);
			System.exit(0);
		}
	}
}
