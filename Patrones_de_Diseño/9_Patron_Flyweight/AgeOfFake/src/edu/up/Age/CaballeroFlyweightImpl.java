package edu.up.Age;

public class CaballeroFlyweightImpl implements PersonajeFlyweight {

    private int vida;
    private int nivelMagia;
    private int nivelAtaque;
    private int nivelDefensa;

    public CaballeroFlyweightImpl() {
        this.vida = 50;
        this.nivelAtaque = 30;
        this.nivelDefensa = 20;
        this.nivelMagia = 5;
    }

    public int getVida() {
        return vida;
    }

    public int getNivelMagia() {
        return nivelMagia;
    }

    public int getNivelAtaque() {
        return nivelAtaque;
    }

    public int getNivelDefensa() {
        return nivelDefensa;
    }

    @Override
    public void setVida(int vida) {
        this.vida = vida;
    }

    @Override
    public void setNivelMagia(int nivelMagia) {
        this.nivelMagia = nivelMagia;
    }

    @Override
    public void setNivelAtaque(int nivelAtaque) {
        this.nivelAtaque = nivelAtaque;
    }

    @Override
    public void setNivelDefensa(int nivelDefensa) {
        this.nivelDefensa = nivelDefensa;
    }

    @Override
    public String toString() {
        return  "Caballero FLYWGT" +
                "[vidaTotal=" + vida + ", ataque=" + nivelAtaque + ", " +
                "defensa=" + nivelDefensa + ", magia="+ nivelMagia + "]"; 
    }

}
