package builder;
/* "DIRECTOR" */
class Arquitecto {
  private Contratista con;

    public Arquitecto() {
    }

    public Arquitecto(Contratista con) {
        this.con = con;
    }

    public void setContratista(Contratista con) {
	  this.con = con; 
  }

  public void dirigirContruccionDeCasa() {
	  con.iniciarConstruccionDeCasaNueva();
	  con.hacerCimientos();
	  con.hacerColumnas();
	  con.hacerParedes();
	  con.hacerTechos();
    con.hacerTerminaciones();
  }
}
