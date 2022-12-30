package edu.up.FINAL.Central;

import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import edu.up.FINAL.Dispositivo.Dispositivo;
import edu.up.FINAL.Interfaces.Colleage;
import edu.up.FINAL.Interfaces.Mediator;
import edu.up.FINAL.NodoConcentrador.NodoConcentrador;
import edu.up.FINAL.Servicios.Policia;

public class SistemaCentral implements Mediator {

    private static SistemaCentral central = null;
    private List<Colleage> colleages = new ArrayList<>(); 

    private SistemaCentral(){}

    public static SistemaCentral getSistemaCentral() {

        if(central == null){
            central = new SistemaCentral();
        }

        return central;
    }

    @Override
    public void codigoAzul(Dispositivo dispositivo) {
        for (Colleage colleage : colleages) {
            if(colleage instanceof Policia) {
                try {
                    colleage.takeMessage("azul", dispositivo);
                } catch (OperationNotSupportedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void codigoRojo(Dispositivo dispositivo) {
        for (Colleage colleage : colleages) {
            
            if(!(colleage instanceof NodoConcentrador)){
                try {
                    colleage.takeMessage("rojo", dispositivo);
                } catch (OperationNotSupportedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void receiveMessage(String codigo, Dispositivo dispositivo) {
        
        if(codigo.equals("azul")){
            codigoAzul(dispositivo);
        }

        if(codigo.equals("rojo")){
            codigoRojo(dispositivo);
        }
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void addColleage(Colleage colleage) {
        colleages.add(colleage);
    }

    @Override 
    public void removeColleage(Colleage colleage) {
        colleages.remove(colleage);
    }
    
}