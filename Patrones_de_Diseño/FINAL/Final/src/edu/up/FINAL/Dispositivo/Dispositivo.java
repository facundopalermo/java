package edu.up.FINAL.Dispositivo;

import edu.up.FINAL.Dispositivo.components.AbstractBoton;
import edu.up.FINAL.Dispositivo.components.BotonAzul;
import edu.up.FINAL.Dispositivo.components.BotonRojo;
import edu.up.FINAL.Interfaces.Nodo;
import edu.up.FINAL.NodoConcentrador.NodoConcentrador;

public class Dispositivo implements Nodo {

    private int identificador;
    private String ubicacion = "Disposito aun no asignado";
    private NodoConcentrador nodoConcentrador;

    private AbstractBoton botonRojo = new BotonRojo();
    private AbstractBoton botonAzul = new BotonAzul();

    public Dispositivo(int identificador) {
        this.identificador = identificador;
    }

    public void botonAzul() {
        this.botonAzul.pedirAyuda(this);
    }

    public void botonRojo() {
        this.botonRojo.pedirAyuda(this);
    }

    @Override
    public void emergenciaAzul(Nodo dispositivo) {
        nodoConcentrador.emergenciaAzul(dispositivo);
    }

    @Override
    public void emergenciaRoja(Nodo dispositivo) {
        nodoConcentrador.emergenciaRoja(dispositivo);
    }


    /* GETTERS & SETTERS */

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public NodoConcentrador getNodoConcentrador() {
        return nodoConcentrador;
    }

    public void setNodoConcentrador(NodoConcentrador nodoConcentrador) {
        this.nodoConcentrador = nodoConcentrador;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

}