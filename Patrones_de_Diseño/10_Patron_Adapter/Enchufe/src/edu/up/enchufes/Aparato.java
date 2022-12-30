package edu.up.enchufes;

public class Aparato {

    private EnchufeTipoA enchufe;

    public Aparato (EnchufeTipoA enchufe) {
        this.enchufe = enchufe;
    }

    public void conectar() {
        this.enchufe.corriente();
    }

}
