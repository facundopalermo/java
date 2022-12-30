package edu.up.GrupoMensaje;

import java.util.List;

public class Simulacion {

    public static void main(String[] args) {

        GroupChat server = GroupChat.getGroupchat();

        UserClient facundo = new UserClient("Facundo");
        UserClient juana = new UserClient("Juana");
        UserClient augusto = new UserClient("Augusto");
        UserClient romina = new UserClient("Romina");

        System.out.println("Conecta Facundo y es el owner");
        
        try {
            facundo.connect();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nConecta Juana");
        try {
            juana.connect();
        } catch (Exception e) {
            System.out.println("\t" + e.getMessage());
        }
        
        /* probado que nadie mas puede ser el duenio... */
        System.out.println("\nFacundo agrega a Juana");
        facundo.addUser(juana);

        System.out.println("\nJuana intenta agregar a Augusto");
        juana.addUser(augusto);

        System.out.println("\nFacundo agrega a Augusto");
        facundo.addUser(augusto);

        System.out.println("\nFacundo agrega a Romina");
        facundo.addUser(romina);

        listarConectados(server.getListClient());

        System.out.println("\nComienza la charla...\n");

        facundo.postMessage("Hola a todos");
        System.out.println("");
        juana.postMessage("Hola", "Facundo");
        System.out.println("");
        augusto.postMessage("Hola gente, como estan?");
        System.out.println("");
        romina.postMessage("Feliz de la vida, pero ya me voy. Chau");

        System.out.println("\nDesconecta Romina");
        romina.disconnect();
        listarConectados(server.getListClient());

        System.out.println("\nSigue la charla...\n");
        facundo.postMessage("que amarga...");
        System.out.println("");
        facundo.postMessage("Vos tambien te vas?", "Juauana");
        System.out.println("");
        facundo.postMessage("Vos tambien te vas?", "Juana");
        System.out.println("");
        juana.postMessage("Si, chau");

        System.out.println("\nDesconecta Juana");
        juana.disconnect();
        System.out.println("\nDesconecta Augusto");
        augusto.disconnect();

        System.out.println("\nPobre Facundo...\n");
        facundo.postMessage("-.-\"");

        System.out.println("\nDesconecta Facundo");
        facundo.disconnect();

        listarConectados(server.getListClient());


    }

    private static void listarConectados(List<ClientColleague> lista) {
        System.out.println("\nLista de Conectados:");
        if(lista.size() > 0) {
            for (ClientColleague usuario : lista) {
                System.out.println("\t" + ((UserClient)usuario).getName());
            }
        }else{
            System.out.println("\tNadie conectado.");
        }

    }
    
}
