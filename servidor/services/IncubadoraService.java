
package services;
import models.IncubadoraEstado;
import models.SensorData;
public class IncubadoraService {

    public static IncubadoraEstado evaluar(SensorData data) {

        String estadoTemp;
        String estadoHum;
        String estadoOxi;

        // Evaluar temperatura
        if (data.getTemperatura() < 36) {
            estadoTemp = "BAJA";
        } else if (data.getTemperatura() <= 38) {
            estadoTemp = "NORMAL";
        } else {
            estadoTemp = "ALTA";
        }

        // Evaluar humedad
        if (data.getHumedad() < 50) {
            estadoHum = "BAJA";
        } else if (data.getHumedad() <= 70) {
            estadoHum = "NORMAL";
        } else {
            estadoHum = "ALTA";
        }
        if (data.getOxigeno() < 19) {
            estadoOxi = "BAJO";
        } else if (data.getOxigeno() <= 23) {
            estadoOxi = "NORMAL";
        } else {
            estadoOxi = "ALTO";
        }

        String resultado = (estadoTemp.equals("NORMAL") && estadoHum.equals("NORMAL"))
                ? "ESTABLE"
                : "ALERTA";

        return new IncubadoraEstado(estadoTemp, estadoHum,estadoOxi, resultado);
    }
}