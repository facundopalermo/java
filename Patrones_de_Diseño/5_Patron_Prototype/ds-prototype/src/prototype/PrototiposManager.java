package prototype;

import java.util.HashMap;
import java.util.Map;

public class PrototiposManager {
    private Map<String, Prototipo> prototipos = new HashMap<String,Prototipo>();
    
    public void registrarPrototipo(String key, Prototipo valor) {
        prototipos.put(key, valor);  
    }

    public Prototipo obtenerPrototipo(String key) {
        return prototipos.get(key).clonar();
    }
}