import java.util.Random;

public class juego {
    public static void main(String[] args) {
        
        Random random = new Random();

        Mano jugador1 = eleccion(random.nextInt(0, 3));
        Mano jugador2 = eleccion(random.nextInt(0, 3));

        int resultado = jugador1.jugar(jugador2);

        System.out.println("J1: " + jugador1.toString() + " vs J2: " + jugador2.toString());

        switch (resultado) {
            case Mano.GANA: System.out.println("Jugador 2 gana");
                break;
            case Mano.PIERDE: System.out.println("Jugador 1 gana");
                break;
            case Mano.EMPATA: System.out.println("Empate");
                break;
            default: 
                break;
        }
    }

    private static Mano eleccion (int random) {

        Mano mano = null;
        switch (random) {
            case 0:
                mano = new Piedra();
                break;
            case 1:
                mano = new Papel();
                break;

            case 2:
                mano = new Tijera();
                break;

            default:
                break;
        }

        return mano;
    }
}
