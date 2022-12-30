package edu.up.FINAL.Afiliado;

import edu.up.FINAL.Dispositivo.Dispositivo;

public class Afiliado {
    
    private String nombre;
    private String apellido;
    private String direccion;
    private Dispositivo dispositivo;

    private Afiliado(AfiliadoBuilder builder) {
        this.nombre = builder.nombre;
        this.apellido = builder.apellido;
        this.direccion = builder.direccion;
        this.dispositivo = builder.dispositivo;
    }

    public static class AfiliadoBuilder {
        private String nombre;
        private String apellido;
        private String direccion;
        private Dispositivo dispositivo;

        public AfiliadoBuilder(String nombre, String apellido, String direccion) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.direccion = direccion;
        }

        public AfiliadoBuilder dispositivo(Dispositivo dispositivo) {
            this.dispositivo = dispositivo;
            this.dispositivo.setUbicacion(this.direccion);
            return this;
        }

        public Afiliado build() {
            return new Afiliado(this);
        }
    }

    
    /* GETTERS & SETTERS */

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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

}