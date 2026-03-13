package smarthome.Control_Remoto;

import smarthome.ID.IDispositivo;

// Rol: RefinedAbstraction del patrón Bridge
// Implementa un control remoto sencillo que delega en el IDispositivo.
public class ControlRemotoBasico extends ControlRemoto {

    public ControlRemotoBasico(IDispositivo dispositivo) {
        super(dispositivo);
    }

    @Override
    public String encender() {
        return "[ControlRemotoBasico] " + dispositivo.encender();
    }

    @Override
    public String apagar() {
        return "[ControlRemotoBasico] " + dispositivo.apagar();
    }

    @Override
    public String subirNivel() {
        return "[ControlRemotoBasico] " + dispositivo.subirNivel();
    }

    @Override
    public String bajarNivel() {
        return "[ControlRemotoBasico] " + dispositivo.bajarNivel();
    }
}
