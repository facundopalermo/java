public class Tijera implements Mano {

    public int jugar(Mano mano) {
        return mano.jugarVsTijera(this);
    }

    public int jugarVsPiedra(Piedra mano) {
        return PIERDE;
    }

    public int jugarVsPapel(Papel mano) {
        return GANA;
    }

    public int jugarVsTijera(Tijera mano) {
        return EMPATA;
    }

    public String toString() {
        return getClass().getName();
    }

}
