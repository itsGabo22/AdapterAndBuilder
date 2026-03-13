package smarthome;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

// Rol: Client de los patrones Bridge y Adapter desde la GUI.
// Trabaja con ControlRemoto (Abstraction) e IDispositivo (Implementor/adaptado).
public class SmartHomeController {

    @FXML
    private ComboBox<String> comboDispositivo;

    @FXML
    private Button btnEncender;

    @FXML
    private Button btnApagar;

    @FXML
    private Button btnSubir;

    @FXML
    private Button btnBajar;

    @FXML
    private TextArea txtLog;

    private ControlRemoto controlRemotoActual;

    @FXML
    public void initialize() {
        comboDispositivo.getItems().addAll(
                "Luz Inteligente",
                "Smart TV",
                "Aire Acondicionado Moderno",
                "Aire Acondicionado Legado (Adapter)"
        );
        comboDispositivo.getSelectionModel().selectFirst();
        crearControlRemotoParaSeleccion();
        log("Sistema iniciado. Dispositivo actual: " + controlRemotoActual.getNombreDispositivo());
    }

    @FXML
    private void onSeleccionarDispositivo() {
        crearControlRemotoParaSeleccion();
        log("Dispositivo cambiado a: " + controlRemotoActual.getNombreDispositivo());
    }

    @FXML
    private void onEncender() {
        if (controlRemotoActual == null) return;
        String r = controlRemotoActual.encender();
        log(r);
    }

    @FXML
    private void onApagar() {
        if (controlRemotoActual == null) return;
        String r = controlRemotoActual.apagar();
        log(r);
    }

    @FXML
    private void onSubirNivel() {
        if (controlRemotoActual == null) return;
        String r = controlRemotoActual.subirNivel();
        log(r);
    }

    @FXML
    private void onBajarNivel() {
        if (controlRemotoActual == null) return;
        String r = controlRemotoActual.bajarNivel();
        log(r);
    }

    // Crea el ControlRemoto (Abstraction) inyectando la implementación adecuada (IDispositivo).
    private void crearControlRemotoParaSeleccion() {
        String seleccion = comboDispositivo.getSelectionModel().getSelectedItem();
        IDispositivo dispositivo;

        if ("Luz Inteligente".equals(seleccion)) {
            dispositivo = new LuzInteligente();
        } else if ("Smart TV".equals(seleccion)) {
            dispositivo = new SmartTV();
        } else if ("Aire Acondicionado Moderno".equals(seleccion)) {
            dispositivo = new ModernAirConditioner();
        } else if ("Aire Acondicionado Legado (Adapter)".equals(seleccion)) {
            LegacyAirConditioner legacy = new LegacyAirConditioner();
            dispositivo = new OldDeviceAdapter(legacy); // Aquí usamos el Adapter
        } else {
            dispositivo = null;
        }

        if (dispositivo != null) {
            // Inyección de dependencias: pasamos el dispositivo al control remoto
            controlRemotoActual = new ControlRemotoBasico(dispositivo);
        }
    }

    private void log(String mensaje) {
        txtLog.appendText(mensaje + "\n");
    }
}

