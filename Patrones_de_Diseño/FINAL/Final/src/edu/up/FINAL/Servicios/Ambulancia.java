package edu.up.FINAL.Servicios;

import javax.naming.OperationNotSupportedException;

import edu.up.FINAL.Dispositivo.Dispositivo;
import edu.up.FINAL.Interfaces.Colleage;

public class Ambulancia implements Colleage {

    @Override
    public void takeMessage(String message, Dispositivo dispositivo) {
        
        if(message.equals("rojo")){
            postMessage("Recibido, enviando ambulancia a ubicacion:\n    Dispositivo " + 
                        dispositivo.getIdentificador() + 
                        "\n    Direccion: " + dispositivo.getUbicacion());
        }
    }

    @Override
    public void postMessage(String message) {
        central.receiveMessage(message);
    }

    @Override
    public void postMessage(String message, Dispositivo dispositivo) throws OperationNotSupportedException {
        throw new OperationNotSupportedException("Operación no valida para un servicio"); 
    }
    
}