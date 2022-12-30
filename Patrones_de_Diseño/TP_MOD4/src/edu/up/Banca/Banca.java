package edu.up.Banca;

public class Banca {
    
    /*
     * main para simular 3 operaciones
     */
    public static void main(String[] args) {

        double monto = 0;
        double interesGanado = 0;
        double gananciaBancaria = 0;
        
        /* crea 2 clientes */
        Cliente cliente1 = new Cliente(34172722, "Facundo", "Palermo");

        Cliente cliente2 = new Cliente(12345678, "Don Satur", "Fundadoen1967");

        /* abre una cuenta a cada cliente */
        cliente1.abrirCuenta("Ahorro");
        cliente2.abrirCuenta("CtaCte");

        /* deposito saldo a cada cliente */
        cliente1.getCuenta(0).depositar(3500);
        System.out.println(cliente1.getNombre() + " deposita $3500");
        cliente2.getCuenta(0).depositar(2000);
        System.out.println(cliente2.getNombre() + " deposita $2000\n");


        /* Cliente 1 a Cliente 2 */
        try {
            monto = 1800;
            System.out.println(cliente1.getNombre() + " transfiere " + monto + " a " + cliente2.getNombre());
            interesGanado = cliente1.getCuenta(0).transferir(cliente2.getCuenta(0), monto);
            System.out.println("Saldo en cuenta de " + cliente1.getNombre() + ": " + cliente1.getCuenta(0).getSaldo());
            System.out.println("Saldo en cuenta de " + cliente2.getNombre() + ": " + cliente2.getCuenta(0).getSaldo());
            
            gananciaBancaria = gananciaBancaria + interesGanado;
            System.out.println("Interes ganado por el banco: " + interesGanado + ". Ganancia total: " + gananciaBancaria);

        } catch (Exception e) {
            System.out.println("Fondos insuficientes");
        }

        System.out.println("\n");

        /* Cliente 2 a Cliente 1 */
        try {  
            monto = 700;
            System.out.println(cliente2.getNombre() + " transfiere " + monto + " a " + cliente1.getNombre());
            interesGanado = cliente2.getCuenta(0).transferir(cliente1.getCuenta(0), monto);
            System.out.println("Saldo en cuenta de " + cliente1.getNombre() + ": " + cliente1.getCuenta(0).getSaldo());
            System.out.println("Saldo en cuenta de " + cliente2.getNombre() + ": " + cliente2.getCuenta(0).getSaldo());
            
            gananciaBancaria = gananciaBancaria + interesGanado;
            System.out.println("Interes ganado por el banco: " + interesGanado + ". Ganancia total: " + gananciaBancaria);
        } catch (Exception e) {
            System.out.println("Fondos insuficientes. Operación cancelada");
        }

        System.out.println("\n");

        /* Sin fondos */
        try {
            monto = 99999;
            System.out.println(cliente1.getNombre() + " transfiere " + monto + " a " + cliente2.getNombre());
            interesGanado = cliente1.getCuenta(0).transferir(cliente2.getCuenta(0), monto);
            System.out.println("Saldo en cuenta de " + cliente1.getNombre() + ": " + cliente1.getCuenta(0).getSaldo());
            
            gananciaBancaria = gananciaBancaria + interesGanado;
            System.out.println("Interes ganado por el banco: " + interesGanado + ". Ganancia total: " + gananciaBancaria);
        } catch (Exception e) {
            System.out.println("Fondos insuficientes");
        }
        
    }
}
