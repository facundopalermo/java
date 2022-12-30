public class Tijera implements Mano {

    public String jugar (Mano mano) {

        if(mano instanceof Tijera) {
            return "Empate";
        }else if (mano instanceof Piedra) {
            return "Piedra";
        }else {
            return "Tijera";
        }
    }

    public String toString() {
        return getClass().getName();
    }
}
