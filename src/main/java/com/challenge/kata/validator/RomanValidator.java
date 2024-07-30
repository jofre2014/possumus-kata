package com.challenge.kata.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
@ConfigurationProperties(prefix = "custom.roman-validator")
public class RomanValidator implements ConstraintValidator<RomanConstraint, String> {

    private String regex;
    private Pattern pattern;

    @Override
    public void initialize(RomanConstraint constraintAnnotation) {
        pattern = Pattern.compile(regex);
    }

    @Override
    public boolean isValid(String roman, ConstraintValidatorContext constraintValidatorContext) {
        return roman != null && pattern.matcher(roman).matches();
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }
}
