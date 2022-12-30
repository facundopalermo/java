package builder;
/* "CONCRETE BUILDER" */
class EspecialistaEnPintura extends Contratista {

	@Override
	public void hacerCimientos() {
		this.casa.setCimientos("CIMIENTOS 2");
	}

	@Override
	public void hacerColumnas() {
		this.casa.setColumnas("COLUMNAS 2");
	}

	@Override
	public void hacerParedes() {
		this.casa.setParedes("PAREDES 2");
	}

	@Override
	public void hacerTechos() {
		this.casa.setTechos("TECHOS 2");
	}

	@Override
	public void hacerTerminaciones() {
		this.casa.setTerminaciones("PINTADA");
	}

	public Casa obtenerCasaTerminada() {
		return casa;
	}

}
