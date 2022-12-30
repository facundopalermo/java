package edu.up.enchufes;

public class AtoCAdapter implements EnchufeTipoA {

    private EnchufeTipoC enchufe;

    public AtoCAdapter(EnchufeTipoC enchufe) {
        this.enchufe = enchufe;
    }

    @Override
    public void corriente() {
        this.enchufe.corriente();
    }
}
