package edu.up.Microondas;

public class simulacion {
    public static void main(String[] args) {
        
        Microondas.setGirarPlato(true);
        Microondas.setPotencia(95);
        Microondas.setTiempo(5);

        System.out.println(Microondas.verConfiguracion());

        try {
            System.out.println("Prender ...");
            Microondas.cocinar();
        } catch (InterruptedException e) {
            System.out.println("El microondas no anda bien");;
        }
    }
}