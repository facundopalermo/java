package builder;
/* PRODUCTO */
class Casa {

	/*
	 * Las partes del producto aca no son "complejas". Pero si cada una necesitara de procesos adicionales
	 * en los setters de cada una estarían las llamadas a esos procesos (ejemplos: llamadas a bases de datos,
	 * obtencion de valores mediante calculos, etc. - ver comentarios).
	 * */
	private String cimientos = "";
	private String columnas = "";
	private String paredes = "";
	private String techos = "";
	private String terminaciones = "";
	
    public void setCimientos(String cimientos) {
    	/*
    	 * reemplazar por la operación compleja que haga falta para generar y setear este valor,
    	 * de ser necesario.
    	 */
    	this.cimientos = cimientos;
    }
	
    public void setColumnas(String columnas) {
    	this.columnas = columnas;
    }
	
    public void setParedes(String paredes) {
    	this.paredes = paredes;
    }
	
    public void setTechos(String techos) {
    	this.techos = techos;
    }

    public void setTerminaciones(String terminaciones) {
    	this.terminaciones = terminaciones;
    }

    @Override
    public String toString() {
	    return "Casa [cimientos=" + cimientos + ", columnas=" + columnas + ", paredes=" + paredes + ", techos=" + techos + ", terminaciones=" + terminaciones + "]";
    }

    

}
