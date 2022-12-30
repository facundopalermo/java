public interface Mano {

    int GANA = 1, PIERDE = 2, EMPATA = 3; 

    int jugar(Mano mano);
    int jugarVsPiedra(Piedra mano);
    int jugarVsPapel(Papel mano);
    int jugarVsTijera(Tijera mano);

}
