package edu.up.Banca;

public class CajaDeAhorroEnPesos extends Cuenta {

    public CajaDeAhorroEnPesos(int numeroDeCuenta) {
        super(numeroDeCuenta);
    }

    final double INTERES = 1.5; 

    protected double calcularInteres(double monto) {
        double interesCalculado = 0;
        interesCalculado = (monto * INTERES)/100;
        return interesCalculado;
    }
    
}
