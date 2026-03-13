package smarthome;

// Rol: ConcreteImplementor del patrón Bridge
// Otra implementación de dispositivo: una TV inteligente.
public class SmartTV implements IDispositivo {

    private boolean encendida;
    private int volumen; // 0 a 100

    public SmartTV() {
        this.encendida = false;
        this.volumen = 20;
    }

    @Override
    public String encender() {
        encendida = true;
        return "SmartTV encendida. Volumen actual: " + volumen;
    }

    @Override
    public String apagar() {
        encendida = false;
        return "SmartTV apagada.";
    }

    @Override
    public String subirNivel() {
        if (!encendida) {
            return "SmartTV está apagada. No se puede subir volumen.";
        }
        volumen = Math.min(100, volumen + 5);
        return "SmartTV sube volumen a " + volumen;
    }

    @Override
    public String bajarNivel() {
        if (!encendida) {
            return "SmartTV está apagada. No se puede bajar volumen.";
        }
        volumen = Math.max(0, volumen - 5);
        return "SmartTV baja volumen a " + volumen;
    }

    @Override
    public String getNombre() {
        return "Smart TV";
    }
}

