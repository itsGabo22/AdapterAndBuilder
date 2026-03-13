package smarthome;

// Rol: ConcreteImplementor del patrón Bridge
// Aire acondicionado moderno que ya cumple con la interfaz IDispositivo.
public class ModernAirConditioner implements IDispositivo {

    private boolean encendido;
    private int temperatura; // 16 a 30

    public ModernAirConditioner() {
        this.encendido = false;
        this.temperatura = 24;
    }

    @Override
    public String encender() {
        encendido = true;
        return "Aire Acondicionado Moderno encendido. Temp: " + temperatura + "°C";
    }

    @Override
    public String apagar() {
        encendido = false;
        return "Aire Acondicionado Moderno apagado.";
    }

    @Override
    public String subirNivel() {
        if (!encendido) {
            return "Aire Moderno está apagado. No se puede subir temperatura.";
        }
        temperatura = Math.min(30, temperatura + 1);
        return "Aire Moderno sube temperatura a " + temperatura + "°C";
    }

    @Override
    public String bajarNivel() {
        if (!encendido) {
            return "Aire Moderno está apagado. No se puede bajar temperatura.";
        }
        temperatura = Math.max(16, temperatura - 1);
        return "Aire Moderno baja temperatura a " + temperatura + "°C";
    }

    @Override
    public String getNombre() {
        return "Aire Acondicionado Moderno";
    }
}

