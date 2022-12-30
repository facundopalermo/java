package builder;
class Persona {

	public static void main(String[] args) {
		Persona c = new Persona();
		c.encargarCasa();
	}

	public void encargarCasa() {

		Arquitecto arquitecto = new Arquitecto();
		//EspecialistaEnRevestimiento especialistaEnRevestimiento = new EspecialistaEnRevestimiento();
		EspecialistaEnPintura especialistaEnPintura = new EspecialistaEnPintura();

		/*LOS CONTRATISTAS SON INTERCAMBAIBLES, el arquitecto hoy trabaja con el que reviste de ladrillos, mañana con el que pinta*/
		//arquitecto.setContratista(especialistaEnRevestimiento);
		arquitecto.setContratista(especialistaEnPintura);
		arquitecto.dirigirContruccionDeCasa();
		/*Y DEPENDE QUE CONTRATISTA USE TENDRE UNA CASA CON UNA U OTRA CARACTERISTICA!!*/
		Casa casa = especialistaEnPintura.obtenerCasaTerminada();
		System.out.println("El contratista entrega casa al arquitecto:");
		System.out.println(casa);
		System.out.println("El arquitecto entrega las llaves al nuevo dueño");
	}
}
