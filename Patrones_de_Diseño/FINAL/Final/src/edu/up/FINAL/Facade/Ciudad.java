package edu.up.FINAL.Facade;

import edu.up.FINAL.Central.SistemaCentral;
import edu.up.FINAL.Servicios.Ambulancia;
import edu.up.FINAL.Servicios.Bombero;
import edu.up.FINAL.Servicios.Policia;

public class Ciudad {

    static SistemaCentral central = SistemaCentral.getSistemaCentral();

    static Policia policia = new Policia();
    static Ambulancia ambulancia = new Ambulancia();
    static Bombero bombero = new Bombero();

    public static void iniciarCiudad() {
        central.addColleage(policia);
        central.addColleage(ambulancia);
        central.addColleage(bombero);
    }
    
}