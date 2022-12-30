import java.util.Date;

public class Libro {
    private String titulo;
    private String autor;
    private Date fechaPublicacion;
    private String editorial;
    private String ubicacion;
    private int cantidadCapitulos;
    private int cantidadEjemplares;

    private Libro(LibroBuilder builder) {
        this.titulo = builder.titulo;
        this.autor = builder.autor;
        this.fechaPublicacion = builder.fechaPublicacion;
        this.editorial = builder.editorial;
        this.ubicacion = builder.ubicacion;
        this.cantidadCapitulos = builder.cantidadCapitulos;
        this.cantidadEjemplares = builder.cantidadEjemplares;
    }

    @Override
    public String toString() {
        return  titulo + " - " +
        autor + " - " +
        fechaPublicacion + " - " +
        editorial + " - " +
        ubicacion + " - " +
        cantidadCapitulos + " - " +
        cantidadEjemplares;
    }

    public static class LibroBuilder {
        private String titulo;
        private String autor;
        private Date fechaPublicacion;
        private String editorial;
        private String ubicacion;
        private int cantidadCapitulos;
        private int cantidadEjemplares;

        public LibroBuilder(String titulo, String autor, String ubicacion) {
            this.titulo = titulo;
            this.autor = autor;
            this.ubicacion = ubicacion;
        }

        public LibroBuilder fechaPublicacion (Date fechaPublicacion) {
            this.fechaPublicacion = fechaPublicacion;
            return this;
        }

        public LibroBuilder editorial (String editorial) {
            this.editorial = editorial;
            return this;
        }

        public LibroBuilder cantidadCapitulos (int cantidadCapitulos) {
            this.cantidadCapitulos = cantidadCapitulos;
            return this;
        }

        public LibroBuilder cantidadEjemplares (int cantidadEjemplares) {
            this.cantidadEjemplares = cantidadEjemplares;
            return this;
        }

        public Libro build() {
            return new Libro(this);
        }
    }
}
