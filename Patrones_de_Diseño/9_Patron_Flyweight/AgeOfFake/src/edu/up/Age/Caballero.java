package edu.up.Age;

public class Caballero {
    
    private String nombre;
    private int vidaReal;
    private PersonajeFlyweight caballeroFlyweight;

    public Caballero(String nombre, int vidaReal) {
        this.nombre = nombre;
        this.vidaReal = vidaReal;
        this.caballeroFlyweight = PersonajeFlyweightFactory.getCaballeroFlyweightImpl();
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getVidaReal() {
        return vidaReal;
    }
    public void setVidaReal(int vidaReal) {
        this.vidaReal = vidaReal;
    }

    @Override
    public String toString() {
        return "Caballero [nombre=" + nombre + ", vidaReal=" + vidaReal + ", CabelloroFly=" + caballeroFlyweight + "]";
    }

}
