package edu.up.FINAL.NodoConcentrador;

import java.util.ArrayList;
import java.util.List;
import javax.naming.OperationNotSupportedException;

import edu.up.FINAL.Dispositivo.Dispositivo;
import edu.up.FINAL.Interfaces.Colleage;
import edu.up.FINAL.Interfaces.Nodo;

public class NodoConcentrador implements Nodo, Colleage {

    private int identificador;
    private String barrio;

    private List<Nodo> dispositivos = new ArrayList<Nodo>();

    public NodoConcentrador(String barrio, int identificador) {
        this.identificador = identificador;
        this.barrio = barrio;
        central.addColleage(this);
    }

    @Override
    public void emergenciaAzul(Nodo dispositivo) {
        postMessage("azul", (Dispositivo) dispositivo);
    }

    @Override
    public void emergenciaRoja(Nodo dispositivo) {
        postMessage("rojo", (Dispositivo) dispositivo);
    }

    @Override
    public void postMessage(String message) {
        central.receiveMessage(message);
    }

    @Override
    public void postMessage(String message, Dispositivo dispositivo) {
        central.receiveMessage(message, dispositivo);
    }

    @Override
    public void takeMessage(String message, Dispositivo dispositivo) throws OperationNotSupportedException{
        throw new OperationNotSupportedException("Operación no valida para un nodo concentrador");  
    }

    
    /* GETTERS & SETTERS */
    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public List<Nodo> getDispositivos() {
        return dispositivos;
    }

    public void addDispositivo(Dispositivo dispositivo) {
        this.dispositivos.add(dispositivo);
        dispositivo.setNodoConcentrador(this);
    }
    
}
