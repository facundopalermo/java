package edu.up.GrupoMensaje;

import java.util.List;
import java.util.ArrayList;

public class GroupChat implements ServerMediator {

    private static GroupChat groupchat = null;
    private ClientColleague owner = null;
    private List<ClientColleague> listClient = new ArrayList<>();

    private GroupChat() {}

    public static GroupChat getGroupchat() {

        if (groupchat == null) {
            groupchat = new GroupChat();
        }
        return groupchat;
    }

    @Override
    public void addClient(ClientColleague o, ClientColleague client) throws Exception {
        if(o == owner){
            listClient.add(client);
            sendMessage(((UserClient) client).getName() + " se ha unido al grupo."); 
        }else{
            throw new Exception("usuario no duenio");
        }

    }

    @Override
    public void removeClient(ClientColleague client) {
        listClient.remove(client);
        sendMessage(((UserClient) client).getName() + " ha abandonado el grupo.");
    }

    @Override
    public void sendMessage(String message) {
        for (ClientColleague client : listClient) {
            client.getMessage(message);
        }
    }

    @Override
    public void sendMessage(ClientColleague from, String message) {
        sendMessage (((UserClient)from).getName() + ": " + message);
    }

    @Override
    public void sendMessage(ClientColleague from, String message, ClientColleague to ) {
        to.getMessage(((UserClient)from).getName() + ": " + message);
    }


    @Override
    public void receiveMessage(ClientColleague from, String message, ClientColleague to) {
        String text = "";

        UserClient userTo = (UserClient)to;

        if (userTo != null) {
            text = "@" + userTo.getName() + " " + message;
            sendMessage(from, text  + " (este es especial)", to);
        } else {
            text = "El usuario arrobado no existe.";
        }

        sendMessage(from, text);
    }

    @Override
    public void receiveMessage(ClientColleague from, String message) {
        sendMessage(from, message);
    }

    public List<ClientColleague> getListClient() {
        return listClient;
    }

    public UserClient getUserFromList(String name) {
        for (ClientColleague clientColleague : listClient) {
            if(((UserClient) clientColleague).getName() == name){
                return (UserClient)clientColleague;
            }
        }

        return null;
    }
    public ClientColleague getOwner() {
        return owner;
    }
    public void setOwner(ClientColleague owner) {
        this.owner = owner;
    }
}
