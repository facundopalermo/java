package edu.up.FINAL.Servicios.PoliciaStrategy;

import edu.up.FINAL.Interfaces.PoliciaStrategy;

public class PoliciaCodigoRojo implements PoliciaStrategy {

    @Override
    public String dispatch() {
        return "policia motorizado";
    }
    
}