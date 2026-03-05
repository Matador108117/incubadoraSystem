package validation;

import models.SensorData;

public class TemperatureValidator implements Validator<SensorData> {

    @Override
    public void validate(SensorData data) throws ValidationException {

        int temp = data.getTemperatura();

        if (temp < 0 || temp > 60) {
            throw new ValidationException("Temperatura fuera de rango: " + temp);
        }

    }

}