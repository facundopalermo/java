package edu.up.usuarios.clase;

public class Administrador extends Usuario {

	public Administrador(int id, String user, String pass, String email, String nombre, String apellido) {
		super(id, user, pass, email,nombre,apellido);
	}

	public Administrador(String user, String pass, String email, String nombre, String apellido) {
		super(user, pass, email,nombre,apellido);
	}	

}
