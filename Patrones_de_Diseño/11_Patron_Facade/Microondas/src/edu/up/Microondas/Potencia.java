package edu.up.Microondas;

public class Potencia {
    
    private int potencia = 0;
    private int potencia_maxima = 100;

    public void setPotencia (int potencia) {
        this.potencia = potencia < 0 ? 0 : (potencia > potencia_maxima ? potencia_maxima : potencia);
    }

    public int getPotencia() {
        return potencia;
    }

    public int getPotencia_maxima() {
        return potencia_maxima;
    }

}
