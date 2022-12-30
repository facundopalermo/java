package edu.up.GrupoMensaje;

public class UserClient implements ClientColleague {

    private String name = "";
    private GroupChat server = GroupChat.getGroupchat();;

    public UserClient(String name) {
        this.name = name;
    }

    public void addUser(UserClient user) {
        try{
            server.addClient(this, user);
        }catch (Exception e) {
            System.out.println("No puedes agregar usuarios al chat, no eres el owner del grupo\n");
        }
    }
    
    public void connect() throws Exception {
        if(server.getOwner() == null) {
            server.setOwner(this);
            server.addClient(this, this);
        }else{
            throw new Exception("No puede conectar solo. Pidale al duenio: " + ((UserClient) server.getOwner()).getName());
        }
    }

    @Override
    public void disconnect() {
        server.removeClient(this);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("\t(recibido en " + name + ") -> " + message);
    }

    @Override
    public void postMessage(String message) {
        server.receiveMessage(this, message);
    }

    public void postMessage(String message, String to) {
        UserClient userTo = server.getUserFromList(to);
        server.receiveMessage(this, message, userTo);
    }

    public String getName() {
        return name;
    }

}
