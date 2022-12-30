import java.util.Date;

public class Biblioteca {

    public static void main(String[] args) {
        Libro libro = new Libro.LibroBuilder("El señor de los anillos", "J.R.R. Tolkien", "L1-02")
        .fechaPublicacion(new Date())
        .editorial("Atlantida")
        .cantidadCapitulos(25)
        .cantidadEjemplares(666)
        .build();

        System.out.println(libro);
    }
}
