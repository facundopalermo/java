public class Main {
    public static void main(String[] args) {

        /*Strategy define una familia de algoritmos encapsulados de forma tal que puedan intercambiarse. El patrón Strategy permite variar entre diferentes algoritmos sin afectar a los clientes que los usan. */
        
        SistemaDeArmas T8000 = new RobotPesado();
        T8000.setFormaDeAtacar(new AtacarConBalas());
        T8000.setFormaDeVolar(new VolarConPropulsores());

        T8000.mostrar();
        T8000.ejecutarVuelo();
        T8000.ejecutarAtaque();
    }
}
