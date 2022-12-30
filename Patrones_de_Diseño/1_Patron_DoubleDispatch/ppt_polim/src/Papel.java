public class Papel implements Mano {

    public String jugar (Mano mano) {

        if(mano instanceof Papel) {
            return "Empate";
        }else if (mano instanceof Tijera) {
            return "Tijera";
        }else {
            return "Papel";
        }
    }

    public String toString() {
        return getClass().getName();
    }
}
