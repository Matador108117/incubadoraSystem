package validation;

import models.SensorData;

public class TypeValidator implements Validator<Object> {

    @Override
    public void validate(Object data) throws ValidationException {

        if (!(data instanceof SensorData)) {
            throw new ValidationException("Objeto recibido no es SensorData");
        }

    }
}
