package smarthome.ID;

// Rol: Implementor del patrón Bridge
// Define las operaciones que cualquier dispositivo controlable debe ofrecer.
public interface IDispositivo {

    String encender();

    String apagar();

    String subirNivel(); // Intensidad / volumen / temperatura

    String bajarNivel();

    String getNombre();
}
