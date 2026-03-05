package models;
import java.io.Serializable;

public class IncubadoraEstado implements Serializable {

    private String estadoTemperatura;
    private String estadoHumedad;
    private String estadoOxigeno;
    private String resultadoGeneral;

    public IncubadoraEstado(String estadoTemperatura, String estadoHumedad, String estadoOxigeno, String resultadoGeneral) {
        this.estadoTemperatura = estadoTemperatura;
        this.estadoHumedad = estadoHumedad;
        this.estadoOxigeno = estadoOxigeno;
        this.resultadoGeneral = resultadoGeneral;
    }

    @Override
    public String toString() {
        return "Temp: " + estadoTemperatura +
                " | Humedad: " + estadoHumedad +
                " | Oxigeno: " + estadoOxigeno +
                " | Resultado: " + resultadoGeneral;
    }
}