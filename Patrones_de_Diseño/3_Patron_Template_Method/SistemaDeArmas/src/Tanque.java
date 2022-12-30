public class Tanque extends SistemaDeArmas {

    public void salir() {
        System.out.println("Salgo del Cuartel");
        System.out.println("Voy");
    }

    public void regresar() {
        System.out.println("Regresando");
        System.out.println("Guardado");
    }

    public boolean combustibleSuficiente() {

        if (litrosCombustible > 10) {
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
