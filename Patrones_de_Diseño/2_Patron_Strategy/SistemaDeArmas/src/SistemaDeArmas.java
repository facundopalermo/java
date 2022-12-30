public abstract class SistemaDeArmas {
    int energia;
    FormaDeVolar formaDeVolar;
    FormaDeAtacar formaDeAtacar;
    
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

    public void setFormaDeVolar(FormaDeVolar formaDeVolar) {
        this.formaDeVolar = formaDeVolar;
    }

    public FormaDeAtacar getFormaDeAtacar() {
        return formaDeAtacar;
    }

    public void setFormaDeAtacar(FormaDeAtacar formaDeAtacar) {
        this.formaDeAtacar = formaDeAtacar;
    }

    
}
