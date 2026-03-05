package validation;

import models.SensorData;

public class OxygenValidator implements Validator<SensorData> {

    @Override
    public void validate(SensorData data) throws ValidationException {

        int oxigeno = data.getOxigeno();

        if (oxigeno < 0 || oxigeno > 100) {
            throw new ValidationException("Oxígeno fuera de rango: " + oxigeno);
        }

    }

}