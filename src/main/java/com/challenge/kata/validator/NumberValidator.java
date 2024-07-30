package com.challenge.kata.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NumberValidator  implements ConstraintValidator<NumberConstraint, String> {

    @Override
    public boolean isValid(String numberStr, ConstraintValidatorContext context) {

        if (numberStr == null || !numberStr.matches("\\d+")) {
            return false;
        }
        int number = Integer.parseInt(numberStr);
        return number >= 1 && number <= 3999;
    }
}
