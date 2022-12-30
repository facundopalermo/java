package edu.up.FINAL.Servicios.PoliciaStrategy;

import edu.up.FINAL.Interfaces.PoliciaStrategy;

public class PoliciaCodigoAzul implements PoliciaStrategy{

    @Override
    public String dispatch() {
        
        return "patrullero";
    }
    
}