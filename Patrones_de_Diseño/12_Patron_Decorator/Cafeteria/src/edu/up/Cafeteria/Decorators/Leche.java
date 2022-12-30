package edu.up.Cafeteria.Decorators;

import edu.up.Cafeteria.Cafe;

public class Leche extends AgregadosDecorator {

    private double precio = 100;

    public Leche(Cafe cafe) {
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
