package edu.up.FINAL;

import edu.up.FINAL.Facade.Ciudad;
import edu.up.FINAL.Facade.Cliente;
import edu.up.FINAL.NodoConcentrador.NodoConcentrador;

public class Simulacion {
    
    public static void main(String[] args) {
        
        Ciudad.iniciarCiudad();
        NodoConcentrador nodoVillaCrespo = new NodoConcentrador("Villa crespo", 1234);
        NodoConcentrador nodoPalermo = new NodoConcentrador("Palermo", 4321);

        Cliente cliente1 = new Cliente("Facundo", "Palermo", "Aguirre 301", nodoVillaCrespo);
        Cliente cliente2 = new Cliente("Esteban", "Phillips", "Hidalgo 1432", nodoVillaCrespo);
        Cliente cliente3 = new Cliente("Universidad", "Palermo", "Mario Bravo 1050", nodoPalermo);

        System.out.println(cliente1.datos());
        System.out.println(cliente1.datosDispositivo());

        System.out.println("-----------------------------------");

        System.out.println(cliente2.datos());
        System.out.println(cliente2.datosDispositivo());

        System.out.println("-----------------------------------");

        System.out.println(cliente3.datos());
        System.out.println(cliente3.datosDispositivo());

        System.out.println("-----------------------------------");

        System.out.println("\nCliente 1 presiona Boton Azul");
        cliente1.presionaBotonAzul();
        System.out.println("\nCliente 2 presiona Boton Rojo");
        cliente2.presionaBotonRojo();
        System.out.println("\nCliente 3 presiona Boton Azul");
        cliente3.presionaBotonAzul();

    }
    
}
