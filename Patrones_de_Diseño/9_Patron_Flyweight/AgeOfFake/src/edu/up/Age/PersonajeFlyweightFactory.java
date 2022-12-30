package edu.up.Age;

import java.util.HashMap;

public class PersonajeFlyweightFactory {
    
    private static final HashMap<String, PersonajeFlyweight> cache = new HashMap<>();

    public static PersonajeFlyweight getDragonFlyweightImpl() {
        
        String key = "DRAGON";
        PersonajeFlyweight personaje = cache.get(key);

        if(personaje == null) {
            personaje = new DragonFlyweightImpl();
            cache.put(key, personaje);
        }

        return personaje;
    }

    public static PersonajeFlyweight getCaballeroFlyweightImpl() {
        
        String key = "CABALLERO";
        PersonajeFlyweight personaje = cache.get(key);

        if(personaje == null) {
            personaje = new DragonFlyweightImpl();
            cache.put(key, personaje);
        }

        return personaje;
    }

    public static int getCacheSize() {
        return cache.size();
    }
}
