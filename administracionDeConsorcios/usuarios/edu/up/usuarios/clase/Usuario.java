package edu.up.usuarios.clase;

public class Usuario {

	private int id;
    private String user;
    private String pass;
    
    private String email;
    private String nombre;
    private String apellido;
    
	public Usuario() {

	}

	public Usuario(int id, String user, String pass, String email, String nombre, String apellido) {
		this.id = id;
		this.user = user;
		this.pass = pass;
		this.email = email;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Usuario(String user, String pass, String email, String nombre, String apellido) {
		this.user = user;
		this.pass = pass;
		this.email = email;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}
