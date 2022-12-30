package edu.up.enchufes;

public class EnchufeAmericano implements EnchufeTipoA {

    @Override
    public void corriente() {
        System.out.println("110 voltios");
    }
}
