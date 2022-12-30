package edu.up.FINAL.Dispositivo.components;

import edu.up.FINAL.Dispositivo.Dispositivo;

public class BotonRojo extends AbstractBoton {

    @Override
    protected void lanzarEvento(Dispositivo dispositivo) {
    
        dispositivo.emergenciaRoja(dispositivo);
        
    }
   
}