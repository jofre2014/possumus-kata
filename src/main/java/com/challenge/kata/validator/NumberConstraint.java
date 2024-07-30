package com.challenge.kata.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NumberValidator.class)
public @interface NumberConstraint {
    String message() default "Invalid number. The number must be between 1 and 3999.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
