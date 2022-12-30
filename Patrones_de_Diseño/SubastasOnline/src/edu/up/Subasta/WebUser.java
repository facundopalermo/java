package edu.up.Subasta;

public class WebUser extends User {

    public WebUser (String name) {
        super(name, "Web");
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
