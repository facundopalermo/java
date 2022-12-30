package edu.up.enchufes;

public class Simulacion {
    public static void main(String[] args) {
        
        EnchufeTipoA enchufeA = new EnchufeAmericano();
        Aparato aparato = new Aparato(enchufeA);

        System.out.println("conectar aparato americano en enchufe americano:");
        aparato.conectar();

        EnchufeTipoC enchufeC = new EnchufeArgentino();
        EnchufeTipoA adaptador = new AtoCAdapter(enchufeC);

        Aparato aparato2 = new Aparato(adaptador);
        System.out.println("conectar aparato americano en enchufe argentino:");
        aparato2.conectar();
    }   
}
