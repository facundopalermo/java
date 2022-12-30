package edu.up.Cafeteria.Decorators;

import edu.up.Cafeteria.Cafe;

public class CremaBatida extends AgregadosDecorator {

    private double precio = 150;

    public CremaBatida(Cafe cafe) {
        super(cafe);
    }

    @Override
    public double calcularPrecio() {
        return super.calcularPrecio() + precio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
