package edu.up.Age;

public class Dragon {

    private String nombre;
    private int vidaReal;
    private PersonajeFlyweight dragonFlyweight;

    public Dragon(String nombre, int vidaReal) {
        this.nombre = nombre;
        this.vidaReal = vidaReal;
        this.dragonFlyweight = PersonajeFlyweightFactory.getDragonFlyweightImpl();
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
        return "Dragon [nombre=" + nombre + ", vidaReal=" + vidaReal + ", DragonFly=" + dragonFlyweight + "]";
    }

}
