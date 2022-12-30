package prototype;

//LA OTRA CLASE "COSTOSA" 
public class PerfilDeUsuario implements Prototipo {
    
	//es solo simulado, no voy a leer nada....
	private String perfil;
    
    public void obtenerPerfilDesdeBaseDeDatos() {
    	//SIMULO que esta operacion de leer la base de datos y levantar el perfil del usuario
        try {
	        Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        this.perfil = "Aca va el perfil del usuario que lei desde bbdd";
    }

    @Override
    public Prototipo clonar() {
    	PerfilDeUsuario p = new PerfilDeUsuario();  //create new object
        p.perfil = this.perfil; //copy value
        return p;
    }

	
    //SETTER Y GETTER DE VALOR DEL ATRIBUTO PERFIL
    public String getPerfil() {
    	return this.perfil;
    }
    public void setPerfil(String perfil) {
    	this.perfil = perfil;
    }

    //toString IMPORTANTE para correr el programa y ver los valores de la prueba
    @Override
    public String toString() {
	    return "PerfilDeUsuario [perfil=" + perfil + "]";
    }
    
    
}