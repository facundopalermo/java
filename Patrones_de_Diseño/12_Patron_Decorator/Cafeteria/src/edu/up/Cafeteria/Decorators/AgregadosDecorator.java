package edu.up.Cafeteria.Decorators;

import edu.up.Cafeteria.Cafe;

public abstract class AgregadosDecorator implements Cafe {

    private Cafe cafe;

    public AgregadosDecorator(Cafe cafe) {
        this.cafe = cafe;
    }

    @Override
    public double calcularPrecio() {
        return cafe.calcularPrecio();
    } 
}
