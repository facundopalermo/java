package edu.up.enchufes;

public class EnchufeArgentino implements EnchufeTipoC {
    @Override
    public void corriente() {
        System.out.println("220 voltios");
    }
}
