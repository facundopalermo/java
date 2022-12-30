package prototype;


//UNA DE LAS CLASES "COSTOSAS" 
public class Configuracion implements Prototipo {
	//es solo simulado, no voy a leer nada....
    private String valoresConfig;

    public void obtenerValoresDesdeArchivo() {
    	//SIMULO que esta operacion de leer el archivo y levantar los valores tarda 5 segundos
        try {
	        Thread.sleep(5000);
        } catch (InterruptedException e) {
        }   
        valoresConfig = "Aca irian valores de configuracion";
    }

    //METODO DE CLONACION
    @Override
    public Prototipo clonar() {
    	Configuracion c = new Configuracion();//creo el nuevo objeto
        c.setValoresConfig(this.valoresConfig);//le copio los valores
        return c;
    }
	
    
    //SETTER Y GETTER DE VALORES DE CONFIG
    public String getValoresConfig() {
    	return this.valoresConfig;
    }
    public void setValoresConfig(String valoresConfig) {
    	this.valoresConfig = valoresConfig;
    }

    //toString IMPRTANTE para correr el programa y ver los valores de la prueba
    @Override
    public String toString() {
	    return super.toString()+ " - Configuracion [valoresConfig=" + valoresConfig + "]";
    }
    
}
