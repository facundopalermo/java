package edu.up.Banca;

public abstract class Cuenta {
    
    private int numeroDeCuenta;
    private double saldo;

    /* constructor */
    public Cuenta(int numeroDeCuenta) {
        this.numeroDeCuenta = numeroDeCuenta;
    }

    protected abstract double calcularInteres(double monto);

    public final double transferir(Cuenta destino, double monto) throws Exception {
        double intereses = 0;
        double total = 0;
        
        intereses = calcularInteres(monto);
        total = monto + intereses;

        if(verificarSaldo(total)) {
            this.saldo = this.saldo - total;
            destino.recibir(monto);
            return intereses;
        }

        throw new Exception("Sin fondos");
    }

    private boolean verificarSaldo (double requerido) {
        if(this.saldo >= requerido) {
            return true;
        }
        return false;
    }

    public void recibir (double monto) {
        depositar (monto);
    }

    public void depositar (double monto) {
        this.saldo = this.saldo + monto;
    }

    /* GETTERS y SETTERS */
    public int getNumeroDeCuenta() {
        return numeroDeCuenta;
    }

    public void setNumeroDeCuenta(int numeroDeCuenta) {
        this.numeroDeCuenta = numeroDeCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
