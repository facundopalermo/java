package edu.up.Cafeteria;

public class TostadoSuave implements Cafe {

    private double precio = 450;

    @Override
    public double calcularPrecio() {
        return precio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}
