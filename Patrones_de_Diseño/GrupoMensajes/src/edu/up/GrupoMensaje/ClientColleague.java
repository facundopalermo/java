package edu.up.GrupoMensaje;

public interface ClientColleague {

    void connect() throws Exception;
    void disconnect();
    void getMessage(String message);
    void postMessage(String message);
    void postMessage(String message, String to);

}
