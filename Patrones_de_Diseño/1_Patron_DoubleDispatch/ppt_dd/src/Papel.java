public class Papel implements Mano {

    public int jugar(Mano mano) {
        return mano.jugarVsPapel(this);
    }

    public int jugarVsPiedra(Piedra mano) {
        return GANA;
    }

    public int jugarVsPapel(Papel mano) {
        return EMPATA;
    }

    public int jugarVsTijera(Tijera mano) {
        return PIERDE;
    }
    
    public String toString() {
        return getClass().getName();
    }

}
