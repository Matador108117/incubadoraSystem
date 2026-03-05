package validation;

import java.util.List;
import models.SensorData;

public class ValidationChain {

    private final List<Validator<SensorData>> validators;

    public ValidationChain(List<Validator<SensorData>> validators) {
        this.validators = validators;
    }

    public void validate(SensorData data) throws ValidationException {

        for (Validator<SensorData> validator : validators) {
            validator.validate(data);
        }

    }

}