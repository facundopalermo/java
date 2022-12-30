package edu.up.FINAL.Dispositivo.components;

import edu.up.FINAL.Dispositivo.Dispositivo;

public class BotonAzul extends AbstractBoton {

    @Override
    protected void lanzarEvento(Dispositivo dispositivo) {
    
        dispositivo.emergenciaAzul(dispositivo);
        
    }
    
}