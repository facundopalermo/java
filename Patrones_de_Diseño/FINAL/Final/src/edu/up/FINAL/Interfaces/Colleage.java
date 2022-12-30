package edu.up.FINAL.Interfaces;

import javax.naming.OperationNotSupportedException;

import edu.up.FINAL.Central.SistemaCentral;
import edu.up.FINAL.Dispositivo.Dispositivo;

public interface Colleage {

    Mediator central = SistemaCentral.getSistemaCentral();

    public void postMessage(String message);
    public void postMessage(String message, Dispositivo dispositivo) throws OperationNotSupportedException;
    public void takeMessage(String message, Dispositivo dispositivo) throws OperationNotSupportedException;
    
}