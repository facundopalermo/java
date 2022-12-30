package edu.up.Subasta;

public class MobileUser extends User {

    public MobileUser (String name) {
        super(name, "Mobile");
    }

    @Override
    public void update(Article articulo) {
        System.out.println("Usuario: " + this.name);
        System.out.println("Dispositivo: " + this.source);
        System.out.println("Articulo: " + articulo.getDescription());
        System.out.println("Precio: " + articulo.getActualPrice());
        System.out.println("");
    }
    
}
