package prototype;

import java.util.Date;

class PruebaPrototype {

    public static void main(String[] args) {

        Date startCrearAdmin = new Date(); // registro cuando empieza la configuracion
        Configuracion configuracion = obtenerConfig();
        PerfilDeUsuario perfil = obtenerPerfil();
        // opcionalmente, tenemos un registro de prototipos - aca no es muy util porque estamos haciendo un ejemplo muy simple y con todas variables locales
        // pero el registro podría estar en otro lado, y ser un signleton posiblemente

		//PrototiposManager manager = new PrototiposManager();
		//manager.registrarPrototipo("CONFIGURACION", configuracion);
		//manager.registrarPrototipo("PERFIL", perfil);

        Usuario admin1 = new Usuario.UsuarioBuilder()
                                    .conNombre("El admin")
                                    .conUsername("root")
                                    .conConfiguracionDeUsuario(configuracion)
                                    .conPerfilDeUsuario(perfil).build();

        Date endCrearAdmin = new Date();// registro cuando termino la carga del perfil

        System.out.print("La creacion del primer usuario admin tardo:");
        Long tiempoTotalCrearAdmin = endCrearAdmin.getTime() - startCrearAdmin.getTime();
        System.out.println(tiempoTotalCrearAdmin + " milisegundos \r\n");
        System.out.println(admin1 + " milisegundos \r\n");


        Date startCrearOtroAdmin = new Date(); // registro cuando empieza la configuracion
        Usuario segundoAdmin = new Usuario.UsuarioBuilder()
                .conNombre("El admin 2")
                .conUsername("admin2")
                //no quiero la misma instancia que esta en el mapa, no me interesa esa referencia, quiero una COPIA (ver como el toString imprime diferentes instancias)
//				.conConfiguracionDeUsuario((Configuracion)manager.obtenerPrototipo("CONFIGURACION").clonar()) - OPC 1 usando registro de prototipos
                .conConfiguracionDeUsuario((Configuracion) configuracion.clonar())// - OPc 2 clonando directamente
                //no quiero la misma instancia que esta en el mapa, no me interesa esa referencia, quiero una COPIA
                .conPerfilDeUsuario((PerfilDeUsuario) perfil.clonar())
                .build();

        Date endCrearOtroAdmin = new Date();// registro cuando termino la carga del perfil
        System.out.print("La creacion del segundo usuario admin tardo:");
        Long tiempoTotalCrearOtroAdmin = endCrearOtroAdmin.getTime() - startCrearOtroAdmin.getTime();
        System.out.println(tiempoTotalCrearOtroAdmin + " milisegundos \r\n");
        System.out.println(segundoAdmin);

        Date startCrearTercerAdmin = new Date(); // registro cuando empieza la configuracion
        Usuario tercerAdmin = new Usuario.UsuarioBuilder()
                .conNombre("El admin 3")
                .conUsername("admin3")
                //no quiero la misma instancia que esta en el mapa, no me interesa esa referencia, quieor una COPIA
                .conConfiguracionDeUsuario((Configuracion) configuracion.clonar())
                //no quiero la misma instancia que esta en el mapa, no me interesa esa referencia, quieor una COPIA
                .conPerfilDeUsuario((PerfilDeUsuario) perfil.clonar())
                .build();
        Date endTercerOtroAdmin = new Date();// registro cuando termino la carga del perfil
        System.out.print("La creacion del tercer usuario admin tardo:");
        Long tiempoTotalTercerOtroAdmin = endTercerOtroAdmin.getTime() - startCrearTercerAdmin.getTime();
        System.out.println(tiempoTotalTercerOtroAdmin + " milisegundos \r\n");
        System.out.println(tercerAdmin);

    }

    private static PerfilDeUsuario obtenerPerfil() {
        PerfilDeUsuario perfil = new PerfilDeUsuario();

        perfil.obtenerPerfilDesdeBaseDeDatos(); // si es la primera vez, debería tardar mucho
        //muestro el perfil
        System.out.println("Perfil:" + perfil);
        return perfil;
    }

    private static Configuracion obtenerConfig() {

        Configuracion configuracion = new Configuracion();
        configuracion.obtenerValoresDesdeArchivo();// si es la primera vez, debería tardar mucho
        System.out.println("Config: " + configuracion);

        return configuracion;
    }
}
