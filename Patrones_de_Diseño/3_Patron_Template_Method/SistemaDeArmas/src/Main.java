public class Main {
    public static void main(String[] args) {
        
        SistemaDeArmas avion = new Avion();
        avion.setFormaDeAtacar(new AtacarConMisiles());
        avion.setFormaDeVolar(new VolarConPropulsores());
        avion.setLitrosCombustible(80);

        SistemaDeArmas barco = new Barco();
        barco.setFormaDeAtacar(new AtacarConBalas());
        
        SistemaDeArmas tanque = new Tanque();
        tanque.setFormaDeAtacar(new AtacarConRayos());
        tanque.setLitrosCombustible(5);

        System.out.println("Avion");
        avion.ejecutarMision();

        System.out.println("\nBarco");
        barco.ejecutarMision();

        System.out.println("\nTanque");
        tanque.ejecutarMision();

    }
}