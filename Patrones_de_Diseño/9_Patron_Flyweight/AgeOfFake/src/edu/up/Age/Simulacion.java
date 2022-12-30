package edu.up.Age;

import java.util.ArrayList;
import java.util.List;

public class Simulacion {
    public static void main(String[] args) {
        
        List<Object> mapa = new ArrayList<>();

        Caballero c1 = new Caballero("Caballero 1", 10);
        Caballero c2 = new Caballero("Caballero 2", 9);
        Caballero c3 = new Caballero("Caballero 3", 11);

        Dragon d1 = new Dragon("Dragon 1", 10);
        Dragon d2 = new Dragon("Dragon 2", 9);
        Dragon d3 = new Dragon("Dragon 3", 11);

        mapa.add(c1);
        mapa.add(c2);
        mapa.add(c3);
        mapa.add(d1);
        mapa.add(d2);
        mapa.add(d3);

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);

        System.out.println("Objetos");
        System.out.println(mapa.size());
        System.out.println("Cache");
        System.out.println(PersonajeFlyweightFactory.getCacheSize());
        
    }
}
