package smarthome;

// Rol: Abstraction del patrón Bridge
// Representa un control remoto genérico que trabaja con un IDispositivo.
public abstract class ControlRemoto {

    protected IDispositivo dispositivo;

    public ControlRemoto(IDispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    public abstract String encender();

    public abstract String apagar();

    public abstract String subirNivel();

    public abstract String bajarNivel();

    public String getNombreDispositivo() {
        return dispositivo != null ? dispositivo.getNombre() : "Ningún dispositivo";
    }
}

