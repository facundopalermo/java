package edu.up.FINAL.Servicios;

import javax.naming.OperationNotSupportedException;

import edu.up.FINAL.Dispositivo.Dispositivo;
import edu.up.FINAL.Interfaces.Colleage;
import edu.up.FINAL.Interfaces.PoliciaStrategy;
import edu.up.FINAL.Servicios.PoliciaStrategy.PoliciaCodigoAzul;
import edu.up.FINAL.Servicios.PoliciaStrategy.PoliciaCodigoRojo;

public class Policia implements Colleage {

    private PoliciaStrategy strategy;

    @Override
    public void takeMessage(String message, Dispositivo dispositivo) {

        if(message.equals("rojo")){
            strategy = new PoliciaCodigoRojo();
        }else {
            strategy = new PoliciaCodigoAzul();
        }

        postMessage("Recibido, enviando " + strategy.dispatch() + " a ubicacion:\n    Dispositivo " + 
                        dispositivo.getIdentificador() + 
                        "\n    Direccion: " + dispositivo.getUbicacion());
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