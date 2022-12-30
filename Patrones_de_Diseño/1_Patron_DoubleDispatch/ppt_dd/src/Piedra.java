public class Piedra implements Mano {

    public int jugar(Mano mano) {
        return mano.jugarVsPiedra(this);
    }

    public int jugarVsPiedra(Piedra mano) {
        return EMPATA;
    }

    public int jugarVsPapel(Papel mano) {
        return PIERDE;
    }

    public int jugarVsTijera(Tijera mano) {
        return GANA;
    }

    public String toString() {
        return getClass().getName();
    }

}
