package com.challenge.kata.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RomanValidator.class)
public @interface RomanConstraint {

    String message() default "Roman numeral invalid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
