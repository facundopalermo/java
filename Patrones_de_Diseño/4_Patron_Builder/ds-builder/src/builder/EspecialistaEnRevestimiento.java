package builder;
/* "CONCRETE BUILDER" */
class EspecialistaEnRevestimiento extends Contratista {

	@Override
	public void hacerCimientos() {
		this.casa.setCimientos("CIMIENTOS 1");
	}

	@Override
	public void hacerColumnas() {
		this.casa.setColumnas("COLUMNAS 1");
	}

	@Override
	public void hacerParedes() {
		this.casa.setParedes("PAREDES 1");
	}

	
	@Override
	public void hacerTechos() {
		this.casa.setTechos("TECHOS 1");
	}
	
	@Override
	public void hacerTerminaciones() {
		this.casa.setTerminaciones("REVESTIDA CON LADRILLO");
		
	}

	public Casa obtenerCasaTerminada() {
		return casa;
	}
	
}
