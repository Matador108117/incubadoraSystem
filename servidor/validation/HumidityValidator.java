package validation;

import models.SensorData;

public class HumidityValidator implements Validator<SensorData> {

    @Override
    public void validate(SensorData data) throws ValidationException {

        int humedad = data.getHumedad();

        if (humedad < 0 || humedad > 100) {
            throw new ValidationException("Humedad fuera de rango: " + humedad);
        }

    }

}