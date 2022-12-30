package edu.up.FINAL.Dispositivo.components;

import edu.up.FINAL.Dispositivo.Dispositivo;

public abstract class AbstractBoton {
    
    public final void pedirAyuda(Dispositivo dispositivo) {
        lanzarEvento(dispositivo);
    }

    protected abstract void lanzarEvento(Dispositivo dispositivo);
    
}