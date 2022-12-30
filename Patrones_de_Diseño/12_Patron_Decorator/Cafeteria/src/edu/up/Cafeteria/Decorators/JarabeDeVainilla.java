package edu.up.Cafeteria.Decorators;

import edu.up.Cafeteria.Cafe;

public class JarabeDeVainilla extends AgregadosDecorator {

    private double precio = 200;

    public JarabeDeVainilla(Cafe cafe) {
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
