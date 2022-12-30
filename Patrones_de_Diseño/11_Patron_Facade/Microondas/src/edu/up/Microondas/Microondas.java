package edu.up.Microondas;

public class Microondas {

    private static Potencia potencia = new Potencia();
    private static Motor motor = new Motor();
    private static Tiempo tiempo = new Tiempo();

    public static void setPotencia(int val) {
        potencia.setPotencia(val);
    }

    public static void setGirarPlato(boolean val) {
        motor.girarPlato(val);
    }

    public static void setTiempo(int sec) {
        tiempo.setTiempo(sec);
    }

    public static void cocinar() throws InterruptedException {
        tiempo.correrTiempo();
        System.out.println("Listo");
    }

    public static String verConfiguracion() {

        return "\nPotencia: " + potencia.getPotencia() + "\nGirar: " + (motor.getGirar()?"Si":"No") + "\nTiempo: " + tiempo.getTiempo();

    }


}
