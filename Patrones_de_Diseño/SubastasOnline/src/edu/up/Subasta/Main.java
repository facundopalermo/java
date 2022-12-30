package edu.up.Subasta;

import java.util.ArrayList;
import java.util.List;

/*
 * Main de prueba, algunos metodos estan automatizados, como puede ser leave() de la clase User para decidir si seguir o no en la subasta.
 */

public class Main {
    public static void main(String[] args) {

        double newPrice = 0;

        User owner = new WebUser("Owner");
        
        /* El usuario 0 va a crear una subasta */
        Article articulo = owner.createAuction("Mona Lisa", 1000, 500000);

        /* Instancio usuarios de Mobile y Web (participantes) y entran a la subasta */
        List<User> users = new ArrayList<User>();
        for (int i = 0; i < 5; i++) {
            users.add(new MobileUser("Usuario_" + i));
            users.add(new WebUser("Usuario_" + (5 + i)));
        }

        for (User user : users) {
            user.joinAuction(articulo);
        }

        while (!articulo.isSelled()) {
            
            for (User user : users) {
                /* el usuario hace una oferta, si es 0, sale de la subasta */
                newPrice = user.toOffer(articulo.getActualPrice());
                if(newPrice > articulo.getActualPrice()) {

                    System.out.println(":::::::::>>> Usuario " + user.getName() + " oferta " + newPrice);

                    /* Aqui se va a notificar a todos los usuarios, y se imprimiran las vistas de los 10. */
                    System.out.print("\nVistas:\n");
                    articulo.setActualPrice(newPrice);
                    
                    /* Comprueba si el dueño acepta la oferta o alcanza el precio objetivo */
                    if(owner.acceptOffer(newPrice) || newPrice >= articulo.getTargetPrice()) {
                        articulo.setSelled(true);
                        System.out.println("Articulo vendido a " + user.name + " por un valor de $" + newPrice);
                        break;
                    }

                } else {
                    user.leaveAuction(articulo);
                }
            }

            if(!articulo.thereAreObservers()) {
                System.out.println("Subasta finalizada por falta de participantes.");
                break;
            }
        }
        
    }
}
