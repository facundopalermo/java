package edu.up.Microondas;

public class Tiempo {
    
    private int tiempo = 0;

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo < 0 ? 0 : tiempo;
    }

    public void correrTiempo () throws InterruptedException {

        if (this.tiempo > 0) {
            for (int i = this.tiempo; i > 0; i--) {
                System.out.println(i);
                Thread.sleep(1000);
            }
        }
    }

    public int getTiempo() {
        return tiempo;
    }

}
