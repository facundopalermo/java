package edu.up.Cafeteria;

public class TostadoIntenso implements Cafe {

    private double precio = 600;

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
