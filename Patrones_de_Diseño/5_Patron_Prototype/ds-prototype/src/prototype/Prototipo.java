package prototype;
public interface Prototipo {
	//uso "clonar" y no "clone()" para que no se preste a confusión con el clone() de Java.
    public Prototipo clonar();
}