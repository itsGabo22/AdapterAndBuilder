package smarthome;

// Rol: ConcreteImplementor del patrón Bridge
// Implementación concreta de un dispositivo: una luz inteligente.
public class LuzInteligente implements IDispositivo {

    private boolean encendida;
    private int intensidad; // 0 a 100

    public LuzInteligente() {
        this.encendida = false;
        this.intensidad = 50;
    }

    @Override
    public String encender() {
        encendida = true;
        return "LuzInteligente encendida. Intensidad actual: " + intensidad + "%";
    }

    @Override
    public String apagar() {
        encendida = false;
        return "LuzInteligente apagada.";
    }

    @Override
    public String subirNivel() {
        if (!encendida) {
            return "LuzInteligente está apagada. No se puede subir intensidad.";
        }
        intensidad = Math.min(100, intensidad + 10);
        return "LuzInteligente sube intensidad a " + intensidad + "%";
    }

    @Override
    public String bajarNivel() {
        if (!encendida) {
            return "LuzInteligente está apagada. No se puede bajar intensidad.";
        }
        intensidad = Math.max(0, intensidad - 10);
        return "LuzInteligente baja intensidad a " + intensidad + "%";
    }

    @Override
    public String getNombre() {
        return "Luz Inteligente";
    }
}

