package smarthome.Adapter;

import smarthome.Aire_Acondicionado.LegacyAirConditioner;
import smarthome.ID.IDispositivo;

// Rol: Adapter (Patrón Adapter)
// Implementa IDispositivo (del Bridge) pero delega en un LegacyAirConditioner,
// traduciendo los métodos modernos a los métodos legados.
public class OldDeviceAdapter implements IDispositivo {

    private final LegacyAirConditioner legacy;

    public OldDeviceAdapter(LegacyAirConditioner legacy) {
        this.legacy = legacy;
    }

    @Override
    public String encender() {
        String infoAdapter = "[Adapter] Traduciendo comando 'encender' a 'executePowerOn' para dispositivo antiguo.\n";
        return infoAdapter + legacy.executePowerOn();
    }

    @Override
    public String apagar() {
        String infoAdapter = "[Adapter] Traduciendo comando 'apagar' a 'executePowerOff' para dispositivo antiguo.\n";
        return infoAdapter + legacy.executePowerOff();
    }

    @Override
    public String subirNivel() {
        String infoAdapter = "[Adapter] Traduciendo comando 'subirNivel' a 'increaseTemperature' para dispositivo antiguo.\n";
        return infoAdapter + legacy.increaseTemperature();
    }

    @Override
    public String bajarNivel() {
        String infoAdapter = "[Adapter] Traduciendo comando 'bajarNivel' a 'decreaseTemperature' para dispositivo antiguo.\n";
        return infoAdapter + legacy.decreaseTemperature();
    }

    @Override
    public String getNombre() {
        return legacy.getLegacyName() + " (Adaptado)";
    }
}
