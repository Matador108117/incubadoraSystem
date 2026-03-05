package services;
import java.util.Random;
import models.SensorData;
public class SensorFactory {

    private static final Random random = new Random();

    public static SensorData generarLectura() {
        int temperatura = 34 + random.nextInt(7); // 34 a 40
        int humedad = 45 + random.nextInt(35);    // 45 a 79
        int oxigeno = 0 + random.nextInt(30);    // 80 a 99
        return new SensorData(temperatura, humedad, oxigeno);
    }
}
