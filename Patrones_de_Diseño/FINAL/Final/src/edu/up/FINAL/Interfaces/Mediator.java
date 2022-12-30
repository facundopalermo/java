package edu.up.FINAL.Interfaces;

import edu.up.FINAL.Dispositivo.Dispositivo;

public interface Mediator {

    void codigoAzul(Dispositivo dispositivo);
    void codigoRojo(Dispositivo dispositivo);
    
    void receiveMessage(String message);
    void receiveMessage(String codigo, Dispositivo dispositivo);

    void addColleage(Colleage colleage);
    void removeColleage(Colleage colleage);
    
}