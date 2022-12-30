package edu.up.Banca;

public class CuentaCorrienteEnPesos extends Cuenta{
    final double INTERES = 3; 

    public CuentaCorrienteEnPesos(int numeroDeCuenta) {
        super(numeroDeCuenta);
    }

    protected double calcularInteres(double monto) {
        double interesCalculado = 0;
        interesCalculado = (monto * INTERES)/100;
        return interesCalculado;
    }
}
