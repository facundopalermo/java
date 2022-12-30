package edu.up.Banca;
import java.util.ArrayList;

public class Cliente {
    
    private int dni;
    private String nombre;
    private String apellido;
    private ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();

    public Cliente(int dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public void abrirCuenta(String tipo) {
        int numeroDeCuenta = cuentas.size() + 1;

        switch (tipo) {
            case "Ahorro":
                cuentas.add(new CajaDeAhorroEnPesos(numeroDeCuenta));
                break;

            case "CtaCte":
                cuentas.add(new CuentaCorrienteEnPesos(numeroDeCuenta));
                break;
        
            default:
                break;
        }
    }

    /* GETTERS y SETTERS */
    public int getDni() {
        return dni;
    }
    public void setDni(int dni) {
        this.dni = dni;
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

    public Cuenta getCuenta(int index) {
        /* retorna por array para no complicar tanto el ejercicio */
        return cuentas.get(index);
    }
    
}
