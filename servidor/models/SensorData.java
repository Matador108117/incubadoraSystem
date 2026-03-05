package models;
import java.io.Serializable;

public class SensorData implements Serializable {
    private int temperatura;
    private int humedad;
    private int oxigeno;

    public SensorData(int temperatura, int humedad, int oxigeno) {
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.oxigeno = oxigeno;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public int getHumedad() {
        return humedad;
    }
    public int getOxigeno() {
        return oxigeno;
    }
    @Override
    public String toString() {
        return "Temperatura=" + temperatura + ", Humedad=" + humedad + ", Oxigeno=" + oxigeno;
    }
}