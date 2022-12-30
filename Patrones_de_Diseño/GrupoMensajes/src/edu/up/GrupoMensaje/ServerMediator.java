package edu.up.GrupoMensaje;

public interface ServerMediator {

    void sendMessage(String message);
    void sendMessage(ClientColleague from, String message);
    void sendMessage(ClientColleague from, String message, ClientColleague to);

    void receiveMessage(ClientColleague from, String message);
    void receiveMessage(ClientColleague from, String message, ClientColleague to);

    void addClient(ClientColleague o, ClientColleague client) throws Exception;
    void removeClient(ClientColleague client);
    
}
