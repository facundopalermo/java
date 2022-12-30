public abstract class SistemaDeArmas {
    int energia;
    int litrosCombustible;

    FormaDeVolar formaDeVolar;
    FormaDeAtacar formaDeAtacar;

    /* 
     * Template method.
     * Final es para que no sea modificado
     */
    public final void ejecutarMision() {
        salir();
        irAlObjetivo();
        cumplirOrden();

        if(combustibleSuficiente()) {
            reabastecer();
        }

        regresar();
    }

    public abstract void salir();
    public abstract void regresar();

    protected void irAlObjetivo() {
        System.out.println("Yendo al objetivo");
    }

    protected void cumplirOrden() {
        this.ejecutarAtaque();
        System.out.println("Mision cumplida");
    }

    protected boolean reabastecer() {
        return true;
    }

    public boolean combustibleSuficiente() {
        return true;
    }
    
    public void ejecutarVuelo() {
        this.formaDeVolar.volar();
    }

    public void ejecutarAtaque() {
        this.formaDeAtacar.atacar();
    }

    public void mostrar() {
        System.out.println("Muestro Sistema de Armas");
    }

    public FormaDeVolar getFormaDeVolar() {
        return formaDeVolar;
    }

    /* Getters y Setters */
    public void setFormaDeVolar(FormaDeVolar formaDeVolar) {
        this.formaDeVolar = formaDeVolar;
    }

    public FormaDeAtacar getFormaDeAtacar() {
        return formaDeAtacar;
    }

    public void setFormaDeAtacar(FormaDeAtacar formaDeAtacar) {
        this.formaDeAtacar = formaDeAtacar;
    }

    public int getLitrosCombustible() {
        return litrosCombustible;
    }

    public void setLitrosCombustible(int litrosCombustible) {
        this.litrosCombustible = litrosCombustible;
    }

    
}
