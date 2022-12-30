package edu.up.Cafeteria;

import edu.up.Cafeteria.Decorators.JarabeDeVainilla;
import edu.up.Cafeteria.Decorators.Leche;

public class Sistema {
    
    public static void main(String[] args) {
        
        Cafe pedido1 = new TostadoIntenso();
        System.out.println("Pedido 1: Tostado Intenso - Precio: " + pedido1.calcularPrecio());

        Cafe pedido2 = new Leche(new TostadoSuave());
        System.out.println("Pedido 2: Tostado Suave con Leche - Precio: " + pedido2.calcularPrecio());

        Cafe pedido3 = new JarabeDeVainilla(new Leche(new TostadoIntenso()));
        System.out.println("Pedido 3: Tostado Intenso con Leche y Jarabe de Vainilla - Precio: " + pedido3.calcularPrecio());

    }
}
