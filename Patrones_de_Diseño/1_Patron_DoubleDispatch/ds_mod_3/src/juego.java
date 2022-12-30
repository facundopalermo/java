import java.util.ArrayList;
import java.util.Random;

public class juego {
    public static void main(String[] args) {
        
        Random random = new Random();

        String ganador = new String("");

        int jugador1 = random.nextInt(0, 3);
        int jugador2 = random.nextInt(0, 3);

        ArrayList<String> mano = new ArrayList<String>();
        mano.add("Piedra");
        mano.add("Papel");
        mano.add("Tijera");

        System.out.println("J1:" + mano.get(jugador1) + " vs J2:" + mano.get(jugador2));
        
        if (jugador1 == jugador2){
            ganador = "Empate";
        } else if (jugador1 == 0 && jugador2 == 2){
            ganador = "Jugador 1";
        } else if (jugador1 == 1 && jugador2 == 0){
            ganador = "Jugador 1";
        } else if (jugador1 == 2 && jugador2 == 1){
            ganador = "Jugador 1";
        } else {
            ganador = "Jugador 2";
        }
        
        System.out.println(ganador);
    }
}
