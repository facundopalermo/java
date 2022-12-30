package prototype;

public class Usuario {
    private String nombre;
    private String username;
    private PerfilDeUsuario perfilDeUsuario;
    private Configuracion configuracionDeUsuario;


    public Usuario(String nombre, String username, PerfilDeUsuario perfilDeUsuario, Configuracion configuracionDeUsuario) {
        this.nombre = nombre;
        this.username = username;
        this.perfilDeUsuario = perfilDeUsuario;
        this.configuracionDeUsuario = configuracionDeUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public PerfilDeUsuario getPerfilDeUsuario() {
        return perfilDeUsuario;
    }

    public void setPerfilDeUsuario(PerfilDeUsuario perfilDeUsuario) {
        this.perfilDeUsuario = perfilDeUsuario;
    }

    public Configuracion getConfiguracionDeUsuario() {
        return configuracionDeUsuario;
    }

    public void setConfiguracionDeUsuario(Configuracion configuracionDeUsuario) {
        this.configuracionDeUsuario = configuracionDeUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", username='" + username + '\'' +
                ", perfilDeUsuario=" + perfilDeUsuario +
                ", configuracionDeUsuario=" + configuracionDeUsuario +
                '}';
    }

    public static class UsuarioBuilder {
        private String nombre;
        private String username;
        private PerfilDeUsuario perfilDeUsuario;
        private Configuracion configuracionDeUsuario;

        public UsuarioBuilder conNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public UsuarioBuilder conUsername(String username) {
            this.username = username;
            return this;
        }

        public UsuarioBuilder conPerfilDeUsuario(PerfilDeUsuario perfilDeUsuario) {
            this.perfilDeUsuario = perfilDeUsuario;
            return this;
        }

        public UsuarioBuilder conConfiguracionDeUsuario(Configuracion configuracionDeUsuario) {
            this.configuracionDeUsuario = configuracionDeUsuario;
            return this;
        }

        public Usuario build() {
            return new Usuario(nombre, username, perfilDeUsuario, configuracionDeUsuario);
        }
    }
}
