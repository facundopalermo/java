package edu.up.FINAL.Facade;

import edu.up.FINAL.Afiliado.Afiliado;
import edu.up.FINAL.Dispositivo.Dispositivo;
import edu.up.FINAL.NodoConcentrador.NodoConcentrador;

public class Cliente {

    private Afiliado afiliado;
    private Dispositivo dispositivo = new Dispositivo((int)(Math.random()*10000+1));
    private NodoConcentrador nodo;

    public Cliente(String nombre, String apellido, String direccion, NodoConcentrador nodo) {

        this.nodo = nodo;
        this.nodo.addDispositivo(dispositivo);
        this.afiliado = new Afiliado.AfiliadoBuilder(nombre, apellido, direccion)
                                    .dispositivo(dispositivo)
                                    .build();

    }

    public void presionaBotonAzul() {
        dispositivo.botonAzul();
    }

    public void presionaBotonRojo() {
        dispositivo.botonRojo();
    }

    public String datos() {
        return "Cliente: " + afiliado.getNombre() +
             "\nApellido: " + afiliado.getApellido() +
             "\nDireccion: " + afiliado.getDireccion() +
             "\nBarrio: " + nodo.getBarrio() +
             "\n";
    }

    public String datosDispositivo() {
        return "Dispositivo s/n: " + dispositivo.getIdentificador() +
               "\nUbicacion: " + dispositivo.getUbicacion() +
               "\n";
    }
    
}