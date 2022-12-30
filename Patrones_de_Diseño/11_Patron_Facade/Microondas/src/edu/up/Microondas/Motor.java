package edu.up.Microondas;

public class Motor {
    
    private boolean girar = false;

    public void girarPlato(boolean girar) {
        this.girar = girar;
    }

    public boolean getGirar() {
        return girar;
    }
}
