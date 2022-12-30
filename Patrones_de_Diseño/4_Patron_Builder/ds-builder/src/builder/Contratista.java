package builder;
/* "ABSTRACT BUILDER" */
abstract class Contratista {

	protected Casa casa;

	public void iniciarConstruccionDeCasaNueva() {
		casa = new Casa();
	}

	public abstract void hacerCimientos();
	public abstract void hacerColumnas();
	public abstract void hacerParedes();
	public abstract void hacerTechos();
	public abstract void hacerTerminaciones();

}
