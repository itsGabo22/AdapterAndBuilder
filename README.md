# Taller Patrón Adapter y Bridge - Smart Home

Este es mi caso de estudio para el taller de **Patrón Adapter o Bridge** usando **Java + JavaFX**.  
Diseñé un sistema de **Smart Home** llamado **“Neon Home Control”** donde controlo distintos dispositivos desde un mismo control remoto.

## Diseño de patrones

- **Bridge**
  - **Abstraction**: `ControlRemoto`
  - **RefinedAbstraction**: `ControlRemotoBasico`
  - **Implementor**: `IDispositivo`
  - **ConcreteImplementor**: `LuzInteligente`, `SmartTV`, `ModernAirConditioner`, y también `OldDeviceAdapter` (porque implementa `IDispositivo`.
  - La idea es separar la jerarquía de controles remotos de la jerarquía de dispositivos, para poder combinarlos libremente.

- **Adapter**
  - **Adaptee (legado)**: `LegacyAirConditioner` (simula un aire viejo, con métodos como `executePowerOn()` que no cumplen la interfaz moderna).
  - **Adapter**: `OldDeviceAdapter` implementa `IDispositivo` y por dentro delega en `LegacyAirConditioner`.
  - El adaptador traduce llamadas como `encender()` → `executePowerOn()`.  
    En el log se ve explícitamente el mensaje:
    `[Adapter] Traduciendo comando 'encender' a 'executePowerOn' para dispositivo antiguo`.

## Cómo compilar y ejecutar

Requisitos:
- JDK instalado (versión 17+ recomendada).
- JavaFX descargado. En mi caso lo tengo en:  
  `C:\Users\Gabriel\Downloads\openjfx-25.0.2_windows-x64_bin-sdk\javafx-sdk-25.0.2\lib`

### 1. Compilar

Abrir **CMD** y ejecutar:

```cmd
cd /d C:\Users\Gabriel\Desktop\Tareas\PatronesSW\PatronAdapterYBuilder\src
set FX=C:\Users\Gabriel\Downloads\openjfx-25.0.2_windows-x64_bin-sdk\javafx-sdk-25.0.2\lib

javac --module-path "%FX%" --add-modules javafx.controls,javafx.fxml smarthome\*.java
```

Si no aparece ningún error, la compilación fue correcta.

### 2. Ejecutar

Desde la misma carpeta `src`:

```cmd
java --module-path "%FX%" --add-modules javafx.controls,javafx.fxml smarthome.SmartHomeApp
```

Se abrirá la ventana **“Neon Home Control - Bridge + Adapter”**.

## Cómo probar el Adapter y el Bridge

- En la parte superior elijo el **dispositivo**:
  - Luz Inteligente
  - Smart TV
  - Aire Acondicionado Moderno
  - Aire Acondicionado Legado (Adapter)
- Uso los botones:
  - **Encender / Apagar**
  - **Subir Nivel / Bajar Nivel**
- En el área de log se ve:
  - Para dispositivos modernos, los mensajes normales de cada implementación.
  - Para el dispositivo legado, mensajes como:  
    `[Adapter] Traduciendo comando 'encender' a 'executePowerOn' para dispositivo antiguo`  
    demostrando que estoy usando **Adapter** sobre una clase con interfaz incompatible, pero a través del mismo contrato del **Bridge** (`IDispositivo`).

