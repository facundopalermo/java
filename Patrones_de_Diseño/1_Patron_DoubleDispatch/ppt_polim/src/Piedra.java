public class Piedra implements Mano{

    public String jugar (Mano mano) {

        if(mano instanceof Piedra) {
            return "Empate";
        }else if (mano instanceof Papel) {
            return "Papel";
        }else {
            return "Piedra";
        }
    }

    public String toString() {
        return getClass().getName();
    }
}
