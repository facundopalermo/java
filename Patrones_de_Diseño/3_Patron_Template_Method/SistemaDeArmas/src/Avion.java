public class Avion extends SistemaDeArmas {

    final int MAXIMO_COMBUSTIBLE = 100; 

    public void salir() {
        System.out.println("Salgo del Hangar");
        System.out.println("Despego");
        this.ejecutarVuelo();
    }

    public void regresar() {
        System.out.println("Regresando");
        System.out.println("Aterricé");
    }

    public boolean combustibleSuficiente() {

        int percent = 0;
        percent = (litrosCombustible * 100) / MAXIMO_COMBUSTIBLE;

        if (percent > 10) {
            return false;
        }

        return true;

    }

    public boolean reabastecer() {
        this.setLitrosCombustible(100);
        System.out.println("Combustible reabastecido");
        return true;
    }
}
