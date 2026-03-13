package smarthome;

// Rol: Clase legada/incompatible.
// Imagina que viene de una librería externa que no podemos cambiar.
public class LegacyAirConditioner {

    private boolean powerOn;
    private int temp; // 60 a 80 (Fahrenheit por ejemplo)

    public LegacyAirConditioner() {
        this.powerOn = false;
        this.temp = 72;
    }

    public String executePowerOn() {
        powerOn = true;
        return "LegacyAirConditioner -> executePowerOn(): encendido. Temp: " + temp + "F";
    }

    public String executePowerOff() {
        powerOn = false;
        return "LegacyAirConditioner -> executePowerOff(): apagado.";
    }

    public String increaseTemperature() {
        if (!powerOn) {
            return "LegacyAirConditioner está apagado. No se puede aumentar temperatura.";
        }
        temp = Math.min(80, temp + 1);
        return "LegacyAirConditioner -> increaseTemperature(): " + temp + "F";
    }

    public String decreaseTemperature() {
        if (!powerOn) {
            return "LegacyAirConditioner está apagado. No se puede disminuir temperatura.";
        }
        temp = Math.max(60, temp - 1);
        return "LegacyAirConditioner -> decreaseTemperature(): " + temp + "F";
    }

    public String getLegacyName() {
        return "Legacy Air Conditioner";
    }
}

